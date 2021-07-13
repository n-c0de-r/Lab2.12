import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to generate a list of names from a file.
 * 
 * @author	n-c0de-r
 * @author	AlexanderStae
 * @version	11.07.2021
 */
public class NameGenerator {

	/**
	 * Method to create the list of names.
	 * 
	 * @return	ArrayList of names.
	 */
	public ArrayList<String> getNames() {
		ArrayList<String> n = new ArrayList<>();
		
		File f = new File ("./streets.txt");
		Scanner s;
		try {
			s = new Scanner(f);
			while (s.hasNextLine()) {
				n.add(s.nextLine());
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	
}
