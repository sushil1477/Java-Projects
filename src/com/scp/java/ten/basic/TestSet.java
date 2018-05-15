 package com.scp.java.ten.basic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TestSet {

	public static void main(String[] args) {
		Vehicle v1 = new Vehicle(20,"fdjkxzZ","R1sdas31A");
		Vehicle v2 = new Vehicle(140,"gfkxkjYZ","R1fasd31A");
		Vehicle v3 = new Vehicle(150,"faetaYZ","R131czxA");
		Vehicle v4 = new Vehicle(2110,"faseYZ","R131Afds");
		Vehicle v5 = new Vehicle(130,"sadaYZ","R131Aczxcz");
		
		
		
		
		TreeSet<Vehicle> t = new TreeSet<>();//natural
		t.add(v1);
		t.add(v2);
		t.add(v3);
		t.add(v4);
		t.add(v5);
		
		//ClassCastExcection -- If your domain object doesnt implement comparable
		//In treeset you can add only thoes objects which we can sort -- ultimately you
		//should have either comparable or comparator
		
		TreeSet<Vehicle> t1 = new TreeSet<>(new RegNoSort());//
		
		
		System.out.println("treeset elements =" +t);
		
		List<Vehicle> vechileList = new ArrayList<>();
		
		vechileList.add(v1);
		vechileList.add(v2);
		vechileList.add(v3);
		vechileList.add(v4);
		vechileList.add(v5);
		System.out.println(vechileList);
		
		Collections.sort(vechileList,new RegNoSort());
	
		System.out.println("\n\n -- "+vechileList);
		/*Field[] fields = v.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getName());
		}
		
*/	}
}


class RegNoSort implements Comparator<Vehicle>{

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		System.out.println("compare method");
		return o1.getRegNumber().compareTo(o2.getRegNumber());
	}
	
}


class Vehicle implements Comparable<Vehicle>{
	private int vechileId;
	private String vName;
	private String regNumber;

	public Vehicle(int vechileId, String vName, String regNumber) {
		super();
		this.vechileId = vechileId;
		this.vName = vName;
		this.regNumber = regNumber;
	}
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\n Vehicle [vechileId=" + vechileId + ", vName=" + vName + ", regNumber=" + regNumber + "]";
	}
	public int getVechileId() {
		return vechileId;
	}
	public void setVechileId(int vechileId) {
		this.vechileId = vechileId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	@Override
	public int compareTo(Vehicle o) {
		return this.regNumber.compareTo(o.regNumber);
	}
	
	
	/**
	 * bean Vs POJO
	 * 
	 * POJO Plain old java object -- Class which doesnt implement or extend any other 
	 * interface of class respectively... and holds only member fields along with 
	 * their getter setters
	 * 
	 * Bean -- can do + member fields + getter setter
	 * 
	 * Bean can be a POJO but vice versa is not true....
	 * 
	 * 
	 * Why Getter setters--
	 *  if your members fields are not private then fields can be directly accessible 
	 *  and we cannot add validation logic if we want as there is no single entry point
	 *  however if we provide getter setters and mark all fields as private then 
	 *  there is single entry to read/write and so you can add validation logic
	 * 
	 * 
	 */
	
}
