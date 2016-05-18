
/*create the table */
package grid;

import java.sql.*;


public class database {
	 
	private static String password = "12020210749343";
	private static String username = "root";
	
	private static String constring = "jdbc:mysql://localhost:3306/utility";
	private static Connection con;
	private static Statement st;
	
	
	
	public static void main(String[] args){
		
		try {
			
			con = DriverManager.getConnection(constring,username,password);
			st = con.createStatement();
			//st.execute("create database package");
			st.execute("use utility");
			st.execute("create table gridnew (taskid INT(11) PRIMARY KEY AUTO_INCREMENT, username VARCHAR(20), appliancename VARCHAR(20), power INT(11), starttime INT(11), currentstart INT(10), currentend INT(10), deadline INT(10), runtime INT(11), jobcompleted INT(11), jobtype VARCHAR(20), hsstarttime INT(11), usstarttime INT(11), projectedcompletion FLOAT(11), powerconsumed INT(11), committime DATETIME NOT NULL DEFAULT NOW(), commitstat INT(3), utilitycommit INT(3))");
			//st.execute("UPDATE packages SET destination =" + a + " WHERE source = 'CA'" );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
