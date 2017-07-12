package data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import data.date2;

public class Book implements Serializable {
	// ������Ϣ
	private int bookID;// ͼ����
	private String bookName;// ����
	private double bookPrice;// ����
	private Date bookIndate = new Date(0, 0, 1);// ���ʱ��
	// ���α༭��Ϣ
	private String bookLoc;// ��ܱ��
	private int stock;// �ڹ�����
	// �����Ϣ
	private String bookState;// ͼ��״̬����� �ڹ�
	private int renewtimes;// ���������
	private int keeper;// ��Ŀǰ�����,0Ϊû�н��
	private Date Outdate;// ��������
	private Date Duedate;// Ӧ������
	// ���캯��

	public Book(int bookID, String name, double price) {
		// ������ݹ��췽��
		setBookID(bookID);
		setBookName(name);
		setBookPrice(price);
		setBookState("�ڹ�");// Ĭ���ڹ�
		setBookLoc("Z01");// �ݴ����

	}

	public Book() {
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		if (bookPrice < 0) {
			this.bookPrice = 0;
		} else {
			this.bookPrice = bookPrice;
		}
	}

	public String SgetBookIndate() {
		SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
		return d1.format(bookIndate);
	}

	public Date getBookIndate() {
		return bookIndate;
	}

	public void setBookIndate(int year, int month, int date) {
		bookIndate = new Date(year - 1900, month - 1, date);
	}

	public String getBookLoc() {
		return bookLoc;
	}

	public void setBookLoc(String bookLoc) {
		this.bookLoc = bookLoc;
	}

	public String getBookState() {
		return bookState;
	}

	public void setBookState(String bookState) {
		this.bookState = bookState;
	}

	public int getRenewtimes() {
		return renewtimes;
	}

	public void setRenewtimes(int renewtimes) {
		this.renewtimes = renewtimes;
	}

	public int getKeeper() {
		return keeper;
	}

	public void setKeeper(int keeper) {
		this.keeper = keeper;
	}

	public String SgetOutdate() {
		SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
		return d1.format(Outdate);
	}

	public Date getOutdate() {
		return Outdate;
	}

	public void setOutdate() {
		Outdate = new Date();
	}

	public String SgetDuedate() {
		SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
		return d1.format(Duedate);
	}

	public Date getDuedate() {
		return Duedate;
	}

	public void setDuedate() {
		Duedate = (Date) getOutdate().clone();
		date2 temp = new date2(Duedate.getYear() + 1900, Duedate.getMonth() + 1, Duedate.getDate());
		temp.next31Day();
		Duedate.setDate(temp.getDay());
		Duedate.setMonth(temp.getMonth() - 1);
		Duedate.setYear(temp.getYear() - 1900);
	}

	public void duedateRenew() {
		Duedate = (Date) getDuedate().clone();
		date2 temp = new date2(Duedate.getYear() + 1900, Duedate.getMonth() + 1, Duedate.getDate());
		temp.next31Day();
		Duedate.setDate(temp.getDay());
		Duedate.setMonth(temp.getMonth() - 1);
		Duedate.setYear(temp.getYear() - 1900);
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
