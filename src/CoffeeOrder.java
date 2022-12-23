import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeOrder {
	public static void main(String[] args) {
		System.out.println("Welcome to Starbucks!");
		System.out.println("We have coffee, cappuccino, latte, and iced-coffee");
		System.out.println("What would you like to order?");
		
		Scanner scanner = new Scanner(System.in);
		
		String order = scanner.nextLine();
		System.out.println("Your order is " + order);
		
		int numcream = 0;
		
		if(order.equals("coffee") || order.equals("iced-coffee")) {
			System.out.println("How much cream would you like to add?");
			String answer = scanner.nextLine();
			try {
				numcream = Integer.parseInt(answer);
				if(numcream == 0 || numcream == 1) {
					System.out.println("Okay, then that will be $2.50");
				} else if(numcream >= 2) {
					System.out.println("Okay, that will be " + ( 2.5 + (.20 * numcream)));
				} else {
					System.out.println("Sorry, I didn't understand.");
				}
			} catch (Exception e) {
				System.out.println("Sorry, I didn't understand.");
			}
			
			
		} else if(order.equals("cappuccino")) {
			System.out.println("Sorry, we are just out of espresso");
		} else if(order.equals("latte")) {
			System.out.println("Sure, that will be $3.99");
		} else {
			
		}
		//addOrder(order, numcream);
		ArrayList<String> orders = CoffeeEmployee.loadOrders();
		orders.add(order + " " + numcream);
		CoffeeEmployee.saveOrders(orders);
		
	}

//	public static void addOrder(String order, int numcream) {
//		File file = new File("order records.txt");
//		try {
//			FileWriter fw = new FileWriter(file, true);
//
//			PrintWriter pw = new PrintWriter(fw);
//			
//			pw.println(order + " " + numcream); // to save order history into the text file
//			pw.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
}
