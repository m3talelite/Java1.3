package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import Model.Book;

import com.google.common.collect.ComparisonChain;

public class MainControl{
	private List<Book> list;
	private Map<Integer, Book> map;
	private Set<Object> set;

	public MainControl() {
		System.out.println("init of the main controller");
		init();
	}

	private void init() {
		list = readTextFileList();
		map = readTextFileMap("Boekenlijst.txt");
		
		
		writeTextFile("Booklist.txt", list);
		
		//not working as it should
		writeObjectFile("Booklist.ob");
		
		//Print the List, Map
		printList();
		printMap();
	}

	public List<Book> readTextFileList() {
		List<Book> tempList = new LinkedList<Book>();
		File file = new File("Boekenlijst.txt");
		FileInputStream inputStream;
		BufferedReader bufferedReader;
		try {
			inputStream = new FileInputStream(file);
			bufferedReader = new BufferedReader(new InputStreamReader(
					inputStream));

			String lineInfo;
			while ((lineInfo = bufferedReader.readLine()) != null) {
				String[] trimmingStr = lineInfo.split("-");
				tempList.add(new Book(Integer.parseInt(trimmingStr[0]),
						trimmingStr[1], Integer.parseInt(trimmingStr[2]),
						Double.parseDouble(trimmingStr[3])));
			}
			bufferedReader.close();
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
		return tempList;
	}
	
	public Map<Integer, Book> readTextFileMap(String filePath){
		Map<Integer, Book> tempMap = new TreeMap<Integer, Book>();
		File file = new File(filePath);
		FileInputStream inputStream;
		BufferedReader bufferedReader;
		try {
			inputStream = new FileInputStream(file);
			bufferedReader = new BufferedReader(new InputStreamReader(
					inputStream));

			String lineInfo;
			while ((lineInfo = bufferedReader.readLine()) != null) {
				String[] trimmingStr = lineInfo.split("-");
				tempMap.put(
						Integer.parseInt(trimmingStr[0]), 
						new Book(trimmingStr[1],
								Integer.parseInt(trimmingStr[2]), 
								 Double.parseDouble(trimmingStr[3])));
			}
			bufferedReader.close();
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
		
		return tempMap;
	}

	public void writeTextFile(String filePath, List<Book> ls) {
		File file = new File(filePath);
		FileOutputStream outputStream;
		BufferedWriter writer;
		try {
			outputStream = new FileOutputStream(file);
			writer = new BufferedWriter(new OutputStreamWriter(outputStream));
			for (Book obj : ls) {
				writer.write(obj.toString());
				writer.newLine();
			}
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public Object readObjectFile() {
		Object obj = null;
		
		return obj;
	}

	public void writeObjectFile(String filePath) {
		File file = new File(filePath);
		FileOutputStream outputStream;
		ObjectOutputStream objOutputStream;
		try {
			outputStream = new FileOutputStream(file);
			objOutputStream = new ObjectOutputStream(outputStream);
			for (Book obj : list){
				objOutputStream.writeObject(obj);
			}
			objOutputStream.close();
			
			System.out.println("Written object file");
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}

	// Getters and setters, toString and equals//
	public Map<Integer, Book> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Book> map) {
		this.map = map;
	}

	public Set<Object> getSet() {
		return set;
	}

	public void setSet(Set<Object> set) {
		this.set = set;
	}

	public void printList() {
		System.out.println("-----------------------------------------------------");
		for (Book obj : list) 
			System.out.println(obj.toString());
		System.out.println("-----------------------------------------------------");
	}
	
	public void printMap(){
		System.out.println("-----------------------------------------------------");
		for (Map.Entry<Integer, Book> obj : map.entrySet())
			System.out.println("id: " + obj.getKey() + "Book: " + obj.getValue().toString());
		System.out.println("-----------------------------------------------------");
	}

	// ////////////////////////////////////TERMINAL//////////////////////////////////////
	@SuppressWarnings("unchecked")
	public void print() {

		// Voegt boeken toe aan list.
		list.add(new Book(1, "Harry Potter en de Vuurbeker", 2000, 15.00));
		list.add(new Book(2, "De aanslag", 1982, 10.00));
		list.add(new Book(3, "De zwarte dood", 2003, 5.00));
		list.add(new Book(4, "De zwarte dood", 2003, 5.00));
		list.add(new Book(5, "Hoe overleef ik het jaar 2000", 1999, 2.50));

		// Comparable
		System.out.println("java.lang.Comparable:");
		getSortedListComparable();

		// Google library
		System.out.println("Google:");
		getSortedListComparableGoogle();

		// Comparator
		System.out.println("java.util.Comparator:");
		getSortedListComparator();

		// Google library
		System.out.println("Google:");
		getSortedListComparatorGoogle();

		// Clone
		try {
			for (int i = 0; i < list.size(); i++) {
				Book cloned = (Book) list.get(i).clone();
				System.out.println(">> " + cloned.getId());
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		// Algoritme
		for (Book book : getReverseList()) {
			System.out.println(book.getTitle());
		}

		System.out.println(getTotalPrice());

		for (Book book : getBooks('D')) {
			System.out.println(book.getTitle());
		}

		for (Book book : getBooksOnYears(1982)) {
			System.out.println(book.getTitle());
		}

		for (Book book : getAllUniqueBooks()) {
			System.out.println(".." + book.getTitle());
		}

		System.out.println("Max price: " + getMaxPrice());
		System.out.println("Min price: " + getMinPrice());

	}

	// ////////////////////////////////////ALGORITME//////////////////////////////////////

	// Toont de omgekeerde volgorde.
	public List<Book> getReverseList() {
		List<Book> newList = new ArrayList<Book>();
		for (int i = list.size() - 1; i > -1; i--) {
			newList.add(list.get(i));
		}
		return newList;
	}

	// Toont het totaal bedrag van de boeken.
	public Double getTotalPrice() {
		double price = 0.0;
		for (int i = 0; i < list.size(); i++) {
			price += list.get(i).getPrice();
		}
		return price;
	}

	// Toont alle boeken op begin letter.
	public List<Book> getBooks(char letter) {
		List<Book> newList = new ArrayList<Book>();
		for (int i = 0; i < list.size(); i++) {
			String element = list.get(i).getTitle();
			for (int j = 0; j < element.length(); j++) {
				char character = element.charAt(j);
				if (character == letter) {
					newList.add(list.get(i));
				}
				break;
			}
		}
		return newList;
	}

	// Toont alle boeken op jaartal.
	public List<Book> getBooksOnYears(int year) {
		List<Book> newList = new ArrayList<Book>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getYear() == year) {
				newList.add(list.get(i));
			}
		}
		return newList;
	}

	// Toont alle unieke boeken.
	public List<Book> getAllUniqueBooks() {
		List<Book> newList = new ArrayList<Book>();
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			String title = list.get(i).getTitle();
			for (int j = 0; j < list.size(); j++) {
				if (title.equals(list.get(j).getTitle())) {
					count++;
				}
			}
			if (count < 2) {
				newList.add(list.get(i));
			}
			count = 0;
		}
		return newList;
	}

	// Toont de hoogste prijs.
	public Double getMaxPrice() {
		double price = 0.0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPrice() > price) {
				price = list.get(i).getPrice();
			}
		}
		return price;
	}

	// Toont de laagste prijs.
	public Double getMinPrice() {
		double price = getMaxPrice();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getPrice() < price) {
				price = list.get(i).getPrice();
			}
		}
		return price;
	}

	// ////////////////////////////////////COMPARABLE//////////////////////////////////////

	@SuppressWarnings("unchecked")
	public void getSortedListComparable() {
		for (Book book1 : list) {
			Collections.sort(book1.getList());
			for (Book book2 : list)
				System.out.println(book2.getId() + " - " + book2.getTitle()
						+ " - " + book2.getYear() + " - " + book2.getPrice());
			System.out
					.println("-----------------------------------------------------");
		}
	}

	public void getSortedListComparableGoogle() {
		Collections.sort(list);
		for (Book book : list)
			System.out.println(book.getId() + " - " + book.getTitle() + " - "
					+ book.getYear() + " - " + book.getPrice());
		System.out
				.println("-----------------------------------------------------");
	}

	// ////////////////////////////////////COMPARATOR//////////////////////////////////////

	@SuppressWarnings("unchecked")
	public void getSortedListComparator() {
		ComparatorSort comparatorSort = new ComparatorSort();
		for (int i = 0; i < comparatorSort.getList().size(); i++) {
			Collections.sort(list, comparatorSort.getList().get(i));
			for (Book book : list)
				System.out.println(book.getId() + " - " + book.getTitle()
						+ " - " + book.getYear() + " - " + book.getPrice());
			System.out
					.println("-----------------------------------------------------");
		}
	}

	@SuppressWarnings("unchecked")
	public void getSortedListComparatorGoogle() {
		Collections.sort(list, new ComparatorSort());
		for (Book book : list)
			System.out.println(book.getId() + " - " + book.getTitle() + " - "
					+ book.getYear() + " - " + book.getPrice());
		System.out
				.println("-----------------------------------------------------");
	}

	@SuppressWarnings("rawtypes")
	public class ComparatorSort implements Comparator {

		private List<Comparator> list = new LinkedList<Comparator>();

		public ComparatorSort() {
			list.add(SortIdComparator);
			list.add(SortTitleComparator);
			list.add(SortYearComparator);
			list.add(SortPriceComparator);
		}

		public Comparator SortIdComparator = new Comparator() {
			public int compare(Object obj1, Object obj2) {
				int id1 = ((Book) obj1).getId();
				int id2 = ((Book) obj2).getId();
				return id1 > id2 ? 1 : id1 < id2 ? -1 : 0;
			}
		};

		public Comparator SortTitleComparator = new Comparator() {
			public int compare(Object obj1, Object obj2) {
				String title1 = ((Book) obj1).getTitle();
				String title2 = ((Book) obj2).getTitle();
				return title1.compareTo(title2);
			}
		};

		public Comparator SortYearComparator = new Comparator() {
			public int compare(Object obj1, Object obj2) {
				int year1 = ((Book) obj1).getYear();
				int year2 = ((Book) obj2).getYear();
				return year1 - year2;
			}
		};

		public Comparator SortPriceComparator = new Comparator() {
			public int compare(Object obj1, Object obj2) {
				double price1 = ((Book) obj1).getPrice();
				double price2 = ((Book) obj2).getPrice();
				return Double.compare(price1, price2);
			}
		};

		public List<Comparator> getList() {
			return list;
		}

		// Aparte library van google!
		public int compare(Object o1, Object o2) {

			Book book1 = (Book) o1;
			Book book2 = (Book) o2;

			return ComparisonChain.start()
					.compare(book1.getId(), book2.getId())
					.compare(book1.getTitle(), book2.getTitle())
					.compare(book1.getYear(), book2.getYear())
					.compare(book1.getPrice(), book2.getPrice())
					.compare(book1.getPrice(), book2.getPrice()).result();
		}
	}
}
