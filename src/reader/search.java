package reader;

import data.Book;
import data.Manager;
import data.Reader;

import java.util.ArrayList;

public class search {
	// 根据学生编号展示列出所有已借图书
	public static void keeper(int stuID, ArrayList a1) {
		System.out.printf("\n%s\t\t%s\t\t%s\t\t%s\t\t%s", "图书编号", "书名", "借阅日期", "到期日期", "可续借次数");
		int counter = -1;
		for (int i = 0; i < a1.size(); i++) {
			if (((Book) a1.get(i)).getKeeper() == stuID) {
				System.out.printf("\n%s\t\t%s\t\t%s\t%s\t\t%s", ((Book) a1.get(i)).getBookID(),
						((Book) a1.get(i)).getBookName(), ((Book) a1.get(i)).SgetOutdate(),
						((Book) a1.get(i)).SgetDuedate(), ((Book) a1.get(i)).getRenewtimes());
				counter = i;
			}
		}
		if (counter == -1) {
			System.out.print("\n您还没有借书。\n");
		}

	}

	/*
	 * public static void keeping(reader.getID(index)){ System.out.printf(
	 * "\n%-10s  %-15s %-8s %-8s","图书编号","书名","借阅日期","到期日期"); for (Book
	 * element:Book.value()){ if(Book.getkeeper()==reader.getID())
	 * System.out.print("\n%-10s  %-15s %-8s %-8s)",Book.getID(),Book.getName(),
	 * Book.getBorrow(),Book.getDue()); } }
	 */
	// 根据图书编号确定图书状态
	public static String bookID2State(int bookID, ArrayList a1) {
		int counter = -1;
		String s1;
		for (int i = 0; i < a1.size(); i++) {
			if (((Book) a1.get(i)).getBookID() == bookID) {
				counter = i;
				break;
			}
		}
		if (counter == -1) {
			s1 = "您输入的的这本书不存在。";
		} else {
			s1 = ((Book) a1.get(counter)).getBookState();
		}
		return s1;
	}

	// 根据图书编号查找ArrayList的索引号
	public static int bookID2index(int bookID, ArrayList a1) {
		int counter = -1;// -1 意味着该图书不存在
		for (int i = 0; i < a1.size(); i++) {
			if (((Book) a1.get(i)).getBookID() == bookID) {
				counter = i;
				break;
			}
		}
		return counter;
	}

	// 根据关键字查找可借图书
	public static void query(CharSequence name, ArrayList a1) {
		System.out.printf("\n%s\t%s\t%s\t%s", "图书编号", "书名", "书架编号", "在馆数量");
		int counter = -1;
		for (int i = 0; i < a1.size(); i++) {
			if (((Book) a1.get(i)).getBookName().contains(name)) {
				System.out.printf("\n%s\t%s\t%s\t%s", ((Book) a1.get(i)).getBookID(),
						((Book) a1.get(i)).getBookName(), ((Book) a1.get(i)).getBookLoc(),
						((Book) a1.get(i)).getStock());
				counter = i;
			}
		}
		if (counter == -1) {
			System.out.print("\n无查询结果。");
		}
	}

	// 根据学号编号查找ArrayList的索引号
	public static int stuID2index(int stuID, ArrayList a1) {
		int counter = -1;// -1 意味着该学号不存在
		for (int i = 0; i < a1.size(); i++) {
			if (((Reader) a1.get(i)).getID() == stuID) {
				counter = i;
				break;
			}
		}
		return counter;
	}

	// 根据管理员名称查找Array的索引号
	public static int admin2index(String name, Manager[] m1) {
		int counter = -1;// -1 意味着该管理员名称不存在
		for (int i = 0; i < m1.length; i++) {
			if (m1[i].getUserName().equals(name)) {
				counter = i;
				break;
			}
		}
		return counter;
	}
}
