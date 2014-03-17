package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ComparisonChain;

import Model.Book;

public class MainControl {
	private List<Book> list;
	private Map<Object, List<Object>> map;
	private Set<Object> set;
	
	public MainControl(){
		System.out.println("init of the main controller");
		init();
	}

	private void init(){
		list = new ArrayList<Book>();
	// TODO: initialize the rest of the lists
		
	}
	public static void readTextFile(){
		
	}

	public static void writeTextFile(){

	}
	
	public static void readObjectFile(){
		
	}
	
	public static void writeObjectFile(){
		
	}
	
	//Getters and setters, toString and equals//
	public Map<Object, List<Object>> getMap() {
		return map;
	}

	public void setMap(Map<Object, List<Object>> map) {
		this.map = map;
	}

	public Set<Object> getSet() {
		return set;
	}

	public void setSet(Set<Object> set) {
		this.set = set;
	}

	//////////////////////////////////////TERMINAL//////////////////////////////////////
	@SuppressWarnings("unchecked")
	public void print() {
	
		//Voegt boeken toe aan list.
		list.add(new Book(1,"Harry Potter en de Vuurbeker", 2000, 15.00));
		list.add(new Book(2,"De aanslag", 1982, 10.00));
		list.add(new Book(3,"De zwarte dood", 2003, 5.00));
		list.add(new Book(4,"Hoe overleef ik het jaar 2000", 1999, 7.50));
		
		//Comparable
		System.out.println("java.lang.Comparable:");
		getSortedListComparable();
		
		//Google library
		System.out.println("Google:");
		getSortedListComparableGoogle();
		
		//Comparator
		System.out.println("java.util.Comparator:");
		getSortedListComparator();
		
		//Google library
		System.out.println("Google:");
		getSortedListComparatorGoogle();
		
		//Clone
		try {
			for(int i = 0; i < list.size(); i++) {
				Book cloned = (Book) list.get(i).clone();
				System.out.println(">> " + cloned.getId());
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
	
	//////////////////////////////////////COMPARABLE//////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	public void getSortedListComparable() {
		for(Book book1 : list) {
			Collections.sort(book1.getList());
			for(Book book2 : list)
				System.out.println(book2.getId() + " - " + book2.getTitle() + " - " + book2.getYear() + " - " + book2.getPrice());
		System.out.println("-----------------------------------------------------");
		}
	}
	
	public void getSortedListComparableGoogle() {
		Collections.sort(list);
		for(Book book : list)
			System.out.println(book.getId() + " - " + book.getTitle() + " - " + book.getYear() + " - " + book.getPrice());	
		System.out.println("-----------------------------------------------------");
	}
	
	//////////////////////////////////////COMPARATOR//////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	public void getSortedListComparator() {
	    ComparatorSort comparatorSort = new ComparatorSort();
		for(int i = 0; i < comparatorSort.getList().size(); i++) {
			Collections.sort(list,comparatorSort.getList().get(i));
			for(Book book : list)
				System.out.println(book.getId() + " - " + book.getTitle() + " - " + book.getYear() + " - " + book.getPrice());
			System.out.println("-----------------------------------------------------");
		}
	}
	
	@SuppressWarnings("unchecked")
	public void getSortedListComparatorGoogle() {
		Collections.sort(list,new ComparatorSort());
		for(Book book : list)
			System.out.println(book.getId() + " - " + book.getTitle() + " - " + book.getYear() + " - " + book.getPrice());	
		System.out.println("-----------------------------------------------------");
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
				double price1 = ((Book)obj1).getPrice();
				double price2 = ((Book)obj2).getPrice();
				return Double.compare(price1,price2);
			}
		};
		
		public List<Comparator> getList() {
			return list;
		}

		//Aparte library van google!
		public int compare(Object o1, Object o2) {

			Book book1 = (Book)o1;
			Book book2 = (Book)o2;
			
			return ComparisonChain.start() 
					.compare(book1.getId(),book2.getId())
					.compare(book1.getTitle(),book2.getTitle())
					.compare(book1.getYear(), book2.getYear())
					.compare(book1.getPrice(),book2.getPrice())
					.compare(book1.getPrice(),book2.getPrice())
					.result();
		}
	}
}
 