package com.skywalker.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ProblemStatement5Q1 {

	public List<String> allies;
	public String output;
	public String king;
	Map<String,String> messages;	
	public static final String AIR = "owl";
	public static final String WATER = "octopus";
	public static final String LAND = "panda";
	public static final String ICE = "mammoth";
	public static final String FIRE = "dragon";



	public ProblemStatement5Q1() {
		super();
		this.allies = new ArrayList<String>();
		this.king = "None";
		this.output = "None";
		this.messages = new HashMap<String,String>();
	}


	public void printAllies() {
		for(String ally:this.allies) {
			System.out.println(ally+",");
		}

	}

	public void printQuestion() {
		System.out.println("Who is the ruler of Southeros?");
		System.out.println("Output: "+ this.king);
		System.out.println("Allies of Ruler?");
		System.out.println("Output: "+ this.output);
	}
	public void getInputMessages() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number of kingdoms you want to send message");
		int count = Integer.parseInt(sc.nextLine().trim()); 
		while(count>0) {
			System.out.print("Input: ");
			count-- ;
			String[] a = sc.nextLine().split(",");
			if(a.length==2) {
				this.messages.put(a[0].trim(), a[1].trim());
			}
		}
		sc.close();
	}

	public void printInput() {
		Set<String> keys = this.messages.keySet();
		for(String key:keys) {
			System.out.println(this.messages.get(key));

		}
	}

	private Map<Character,Integer> getKingdom(String kingdom){
		Map<Character,Integer> map = new TreeMap<Character,Integer>();
		char[]arr = kingdom.toCharArray();
		for(int i=0;i<arr.length;i++) {
			if(map.containsKey(arr[i]))
				map.put(arr[i], map.get(arr[i])+1);
			else
				map.put(arr[i], 1);
		}
		return map;
	}


	private boolean CheckMessage(String emblemSymbol,String messages) {
		switch(emblemSymbol.toUpperCase()) {
		case "AIR":
			emblemSymbol = AIR;
			break;
		case "WATER":
			emblemSymbol = WATER;
			break;
		case "ICE":
			emblemSymbol = ICE;
			break;
		case "FIRE":
			emblemSymbol = FIRE;
			break;
		case "LAND":
			emblemSymbol = LAND;
			break;
		}
		Map<Character,Integer> message = getKingdom(messages);
		Map<Character,Integer> emblem = getKingdom(emblemSymbol);
		Set<Character> emblemKeys = emblem.keySet();
		for(char key:emblemKeys) {
			if(emblem.get(key)>message.get(key)) {
				return false;
			}
		}
		return true;
	}

	private void findAllies(Map<String,String>message) {
		Set<String> keys = this.messages.keySet();
		for(String key:keys) {
			if(CheckMessage(key.toUpperCase(),message.get(key).toLowerCase())) {
				this.allies.add(key);
			}
		}
		if(this.allies.size()>2) {
			this.king = "King Shan";
			this.output = getAllies();
		}
	}
	
	private String getAllies() {
		StringBuilder sb = new StringBuilder();
		Iterator<String> itr = this.allies.iterator();
		while(itr.hasNext()) {
			sb.append(itr.next()+",");
		}
		return sb.toString();
	}

	public static void main(String[] args) {

		ProblemStatement5Q1 object = new ProblemStatement5Q1();
		object.printQuestion();
		System.out.println("\n");
		object.getInputMessages();
		/*System.out.println("+++++++++++++++++");
		object.printInput();*/
		object.findAllies(object.messages);
		//object.printAllies();
		System.out.println();
		object.printQuestion();
	}

}
