/**
 * CityDAO
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

public class CityDAO {

	public static boolean insert() {
		Scanner scanner = new Scanner(System.in);
		City city = new City();
		city.setData();

		ArrayList<State> statelist = StateDAO.getAllRecords();

		if (statelist.size() > 0) {
			for (State temp : statelist) {
				temp.display();
			}
		}

		// Get State ID
		System.out.println("Enter the State ID:");
		int state_id = scanner.nextInt();

		// Validate country ID - Exists
		State temp = StateDAO.getRecordById(state_id);
		if (temp != null) {

			// Database Insert Statement
			String sql = "insert into city values(" + city.getId() + ",'" + city.getName() + "'," + state_id + ")";

			return DatabaseOperation.updateDB(sql);
		}

		return false;

	}

	public static boolean update() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the City ID:");
		int id = scanner.nextInt();

		City city = getRecordById(id);

		if (city != null) {
			city.updateData();

			ArrayList<State> statelist = StateDAO.getAllRecords();

			if (statelist.size() > 0) {
				for (State temp : statelist) {
					temp.display();
				}

				// Get State ID
				System.out.println("Enter the State ID:");
				int state_id = scanner.nextInt();

				// Validate country ID - Exists
				State temp = StateDAO.getRecordById(state_id);
				if (temp != null) {
					// Database Insert Statement
					String sql = "update state set fullname='" + city.getName() + "',fk_state =" + state_id
							+ " where id=" + id;

					return DatabaseOperation.updateDB(sql);
				}
			}
		}
		return false;
	}

	public static boolean delete() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the City ID:");
		int id = scanner.nextInt();

		City city = getRecordById(id);

		if (city != null) {

			String sql = "delete from city where id=" + id;
			return DatabaseOperation.updateDB(sql);

		}
		return false;
	}

	public static City getRecordById(int id) {
		City city = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DatabaseOperation.DB_URL, DatabaseOperation.DB_USER,
					DatabaseOperation.DB_PASSWORD);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from city where id=" + id);
			while (rs.next()) {
				city = new City();
				city.setId(Integer.parseInt(rs.getString("id")));
				city.setName(rs.getString("fullname"));

				city.setState(StateDAO.getRecordById(Integer.parseInt(rs.getString("fk_state"))));
			}
			rs.close();
			stat.close();
			con.close();
			return city;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static ArrayList<City> getAllRecords() {

		ArrayList<City> list = new ArrayList<>();
		City city = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DatabaseOperation.DB_URL, DatabaseOperation.DB_USER,
					DatabaseOperation.DB_PASSWORD);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from city");
			while (rs.next()) {
				city = new City();
				city.setId(Integer.parseInt(rs.getString("id")));
				city.setName(rs.getString("fullname"));

				city.setState(StateDAO.getRecordById(Integer.parseInt(rs.getString("fk_state"))));
				list.add(city);
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

	public static ArrayList<City> getAllRecordsByState(int id) {

		ArrayList<City> list = new ArrayList<>();
		City city = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DatabaseOperation.DB_URL, DatabaseOperation.DB_USER,
					DatabaseOperation.DB_PASSWORD);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from city where fk_state=" + id);
			while (rs.next()) {
				city = new City();
				city.setId(Integer.parseInt(rs.getString("id")));
				city.setName(rs.getString("fullname"));

				city.setState(StateDAO.getRecordById(Integer.parseInt(rs.getString("fk_state"))));
				list.add(city);
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
