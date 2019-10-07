package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	// Create a program that opens the file created by FileEncryptor and display
	// the decrypted message to the user in a JOptionPane.

	public static void main(String[] args) {
		String key = "zyxwvutsrqponmlkjihefgdcba ";
		String normal = "abcdefghijklmnopqrstuvwxyz ";
		String out = "";
		File file = new File("src/_02_File_Encrypt_Decrypt/text.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/text.txt"));
String main = "";
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				main+=line;
				line = br.readLine();
			}
			
			for(int i = 0;i<main.length();i++) {
				for (int k = 0; k < normal.length(); k++) {
					if (key.substring(k, k + 1).equals(main.substring(i, i+1))) {
						out += normal.substring(k, k + 1);
					}
				}
			}	
			JOptionPane.showMessageDialog(null, out);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
