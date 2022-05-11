import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class GUI_Pharmacy  extends JFrame{

	private JFrame f;
	private JPanel p,btnp,listp,imgp;
	
	private JButton addD,rmD,refD,back,refresh,shortC,shortN;
	//BUTTONS : Add Drugs, Remove Drugs, Refill Drugs, Back to menu , Refresh the list
	
	private JList list,listF;
	private JScrollPane scrollPane1,scrollPane2;
	private JLabel lbl1,lbl2;
	
	private ImageIcon logo;
	private JLabel imglbl;
	private ImageIcon img;
	
	private DefaultListModel mlist;
	
	public GUI_Pharmacy() {
		
		//Frames-Panels
		f=new JFrame();
		p=new JPanel();
		btnp=new JPanel();
		listp=new JPanel();
		
		//Image
		imgp=new JPanel();
		img=new ImageIcon("img/img_pharmacy1.png");
		imglbl=new JLabel(img);
		
		//Buttons
		addD=new JButton("Add Medicine");
		addD.setPreferredSize(new Dimension(250,50));
		addD.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		rmD=new JButton("Remove Medicine");
		rmD.setPreferredSize(new Dimension(250,50));
		rmD.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		refD=new JButton("Refill Medicine");
		refD.setPreferredSize(new Dimension(250,50));
		refD.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		back=new JButton("Back to Menu");
		back.setPreferredSize(new Dimension(250,50));
		back.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		refresh=new JButton("Refresh Pharmacy");
		refresh.setPreferredSize(new Dimension(250,50));
		refresh.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		shortC=new JButton("Short by Company");
		shortC.setPreferredSize(new Dimension(250,50));
		shortC.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		shortN=new JButton("Short by Name");
		shortN.setPreferredSize(new Dimension(250,50));
		shortN.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		//Images-Logos
		logo=new ImageIcon("img/db1.png");
		
		//Labels
		lbl1=new JLabel("<html><b>M<br>E<br>D<br>I<br>C<br>I<br>N<br>E<br><br>L<br>I<br>S<br>T</html>");
		lbl1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		lbl2=new JLabel("<html><b>S<br>H<br>O<br>P<br>P<br>I<br>N<br>G<br><br>L<br>I<br>S<br>T</html>");
		lbl2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		//List
		
		//For testing purposes
		mlist=new DefaultListModel();
		DefaultListModel list2=new DefaultListModel();
		
		DB_connection con=new DB_connection();
		try {
			mlist=con.getPharmacy();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		list=new JList(mlist);
		list.setCellRenderer(new MedicineRenderer());
		list.setFixedCellHeight(50);
		scrollPane1=new JScrollPane(list);
		
		listF=new JList(list2);
		listF.setCellRenderer(new MedicineRenderer());
		listF.setFixedCellHeight(50);
		listF.setEnabled(false);
		scrollPane2=new JScrollPane(listF);
		
		
		
		//Add-ons on the panels
		btnp.add(addD);
		btnp.add(rmD);
		btnp.add(refD);
		btnp.add(shortC);
		btnp.add(shortN);
		btnp.add(refresh);
		btnp.add(back);
		btnp.add(Box.createVerticalStrut(300));
		
		
		listp.add(lbl1);
		listp.add(scrollPane1);
		listp.add(Box.createHorizontalStrut(100));
		listp.add(lbl2);
		listp.add(scrollPane2);
		
		imgp.add(imglbl);
		
		//Adding the panels on the Main Panel
		p.setLayout(new BorderLayout());
		p.add(imgp,BorderLayout.NORTH);
		p.add(btnp,BorderLayout.SOUTH);
		p.add(listp,BorderLayout.CENTER);
		
		
		//Frame Settings
		f.setTitle("e-Patient MS");
		f.setIconImage(logo.getImage());
		f.setResizable(true);
		f.setContentPane(p);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Button Functions
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUI_Menu();
				f.dispose();
			}
			
		});
		
		rmD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(listF.getSelectedValuesList().size()>=1) {
					JOptionPane.showMessageDialog(null,"Please select medicine from the correct table");
				}else {
					if(list.getSelectedValuesList().size()>1) {
						JOptionPane.showMessageDialog(null,"You can only pick one Medicine at the time..");
					}else if(list.getSelectedValuesList().size()<1) {
						JOptionPane.showMessageDialog(null,"You need to pick a Medicne");
					}else {
						new GUI_RmvMedicine((Medicine)list.getSelectedValue());
					}
				}
			}
			
		});
		
		addD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUI_AddMedicine();
			}
			
		});
		
		refresh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUI_Pharmacy();
				f.dispose();
			}
			
		});
	}
	
}
