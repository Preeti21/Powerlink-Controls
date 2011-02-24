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
class Customer extends JFrame implements ActionListener
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel lcustid,lcustfname,lcustlname,lcustaddr,lcustcontact,lcustmob,lcustfax,lcustemail,lcustcomments;
	JTextField tcustid,tcustfname,tcustlname,tcustcontact,tcustmob,tcustfax,tcustemail;
	JTextArea tcustaddr,tcustcomments;
	//JComboBox csupplier;
	JButton bfirst,bprevious,bnext,blast,badd,bedit,bdelete,bsave;
	GridBagLayout gb;
	GridBagConstraints gbc;
	Connection con;
	Statement st;
	ResultSet rs;
	Customer()
	{
		try{
	Container c=getContentPane();
	 c.setLayout(new FlowLayout());
	//String ssupplier[]={"L&T","abc","xyz"};
	 gb=new GridBagLayout();
	 gbc=new GridBagConstraints();
	 getContentPane().setLayout(gb);
	 head=new JLabel("Customer Details Form");
	 fhead=new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,30);
	 fcontrols=new Font("Trebuchet MS",Font.BOLD,15);
	 head.setFont(fhead);
	 head.setForeground(Color.blue);
	 //setSize(500,600);
	 //setVisible(true);
	 getContentPane().setBackground(Color.cyan);
	 gbc.anchor=GridBagConstraints.NORTHWEST;
	 gbc.gridx=3;
	 gbc.gridy=1;
	 gb.setConstraints(head,gbc);
	 getContentPane().add(head);
	//-----------------------------------------------------------
	 lcustid=new JLabel("Customer Id");
	 lcustfname=new JLabel("First Name");
	 lcustlname=new JLabel("Last Name");
	 lcustaddr=new JLabel("Address");
	 lcustcontact=new JLabel("Contact");
	lcustmob=new JLabel("Mobile");
	lcustfax=new JLabel("Fax");
 	lcustemail=new JLabel("EMail");
	lcustcomments=new JLabel("Comments");


	tcustid = new JTextField(10);
	 tcustfname=new JTextField(10);
	 tcustlname=new JTextField(10);
	 tcustaddr=new JTextArea(5,10);
	tcustcontact=new JTextField(10);
	tcustmob=new JTextField(10);
	tcustfax=new JTextField(10);
	tcustemail=new JTextField(20);
	tcustcomments=new JTextArea(5,10);
	//csupplier=new JComboBox(ssupplier);
	 badd = new JButton("Add");
	 bedit = new JButton("Edit");
	 bsave = new JButton("    Save    ");
	 bdelete = new JButton("   Delete   ");
	 bfirst = new JButton("  << First  ");
	 bprevious = new JButton(" < Previous ");
	 bnext = new JButton("   Next  >  ");
	 blast = new JButton("  Last  >>  ");

//-----------------------------------------------------------------------
	 badd.addActionListener(this);
	 bedit.addActionListener(this);
	 bsave.addActionListener(this);
	 bdelete.addActionListener(this);
	 bfirst.addActionListener(this);
	 bprevious.addActionListener(this);
	 bnext.addActionListener(this);
	 blast.addActionListener(this);

//-----------------------------------------------------------------------
	 lcustid.setFont(fcontrols);
	 lcustfname.setFont(fcontrols);
	 lcustlname.setFont(fcontrols);
	 lcustaddr.setFont(fcontrols);
	 lcustcontact.setFont(fcontrols);
	 lcustmob.setFont(fcontrols);
	 lcustfax.setFont(fcontrols);
	 lcustemail.setFont(fcontrols);
	 lcustcomments.setFont(fcontrols);
	 lcustid.setForeground(Color.red);
	 lcustfname.setForeground(Color.red);
 	 lcustlname.setForeground(Color.red);
	 lcustaddr.setForeground(Color.red);
	 lcustcontact.setForeground(Color.red);
	lcustmob.setForeground(Color.red);
	lcustfax.setForeground(Color.red);
	lcustemail.setForeground(Color.red);
	lcustcomments.setForeground(Color.red);
	//---------------------------------------------------------
	gbc.gridx=1;
	gbc.gridy=4;
	gb.setConstraints(lcustid,gbc);
	getContentPane().add(lcustid);
	 gbc.gridx=1;
	gbc.gridy=7;
	gb.setConstraints(lcustfname,gbc);
	getContentPane().add(lcustfname);

	 gbc.gridx=1;
	gbc.gridy=10;
	gb.setConstraints(lcustlname,gbc);
	getContentPane().add(lcustlname);
	 gbc.gridx=1;
	gbc.gridy=13;
	gb.setConstraints(lcustaddr,gbc);
	getContentPane().add(lcustaddr);
	 gbc.gridx=1;
	gbc.gridy=16;
	gb.setConstraints(lcustcontact,gbc);
	getContentPane().add(lcustcontact);
	gbc.gridx=1;
	gbc.gridy=19;
	gb.setConstraints(lcustmob,gbc);
	getContentPane().add(lcustmob);
	gbc.gridx=1;
	gbc.gridy=22;
	gb.setConstraints(lcustfax,gbc);
	getContentPane().add(lcustfax);
	gbc.gridx=1;
	gbc.gridy=25;
	gb.setConstraints(lcustemail,gbc);
	getContentPane().add(lcustemail);
	gbc.gridx=1;
	gbc.gridy=28;
	gb.setConstraints(lcustcomments,gbc);
	getContentPane().add(lcustcomments);
	//------------------------------------------------------------------
	gbc.gridx=3;
	gbc.gridy=4;
	gb.setConstraints(tcustid,gbc);
	getContentPane().add(tcustid);
	gbc.gridx=3;
	gbc.gridy=7;
	gb.setConstraints(tcustfname,gbc);
	getContentPane().add(tcustfname);
	gbc.gridx=3;
	gbc.gridy=10;
	gb.setConstraints(tcustlname,gbc);
	getContentPane().add(tcustlname);
	gbc.gridx=3;
	gbc.gridy=13;
	gb.setConstraints(tcustaddr,gbc);
	getContentPane().add(tcustaddr);
	gbc.gridx=3;
	gbc.gridy=16;
	gb.setConstraints(tcustcontact,gbc);
	getContentPane().add(tcustcontact);
	gbc.gridx=3;
	gbc.gridy=19;
	gb.setConstraints(tcustmob,gbc);
	getContentPane().add(tcustmob);
	gbc.gridx=3;
	gbc.gridy=22;
	gb.setConstraints(tcustfax,gbc);
	getContentPane().add(tcustfax);
	gbc.gridx=3;
	gbc.gridy=25;
	gb.setConstraints(tcustemail,gbc);
	getContentPane().add(tcustemail);
	gbc.gridx=3;
	gbc.gridy=28;
	gb.setConstraints(tcustcomments,gbc);
	getContentPane().add(tcustcomments);
	//-----------------------------------------------------------------
	gbc.gridx=1;
	gbc.gridy=31;
	gb.setConstraints(bfirst,gbc);
	getContentPane().add(bfirst);
	gbc.gridx=7;
	gbc.gridy=31;
	gb.setConstraints(bprevious,gbc);
	getContentPane().add(bprevious);
	gbc.gridx=14;
	gbc.gridy=31;
	gb.setConstraints(bnext,gbc);
	getContentPane().add(bnext);
	gbc.gridx=21;
	gbc.gridy=31;
	gb.setConstraints(blast,gbc);
	getContentPane().add(blast);
	gbc.gridx=22;
	gbc.gridy=10;
	//---------------------------------------------------------------
	gb.setConstraints(badd,gbc);
	getContentPane().add(badd);
	gbc.gridx=22;
	gbc.gridy=16;
	gb.setConstraints(bedit,gbc);
	getContentPane().add(bedit);
	gbc.gridx=22;
	gbc.gridy=22;
	gb.setConstraints(bdelete,gbc);
	getContentPane().add(bdelete);
	gbc.gridx=22;
	gbc.gridy=28;
	gb.setConstraints(bsave,gbc);
	getContentPane().add(bsave);
	//----------------------------------------------------------------

	JPanel jpbutton = new JPanel();
	jpbutton.setLayout(new FlowLayout());
	jpbutton.add(bfirst);
	jpbutton.add(bprevious);
	jpbutton.add(bnext);
	jpbutton.add(blast);
	jpbutton.setBackground(Color.BLUE);

	gbc.gridx=1;
	gbc.gridy=31;
	gb.setConstraints(jpbutton,gbc);
	getContentPane().add(jpbutton);

	JPanel jpbutton1 = new JPanel();
	jpbutton1.setLayout(new FlowLayout());
	jpbutton1.add(badd);
	jpbutton1.add(bedit);
	jpbutton1.add(bdelete);
	jpbutton1.add(bsave);
	jpbutton1.setBackground(Color.BLUE);

	gbc.gridx=22;
	gbc.gridy=10;
	gb.setConstraints(jpbutton,gbc);
	getContentPane().add(jpbutton);

	//----------------------------------------------------------------
	setSize(1000,1000);
	pack();
	setVisible(true);
	con = DConnection.getConnection();
	String query1 = "select * from t_customer_master";
	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = st.executeQuery(query1);
	/*while (rs.next())
	{
		System.out.println("From Database Customer Name : " + rs.getString(2));
	}*/
		}
		catch(Exception e){}
	}
//------------------------------------------------------------------------
	public void actionPerformed(ActionEvent ae)
{
		try{
			System.out.println(ae.getSource());
	if(ae.getSource()==this.badd)
	{
		JOptionPane.showMessageDialog(this,"Add is hit..");
		tcustid.setText("");
		tcustfname.setText("");
		tcustlname.setText("");
		tcustcontact.setText("");
		tcustmob.setText("");
		tcustfax.setText("");
		tcustemail.setText("");
		tcustaddr.setText("");
		tcustcomments.setText("");

		bsave.setEnabled(true);
		bedit.setEnabled(false);
		bdelete.setEnabled(false);
		bfirst.setEnabled(false);
		bprevious.setEnabled(false);
		bnext.setEnabled(false);
		blast.setEnabled(false);
		badd.setEnabled(false);


	}
		else if (ae.getSource()== this.bfirst)
	{

		rs.first();
		bindData();
	}
	else if(ae.getSource()==bprevious)
	{
		if(rs.isFirst())
		{
		rs.last();
		}
		else
		{
		rs.previous();
		}
		bindData();
	}
	else if(ae.getSource()==bnext)
	{
		if(rs.isLast())
		{
		rs.first();
		}
		else
		{
		rs.next();
		}
		bindData();

	}
	else if(ae.getSource()==blast)
	{rs.last();
	bindData();
	}
	else if(ae.getSource()==bsave)
	{
		String query1 = "select * from t_currency_master";
		bsave.setEnabled(false);
		bedit.setEnabled(true);
		badd.setEnabled(true);
		bdelete.setEnabled(true);
		bfirst.setEnabled(true);
		bprevious.setEnabled(true);
		bnext.setEnabled(true);
		blast.setEnabled(true);
		PreparedStatement pst=con.prepareStatement("insert into t_customer_master values('"+ tcustid.getText()+"','"+ tcustlname.getText()+"','"+ tcustfname.getText()+"','"+ tcustcontact.getText()+"','"+ tcustmob.getText()+"','"+ tcustfax.getText()+"','"+ tcustemail.getText()+"','"+ tcustaddr.getText()+"','"+ tcustcomments.getText()+"')");
		int x=pst.executeUpdate();
		System.out.println("Update count ..." + x);
		if(x>0)
		JOptionPane.showMessageDialog(this,"Record Added Successfully");
		else
		JOptionPane.showMessageDialog(this,"Error While Adding Records");
		bindData();
		rs = st.executeQuery(query1);
		rs.next();
	}
	else if(ae.getSource()==bedit)
	{
		String str="update t_customer_master set C_ID='"+ tcustid.getText() +"',Lname='"+ tcustlname.getText() +"',Fname='"+ tcustfname.getText() +"',Address='"+ tcustaddr.getText() +"',contact='"+ tcustcontact.getText() +"',mobile='"+ tcustmob.getText() +"',fax='" + tcustfax.getText() +"',email='"+ tcustemail.getText()+"',comments='"+ tcustcomments.getText()+ "' where C_ID = '" + tcustid.getText() + "'";
		PreparedStatement pst=con.prepareStatement(str);
		int x=pst.executeUpdate();
		if(x>0)
		JOptionPane.showMessageDialog(this,"Record Updated Successfully");
		else
		JOptionPane.showMessageDialog(this,"Error While Updating Record");
		bindData();
	}
	else if(ae.getSource()==bdelete)
	{
		PreparedStatement pst=con.prepareStatement("delete from t_customer_master where C_ID = '" + tcustid.getText() + "'");
	int x=pst.executeUpdate();
	if(x>0)
	JOptionPane.showMessageDialog(this,"Record Deleted Successfully");
	else
	JOptionPane.showMessageDialog(this,"Error While Deleting Record");
	}
		}
		catch(Exception e){e.printStackTrace();}

}
	public void bindData()
	{
		try{

			tcustid.setText(rs.getString(1));
			tcustfname.setText(rs.getString(2));
			tcustlname.setText(rs.getString(3));
			tcustcontact.setText(rs.getString(4));
			tcustmob.setText(rs.getString(5));
			tcustfax.setText(rs.getString(6));
			tcustemail.setText(rs.getString(7));
			tcustaddr.setText(rs.getString(8));
			tcustcomments.setText(rs.getString(9));
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
//---------------------------------------------------------------------------
  	public static void main(String args[])
	{
 	Customer cust=new Customer();

	}
}
