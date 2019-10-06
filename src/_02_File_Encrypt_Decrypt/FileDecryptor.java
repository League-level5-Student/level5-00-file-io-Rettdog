package _02_File_Encrypt_Decrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.
	
	public static void main(String[] args) {
		String key = "zyxwvutsrqponmlkjihefgdcba";
		String out = "";
		File file = new File("src/_02_File_Encrypt_Decrypt");
		try {
			FileReader fr = new FileReader(file);
			char c = (char) fr.read();
			while(c!=-1) {
			
			c=(char) fr.read();
			
			
			
			
			
			}
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
