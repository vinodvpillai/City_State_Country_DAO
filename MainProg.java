/**
 * MainProg
 * Created on March 9, 2017
 * @author Vinod Pillai <vinodthebest@gmail.com>
 * @version 1.0
 * 
 */
package com.vinod.citystate.main;

import java.util.ArrayList;
import java.util.Scanner;

import com.vinod.citystate.dao.CityDAO;
import com.vinod.citystate.dao.CountryDAO;
import com.vinod.citystate.dao.StateDAO;
import com.vinod.citystate.model.City;
import com.vinod.citystate.model.Country;
import com.vinod.citystate.model.State;

public class MainProg {

	public static void main(String[] args) {

		int operation;

		int countryoperation;
		int stateoperation;
		int cityoperation;

		int countryback = 0;
		int stateback = 0;
		int cityback = 0;

		int id = 0;

		Scanner scanner = new Scanner(System.in);

		while (true) {

			System.out.println("1. Manage Country");
			System.out.println("2. Manage State");
			System.out.println("3. Manage City");

			System.out.println("0. Exit");

			System.out.println("Select the Operation:");
			operation = scanner.nextInt();

			switch (operation) {
			case 1:
				countryback = 0;
				countryoperation = 0;
				while (true) {
					System.out.println("1. Add Country");
					System.out.println("2. Update Country");
					System.out.println("3. Remove Country - ID");
					System.out.println("4. Search Country - ID - All States");
					System.out.println("5. Display all Country");
					System.out.println("0. Back to Main Menu");

					System.out.println("Select the Operation:");
					countryoperation = scanner.nextInt();

					switch (countryoperation) {
					case 1:
						if (!(CountryDAO.insert())) {
							System.out.println("Sorry Error occured please try agian later");
						}

						break;
					case 2:
						// Update
						if (!(CountryDAO.update())) {
							System.out.println("Sorry Error occured please try agian later");
						}
						break;
					case 3:
						// Remove
						if (!(CountryDAO.delete())) {
							System.out.println("Sorry Error occured please try agian later");
						}

						break;
					case 4:
						System.out.println("Enter the Country ID:");
						id = scanner.nextInt();
						ArrayList<State> statelist = StateDAO.getAllRecordsByCountry(id);

						for (State obj : statelist) {
							obj.display();
						}
						break;

					case 5:
						ArrayList<Country> listval = CountryDAO.getAllRecords();

						for (Country obj : listval) {
							obj.display();
						}
						break;

					case 0:
						countryback = 1;
						break;
					default:
						break;
					}

					if (countryback == 1) {
						break;

					}
				}
				break;

			case 2:
				stateoperation = 0;
				stateback = 0;
				while (true) {
					System.out.println("1. Add State");
					System.out.println("2. Update State");
					System.out.println("3. Remove State - ID");
					System.out.println("4. Search State - Display All City");
					System.out.println("5. Display all State");
					System.out.println("0. Back to Main Menu");

					System.out.println("Select the Operation:");
					stateoperation = scanner.nextInt();

					switch (stateoperation) {
					case 1:
						// Insert
						if (!(StateDAO.insert())) {
							System.out.println("Sorry Error occured please try agian later");
						}
						break;
					case 2:
						// Update
						if (!(StateDAO.update())) {
							System.out.println("Sorry Error occured please try agian later");
						}
						break;
					case 3:
						// Delete
						if (!(StateDAO.delete())) {
							System.out.println("Sorry Error occured please try agian later");
						}
						break;
					case 4:
						// Display all City
						System.out.println("Enter the State ID:");
						id = scanner.nextInt();
						
						ArrayList<City> citylist = CityDAO.getAllRecordsByState(id);

						for (City obj : citylist) {
							obj.display();
						}
						break;
					case 5:
						// Display all State
						
						ArrayList<State> statelist = StateDAO.getAllRecords();

						for (State state : statelist) {
							state.display();
						}

						break;
					case 0:
						stateback = 1;
						break;
					default:
						break;
					}

					if (stateback == 1) {
						break;

					}
				}
				break;
			case 3:
				cityback = 0;
				cityoperation = 0;
				while (true) {
					System.out.println("1. Add City");
					System.out.println("2. Update City");
					System.out.println("3. Remove City - ID");
					System.out.println("4. Display all City");
					System.out.println("0. Back to Main Menu");

					System.out.println("Select the Operation:");
					countryoperation = scanner.nextInt();

					switch (countryoperation) {
					case 1:
						if (!(CityDAO.insert())) {
							System.out.println("Sorry Error occured please try agian later");
						}

						break;
					case 2:
						// Update
						if (!(CityDAO.update())) {
							System.out.println("Sorry Error occured please try agian later");
						}
						break;
					case 3:
						// Remove
						if (!(CityDAO.delete())) {
							System.out.println("Sorry Error occured please try agian later");
						}

						break;
					case 4:
						ArrayList<City> citylist = CityDAO.getAllRecords();

						for (City obj : citylist) {
							obj.display();
						}
						break;

					case 0:
						cityback = 1;
						break;
					default:
						break;
					}

					if (cityback == 1) {
						break;

					}
				}
				break;

			case 0:
				System.exit(0);
			}

		}
	}
}
