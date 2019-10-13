package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener
{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 * 
	 * When add task is clicked:
	 * 		ask the user for a  task and save it to an array list
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list.
	 */
	JFrame frame;
	JPanel panel;
	JButton addTaskButton;
	JButton viewTaskButton;
	JButton removeTaskButton;
	JButton saveListButton;
	JButton loadListButton;
	File listFile = new File("src/_03_To_Do_List/list.txt");
	BufferedReader reader;
	FileWriter writer;
	ArrayList<String> toDoList = new ArrayList<String>();
	public static void main(String[] args) {
		(new ToDoList()).start();
	}
public void start() {
	frame = new JFrame();
	panel = new JPanel();
	addTaskButton = new JButton();
	addTaskButton.addActionListener(this);
	addTaskButton.setText("Add Task");
	viewTaskButton = new JButton();
	viewTaskButton.addActionListener(this);
	viewTaskButton.setText("View Task");
	removeTaskButton = new JButton();
	removeTaskButton.addActionListener(this);
	removeTaskButton.setText("Remove Task");
	saveListButton = new JButton();
	saveListButton.addActionListener(this);
	saveListButton.setText("Save List");
	loadListButton = new JButton();
	loadListButton.addActionListener(this);
	loadListButton.setText("Load List");
	panel.add(addTaskButton);
	panel.add(viewTaskButton);
	panel.add(removeTaskButton);
	panel.add(saveListButton);
	panel.add(loadListButton);
	frame.add(panel);
	frame.pack();
	frame.setVisible(true);
	
		
		loadList();
		
	
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton source = (JButton) e.getSource();
		if(source.equals(addTaskButton)) {
			addTask();
		}else if(source.equals(viewTaskButton)) {
			viewTasks();
		}else if(source.equals(removeTaskButton)) {
			removeTask();
		}else if(source.equals(saveListButton)) {
			saveList();
		}else if(source.equals(loadListButton)) {
			loadList();
		}
	}
	
	public void loadList(){
		ArrayList<String> out = new ArrayList<String>();
		try {
			reader = new BufferedReader(new FileReader(listFile));
			String line = reader.readLine();
			while(line!= null) {
				out.add(line);
				System.out.println(line);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		toDoList = out;
	}
	
	public void saveList() {
		listFile = new File("src/_03_To_Do_List/list.txt");
		try {
			writer = new FileWriter(listFile);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			writer = new FileWriter(listFile);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int i = 0;i<toDoList.size();i++) {
			String line = toDoList.get(i);
			try {
				writer.write(line+"\n");
				System.out.println(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addTask() {
		toDoList.add(JOptionPane.showInputDialog("Task to Add: "));
	}
	public void removeTask() {
		String remove = JOptionPane.showInputDialog("Task to Remove: ");
		for(int i = 0;i<toDoList.size();i++) {
			if(toDoList.get(i).equalsIgnoreCase(remove)) {
				toDoList.remove(i);
				i--;
			}
		}
	}
	public void viewTasks() {
		String out = "Task:";
		for(int i = 0;i<toDoList.size();i++) {
			if(!toDoList.get(i).equals(null)) {
			out+="\n"+toDoList.get(i);
			}
		}
		JOptionPane.showMessageDialog(null, out);
	}
}
