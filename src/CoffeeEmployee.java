import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeEmployee {
	public static void main(String[] args) {
		
		ArrayList<String> orders = loadOrders();
		
		System.out.println("Which records would you like to mark as DONE?");
		
		Scanner input = new Scanner(System.in);
		int index = input.nextInt();
		
		orders.set(index, orders.get(index) + " DONE!");
		
		saveOrders(orders);
	}

	public static void saveOrders(ArrayList<String> orders) {
		File file = new File("order records.txt");
		
		PrintWriter pw;
		try {
			pw = new PrintWriter(file);
		
		int d = 0;
		while (d < orders.size()) {
			String line = orders.get(d);
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

	public static ArrayList<String> loadOrders() {
		ArrayList<String> orders = new ArrayList<>();
		
		try {
			File file = new File("order records.txt");
			Scanner scanner = new Scanner(file);
			

			while(scanner.hasNext()) {
				String line = scanner.nextLine();
				System.out.println(orders.size() + ": " + line);
				
				orders.add(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
}
 