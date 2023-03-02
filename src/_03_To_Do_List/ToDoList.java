package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame = new JFrame("To-Do List");
	JPanel panel = new JPanel();
	JButton addButton = new JButton("Add Task");
	JButton viewButton = new JButton("View Tasks");
	JButton removeButton = new JButton("Remove Task");
	JButton saveButton = new JButton("Save List");
	JButton loadButton = new JButton("Load List");
	ArrayList<String> tasks = new ArrayList<String>();
	
	public static void main(String[] args) {
		ToDoList td = new ToDoList();
	}
	
	ToDoList(){
		addButton.addActionListener(this);
		viewButton.addActionListener(this);
		removeButton.addActionListener(this);
		saveButton.addActionListener(this);
		loadButton.addActionListener(this);
		panel.add(addButton);
		panel.add(viewButton);
		panel.add(removeButton);
		panel.add(saveButton);
		panel.add(loadButton);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==addButton) {
			String task = JOptionPane.showInputDialog("Enter a task to add:");
			tasks.add(task);
		}
		else if(e.getSource()==viewButton) {
			String taskView = "";
			for(int i = 1; i-1 < tasks.size(); i++) {
				taskView += "" + i + ". " + tasks.get(i-1) + "\n";
			}
			JOptionPane.showMessageDialog(null, "Here are the tasks:\n" + taskView);
		}
		else if(e.getSource()==removeButton) {
			String remove = JOptionPane.showInputDialog("Which task would you like to remove?");
			for(int i = 0; i < tasks.size(); i++) {
				if (remove.equals(tasks.get(i))) {
					tasks.remove(i);
				}
			}
			JOptionPane.showMessageDialog(null, "The task has been removed.");
		}
		else if(e.getSource()==saveButton) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/tasks.txt");
				fw.write("" + tasks);
				fw.close();
				JOptionPane.showMessageDialog(null, "Your list has been saved.");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==loadButton) {
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/_03_To_Do_List/tasks.txt"));
				String line = br.readLine();
				br.close();
				
				line = line.replaceAll("[\\[\\]]", "");
				tasks = new ArrayList<String>(Arrays.asList(line.split(", ")));
				JOptionPane.showMessageDialog(null, "A list has been loaded");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
