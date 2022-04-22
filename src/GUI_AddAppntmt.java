import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class GUI_AddAppntmt extends JFrame{

	private JFrame f;
	private JPanel p;
	private JButton add;
	private JTextField name;
	private JComboBox menu,menu1;
	private JLabel lbl,lbl1;
	private ImageIcon logo;
	
	public GUI_AddAppntmt(String lastD) {
		
		f=new JFrame();
		p=new JPanel();
		add=new JButton("Add");
		add.setPreferredSize(new Dimension(100,30));
		add.setFont(new Font("Times New Roman",Font.BOLD,15));
		name=new JTextField(25);
		lbl1=new JLabel();
		lbl1.setFont(new Font("Times New Roman",Font.BOLD,15));
		lbl1.setText("Full name :");
		lbl=new JLabel();
		lbl.setFont(new Font("Times New Roman",Font.BOLD,15));
		lbl.setText("Please select the time for the Appointment");
		logo=new ImageIcon("img/db1.png");
		
		String[] choices=new String[48];
		int index=0;
		for(int i=0;i<=11;i++) {
			for(int j=0;j<=3;j++) {
				switch(j) {
				case 0:
					choices[index]=String.valueOf(i+9)+":00";
					index++;
					break;
				case 1:
					choices[index]=String.valueOf(i+9)+":15";
					index++;
					break;
				case 2:
					choices[index]=String.valueOf(i+9)+":30";
					index++;
					break;
				case 3:
					choices[index]=String.valueOf(i+9)+":45";
					index++;
					break;
				default:
					break;
				}
			}
		}
		
		String[] choices1=new String[3];
		choices1[0]="Non-urgent";
		choices1[1]="Urgent";
		choices1[2]="Emergent";
		
		JComboBox<String> menu = new JComboBox<String>(choices);
		menu.setVisible(true);
		
		JComboBox<String> menu1 = new JComboBox<String>(choices1);
		menu1.setVisible(true);
		
		p.add(lbl1);
		p.add(name);
		p.add(lbl);
		p.add(menu);
		p.add(menu1);
		p.add(add);
		
		f.setTitle("e-Patient MS");
		f.setIconImage(logo.getImage());
		f.setResizable(false);
		f.setSize(new Dimension(500,200));
		f.setLocation(650,450);
		f.setContentPane(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
}
