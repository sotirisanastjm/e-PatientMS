import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Format;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;
public class GUI_Calendar extends JFrame implements ActionListener {
	
	private JFrame f;
	private JPanel btnp,p,cal,list,cal1,cal2,cal3;//cal1 einai gia to label tou mhna/xronou to cal2 gia label twn hmerwn to cal3 gia ta buttons
	
	private JList aplist;
	private JScrollPane scrollpane;
	
	private JButton back,nextmonth,prevmonth,addap,delap,editap;
	private ArrayList<JButton> buttons;
	
	private ImageIcon logo,img;
	
	private JLabel imglbl,callbl1,callbl2;//callbl1="Einai to label gia mhna-xrono" enw to callbl2="Gia tis meres"
	
	private int currentMonth,currentYear,cDate,cMonth,cYear;
	private Calendar calendar;
	
	private String lastD="0";
	
	public GUI_Calendar(){
		
		//Frames-Panels
		f=new JFrame();
		p=new JPanel();
		btnp=new JPanel();
		cal=new JPanel();
		list=new JPanel();
		cal1=new JPanel();
		cal2=new JPanel();
		cal3=new JPanel();
		
		//Labels
		callbl1=new JLabel();
		callbl2=new JLabel();
		
		
		//Buttons
		back=new JButton("Back to Menu");
		back.setPreferredSize(new Dimension(250,50));
		back.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		nextmonth=new JButton("Next");
		nextmonth.setPreferredSize(new Dimension (60,30));
		nextmonth.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		prevmonth=new JButton("Prev");
		prevmonth.setPreferredSize(new Dimension (60,30));
		prevmonth.setFont(new Font("Times New Roman",Font.BOLD,15));
		
		addap=new JButton("Add Appointment");
		addap.setPreferredSize(new Dimension (200,50));
		addap.setFont(new Font("Times New Roman",Font.BOLD,20));

		delap=new JButton("Delete Appointment");
		delap.setPreferredSize(new Dimension (200,50));
		delap.setFont(new Font("Times New Roman",Font.BOLD,20));
		
		editap=new JButton("Edit Appointment");
		editap.setPreferredSize(new Dimension (200,50));
		editap.setFont(new Font("Times New Roman",Font.BOLD,20));
		//Images
		logo=new ImageIcon("img/db1.png");
		img=new ImageIcon("img/img_schedule.png");
		imglbl=new JLabel(img);
		
		
		
		//Relevant to Calendar
		calendar= new GregorianCalendar();
		cDate=calendar.get(Calendar.DATE);
		cMonth=calendar.get(Calendar.MONTH);
		cYear=calendar.get(Calendar.YEAR);
		currentMonth=calendar.get(Calendar.MONTH);
		currentYear=calendar.get(Calendar.YEAR);
		
		
		
		//Add-ons in the panels
		btnp.add(back);
		btnp.add(addap);
		btnp.add(delap);
		btnp.add(Box.createVerticalStrut(60));
		
		//List for the appointments
		DefaultListModel list1=new DefaultListModel();
		list1.addElement(new Appointment("Sotiris Anastasiadis",13.00,1));
		aplist=new JList(list1);
		aplist.setCellRenderer(new AppointmentRenderer());
		aplist.setFixedCellWidth(500);
		aplist.setFixedCellHeight(70);
		scrollpane=new JScrollPane(aplist);
		list.add(scrollpane);
		list.add(Box.createHorizontalStrut(50));
		
		
		//Designing the Calendar Panel --> cal
		cal.setLayout(new BorderLayout());
		
		cal.add(cal1,BorderLayout.NORTH);
		cal1.add(prevmonth);
		cal1.add(Box.createHorizontalStrut(20));
		cal1.add(callbl1);
		setLabel();
		callbl1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		cal1.add(Box.createHorizontalStrut(20));
		cal1.add(nextmonth);
		
		cal.add(cal2,BorderLayout.CENTER);
		cal2.add(callbl2);
		String text=String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s","SUN","MON","TUE","WED","THU","FRI","SAT");
		callbl2.setText(text);
		callbl2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		
		cal.add(cal3,BorderLayout.SOUTH);
		cal3.setPreferredSize(new Dimension(500,600));
		buttons = new ArrayList<JButton>();
		for (int i = 1; i <= 37; i++) {
		    JButton button = new JButton(String.valueOf(i));
		    button.setBackground(Color.white);
		    cal3.add(button);
		    button.setPreferredSize(new Dimension(115,80));
			button.setFont(new Font("Times New Roman", Font.BOLD, 20));
			switch(i) {
				case 1:
					button.setForeground(Color.RED);
					break;
				case 7:
					button.setForeground(Color.RED);
					break;
				case 8:
					button.setForeground(Color.RED);
					break;
				case 14:
					button.setForeground(Color.RED);
					break;
				case 15:
					button.setForeground(Color.RED);
					break;
				case 21:
					button.setForeground(Color.RED);
					break;
				case 22:
					button.setForeground(Color.RED);
					break;
				case 28:
					button.setForeground(Color.RED);
					break;
				case 29:
					button.setForeground(Color.RED);
					break;
				case 35:
					button.setForeground(Color.RED);
					break;
				case 36:
					button.setForeground(Color.RED);
					break;
				default:
					break;
			}
			button.addActionListener(this);
			buttons.add(button);
		}
		printCal(currentMonth,currentYear);
		// Here is the current day so it can change color to be different from the others
		GregorianCalendar gcal=new GregorianCalendar(cYear,cMonth,1);
		int startInWeek=gcal.get(Calendar.DAY_OF_WEEK);
		cal3.add(Box.createHorizontalStrut(600));
		
		
		p.setLayout(new BorderLayout());
		p.add(btnp,BorderLayout.SOUTH);
		p.add(cal,BorderLayout.LINE_START);
		p.add(list,BorderLayout.LINE_END);
		p.add(imglbl,BorderLayout.NORTH);
		
		
		f.setTitle("e-Patient MS");
		f.setIconImage(logo.getImage());
		f.setContentPane(p);
		f.setResizable(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		nextmonth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(currentMonth==11) {
					currentYear++;
					currentMonth=0;
					setLabel();
					printCal(currentMonth,currentYear);
				}else {
					currentMonth++;
					setLabel();
					printCal(currentMonth,currentYear);
				}
			}
		});
		
		prevmonth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(cMonth==currentMonth && cYear==currentYear ) {
					JOptionPane.showMessageDialog(f, "Sorry, but you can not see the previous Month");
				}else if(currentMonth==0) {
					currentYear--;
					currentMonth=11;
					setLabel();
					printCal(currentMonth,currentYear);
				}else {
					currentMonth--;
					setLabel();
					printCal(currentMonth,currentYear);
				}
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
		
		addap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Integer.valueOf(lastD)==0) {
					JOptionPane.showMessageDialog(null,"Please select a valid day to add an Appointment!");
				}else {
					new GUI_AddAppntmt(lastD);
				}
			}
		});
		
	}
	

	
	public void setLabel() {
		switch(currentMonth) {
			case 0:
				callbl1.setText("Jan"+" "+currentYear);
				break;
			case 1:
				callbl1.setText("Feb"+" "+currentYear);
				break;
			case 2:
				callbl1.setText("Mar"+" "+currentYear);
				break;
			case 3:
				callbl1.setText("Apr"+" "+currentYear);
				break;
			case 4:
				callbl1.setText("May"+" "+currentYear);
				break;
			case 5:
				callbl1.setText("Jun"+" "+currentYear);
				break;
			case 6:
				callbl1.setText("Jul"+" "+currentYear);
				break;
			case 7:
				callbl1.setText("Aug"+" "+currentYear);
				break;
			case 8:
				callbl1.setText("Sept"+" "+currentYear);
				break;
			case 9:
				callbl1.setText("Oct"+" "+currentYear);
				break;
			case 10:
				callbl1.setText("Nov"+" "+currentYear);
				break;
			case 11:
				callbl1.setText("Dec"+" "+currentYear);
				break;
			default:
				break;
		}
	}
	
	public void printCal(int Month,int Year) {
		GregorianCalendar gCal=new GregorianCalendar(Year,Month,1);
		int days=gCal.getActualMaximum(Calendar.DATE);
		int startInWeek=gCal.get(Calendar.DAY_OF_WEEK);
		int index=1;
		for(int j=0;j<37;j++)	buttons.get(j).setBackground(Color.white);
		for(int j=1;j<startInWeek;j++) {
			buttons.get(j-1).setText("_");
			index++;
		}
		int j=1;
		while(j<=days) {
			buttons.get(index-1).setText(String.valueOf(j));
			if(Month==cMonth && Year==cYear && cDate==(index-1)) {
				buttons.get(startInWeek+cDate-2).setBackground(Color.gray);
			}
			index++;
			j++;
		}
		if(index<37) {
			for(j=index;j<=37;j++) {
				buttons.get(j-1).setText("_");
			}
		}
	}
	
	public void actionPerformed(ActionEvent event) {
        if(((JButton) event.getSource()).getText().contains("_")) {
        	lastD="0";
        }else {
        	lastD=((JButton) event.getSource()).getText();
        }
    }
	public void readFile() {
		
	}
}

