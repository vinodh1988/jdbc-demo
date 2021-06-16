package com.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadOperation {
   public static void main(String n[]) {
		Connection connection = SqlServerConnection.getConnection();
    	try {
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from sampe");
			ResultSetMetaData metadata =rs.getMetaData();
			byte c=(byte)metadata.getColumnCount();
			for(int i=1;i<=c;i++) {
				System.out.printf("%20s",metadata.getColumnName(i));
			}
			System.out.println("\n_____________________________________________________________________________________________");
			while(rs.next()) {
				System.out.printf("\n%20d %25s %25s",rs.getInt(1),rs.getString(2),rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }
}
