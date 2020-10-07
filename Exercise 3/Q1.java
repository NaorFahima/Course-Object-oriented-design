package Task_3; // Naor Fahima 315783563

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String searchedWord;
		int numOfFile ,sum = 0;
		Scanner sca = new Scanner(System.in);
		
		System.out.println("Enter the searched word:");
		searchedWord = sca.nextLine();
		System.out.println("Enter number of articles:");
		numOfFile = Integer.parseInt(sca.nextLine());
		
		Thread[] threads = new Thread[numOfFile];
		MyReadFile[] fileNames = new MyReadFile[numOfFile];
		
		for (int i = 0; i < numOfFile; i++) { // loop that read files name
			System.out.println("Enter name of article no " + (i + 1) + ":");
			fileNames[i] = new MyReadFile(sca.nextLine(), searchedWord);
			threads[i] = new Thread(fileNames[i], searchedWord);
		}
		for (int i = 0; i < numOfFile; i++) { // loop that run all the threads
			threads[i].run();
		}
		for(int i=0;i<numOfFile;i++) {// join all the threads and get the final sum
			try {
				threads[i].join();
				sum += fileNames[i].getCounter();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Total number of times the word '"+searchedWord+"' appears in articles is "+sum);
		sca.close();
	}
	
	

	public static class MyReadFile implements Runnable {

		private String nameFile;
		private String searchedWord;
		private int counter;

		public MyReadFile(String nameFile, String searchedWord) {
			this.nameFile = nameFile;
			this.searchedWord = searchedWord;
		}

		@Override
		public void run() {
			String temp;
			String temps[];
			try (RandomAccessFile f = new RandomAccessFile(nameFile, "r")) { // open file
				while (f.getFilePointer()<f.length()) { // read all the file
					temp = f.readLine(); // read line from the file
					temps = temp.split(" ");
					for (int i = 0; i < temps.length; i++) 
						if(temps[i].equals(searchedWord))
							counter++;
				}
				System.out.println("Word '" + searchedWord + "' appears in " + nameFile + " " + counter + " times");
			} catch (FileNotFoundException e) {
				System.out.println("Error occurred.  Error is: "+nameFile+" (The system cannot find the file specified)");
			} catch (IOException e) {
				System.out.println("Error Input/Output");
			}
		}

		public int getCounter() {
			return counter;
		}
	}
}
