package Model;

import java.io.Serializable;

public class Book implements Comparable<Book>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private int year;
	private double price;
	
	public Book() { }
	
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
		
		System.out.println(tmp);
		return tmp;
	}
	
	//Sample of the equals method
	//Should work great
	public boolean equals(Object obj){
		if (obj instanceof Book && ((Book) obj).getClass() == this.getClass())
			return true;
		return false;
	}
	
	//////////////////////////////////////COMPARABLE//////////////////////////////////////	
	
	/*
	 * 
	 * De onderstaande methodes laten verschillende manieren van sortering zien.
	 * Het is aan jouw zelf te bepalen welke van deze methodes je wilt gaan gebruiken. 
	 * Houd er rekening mee dat ieder zijn voor- en nadelen heeft.
	 * 
	 */
	
	@SuppressWarnings("rawtypes")
	public Comparable SortIdComparable = new Book() {
		public int compareTo(Book obj) {
			int id1 = obj.getId();
			int id2 = this.getId();
				return id1 - id2;
		}
	};
	
	@SuppressWarnings("rawtypes")
	public Comparable SortTitleComparable = new Book() {
		public int compareTo(Book obj) {
			String title1 = obj.getTitle();
			String title2 = this.getTitle();
				return title1.compareTo(title2);			
		}
	};
	
	@SuppressWarnings("rawtypes")
	public Comparable SortYearComparable = new Book() {
		public int compareTo(Book o) {
			if (o.getYear() > this.getYear()) 
				return 1;
			else if (o.getYear() < this.getYear())
				return -1;
			else
				return 0;
		}
	};
	
	@SuppressWarnings("rawtypes")
	public Comparable SortPriceComparable = new Book() {
		public int compareTo(Book obj) {
			double price1 = obj.getPrice();
			double price2 = this.getPrice();
				return Double.compare(price1,price2);
		}
	};

	@Override
	public int compareTo(Book arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
