import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
class ProductMaster extends JFrame implements ActionListener
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel lproid,lproname,lcatid,lcost,lprodesc;
	JTextField tproid,tproname,tcatid,tcost;
	JTextArea tprodesc;
	//JComboBox csupplier;
	JButton bfirst,bprevious,bnext,blast,badd,bedit,bdelete,bsave;
	GridBagLayout gb;
	GridBagConstraints gbc;
	Connection con;
	Statement st;
	ResultSet rs;
	ProductMaster()
	{
		try
		{
	Container c=getContentPane();
	 c.setLayout(new FlowLayout());
	String ssupplier[]={"L&T","abc","xyz"};
	 gb=new GridBagLayout();
	 gbc=new GridBagConstraints();
	 getContentPane().setLayout(gb);
	 head=new JLabel("Product Master Form");
	 fhead=new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,30);
	 fcontrols=new Font("Trebuchet MS",Font.BOLD,15);
	 head.setFont(fhead);
	 head.setForeground(Color.cyan);
	 //setSize(500,600);
	 //setVisible(true);
	 getContentPane().setBackground(Color.blue);
	 gbc.anchor=GridBagConstraints.NORTHWEST;
	 gbc.gridx=3;
	 gbc.gridy=1;
	 gb.setConstraints(head,gbc);
	 getContentPane().add(head);
	 //-------------------------------------------------------------------------------
	 lproid=new JLabel("Product Id");
	 lproname=new JLabel("Product Name");
	 lcost=new JLabel("Cost");
	 lprodesc=new JLabel("Description");
	 lcatid=new JLabel("Latlogue ID");
	 //-------------------------------------------------------------------------------
	 tproid=new JTextField(10);
	 tproname=new JTextField(20);
	 tcost=new JTextField(10);
	 tprodesc=new JTextArea(5,10);
	 tcatid=new JTextField(10);
	 //-------------------------------------------------------------------------------
	 badd = new JButton("Add");
	 bedit = new JButton("Edit");
	 bsave = new JButton("    Save    ");
	 bdelete = new JButton("   Delete   ");
	 bfirst = new JButton("  << First  ");
	 bprevious = new JButton(" < Previous ");
	 bnext = new JButton("   Next  >  ");
	 blast = new JButton("  Last  >>  ");

	 //--------------------------------------------------------------------------------
	 badd.addActionListener(this);
	 bedit.addActionListener(this);
	 bsave.addActionListener(this);
	 bdelete.addActionListener(this);
	 bfirst.addActionListener(this);
	 bprevious.addActionListener(this);
	 bnext.addActionListener(this);
	 blast.addActionListener(this);
	 //---------------------------------------------------------------------------------
	 lproid.setFont(fcontrols);
	 lproname.setFont(fcontrols);
	 lcost.setFont(fcontrols);
	 lprodesc.setFont(fcontrols);
	 lcatid.setFont(fcontrols);
	 lproid.setForeground(Color.red);
	 lproname.setForeground(Color.red);
 	 lcost.setForeground(Color.red);
	 lprodesc.setForeground(Color.red);
	 lcatid.setForeground(Color.red);
	 //---------------------------------------------------------------------------
	 gbc.gridx=1;
	gbc.gridy=4;
	gb.setConstraints(lproid,gbc);
	getContentPane().add(lproid);
	 gbc.gridx=1;
	gbc.gridy=7;
	gb.setConstraints(lproname,gbc);
	getContentPane().add(lproname);
	gbc.gridx=1;
	gbc.gridy=10;
	gb.setConstraints(lcatid,gbc);
	getContentPane().add(lcatid);
 	 gbc.gridx=1;
	gbc.gridy=13;
	gb.setConstraints(lcost,gbc);
	getContentPane().add(lcost);
	 gbc.gridx=1;
	gbc.gridy=16;
	gb.setConstraints(lprodesc,gbc);
	getContentPane().add(lprodesc);

	//-------------------------------------------------------------------------------------
	gbc.gridx=3;
	gbc.gridy=4;
	gb.setConstraints(tproid,gbc);
	getContentPane().add(tproid);
	gbc.gridx=3;
	gbc.gridy=7;
	gb.setConstraints(tproname,gbc);
	getContentPane().add(tproname);
	gbc.gridx=3;
	gbc.gridy=10;
	gb.setConstraints(tcatid,gbc);
	getContentPane().add(tcatid);
	gbc.gridx=3;
	gbc.gridy=13;
	gb.setConstraints(tcost,gbc);
	getContentPane().add(tcost);
	gbc.gridx=3;
	gbc.gridy=16;
	gb.setConstraints(tprodesc,gbc);
	getContentPane().add(tprodesc);

	//----------------------------------------------------------------------------------
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
	//gbc.gridx=28;
	//gbc.gridy=31;
	//gb.setConstraints(bfirst,gbc);
	//getContentPane().add(bfirst);
	//gbc.gridx=35;
	//gbc.gridy=31;
	//gb.setConstraints(bprevious,gbc);
	//getContentPane().add(bprevious);
	//gbc.gridx=54;
	//gbc.gridy=28;
	//gb.setConstraints(bnext,gbc);
	//getContentPane().add(bnext);
	//gbc.gridx=63;
	//gbc.gridy=28;
	//gb.setConstraints(blast,gbc);
	//getContentPane().add(blast);
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
	//-----------------------------------------------------------

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
//--------------------------------------------------------------------------------------------
	setSize(1000,1000);
	pack();
	setVisible(true);
	con = DConnection.getConnection();
	String query1 = "select * from t_product_master";
	st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = st.executeQuery(query1);
	/*while (rs.next())
	{
		System.out.println("From Database Customer Name : " + rs.getString(2));
	}*/
		}
		catch(Exception e){}
	}
	//----------------------------------------------------------------------------------------------------

public void actionPerformed(ActionEvent ae)
{
	try{
		System.out.println(ae.getSource());
	if(ae.getSource()==this.badd)
	{
		JOptionPane.showMessageDialog(this,"Add is hit..");
		tproid.setText("");
		tproname.setText("");
		tcatid.setText("");
		tcost.setText("");
		tprodesc.setText("");

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
		PreparedStatement pst=con.prepareStatement("insert into t_product_master values('"+ tproid.getText()+"','"+ tproname.getText()+"','"+tcatid.getText()+"','"+ tcost.getText()+"','"+ tprodesc.getText()+"')");
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
		String str="update t_product_master set P_ID='"+ tproid.getText() +"',Pname='"+ tproname.getText() +"',Cat_ID='"+ tcatid.getText() +"',cost='"+ tcost.getText() +"',describe='"+ tprodesc.getText() + "' where C_ID = '" + tproid.getText() + "'";
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
		PreparedStatement pst=con.prepareStatement("delete from t_product_master where P_ID = '" + tproid.getText() + "'");
	int x=pst.executeUpdate();
	if(x>0)
	JOptionPane.showMessageDialog(this,"Record Deleted Successfully");
	else
	JOptionPane.showMessageDialog(this,"Error While Deleting Record");
	}
		}
		catch(Exception e){e.printStackTrace();}

}
//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	public void bindData()
	{
		try
		{
			tproid.setText(rs.getString(1));
			tproname.setText(rs.getString(2));
			tcatid.setText(rs.getString(2));
			tcost.setText(rs.getString(3));
			tprodesc.setText(rs.getString(4));
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
//---------------------------------------------------------------------------

  	public static void main(String args[])
	{
 	 ProductMaster pm=new ProductMaster();

	}
}
