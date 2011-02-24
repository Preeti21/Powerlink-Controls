import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
class MyFrame extends JFrame implements ActionListener{ 

	JMenuBar mainMenuBar;
	JMenu master,transactions,reports,admin,exit,submenu1,submenu2,submenu3,submenu4;
	JMenuItem product,customer,employee,supplier,tax,currency,po,invoice,deliverynote,enquiry,submenuitem1,submenuitem2,submenuitem3,submenuitem4,submenuitem5,submenuitem6,submenuitem7,submenuitem8;
	
	public void actionPerformed(ActionEvent e)
	{
		Object obj = new Object();
		obj=e.getSource();
		System.out.println(e.getSource());
		System.out.println(this.submenuitem1);
		if(obj == this.submenuitem1)
		{
			System.out.println("Adding new PO..");
			PurchaseOrder poform = new PurchaseOrder();
		}
	}
  MyFrame()
 {
	mainMenuBar = new JMenuBar();
	master= new JMenu("Master Tables");
	master.setMnemonic(KeyEvent.VK_M);
	mainMenuBar.add(master);
	transactions= new JMenu("Transactions");
	transactions.setMnemonic(KeyEvent.VK_M);
	mainMenuBar.add(transactions);
	reports= new JMenu("Reports");
	reports.setMnemonic(KeyEvent.VK_M);
	mainMenuBar.add(reports);
	admin= new JMenu("Admin");
	admin.setMnemonic(KeyEvent.VK_M);
	mainMenuBar.add(admin);
	exit= new JMenu("Exit");
	exit.setMnemonic(KeyEvent.VK_M);
	mainMenuBar.add(exit);
	//-----------------------------------------------------------------------
	product= new JMenuItem("Product",
				KeyEvent.VK_T);
	master.add(product);
	product.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
	
	master.addSeparator();

	customer= new JMenuItem("Customer",
     		KeyEvent.VK_T);
	master.add(customer);
	customer.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));

	master.addSeparator();

	employee= new JMenuItem("Employee",
				KeyEvent.VK_T);
	master.add(employee);
	employee.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
	
	master.addSeparator();
	
	supplier= new JMenuItem("Supplier",
				KeyEvent.VK_T);
	master.add(supplier);
	supplier.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
	
	master.addSeparator();
	
	tax= new JMenuItem("Tax",
				KeyEvent.VK_T);
	master.add(tax);
	tax.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
	
	master.addSeparator();
	
	currency= new JMenuItem("Currency",
				KeyEvent.VK_T);
	master.add(currency);
	currency.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
	
	master.addSeparator();
//-------------------------------------------------------------------------------------

	/*po= new JMenuItem("Purchase Order",
				KeyEvent.VK_T);
	po.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
	po= new JMenuItem("Purchase Order",
				KeyEvent.VK_T);
	transactions.add(po);
	
	
	transactions.addSeparator();

	invoice= new JMenuItem("Invoice",
				KeyEvent.VK_T);
	transactions.add(invoice);
	invoice.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
	
	transactions.addSeparator();

	deliverynote= new JMenuItem("Delivery Note",
				KeyEvent.VK_T);
	transactions.add(deliverynote);
	deliverynote.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
	
	transactions.addSeparator();

	enquiry= new JMenuItem("Enquiry",
				KeyEvent.VK_T);
	transactions.add(enquiry);
	enquiry.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
	
	transactions.addSeparator();*/

//-------------------------------------------------------------------------------------
	// Sub Menu follows a seperator
		po = new JMenu("Purchase Order");
		po.setMnemonic(KeyEvent.VK_S);
		submenuitem1 = new JMenuItem("Add");
		submenuitem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.CTRL_MASK));
		submenuitem1.addActionListener(this);
		
		//submenuitem1.addActionListener(this);
		po.add(submenuitem1);
		submenuitem2 = new JMenuItem("Edit");
		po.add(submenuitem2);
		//submenuitem1.addActionListener(this);
		transactions.add(po);
		transactions.addSeparator();	

		// Sub Menu follows a seperator
		invoice = new JMenu("Invoice");
		invoice.setMnemonic(KeyEvent.VK_S);
		submenuitem3 = new JMenuItem("Add");
		submenuitem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.CTRL_MASK));
		//submenuitem1.addActionListener(this);
		invoice.add(submenuitem3);
		submenuitem4 = new JMenuItem("Edit");
		invoice.add(submenuitem4);
		//submenuitem1.addActionListener(this);
		transactions.add(invoice);
		transactions.addSeparator();	

		// Sub Menu follows a seperator
		deliverynote= new JMenu("Delivery Note");
		deliverynote.setMnemonic(KeyEvent.VK_S);
		submenuitem5 = new JMenuItem("Add");
		submenuitem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.CTRL_MASK));
		//submenuitem1.addActionListener(this);
		deliverynote.add(submenuitem5);
		submenuitem6 = new JMenuItem("Edit");
		deliverynote.add(submenuitem6);
		//submenuitem1.addActionListener(this);
		transactions.add(deliverynote);
		transactions.addSeparator();

		// Sub Menu follows a seperator
		enquiry= new JMenu("Enquiry");
		enquiry.setMnemonic(KeyEvent.VK_S);
		submenuitem7 = new JMenuItem("Add");
		submenuitem7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.CTRL_MASK));
		//submenuitem1.addActionListener(this);
		enquiry.add(submenuitem7);
		submenuitem8 = new JMenuItem("Edit");
		deliverynote.add(submenuitem8);
		//submenuitem1.addActionListener(this);
		transactions.add(enquiry);
		transactions.addSeparator();

		
		

			
//-------------------------------------------------------------------------------------
	Container c=getContentPane();
	c.setLayout(new FlowLayout());
	c.add(mainMenuBar);
	setSize(400,400);
	setVisible(true);
	//pack();
  }


  public static void main(String args[])
  {
	MyFrame f=new MyFrame();
  }

 }