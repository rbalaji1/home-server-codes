package grid;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class readfile{

  public static void main(String[] args) {

	readfile obj = new readfile();
	obj.run();

  }

  public HashMap<Integer, Double> run() {

	String csvFile = "/Users/ragav2/Downloads/20151122-da.csv";
	BufferedReader br = null;
	String line = "";
	ArrayList<String> keya = new ArrayList<String>();
	String[] key = new String[26];
	String[] value = new String[26];
	HashMap<Integer, Double> price = new HashMap<Integer, Double>();
	int j;
	

	try {

		br = new BufferedReader(new FileReader(csvFile));
		for(int i=0; i<4; i++){
			String txt = br.readLine();
			//System.out.println(txt);
			if(i == 2)
				key = txt.split(",");
			if(i == 3)
				value = txt.split(",");
		}
		
		for(int i=1; i<25; i++){

			price.put(Integer.parseInt(key[i]), Double.parseDouble(value[i]));
			
		}
		
		

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	return price;
  }

}