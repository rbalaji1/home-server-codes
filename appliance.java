package grid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

public class appliance {

	private int taskid;
	private String username;
	private String appliancename;
	private int power;
	private int starttime;
	private int currentstart;
	private int currentend;
	private int deadline;
	private int runtime;
	private int hsstarttime;
	private int jobcompleted;
	private double projectedcomp;
	private int powerconsumed;
	private String jobType;
	private int usstarttime;
	Random r = new Random();

	// private String[] names = { "r","t","a","b","c" };
	// private String[] aname = { "tv", "ac", "fridge", "oven", "dryer" };

	public appliance() {

		// this.taskid = t;
		// this.username = names[t];
	}

	private static String password = "12020210749343";
	private static String usrname = "root";
	private static String constring = "jdbc:mysql://localhost:3306/utility";
	private static String constring1 = "jdbc:mysql://192.168.1.5:3306/utility";
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;

	public String getUsername(int tid) {

		String uname = null;

		try {
			con = DriverManager.getConnection(constring, usrname, password);
			st = con.createStatement();
			rs = st.executeQuery(" select username from grid where taskid ="
					+ tid);
			while (rs.next()) {
				uname = rs.getString("username");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null && con != null)
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
			con = DriverManager.getConnection(constring, usrname, password);
			st = con.createStatement();
			rs = st.executeQuery(" select appliancename from grid where taskid ="
					+ tid);
			while (rs.next()) {
				aname = rs.getString("appliancename");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null && con != null)
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
			con = DriverManager.getConnection(constring, usrname, password);
			st = con.createStatement();
			rs = st.executeQuery(" select power from grid where taskid =" + tid);
			while (rs.next()) {
				p = rs.getInt("power");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null && con != null)
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

	public void setjobType(String jobType) {
		this.jobType = jobType;
	}

	public String getJobType() {
		return jobType;
	}

	public ArrayList<appliance> getdata(String uname) {

		// appliance a = new appliance();
		ArrayList<appliance> aparray = new ArrayList<appliance>();

		try {
			con = DriverManager.getConnection(constring, usrname, password);
			st = con.createStatement();
			rs = st.executeQuery(" select * from grid where username ='"
					+ uname + "'");
			while (rs.next()) {
				appliance a = new appliance();
				a.setAppliancename(rs.getString("appliancename"));
				a.setUsername(rs.getString("username"));
				a.setPower(rs.getInt("power"));
				a.setDeadline(rs.getInt("deadline"));
				a.setRuntime(rs.getInt("runtime"));
				a.setStarttime(rs.getInt("starttime"));
				a.setjobType(rs.getString("jobtype"));
				aparray.add(a);
				// System.out.println(a.getStarttime());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		// System.out.println(aparray.get(2).getStarttime());
		/*
		 * System.out.println("applaince check"); for(appliance x : aparray){
		 * System.out.println(x.getStarttime());
		 * 
		 * //System.out.println(start[i]); }
		 */
		return aparray;

	}

	public ArrayList<String> getStatus() {

		// appliance a = new appliance();
		int commit = 1;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> realnames = new ArrayList<String>();

		try {
			con = DriverManager.getConnection(constring, usrname, password);
			st = con.createStatement();
			rs = st.executeQuery(" select username from grid where commitstat ="
					+ commit);
			while (rs.next()) {

				names.add(rs.getString("username"));

				// System.out.println(a.getStarttime());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		// System.out.println(aparray.get(2).getStarttime());
		/*
		 * System.out.println("applaince check"); for(appliance x : aparray){
		 * System.out.println(x.getStarttime());
		 * 
		 * //System.out.println(start[i]); }
		 */

		for (int i = 0; i < names.size(); i++) {
			// b = true;
			if (i == 0)
				realnames.add(names.get(i));
			else {

				String m = names.get(i);
				if (!realnames.contains(m))
					realnames.add(m);

			}

		}
		
		
		return realnames;

	}

	public ArrayList<String> getallnames() {

		// appliance a = new appliance();
		int commit = 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> realnames = new ArrayList<String>();

		try {
			con = DriverManager.getConnection(constring, usrname, password);
			st = con.createStatement();
			rs = st.executeQuery(" select username from grid where commitstat = 0");
			while (rs.next()) {

				names.add(rs.getString("username"));

				// System.out.println(a.getStarttime());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (st != null && con != null)
				try {
					st.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

		boolean b;
		String x = "";
		// System.out.println(names.size());
		for (int i = 0; i < names.size(); i++) {
			// b = true;
			if (i == 0)
				realnames.add(names.get(i));
			else {

				String m = names.get(i);
				if (!realnames.contains(m))
					realnames.add(m);

			}

		}
		return realnames;

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

	public void putdata(int[] start, String[] uname, String[] app) {

		for (int i = 0; i < start.length; i++) {
			try {
				con = DriverManager.getConnection(constring, usrname, password);
				st = con.createStatement();
				st.executeUpdate(" UPDATE grid  SET hsstarttime=" + start[i]
						+ ", commitstat=0 WHERE username='" + uname[i]
						+ "' AND appliancename='" + app[i] + "'");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (st != null && con != null)
					try {
						st.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}

	}

	public void putdata1(int[] start, String[] uname, String[] app) {

		for (int i = 0; i < start.length; i++) {
			try {
				con = DriverManager
						.getConnection(constring1, usrname, password);
				System.out.println("Connection successful");
				st = con.createStatement();
				st.executeUpdate(" UPDATE grid  SET hsstarttime=" + start[i]
						+ ", commitstat=0 WHERE username='" + uname[i]
						+ "' AND appliancename='" + app[i] + "'");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (st != null && con != null)
					try {
						st.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}

	}

	public void putdata(int[] start, int[] end, String[] uname, String[] app) {

		for (int i = 0; i < start.length; i++) {
			try {
				con = DriverManager.getConnection(constring, usrname, password);
				st = con.createStatement();
				st.executeUpdate(" UPDATE grid  SET currentstart=" + start[i]
						+ ", currentend=" + end[i] + " WHERE username='"
						+ uname[i] + "' AND appliancename='" + app[i] + "'");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (st != null && con != null)
					try {
						st.close();
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}

	}

	public int getHsstarttime() {
		return hsstarttime;
	}

	public void setHsstarttime(int hsstarttime) {
		this.hsstarttime = hsstarttime;
	}

	public int getUsstarttime() {
		return usstarttime;
	}

	public void setUsstarttime(int usstarttime) {
		this.usstarttime = usstarttime;
	}

}
