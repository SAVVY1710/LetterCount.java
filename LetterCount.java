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
	int biggest;
	char big;
	
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
				for(char n = 'a'; n<= 'z'; n++)
				{
					if(temp.charAt(i) == n)
					{
						int index = (int)(n)-97;
						lettercounter[index]++;
					}
				}
				for(char n = 'A'; n<= 'Z'; n++)
				{
					if(temp.charAt(i) == n)
					{
						int index = (int)(n)-65;
						lettercounter[index]++;
					}
				}
			}
		}
		input.close();
		for(int i = 0; i < 26; i++)
		{
			if(lettercounter[i] > biggest)
			{
				//big = (char)(i+65);
				biggest = lettercounter[i];
			}

		}
		int rule = biggest/60;
		System.out.println(rule);
		for(int i = 0; i < 26; i++)
		{
			System.out.print((char)(i+65) + ": ");
			System.out.printf("%5d", lettercounter[i]);
			for(int n = 0; n < lettercounter[i]/rule; n++)
			{
				System.out.print("+");
			}
			System.out.println();
		}
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