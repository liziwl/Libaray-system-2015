package Manager;

import java.util.ArrayList;
import data.Reader;
import data.Book;

public class show {
	// չʾ����ͼ��
	public static void showbooks(ArrayList a1) {
		System.out.printf("\n%s\t\t%s\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s", "ͼ����", "����", "�������", "��ܱ��", "����", "ͼ��״̬",
				"���������");
		int counter = -1;
		for (int i = 0; i < a1.size(); i++) {
			System.out.printf("\n%s\t\t%s\t\t%s\t\t%s%15s\t\t%s\t\t%s", ((Book) a1.get(i)).getBookID(),
					((Book) a1.get(i)).getBookName(), ((Book) a1.get(i)).SgetBookIndate(),
					((Book) a1.get(i)).getBookLoc(), ((Book) a1.get(i)).getKeeper(), ((Book) a1.get(i)).getBookState(),
					((Book) a1.get(i)).getRenewtimes());
			counter = i;
		}

		if (counter == -1) {
			System.out.print("\nͼ���б�Ŀǰû��ͼ�顣");
		}

	}
	// չʾ���ж���
	public static void showreaders(ArrayList a1) {
		System.out.printf("\n%s%25s\t\t%s\t\t%s", "ѧ��", "����", "�Ա�", "�ѽ�ͼ����");
		int counter = -1;
		for (int i = 0; i < a1.size(); i++) {
			System.out.printf("\n%d%15s\t\t%s\t\t%s", ((Reader) a1.get(i)).getID(), ((Reader) a1.get(i)).getName(),
					((Reader) a1.get(i)).getGender(), ((Reader) a1.get(i)).getKeepingbooks());
			counter = i;
		}
		if (counter == -1) {
			System.out.print("\n�����б�Ŀǰû�ж��ߡ�");
		}
	}
}
