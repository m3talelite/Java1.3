package Model;

public abstract class Book implements Comparable<Book> {
	
	private int id;
	private String name;
	private int year;
	private double price;
	
	public Book() { }
	
	public Book(int id, String name, int year, double price){
		this.id = id;
		this.name = name;
		this.year = year;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
				", name=" + name + 
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
			String title1 = obj.getName();
			String title2 = this.getName();
				return title1.compareTo(title2);			
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

}
