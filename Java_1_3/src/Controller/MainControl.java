package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Model.Book;


public class MainControl implements Comparable<Book>, Comparator{
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

	//TODO: make all these methods work
	public void addToList(Object obj){
		
	}
	
	public void addToMap(Object obj){
		
	}
	
	public void addToSet(Object obj){
		
	}
	
	public void deleteFromList(Object obj){
		
	}
	
	public void deleteFromMap(Object obj){
		
	}
	
	public void deleteFromSet(Object obj){
		
	}
	
	//////////////////////////////////////COMPARABLE//////////////////////////////////////
	
	public List<Book> getSortedComId() {
		Collections.sort(list);
		return list;
	}
	
	//////////////////////////////////////COMPARATOR//////////////////////////////////////
	
	@SuppressWarnings("unchecked")
	public List<Book> getSortedId() {
		Collections.sort(list,new ComparatorSort().SortIdComparator);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getSortedTitle() {
		Collections.sort(list,new ComparatorSort().SortTitleComparator);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> getSortedPrice() {
		Collections.sort(list,new ComparatorSort().SortPriceComparator);
		return list;
	}
	
	//Aparte library van google!	
	@SuppressWarnings("unchecked")
	public List<Book> getSortedList() {
		Collections.sort(list,new ComparatorSort());
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	public class ComparatorSort implements Comparator {
	
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

		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//Forced to do to avoid mergeconflicts
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}

		//Aparte library van google!
/*		@Override
		public int compare(Object o1, Object o2) {

			Book book1 = (Book)o1;
			Book book2 = (Book)o2;
			
			return ComparisonChain.start() 
					.compare(book1.getId(),book2.getId())
					.compare(book1.getTitle(),book2.getTitle())
					.compare(book1.getPrice(),book2.get

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}Price())
					.result();
		}
*/
	}
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!
	//DELETE THIS BELOW!!!!!!!!
	//!!!!!!!!!!!!!!!!!!!!!!!!!
	
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
 