package Manager;

import java.util.ArrayList;
import data.Book;
import data.Reader;

public class saveTXT {
	// ת������ͼ���б�Ϊ�ַ���
	public static String books2TXT(ArrayList a1) {
		StringBuffer result = new StringBuffer();
		result.append(String.format("\n%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s", "ͼ����", "����", "�������", "��ܱ��", "����", "ͼ��״̬",
				"���������"));
		result.append(System.getProperty("line.separator"));
		int counter = -1;
		for (int i = 0; i < a1.size(); i++) {
			result.append(String.format("\n%s\t\t%s%20s\t\t%s\t\t%s\t\t%s\t\t%s", ((Book) a1.get(i)).getBookID(),
					((Book) a1.get(i)).getBookName(), ((Book) a1.get(i)).SgetBookIndate(),
					((Book) a1.get(i)).getBookLoc(), ((Book) a1.get(i)).getKeeper(), ((Book) a1.get(i)).getBookState(),
					((Book) a1.get(i)).getRenewtimes()));
			result.append(System.getProperty("line.separator"));
			counter = i;
		}

		if (counter == -1) {
			result.append(String.format("\nͼ���б�Ŀǰû��ͼ�顣"));
			result.append(System.getProperty("line.separator"));
		}
		return result.toString();
	}

	// ת�����ж����б�Ϊ�ַ���
	public static String readers2TXT(ArrayList a1) {
		StringBuffer result = new StringBuffer();
		result.append(String.format("\n\t%s%25s\t\t%s\t\t%s", "ѧ��", "����", "�Ա�", "�ѽ�ͼ����"));
		result.append(System.getProperty("line.separator"));
		int counter = -1;
		for (int i = 0; i < a1.size(); i++) {
			result.append(String.format("\n%15d\t%s\t%s\t%s", ((Reader) a1.get(i)).getID(), ((Reader) a1.get(i)).getName(),
					((Reader) a1.get(i)).getGender(), ((Reader) a1.get(i)).getKeepingbooks()));
			result.append(System.getProperty("line.separator"));
			counter = i;
		}
		if (counter == -1) {
			result.append(String.format("\n�����б�Ŀǰû�ж��ߡ�"));
			result.append(System.getProperty("line.separator"));
		}
		return result.toString();
	}
}
