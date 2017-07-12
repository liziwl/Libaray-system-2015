package reader;

import data.Book;
import data.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class BR {
	// ���鷽��
	public static void borrow(int stuID, int bookID, ArrayList books, ArrayList readers) {
		if (stuOverdue(bookID, books) == true) {
			int tempKeep = ((Reader) readers.get(search.stuID2index(stuID, readers))).getKeepingbooks();
			if (tempKeep < 2) {

				if (search.bookID2State(bookID, books).equals("�ڹ�")) {
					((Book) books.get(search.bookID2index(bookID, books))).setBookState("���");
					((Book) books.get(search.bookID2index(bookID, books))).setKeeper(stuID);
					((Book) books.get(search.bookID2index(bookID, books))).setOutdate();
					((Book) books.get(search.bookID2index(bookID, books))).setDuedate();
					((Book) books.get(search.bookID2index(bookID, books))).setRenewtimes(1);
					((Reader) readers.get(search.stuID2index(stuID, readers))).setKeepingbooks(tempKeep + 1);
					System.out.printf("��%s��������ɡ��������ڣ�%s����������1��.\n",
							((Book) books.get(search.bookID2index(bookID, books))).getBookName(),
							((Book) books.get(search.bookID2index(bookID, books))).SgetDuedate());
				} else {
					if (search.bookID2State(bookID, books).equals("���")) {
						System.out.printf("��%s���ѱ������\n",
								((Book) books.get(search.bookID2index(bookID, books))).getBookName());
					} else {
						System.out.print(search.bookID2State(bookID, books) + "\n");
						// "������ĵ��Ȿ�鲻���ڡ�"
					}
				}
			} else
				System.out.printf("ѧ�ţ�%s�����Ѿ�����2���������ٽ��顣\n",
						((Reader) readers.get(search.stuID2index(stuID, readers))).getID());

		} else
			System.out.print("\n��������δ��ͼ�飬���ڲ��ɽ��顣");
	}

	// ���鷽��
	public static void back(int stuID, int bookID, ArrayList books, ArrayList readers) {
		if (search.bookID2State(bookID, books).equals("�ڹ�")) {
			System.out.printf("��%s����Ϊ�ڹ�״̬��\n", ((Book) books.get(search.bookID2index(bookID, books))).getBookName());
		} else {
			if (search.bookID2State(bookID, books).equals("���")) {
				Date tempTime = new Date();
				if (dueCheck(bookID, books, tempTime) == true) {
					((Book) books.get(search.bookID2index(bookID, books))).setBookState("�ڹ�");
					((Book) books.get(search.bookID2index(bookID, books))).setKeeper(0);
					int tempKeep = ((Reader) readers.get(search.stuID2index(stuID, readers))).getKeepingbooks();
					((Reader) readers.get(search.stuID2index(stuID, readers))).setKeepingbooks(tempKeep - 1);

					SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
					System.out.printf("��%s��������ɡ��黹���ڣ�%s��\n",
							((Book) books.get(search.bookID2index(bookID, books))).getBookName(), d1.format(tempTime));
				} else
					System.out.printf("��%s���Ѿ����ڣ�����ɷ���󷽿ɻ��顣\n",
							((Book) books.get(search.bookID2index(bookID, books))).getBookName());
			} else {
				System.out.print(search.bookID2State(bookID, books) + "\n");
				// "������ĵ��Ȿ�鲻���ڡ�"
			}
		}
	}

	// ����ͼ���ż���Ƿ�����
	public static boolean dueCheck(int bookID, ArrayList a1, Date checkTime) {
		boolean flag = ((Book) a1.get(search.bookID2index(bookID, a1))).getDuedate().after(checkTime);
		// true ��û������
		return flag;
	}

	/**
	 * ������������֮���������� һ�췣��һԪ
	 * 
	 * @param smdate
	 *            ��С��ʱ��
	 * @param bdate
	 *            �ϴ��ʱ��
	 * @return �������
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

	// ������ĳ����˼���Ƿ�����
	public static boolean stuOverdue(int stuID, ArrayList a1) {
		Date tempTime = new Date();
		boolean check = true;// true��û������
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
		// true �Ǹ�ѧ��û�����ڣ�false �����ڡ�
	}

	// ����ͼ�鷽��
	public static void renew(int bookID, ArrayList a1) {
		String state = search.bookID2State(bookID, a1);
		if (state.equals("������ĵ��Ȿ�鲻���ڡ�")) {
			System.out.print("\n������ĵ��Ȿ�鲻���ڡ�");
		} else {
			if (state.equals("�ڹ�")) {
				System.out.printf("\n��%s��δ�����", ((Book) a1.get(search.bookID2index(bookID, a1))).getBookName());
			} else {
				Date tempTime = new Date();
				if (dueCheck(bookID, a1, tempTime) == true) {
					if (((Book) a1.get(search.bookID2index(bookID, a1))).getRenewtimes() == 1) {
						((Book) a1.get(search.bookID2index(bookID, a1))).setRenewtimes(0);
						((Book) a1.get(search.bookID2index(bookID, a1))).duedateRenew();
						System.out.printf("��%s���������,�������ڣ�%s\n",
								((Book) a1.get(search.bookID2index(bookID, a1))).getBookName(),
								((Book) a1.get(search.bookID2index(bookID, a1))).SgetDuedate());
					} else {
						System.out.printf("��%s��������������ꡣ\n",
								((Book) a1.get(search.bookID2index(bookID, a1))).getBookName());
					}
				} else
					System.out.printf("��%s���Ѿ����ڣ��������衣\n",
							((Book) a1.get(search.bookID2index(bookID, a1))).getBookName());
			}
		}
	}

	// ��ȡ����������ڣ�
	public static int fine(int stuID, ArrayList a1) throws ParseException {
		int total = 0;
		if (stuOverdue(stuID, a1) == true) {
			total = 0;
		} else {
			int fine = 0;
			Date tempTime = new Date();
			for (int i = 0; i < a1.size(); i++) {
				if (((Book) a1.get(i)).getKeeper() == stuID && ((Book) a1.get(i)).getBookState().equals("���")
						&& ((Book) a1.get(i)).getDuedate().before(tempTime))
					fine += daysBetween(((Book) a1.get(i)).getDuedate(), tempTime);
			}
			total = fine;
		}
		return total;
	}
}
