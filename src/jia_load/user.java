package jia_load;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.*;
import java.util.*;

import Manager.MyFile;
import Manager.saveTXT;
import Manager.show;
import data.Book;
import data.Manager;
import data.Reader;
import data.date2;
import reader.search;

public class user {
	// ��Bookָ���Ķ���д����ָ�����ļ�
	public static void writeObjectsToFile(ArrayList<Book> books, String filename) {
		File file = new File(filename); // ����������ʼ��File����file
		try {
			// ����������ʼ��ObjectOutputStream����objOutputStream
			ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			for (Object obj : books) {
				// ������д���ļ�
				objOutputStream.writeObject(obj);
			}
			// �ر���objOutputStream
			objOutputStream.close();
		} catch (IOException e) { // �����쳣IOException
			e.printStackTrace(); // �쳣��Ϣ���
		}
	}

	// ��Bookָ���ļ��еĶ������ݶ���
	public static ArrayList<Book> readObjectsFromFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		// ����ļ������ھͶ����쳣
		if (!file.exists())
			throw new FileNotFoundException();
		// ʹ��List�ȴ洢���صĶ���
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			FileInputStream fileInputStream = new FileInputStream(file); // ����������ʼ��FileInputStream
			// ����������ʼ��ObjectInputStream����objInputStream
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
			while (fileInputStream.available() > 0) {
				list.add((Book) objInputStream.readObject()); // ��ȡһ�����󣬲�������б���
			}
			objInputStream.close(); // �ر�objInputStream
		} catch (ClassNotFoundException e) { // ����ClassNotFoundException�쳣
			e.printStackTrace(); // �쳣��Ϣ���
		} catch (IOException e) { // ����IOException�쳣
			e.printStackTrace(); // �쳣��Ϣ���
		}
		return list;
	}

	// ��Readerָ���Ķ���д����ָ�����ļ�
	public static void RwriteObjectsToFile(ArrayList<Reader> readers, String filename) {
		File file = new File(filename); // ����������ʼ��File����file
		try {
			// ����������ʼ��ObjectOutputStream����objOutputStream
			ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			for (Object obj : readers) {
				// ������д���ļ�
				objOutputStream.writeObject(obj);
			}
			// �ر���objOutputStream
			objOutputStream.close();
		} catch (IOException e) { // �����쳣IOException
			e.printStackTrace(); // �쳣��Ϣ���
		}
	}

	// ��Readerָ���ļ��еĶ������ݶ���
	public static ArrayList<Reader> RreadObjectsFromFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		// ����ļ������ھͶ����쳣
		if (!file.exists())
			throw new FileNotFoundException();
		// ʹ��List�ȴ洢���صĶ���
		ArrayList<Reader> list = new ArrayList<Reader>();
		try {
			FileInputStream fileInputStream = new FileInputStream(file); // ����������ʼ��FileInputStream
			// ����������ʼ��ObjectInputStream����objInputStream
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
			while (fileInputStream.available() > 0) {
				list.add((Reader) objInputStream.readObject()); // ��ȡһ�����󣬲�������б���
			}
			objInputStream.close(); // �ر�objInputStream
		} catch (ClassNotFoundException e) { // ����ClassNotFoundException�쳣
			e.printStackTrace(); // �쳣��Ϣ���
		} catch (IOException e) { // ����IOException�쳣
			e.printStackTrace(); // �쳣��Ϣ���
		}
		return list;
	}

	// ��Managerָ���Ķ���д����ָ�����ļ�
	public static void MwriteObjectsToFile(Object[] objs, String filename) {
		File file = new File(filename); // ����������ʼ��File����file
		try {
			// ����������ʼ��ObjectOutputStream����objOutputStream
			ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			for (Object obj : objs) {
				// ������д���ļ�
				objOutputStream.writeObject(obj);
			}
			// �ر���objOutputStream
			objOutputStream.close();
		} catch (IOException e) { // �����쳣IOException
			e.printStackTrace(); // �쳣��Ϣ���
		}
	}

	// ��Managerָ���ļ��еĶ������ݶ���
	public static Manager[] MreadObjectsFromFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		// ����ļ������ھͶ����쳣
		if (!file.exists())
			throw new FileNotFoundException();
		// ʹ��List�ȴ洢���صĶ���
		List<Manager> list = new ArrayList<Manager>();
		try {
			FileInputStream fileInputStream = new FileInputStream(file); // ����������ʼ��FileInputStream
			// ����������ʼ��ObjectInputStream����objInputStream
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
			while (fileInputStream.available() > 0) {
				list.add((Manager) objInputStream.readObject()); // ��ȡһ�����󣬲�������б���
			}
			objInputStream.close(); // �ر�objInputStream
		} catch (ClassNotFoundException e) { // ����ClassNotFoundException�쳣
			e.printStackTrace(); // �쳣��Ϣ���
		} catch (IOException e) { // ����IOException�쳣
			e.printStackTrace(); // �쳣��Ϣ���
		}
		Manager[] managers = new Manager[list.size()]; // ����������ʼ��Manager����
		return list.toArray(managers);
	}

	// ������
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String Bfile = "books.dat";
		String Rfile = "readers.dat";
		String Mfile = "managers.dat";
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Reader> readers = new ArrayList<Reader>();
		Manager[] managers = new Manager[10];
		boolean flag;// �жϱ���
		int stuID;// ѧ��
		int choice = 0;// �û�ѡ��
		// �����ʼ����

		Scanner input = new Scanner(System.in);

		do {
			do {
				System.out.println("=========================================||��ӭʹ��ͼ��ݹ���ϵͳ||=========================================");
				System.out.println("��ѡ���¼����:");
				System.out.print("1.����\t2.����Ա\t3.ϵͳ��ʼ��"); // ��֤ʹ�����Ƿ����û����ǹ���Ա����Ȼ�������û����ǹ���Ա����ѡһ��
				choice = input.nextInt();
				if (choice != 1 && choice != 2 && choice != 3) {
					System.out.println("������ѡ����߻����Ա��");
				} else {
					break;
				}
			} while (choice != 1 && choice != 2 && choice != 3);

			switch (choice) {
			// ��ʼ��
			case 3:
				// books�ļ���ʼ��
				Book book1 = new Book(10001, "��Ĺ�ʼ�", 56.6); // �������book���洢ͼ�����������
				book1.setBookIndate(1993, 2, 4);
				book1.setStock(5);
				book1.setBookLoc("A01");
				books.add(book1);

				Book book2 = new Book(10002, "Χ��", 45.8);
				book2.setBookIndate(1996, 5, 4);
				book2.setStock(5);
				book2.setBookLoc("B02");
				books.add(book2);

				Book book3 = new Book(10003, "ƽ������", 45.0);
				book3.setBookIndate(2001, 10, 3);
				book3.setStock(5);
				book3.setBookLoc("C03");
				books.add(book3);

				Book book4 = new Book(10004, "��������", 89.0);
				book4.setBookIndate(1997, 7, 14);
				book4.setStock(5);
				book4.setBookLoc("D04");
				books.add(book4);

				Book book5 = new Book(10005, "��ǧ��", 50.5);
				book5.setBookIndate(2006, 12, 9);
				book5.setStock(5);
				book5.setBookLoc("E05");
				books.add(book5);
				writeObjectsToFile(books, Bfile);

				// readers�ļ���ʼ��
				Reader stu1 = new Reader("����ǿ", "��", 11510352);
				readers.add(stu1);
				Reader stu2 = new Reader("������", "Ů", 11510375);
				readers.add(stu2);
				Reader stu3 = new Reader("������", "Ů", 11510369);
				readers.add(stu3);
				RwriteObjectsToFile(readers, Rfile);

				// managers�ļ���ʼ��
				managers[0] = new Manager("admin", 123456);
				for (int i = 1; i < managers.length; i++) {
					managers[i] = new Manager();
				}
				MwriteObjectsToFile(managers, Mfile);
				System.out.print("ϵͳ�Ѿ���ʼ����ɡ�\n");
				break;
			// ���ߵ�½
			case 1:
				books = readObjectsFromFile(Bfile);
				readers = RreadObjectsFromFile(Rfile);
				flag = false;
				do {
					System.out.print("���������֤�ţ�ѧ�ţ���");
					stuID = input.nextInt();
					if (search.stuID2index(stuID, readers) == -1) {
						System.out.print("�������ѧ�Ų����ڣ����������룡\n");
						continue;
					}
					System.out.print("���������루Ĭ��Ϊѧ�ź�6λ����");
					int pwd = input.nextInt();
					flag = (readers.get(search.stuID2index(stuID, readers)).getPassword() == pwd) ? true : false;
					if (flag) {
						System.out.println("��¼�ɹ���");
						break;
					} else {
						System.out.print("����������������룡\n"); // ��ѭ����֤�û�������ȷ���û���������
					}
				} while (flag == false);
				int function1;
				do {// ���߹���ѭ��
					function1 = -1;
					do {
						System.out.print("\n===========================================|���߹���|===========================================\n");
						System.out.printf("\n�����빦�ܱ�ţ�\n%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
								"1.��ѯ�ɽ���ͼ��", "2.��ѯ�ѽ�ͼ��", "3.����", "4.����", "5.����ͼ�鴦��", "6.����", "7.�޸�����", "8.�˳���¼");
						function1 = input.nextInt();
						flag = (function1 >= 1 && function1 <= 8) ? true : false;
						if (flag == true) {
						} else
							System.out.print("������Ĺ��ܲ����ڣ�����������\n");
					} while (flag == false);
					switch (function1) {
					case 1:// ��ѯ�ɽ���ͼ��
						System.out.print("�����������ؼ��ʣ�");
						CharSequence name1 = input.next();
						reader.search.query(name1, books);
						System.out.println();
						break;
					case 2:// ��ѯ�ѽ�ͼ��
						System.out.printf("����֤�ţ�%d", stuID);
						reader.search.keeper(stuID, books);
						System.out.println();// ����
						break;
					case 3:// ����
						show.showbooks(books);
						System.out.print("\n������ͼ���ţ�");
						int LbookID = input.nextInt();
						reader.BR.borrow(stuID, LbookID, books,readers);
						writeObjectsToFile(books, Bfile);
						RwriteObjectsToFile(readers, Rfile);
						break;
					case 4:// ����
						System.out.print("������ͼ���ţ�");
						int RbookID = input.nextInt();
						reader.BR.back(stuID, RbookID, books,readers);
						writeObjectsToFile(books, Bfile);
						RwriteObjectsToFile(readers, Rfile);
						break;
					case 5:// ����ͼ�鴦��
						System.out.printf("����֤�ţ�%d", stuID);
						reader.search.keeper(stuID, books);
						try {
							if (reader.BR.fine(stuID, books) == 0) {
								System.out.print("��û������ͼ�飬����Ҫ���ɷ��\n");
							} else {
								System.out.printf("\n��Ҫ���ɷ���%dԪ��", reader.BR.fine(stuID, books));
								System.out.print("\n�Ƿ����ڴ���(Y/N)");
								char choice5 = 'N';
								choice5 = input.next().charAt(0);
								Date tempTime = new Date();
								if (String.valueOf(choice5).equalsIgnoreCase(String.valueOf("Y"))) {
									for (int i = 0; i < books.size(); i++) {
										if (((Book) books.get(i)).getKeeper() == stuID
												&& ((Book) books.get(i)).getBookState().equals("���")
												&& ((Book) books.get(i)).getDuedate().before(tempTime))
										{
											((Book) books.get(i)).setKeeper(0);
											((Book) books.get(i)).setBookState("�ڹ�");
											int tempKeep = ((Reader) readers.get(search.stuID2index(stuID, readers))).getKeepingbooks();
											((Reader) readers.get(search.stuID2index(stuID, readers))).setKeepingbooks(tempKeep - 1);
										}
									}
									System.out.print("������ɣ�����ͼ���Ѿ��黹��\n");
								} else
									System.out.print("��ʱ������\n");
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						writeObjectsToFile(books, Bfile);
						RwriteObjectsToFile(readers, Rfile);
						break;
					case 6:// ����
						System.out.printf("����֤�ţ�%d", stuID);
						reader.search.keeper(stuID, books);
						System.out.print("\n������ͼ���ţ�");
						int bookID6 = input.nextInt();
						reader.BR.renew(bookID6, books);
						writeObjectsToFile(books, Bfile);
						break;
					case 7:// �޸�����
						do {
							System.out.print("���������֤�ţ�ѧ�ţ���");
							stuID = input.nextInt();
							if (search.stuID2index(stuID, readers) == -1) {
								System.out.print("�������ѧ�Ų����ڣ����������룡\n");
							}
						} while (search.stuID2index(stuID, readers) == -1);
						System.out.print("\n�����������룺");
						int pwd = input.nextInt();
						readers.get(search.stuID2index(stuID, readers)).setPassword(pwd);
						RwriteObjectsToFile(readers, Rfile);
						break;
					case 8:// �˳���¼
						writeObjectsToFile(books, Bfile);
						System.out.print("\n���˳���¼��");
						break;
					}
				} while (function1 != 8);
				break;// ���ߺ��������˳�

			// ����Ա��½
			case 2:
				books = readObjectsFromFile(Bfile);
				readers = RreadObjectsFromFile(Rfile);
				managers = MreadObjectsFromFile(Mfile);
				String userName = "";// ��ǰ�û���
				flag = false;
				do {
					System.out.print("���������Ա����");
					String name = input.next();
					if (search.admin2index(name, managers) == -1) {
						System.out.print("������Ĺ���Ա�������ڣ����������룡\n");
						continue;
					}
					System.out.print("���������룺");
					int pwd = input.nextInt();
					flag = (managers[search.admin2index(name, managers)].getUsercode() == pwd) ? true : false;
					if (flag) {
						System.out.println("��¼�ɹ���");
						userName = name;
						break;
					}
					System.out.print("�����������������!\n"); // ��ѭ����֤�û�������ȷ���û���������
				} while (flag == false);

				int function2 = -1;
				do {// ����Ա����ѭ��
					do {
						System.out.print("==========================================|����Ա����|==========================================");
						System.out.printf("\n�����빦�ܱ�ţ�\n%s\t%s\t%s\t%s", "1.������Ϣ����", "2.ͼ����Ϣ����", "3.�޸�����",
								"4.�˳���¼");
						function2 = input.nextInt();
						flag = (function2 >= 1 && function2 <= 4) ? true : false;
						if (flag == true) {
						} else
							System.out.print("������Ĺ��ܲ����ڣ�����������\n");
					} while (flag == false);
					switch (function2) {
					case 1:// ������Ϣ����
						int function21 = -1;
						do {
							do {
								System.out.print("===========================================|������Ϣ|===========================================");
								System.out.printf("\n�����빦�ܱ�ţ�\n%s\t%s\t%s\t%s", "1.¼���¶���", "2.�޸Ķ�������",
										"3.���ж�����Ϣ�б�չʾ", "4.�˳� ������Ϣ����");
								function21 = input.nextInt();
								flag = (function21 >= 1 && function21 <= 4) ? true : false;
								if (flag == true) {
								} else
									System.out.print("������Ĺ��ܲ����ڣ�����������\n");
							} while (flag == false);
							switch (function21) {
							case 1:// ¼���¶���
								char choice11;
								do {
									System.out.print("\n����:");
									String name = input.next();
									System.out.print("\n�Ա�:1.�� 2.Ů");
									String gender;
									int choice11g;
									do {
										choice11g = input.nextInt();
										if (choice11g != 1 && choice11g != 2)
											System.out.print("�������ѡ����ڣ�����������\n");
									} while (choice11g != 1 && choice11g != 2);
									if (choice11g == 1)
										gender = "��";
									else
										gender = "Ů";
									System.out.print("\nѧ��:");
									int ID = input.nextInt();
									Reader readertemp = new Reader(name, gender, ID);
									readers.add(readertemp);
									System.out.print("\n�Ƿ�������룿��Y/N��");
									choice11 = 'N';
									choice11 = input.next().charAt(0);
								} while (String.valueOf(choice11).equalsIgnoreCase(String.valueOf("Y")));
								RwriteObjectsToFile(readers, Rfile);
								break;
							case 2:// �޸Ķ�������
								do {
									System.out.print("���������֤�ţ�ѧ�ţ���");
									stuID = input.nextInt();
									if (search.stuID2index(stuID, readers) == -1) {
										System.out.print("�������ѧ�Ų����ڣ����������룡\n");
									}
								} while (search.stuID2index(stuID, readers) == -1);
								System.out.print("\n�����������룺");
								int pwd = input.nextInt();
								readers.get(search.stuID2index(stuID, readers)).setPassword(pwd);
								RwriteObjectsToFile(readers, Rfile);
								break;
							case 3:// ���ж�����Ϣ�б�չʾ
									// ��ȡ�ļ�����
								readers = RreadObjectsFromFile(Rfile);
								// ��ȡ�Ķ���
								show.showreaders(readers);
								System.out.println();// ����
								
								char choice212;
								do {
									System.out.print("\n�Ƿ���Ҫ�������б�Ϊtxt����Y/N��");
									choice212 = 'N';
									choice212 = input.next().charAt(0);
								} while (!String.valueOf(choice212).equalsIgnoreCase(String.valueOf("N"))&&!String.valueOf(choice212).equalsIgnoreCase(String.valueOf("Y")));
								
								if(String.valueOf(choice212).equalsIgnoreCase(String.valueOf("Y"))){
									Date now =new Date();
									SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									StringBuffer result = new StringBuffer();
									result.append("========================================================================================================================\n");
									result.append(d1.format(now)+"\n");
									result.append(System.getProperty("line.separator"));
									result.append(saveTXT.readers2TXT(readers)+"\n");
									String readerTXT="readersLIST.txt";
									MyFile.creatTxtFile(readerTXT);
									MyFile.writeTxtFile(result.toString(),readerTXT);
									System.out.print("�����ɡ�\n");
								}
								break;
							case 4:// �˳�������Ϣ����
								RwriteObjectsToFile(readers, Rfile);
								System.out.print("���˳�������Ϣ����\n");
								break;
							}
						} while (function21 != 4);
						break;
					case 2:// ͼ����Ϣ����
						int function22 = -1;
						do {
							do {
								System.out.print("==========================================|ͼ����Ϣ����|==========================================");
								System.out.printf("\n�����빦�ܱ�ţ�\n%s\t%s\t%s\t%s", "1.�������", "2.�༭ͼ����Ϣ",
										"3.����ͼ����Ϣ�б�չʾ", "4.�˳� ͼ����Ϣ����");
								function22 = input.nextInt();
								flag = (function22 >= 1 && function22 <= 4) ? true : false;
								if (flag == true) {
								} else
									System.out.print("������Ĺ��ܲ����ڣ�����������\n");
							} while (flag == false);
							switch (function22) {
							case 1:// �������
								char choice21;
								do {
									System.out.print("\nͼ����:");
									int id = input.nextInt();
									System.out.print("\n����:");
									String name = input.next();
									System.out.print("\n�۸�:");
									double price = input.nextDouble();
									Book booktemp = new Book(id, name, price);
									books.add(booktemp);
									System.out.print("\n�Ƿ�������룿��Y/N��");
									choice21 = 'N';
									choice21 = input.next().charAt(0);
								} while (String.valueOf(choice21).equalsIgnoreCase(String.valueOf("Y")));
								writeObjectsToFile(books, Bfile);

								break;
							case 2:// �༭ͼ����Ϣ
								books = readObjectsFromFile(Bfile);// ��ȡ�ļ�����
								char choice22;
								do {
									show.showbooks(books);// ��ȡ�Ķ���
									System.out.println();// ����

									int index = -1;// ͼ��������
									do {// ��ȡͼ����
										System.out.print("\n������ͼ���ţ�");
										int bookID = input.nextInt();
										index = search.bookID2index(bookID, books);
										if (index == -1)
											System.out.print("�������ͼ���Ų����ڣ����������롣\n");
									} while (index == -1);

									int edit;
									do {// ��ȡ�޸ĵ�����
										System.out.print("\n������Ҫ�޸ĵ����ԣ�");
										System.out.printf("\n%s\t%s\t%s\t%s\t%s", "1.ͼ����", "2.����", "3.�������",
												"4.��ܱ��", "5.ͼ��״̬");
										edit = input.nextInt();
										flag = (edit >= 1 && edit <= 5) ? true : false;
										if (flag == true) {
										} else
											System.out.print("�������Ҫ�޸����Բ����ڣ�����������\n");
									} while (flag == false);
									switch (edit) {
									case 1:// ͼ����
										System.out.print("\n��������ͼ���ţ�");
										int id = input.nextInt();
										books.get(index).setBookID(id);
										System.out.print("\n��ͼ�����趨��ɡ�");
										break;
									case 2:// ����
										System.out.print("\n��������������");
										String name = input.next();
										books.get(index).setBookName(name);
										System.out.print("\n�������趨��ɡ�");
										break;
									case 3:// �������
										flag=false;
										do{
										System.out.print("\n��������������ڣ�YYYY MM DD���������ÿո�ֿ�����");
										int year=input.nextInt();
										int month=input.nextInt();
										int day=input.nextInt();
										flag=(date2.NcheckYear(year)&&date2.NcheckMonth(month));
										if(flag==false){
											System.out.print("�������������������������\n");
										}
										else 
										{
											if(date2.NcheckDay(year, month, day)==false)
											{
												System.out.print("�������������������������\n");
												flag=false;
											}
											else
												books.get(index).setBookIndate(year,month,day);
										}
										}while(flag==false);
										System.out.print("\n����������趨��ɡ�");
										
										break;
									case 4:// ��ܱ��
										System.out.print("\n����������ܱ�ţ�");
										String bookLoc = input.next();
										books.get(index).setBookLoc(bookLoc);
										System.out.print("\n����ܱ���趨��ɡ�");
										break;
									case 5:// ͼ��״̬
										int function225 = -1;
										do {
											System.out.print("\n��ѡ��ͼ��״̬��1.�ڹ�\t2.���");
											function225 = input.nextInt();
											flag = (function225 >= 1 && function225 <= 2) ? true : false;
											if (flag == true) {
											} else
												System.out.print("�������ͼ��״̬�����ڣ�����������\n");
										} while (flag == false);
										if (function225 == 1)
											books.get(index).setBookState("�ڹ�");
										else
											books.get(index).setBookState("���");
										break;
									}

									System.out.print("\n�Ƿ�����༭����ͼ����Ϣ����Y/N��");
									choice22 = 'N';
									choice22 = input.next().charAt(0);
								} while (String.valueOf(choice22).equalsIgnoreCase(String.valueOf("Y")));
								writeObjectsToFile(books, Bfile);

								break;
							case 3:// ����ͼ����Ϣ�б�չʾ
									// ��ȡ�ļ�����
								books = readObjectsFromFile(Bfile);
								// ��ȡ�Ķ���
								show.showbooks(books);
								System.out.println();// ����
								
								char choice223;
								do {
									System.out.print("\n�Ƿ���Ҫ�������б�Ϊtxt����Y/N��");
									choice223 = 'N';
									choice223 = input.next().charAt(0);
								} while (!String.valueOf(choice223).equalsIgnoreCase(String.valueOf("N"))&&!String.valueOf(choice223).equalsIgnoreCase(String.valueOf("Y")));
								
								if(String.valueOf(choice223).equalsIgnoreCase(String.valueOf("Y"))){
									Date now =new Date();
									SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									StringBuffer result = new StringBuffer();
									result.append("========================================================================================================================\n");
									result.append(d1.format(now)+"\n");
									result.append(System.getProperty("line.separator"));
									result.append(saveTXT.books2TXT(books)+"\n");
									String bookTXT="booksLIST.txt";
									MyFile.creatTxtFile(bookTXT);
									MyFile.writeTxtFile(result.toString(),bookTXT);
									System.out.print("�����ɡ�\n");
								}
								
								break;
							case 4:// �˳�ͼ����Ϣ����
								System.out.print("���˳�ͼ����Ϣ����\n");
								break;
							}
						} while (function22 != 4);
						break;
					case 3:// �޸�����
						do {
							System.out.print("������ԭ���룺");
							int rawPwd = input.nextInt();
							flag = (managers[search.admin2index(userName, managers)].getUsercode() == rawPwd) ? true
									: false;
							if (flag) {
								System.out.println("ԭ������ȷ��");
								break;
							}
							System.out.print("�����������������!\n");
						} while (flag == false);

						System.out.print("\n�����������룺");
						int newPwd = input.nextInt();
						managers[search.admin2index(userName, managers)].setUsercode(newPwd);
						System.out.print("�������趨�ɹ��������µ�¼��\n");
						MwriteObjectsToFile(managers, Mfile);
						break;
					case 4:// �˳�����Ա��¼
						writeObjectsToFile(books, Bfile);
						RwriteObjectsToFile(readers, Rfile);
						System.out.print("���˳���¼��\n");
						break;
					}
				} while (function2 != 4);

				break;// ����Ա���������˳�
			}
		} while (choice != 1 && choice != 2);
	}
}
