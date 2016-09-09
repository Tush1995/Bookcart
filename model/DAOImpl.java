package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DAOImpl implements DAOProvider
{
	static HashMap<String, Double> hm=new HashMap<>();
	@Override
	public String login(String uid) {
		// TODO Auto-generated method stub
		
		DBConnect db=new DBConnect();
		Connection con=db.connect();
		String unm=null;
		try{
		PreparedStatement ps=con.prepareStatement("select username from user where uid=?");
		ps.setString(1, uid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			 unm=rs.getString(1);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return unm;
	}

	@Override
	public HashMap<String, Book> select(String cate) {
		
		HashMap<String, Book> hm=new HashMap<>();
		DBConnect db=new DBConnect();
		Connection con=db.connect();
		try {
			PreparedStatement ps=con.prepareStatement("select * from book where category=?");
			ps.setString(1, cate);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Book b=new Book();
				b.setBid(rs.getString(1));
				b.setBname(rs.getString(2));
				b.setPrice(rs.getDouble(3));
				b.setBauthor(rs.getString(4));
				hm.put(b.getBid(),b);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return hm;
	}

	@Override
	public HashMap<String, Double> cart(String[] bids) {
		
		DBConnect db=new DBConnect();
		Connection con=db.connect();
		try {
			for(int i=0;i<bids.length;i++){
			PreparedStatement ps=con.prepareStatement("select bname,price from book where bid=?");
			ps.setString(1, bids[i]);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				hm.put(rs.getString(1), rs.getDouble(2));
			}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return hm;
	}

	@Override
	public HashMap<String, Double> Remove(String[] bids) {
	
		System.out.println(hm);
		for(int i=0;i<bids.length;i++){
		hm.remove(bids[i]);
		}
		return hm;
		
		
	}

}
