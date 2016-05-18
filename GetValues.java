package grid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GetValues {
    private static String password = "12020210749343";
    private static String username = "root";
    
    private static String constring = "jdbc:mysql://localhost:3306/utility";
    private static Connection con;
    private static Statement st;
    private static ResultSet rs;
    
    private String AppName;
    private int Power;
    private int StartTime;
    private int Deadline;
    private int RunTime;
    
    public String getAppName() {
        return AppName;
    }
    public int getPower() {
        return Power;
    }
    public int getStartTime() {
        return StartTime;
    }
    public int getDeadline() {
        return Deadline;
    }
    public int getRunTime() {
        return RunTime;
    }
    
    public static String retAppName(){
        String appname = null;
        
        
        try {
            con = DriverManager.getConnection(constring,username,password); 
            st = con.createStatement();
            rs = st.executeQuery(" select appliancename from grid ");
            while (rs.next()) {
                    appname = rs.getString("appliancename");
            }
        }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        finally{
             if(st != null && con != null)
                try {
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
        }
        return appname;
        
    }
    
    public static int retPower(){
        int power = 0;
        
        
        try {
            con = DriverManager.getConnection(constring,username,password); 
            st = con.createStatement();
            rs = st.executeQuery(" select power from grid ");
            while (rs.next()) {
                    power = rs.getInt("power");
            }
        }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        finally{
             if(st != null && con != null)
                try {
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
        }
        return power;
    
    }
    
    public static int retStartTime(){
        int starttime = 0;
        
        
        try {
            con = DriverManager.getConnection(constring,username,password); 
            st = con.createStatement();
            rs = st.executeQuery(" select starttime from grid ");
            while (rs.next()) {
                    starttime = rs.getInt("starttime");
            }
        }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        finally{
             if(st != null && con != null)
                try {
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
        }
        return starttime;
        
    }
    
    
    public static int retDeadline(){
        int deadline = 0;
        
        
        try {
            con = DriverManager.getConnection(constring,username,password); 
            st = con.createStatement();
            rs = st.executeQuery(" select deadline from grid ");
            while (rs.next()) {
                    deadline = rs.getInt("deadline");
            }
        }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        finally{
             if(st != null && con != null)
                try {
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
        }
        return deadline;
        
    }
    
    public static int retRunTime(){
        int runtime = 0;
        
        
        try {
            con = DriverManager.getConnection(constring,username,password); 
            st = con.createStatement();
            rs = st.executeQuery(" select runtime from grid ");
            while (rs.next()) {
                    runtime = rs.getInt("runtime");
            }
        }
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        finally{
             if(st != null && con != null)
                try { 
                    st.close();
                    con.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } 
        }
        return runtime;
        
    }
    
    
    public static void main(String[] args) {
    	String appnamE = retAppName();
    	int poweR = retPower();
    	int starttimE = retStartTime();
    	int deadlinE = retDeadline();
    	int runtimE = retRunTime();
    	System.out.println("AppNAme " + appnamE);
    	System.out.println("Power " + poweR);
    	System.out.println("Start Time " + starttimE);
    	System.out.println("Deadline " + deadlinE);
    	System.out.println("RunTime " + runtimE);
	}
    
    
    
    
}