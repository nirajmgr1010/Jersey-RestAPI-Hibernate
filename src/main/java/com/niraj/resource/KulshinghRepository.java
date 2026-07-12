package com.niraj.resource;

import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class KulshinghRepository {

	Connection con = null;
	
	
	public KulshinghRepository() {
		String url = "jdbc:mysql://localhost:3306/restdb";
		String username = "root";
		String password ="password";
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<Kulshingh> getKulshinghs(){
		List<Kulshingh> kulshingh = new ArrayList<>();
		
		
		String sql = "select *from kulshingh";
		try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			Kulshingh k = new Kulshingh();
			k.setId(rs.getInt(1));
			k.setName(rs.getString(2));
			k.setPoint(rs.getInt(3));
			
			kulshingh.add(k);
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return kulshingh;
	}
	
	public Kulshingh getKulshingh(int id) {
		
		Kulshingh k = new Kulshingh();
		String sql = "select *from kulshingh where id="+id;
		try {
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		if(rs.next()) {
			
			k.setId(rs.getInt(1));
			k.setName(rs.getString(2));
			k.setPoint(rs.getInt(3));
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
	
	public void create(Kulshingh k) {
		
		String sql = "insert into kulshingh values(?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, k.getId());
			st.setString(2, k.getName());
			st.setInt(3, k.getPoint());
			
			st.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
public void Update(Kulshingh k) {
		
	String sql = "UPDATE kulshingh SET name=?, point=? WHERE id=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, k.getName());
			st.setInt(2, k.getPoint());
			st.setInt(3, k.getId());
			
			st.executeUpdate();
			
			}catch(Exception e) {
				e.printStackTrace();
			}
	}


public void delete(int id) {
	
	String sql = "DELETE from kulshingh WHERE id=?";
	try {
		PreparedStatement st = con.prepareStatement(sql);
	    st.setInt(1, id);
		st.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
}
}
