/**
 * CountryDAO
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
import com.vinod.citystate.model.Country;
import com.vinod.citystate.model.State;

public class CountryDAO {

	public static boolean insert() {
		Country country = new Country();
		country.setData();
		// Database Insert Statement
		String sql = "insert into country values(" + country.getId() + ",'" + country.getName() + "')";

		return DatabaseOperation.updateDB(sql);
	}

	public static boolean update() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Country ID:");
		int id = scanner.nextInt();

		Country country = getRecordById(id);

		if (country != null) {
			country.updateData();
			// Database Update Statement
			String sql = "update country set fullname='" + country.getName() + "' where id=" + id;

			return DatabaseOperation.updateDB(sql);
		}

		return false;
	}

	public static boolean delete() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Country ID:");
		int id = scanner.nextInt();

		Country country = getRecordById(id);

		if (country != null) {

			ArrayList<State> statelist = StateDAO.getAllRecordsByCountry(id);
			if (statelist.size() > 0) {
				return false;
			} else {
				// Database Update Statement
				String sql = "delete from country where id=" + id;

				return DatabaseOperation.updateDB(sql);
			}
		}

		return false;
	}

	public static Country getRecordById(int id) {
		Country country = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DatabaseOperation.DB_URL, DatabaseOperation.DB_USER,
					DatabaseOperation.DB_PASSWORD);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from country where id=" + id);
			while (rs.next()) {
				country = new Country();
				country.setId(Integer.parseInt(rs.getString("id")));
				country.setName(rs.getString("fullname"));
			}
			rs.close();
			stat.close();
			con.close();
			return country;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static ArrayList<Country> getAllRecords() {

		ArrayList<Country> list = new ArrayList<>();
		Country country = null;
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DatabaseOperation.DB_URL, DatabaseOperation.DB_USER,
					DatabaseOperation.DB_PASSWORD);
			Statement stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from country");
			while (rs.next()) {
				country = new Country();
				country.setId(Integer.parseInt(rs.getString("id")));
				country.setName(rs.getString("fullname"));

				list.add(country);

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
