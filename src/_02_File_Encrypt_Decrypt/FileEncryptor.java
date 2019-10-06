package _02_File_Encrypt_Decrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	
	public static void main(String[] args) {
		String key = "zyxwvutsrqponmlkjihefgdcba";
		String word = JOptionPane.showInputDialog("Give me a message to encrypt");
		String out = "";
		File file = new File("src/_02_File_Encrypt_Decrypt");
		try {
			FileWriter fw = new FileWriter(file);
			
			for(int i = 0;i<word.length();i++) {
				for(int k = 0;k<key.length();k++) {
					if(word.substring(i,i+1).equals(key.substring(k, k+1))) {
						out+=key.substring(k,k+1);
					}
				}
			}
			
			fw.write(out);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
