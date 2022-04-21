import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;


public class PatientRenderer extends DefaultListCellRenderer {
	
	public Component getListCellRendererComponent(
	        @SuppressWarnings("rawtypes") JList list, Object value, int index,
	        boolean isSelected, boolean cellHasFocus)
	    {
			super.getListCellRendererComponent(list, value,
	            index, isSelected, cellHasFocus);
			Patient patient=(Patient)value;
			setPreferredSize(new Dimension(250,50));
			setFont(new Font("Times New Roman", Font.PLAIN, 22));
			
			setText(patient.getAmka()+" "+patient.getSurname()+" "+patient.getName());
			return this;
	    }
}