

package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Journey_Details extends JFrame{  //Forth

    JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,Source,Destination,label,label1;
    JButton Show;

    public static void main(String[] args){
        new Journey_Details();
    }
    
    public Journey_Details(){
        
        setTitle("JOURNEY_DETAILS");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setLayout(null);
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Source.setBounds(60, 100, 150, 27);
	add(Source);
	
        Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);
		
	
		
	Show = new JButton("SHOW");
	Show.setBounds(680, 100, 100, 30);
	add(Show);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	ReservationDetails = new JLabel("JOURNEY DETAILS");
	ReservationDetails.setForeground(Color.BLUE);
	ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 359, 31);
	add(ReservationDetails);
		
	Pnrno = new JLabel("F CODE");
	Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Pnrno.setBounds(79, 270, 83, 20);
	add(Pnrno);
		
	Ticketid = new JLabel("F MODEL");
	Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Ticketid.setBounds(172, 270, 71, 20);
	add(Ticketid);
		
	Fcode = new JLabel("JNY DATE");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Fcode.setBounds(297, 270, 103, 20);
	add(Fcode);
		
	Jnydate = new JLabel("JNY_TIME");
	Jnydate.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Jnydate.setBounds(390, 270, 94, 20);
	add(Jnydate);
		
	Jnytime = new JLabel("CAPACITY");
	Jnytime.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Jnytime.setBounds(494, 270, 83, 20);
	add(Jnytime);
		
	Source = new JLabel("SOLD");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(613, 270, 94, 20);
	add(Source);
		
	Destination = new JLabel("CLASSNAME");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(717, 270, 94, 20);
	add(Destination);
        
	String[] items1 =  {"DHAKA", "INDIA", "LONDON", "DUBAI","QUTAR","JAPAN"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
		

	String[] items2 =  {"DHAKA", "INDIA", "LONDON", "DUBAI","QUTAR","JAPAN"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);
        
        table = new JTable();
	table.setBounds(38, 310, 800, 500);
	add(table);
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
//                    System.out.print(src +" "+  dst);
                    conn c = new conn();
                    
                    String str = "select f_code,flight_model,jny_date,jny_time,capacity,sold,class_name from flight where src = '"+src+"' and dst = '"+dst+"'";
                    ResultSet rs=c.s.executeQuery(str);
                    
                    if(rs.next()){
//                        System.out.print("OK");
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                    }else{
                        JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
                        
                    }					
                    
					
		}catch(Exception e){}
            }
	});
		
	setSize(860,600);
        setLocation(100,40);
	setVisible(true);
		
    }
}