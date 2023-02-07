package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student 
{
	private static final String url="jdbc:mysql://localhost:3306/jdbc";
	private static final String username="root";
	private static final String password="Revanth@1234";
	
	private static Statement s=null;
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	
	public static void Creating() 
	{
	
		try {
			
			// load Driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// establish connection 
			con=DriverManager.getConnection(url,username,password);
			//prepare sql statement
			s=con.createStatement();
			s.executeUpdate("create table student(sno int primary key auto_increment, sname varchar(40),sub varchar(50),email varchar(40))");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(s!=null) {
					s.close();
				}
				if(con!=null)
					con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void inserting(String name,String sub,String email ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 
		con=DriverManager.getConnection(url, username, password);
		ps=con.prepareStatement("insert into student(sname ,sub, email)values(?,?,?)");
		ps.setString(1,name);
		ps.setString(2, sub);
		ps.setString(3, email);
		ps.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
			
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void update(int sno,String sub,String email ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		 
		con=DriverManager.getConnection(url, username, password);
		ps=con.prepareStatement("update student set email=?, sub=? where sno=?");
		ps.setInt(3,sno);
		ps.setString(2, sub);
		ps.setString(1, email);
		ps.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
			
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void deleting(int sno)  
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection(url, username, password);
		ps=con.prepareStatement("delete from student where sno=?");
		ps.setInt(1, sno);
		ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			
			try {
				if(ps!=null)
					ps.close();
				if(con!=null)
					con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	public static void Read() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			s=con.createStatement();
			rs=s.executeQuery("select *from student");
			while(rs.next()) {
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("sub"));
				System.out.println(rs.getString("email"));
				System.out.println("*     **      *");
			}
			
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
				if(s!=null)
					s.close();
				if(con!=null)
					con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}