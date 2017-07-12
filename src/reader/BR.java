package reader;

import data.Book;
import data.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BR {
	// 借书方法
	public static void borrow(int stuID, int bookID, ArrayList books, ArrayList readers) {
		if (stuOverdue(bookID, books) == true) {
			int tempKeep = ((Reader) readers.get(search.stuID2index(stuID, readers))).getKeepingbooks();
			if (tempKeep < 2) {

				if (search.bookID2State(bookID, books).equals("在馆")) {
					((Book) books.get(search.bookID2index(bookID, books))).setBookState("借出");
					((Book) books.get(search.bookID2index(bookID, books))).setKeeper(stuID);
					((Book) books.get(search.bookID2index(bookID, books))).setOutdate();
					((Book) books.get(search.bookID2index(bookID, books))).setDuedate();
					((Book) books.get(search.bookID2index(bookID, books))).setRenewtimes(1);
					((Reader) readers.get(search.stuID2index(stuID, readers))).setKeepingbooks(tempKeep + 1);
					System.out.printf("《%s》借书完成。还书日期：%s，还可续借1次.\n",
							((Book) books.get(search.bookID2index(bookID, books))).getBookName(),
							((Book) books.get(search.bookID2index(bookID, books))).SgetDuedate());
				} else {
					if (search.bookID2State(bookID, books).equals("借出")) {
						System.out.printf("《%s》已被借出。\n",
								((Book) books.get(search.bookID2index(bookID, books))).getBookName());
					} else {
						System.out.print(search.bookID2State(bookID, books) + "\n");
						// "您输入的的这本书不存在。"
					}
				}
			} else
				System.out.printf("学号：%s，您已经借满2本，不可再借书。\n",
						((Reader) readers.get(search.stuID2index(stuID, readers))).getID());

		} else
			System.out.print("\n您有逾期未还图书，现在不可借书。");
	}

	// 还书方法
	public static void back(int stuID, int bookID, ArrayList books, ArrayList readers) {
		if (search.bookID2State(bookID, books).equals("在馆")) {
			System.out.printf("《%s》已为在馆状态。\n", ((Book) books.get(search.bookID2index(bookID, books))).getBookName());
		} else {
			if (search.bookID2State(bookID, books).equals("借出")) {
				Date tempTime = new Date();
				if (dueCheck(bookID, books, tempTime) == true) {
					((Book) books.get(search.bookID2index(bookID, books))).setBookState("在馆");
					((Book) books.get(search.bookID2index(bookID, books))).setKeeper(0);
					int tempKeep = ((Reader) readers.get(search.stuID2index(stuID, readers))).getKeepingbooks();
					((Reader) readers.get(search.stuID2index(stuID, readers))).setKeepingbooks(tempKeep - 1);

					SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
					System.out.printf("《%s》还书完成。归还日期：%s。\n",
							((Book) books.get(search.bookID2index(bookID, books))).getBookName(), d1.format(tempTime));
				} else
					System.out.printf("《%s》已经逾期，请缴纳罚金后方可还书。\n",
							((Book) books.get(search.bookID2index(bookID, books))).getBookName());
			} else {
				System.out.print(search.bookID2State(bookID, books) + "\n");
				// "您输入的的这本书不存在。"
			}
		}
	}

	// 根据图书编号检查是否逾期
	public static boolean dueCheck(int bookID, ArrayList a1, Date checkTime) {
		boolean flag = ((Book) a1.get(search.bookID2index(bookID, a1))).getDuedate().after(checkTime);
		// true 是没有逾期
		return flag;
	}

	/**
	 * 计算两个日期之间相差的天数 一天罚款一元
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	// 根据书的持有人检查是否逾期
	public static boolean stuOverdue(int stuID, ArrayList a1) {
		Date tempTime = new Date();
		boolean check = true;// true是没有逾期
		for (int i = 0; i < a1.size(); i++) {
			if (((Book) a1.get(i)).getKeeper() == stuID) {
				boolean flag = dueCheck(((Book) a1.get(i)).getBookID(), a1, tempTime);
				//
				if (flag == false) {
					check = false;
					break;
				}
			}
		}
		return check;
		// true 是该学生没有逾期，false 是逾期。
	}

	// 续借图书方法
	public static void renew(int bookID, ArrayList a1) {
		String state = search.bookID2State(bookID, a1);
		if (state.equals("您输入的的这本书不存在。")) {
			System.out.print("\n您输入的的这本书不存在。");
		} else {
			if (state.equals("在馆")) {
				System.out.printf("\n《%s》未借出。", ((Book) a1.get(search.bookID2index(bookID, a1))).getBookName());
			} else {
				Date tempTime = new Date();
				if (dueCheck(bookID, a1, tempTime) == true) {
					if (((Book) a1.get(search.bookID2index(bookID, a1))).getRenewtimes() == 1) {
						((Book) a1.get(search.bookID2index(bookID, a1))).setRenewtimes(0);
						((Book) a1.get(search.bookID2index(bookID, a1))).duedateRenew();
						System.out.printf("《%s》续借完成,还书日期：%s\n",
								((Book) a1.get(search.bookID2index(bookID, a1))).getBookName(),
								((Book) a1.get(search.bookID2index(bookID, a1))).SgetDuedate());
					} else {
						System.out.printf("《%s》续借次数已用完。\n",
								((Book) a1.get(search.bookID2index(bookID, a1))).getBookName());
					}
				} else
					System.out.printf("《%s》已经逾期，不可续借。\n",
							((Book) a1.get(search.bookID2index(bookID, a1))).getBookName());
			}
		}
	}

	// 获取罚款方法（逾期）
	public static int fine(int stuID, ArrayList a1) throws ParseException {
		int total = 0;
		if (stuOverdue(stuID, a1) == true) {
			total = 0;
		} else {
			int fine = 0;
			Date tempTime = new Date();
			for (int i = 0; i < a1.size(); i++) {
				if (((Book) a1.get(i)).getKeeper() == stuID && ((Book) a1.get(i)).getBookState().equals("借出")
						&& ((Book) a1.get(i)).getDuedate().before(tempTime))
					fine += daysBetween(((Book) a1.get(i)).getDuedate(), tempTime);
			}
			total = fine;
		}
		return total;
	}
}
