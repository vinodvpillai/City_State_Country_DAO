/**
 * DatabaseOperation
 * Created on March 9, 2017
 * @author Vinod Pillai <vinodthebest@gmail.com>
 * @version 1.0
 * 
 */
package com.vinod.citystate.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseOperation {

	public static final String DB_URL = "jdbc:mysql://localhost/citystate_db";
	public static final String DB_USER = "root";
	public static final String DB_PASSWORD = "admin";

	public static boolean updateDB(String sql) {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

			Statement stat = con.createStatement();

			int rel = stat.executeUpdate(sql);

			if (rel >= 1) {
				System.out.println("\n Database Updated");
				return true;
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	
}
