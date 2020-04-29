package com.patroclos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {

		System.out.println("");
		Map<Integer, Object> names = new HashMap<Integer, Object>();
		names.put(1,"patroclos");
		names.put(2,"steve");
		System.out.println("List HashMap");
		names.forEach( (id,name) -> System.out.println(name));

		System.out.println("");
		names = new Hashtable<Integer, Object>();
		names.put(1,"patroclos");
		names.put(1,"steve");
		System.out.println("List HashTable");
		names.forEach( (id,name) -> System.out.println(name));

		System.out.println("");
		System.out.println("List HashSet");
		Set<Object> namesSet = new HashSet<Object>();
		namesSet.add("patroclos");
		namesSet.add("patroclos");
		namesSet.forEach( (name) -> System.out.println(name));

		System.out.println("");
		Map<Float, Object> namesTree = new TreeMap<Float, Object>();
		namesTree.put((float) 1.0,"patroclos");
		namesTree.put((float)2.0,"steve");
		namesTree.put((float)1.1,"patroclos2");
		namesTree.put((float)2.1,"steve2");
		namesTree.put((float)3.0,"john");
		namesTree.put((float)4.0,"mark");
		namesTree.put((float)4.1,"mark2");
		namesTree.put((float)4.2,"mark3");
		System.out.println("List TreeMap");
		namesTree.forEach( (id,name) -> {

			//leave space for inner numbering...
			String idString = id.toString();
			int idStringIndex = idString.indexOf(".");
			int spaceLength = Integer.parseInt(idString.substring(idStringIndex+1,idString.length()));
			for(int i=0;i<spaceLength;i++) {
				System.out.print(" ");
			}
			System.out.println(id + " -> " + name);
		}

				);



		System.out.println("");
		System.out.println("List LinkedList");
		List<Object> namesList = new LinkedList<Object>();
		namesList.add("patroclos");
		namesList.add("john");
		namesList.add("mark");
		namesList.forEach( (name) -> System.out.println(name));
		
		System.out.println("");
		System.out.println("List filtered LinkedList");
		List<Object> namesListFiltered =  namesList.stream()
				.filter(name -> name.equals("patroclos") == false )
				.collect(Collectors.toList());
		namesListFiltered.forEach( (name) -> System.out.println(name));
		
		System.out.println("");
		System.out.println("List mapped LinkedList");
		namesListFiltered =  namesList.stream()
				.map(name -> { 
					if(name.equals("patroclos")) { name += ".lemon"; }
					return name; 
				} 
						)
				.collect(Collectors.toList());
		namesListFiltered.forEach( (name) -> System.out.println(name));
		
		
		
		System.out.println("");
		System.out.println("List sorted array of numbers");
		List<Integer> numbers = Arrays.asList(0,5,6,2,1,1,6);
		numbers = numbers.stream().sorted().collect(Collectors.toList());
		numbers.forEach( (number) -> System.out.println(number));
		
		System.out.println("");
		System.out.println("List sorted array/remove duplicate numbers");
		numbers = numbers.stream().sorted().distinct().collect(Collectors.toList());
		numbers.forEach( (number) -> System.out.println(number));
		
	}

}
