package data;

import java.io.Serializable;

public class Reader implements Serializable{
	private int ID;//ѧ��&���鿨��
	private String Name;//����
	private String Gender;//�Ա�
	private int keepingbooks;//�ѽ�ͼ����������2��
	private int[] bookIndex = new int[5];
	private int password;//����
	//���캯��
	public Reader(){}
	public Reader(String name,String gender,int id){
		setName(name);
		setGender(gender);
		setID(id);
		setKeepingbooks(0);
		//Ĭ�������趨
		String code =Integer.toString(id);
		String password;
		if(code.length()>=6){// �ж��Ƿ񳤶ȴ��ڵ���6
			password =code.substring(code.length()- 6);//һ��������ʾ��ȡ���ݵ����֮��Ĳ���
		}
		else
			password=Integer.toString(id);
		setPassword(Integer.parseInt(password));
	}
	
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public int[] getBookIndex() {
		return bookIndex;
	}
	public void setBookIndex(int[] bookIndex) {
		this.bookIndex = bookIndex;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getKeepingbooks() {
		return keepingbooks;
	}
	public void setKeepingbooks(int keepingbooks) {
		this.keepingbooks = keepingbooks;
	}
	
}
