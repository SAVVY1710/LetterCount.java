import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *	Counts the frequency of letters in a file and produces a histogram.
 *
 *	@author	Sai Avula
 *	@since	7/4/2024
 */

public class LetterCount {

	Scanner input;
	String fileName;
	int[]lettercounter;
	
	// Fields go here, all must be private
	/* Constructor */							
	public LetterCount() 
	{
		lettercounter = new int[26];
		fileName = "";
		input = null;

	}
	
	/* Main routine */
	public static void main(String[] args) {
		LetterCount lc = new LetterCount();
		if (args.length != 1)
			System.out.println("Usage: java LetterCount <inputFile>");
		else
			lc.run(args);
	}
	
	/**	The core program of the class, it
	 *	- opens the input file
	 *	- reads the file and counts the letters
	 *	- closes the input file
	 *	- prints the histogram of the letter count
	 */
	public void run(String[] args) {
		fileName = args[0];
		tryCatchIt();
		while(input.hasNext())
		{
			String temp = input.next();
			for(int i = 0; i < temp.length(); i++)
			{
				System.out.println(temp.charAt(i));
			}
		}
		input.close();
	}
	public void tryCatchIt()
    {
        File inFile = new File (fileName);
        //value = "";
        input = null;
        try
        {
            input = new Scanner ( inFile );
        }
        catch ( FileNotFoundException e )
        {
            System.err.println("Cannot find " + fileName + " file.");
            System.exit(1);
        }
    }
	
}