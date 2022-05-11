import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI_RmvMedicine extends JFrame{
	
	private JFrame f;
	private JPanel p;
	
	private JButton remove,delete;
	
	private JTextField quantity;
	
	private JLabel lbl1,lbl2,lbl3;
	
	private ImageIcon logo;
	private ImageIcon icon;
	private Medicine med;
	public GUI_RmvMedicine(Medicine med) {
		
		this.med=med;
		
		f=new JFrame();
		p=new JPanel();
		
		remove=new JButton("Remove");
		remove.setPreferredSize(new Dimension(100,30));
		remove.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		delete=new JButton("Delete");
		delete.setPreferredSize(new Dimension(100,30));
		delete.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		quantity=new JTextField(5);
		
		lbl1=new JLabel("Write the correct amount you want to remove");
		lbl1.setFont(new Font("Times New Roman",Font.PLAIN,20));
		
		lbl2=new JLabel("Current amount:"+med.getQuantity());
		lbl2.setFont(new Font("Times New Roman",Font.BOLD,18));
		
		lbl3=new JLabel("Or delete the Medicine");
		lbl3.setFont(new Font("Times New Roman",Font.BOLD,18));
		
		logo=new ImageIcon("img/db1.png");
		icon=new ImageIcon("img/img_pharmacy2.png");
		
		p.add(lbl1);
		p.add(lbl2);
		p.add(quantity);
		p.add(remove);
		p.add(lbl3);
		p.add(delete);
		
		f.setTitle("e-Patient MS");
		f.setIconImage(logo.getImage());
		f.setResizable(false);
		f.setSize(new Dimension(400,200));
		f.setLocation(650,450);
		f.setContentPane(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		remove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DB_connection con=new DB_connection();
				if(quantity.getText().matches("[0-9]+") && Integer.valueOf(quantity.getText())!=0) {
					con.removeMedicine(med,med.getQuantity()-Integer.valueOf(quantity.getText()));
					f.dispose();
				}else if(quantity.getText().matches("[0-9]+") && Integer.valueOf(quantity.getText())==0) {
					JOptionPane.showMessageDialog(null,"Please write the correct amount, you can not remove 0 amount..");
				}else {
					JOptionPane.showMessageDialog(null,"Please write the correct amount!");
				}
				
			}
			
		});
		
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				DB_connection con=new DB_connection();
				int n=JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the medicine?","Message",JOptionPane.YES_NO_OPTION);
				if(n==JOptionPane.YES_OPTION) {
					con.delMedicine(med);
				}
				f.dispose();
			}
			
		});
	}
}
