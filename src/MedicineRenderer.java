import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

public class MedicineRenderer extends DefaultListCellRenderer{
	
	public Component getListCellRendererComponent(
			@SuppressWarnings("rawtypes") JList list, Object value, int index,
	        boolean isSelected, boolean cellHasFocus)
			{
	        	
				super.getListCellRendererComponent(list, value,
	            index, isSelected, cellHasFocus);
				Medicine medicine=(Medicine)value;
				setPreferredSize(new Dimension(250,50));
				setFont(new Font("Times New Roman", Font.PLAIN, 22));
				setText(medicine.getName()+" "+medicine.getCompany()+" "+medicine.getQuantity());
				return this;
			}
}
