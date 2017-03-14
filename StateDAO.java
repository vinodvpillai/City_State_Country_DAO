/**
 * StateDAO
 * Created on March 9, 2017
 * @author Vinod Pillai <vinodthebest@gmail.com>
 * @version 1.0
 * 
 */
package com.vinod.citystate.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.vinod.citystate.db.DatabaseOperation;
import com.vinod.citystate.model.City;
import com.vinod.citystate.model.Country;
import com.vinod.citystate.model.State;

public class StateDAO {

	public static boolean insert() {
		State state = new State();
		state.setData();
		
		Scanner scanner = new Scanner(System.in);
		// Database Insert Statement
		
		ArrayList<Country> countrylist = CountryDAO.getAllRecords();

		if (countrylist.size() > 0) {
			for (Country temp : countrylist) {
				temp.display();
			}

			// Get Country ID
			System.out.println("Enter the Country ID:");
			int country_id = scanner.nextInt();

			// Validate country ID - Exists
			Country country = CountryDAO.getRecordById(country_id);
			if (country != null) {
				// Database Insert Statement
				
				String sql = "insert into state values(" + state.getId() + ",'" + state.getName() + "',"+ country_id+")";

				
				return DatabaseOperation.updateDB(sql);
			}
		}
		return false;
	}

	public static boolean update() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the State ID:");
		int id = scanner.nextInt();

		State state = getRecordById(id);

		if (state != null) {
			state.updateData();

			ArrayList<Country> countrylist = CountryDAO.getAllRecords();

			if (countrylist.size() > 0) {
				for (Country temp : countrylist) {
					temp.display();
				}

				// Get Country ID
				System.out.println("Enter the Country ID:");
				int country_id = scanner.nextInt();

				// Validate country ID - Exists
				Country country = CountryDAO.getRecordById(country_id);
				if (country != null) {
					// Database Insert Statement
					String sql = "update state set fullname='" + state.getName() + "',fk_country=" + country_id
							+ " where id=" + id;

					return DatabaseOperation.updateDB(sql);
				}
			}
		}
		return false;
	}
	
	public static boolean delete() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the State ID:");
		int id = scanner.nextInt();

		State state = getRecordById(id);

		if (state != null) {
			ArrayList<City> citylist = CityDAO.getAllRecordsByState(id);
			if (citylist.size() > 0) {
				return false;
			} else {
				// Database Update Statement
				String sql = "delete from state where id=" + id;

				return DatabaseOperation.updateDB(sql);
			}

			
		}
		return false;
	}

	public static State getRecordById(int id) {
		State state = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DatabaseOperation.DB_URL, DatabaseOperation.DB_USER,
					DatabaseOperation.DB_PASSWORD);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from state where id=" + id);
			while (rs.next()) {
				state = new State();
				state.setId(Integer.parseInt(rs.getString("id")));
				state.setName(rs.getString("fullname"));

				state.setCountry(CountryDAO.getRecordById(Integer.parseInt(rs.getString("fk_country"))));
			}
			rs.close();
			stat.close();
			con.close();
			return state;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static ArrayList<State> getAllRecords() {

		ArrayList<State> list = new ArrayList<>();
		State state = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DatabaseOperation.DB_URL, DatabaseOperation.DB_USER,
					DatabaseOperation.DB_PASSWORD);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from state");
			while (rs.next()) {
				state = new State();
				state.setId(Integer.parseInt(rs.getString("id")));
				state.setName(rs.getString("fullname"));
				state.setCountry(CountryDAO.getRecordById(Integer.parseInt(rs.getString("fk_country"))));
				list.add(state);

			}
			rs.close();
			stat.close();
			con.close();
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static ArrayList<State> getAllRecordsByCountry(int id) {

		ArrayList<State> list = new ArrayList<>();
		State state = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DatabaseOperation.DB_URL, DatabaseOperation.DB_USER,
					DatabaseOperation.DB_PASSWORD);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from state where fk_country="+id);
			while (rs.next()) {
				state = new State();
				state.setId(Integer.parseInt(rs.getString("id")));
				state.setName(rs.getString("fullname"));
				state.setCountry(CountryDAO.getRecordById(Integer.parseInt(rs.getString("fk_country"))));
				list.add(state);

			}
			rs.close();
			stat.close();
			con.close();
			return list;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
