import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
class CurrencyMaster extends JFrame implements ActionListener
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel lcurrcode,lcurrvalue;
	JTextField tcurrcode,tcurrvalue;
	JButton bfirst,bprevious,bnext,blast,badd,bedit,bdelete,bsave;
	GridBagLayout gb;
	GridBagConstraints gbc;
	Connection con;
	Statement st;
	ResultSet rs;
	CurrencyMaster()
	{
		try
		{
			Container c=getContentPane();
	 c.setLayout(new FlowLayout());
	 gb=new GridBagLayout();
	 gbc=new GridBagConstraints();
	 getContentPane().setLayout(gb);
	 head=new JLabel("Currency Master Form");
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
//-----------------------------------------------------------------------
	 lcurrcode=new JLabel("Currency Code");
	 lcurrvalue=new JLabel("Currency Value");
//-----------------------------------------------------------------------
	 tcurrcode=new JTextField(10);
	 tcurrvalue=new JTextField(10);
//-----------------------------------------------------------------------
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


	 lcurrcode.setFont(fcontrols);
	 lcurrvalue.setFont(fcontrols);
	 lcurrcode.setForeground(Color.red);
	 lcurrvalue.setForeground(Color.red);
//-----------------------------------------------------------------------
	gbc.gridx=1;
	gbc.gridy=7;
	gb.setConstraints(lcurrcode,gbc);
	getContentPane().add(lcurrcode);
	 gbc.gridx=1;
	gbc.gridy=14;
	gb.setConstraints(lcurrvalue,gbc);
	getContentPane().add(lcurrvalue);
//-----------------------------------------------------------------------
	gbc.gridx=3;
	gbc.gridy=7;
	gb.setConstraints(tcurrcode,gbc);
	getContentPane().add(tcurrcode);
	gbc.gridx=3;
	gbc.gridy=14;
	gb.setConstraints(tcurrvalue,gbc);
	getContentPane().add(tcurrvalue);
//-----------------------------------------------------------------------
/*	gbc.gridx=1;
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
	getContentPane().add(bsave);*/
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
	//System.out.println("111111111111");
	con = DConnection.getConnection();
	//System.out.println("111111111111");
	String query1 = "select * from t_currency_master";
	//System.out.println("111111111111");
	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	//System.out.println("111111111111");
	rs = st.executeQuery(query1);
	//System.out.println("22222");
	rs.next();
	//System.out.println("3333");
	System.out.println(rs.getString(1));
	//rs.next();
		tcurrcode.setText(rs.getString(1));
		tcurrvalue.setText(rs.getString(2));
	rs.first();
		}
		catch(Exception e){
			e.printStackTrace();
		}
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
		tcurrcode.setText("");
		tcurrvalue.setText("");


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
		PreparedStatement pst=con.prepareStatement("insert into t_currency_master values('"+ tcurrcode.getText()+"','"+ tcurrvalue.getText()+"')");
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
		String str="update t_currency_master set Curr_CD='"+ tcurrcode.getText() +"',value='"+ tcurrvalue.getText() +"' where Curr_CD = '" + tcurrcode.getText() + "'";
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
		PreparedStatement pst=con.prepareStatement("delete from t_currency_master where Curr_CD = '" + tcurrcode.getText() + "'");
	int x=pst.executeUpdate();
	if(x>0)
	JOptionPane.showMessageDialog(this,"Record Deleted Successfully");
	else
	JOptionPane.showMessageDialog(this,"Error While Deleting Record");
	bindData();
	}
		}
		catch(Exception e){e.printStackTrace();}

}
	public void bindData()
	{
		try{
			tcurrcode.setText(rs.getString(1));
			tcurrvalue.setText(rs.getString(2));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

//---------------------------------------------------------------------------
  	public static void main(String args[])
	{
 	CurrencyMaster curr=new CurrencyMaster();

	}
}
