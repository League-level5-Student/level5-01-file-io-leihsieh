package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	public static void main(String[] args) {
		String keyString = JOptionPane.showInputDialog("Enter the key to decrypt the message");
		int key = Integer.parseInt(keyString);
		String message = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/message.txt"));
			String line = br.readLine();
			while(line != null){
				message += line;
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String decMessage = "";
		for(char c : message.toCharArray()) {
			if(c != ' ') {
				int originalPosition = c - 'a';
				int newPosition = (originalPosition - key);
				if(newPosition < 0) {
					newPosition+=26;
				}
				char newChar = (char) ('a' + newPosition);
				decMessage += newChar;
			}
			else {
				decMessage += c;
			}
		}
		JOptionPane.showMessageDialog(null, "The decrypted message is as follows: " + decMessage);
		System.out.println(decMessage);
	}
}
