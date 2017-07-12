package data;

import java.io.Serializable;

public class Reader implements Serializable{
	private int ID;//学号&借书卡号
	private String Name;//姓名
	private String Gender;//性别
	private int keepingbooks;//已借图书数，最多借2本
	private int[] bookIndex = new int[5];
	private int password;//密码
	//构造函数
	public Reader(){}
	public Reader(String name,String gender,int id){
		setName(name);
		setGender(gender);
		setID(id);
		setKeepingbooks(0);
		//默认密码设定
		String code =Integer.toString(id);
		String password;
		if(code.length()>=6){// 判断是否长度大于等于6
			password =code.substring(code.length()- 6);//一个参数表示截取传递的序号之后的部分
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
