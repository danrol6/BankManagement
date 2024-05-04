package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.entities.User;
import com.utilities.DbCon;

public class UsersDao implements DaoInterface<User> {
	private static String TABLE = "Users";
	
	public ArrayList<User> findAll() {
		Connection con = DbCon.getConnection();
		ArrayList<User> users = new ArrayList<User>();
		
		try {
			String sql = "select * from " +TABLE;
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setRole(rs.getString(6));
				user.setLastLogin(rs.getTimestamp(7));
				
				users.add(user);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return users;
	}

	public User findById(int id) {
		Connection con = DbCon.getConnection();
		User user = new User();
		
		try {
			String sql = "select * from " +TABLE+" where user_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				user.setRole(rs.getString(6));
				user.setLastLogin(rs.getTimestamp(7));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return user;
	}

	public void update(User obj) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "update " + TABLE + 
					" set username=?, password=?, first_name=?, last_name=?, "
					+ "role=?, last_login=? where user_id=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, obj.getUsername());
			ps.setString(2, obj.getPassword());
			ps.setString(3, obj.getFirstName());
			ps.setString(4, obj.getLastName());
			ps.setString(5, obj.getRole());
			ps.setTimestamp(6, obj.getLastLogin());
			ps.setInt(7, obj.getUserId());
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}
	
	public User save(User obj) {
	Connection con = DbCon.getConnection();
		
		try {
			String qry = "insert into " + TABLE + 
					" (user_id, username, password, first_name, last_name, role, last_login) "
					+ "values (?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, obj.getUserId());
			ps.setString(2, obj.getUsername());
			ps.setString(3, obj.getPassword());
			ps.setString(4, obj.getFirstName());
			ps.setString(5, obj.getLastName());
			ps.setString(6, obj.getRole());
			ps.setTimestamp(7, obj.getLastLogin());
			
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
		return obj;
	}

	public void delete(int id) {
		Connection con = DbCon.getConnection();
		
		try {
			String qry = "delete from " + TABLE + " where user_id=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setInt(1, id);
			
			ps.executeQuery();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}
	}
	
	public boolean checkDatabase(String username, String password) {
		Connection con = DbCon.getConnection();
		int count = 0;
		
		try {
			String qry = "select count(*) from " + TABLE + " where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}	
		
		if(count >= 1) {
			return true;
		}
		return false;
	}
	
	public String getRole(String username, String password) {
		Connection con = DbCon.getConnection();
		String role = "";
		
		try {
			String qry = "select role from " + TABLE + " where username=? and password=?";
			PreparedStatement ps = con.prepareStatement(qry);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				role = rs.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DbCon.closeConnection();
		}	
		
		return role;
	}

}
