package _01_File_Recorder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		
		String word = JOptionPane.showInputDialog("Message please!!!!!");
		File file = new File("src/_01_File_Recorder/test3.txt");
		try {
			FileWriter fw = new FileWriter(file);
			
			fw.write(word);
			System.out.println(word);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println();
		}
		
		
		
	}
}
