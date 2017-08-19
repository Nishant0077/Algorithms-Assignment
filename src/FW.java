import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;


public class FW 
{	
	public void CreateAndWriteToFile(String s) throws IOException
	{
	
		 File file = new File("D:/components.txt");
			FileWriter fw = new FileWriter(file, true);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(s);		
			
			pw.close();
	}
}
