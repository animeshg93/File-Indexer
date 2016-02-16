import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Indexer{
	private static HashMap<String, Integer> map;
	public static void main(String[] args) throws FileNotFoundException{

		String filename = args[0];
		File file = new File(filename);				//opens the file specified by the command-line argument
		map = new HashMap<String, Integer>();

		//Will try and create a new Scanner for the specified file, if the file path is valid
		try{
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()){
				String word = scan.next();
				word=word.toLowerCase();				//gets the next word and converts that to lower case

				//if the map contains the word, increments its value by 1, else creates a new key-value pair
				if(map.containsKey(word)){
					map.put(word, map.get(word)+1);
				}
				else{
					map.put(word, 1);
				}
			}// wnd while
			scan.close();
		}// end try
		catch(Error e){
			e.printStackTrace();
		}

		int loop_limit = 10;
		String top_ten="Word     Encountered\n\n";

		//In the rare scenario that the map contains less than 10 pairs, the if statement will setle how many words to display
		if(map.size() < loop_limit)
			loop_limit = map.size();

		for(int i=0; i < loop_limit; i++){
			Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();

			int max = Collections.max(map.values());			//gets the max value in the Collection
			boolean found = false;								// a boolean value to stop looping once the required word has been found

			//keeps looping until the iterator exhausts itself, or until a match is found
			while(it.hasNext() && !found){
				Map.Entry<String, Integer> entry=it.next();		
				if(entry.getValue().equals(max)){

					//appends the necessary key and value to the top_ten string
					top_ten += String.format("%-13s", entry.getKey()+":").replace(' ',' ')+entry.getValue()+" times\n";
					found = true;
					it.remove();								// removes the parsed key-value pairing
				}//end if
			}// end while
		}// end for

		//Prints the final output
		System.out.println("\nThe top "+loop_limit+ " words are:\n\n"+top_ten);
	}
}