package work.files.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		ArrayList<Product> products = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please, inform a path where is the .csv file: ");
		String pathname = sc.nextLine();

		File file = new File(pathname);

		try (BufferedReader bf = new BufferedReader(new FileReader(file))) {

			String line = bf.readLine();

			while (line != null) {
				String[] s = line.split(",");
				products.add(new Product(s[0], Double.parseDouble(s[1]), Integer.parseInt(s[2])));
				line = bf.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error during the read, message from the system " + e.getMessage());
		}
		
		boolean newFile = new File(file.getParent() + "\\out").mkdir();

		if (newFile == true) {
			System.out.println("File out created!");
		}
		
		File fileOut = new File(file.getParent() + "\\out\\summary.csv");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut, true))) {
			for (Product product : products) {
				String str = product.getName() + "," + product.getSummary();
				bw.write(str);
				bw.newLine();
			}
			System.out.println("Summary created, checkout the output file to see more!");
		} catch (IOException e) {
			System.out.println("Error during the write, message from the system " + e.getMessage());
		}
		sc.close();
	}
}
