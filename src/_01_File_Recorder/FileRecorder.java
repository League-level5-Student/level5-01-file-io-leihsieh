package _01_File_Recorder;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileRecorder {
	// Create a program that takes a message from the user and saves it to a file.
	public static void main(String[] args) {
		String input = JOptionPane.showInputDialog("Write a message:");
		try {
			FileWriter fw = new FileWriter("src/_01_File_Recorder/messages.txt", true);
			fw.write("\n" + input);
				
			fw.close();
			JOptionPane.showMessageDialog(null, "Your message has been recorded.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
