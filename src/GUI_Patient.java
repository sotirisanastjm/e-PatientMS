import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.*;

public class GUI_Patient extends JFrame {

	
	private JFrame f;
	private JPanel p;
	private JPanel btnp;
	private JPanel listp;
	private JPanel imgp;
	
	private JButton addp;
	private JButton delp;
	private JButton editp;
	private JButton short1p;
	private JButton short2p;
	private JButton back;
	private JButton btnsearch;
	private JButton refresh;
	
	private JTextField search;
	
	private ImageIcon logo;
	private ImageIcon img;
	private JLabel imglbl;
	
	private JList list;
	private JScrollPane scrollpane;
	
	private DefaultListModel plist;
	
	public GUI_Patient() {
		
		
		//Frames and Panels
		f=new JFrame();
		p=new JPanel();
		btnp=new JPanel();
		listp=new JPanel();
		
		
		//List
		//For testing purposes
		plist=new DefaultListModel();
		DB_connection con=new DB_connection();
		try {
			plist=con.getPatient();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		list=new JList(plist);
		list.setCellRenderer(new PatientRenderer());
		//list.setPreferredSize(new Dimension(400,500));
		list.setFixedCellWidth(500);
		scrollpane=new JScrollPane(list); 
		
		
		
		//Images
		logo=new ImageIcon("img/db1.png");
		imgp=new JPanel();
		img=new ImageIcon("img/img_patient2.png");
		imglbl=new JLabel(img);
		
		
		//Buttons 
		addp=new JButton("Add Patient");
		addp.setPreferredSize(new Dimension(250,50));
		addp.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		delp=new JButton("Delete Patient");
		delp.setPreferredSize(new Dimension(250,50));
		delp.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		editp=new JButton("Edit Patient");
		editp.setPreferredSize(new Dimension(250,50));
		editp.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		short1p=new JButton("Short by Surname");
		short1p.setPreferredSize(new Dimension(250,50));
		short1p.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		short2p=new JButton("Short by Date");
		short2p.setPreferredSize(new Dimension(250,50));
		short2p.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		back=new JButton("Back to Menu");
		back.setPreferredSize(new Dimension(250,50));
		back.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		refresh=new JButton("Refresh");
		refresh.setPreferredSize(new Dimension(250,50));
		refresh.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		btnsearch=new JButton("Search");
		btnsearch.setPreferredSize(new Dimension(125,50));
		btnsearch.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		
		//The search textfiel
		search=new JTextField("Search by Name/Surname..",20);
		search.setPreferredSize(new Dimension(125,50));
		search.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		
		//Add-ons for the panels.
		imgp.add(imglbl);
		
		listp.add(scrollpane);
		
	//For now i wont put the search
		//btnp.add(search);
		//btnp.add(btnsearch);
		btnp.add(addp);
		btnp.add(delp);
		btnp.add(editp);
		btnp.add(short1p);
		btnp.add(short2p);
		btnp.add(refresh);
		btnp.add(back);
		btnp.add(Box.createVerticalStrut(200));
		
		
		//Adding on MainPanel
		p.setLayout(new BorderLayout());
		p.add(btnp,BorderLayout.SOUTH);
		p.add(listp,BorderLayout.CENTER);
		p.add(imgp,BorderLayout.NORTH);
		
		
		//Frame Settings
		f.setTitle("e-Patient MS");
		f.setIconImage(logo.getImage());
		f.setContentPane(p);
		f.setResizable(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUI_AddP();
			}
		});
		
		delp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(list.getSelectedValuesList().size()>1) {
					JOptionPane.showMessageDialog(null,"You can only pick one patient at the time..");
				}else if(list.getSelectedValuesList().size()<1) {
					JOptionPane.showMessageDialog(null,"You need to pick a patient");
				}else {
					con.delPatient((Patient)list.getSelectedValue());
				}
			}
		});
		
		editp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(list.getSelectedValuesList().size()>1) {
					JOptionPane.showMessageDialog(null,"You can only pick one patient at the time..");
				}else if(list.getSelectedValuesList().size()<1) {
					JOptionPane.showMessageDialog(null,"You need to pick a patient");
				}else {
					new GUI_EditP((Patient)list.getSelectedValue());
				}
			}
		});
		
		short1p.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<plist.size();i++) {
					for(int j=i+1;j<plist.size();j++) {
						if((((Patient)plist.get(i)).getSurname()).compareTo((((Patient)plist.get(j)).getSurname()))>0) {
							Patient patient=(Patient) plist.get(i);
							plist.setElementAt(plist.get(j), i);
							plist.setElementAt(patient, j);
						}
					}
				}
				list.setModel(plist);
				listp.updateUI();
			}
		});
		
		short2p.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0;i<plist.size();i++) {
					for(int j=i+1;j<plist.size();j++) {
						if((((Patient)plist.get(i)).getBirth_date()).compareTo((((Patient)plist.get(j)).getBirth_date()))>0) {
							Patient patient=(Patient) plist.get(i);
							plist.setElementAt(plist.get(j), i);
							plist.setElementAt(patient, j);
						}
					}
				}
				list.setModel(plist);
				listp.updateUI();
			}
		});
		
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
				new GUI_Patient();
				f.dispose();
			}
		});
		
		btnsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Search();
			}
		});
		
		search.addMouseListener(new MouseAdapter() {
			 
			public void mouseClicked(MouseEvent e) {
				 search.setText("");
			}
		});
		search.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				Search();
			}
		});
	}
	
	public void Search() {
		
	}
	
}
