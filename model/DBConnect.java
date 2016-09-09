package model;

import java.sql.Connection;
import java.sql.DriverManager;

import static model.DAOProvider.*;

public class DBConnect 
{
	Connection con=null;
Connection connect()
{
	try {
		Class.forName(DRIVER);
		System.out.println("Driver Loaded");
		con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("Connected");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	
}

}
