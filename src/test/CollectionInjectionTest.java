package test;


import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.CollectionInjection;
import model.Person;

public class CollectionInjectionTest {
	
	public static void main(String[] args) {
		
		
		ApplicationContext context=new ClassPathXmlApplicationContext("test/collection-injection-xml.xml");
		
		CollectionInjection colinject=(CollectionInjection)context.getBean("collectionId" , CollectionInjection.class);
		
		List<String> myList=colinject.getMyList();
		List<Person> myPerson=colinject.getMyPerson();
		Set<Integer> mySet=colinject.getMySet();
		Map<String, Object> myMap = colinject.getMyMap();
		Properties myProperties = colinject.getMyProperties();
		
		System.out.println("myList element:");
		for (String element : myList) {
			System.out.println(element);
		}
		
		System.out.println("myPerson elements : ");
		for (Person element : myPerson) {
			System.out.println(element);
		}
		
		System.out.println("mySet elements : ");
		for (Integer element : mySet) {
			System.out.println(element);
		}
		
		
		System.out.println("myMap elements : ");
		for (Object element : myMap.keySet()) {
			System.out.println(myMap.get(element));
		}
		
		
		System.out.println("myProperties elements : ");
		for (Map.Entry<Object, Object> entry : myProperties.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		((ClassPathXmlApplicationContext) context).close();
		
	}
	
	

}
