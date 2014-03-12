package Model;

public class Book {
	
	private int id;
	private String name;
	private int year;
	private float price;
	
	public Book(int id, String name, int year, float price){
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
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
}
