package test;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

public class ScrollTest {
	public static void main (String args []){
		JFrame frame = new JFrame("aa");
		frame.setSize(500,500);
		frame.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
		for (int i=0;i<100;i++){
			JLabel l = new JLabel("holilili");
			JSlider s = new JSlider();
			panel.add(l);
			panel.add(s);
		}
		
		JScrollPane pane = new JScrollPane(panel);
		pane.setBounds(5,5,350,350);
		frame.add(pane);
		frame.setVisible(true);
	}
}
