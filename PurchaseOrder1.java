import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.*;
//import java.util.*;
//import java.util.regex.*;
class PurchaseOrder extends JFrame
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel lponum,ldate,lsupplier,lcreditperiod,lvalidity,lordernum,ltaxcode,ltaxamt,ltaxableamt,ltaxableamtcal,laddtionaltax,lsurcharge,lcess;
	JTextField tponum,tdate,tcreditperiod,tvalidity,tordernum,ttaxcode,ttaxamt,taddtionaltax,tsurcharge,tcess;
	JComboBox csupplier;
	JButton newentry,change,delete;
	
	//--------------------------------------------------------------------------
	 String data[][]={{"","","","","","","","","",""}};
	 String fields[]={"sr","Product Description","Quantity","Unit","Rate","Discount(%)","Discount(Amt)","Tax Amt","Value"};
	//--------------------------------------------------------------------------
	
	GridBagLayout gb;
	GridBagConstraints gbc;
	Connection con;
	Statement st;
	ResultSet rs;
	PurchaseOrder()
	{
		System.out.println("Here...........");
		try{
	 Container c=getContentPane();
	 c.setLayout(new FlowLayout());
	 String ssupplier[]={"L&T","abc","xyz"};
	 gb=new GridBagLayout();
	 gbc=new GridBagConstraints();
	 getContentPane().setLayout(gb);
	 head=new JLabel("Purchase Order Form");
	 fhead=new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,30);
	 fcontrols=new Font("Trebuchet MS",Font.BOLD,15);
	 head.setFont(fhead);
	 head.setForeground(Color.blue);
	 getContentPane().setBackground(Color.cyan);
	 gbc.anchor=GridBagConstraints.NORTHWEST;
	 gbc.gridx=3;
	 gbc.gridy=1;
	 gb.setConstraints(head,gbc);
	 getContentPane().add(head);
	//-----------------------------------------------------------
	 lponum=new JLabel("PO id: ");
	 ldate=new JLabel("Date : ");
	 lsupplier=new JLabel("Supplier: ");
	 lcreditperiod=new JLabel("Credit Period: ");
	 lvalidity=new JLabel("Validity: ");
	 lordernum=new JLabel("Order no.: ");
	 ltaxcode=new JLabel("Tax Code: ");
	 ltaxamt=new JLabel("Tax Amt");
	 ltaxableamt=new JLabel("Taxable Amt");
	 ltaxableamtcal=new JLabel("");
 	 laddtionaltax=new JLabel("Additional Tax : ");
 	lsurcharge=new JLabel("Surcharge :");
	 lcess=new JLabel("Cess : ");


	 tponum = new JTextField(10);
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
	 csupplier=new JComboBox(ssupplier);
	 
	 newentry=new JButton("New Entry");
	 change=new JButton("Change");
	 delete=new JButton("Delete");
	 
	 //-------------------------------------------------------------------------
	 
	 JTable jt=new JTable(data,fields);
	 JScrollPane Pane=new JScrollPane(jt);
	 //f.add(Pane);

	
//-----------------------------------------------------------------------
	
//-----------------------------------------------------------------------
	 lponum.setFont(fcontrols);
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

	 lponum.setForeground(Color.red);
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
//-------------------------------------------------------------------------
	 gbc.gridx=1;
	 gbc.gridy=4;
	 gb.setConstraints(lponum,gbc);
	 getContentPane().add(lponum);
	 gbc.gridx=1;
	 gbc.gridy=7;
	 gb.setConstraints(ldate,gbc);
	 getContentPane().add(ldate);

	 gbc.gridx=1;
	 gbc.gridy=10;
	 gb.setConstraints(lsupplier,gbc);
	 getContentPane().add(lsupplier);
	 gbc.gridx=7;
	 gbc.gridy=4;
	 gb.setConstraints(lcreditperiod,gbc);
	 getContentPane().add(lcreditperiod);
	 gbc.gridx=7;
	 gbc.gridy=7;
	 gb.setConstraints(lvalidity,gbc);
	 getContentPane().add(lvalidity);
	 gbc.gridx=7;
	 gbc.gridy=10;
	 gb.setConstraints(lordernum,gbc);
	 getContentPane().add(lordernum);
	 //---------------------------------------------------
	 gbc.gridx=3;
	 gbc.gridy=32;
	 gb.setConstraints(ltaxcode,gbc);
	 getContentPane().add(ltaxcode);
	 gbc.gridx=3;
	 gbc.gridy=36;
	 gb.setConstraints(ltaxamt,gbc);
	 getContentPane().add(ltaxamt);
	 gbc.gridx=3;
	 gbc.gridy=40;
	 gb.setConstraints(ltaxableamt,gbc);
	 getContentPane().add(ltaxableamt);
	 gbc.gridx=3;
	 gbc.gridy=44;
	 gb.setConstraints(laddtionaltax,gbc);
	 getContentPane().add(laddtionaltax);
	 gbc.gridx=3;
	 gbc.gridy=48;
	 gb.setConstraints(lsurcharge,gbc);
	 getContentPane().add(lsurcharge);
	 gbc.gridx=3;
	 gbc.gridy=52;
	 gb.setConstraints(lcess,gbc);
	 getContentPane().add(lcess);
	//------------------------------------------------------------------
	gbc.gridx=3;
	gbc.gridy=4;
	gb.setConstraints(tponum,gbc);
	getContentPane().add(tponum);
	gbc.gridx=3;
	gbc.gridy=7;
	gb.setConstraints(tdate,gbc);
	getContentPane().add(tdate);
	gbc.gridx=3;
	gbc.gridy=10;
	gb.setConstraints(csupplier,gbc);
	getContentPane().add(csupplier);
	gbc.gridx=13;
	gbc.gridy=4;
	gb.setConstraints(tcreditperiod,gbc);
	getContentPane().add(tcreditperiod);
	gbc.gridx=13;
	gbc.gridy=7;
	gb.setConstraints(tvalidity,gbc);
	getContentPane().add(tvalidity);
	gbc.gridx=13;
	gbc.gridy=10;
	gb.setConstraints(tordernum,gbc);
	getContentPane().add(tordernum);
	gbc.gridx=7;
	gbc.gridy=32;
	gb.setConstraints(ttaxcode,gbc);
	getContentPane().add(ttaxcode);
	gbc.gridx=7;
	gbc.gridy=36;
	gb.setConstraints(ttaxamt,gbc);
	getContentPane().add(ttaxamt);
	gbc.gridx=7;
	gbc.gridy=40;
	gb.setConstraints(ltaxableamtcal,gbc);
	getContentPane().add(ltaxableamtcal);
	gbc.gridx=7;
	gbc.gridy=44;
	gb.setConstraints(taddtionaltax,gbc);
	getContentPane().add(taddtionaltax);
	gbc.gridx=7;
	gbc.gridy=48;
	gb.setConstraints(tsurcharge,gbc);
	getContentPane().add(tsurcharge);
	gbc.gridx=7;
	gbc.gridy=52;
	gb.setConstraints(tcess,gbc);
	getContentPane().add(tcess);
	
	gbc.gridx=3;
	gbc.gridy=13;
	gb.setConstraints(Pane,gbc);
	getContentPane().add(Pane);
//-----------------------------------------------------------------------------
	gbc.gridx=1;
	gbc.gridy=56;
	gb.setConstraints(newentry,gbc);
	getContentPane().add(newentry);
	gbc.gridx=2;
	gbc.gridy=56;
	gb.setConstraints(change,gbc);
	getContentPane().add(change);
	gbc.gridx=3;
	gbc.gridy=56;
	gb.setConstraints(delete,gbc);
	getContentPane().add(delete);

//----------------------------------------------------------------
	setSize(200,200);
	pack();
	setVisible(true);
	con = DConnection.getConnection();
	String query1 = "select * from t_po";
	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = st.executeQuery(query1);
	/*while (rs.next())
	{
		System.out.println("From Database Customer Name : " + rs.getString(2));
	}*/

	}
		catch(Exception e){
			
			e.printStackTrace();
		}
	}
//--------------------------------------------------------------------------------

	//----------------------------------------------------------------------------

	public static void main(String args[])
	{
		PurchaseOrder obj=new PurchaseOrder();

	}
}



