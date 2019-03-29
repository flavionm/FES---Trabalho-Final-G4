package Model;

import java.sql.*;
class MysqlCon {
	public static void main(String args[]){  
		try{  
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/youaluga","root","Po2j3kSe96@#ki");
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from usuarios");  
		while(rs.next())  
//		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//		linha acima pega informa��es da tabela e printa
		con.close();  
		}catch(Exception e){ System.out.println(e);}  
	}  
}  
