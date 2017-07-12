package Manager;

import java.util.ArrayList;
import data.Reader;
import data.Book;

public class show {
	// 展示所有图书
	public static void showbooks(ArrayList a1) {
		System.out.printf("\n%s\t\t%s\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s", "图书编号", "书名", "入馆日期", "书架编号", "读者", "图书状态",
				"可续借次数");
		int counter = -1;
		for (int i = 0; i < a1.size(); i++) {
			System.out.printf("\n%s\t\t%s\t\t%s\t\t%s%15s\t\t%s\t\t%s", ((Book) a1.get(i)).getBookID(),
					((Book) a1.get(i)).getBookName(), ((Book) a1.get(i)).SgetBookIndate(),
					((Book) a1.get(i)).getBookLoc(), ((Book) a1.get(i)).getKeeper(), ((Book) a1.get(i)).getBookState(),
					((Book) a1.get(i)).getRenewtimes());
			counter = i;
		}

		if (counter == -1) {
			System.out.print("\n图书列表目前没有图书。");
		}

	}
	// 展示所有读者
	public static void showreaders(ArrayList a1) {
		System.out.printf("\n%s%25s\t\t%s\t\t%s", "学号", "姓名", "性别", "已借图书数");
		int counter = -1;
		for (int i = 0; i < a1.size(); i++) {
			System.out.printf("\n%d%15s\t\t%s\t\t%s", ((Reader) a1.get(i)).getID(), ((Reader) a1.get(i)).getName(),
					((Reader) a1.get(i)).getGender(), ((Reader) a1.get(i)).getKeepingbooks());
			counter = i;
		}
		if (counter == -1) {
			System.out.print("\n读者列表目前没有读者。");
		}
	}
}
