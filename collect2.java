package grid;

import java.util.ArrayList;
import java.util.HashMap;

public class collect2 {

	
    
    public static void main(String[] args) {
    	
    	int itterations = 0;
    	    	
    	schedule sch = new schedule();
    	
    	appliance app = new appliance();
    	readfile p = new readfile();
    	ArrayList<String> names = new ArrayList<String>();
    	
    	names = app.getallnames();
    	ArrayList<appliance> aparray = new ArrayList<appliance>();
    	ArrayList<appliance> aparray1 = new ArrayList<appliance>();
    	HashMap<Integer, Double> price = new HashMap<Integer, Double>();
    	System.out.println(names.size());
    	/*for(int i=0; i<names.size() ; i++){
    		System.out.println(names.get(i));
    			aparray = app.getdata(names.get(i));
        		aparray1 = aparray;
        		price = p.run();
        		sch.comp(aparray, price);
    	//aparray = app.getdata("g");
    		//aparray1 = aparray;
    		//price = p.run();
    		//sch.comp(aparray, price);
    
    		
    	}*/
    	
    	itterations++;
    	System.out.println("Number of itterations = " + itterations);


	}
    
    
	
	
	
}
