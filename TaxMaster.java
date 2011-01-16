import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class TaxMaster extends JFrame
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel ltaxcode,ltaxtype,ltaxvalue;
	JTextField ttaxcode,ttaxtype,ttaxvalue;
	JButton bfirst,bprevious,bnext,blast,badd,bedit,bdelete,bsave;
	GridBagLayout gb;	
	GridBagConstraints gbc;
	TaxMaster()
	{
		 Container c=getContentPane();
		 c.setLayout(new FlowLayout()); 
		 gb=new GridBagLayout();		
		 gbc=new GridBagConstraints();	
		 getContentPane().setLayout(gb);	
		 head=new JLabel("Tax Master Form");		
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
		 ltaxcode=new JLabel("Tax Code");
		 ltaxtype=new JLabel("Tax Type");
		 ltaxvalue=new JLabel("Tax Value");

//-----------------------------------------------------------------------
		 ttaxcode=new JTextField(10);
		 ttaxtype=new JTextField(10);
		 ttaxvalue=new JTextField(10);
	 
//-----------------------------------------------------------------------
	 	 badd = new JButton("Add");		
		 bedit = new JButton("Edit");		
		 bsave = new JButton("    Save    ");			
		 bdelete = new JButton("   Delete   ");		
		 bfirst = new JButton("  << First  ");		
		 bprevious = new JButton(" < Previous ");		
		 bnext = new JButton("   Next  >  ");		
		 blast = new JButton("  Last  >>  ");	
		 ltaxcode.setFont(fcontrols);
		 ltaxtype.setFont(fcontrols);
		 ltaxvalue.setFont(fcontrols);
		 ltaxcode.setForeground(Color.red);
		 ltaxtype.setForeground(Color.red);
		 ltaxvalue.setForeground(Color.red);
//-----------------------------------------------------------------------
		gbc.gridx=1;		
		gbc.gridy=7;		
		gb.setConstraints(ltaxcode,gbc);		
		getContentPane().add(ltaxcode);
		gbc.gridx=1;		
		gbc.gridy=14;		
		gb.setConstraints(ltaxtype,gbc);		
		getContentPane().add(ltaxtype);
		gbc.gridx=1;		
		gbc.gridy=21;		
		gb.setConstraints(ltaxvalue,gbc);		
		getContentPane().add(ltaxvalue);
//-----------------------------------------------------------------------
		gbc.gridx=3;		
		gbc.gridy=7;		
		gb.setConstraints(ttaxcode,gbc);			
		getContentPane().add(ttaxcode);
		gbc.gridx=3;		
		gbc.gridy=14;		
		gb.setConstraints(ttaxtype,gbc);			
		getContentPane().add(ttaxtype);
		gbc.gridx=3;		
		gbc.gridy=21;		
		gb.setConstraints(ttaxvalue,gbc);			
		getContentPane().add(ttaxvalue);
//-----------------------------------------------------------------------
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
		setSize(1000,1000);
		pack();
		setVisible(true);
	}
  	public static void main(String args[])
	{
 		TaxMaster tax=new TaxMaster();
	
	}
}		
