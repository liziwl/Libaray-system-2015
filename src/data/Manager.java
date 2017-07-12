package data;

import java.io.Serializable;

public class Manager implements Serializable {
	private String userName = "";
	private int usercode;

	public Manager() {
	}

	public Manager(String name, int pwd) {
		setUserName(name);
		setUsercode(pwd);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUsercode() {
		return usercode;
	}

	public void setUsercode(int usercode) {
		this.usercode = usercode;
	}

	

}
