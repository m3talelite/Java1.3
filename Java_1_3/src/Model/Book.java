package Model;

import java.util.LinkedList;
import java.util.List;
import java.io.Serializable;

import com.google.common.collect.ComparisonChain;

public class Book implements Comparable<Book>, Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private int year;
	private double price;
	@SuppressWarnings("rawtypes")
	private List<Comparable> list = new LinkedList<Comparable>();
	
	public Book() { 
		list.add(SortIdComparable);
		list.add(SortTitleComparable);
		list.add(SortYearComparable);
		list.add(SortPriceComparable);		
	}
	
	public Book(int id, String title, int year, double price){
		this.id = id;
		this.title = title;
		this.year = year;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	//Sample of the toString() method;
	public String toString() {
		String tmp = "Book " +
				"[id=" + id + 
				", name=" + title + 
				", year=" + year+ 
				", price=" + price + "]";
		return tmp;
	}
	
	//Sample of the equals method
	//Should work great
	public boolean equals(Object obj){
		if (obj instanceof Book && ((Book) obj).getClass() == this.getClass())
			return true;
		return false;
	}
	
	/////////////////////////////////////////CLONE/////////////////////////////////////////
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	//////////////////////////////////////COMPARABLE//////////////////////////////////////	

	public Comparable<Book> SortIdComparable = new Comparable<Book>() {
		public int compareTo(Book obj) {
			int id1 = obj.getId();
			int id2 = Book.this.getId();
				return id1 - id2;
		}
	};
	
	public Comparable<Book> SortTitleComparable = new Comparable<Book>() {
		public int compareTo(Book obj) {
			String title1 = obj.getTitle();
			String title2 = Book.this.getTitle();
				return title1.compareTo(title2);			
		}
	};
	
	public Comparable<Book> SortYearComparable = new Comparable<Book>() {
		public int compareTo(Book o) {
			if (o.getYear() > Book.this.getYear()) 
				return 1;
			else if (o.getYear() < Book.this.getYear())
				return -1;
			else
				return 0;
		}
	};
	
	public Comparable<Book> SortPriceComparable = new Comparable<Book>() {
		public int compareTo(Book obj) {
			double price1 = obj.getPrice();
			double price2 = Book.this.getPrice();
				return Double.compare(price1,price2);
		}
	};
	
	@SuppressWarnings("rawtypes")
	public List<Comparable> getList() {
		return list;
	}

	//Aparte library van google!
	public int compareTo(Book o1) {

		Book book1 = (Book)o1;
		
		return ComparisonChain.start() 
				.compare(book1.getId(),this.getId())
				.compare(book1.getTitle(),this.getTitle())
				.compare(book1.getYear(),this.getYear())
				.compare(book1.getPrice(),this.getPrice())
				.result();
	}

}
