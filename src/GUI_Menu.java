import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class GUI_Menu extends JFrame{
	
	private JFrame frame;
	private JPanel mainp;
	private JPanel imgp;
	private JPanel btnp;
	private JPanel namep;
	
	private ImageIcon img;
	private ImageIcon logo;
	
	private JButton chat;
	private JButton plist;
	private JButton appntms;
	private JButton stats;
	private JButton storage;
	
	private JLabel imglbl;
	private JLabel name;
	
	public GUI_Menu() {

	//Frames and Panels;
		frame=new JFrame();
		mainp=new JPanel();
		imgp=new JPanel();
		imgp.setPreferredSize(new Dimension(550,550));
		btnp=new JPanel();
		namep=new JPanel();
		
	//Buttons
		chat=new JButton("Chatroom");
		plist=new JButton("Patients");
		appntms=new JButton("Schedule and Appointments");
		stats=new JButton("Reporting and Statistics");
		storage=new JButton("Pharmacy");
		
		chat.setPreferredSize(new Dimension(250,50));
		chat.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		plist.setPreferredSize(new Dimension(250,50));
		plist.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		appntms.setPreferredSize(new Dimension(300,50));
		appntms.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		stats.setPreferredSize(new Dimension(300,50));
		stats.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		storage.setPreferredSize(new Dimension(250,50));
		storage.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
	//Images
		img=new ImageIcon("img/healthbit31.png");
		logo=new ImageIcon("img/db1.png");
		
	//Labels
		imglbl=new JLabel(img);
		
	//Add-ons for the other panels
		
		imgp.add(imglbl);
		
		
		name=new JLabel("e-Patient MS");
		name.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		name.setForeground(Color.GRAY);
		namep.add(Box.createHorizontalStrut(1));
	    namep.add(name);
	    namep.add(Box.createHorizontalStrut(1));
		
		btnp.add(plist);
		btnp.add(storage);
		btnp.add(stats);
		btnp.add(appntms);
		btnp.add(chat);
		btnp.add(Box.createVerticalStrut(100));
		
	//Adding on MainPanel
		mainp.setLayout(new BorderLayout());
		mainp.add(imgp,BorderLayout.NORTH);
		mainp.add(namep,BorderLayout.SOUTH);
		mainp.add(btnp,BorderLayout.CENTER);
		
	//Frame settings
		frame.setTitle("e-Patient MS");
		frame.setIconImage(logo.getImage());
		frame.setResizable(true);
		frame.setContentPane(mainp);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		//Button Functions
		plist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUI_Patient();
				frame.dispose();
			}
			
		});
		
		storage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUI_Pharmacy();
				frame.dispose();
			}
			
		});
		
		appntms.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUI_Calendar();
				frame.dispose();
			}
			
		});
		
		stats.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUI_Statistics();
				frame.dispose();
			}
			
		});
	}
}
