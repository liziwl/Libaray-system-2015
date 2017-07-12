package reader;

import java.util.ArrayList;

import data.Book;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList< Book > books = new ArrayList< Book >();
		Book b1= new Book();
		books.add(b1);
		b1.setBookState("ÔÚ¹Ý");
		System.out.print(b1.getBookState());
		
	}

}