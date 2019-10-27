package _02_Pixel_Art;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PixelArtMaker implements MouseListener,ActionListener{
	private JFrame window;
	private GridInputPanel gip;
	private GridPanel gp;
	ColorSelectionPanel csp;
	private JButton save = new JButton("Save");
	private JButton load = new JButton("Load");
	public void start() {
		gip = new GridInputPanel(this);	
		window = new JFrame("Pixel Art");
		window.setLayout(new FlowLayout());
		window.setResizable(false);
		
		window.add(load);
		load.addActionListener(this);
		
		window.add(gip);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}

	public void submitGridData(int w, int h, int r, int c) {
		gp = new GridPanel(w, h, r, c);
		csp = new ColorSelectionPanel();
		window.remove(gip);
		window.add(gp);
		window.add(csp);
		window.remove(load);
		window.add(save);
		save.addActionListener(this);
		gp.repaint();
		gp.addMouseListener(this);
		window.pack();
	}
	public void loadGridData(int w, int h, int r, int c,GridPanel data) {
		gp = data;
		csp = new ColorSelectionPanel();
		window.remove(gip);
		window.add(gp);
		window.add(csp);
		window.remove(load);
		window.add(save);
		save.addActionListener(this);
		gp.repaint();
		gp.addMouseListener(this);
		window.pack();
	}
	
	public static void main(String[] args) {
		new PixelArtMaker().start();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		gp.setColor(csp.getSelectedColor());
		System.out.println(csp.getSelectedColor());
		gp.clickPixel(e.getX(), e.getY());
		gp.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(save)) {
			try {
				FileOutputStream fos = new FileOutputStream(new File("src/_02_Pixel_Art/savePixels.txt"));
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(gp);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource().equals(load)) {
			try {
				FileInputStream fis = new FileInputStream(new File("src/_02_Pixel_Art/savePixels.txt"));
				ObjectInputStream oos = new ObjectInputStream(fis);
				GridPanel data = (GridPanel) oos.readObject();
				loadGridData(data.pixels.length*10, data.pixels[0].length*10, data.pixels.length, data.pixels[0].length,data);
				
				
			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
