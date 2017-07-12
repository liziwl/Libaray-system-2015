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
	// 将Book指定的对象写入至指定的文件
	public static void writeObjectsToFile(ArrayList<Book> books, String filename) {
		File file = new File(filename); // 创建，并初始化File对象file
		try {
			// 创建，并初始化ObjectOutputStream对象objOutputStream
			ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			for (Object obj : books) {
				// 将对象写入文件
				objOutputStream.writeObject(obj);
			}
			// 关闭流objOutputStream
			objOutputStream.close();
		} catch (IOException e) { // 捕获异常IOException
			e.printStackTrace(); // 异常信息输出
		}
	}

	// 将Book指定文件中的对象数据读回
	public static ArrayList<Book> readObjectsFromFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		// 如果文件不存在就丢出异常
		if (!file.exists())
			throw new FileNotFoundException();
		// 使用List先存储读回的对象
		ArrayList<Book> list = new ArrayList<Book>();
		try {
			FileInputStream fileInputStream = new FileInputStream(file); // 创建，并初始化FileInputStream
			// 创建，并初始化ObjectInputStream对象objInputStream
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
			while (fileInputStream.available() > 0) {
				list.add((Book) objInputStream.readObject()); // 读取一个对象，并添加与列表中
			}
			objInputStream.close(); // 关闭objInputStream
		} catch (ClassNotFoundException e) { // 捕获ClassNotFoundException异常
			e.printStackTrace(); // 异常信息输出
		} catch (IOException e) { // 捕获IOException异常
			e.printStackTrace(); // 异常信息输出
		}
		return list;
	}

	// 将Reader指定的对象写入至指定的文件
	public static void RwriteObjectsToFile(ArrayList<Reader> readers, String filename) {
		File file = new File(filename); // 创建，并初始化File对象file
		try {
			// 创建，并初始化ObjectOutputStream对象objOutputStream
			ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			for (Object obj : readers) {
				// 将对象写入文件
				objOutputStream.writeObject(obj);
			}
			// 关闭流objOutputStream
			objOutputStream.close();
		} catch (IOException e) { // 捕获异常IOException
			e.printStackTrace(); // 异常信息输出
		}
	}

	// 将Reader指定文件中的对象数据读回
	public static ArrayList<Reader> RreadObjectsFromFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		// 如果文件不存在就丢出异常
		if (!file.exists())
			throw new FileNotFoundException();
		// 使用List先存储读回的对象
		ArrayList<Reader> list = new ArrayList<Reader>();
		try {
			FileInputStream fileInputStream = new FileInputStream(file); // 创建，并初始化FileInputStream
			// 创建，并初始化ObjectInputStream对象objInputStream
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
			while (fileInputStream.available() > 0) {
				list.add((Reader) objInputStream.readObject()); // 读取一个对象，并添加与列表中
			}
			objInputStream.close(); // 关闭objInputStream
		} catch (ClassNotFoundException e) { // 捕获ClassNotFoundException异常
			e.printStackTrace(); // 异常信息输出
		} catch (IOException e) { // 捕获IOException异常
			e.printStackTrace(); // 异常信息输出
		}
		return list;
	}

	// 将Manager指定的对象写入至指定的文件
	public static void MwriteObjectsToFile(Object[] objs, String filename) {
		File file = new File(filename); // 创建，并初始化File对象file
		try {
			// 创建，并初始化ObjectOutputStream对象objOutputStream
			ObjectOutputStream objOutputStream = new ObjectOutputStream(new FileOutputStream(file));
			for (Object obj : objs) {
				// 将对象写入文件
				objOutputStream.writeObject(obj);
			}
			// 关闭流objOutputStream
			objOutputStream.close();
		} catch (IOException e) { // 捕获异常IOException
			e.printStackTrace(); // 异常信息输出
		}
	}

	// 将Manager指定文件中的对象数据读回
	public static Manager[] MreadObjectsFromFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		// 如果文件不存在就丢出异常
		if (!file.exists())
			throw new FileNotFoundException();
		// 使用List先存储读回的对象
		List<Manager> list = new ArrayList<Manager>();
		try {
			FileInputStream fileInputStream = new FileInputStream(file); // 创建，并初始化FileInputStream
			// 创建，并初始化ObjectInputStream对象objInputStream
			ObjectInputStream objInputStream = new ObjectInputStream(fileInputStream);
			while (fileInputStream.available() > 0) {
				list.add((Manager) objInputStream.readObject()); // 读取一个对象，并添加与列表中
			}
			objInputStream.close(); // 关闭objInputStream
		} catch (ClassNotFoundException e) { // 捕获ClassNotFoundException异常
			e.printStackTrace(); // 异常信息输出
		} catch (IOException e) { // 捕获IOException异常
			e.printStackTrace(); // 异常信息输出
		}
		Manager[] managers = new Manager[list.size()]; // 创建，并初始化Manager数组
		return list.toArray(managers);
	}

	// 主函数
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String Bfile = "books.dat";
		String Rfile = "readers.dat";
		String Mfile = "managers.dat";
		ArrayList<Book> books = new ArrayList<Book>();
		ArrayList<Reader> readers = new ArrayList<Reader>();
		Manager[] managers = new Manager[10];
		boolean flag;// 判断变量
		int stuID;// 学号
		int choice = 0;// 用户选择
		// 载入初始数据

		Scanner input = new Scanner(System.in);

		do {
			do {
				System.out.println("=========================================||欢迎使用图书馆管理系统||=========================================");
				System.out.println("请选择登录类型:");
				System.out.print("1.读者\t2.管理员\t3.系统初始化"); // 验证使用者是否是用户还是管理员，当然这里是用户还是管理员必须选一个
				choice = input.nextInt();
				if (choice != 1 && choice != 2 && choice != 3) {
					System.out.println("请重新选择读者或管理员！");
				} else {
					break;
				}
			} while (choice != 1 && choice != 2 && choice != 3);

			switch (choice) {
			// 初始化
			case 3:
				// books文件初始化
				Book book1 = new Book(10001, "盗墓笔记", 56.6); // 构造对象book来存储图书的所有属性
				book1.setBookIndate(1993, 2, 4);
				book1.setStock(5);
				book1.setBookLoc("A01");
				books.add(book1);

				Book book2 = new Book(10002, "围城", 45.8);
				book2.setBookIndate(1996, 5, 4);
				book2.setStock(5);
				book2.setBookLoc("B02");
				books.add(book2);

				Book book3 = new Book(10003, "平凡的心", 45.0);
				book3.setBookIndate(2001, 10, 3);
				book3.setStock(5);
				book3.setBookLoc("C03");
				books.add(book3);

				Book book4 = new Book(10004, "哈利波特", 89.0);
				book4.setBookIndate(1997, 7, 14);
				book4.setStock(5);
				book4.setBookLoc("D04");
				books.add(book4);

				Book book5 = new Book(10005, "花千骨", 50.5);
				book5.setBookIndate(2006, 12, 9);
				book5.setStock(5);
				book5.setBookLoc("E05");
				books.add(book5);
				writeObjectsToFile(books, Bfile);

				// readers文件初始化
				Reader stu1 = new Reader("李子强", "男", 11510352);
				readers.add(stu1);
				Reader stu2 = new Reader("朱雨萌", "女", 11510375);
				readers.add(stu2);
				Reader stu3 = new Reader("贾彦文", "女", 11510369);
				readers.add(stu3);
				RwriteObjectsToFile(readers, Rfile);

				// managers文件初始化
				managers[0] = new Manager("admin", 123456);
				for (int i = 1; i < managers.length; i++) {
					managers[i] = new Manager();
				}
				MwriteObjectsToFile(managers, Mfile);
				System.out.print("系统已经初始化完成。\n");
				break;
			// 读者登陆
			case 1:
				books = readObjectsFromFile(Bfile);
				readers = RreadObjectsFromFile(Rfile);
				flag = false;
				do {
					System.out.print("请输入读者证号（学号）：");
					stuID = input.nextInt();
					if (search.stuID2index(stuID, readers) == -1) {
						System.out.print("您输入的学号不存在，请重新输入！\n");
						continue;
					}
					System.out.print("请输入密码（默认为学号后6位）：");
					int pwd = input.nextInt();
					flag = (readers.get(search.stuID2index(stuID, readers)).getPassword() == pwd) ? true : false;
					if (flag) {
						System.out.println("登录成功！");
						break;
					} else {
						System.out.print("密码错误，请重新输入！\n"); // 用循环保证用户输入正确的用户名和密码
					}
				} while (flag == false);
				int function1;
				do {// 读者功能循环
					function1 = -1;
					do {
						System.out.print("\n===========================================|读者功能|===========================================\n");
						System.out.printf("\n请输入功能编号：\n%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\n",
								"1.查询可借阅图书", "2.查询已借图书", "3.借书", "4.还书", "5.逾期图书处理", "6.续借", "7.修改密码", "8.退出登录");
						function1 = input.nextInt();
						flag = (function1 >= 1 && function1 <= 8) ? true : false;
						if (flag == true) {
						} else
							System.out.print("您输入的功能不存在，请重新输入\n");
					} while (flag == false);
					switch (function1) {
					case 1:// 查询可借阅图书
						System.out.print("请输入书名关键词：");
						CharSequence name1 = input.next();
						reader.search.query(name1, books);
						System.out.println();
						break;
					case 2:// 查询已借图书
						System.out.printf("读者证号：%d", stuID);
						reader.search.keeper(stuID, books);
						System.out.println();// 换行
						break;
					case 3:// 借书
						show.showbooks(books);
						System.out.print("\n请输入图书编号：");
						int LbookID = input.nextInt();
						reader.BR.borrow(stuID, LbookID, books,readers);
						writeObjectsToFile(books, Bfile);
						RwriteObjectsToFile(readers, Rfile);
						break;
					case 4:// 还书
						System.out.print("请输入图书编号：");
						int RbookID = input.nextInt();
						reader.BR.back(stuID, RbookID, books,readers);
						writeObjectsToFile(books, Bfile);
						RwriteObjectsToFile(readers, Rfile);
						break;
					case 5:// 逾期图书处理
						System.out.printf("读者证号：%d", stuID);
						reader.search.keeper(stuID, books);
						try {
							if (reader.BR.fine(stuID, books) == 0) {
								System.out.print("您没有逾期图书，不需要缴纳罚款。\n");
							} else {
								System.out.printf("\n需要缴纳罚款%d元。", reader.BR.fine(stuID, books));
								System.out.print("\n是否现在处理？(Y/N)");
								char choice5 = 'N';
								choice5 = input.next().charAt(0);
								Date tempTime = new Date();
								if (String.valueOf(choice5).equalsIgnoreCase(String.valueOf("Y"))) {
									for (int i = 0; i < books.size(); i++) {
										if (((Book) books.get(i)).getKeeper() == stuID
												&& ((Book) books.get(i)).getBookState().equals("借出")
												&& ((Book) books.get(i)).getDuedate().before(tempTime))
										{
											((Book) books.get(i)).setKeeper(0);
											((Book) books.get(i)).setBookState("在馆");
											int tempKeep = ((Reader) readers.get(search.stuID2index(stuID, readers))).getKeepingbooks();
											((Reader) readers.get(search.stuID2index(stuID, readers))).setKeepingbooks(tempKeep - 1);
										}
									}
									System.out.print("处理完成，逾期图书已经归还。\n");
								} else
									System.out.print("暂时不处理。\n");
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						writeObjectsToFile(books, Bfile);
						RwriteObjectsToFile(readers, Rfile);
						break;
					case 6:// 续借
						System.out.printf("读者证号：%d", stuID);
						reader.search.keeper(stuID, books);
						System.out.print("\n请输入图书编号：");
						int bookID6 = input.nextInt();
						reader.BR.renew(bookID6, books);
						writeObjectsToFile(books, Bfile);
						break;
					case 7:// 修改密码
						do {
							System.out.print("请输入读者证号（学号）：");
							stuID = input.nextInt();
							if (search.stuID2index(stuID, readers) == -1) {
								System.out.print("您输入的学号不存在，请重新输入！\n");
							}
						} while (search.stuID2index(stuID, readers) == -1);
						System.out.print("\n请输入新密码：");
						int pwd = input.nextInt();
						readers.get(search.stuID2index(stuID, readers)).setPassword(pwd);
						RwriteObjectsToFile(readers, Rfile);
						break;
					case 8:// 退出登录
						writeObjectsToFile(books, Bfile);
						System.out.print("\n已退出登录。");
						break;
					}
				} while (function1 != 8);
				break;// 读者函数部分退出

			// 管理员登陆
			case 2:
				books = readObjectsFromFile(Bfile);
				readers = RreadObjectsFromFile(Rfile);
				managers = MreadObjectsFromFile(Mfile);
				String userName = "";// 当前用户名
				flag = false;
				do {
					System.out.print("请输入管理员名：");
					String name = input.next();
					if (search.admin2index(name, managers) == -1) {
						System.out.print("您输入的管理员名不存在，请重新输入！\n");
						continue;
					}
					System.out.print("请输入密码：");
					int pwd = input.nextInt();
					flag = (managers[search.admin2index(name, managers)].getUsercode() == pwd) ? true : false;
					if (flag) {
						System.out.println("登录成功！");
						userName = name;
						break;
					}
					System.out.print("密码错误，请重新输入!\n"); // 用循环保证用户输入正确的用户名和密码
				} while (flag == false);

				int function2 = -1;
				do {// 管理员功能循环
					do {
						System.out.print("==========================================|管理员功能|==========================================");
						System.out.printf("\n请输入功能编号：\n%s\t%s\t%s\t%s", "1.读者信息管理", "2.图书信息管理", "3.修改密码",
								"4.退出登录");
						function2 = input.nextInt();
						flag = (function2 >= 1 && function2 <= 4) ? true : false;
						if (flag == true) {
						} else
							System.out.print("您输入的功能不存在，请重新输入\n");
					} while (flag == false);
					switch (function2) {
					case 1:// 读者信息管理
						int function21 = -1;
						do {
							do {
								System.out.print("===========================================|读者信息|===========================================");
								System.out.printf("\n请输入功能编号：\n%s\t%s\t%s\t%s", "1.录入新读者", "2.修改读者密码",
										"3.所有读者信息列表展示", "4.退出 读者信息管理");
								function21 = input.nextInt();
								flag = (function21 >= 1 && function21 <= 4) ? true : false;
								if (flag == true) {
								} else
									System.out.print("您输入的功能不存在，请重新输入\n");
							} while (flag == false);
							switch (function21) {
							case 1:// 录入新读者
								char choice11;
								do {
									System.out.print("\n姓名:");
									String name = input.next();
									System.out.print("\n性别:1.男 2.女");
									String gender;
									int choice11g;
									do {
										choice11g = input.nextInt();
										if (choice11g != 1 && choice11g != 2)
											System.out.print("您输入的选项不存在，请重新输入\n");
									} while (choice11g != 1 && choice11g != 2);
									if (choice11g == 1)
										gender = "男";
									else
										gender = "女";
									System.out.print("\n学号:");
									int ID = input.nextInt();
									Reader readertemp = new Reader(name, gender, ID);
									readers.add(readertemp);
									System.out.print("\n是否继续输入？（Y/N）");
									choice11 = 'N';
									choice11 = input.next().charAt(0);
								} while (String.valueOf(choice11).equalsIgnoreCase(String.valueOf("Y")));
								RwriteObjectsToFile(readers, Rfile);
								break;
							case 2:// 修改读者密码
								do {
									System.out.print("请输入读者证号（学号）：");
									stuID = input.nextInt();
									if (search.stuID2index(stuID, readers) == -1) {
										System.out.print("您输入的学号不存在，请重新输入！\n");
									}
								} while (search.stuID2index(stuID, readers) == -1);
								System.out.print("\n请输入新密码：");
								int pwd = input.nextInt();
								readers.get(search.stuID2index(stuID, readers)).setPassword(pwd);
								RwriteObjectsToFile(readers, Rfile);
								break;
							case 3:// 所有读者信息列表展示
									// 读取文件数据
								readers = RreadObjectsFromFile(Rfile);
								// 读取的对象
								show.showreaders(readers);
								System.out.println();// 换行
								
								char choice212;
								do {
									System.out.print("\n是否需要输出结果列表为txt？（Y/N）");
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
									System.out.print("输出完成。\n");
								}
								break;
							case 4:// 退出读者信息管理
								RwriteObjectsToFile(readers, Rfile);
								System.out.print("已退出读者信息管理。\n");
								break;
							}
						} while (function21 != 4);
						break;
					case 2:// 图书信息管理
						int function22 = -1;
						do {
							do {
								System.out.print("==========================================|图书信息管理|==========================================");
								System.out.printf("\n请输入功能编号：\n%s\t%s\t%s\t%s", "1.新书入馆", "2.编辑图书信息",
										"3.所有图书信息列表展示", "4.退出 图书信息管理");
								function22 = input.nextInt();
								flag = (function22 >= 1 && function22 <= 4) ? true : false;
								if (flag == true) {
								} else
									System.out.print("您输入的功能不存在，请重新输入\n");
							} while (flag == false);
							switch (function22) {
							case 1:// 新书入馆
								char choice21;
								do {
									System.out.print("\n图书编号:");
									int id = input.nextInt();
									System.out.print("\n书名:");
									String name = input.next();
									System.out.print("\n价格:");
									double price = input.nextDouble();
									Book booktemp = new Book(id, name, price);
									books.add(booktemp);
									System.out.print("\n是否继续输入？（Y/N）");
									choice21 = 'N';
									choice21 = input.next().charAt(0);
								} while (String.valueOf(choice21).equalsIgnoreCase(String.valueOf("Y")));
								writeObjectsToFile(books, Bfile);

								break;
							case 2:// 编辑图书信息
								books = readObjectsFromFile(Bfile);// 读取文件数据
								char choice22;
								do {
									show.showbooks(books);// 读取的对象
									System.out.println();// 换行

									int index = -1;// 图书索引号
									do {// 获取图书编号
										System.out.print("\n请输入图书编号：");
										int bookID = input.nextInt();
										index = search.bookID2index(bookID, books);
										if (index == -1)
											System.out.print("您输入的图书编号不存在，请重新输入。\n");
									} while (index == -1);

									int edit;
									do {// 获取修改的属性
										System.out.print("\n请输入要修改的属性：");
										System.out.printf("\n%s\t%s\t%s\t%s\t%s", "1.图书编号", "2.书名", "3.入馆日期",
												"4.书架编号", "5.图书状态");
										edit = input.nextInt();
										flag = (edit >= 1 && edit <= 5) ? true : false;
										if (flag == true) {
										} else
											System.out.print("您输入的要修改属性不存在，请重新输入\n");
									} while (flag == false);
									switch (edit) {
									case 1:// 图书编号
										System.out.print("\n请输入新图书编号：");
										int id = input.nextInt();
										books.get(index).setBookID(id);
										System.out.print("\n新图书编号设定完成。");
										break;
									case 2:// 书名
										System.out.print("\n请输入新书名：");
										String name = input.next();
										books.get(index).setBookName(name);
										System.out.print("\n新书名设定完成。");
										break;
									case 3:// 入馆日期
										flag=false;
										do{
										System.out.print("\n请输入新入馆日期（YYYY MM DD，年月日用空格分开）：");
										int year=input.nextInt();
										int month=input.nextInt();
										int day=input.nextInt();
										flag=(date2.NcheckYear(year)&&date2.NcheckMonth(month));
										if(flag==false){
											System.out.print("您输入的日期有误，请重新输入\n");
										}
										else 
										{
											if(date2.NcheckDay(year, month, day)==false)
											{
												System.out.print("您输入的日期有误，请重新输入\n");
												flag=false;
											}
											else
												books.get(index).setBookIndate(year,month,day);
										}
										}while(flag==false);
										System.out.print("\n新入馆日期设定完成。");
										
										break;
									case 4:// 书架编号
										System.out.print("\n请输入新书架编号：");
										String bookLoc = input.next();
										books.get(index).setBookLoc(bookLoc);
										System.out.print("\n新书架编号设定完成。");
										break;
									case 5:// 图书状态
										int function225 = -1;
										do {
											System.out.print("\n请选择图书状态：1.在馆\t2.借出");
											function225 = input.nextInt();
											flag = (function225 >= 1 && function225 <= 2) ? true : false;
											if (flag == true) {
											} else
												System.out.print("您输入的图书状态不存在，请重新输入\n");
										} while (flag == false);
										if (function225 == 1)
											books.get(index).setBookState("在馆");
										else
											books.get(index).setBookState("借出");
										break;
									}

									System.out.print("\n是否继续编辑其它图书信息？（Y/N）");
									choice22 = 'N';
									choice22 = input.next().charAt(0);
								} while (String.valueOf(choice22).equalsIgnoreCase(String.valueOf("Y")));
								writeObjectsToFile(books, Bfile);

								break;
							case 3:// 所有图书信息列表展示
									// 读取文件数据
								books = readObjectsFromFile(Bfile);
								// 读取的对象
								show.showbooks(books);
								System.out.println();// 换行
								
								char choice223;
								do {
									System.out.print("\n是否需要输出结果列表为txt？（Y/N）");
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
									System.out.print("输出完成。\n");
								}
								
								break;
							case 4:// 退出图书信息管理
								System.out.print("已退出图书信息管理。\n");
								break;
							}
						} while (function22 != 4);
						break;
					case 3:// 修改密码
						do {
							System.out.print("请输入原密码：");
							int rawPwd = input.nextInt();
							flag = (managers[search.admin2index(userName, managers)].getUsercode() == rawPwd) ? true
									: false;
							if (flag) {
								System.out.println("原密码正确！");
								break;
							}
							System.out.print("密码错误，请重新输入!\n");
						} while (flag == false);

						System.out.print("\n请输入新密码：");
						int newPwd = input.nextInt();
						managers[search.admin2index(userName, managers)].setUsercode(newPwd);
						System.out.print("新密码设定成功，请重新登录。\n");
						MwriteObjectsToFile(managers, Mfile);
						break;
					case 4:// 退出管理员登录
						writeObjectsToFile(books, Bfile);
						RwriteObjectsToFile(readers, Rfile);
						System.out.print("已退出登录。\n");
						break;
					}
				} while (function2 != 4);

				break;// 管理员函数部分退出
			}
		} while (choice != 1 && choice != 2);
	}
}
