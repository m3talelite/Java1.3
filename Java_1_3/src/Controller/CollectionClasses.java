package Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionClasses {
	private List<Object> list;
	private Map<Object, List<Object>> map;
	private Set<Object> set;
	
	private static CollectionClasses collclass;
	
	private CollectionClasses(){
		
	}
	//*-----------------------------------------------------*\\
	// Singleton object for the collectionClasses 	`		 \\
	//making it impossible to make two objects of this kind  \\
	//*-----------------------------------------------------*\\
	public static CollectionClasses getInstance(){
		if (collclass == null)
			collclass = new CollectionClasses();
		return collclass;
	}

	//Getters and setters, toString and equals//
	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

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
}
 