import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI_Statistics extends JFrame {

	private JFrame f;
	private JPanel p;
	private JPanel statsp;
	private JPanel btnp;
	
	private JButton refresh;
	private JButton back;
	
	private JLabel lbl;
	
	private ImageIcon logo;
	
	public GUI_Statistics() {
		
		//Frames-Panels
		f=new JFrame();
		p=new JPanel();
		statsp=new JPanel();
		btnp=new JPanel();
		
		//Buttons
		back=new JButton("Back to Menu");
		back.setPreferredSize(new Dimension(250,50));
		back.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		
		//Images
		logo=new ImageIcon("img/db1.png");
		
		//Labels
		lbl=new JLabel("Statistics for the last month");
		lbl.setPreferredSize(new Dimension(250,50));
		lbl.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		
		//Add-ons in the panels
		
		p.setLayout(new BorderLayout());
		
		btnp.add(back);
		
		p.add(btnp,BorderLayout.SOUTH);
		
		f.setTitle("e-Patient MS");
		f.setIconImage(logo.getImage());
		f.setContentPane(p);
		f.setResizable(false);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new GUI_Menu();
				f.dispose();
			}
		});
	}
	
}
