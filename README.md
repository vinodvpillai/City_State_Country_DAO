# City_State_Country_DAO
Accessing City-State-Country Data using DAO - MySQL

Classes:
• Country : id, Name, <ArrayList - State> 
• State: id, Name, Country Object, <ArrayList - City>
• City: id, Name, State Object

Database:
• Country : id(PK), Name
• State: id(PK), Name, Country id (FK)
• City: id(PK), Name, State id (FK)

Main Screen:

1. Manage  Country
	1.1 Create New Country
	1.2 Update Country
	1.3 Delete Country - If No States Available
	1.4 Search Country - Display All its State.
	1.5 Display All Country.
	1.7 Back
2. Manage State
	2.1 Create New State
	2.2 Update State
	2.3 Delete State - If No City Available
	2.4 Search State - Display All its City.
	2.5 Display All State.
	2.5 Back
3. Manage City
	3.1 Create New City
	3.2 Update City Details
	3.3 Delete City.
	3.4 Display All City.
	3.5 Back
0. Exit.
