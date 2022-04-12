package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import editor.DiagramaKV;

public class Interface implements ActionListener{
	
	private JFrame fereastra = new JFrame(); // am creat fereastra
	private JButton buton_calculeaza =  new JButton("Calculeaza");
	private DiagramaKV kv =  new DiagramaKV();
	JTable truth_table =  new	JTable();
	int row;


	public Interface()
	{
		fereastra.add(buton_calculeaza);
		buton_calculeaza.setSize(100, 50);
		buton_calculeaza.setLocation(430, 650);
		fereastra.setSize(1000, 800); 
		fereastra.setLayout(null); 
		fereastra.setVisible(true); 
	    row  = 0;
	   
	    truth_table =  new	JTable(kv.getMintermen_function().getMap().size(),2);
		buton_calculeaza.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							kv.read_json();
							for(Map.Entry<String, Integer> entry:kv.getMintermen_function().getMap().entrySet() )
							{
								truth_table.setValueAt(entry.getKey(), row, 0);
								truth_table.setValueAt(entry.getValue(), row, 1);
								row++;
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
			
				}
				
				);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}