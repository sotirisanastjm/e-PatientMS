import java.sql.*;

import javax.swing.DefaultListModel;
public class DB_connection {
	
	Connection connection;
	String driver="com.mysql.cj.jdbc.Driver";
	String server="192.168.2.4";
	String port="3306";
	String db="epatientms";
	String username="patient";
	String password="connect2epatient";
	String url="jdbc:mysql://"+server+"/"+db;
	
	public DB_connection(){
		
	}
	
	public boolean doConnection() {
		
		try{
			
			Class.forName(driver);  
			connection=DriverManager.getConnection(url,username,password);
			
			}catch(ClassNotFoundException e){
				System.out.println("ClassNotFoundException : "+e.getMessage());
				return false;
			}catch(SQLException e) {
				System.out.println(e.getMessage());
	            return false;
			}
		return true;
		
	}
	
	public DefaultListModel getPatient() throws SQLException {
		doConnection();
		DefaultListModel plist=new DefaultListModel();
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("SELECT * FROM Patient");
		while(result.next()) {
			
			plist.addElement(new Patient(result.getString(2).toUpperCase(),result.getString(3).toUpperCase(),result.getString(4).toUpperCase(),result.getString(5).toUpperCase(),
					java.sql.Date.valueOf(result.getString(6)),Double.valueOf(result.getString(7)),
					Double.valueOf(result.getString(8)),result.getString(9).toUpperCase(),result.getString(10),Integer.valueOf(result.getString(1)),result.getString(11)));
		}
		statement.close();
		return plist;
	}
	
	public String[] getHistory(int amka) {
		String[] txt= {"","","","","",""};
		doConnection();
		try {
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("SELECT * FROM History WHERE amkaID='"+amka+"'");
			while(result.next()) {
				txt[0]=result.getString(1);
				txt[1]=result.getString(2);
				txt[2]=result.getString(3);
				txt[3]=result.getString(4);
				txt[4]=result.getString(5);
				txt[5]=result.getString(6);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return txt;
	}
	
	public void setPatient(Patient patient,String txt1,String txt2,String txt3,String txt4,String txt5,String txt6) {
		doConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO Patient VALUES('"+patient.getAmka()+
					"','"+patient.getName()+"','"+patient.getSurname()+"','"+patient.getFathername()+
					"','"+patient.getMothername()+"','"+patient.getBirth_date()+"','"+patient.getWeight()+
					"','"+patient.getHeight()+"','"+patient.getSex()+"','"+patient.getEmail()+"','"+patient.getBloodType()+"')");
			statement.executeUpdate("INSERT INTO History VALUES('"+txt1+"','"+txt2+"','"+txt3+"','"+txt4+"','"+txt5+"','"+txt6+"','"+
					patient.getAmka()+"')");
			statement.executeUpdate("INSERT INTO User (username,password,amka) VALUES ('"+patient.getEmail()+"', '"+
					patient.getAmka()+"', '"+patient.getAmka()+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	public void updatePatient(Patient patient ,String txt1,String txt2,String txt3,String txt4,String txt5,String txt6) {
		doConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("UPDATE Patient SET name='"+patient.getName()+"',surname='"+patient.getSurname()+"',fathername='"+patient.getFathername()+
					"',mothername='"+patient.getMothername()+"',birth_date='"+patient.getBirth_date()+"',weight='"+patient.getWeight()+
					"',height='"+patient.getHeight()+"',sex='"+patient.getSex()+"',email='"+patient.getEmail()+"',BloodTp='"+patient.getBloodType()+
					"' WHERE amka='"+patient.getAmka()+"'");
			statement.executeUpdate("UPDATE History SET FamHi='"+txt1+"', Allergies='"+txt2+"', Medication='"+txt3+"', Visits='"+txt4+
					"', MedTest='"+txt5+"', SurgeryHi='"+txt6+"'"+" WHERE amkaID='"+patient.getAmka()+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	public void delPatient(Patient patient) {
		doConnection();
		int amka=patient.getAmka();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("DELETE FROM User WHERE amka='"+amka+"'");
			statement.executeUpdate("DELETE FROM History WHERE amkaID='"+amka+"'");
			statement.executeUpdate("DELETE FROM Patient WHERE amka='"+amka+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	public void delAppointment(Appointment ap) {
		doConnection();
		int amka=ap.getAmka();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("DELETE FROM Appointment WHERE amka='"+amka+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	public DefaultListModel getAppointment() throws SQLException {
		doConnection();
		DefaultListModel list=new DefaultListModel();
		Statement statement=connection.createStatement();
		ResultSet result=statement.executeQuery("SELECT * FROM Appointment ORDER BY date , time");
		while(result.next()) {
				list.addElement(new Appointment(result.getString(1),Double.valueOf(result.getString(2)),Integer.valueOf(result.getString(3)),
						java.sql.Date.valueOf(result.getString(4)),Integer.valueOf(result.getString(5))));
			}
		statement.close();
		return list;
	}
	
	public void setAppointment(String name,double time,int priority,Date date,int amka) {
		doConnection();
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate("INSERT INTO Appointment(fullname,time,priority,date,amka) VALUES('"+name+"','"+time+"','"+priority+
					"','"+date+"','"+amka+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeConnection();
	}
	
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
