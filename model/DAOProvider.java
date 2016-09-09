package model;

import java.util.HashMap;

public interface DAOProvider
{
	String DRIVER="com.mysql.jdbc.Driver";
	String URL="jdbc:mysql://localhost:3306/tushar";
	String USERNAME="root";
	String PASSWORD="root";
	String login(String uid);
	HashMap<String, Book>select(String cate);
	HashMap<String, Double> cart(String bids[]);
	public HashMap<String, Double> Remove(String[] bids);
}
