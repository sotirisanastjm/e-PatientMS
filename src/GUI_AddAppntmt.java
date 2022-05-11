import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.*;

public class GUI_AddAppntmt extends JFrame{

	private JFrame f;
	private JPanel p;
	private JButton add;
	private JTextField name;
	private JTextField amka;
	private JComboBox menu,menu1;
	private JLabel lbl,lbl1,lbl2;
	private ImageIcon logo;
	
	private Date date;
	public GUI_AddAppntmt(Date date) {
		
		this.date=date;
		
		f=new JFrame();
		p=new JPanel();
		
		
		add=new JButton("Add");
		add.setPreferredSize(new Dimension(100,30));
		add.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		
		name=new JTextField(16);
		amka=new JTextField(8);
		
		
		lbl1=new JLabel();
		lbl1.setFont(new Font("Times New Roman",Font.BOLD,16));
		lbl1.setText("FULL NAME :");
		
		lbl2=new JLabel();
		lbl2.setFont(new Font("Times New Roman",Font.BOLD,16));
		lbl2.setText("AMKA :");
		
		lbl=new JLabel();
		lbl.setFont(new Font("Times New Roman",Font.BOLD,15));
		lbl.setText("Please select the time for the Appointment");
		logo=new ImageIcon("img/db1.png");
		
		String[] choices;
		String str1,str2,str3,str4;
		str1=String.valueOf(String.valueOf(date).charAt(5))+String.valueOf(String.valueOf(date).charAt(6));
		str2=String.valueOf(String.valueOf(date).charAt(8))+String.valueOf(String.valueOf(date).charAt(9));
		str3=String.valueOf(String.valueOf(java.time.LocalDate.now()).charAt(5))+String.valueOf(String.valueOf(java.time.LocalDate.now()).charAt(6));
		str4=String.valueOf(String.valueOf(java.time.LocalDate.now()).charAt(8))+String.valueOf(String.valueOf(java.time.LocalDate.now()).charAt(9));
		if(str1.equals(str3) && str2.equals(str4)) {
			String tm1=String.valueOf(String.valueOf(java.time.LocalTime.now()).charAt(0))+String.valueOf(String.valueOf(java.time.LocalTime.now()).charAt(1));
			String tm2=String.valueOf(String.valueOf(java.time.LocalTime.now()).charAt(3))+String.valueOf(String.valueOf(java.time.LocalTime.now()).charAt(4));
			choices=new String[48-(Integer.valueOf(tm1)-9)*4];
			int index=0;
			
			for(int i=Integer.valueOf(tm1)-9;i<=11;i++) {
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
		}else {
			choices=new String[48];
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
		}
		
		
		String[] choices1= {"Non-urgent","Urgent","Emergent"};
		
		menu = new JComboBox(choices);
		menu.setVisible(true);
		
		menu1 = new JComboBox(choices1);
		menu1.setVisible(true);
		
		p.add(lbl1);
		p.add(name);
		p.add(lbl2);
		p.add(amka);
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
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				double time;
				int priority;
				
				if(String.valueOf(menu1.getSelectedItem()).equals("Non-urgent")){
					priority=0;
				}else if(String.valueOf(menu1.getSelectedItem()).equals("Urgent")) {
					priority=1;
				}else {
					priority=2;
				}
				String time1=(String) menu.getSelectedItem();
				time1=time1.replace(":",".");
				time=Double.valueOf(time1);
				DB_connection con=new DB_connection();
				con.setAppointment(name.getText(),time,priority,date,Integer.valueOf(amka.getText()));
				f.dispose();
			}
			
		});
	}
	
}
