import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.*;
//import java.util.*;
//import java.util.regex.*;
class DeliveryNote extends JFrame
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel ldn_id,ldate,lsupplier,lcreditperiod,lvalidity,lordernum,ltaxcode,ltaxamt,ltaxableamt,ltaxableamtcal,laddtionaltax,lsurcharge,lcess,lcurrcode,lquantity;
	JTextField tdn_id,tdate,tcreditperiod,tvalidity,tordernum,ttaxcode,ttaxamt,taddtionaltax,tsurcharge,tcess,tcurrcode,tquantity;
	JComboBox csupplier;
	JButton newentry,change,delete,save,exit;
//--------------------------------------------------------------------------
	 
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	Connection con;
	DeliveryNote()
	{
		System.out.println("Here...........");
		try{
	 Container c=getContentPane();
	 c.setLayout(new FlowLayout());
	 //String ssupplier[]={"L&T","abc","xyz"};
	 gb=new GridBagLayout();
	 gbc=new GridBagConstraints();
	 getContentPane().setLayout(gb);
	 head=new JLabel("Delivery Note Form");
	 fhead=new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,30);
	 fcontrols=new Font("Trebuchet MS",Font.BOLD,15);
	 head.setFont(fhead);
	 head.setForeground(Color.blue);
	 getContentPane().setBackground(Color.cyan);
	 gbc.anchor=GridBagConstraints.NORTHWEST;
	 gbc.gridx=2;
	 gbc.gridy=1;
	 gb.setConstraints(head,gbc);
	 getContentPane().add(head);
	//-----------------------------------------------------------
	 ldn_id=new JLabel("Delivery Note Number");
	 ldate=new JLabel("Date");
	 lsupplier=new JLabel("Supplier");
	 lcreditperiod=new JLabel("Credit Period");
	 lvalidity=new JLabel("Validity");
	 lordernum=new JLabel("Order Number");
	 ltaxcode=new JLabel("Tax Code");
	 ltaxamt=new JLabel("Tax Amount");
	 ltaxableamt=new JLabel("Taxable Amt");
	 ltaxableamtcal=new JLabel("");
 	 laddtionaltax=new JLabel("Additional Tax : ");
 	lsurcharge=new JLabel("Surcharge :");
	 lcess=new JLabel("Cess : ");
	 lcurrcode=new JLabel("Currency Code");
	 lquantity=new JLabel("Quantity");

	 tdn_id= new JTextField(10);
	 tdate=new JTextField(10);
	 tcreditperiod=new JTextField(10);
	 tvalidity=new JTextField(10);
	 tordernum=new JTextField(10);
	 ttaxcode=new JTextField(10);
	 ttaxamt=new JTextField(10);
	 //ttaxableamt=new JTextField(10);
	 taddtionaltax=new JTextField(20);
	 tsurcharge=new JTextField(10);
	 tcess=new JTextField(10);
	 tcurrcode=new JTextField(10);
	 tquantity=new JTextField(10);
	 
	 csupplier=new JComboBox();
	 
	 newentry=new JButton("New Entry");
	 change=new JButton("Change");
	 delete=new JButton("Delete");
	 save=new JButton("Save");
	 exit=new JButton("Exit");
	 //-------------------------------------------------------------------------
	 DefaultTableModel model = new DefaultTableModel();
	 JTable jt=new JTable(model);
	 jt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	 jt.setAutoscrolls(true);
	   //jt.setSize(20,20);
	 model.addColumn("sr");
	 model.addColumn("Product");
	 model.addColumn("Description");
	 model.addColumn("Quantity");
	 model.addColumn("Unit");
	 model.addColumn("Rate");
	 model.addColumn("Discount(%)");
	 model.addColumn("Discount(Amt)");
	 model.addColumn("Tax Amt");
	 model.addColumn("Value");
	 model.addRow(new Object[]{"","","","","","","","","",""});
	 JScrollPane Pane=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 //Dimension d= new Dimension(20,20);
	 //Pane.setSize(20,20);
	 //model.setRowCount(10);
	 //jt.setPreferredSize(new Dimension(500,200));
	 Pane.setPreferredSize(new Dimension(400,200));
	 //f.add(Pane);

	
//-----------------------------------------------------------------------
	
//-----------------------------------------------------------------------
	 ldn_id.setFont(fcontrols);
	 ldate.setFont(fcontrols);
	 lsupplier.setFont(fcontrols);
	 lcreditperiod.setFont(fcontrols);
	 lvalidity.setFont(fcontrols);
	 lordernum.setFont(fcontrols);
	 ltaxcode.setFont(fcontrols);
	 ltaxamt.setFont(fcontrols);
	 ltaxableamt.setFont(fcontrols);
	 laddtionaltax.setFont(fcontrols);
	 lsurcharge.setFont(fcontrols);
	 lcess.setFont(fcontrols);
	 lcurrcode.setFont(fcontrols);
	 lquantity.setFont(fcontrols);
	 
	 ldn_id.setForeground(Color.red);
	 ldate.setForeground(Color.red);
	 lsupplier.setForeground(Color.red);
 	 lcreditperiod.setForeground(Color.red);
	 lvalidity.setForeground(Color.red);
	 lordernum.setForeground(Color.red);
	 ltaxcode.setForeground(Color.red);
	 ltaxamt.setForeground(Color.red);
	 ltaxableamt.setForeground(Color.red);
	 laddtionaltax.setForeground(Color.red);
	 lsurcharge.setForeground(Color.red);
	 lcess.setForeground(Color.red);
	 lcurrcode.setForeground(Color.red);
	 lquantity.setForeground(Color.red);
//-------------------------------------------------------------------------
	 gbc.gridx=1;
	 gbc.gridy=4;
	 gb.setConstraints(ldn_id,gbc);
	 getContentPane().add(ldn_id);
	
	 gbc.gridx=1;
	 gbc.gridy=7;
	 gb.setConstraints(ldate,gbc);
	 getContentPane().add(ldate);

	 gbc.gridx=1;
	 gbc.gridy=10;
	 gb.setConstraints(lsupplier,gbc);
	 getContentPane().add(lsupplier);
	 
	 gbc.gridx=2;
	gbc.gridy=4;
	gb.setConstraints(tdn_id,gbc);
	getContentPane().add(tdn_id);
	gbc.gridx=2;
	gbc.gridy=7;
	gb.setConstraints(tdate,gbc);
	gbc.gridx=2;
	getContentPane().add(tdate);
	gbc.gridy=10;
	gb.setConstraints(csupplier,gbc);
	getContentPane().add(csupplier);
 
	 gbc.gridx=3;
	 gbc.gridy=4;
	 gb.setConstraints(lcreditperiod,gbc);
	 getContentPane().add(lcreditperiod);
	 gbc.gridx=3;
	 gbc.gridy=7;
	 gb.setConstraints(lvalidity,gbc);
	 getContentPane().add(lvalidity);
	 gbc.gridx=3;
	 gbc.gridy=10;
	 gb.setConstraints(lordernum,gbc);
	 getContentPane().add(lordernum);
	 
 	gbc.gridx=4;
	gbc.gridy=4;
	gb.setConstraints(tcreditperiod,gbc);
	getContentPane().add(tcreditperiod);
	gbc.gridx=4;
	gbc.gridy=7;
	gb.setConstraints(tvalidity,gbc);
	getContentPane().add(tvalidity);
	gbc.gridx=4;
	gbc.gridy=10;
	gb.setConstraints(tordernum,gbc);
	getContentPane().add(tordernum);

	gbc.gridx=2;
	gbc.gridy=13;
	gb.setConstraints(Pane,gbc);
	getContentPane().add(Pane);
	
//	-----------------------------------------------------------------------------
	JPanel jpbutton = new JPanel();
	jpbutton.setLayout(new FlowLayout());
	jpbutton.add(newentry);
	jpbutton.add(change);
	jpbutton.add(delete);
	jpbutton.setBackground(Color.BLUE);
	
	gbc.gridx=2;
	gbc.gridy=30;
	gb.setConstraints(jpbutton,gbc);
	getContentPane().add(jpbutton);
	/*gbc.gridx=3;
	gbc.gridy=14;
	gb.setConstraints(change,gbc);
	getContentPane().add(change);
	gbc.gridx=3;
	gbc.gridy=15;
	gb.setConstraints(delete,gbc);
	getContentPane().add(delete);*/

//----------------------------------------------------------------

	 //---------------------------------------------------
	 gbc.gridx=1;
	 gbc.gridy=32;
	 gb.setConstraints(ltaxcode,gbc);
	 getContentPane().add(ltaxcode);
	 gbc.gridx=1;
	 gbc.gridy=36;
	 gb.setConstraints(ltaxamt,gbc);
	 getContentPane().add(ltaxamt);
	 gbc.gridx=1;
	 gbc.gridy=40;
	 gb.setConstraints(ltaxableamt,gbc);
	 getContentPane().add(ltaxableamt);
	 gbc.gridx=1;
	 gbc.gridy=44;
	 gb.setConstraints(laddtionaltax,gbc);
	 getContentPane().add(laddtionaltax);
	 gbc.gridx=1;
	 gbc.gridy=48;
	 gb.setConstraints(lsurcharge,gbc);
	 getContentPane().add(lsurcharge);
	 gbc.gridx=1;
	 gbc.gridy=52;
	 gb.setConstraints(lcess,gbc);
	 getContentPane().add(lcess);
	 gbc.gridx=1;
	 gbc.gridy=56;
	 gb.setConstraints(lcurrcode,gbc);
	 getContentPane().add(lcurrcode);
	 gbc.gridx=1;
	 gbc.gridy=60;
	 gb.setConstraints(lquantity,gbc);
	 getContentPane().add(lquantity);

	//------------------------------------------------------------------
	
	
	gbc.gridx=2;
	gbc.gridy=32;
	gb.setConstraints(ttaxcode,gbc);
	getContentPane().add(ttaxcode);
	gbc.gridy=36;
	gbc.gridx=2;
	gb.setConstraints(ttaxamt,gbc);
	getContentPane().add(ttaxamt);
	gbc.gridx=2;
	gbc.gridy=40;
	gb.setConstraints(ltaxableamtcal,gbc);
	getContentPane().add(ltaxableamtcal);
	gbc.gridx=2;
	gbc.gridy=44;
	gb.setConstraints(taddtionaltax,gbc);
	getContentPane().add(taddtionaltax);
	gbc.gridx=2;
	gbc.gridy=48;
	gb.setConstraints(tsurcharge,gbc);
	getContentPane().add(tsurcharge);
	gbc.gridx=2;
	gbc.gridy=52;
	gb.setConstraints(tcess,gbc);
	getContentPane().add(tcess);
	gbc.gridx=2;
	gbc.gridy=56;
	gb.setConstraints(tcurrcode,gbc);
	getContentPane().add(tcurrcode);
	gbc.gridx=2;
	gbc.gridy=60;
	gb.setConstraints(tquantity,gbc);
	getContentPane().add(tquantity);
	
	//---------------------------------------------------------------------
	JPanel jpbutton1 = new JPanel();
	jpbutton1.setLayout(new FlowLayout());
	jpbutton1.add(save);
	jpbutton1.add(exit);
	
	jpbutton1.setBackground(Color.BLUE);
	
	gbc.gridx=2;
	gbc.gridy=64;
	gb.setConstraints(jpbutton1,gbc);
	getContentPane().add(jpbutton1);
	//---------------------------------------------------------------------
	
	
	setSize(200,200);
	pack();
	setVisible(true);
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
	}
//--------------------------------------------------------------------------------

	//----------------------------------------------------------------------------

	public static void main(String args[])
	{
		DeliveryNote dn=new DeliveryNote();

	}
}
