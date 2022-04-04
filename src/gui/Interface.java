package gui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Interface {
	public static void main(String[] args) {  
		JFrame fereastra = new JFrame(); // am creat fereastra
		JButton buton_calculeaza =  new JButton("Calculeaza");
		fereastra.add(buton_calculeaza);
		buton_calculeaza.setSize(100, 50);
	//	buton_calculeaza.setLocation(600, 400);
		buton_calculeaza.setBounds(130,100,100, 40);  
		fereastra.setSize(1000, 800); // i-am dat dimensiunile
		fereastra.setLayout(null); // nu setam niciun aspect
		fereastra.setVisible(true); // este vizibila
		}  
}
