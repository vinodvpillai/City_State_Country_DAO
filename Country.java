/**
 * Country
 * Created on March 9, 2017
 * @author Vinod Pillai <vinodthebest@gmail.com>
 * @version 1.0
 * 
 */
package com.vinod.citystate.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Country {

	private int id;
	private String name;

	public ArrayList<State> statelist = new ArrayList<>();

	public Country() {
		super();
	}

	public Country(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Country(int id, String name, ArrayList<State> statelist) {
		super();
		this.id = id;
		this.name = name;
		this.statelist = statelist;
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

	public ArrayList<State> getStatelist() {
		return statelist;
	}

	public void setStatelist(ArrayList<State> statelist) {
		this.statelist = statelist;
	}

	@Override
	public int hashCode() {
		
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Country)) {
			return false;
		}
		if ((obj instanceof Country)) {
			Country country = (Country) obj;
			if (this.getId() != country.getId()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Country Id:"+this.id+" Name:"+this.name;
	}

	public void setData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the ID:");
		this.id = scanner.nextInt();
		System.out.println("Enter the Name:");
		this.name = scanner.next();
	}
	
	public void updateData() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Name:");
		this.name = scanner.next();
	}

	public void display() {
		System.out.println("Country Details:");
		System.out.println("ID:" + id);
		System.out.println("Name:" + name);
	}
}
