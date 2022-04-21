import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI_EditP extends JFrame {
	
	private JFrame f;
	private JPanel p;
	private JPanel btnp;
	private JPanel txtp;
	private JPanel txt1;
	private JPanel txt2;
	private JPanel txt3;
	
	private JButton save;
	private JButton back;
	
	
	private JTextField name;
	private JTextField surname;
	private JTextField father;
	private JTextField mother;
	private JTextField date;
	private JTextField weight;
	private JTextField height;
	private JTextField amka;
	private JTextField email;
	private JTextField blood;
	
	private JTextArea area1;
	private JTextArea area2;
	private JTextArea area3;
	private JTextArea area4;
	private JTextArea area5;
	private JTextArea area6;
	
	private JComboBox sex;
	
	private ImageIcon logo;
	
	public GUI_EditP(Patient patient) {
		
		DB_connection con=new DB_connection();
		//Panels
		f=new JFrame();
		p=new JPanel();
		btnp=new JPanel();
		txtp=new JPanel();
		txt1=new JPanel();
		txt2=new JPanel();
		txt3=new JPanel();
		//Logo
		logo=new ImageIcon("img/db1.png");
		
		//Buttons
		save=new JButton("Save");
		save.setPreferredSize(new Dimension(250,50));
		save.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		back=new JButton("Back");
		back.setPreferredSize(new Dimension(250,50));
		back.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		//Labels and Textfields
		name=new JTextField(patient.getName(),10);
		name.setPreferredSize(new Dimension(50,50));
		name.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		surname=new JTextField(patient.getSurname(),10);
		surname.setPreferredSize(new Dimension(50,50));
		surname.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		father=new JTextField(patient.getFathername(),10);
		father.setPreferredSize(new Dimension(50,50));
		father.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		mother=new JTextField(patient.getMothername(),10);
		mother.setPreferredSize(new Dimension(50,50));
		mother.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		date=new JTextField(String.valueOf(patient.getBirth_date()),10);
		date.setPreferredSize(new Dimension(50,50));
		date.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		weight=new JTextField(String.valueOf(patient.getWeight()),5);
		weight.setPreferredSize(new Dimension(50,50));
		weight.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		height=new JTextField(String.valueOf(patient.getHeight()),5);
		height.setPreferredSize(new Dimension(50,50));
		height.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		email=new JTextField(patient.getEmail(),10);
		email.setPreferredSize(new Dimension(50,50));
		email.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		amka=new JTextField(String.valueOf(patient.getAmka()),10);
		amka.setPreferredSize(new Dimension(50,50));
		amka.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		amka.setEditable(false);
		
		blood=new JTextField(patient.getBloodType(),8);
		blood.setPreferredSize(new Dimension(50,50));
		blood.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		String[] sex1= {"Female","Male"};
		sex=new JComboBox(sex1);
		if(patient.getSex().equals("F")) {
			sex.setSelectedIndex(0);
		}else sex.setSelectedIndex(1);
		sex.setPreferredSize(new Dimension(150,50));
		sex.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		//Family History
		String[] txt=con.getHistory(patient.getAmka());
		
		area1=new JTextArea(txt[0],10,30);
		area1.setLineWrap(true);
		area1.setWrapStyleWord(true);
		area1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		JScrollPane scroll1=new JScrollPane(area1);
		
		//Allergies
		area2=new JTextArea(txt[1],10,30);
		area2.setLineWrap(true);
		area2.setWrapStyleWord(true);
		area2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		JScrollPane scroll2=new JScrollPane(area2);
		
		//Medication History
		area3=new JTextArea(txt[2],12,20);
		area3.setLineWrap(true);
		area3.setWrapStyleWord(true);
		area3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		JScrollPane scroll3=new JScrollPane(area3);
		
		//Doctor Appointments
		area4=new JTextArea(txt[3],12,20);
		area4.setLineWrap(true);
		area4.setWrapStyleWord(true);
		area4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		JScrollPane scroll4=new JScrollPane(area4);
		
		//Medical Tests
		area5=new JTextArea(txt[4],12,20);
		area5.setLineWrap(true);
		area5.setWrapStyleWord(true);
		area5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		JScrollPane scroll5=new JScrollPane(area5);
		
		//Surgery History
		area6=new JTextArea(txt[5],10,30);
		area6.setLineWrap(true);
		area6.setWrapStyleWord(true);
		area6.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		JScrollPane scroll6=new JScrollPane(area6);
		
		JLabel label1=new JLabel("<HTML><b>H<br>I<br>S<br>T<br>O<br>R<br>Y</HTML>");
		label1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel label2=new JLabel("<HTML><b>A<br>L<br>L<br>E<br>R<br>G<br>I<br>E<br>S</HTML>");
		label2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel label3=new JLabel("<html><b>M<br>E<br>D<br>I<br>C<br>A<br>T<br>I<br>O<br>N</html>");
		label3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel label4=new JLabel("<html><b>A<br>P<br>P<br>O<br>I<br>N<br>T<br>M<br>E<br>N<br>T<br>S</html>");
		label4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel label5=new JLabel("<html><b>M<br>E<br>D<br>I<br>C<br>A<br>L<br><br>T<br>E<br>S<br>T<br>S</html>");
		label5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		JLabel label6=new JLabel("<html><b>S<br>U<br>R<br>G<br>E<br>R<br>I<br>E<br>S</html>");
		label6.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		//Textfield Panel
		txt1.add(Box.createVerticalStrut(100));
		txt1.add(surname);
		txt1.add(name);
		txt1.add(father);
		txt1.add(mother);
		txt1.add(date);
		txt1.add(blood);
		txt1.add(weight);
		txt1.add(height);
		txt1.add(amka);
		txt1.add(email);
		txt1.add(sex);
		
		txt2.add(label1);
		txt2.add(scroll1);
		txt2.add(Box.createHorizontalStrut(30));
		txt2.add(label6);		
		txt2.add(scroll6);
		txt2.add(Box.createHorizontalStrut(30));
		txt2.add(label2);
		txt2.add(scroll2);
		
		txt3.add(label3);
		txt3.add(scroll3);
		txt3.add(Box.createHorizontalStrut(40));
		txt3.add(label4);		
		txt3.add(scroll4);
		txt3.add(Box.createHorizontalStrut(40));
		txt3.add(label5);
		txt3.add(scroll5);
		
		
		txtp.setLayout(new BorderLayout());
		txtp.add(txt1,BorderLayout.NORTH);
		txtp.add(txt2,BorderLayout.CENTER);
		txtp.add(txt3,BorderLayout.SOUTH);
		
		//Button Panel
		btnp.add(save);
		btnp.add(back);
		btnp.add(Box.createVerticalStrut(100));
		
		//Panel add-ons
		p.setLayout(new BorderLayout());
		p.add(txtp,BorderLayout.NORTH);
		p.add(btnp,BorderLayout.SOUTH);
		
		//Panel-Frame Settings
		f.setTitle("e-Patient MS");
		f.setIconImage(logo.getImage());
		f.setContentPane(p);
		f.setResizable(true);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				f.dispose();
			}
			
		});
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String gender="";
				if(String.valueOf(sex.getSelectedIndex()).equals("Female")){
					gender="F";
				}else {
					gender="M";
				}

				
				area1.setText(area1.getText().replace("'","''"));
				area2.setText(area2.getText().replace("'","''"));
				area3.setText(area3.getText().replace("'","''"));
				area4.setText(area4.getText().replace("'","''"));
				area5.setText(area5.getText().replace("'","''"));
				area6.setText(area6.getText().replace("'","''"));
				weight.setText(weight.getText().replace(",", "."));
				height.setText(height.getText().replace(",", "."));
				email.setText(email.getText().replace(",", "."));
				String regex = "[0-9, /.]+",regex1 = "[0-9]+";
				
				if(weight.getText().matches(regex)&& height.getText().matches(regex)){
					if(Double.valueOf(weight.getText())<999) {
						if(Double.valueOf(height.getText())<9) {
							try {
								con.updatePatient(new Patient(name.getText(),surname.getText(),father.getText(),mother.getText(),
										java.sql.Date.valueOf(date.getText()),Double.valueOf(weight.getText()),
										Double.valueOf(height.getText()),gender,email.getText(),Integer.valueOf(amka.getText()),blood.getText()),
										area1.getText(),
										area2.getText(),
										area3.getText(),
										area4.getText(),
										area5.getText(),
										area6.getText());
								f.dispose();
							}catch(Exception e) {
								JOptionPane.showMessageDialog(null,"Please check the date, the correct format need to be like YYYY-MM-DD");
							}
						}else JOptionPane.showMessageDialog(null, "Please check the height section, the correct format is 0.00");
					}else JOptionPane.showMessageDialog(null, "Please check the weight section, the correct format is 000.000");
				}else JOptionPane.showMessageDialog(null, "Please only decimal numbers at the weight/height section..");
			}
			
		});
	}

}
