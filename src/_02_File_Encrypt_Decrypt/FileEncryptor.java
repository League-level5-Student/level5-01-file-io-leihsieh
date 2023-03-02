package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String[] args) {
		String message = JOptionPane.showInputDialog("Enter a message to encrypt");
		String keyString = JOptionPane.showInputDialog("Enter a key");
		int key = Integer.parseInt(keyString);
		String encMessage = "";
		for(char c : message.toCharArray()) {
			if(c != ' ') {
				int originalPosition = c - 'a';
				int newPosition = (originalPosition + key) % 26;
				char newChar = (char) ('a' + newPosition);
				encMessage += newChar;
			}
			else {
				encMessage += c;
			}
		}
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/message.txt");
			fw.write(encMessage);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
