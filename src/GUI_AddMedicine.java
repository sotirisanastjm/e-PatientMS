import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI_AddMedicine extends JFrame{
	
	private JFrame f;
	private JPanel p;
	
	private JButton add;
	
	private JTextField name,company,quantity;
	private JLabel lbl1,lbl2,lbl3;
	
	private ImageIcon logo;
	private ImageIcon icon;
	
	public GUI_AddMedicine() {
		
		f=new JFrame();
		p=new JPanel();
		
		add=new JButton("Add");
		add.setPreferredSize(new Dimension(100,30));
		add.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		company=new JTextField(16);
		name=new JTextField(16);
		quantity=new JTextField(5);
		
		lbl1=new JLabel();
		lbl1.setFont(new Font("Times New Roman",Font.BOLD,16));
		lbl1.setText("MEDICINE NAME : ");
		
		lbl2=new JLabel();
		lbl2.setFont(new Font("Times New Roman",Font.BOLD,16));
		lbl2.setText("COMPANY NAME : ");
		
		lbl3=new JLabel();
		lbl3.setFont(new Font("Times New Roman",Font.BOLD,16));
		lbl3.setText("QUANTITY : ");
		
		logo=new ImageIcon("img/db1.png");
		icon=new ImageIcon("img/img_pharmacy2.png");
		
		p.add(lbl1);
		p.add(name);
		p.add(lbl2);
		p.add(company);
		p.add(lbl3);
		p.add(quantity);
		p.add(add);
		p.add(new JLabel(icon));
		
		f.setTitle("e-Patient MS");
		f.setIconImage(logo.getImage());
		f.setResizable(false);
		f.setSize(new Dimension(400,300));
		f.setLocation(650,450);
		f.setContentPane(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DB_connection con=new DB_connection();
				con.setMedicine(new Medicine(name.getText(),company.getText(),Integer.valueOf(quantity.getText())));
				f.dispose();
			}
			
		});
	}
}
