package gui;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.JTable;


import editor.DiagramaKV;

public class GraphicInterface implements ActionListener{ // modificare nume clasa
	
	private JFrame fereastra = new JFrame();
	private JButton buton_calculeaza =  new JButton("CalculeazaJSON");
	private JButton buton_calculeaza_tastatura =  new JButton("Facade");
	private JPanel panel_diagrama =  new JPanel();
	private DiagramaKV kv =  new DiagramaKV();
	JTable truth_table =  new JTable();
	

	public GraphicInterface()
	{
		
		fereastra.setSize(1000, 800); 
		fereastra.setLayout(null);
		fereastra.setVisible(true); 
		panel_diagrama.setVisible(false);
		buton_calculeaza.setSize(150, 50);
		buton_calculeaza.setLocation(330, 650);
	   
		
	}
	public void buton_calculeaza()
	{
		fereastra.add(buton_calculeaza);
		
		panel_diagrama.setBackground(Color.black);  
		panel_diagrama.setSize(500, 400);
		fereastra.add(panel_diagrama);
	
		buton_calculeaza.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					kv.read_json();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
	
		}
		
		);
	}

public void facade(int index)
{
	fereastra.add(buton_calculeaza_tastatura);
	buton_calculeaza_tastatura.setSize(180, 50);
	buton_calculeaza_tastatura.setLocation(530, 650);
	
	JPanel panou_principal = new JPanel();
	
	buton_calculeaza_tastatura.addActionListener(new ActionListener()
	{
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				kv.read_json();
				
				panou_principal.setLayout(new GridLayout(kv.getDiagramaKV(index).getN_Bits(),(int) kv.getDiagramaKV(index).sizeTable()));
				panou_principal.setSize(400,500);
				fereastra.add(panou_principal);
				panou_principal.setVisible(true);
				
				for(int i = 0; i < kv.getDiagramaKV(index).sizeTable(); i++)
				{
						JLabel temporar =  new JLabel(kv.getDiagramaKV(index).getMintermen_function().getSir_biti().get(i));
						panou_principal.add(temporar);
				}
				
				fereastra.revalidate();
				
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