package grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class schedule {

	private int st;
	private int rt;
	private int dl;
	private double stprice;
	private int power;

	private double temp = 10000;
	private boolean frozen = false;
	private double de = 0.0;
	private double newcf = 0.0;
	private double totalcf = 0.0;
	
	private int in;
	private String jt;

	public double calcf(ArrayList<appliance> a, int[] start,
			HashMap<Integer, Double> p, int[] init) {

		totalcf = 0.0;
		 double addpenalty = 0 ;	
		    double penalty = 1;

		double[] cf = new double[a.size()];
		for (int i = 0; i < a.size(); i++) {
			cf[i] = 0.0;

			st = start[i];

			rt = a.get(i).getRuntime();

			dl = a.get(i).getDeadline();

			power = a.get(i).getPower();
			
			jt = a.get(i).getJobType();
			
			in = init[i];

			if(jt.equals("soft")){
				//System.out.println("Soft calculation");
				addpenalty =0 ;
				for (int j = 0; j < rt; j++) {
					// System.out.println(st);
					cf[i] = cf[i] + (p.get(st + (j * 100)) * power);

				}
				
				if( st >= in && st <= dl)
				{
					if(!((rt*100) < (dl- st)))
					{
						addpenalty = (((rt*100) - (dl - st))/100) * penalty;
					}
				}
				else if( st >= dl){
						addpenalty =  rt * penalty ;
				}
				
				
				cf[i] = cf[i] + addpenalty;
				//System.out.println(" cost function " + cf[i] + "  Penalty " + addpenalty +  "in" + in +" st "+ st +" dl "+ dl + " rt "+  rt);
			}
			else{
				//System.out.println("Hard calculation");

					for (int j = 0; j < rt; j++) {		
						// System.out.println(st);
						cf[i] = cf[i] + (p.get(st + (j * 100)) * power);
		
					}
			}
			totalcf = totalcf + cf[i];

		}

		return totalcf;

	}

	public int[] changesch(int[] start, int[] runt, int[] deadt, int[] init, String[] jobty) {

		Random r = new Random();
		int next = 0;
		int d = 0, rn = 0, s = 0, in = 0;
		int val = 0;
		int ran = 0;
		String jb ;

		for (int i = 0; i < start.length; i++) {
			s = start[i] / 100;
			in = init[i] / 100;

			rn = runt[i] / 100;

			d = deadt[i] / 100;
			jb = jobty[i];
			if(jb.equals("soft")){
				d = 24;  
			}

			val = d - rn + 1;
			// System.out.println(in + "    -    " +val);
			ran = (in + r.nextInt(val - in)) * 100;
			// System.out.println("    "+ran);

			start[i] = ran;
			// System.out.println(start[i]);

			val = 0;
		}

		return start;
	}

	public void comp(ArrayList<appliance> a, HashMap<Integer, Double> p) {

		int[] start = new int[a.size()];
		int[] runt = new int[a.size()];
		int[] deadt = new int[a.size()];
		int[] init = new int[a.size()];
		String[] app = new String[a.size()];
		String[] uname = new String[a.size()];
		
		int[] newstart = new int[a.size()];
		int[] best = new int[a.size()];
		int[] bests = new int[a.size()];
		int[] beste = new int[a.size()];
		String[] jobty = new String[a.size()];
		
		int loop = 0;
		double ex = 0.0;
		double ncf = 0.0;
		double cc = 0.0;
		int rand = 0;
		
		 temp = 10000;

		double bestc = 0.0;
		Random r = new Random();

		for (int i = 0; i < a.size(); i++) {
			start[i] = a.get(i).getStarttime();
			init[i] = a.get(i).getStarttime();
			newstart[i] = a.get(i).getStarttime();
			//System.out.println(newstart[i]);
			
			app[i] = a.get(i).getAppliancename();
			
			uname[i] = a.get(i).getUsername();

			runt[i] = a.get(i).getRuntime() * 100;
			deadt[i] = a.get(i).getDeadline();
			jobty[i] = a.get(i).getJobType();
		}

		cc = calcf(a, start, p, init);
		// System.out.println(cc);

		while (temp > 0.1) {
			for (int m = 0; m < 100; m++) {

				newstart = changesch(newstart, runt, deadt, init, jobty);
				
				
				
				ncf = calcf(a, newstart, p, init);

				de = ncf - cc;
				

				if (de < 0) {
					
					

					//System.out.println(ncf + "  -  "+cc + "  =   " + de);
					bests = newstart;
					cc = ncf;
					
				}
				/*else {
					
					ex = Math.exp(de / temp);
					rand = r.nextInt();
					//System.out.println(de + "  "+ temp + "  " + ex + "    -    " + rand + "     =   "+ cc);
					if (rand < ex) {
						best = newstart;
						cc = ncf;
					} else{
						best = best;
						cc = cc;
					}
					
				}*/
				loop++;

			}
			temp = temp-0.1;
			
		}

		for (int i = 0; i < bests.length; i++) {
			beste[i] = bests[i] + runt[i];
			//System.out.println(bests[i]);
		}
		appliance x = new appliance();
		//x.putdata(bests, beste, uname, app);
		System.out.println("here");
		x.putdata(bests, uname, app);
		//x.putdata1(bests, uname, app);
		
		System.out.println(loop);
		System.out.println(cc);
	}

}
