package grid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.sql.*;


public class populate {
	
	
	private int taskid;
	private String username;
	private String appliancename;
	private int power;
	private int starttime;
	private int currentstart;
	private int currentend;
	private int deadline;
	private int runtime;
	private int jobcompleted;
	private double projectedcomp;
	private int powerconsumed;
	private String jobType;
	Random r = new Random();
	
	private String[] first = {"a","b","c","d","e","f","g","h","i","j"};

	private String[] second = {"l","m","n","o","p","q","r","s","t","u"};
	
	
	private String[] n = {"t", "t", "t", "t","t","r","r","r","r","r","th","th","th","th","th","b","b","b","b","b","g","g","g","g","g",};
	private String[] an = {"tv", "fridge", "washer", "dryer", "oven", "tv", "fridge", "washer", "dryer", "oven","tv", "fridge", "washer", "dryer", "oven","tv", "fridge", "washer", "dryer", "oven","tv", "fridge", "washer", "dryer", "oven"};
	private String[] jtype = {"hard", "soft"};
	
	//private String[] names = { "r","t","a","b","c" };
	//private String[] aname = { "tv", "ac", "fridge", "oven", "dryer" };
	
	
	
	public populate(){
		
		//this.taskid = t;
		//this.username = names[t];	
	}
	
	
	
	private static String password = "12020210749343";
	private static String usrname = "root";
	private static String constring = "jdbc:mysql://localhost:3306/utility";
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	
	
	
	
	
public String getJobtype(int tid) {
		
		String jtype = null;
		
		
		try {
			con = DriverManager.getConnection(constring,usrname,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select jobtype from grid where taskid =" + tid);
			while (rs.next()) {
					jtype = rs.getString("jobtype");
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
		return jtype;
		
	}
	
	
	
	
	public String getUsername(int tid) {
		
		String uname = null;
		
		
		try {
			con = DriverManager.getConnection(constring,usrname,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select username from grid where taskid =" + tid);
			while (rs.next()) {
					uname = rs.getString("username");
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
		return uname;
		
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAppliancename(int tid) {
		String aname = null;
		
		
		try {
			con = DriverManager.getConnection(constring,usrname,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select appliancename from grid where taskid =" + tid);
			while (rs.next()) {
					aname = rs.getString("appliancename");
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
		return aname;
	}
	
	
	public void setAppliancename(String appliancename) {
		this.appliancename = appliancename;
	}
	
	
	public int getPower(int tid) {
		int p = 0;
		
		
		try {
			con = DriverManager.getConnection(constring,usrname,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select power from grid where taskid =" + tid);
			while (rs.next()) {
					p = rs.getInt("power");
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
		return p;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	
public ArrayList<appliance> getdata(String uname) {
	
	//appliance a = new appliance();
	ArrayList<appliance> aparray = new ArrayList<appliance>(); 
		
		try {
			con = DriverManager.getConnection(constring,usrname,password); 
			st = con.createStatement();
			rs = st.executeQuery(" select * from grid where username ='" + uname+"'");
			while (rs.next()) {
					appliance a = new appliance();
					a.setPower(rs.getInt("power"));
					a.setDeadline(rs.getInt("deadline"));
					a.setRuntime(rs.getInt("runtime"));
					a.setStarttime(rs.getInt("starttime"));
					a.setjobType(rs.getString("jobtype"));
					aparray.add(a);
					//System.out.println(a.getStarttime());
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
		
		//System.out.println(aparray.get(2).getStarttime());
		/*System.out.println("applaince check");
		for(appliance x : aparray){
			System.out.println(x.getStarttime());
			
			//System.out.println(start[i]);
    	}
		*/
		return aparray;
		
	}
	
	
	
	
	public int getStarttime() {
		return starttime;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	public String getAppliancename() {
		return appliancename;
	}
	public void setStarttime(int startime) {
		this.starttime = startime;
	}
	public int getDeadline() {
		return deadline;
	}
	public void setDeadline(int deadline) {
		this.deadline = deadline;
	}
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	public int getJobcompleted() {
		return jobcompleted;
	}
	public void setJobcompleted(int jobcompleted) {
		this.jobcompleted = jobcompleted;
	}
	public double getProjectedcomp() {
		return projectedcomp;
	}
	public void setProjectedcomp(double projectedcomp) {
		this.projectedcomp = projectedcomp;
	}
	public int getPowerconsumed() {
		return powerconsumed;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setPowerconsumed(int powerconsumed) {
		this.powerconsumed = powerconsumed;
	}
	
	public String getJobtype() {
		return jobType;
	}
	
	public void setjobType(String jobType) {
		this.jobType = jobType;
	}
	
	
	
	
	
	public populate(int i){
		Random r = new Random();

		this.username = first[r.nextInt(10)]+second[r.nextInt(10)];
		
		
		int  j = 0;
		j = i%25;
		this.appliancename = an[j];
		
		
		
		this.starttime = (r.nextInt(15) + 1) *100;
		this .runtime = (r.nextInt(5) + 1);
		this.deadline = starttime + (runtime*100) + ((r.nextInt(4)+1)*100);
		
		System.out.println(this.appliancename);
		this.power = (r.nextInt(10) + 1);
		this.jobType = jtype[(r.nextInt(2))];
		
	
	}
	

	
	
	public static void main(String[] args){
		
		for(int i=0; i<1000; i++){
			populate a = new populate(i);
		try {
			
			con = DriverManager.getConnection(constring,usrname,password);
			st = con.createStatement();
			//st.execute("create database package");
			st.execute("use utility");st.execute("INSERT INTO gridnew (username, appliancename, power, starttime, runtime, deadline , jobtype ) VALUES ('"+a.getUsername()+"', '"+a.getAppliancename()+"', "+a.getPower()+", "+a.getStarttime()+", "+a.getRuntime()+", "+a.getDeadline()+", '"+a.getJobtype()+"')");//st.execute("UPDATE packages SET destination =" + a + " WHERE source = 'CA'" );
			
		} catch (SQLException e) {
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
		
		
		/*try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
	}


	public int getCurrentstart() {
		return currentstart;
	}


	public void setCurrentstart(int currentstart) {
		this.currentstart = currentstart;
	}


	public int getCurrentend() {
		return currentend;
	}


	public void setCurrentend(int currentend) {
		this.currentend = currentend;
	}

	
	
	

}
