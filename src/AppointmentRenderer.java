import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;


public class AppointmentRenderer extends DefaultListCellRenderer {

	public Component getListCellRendererComponent(
	        @SuppressWarnings("rawtypes") JList list, Object value, int index,
	        boolean isSelected, boolean cellHasFocus)
	    {
			super.getListCellRendererComponent(list, value,
	            index, isSelected, cellHasFocus);
			Appointment appointment=(Appointment)value;
			setPreferredSize(new Dimension(250,50));
			setFont(new Font("Times New Roman", Font.PLAIN, 22));
			ImageIcon icon= new ImageIcon("img/img_green.png");
			if(appointment.getPriority()==0) {
				icon= new ImageIcon("img/img_green.png");
			}else if(appointment.getPriority()==1) {
				icon= new ImageIcon("img/img_yellow.png");
			}else {
				icon= new ImageIcon("img/img_red.png");
			}
			double num=(appointment.getTime()-(int)appointment.getTime())*100;
			setIcon(icon);
			if(num!=0) {
				setText(appointment.getFullname()+" "+(int)appointment.getTime()+":"+((int)num)+" "+appointment.getDate());
			}else {
				setText(appointment.getFullname()+" "+(int)appointment.getTime()+":00"+" "+appointment.getDate());
			}
			return this;
	    }

	
}
