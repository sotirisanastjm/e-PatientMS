import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	public GUI_Pharmacy() {
		
		//Frames-Panels
		f=new JFrame();
		p=new JPanel();
		btnp=new JPanel();
		listp=new JPanel();
		
		//Image
		imgp=new JPanel();
		img=new ImageIcon("img/img_pharmacy.png");
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
		lbl1=new JLabel("Medicine List");
		lbl1.setPreferredSize(new Dimension(250,50));
		lbl1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		lbl2=new JLabel("Medicine Shopping List");
		lbl2.setPreferredSize(new Dimension(250,50));
		lbl2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		//List
		
		//For testing purposes
		DefaultListModel list1=new DefaultListModel();
		DefaultListModel list2=new DefaultListModel();
		for(int i=0;i<=20;i++) {
			list1.addElement(new Medicine("'Name'","'Company'",0));
			list2.addElement(new Medicine("'Name'","'Company'",0));
		}
		
		list=new JList(list1);
		list.setCellRenderer(new MedicineRenderer());
		list.setPreferredSize(new Dimension(500,500));
		scrollPane1=new JScrollPane(list);
		
		listF=new JList(list2);
		listF.setCellRenderer(new MedicineRenderer());
		listF.setPreferredSize(new Dimension(500,500));
		listF.setEnabled(false);
		scrollPane2=new JScrollPane(listF);
		
		
		
		//Add-ons on the panels
		btnp.add(Box.createHorizontalStrut(500));
		btnp.add(addD);
		btnp.add(rmD);
		btnp.add(refD);
		btnp.add(Box.createHorizontalStrut(500));
		btnp.add(shortC);
		btnp.add(refresh);
		btnp.add(shortN);
		btnp.add(Box.createHorizontalStrut(2000));
		btnp.add(back);
		btnp.add(Box.createVerticalStrut(300));
		
		
		listp.add(Box.createHorizontalStrut(400));
		listp.add(lbl1);
		listp.add(Box.createHorizontalStrut(200));
		listp.add(lbl2);
		listp.add(Box.createHorizontalStrut(350));
		listp.add(scrollPane1);
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
		f.setResizable(false);
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
