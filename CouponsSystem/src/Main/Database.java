package Main;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {

	//********************************���� �������***********************************
	
	public static String getDriverData() {
		return "org.apache.derby.jdbc.ClientDriver";
	}
	
    //********************************���� ������,���� ����� �����********************
	
	public static String getDBUrl() {
		return "jdbc:derby://localhost:3301/JBDB;create=true";
	}
	
	//********************************Creating tables********************
	public static void createTables(Connection con) throws SQLException {
		String sql;
		
		
		//****************************************Creating Company table*************************************************

		try {
		Statement stmt = con.createStatement();
		
		sql = "create table Company ("
				+ "Id bigint not null primary key generated always as identity(start with 1, increment by 1), "
				+ "Comp_name varchar(50) not null, " + "Password varchar(50) not null, " + "Email varchar(50) not null)";
		stmt.executeUpdate(sql);
		System.out.println("success:" + sql);
		}catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		
		
		
		//****************************************Creating Customer table*************************************************
	
		try {
			Statement stmt = con.createStatement();

		sql = "create table Customer ("
				+ "Id bigint not null primary key generated always as identity(start with 1, increment by 1), "
				+ "Cust_name varchar(50) not null, " + "Password varchar(50) not null)";
		stmt.executeUpdate(sql);
		System.out.println("success:" + sql);
		}catch(SQLException e) {
			System.err.println(e.getMessage());
		}
		
		//****************************************Creating Coupon table*************************************************
        
		try {
    		Statement stmt = con.createStatement();

		sql = "create table Coupon ("
				+ "Id bigint not null primary key generated always as identity(start with 1, increment by 1), "
				+ "Title varchar(50) not null, " + "StartDate Date not null, "  + "EndDate Date not null, " + "Amount int not null, "  
				+ "Message varchar(50) not null, " + "Price double not null, " + "Image varchar(50) not null, " 
				+ "Type varchar(20) not null)";
		stmt.executeUpdate(sql);
		System.out.println("success:" + sql);
        }catch (SQLException e) {
        	System.err.println(e.getMessage());
        }		
	
		}
	}
