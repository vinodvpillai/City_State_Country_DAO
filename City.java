/**
 * City
 * Created on March 9, 2017
 * @author Vinod Pillai <vinodthebest@gmail.com>
 * @version 1.0
 * 
 */
package com.vinod.citystate.model;

import java.util.ArrayList;
import java.util.Scanner;

public class City {

	private int id;
	private String name;

	private State state = new State();

	public City() {
		super();
	}

	public City(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
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
		if ((obj instanceof City)) {
			City city = (City) obj;
			if (this.getId() != city.getId()) {
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
		System.out.println("City Details:");
		System.out.println("ID:" + id);
		System.out.println("Name:" + name);
	}
}
