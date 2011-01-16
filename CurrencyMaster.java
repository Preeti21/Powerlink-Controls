import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class CurrencyMaster extends JFrame
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel lcurrcode,lcurrvalue;
	JTextField tcurrcode,tcurrvalue;
	JButton bfirst,bprevious,bnext,blast,badd,bedit,bdelete,bsave;
	GridBagLayout gb;	
	GridBagConstraints gbc;
	CurrencyMaster()
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
 		CurrencyMaster curr=new CurrencyMaster();
	
	}
}	
