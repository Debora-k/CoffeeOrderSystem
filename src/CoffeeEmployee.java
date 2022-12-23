import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CoffeeEmployee {
	public static void main(String[] args) {
		
		String[] orders = new String[1000];
		int i = 0;
		
		try {
			File file = new File("order records.txt");
			Scanner scanner = new Scanner(file);
			

			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.println(i + ": " + line);
				
				orders[i] = line;
				i++;
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Which records would you like to mark as DONE?");
		
		Scanner input = new Scanner(System.in);
		int index = input.nextInt();
		
		orders[index] = orders[index] + " DONE!";
		
		File file = new File("order records.txt");
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(file);
		
		int d = 0;
		while (d < i) {
			String line = orders[d];
			pw.println(line);
			d++;
		} 
		pw.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("There is no matching files.");
			e.printStackTrace();
		}
	}
}
 