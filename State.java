/**
 * State
 * Created on March 9, 2017
 * @author Vinod Pillai <vinodthebest@gmail.com>
 * @version 1.0
 * 
 */
package com.vinod.citystate.model;

import java.util.ArrayList;
import java.util.Scanner;

public class State {

	private int id;
	private String name;
	private Country country = new Country();

	public ArrayList<City> citylist = new ArrayList<>();

	public State() {
		super();
	}

	public State(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public State(int id, String name, ArrayList<City> citylist) {
		super();
		this.id = id;
		this.name = name;
		this.citylist = citylist;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public ArrayList<City> getCitylist() {
		return citylist;
	}

	public void setCitylist(ArrayList<City> citylist) {
		this.citylist = citylist;
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
		if (!(obj instanceof State)) {
			return false;
		}
		if ((obj instanceof State)) {
			State state = (State) obj;
			if (this.getId() != state.getId()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Country Id:" + this.id + " Name:" + this.name;
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
		System.out.println("State Details:");
		System.out.println("ID:" + id);
		System.out.println("Name:" + name);
	}
}
