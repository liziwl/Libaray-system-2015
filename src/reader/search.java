package reader;

import data.Book;
import data.Manager;
import data.Reader;

import java.util.ArrayList;

public class search {
	// ����ѧ�����չʾ�г������ѽ�ͼ��
	public static void keeper(int stuID, ArrayList a1) {
		System.out.printf("\n%s\t\t%s\t\t%s\t\t%s\t\t%s", "ͼ����", "����", "��������", "��������", "���������");
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
			System.out.print("\n����û�н��顣\n");
		}

	}

	/*
	 * public static void keeping(reader.getID(index)){ System.out.printf(
	 * "\n%-10s  %-15s %-8s %-8s","ͼ����","����","��������","��������"); for (Book
	 * element:Book.value()){ if(Book.getkeeper()==reader.getID())
	 * System.out.print("\n%-10s  %-15s %-8s %-8s)",Book.getID(),Book.getName(),
	 * Book.getBorrow(),Book.getDue()); } }
	 */
	// ����ͼ����ȷ��ͼ��״̬
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
			s1 = "������ĵ��Ȿ�鲻���ڡ�";
		} else {
			s1 = ((Book) a1.get(counter)).getBookState();
		}
		return s1;
	}

	// ����ͼ���Ų���ArrayList��������
	public static int bookID2index(int bookID, ArrayList a1) {
		int counter = -1;// -1 ��ζ�Ÿ�ͼ�鲻����
		for (int i = 0; i < a1.size(); i++) {
			if (((Book) a1.get(i)).getBookID() == bookID) {
				counter = i;
				break;
			}
		}
		return counter;
	}

	// ���ݹؼ��ֲ��ҿɽ�ͼ��
	public static void query(CharSequence name, ArrayList a1) {
		System.out.printf("\n%s\t%s\t%s\t%s", "ͼ����", "����", "��ܱ��", "�ڹ�����");
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
			System.out.print("\n�޲�ѯ�����");
		}
	}

	// ����ѧ�ű�Ų���ArrayList��������
	public static int stuID2index(int stuID, ArrayList a1) {
		int counter = -1;// -1 ��ζ�Ÿ�ѧ�Ų�����
		for (int i = 0; i < a1.size(); i++) {
			if (((Reader) a1.get(i)).getID() == stuID) {
				counter = i;
				break;
			}
		}
		return counter;
	}

	// ���ݹ���Ա���Ʋ���Array��������
	public static int admin2index(String name, Manager[] m1) {
		int counter = -1;// -1 ��ζ�Ÿù���Ա���Ʋ�����
		for (int i = 0; i < m1.length; i++) {
			if (m1[i].getUserName().equals(name)) {
				counter = i;
				break;
			}
		}
		return counter;
	}
}
