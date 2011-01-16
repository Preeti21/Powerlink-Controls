import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class PurchaseOrder extends JFrame
{
 	JLabel head;
	Font fhead,fcontrols;
	JLabel lponum,ldate,lsupplier,lcreditperiod,lamount,lquantity,ltaxcode,ltaxamount,lcurrcode,lempcode,ltotalamount;
	JTextField tponum,tdate,tcreditperiod,tamount,tquantity,ttaxcode,ttaxamount,tcurrcode,tempcode,ttotalamount;
	JComboBox csupplier;
	JButton bfirst,bprevious,bnext,blast,badd,bedit,bdelete,bsave;
	GridBagLayout gb;	
	GridBagConstraints gbc;
	PurchaseOrder()
	{
		 Container c=getContentPane();
		 c.setLayout(new FlowLayout()); 
		 gb=new GridBagLayout();		
		 gbc=new GridBagConstraints();	
		 getContentPane().setLayout(gb);	
		 head=new JLabel("Purchase Order Form");		
		 fhead=new Font("Trebuchet MS",Font.BOLD|Font.ITALIC,30);		
		 fcontrols=new Font("Trebuchet MS",Font.BOLD,15);		
		 head.setFont(fhead);		
		 head.setForeground(Color.blue);		
		 //setSize(500,600);			
		 //setVisible(true);		
		 getContentPane().setBackground(Color.gray);
		 gbc.anchor=GridBagConstraints.NORTHWEST;		
		 gbc.gridx=3;		
		 gbc.gridy=1;			
		 gb.setConstraints(head,gbc);		
		 getContentPane().add(head);
		 String ssupplier[]={"L & T","abc","xyz"};
//--------------------------------------------------------------------------------------
		 lponum=new JLabel("Purchase Order Number");
		 ldate=new JLabel("Date");
		 lsupplier=new JLabel("Supplier");
		 lcreditperiod=new JLabel("Credit Period");
		 lamount=new JLabel("Amount");
		 lquantity=new JLabel("Quantity");
		 ltaxcode=new JLabel("Tax Code");
		 ltaxamount=new JLabel("Tax Amount");
		 ltotalamount=new JLabel("Total Amount");
		 lcurrcode=new JLabel("Currency Code");
		 lempcode=new JLabel("Employee Code");
//----------------------------------------------------------------------------------------
		 tponum=new JTextField(10);
		 tdate=new JTextField(10);
		 //tsupplier=new JTextField(10);
		 tcreditperiod=new JTextField(10);
		 tamount=new JTextField(10);
		 tquantity=new JTextField(10);
		 ttaxcode=new JTextField(10);
		 ttaxamount=new JTextField(10);
		 ttotalamount=new JTextField(10);
		 tcurrcode=new JTextField(10);
		 tempcode=new JTextField(10);
//-------------------------------------------------------------------------------------------
 	 	csupplier=new JComboBox(ssupplier);
//-------------------------------------------------------------------------------------------
		 badd = new JButton("Add");		
		 bedit = new JButton("Edit");		
		 bsave = new JButton("    Save    ");			
		 bdelete = new JButton("   Delete   ");		
		 bfirst = new JButton("  << First  ");		
		 bprevious = new JButton(" < Previous ");		
		 bnext = new JButton("   Next  >  ");		
		 blast = new JButton("  Last  >>  ");	
//---------------------------------------------------------------------------------------------
		 lponum.setFont(fcontrols);
		 ldate.setFont(fcontrols);
		 lsupplier.setFont(fcontrols);
		 lcreditperiod.setFont(fcontrols);
		 lamount.setFont(fcontrols);
		 lquantity.setFont(fcontrols);
		 ltaxcode.setFont(fcontrols);
		 ltaxamount.setFont(fcontrols);
		 ltotalamount.setFont(fcontrols);
		 lcurrcode.setFont(fcontrols);
		 lempcode.setFont(fcontrols);
//----------------------------------------------------------------------------------------------
		 lponum.setForeground(Color.red);
		 ldate.setForeground(Color.red);
		 lsupplier.setForeground(Color.red);
		 lcreditperiod.setForeground(Color.red);
		 lamount.setForeground(Color.red);
		 lquantity.setForeground(Color.red);
		 ltaxcode.setForeground(Color.red);
		 ltaxamount.setForeground(Color.red);
		 ltotalamount.setForeground(Color.red);
		 lcurrcode.setForeground(Color.red);
		 lempcode.setForeground(Color.red);
//-----------------------------------------------------------------------------------------------
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
		gbc.gridx=1;		
		gbc.gridy=13;		
		gb.setConstraints(lcreditperiod,gbc);		
		getContentPane().add(lcreditperiod);
		gbc.gridx=1;		
		gbc.gridy=16;		
		gb.setConstraints(lamount,gbc);		
		getContentPane().add(lamount);
		gbc.gridx=1;		
		gbc.gridy=19;		
		gb.setConstraints(lquantity,gbc);		
		getContentPane().add(lquantity);
		gbc.gridx=1;		
		gbc.gridy=22;		
		gb.setConstraints(ltaxcode,gbc);		
		getContentPane().add(ltaxcode);
		gbc.gridx=1;		
		gbc.gridy=25;		
		gb.setConstraints(ltaxamount,gbc);		
		getContentPane().add(ltaxamount);
		gbc.gridx=1;		
		gbc.gridy=28;		
		gb.setConstraints(ltotalamount,gbc);		
		getContentPane().add(ltotalamount);
		gbc.gridx=1;		
		gbc.gridy=31;		
		gb.setConstraints(lcurrcode,gbc);		
		getContentPane().add(lcurrcode);
		gbc.gridx=1;		
		gbc.gridy=34;		
		gb.setConstraints(lempcode,gbc);		
		getContentPane().add(lempcode);

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
		gbc.gridx=3;		
		gbc.gridy=13;		
		gb.setConstraints(tcreditperiod,gbc);			
		getContentPane().add(tcreditperiod);
		gbc.gridx=3;		
		gbc.gridy=16;		
		gb.setConstraints(tamount,gbc);			
		getContentPane().add(tamount);
		gbc.gridx=3;		
		gbc.gridy=19;		
		gb.setConstraints(tquantity,gbc);			
		getContentPane().add(tquantity);
		gbc.gridx=3;		
		gbc.gridy=22;		
		gb.setConstraints(ttaxcode,gbc);			
		getContentPane().add(ttaxcode);
		gbc.gridx=3;		
		gbc.gridy=25;		
		gb.setConstraints(ttaxamount,gbc);			
		getContentPane().add(ttaxamount);
		gbc.gridx=3;		
		gbc.gridy=28;		
		gb.setConstraints(ttotalamount,gbc);			
		getContentPane().add(ttotalamount);
		gbc.gridx=3;		
		gbc.gridy=31;		
		gb.setConstraints(tcurrcode,gbc);			
		getContentPane().add(tcurrcode);
		gbc.gridx=3;		
		gbc.gridy=34;		
		gb.setConstraints(tempcode,gbc);			
		getContentPane().add(tempcode);

	//-----------------------------------------------------------------
		gbc.gridx=1;		
		gbc.gridy=40;	
		gb.setConstraints(bfirst,gbc);		
		getContentPane().add(bfirst);		
		gbc.gridx=7;		
		gbc.gridy=40;		
		gb.setConstraints(bprevious,gbc);		
		getContentPane().add(bprevious);		
		gbc.gridx=14;		
		gbc.gridy=40;		
		gb.setConstraints(bnext,gbc);		
		getContentPane().add(bnext);		
		gbc.gridx=21;		
		gbc.gridy=40;		
		gb.setConstraints(blast,gbc);		
		getContentPane().add(blast);	
//---------------------------------------------------------------------------------	
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
		setSize(1000,1000);
		pack();
		setVisible(true);
	}
  	public static void main(String args[])
	{
 		PurchaseOrder po=new PurchaseOrder();
	
	}
}		

