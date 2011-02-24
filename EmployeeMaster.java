import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
class EmployeeMaster extends JFrame implements ActionListener
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel lempid,lempfname,lemplname,lempaddr,lempcontact,lempmob,lempfax,lempemail,lempdesig;
	JTextField tempid,tempfname,templname,tempcontact,tempmob,tempfax,tempemail;
	JTextArea tempaddr;
	JComboBox cempdesig;
	JButton bfirst,bprevious,bnext,blast,badd,bedit,bdelete,bsave;
	GridBagLayout gb;
	GridBagConstraints gbc;
	Connection con;
	Statement st;
	ResultSet rs;
	EmployeeMaster()
	{
		try
		{
	Container c=getContentPane();
	 c.setLayout(new FlowLayout());
	 String sdesig[]={"Manager","Admin","Assistant manager"};
	 gb=new GridBagLayout();
	 gbc=new GridBagConstraints();
	 getContentPane().setLayout(gb);
	 head=new JLabel("Employee Master Form");
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
	 lempid=new JLabel("Employee Id");
	 lempfname=new JLabel("First Name");
	 lemplname=new JLabel("Last Name");
	 lempaddr=new JLabel("Address");
	 lempcontact=new JLabel("Contact");
	lempmob=new JLabel("Mobile");
	lempfax=new JLabel("Fax");
 	lempemail=new JLabel("EMail");
	lempdesig=new JLabel("Designation");


	tempid=new JTextField(10);
	 tempfname=new JTextField(10);
	 templname=new JTextField(10);
	 tempaddr=new JTextArea(5,10);
	tempcontact=new JTextField(10);
	tempmob=new JTextField(10);
	tempfax=new JTextField(10);
	tempemail=new JTextField(20);
	//tcustcomments=new JTextArea(5,10);
	cempdesig=new JComboBox(sdesig);
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
	 lempid.setFont(fcontrols);
	 lempfname.setFont(fcontrols);
	 lemplname.setFont(fcontrols);
	 lempaddr.setFont(fcontrols);
	 lempcontact.setFont(fcontrols);
	 lempmob.setFont(fcontrols);
	 lempfax.setFont(fcontrols);
	 lempemail.setFont(fcontrols);
	 lempdesig.setFont(fcontrols);
	 lempid.setForeground(Color.red);
	 lempfname.setForeground(Color.red);
 	 lemplname.setForeground(Color.red);
	 lempaddr.setForeground(Color.red);
	 lempcontact.setForeground(Color.red);
	lempmob.setForeground(Color.red);
	lempfax.setForeground(Color.red);
	lempemail.setForeground(Color.red);
	lempdesig.setForeground(Color.red);
	//---------------------------------------------------------
	gbc.gridx=1;
	gbc.gridy=4;
	gb.setConstraints(lempid,gbc);
	getContentPane().add(lempid);
	 gbc.gridx=1;
	gbc.gridy=7;
	gb.setConstraints(lempfname,gbc);
	getContentPane().add(lempfname);

	 gbc.gridx=1;
	gbc.gridy=10;
	gb.setConstraints(lemplname,gbc);
	getContentPane().add(lemplname);
	 gbc.gridx=1;
	gbc.gridy=13;
	gb.setConstraints(lempaddr,gbc);
	getContentPane().add(lempaddr);
	 gbc.gridx=1;
	gbc.gridy=16;
	gb.setConstraints(lempcontact,gbc);
	getContentPane().add(lempcontact);
	gbc.gridx=1;
	gbc.gridy=19;
	gb.setConstraints(lempmob,gbc);
	getContentPane().add(lempmob);
	gbc.gridx=1;
	gbc.gridy=22;
	gb.setConstraints(lempfax,gbc);
	getContentPane().add(lempfax);
	gbc.gridx=1;
	gbc.gridy=25;
	gb.setConstraints(lempemail,gbc);
	getContentPane().add(lempemail);
	gbc.gridx=1;
	gbc.gridy=28;
	gb.setConstraints(lempdesig,gbc);
	getContentPane().add(lempdesig);
	//------------------------------------------------------------------
	gbc.gridx=3;
	gbc.gridy=4;
	gb.setConstraints(tempid,gbc);
	getContentPane().add(tempid);
	gbc.gridx=3;
	gbc.gridy=7;
	gb.setConstraints(tempfname,gbc);
	getContentPane().add(tempfname);
	gbc.gridx=3;
	gbc.gridy=10;
	gb.setConstraints(templname,gbc);
	getContentPane().add(templname);
	gbc.gridx=3;
	gbc.gridy=13;
	gb.setConstraints(tempaddr,gbc);
	getContentPane().add(tempaddr);
	gbc.gridx=3;
	gbc.gridy=16;
	gb.setConstraints(tempcontact,gbc);
	getContentPane().add(tempcontact);
	gbc.gridx=3;
	gbc.gridy=19;
	gb.setConstraints(tempmob,gbc);
	getContentPane().add(tempmob);
	gbc.gridx=3;
	gbc.gridy=22;
	gb.setConstraints(tempfax,gbc);
	getContentPane().add(tempfax);
	gbc.gridx=3;
	gbc.gridy=25;
	gb.setConstraints(tempemail,gbc);
	getContentPane().add(tempemail);
	gbc.gridx=3;
	gbc.gridy=28;
	gb.setConstraints(cempdesig,gbc);
	getContentPane().add(cempdesig);
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
	gbc.gridy=16;
	gb.setConstraints(jpbutton,gbc);
	getContentPane().add(jpbutton);

	//----------------------------------------------------------------
	setSize(1000,1000);
	pack();
	setVisible(true);
	con = DConnection.getConnection();
	String query1 = "select * from t_employee_master";
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
		try
		{
			System.out.println(ae.getSource());
	if(ae.getSource()==this.badd)
	{
		JOptionPane.showMessageDialog(this,"Add is hit..");
		tempid.setText("");
		tempfname.setText("");
		templname.setText("");
		tempcontact.setText("");
		tempmob.setText("");
		tempfax.setText("");
		tempemail.setText("");
		tempaddr.setText("");

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
		PreparedStatement pst=con.prepareStatement("insert into t_employee_master values('"+ tempid.getText()+"','"+ tempfname.getText()+"','"+ templname.getText()+"','"+ tempaddr.getText()+"','"+ tempcontact.getText()+"','"+ tempmob.getText()+"','"+ tempfax.getText()+"','"+ tempemail.getText()+"')");
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
		String str="update t_employee_master set E_ID='"+ tempid.getText() +"',Fname='"+ tempfname.getText() +"',Lname='"+ templname.getText() +"',Address='"+ tempaddr.getText() +"',contact='"+ tempcontact.getText() +"',mobile='"+ tempmob.getText() +"',fax='" + tempfax.getText() +"',email='"+ tempfax.getText()+ "' where E_ID = '" + tempid.getText() + "'";
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
		PreparedStatement pst=con.prepareStatement("delete from t_employee_master where E_ID = '" + tempid.getText() + "'");
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
		try
			{
			 tempid.setText(rs.getString(1));
			 tempfname.setText(rs.getString(2));
			 templname.setText(rs.getString(3));
			 tempcontact.setText(rs.getString(4));
			 tempmob.setText(rs.getString(5));
			 tempfax.setText(rs.getString(6));
			 tempemail.setText(rs.getString(7));
			 tempaddr.setText(rs.getString(8));
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

//---------------------------------------------------------------------------
  	public static void main(String args[])
	{
 	EmployeeMaster em=new EmployeeMaster();

	}
}
