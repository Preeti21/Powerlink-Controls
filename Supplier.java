import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class Supplier extends JFrame implements ActionListener
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel lsuppid,lsuppname,lsuppaddr,lsuppcontact,lsuppmob,lsuppfax,lsuppemail,lsuppcomments;
	JTextField tsuppid,tsuppname,tsuppcontact,tsuppmob,tsuppfax,tsuppemail;
	JTextArea tsuppaddr,tsuppcomments;
	//JComboBox csupplier;
	JButton bfirst,bprevious,bnext,blast,badd,bedit,bdelete,bsave;
	GridBagLayout gb;
	GridBagConstraints gbc;
	Connection con;
	Statement st;
	ResultSet rs;
	Supplier()
	{
		try
		{


	Container c=getContentPane();
	 c.setLayout(new FlowLayout());
	//String ssupplier[]={"L&T","abc","xyz"};
	 gb=new GridBagLayout();
	 gbc=new GridBagConstraints();
	 getContentPane().setLayout(gb);
	 head=new JLabel("Supplier Details Form");
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
	 lsuppid=new JLabel("Supplier Id");
	 lsuppname=new JLabel("Name");
	 //lcustlname=new JLabel("Last Name");
	 lsuppaddr=new JLabel("Address");
	 lsuppcontact=new JLabel("Contact");
	lsuppmob=new JLabel("Mobile");
	lsuppfax=new JLabel("Fax");
 	lsuppemail=new JLabel("EMail");
	lsuppcomments=new JLabel("Comments");


	tsuppid=new JTextField(10);
	 tsuppname=new JTextField(10);
	 //tcustlname=new JTextField(10);
	 tsuppaddr=new JTextArea(5,10);
	tsuppcontact=new JTextField(10);
	tsuppmob=new JTextField(10);
	tsuppfax=new JTextField(10);
	tsuppemail=new JTextField(20);
	tsuppcomments=new JTextArea(5,10);
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
	 lsuppid.setFont(fcontrols);
	 lsuppname.setFont(fcontrols);
	 //lcustlname.setFont(fcontrols);
	 lsuppaddr.setFont(fcontrols);
	 lsuppcontact.setFont(fcontrols);
	 lsuppmob.setFont(fcontrols);
	 lsuppfax.setFont(fcontrols);
	 lsuppemail.setFont(fcontrols);
	 lsuppcomments.setFont(fcontrols);
	 lsuppid.setForeground(Color.red);
	 lsuppname.setForeground(Color.red);
 	 //lcustlname.setForeground(Color.red);
	 lsuppaddr.setForeground(Color.red);
	 lsuppcontact.setForeground(Color.red);
	lsuppmob.setForeground(Color.red);
	lsuppfax.setForeground(Color.red);
	lsuppemail.setForeground(Color.red);
	lsuppcomments.setForeground(Color.red);
	//---------------------------------------------------------
	gbc.gridx=1;
	gbc.gridy=4;
	gb.setConstraints(lsuppid,gbc);
	getContentPane().add(lsuppid);
	 gbc.gridx=1;
	gbc.gridy=7;
	gb.setConstraints(lsuppname,gbc);
	getContentPane().add(lsuppname);

	// gbc.gridx=1;
	//gbc.gridy=10;
	//gb.setConstraints(lcustlname,gbc);
	//getContentPane().add(lcustlname);
	 gbc.gridx=1;
	gbc.gridy=10;
	gb.setConstraints(lsuppaddr,gbc);
	getContentPane().add(lsuppaddr);
	 gbc.gridx=1;
	gbc.gridy=13;
	gb.setConstraints(lsuppcontact,gbc);
	getContentPane().add(lsuppcontact);
	gbc.gridx=1;
	gbc.gridy=16;
	gb.setConstraints(lsuppmob,gbc);
	getContentPane().add(lsuppmob);
	gbc.gridx=1;
	gbc.gridy=19;
	gb.setConstraints(lsuppfax,gbc);
	getContentPane().add(lsuppfax);
	gbc.gridx=1;
	gbc.gridy=22;
	gb.setConstraints(lsuppemail,gbc);
	getContentPane().add(lsuppemail);
	gbc.gridx=1;
	gbc.gridy=25;
	gb.setConstraints(lsuppcomments,gbc);
	getContentPane().add(lsuppcomments);
	//------------------------------------------------------------------
	gbc.gridx=3;
	gbc.gridy=4;
	gb.setConstraints(tsuppid,gbc);
	getContentPane().add(tsuppid);
	gbc.gridx=3;
	gbc.gridy=7;
	gb.setConstraints(tsuppname,gbc);
	getContentPane().add(tsuppname);
	//gbc.gridx=3;
	//gbc.gridy=10;
	//gb.setConstraints(tcustlname,gbc);
	//getContentPane().add(tcustlname);
	gbc.gridx=3;
	gbc.gridy=10;
	gb.setConstraints(tsuppaddr,gbc);
	getContentPane().add(tsuppaddr);
	gbc.gridx=3;
	gbc.gridy=13;
	gb.setConstraints(tsuppcontact,gbc);
	getContentPane().add(tsuppcontact);
	gbc.gridx=3;
	gbc.gridy=16;
	gb.setConstraints(tsuppmob,gbc);
	getContentPane().add(tsuppmob);
	gbc.gridx=3;
	gbc.gridy=19;
	gb.setConstraints(tsuppfax,gbc);
	getContentPane().add(tsuppfax);
	gbc.gridx=3;
	gbc.gridy=22;
	gb.setConstraints(tsuppemail,gbc);
	getContentPane().add(tsuppemail);
	gbc.gridx=3;
	gbc.gridy=25;
	gb.setConstraints(tsuppcomments,gbc);
	getContentPane().add(tsuppcomments);
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
	//---------------------------------------------------------------
	gbc.gridx=22;
	gbc.gridy=10;
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
	String query1 = "select * from t_supplier_master";
	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = st.executeQuery(query1);
	/*while (rs.next())
	{
		System.out.println("From Database supplier Name : " + rs.getString(2));
	}*/
		}catch(Exception e){}
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
				tsuppid.setText("");
				tsuppname.setText("");
				tsuppcontact.setText("");
				tsuppmob.setText("");
				tsuppfax.setText("");
				tsuppemail.setText("");
				tsuppaddr.setText("");
				tsuppcomments.setText("");

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
				PreparedStatement pst=con.prepareStatement("insert into t_supplier_master values('"+ tsuppid.getText()+"','"+ tsuppname.getText()+"','"+ tsuppaddr.getText()+"','"+ tsuppcontact.getText()+"','"+ tsuppmob.getText()+"','"+ tsuppfax.getText()+"','"+ tsuppemail.getText()+"','"+ tsuppcomments.getText()+"')");
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
				String str="update t_supplier_master set S_ID='"+ tsuppid.getText() +"',Sname='"+ tsuppname.getText() +"',Address='"+ tsuppaddr.getText() +"',contact='"+ tsuppcontact.getText() +"',mobile='"+ tsuppmob.getText() +"',fax='" + tsuppfax.getText() +"',email='"+ tsuppemail.getText()+"',comments='"+ tsuppcomments.getText()+ "' where S_ID = '" + tsuppid.getText() + "'";
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
				PreparedStatement pst=con.prepareStatement("delete from t_supplier_master where S_ID = '" + tsuppid.getText() + "'");
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

					tsuppid.setText(rs.getString(1));
					tsuppname.setText(rs.getString(2));
					tsuppcontact.setText(rs.getString(3));
					tsuppmob.setText(rs.getString(4));
					tsuppfax.setText(rs.getString(5));
					tsuppemail.setText(rs.getString(6));
					tsuppaddr.setText(rs.getString(7));
					tsuppcomments.setText(rs.getString(8));
					}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				}

//---------------------------------------------------------------------------
  	public static void main(String args[])
	{
 	Supplier supp=new Supplier();

	}
}
