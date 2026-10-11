package com.example.demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

@Component
public class TransactionGUI extends JFrame implements ActionListener{
	
	JButton create;
	JButton update;
	JButton delete;
	JButton view;
	private JTextField Id;
    private JTextField accId;
    private JTextField category;
    private JTextField merchant;
    private JTextField description;
    private JTextField price;
    private final CRUDmethods crudMethods;

    public TransactionGUI(CRUDmethods crudMethods) {
    	this.crudMethods = crudMethods;
        setTitle("Transaction Manager");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(6, 2, 5, 5));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		create = new JButton("Create");
		create.addActionListener(this);
		
		update = new JButton("Update");
		update.addActionListener(this);
		
		delete = new JButton("Delete");
		delete.addActionListener(this);
		
		view = new JButton("View");
		view.addActionListener(this);
		
		Id = new JTextField();
		Id.setPreferredSize(new Dimension(240, 40));
		Id.setFont(new Font("Consolas",Font.PLAIN,35));
		Id.setForeground(new Color(0x00FF00));
		Id.setBackground(Color.black);
		Id.setCaretColor(Color.white);
		Id.setText("Transaction ID (Enter for update)");
		
		accId = new JTextField();
		accId.setPreferredSize(new Dimension(240, 40));
		accId.setFont(new Font("Consolas",Font.PLAIN,35));
		accId.setForeground(new Color(0x00FF00));
		accId.setBackground(Color.black);
		accId.setCaretColor(Color.white);
		accId.setText("Account ID");
		
		category = new JTextField();
		category.setPreferredSize(new Dimension(240, 40));
		category.setFont(new Font("Consolas",Font.PLAIN,35));
		category.setForeground(new Color(0x00FF00));
		category.setBackground(Color.black);
		category.setCaretColor(Color.white);
		category.setText("Category");
		
		merchant = new JTextField();
		merchant.setPreferredSize(new Dimension(240, 40));
		merchant.setFont(new Font("Consolas",Font.PLAIN,35));
		merchant.setForeground(new Color(0x00FF00));
		merchant.setBackground(Color.black);
		merchant.setCaretColor(Color.white);
		merchant.setText("Merchant");
		
		description = new JTextField();
		description.setPreferredSize(new Dimension(240, 40));
		description.setFont(new Font("Consolas",Font.PLAIN,35));
		description.setForeground(new Color(0x00FF00));
		description.setBackground(Color.black);
		description.setCaretColor(Color.white);
		description.setText("Description");
		
		price = new JTextField();
		price.setPreferredSize(new Dimension(240, 40));
		price.setFont(new Font("Consolas",Font.PLAIN,35));
		price.setForeground(new Color(0x00FF00));
		price.setBackground(Color.black);
		price.setCaretColor(Color.white);
		price.setText("Price");
		
		this.add(Id);
		this.add(accId);
		this.add(category);
		this.add(merchant);
		this.add(description);
		this.add(price);
		this.add(create);
		this.add(update);
		this.add(delete);
		this.add(view);
		this.pack();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==create) {
			try {
				int a = Integer.parseInt(accId.getText());
		        String c = category.getText();
		        String m = merchant.getText();
		        String d = description.getText();
		        double p = Double.parseDouble(price.getText());
				Transaction t = new Transaction(a, c, m, d, p);
				crudMethods.create(t);
			}
			catch(Exception x) {
				ErrorWindow w = new ErrorWindow();
			}
		}
		if(e.getSource()==update) {
			try {
				int i = Integer.parseInt(Id.getText());
				int a = Integer.parseInt(accId.getText());
		        String c = category.getText();
		        String m = merchant.getText();
		        String d = description.getText();
		        double p = Double.parseDouble(price.getText());
				Transaction t = new Transaction(i, a, c, m, d, p);
				crudMethods.update(t);
			}
			catch(Exception x) {
				ErrorWindow w = new ErrorWindow();
			}
		}
		if(e.getSource()==delete) {
			try {
				int i = Integer.parseInt(Id.getText());
				Transaction t = new Transaction(i);
				crudMethods.delete(t);
			}
			catch(Exception x) {
				ErrorWindow w = new ErrorWindow();
			}
		}
		if(e.getSource()==view) {
			List<Transaction> l = crudMethods.retrieveAll();

		    JTextArea textArea = new JTextArea(15, 30);
		    textArea.setEditable(false);

		    for (Transaction t : l) {
		        textArea.append(t.toString() + "\n");
		    }

		    JScrollPane scrollPane = new JScrollPane(textArea);

		    JOptionPane.showMessageDialog(
		        this,
		        scrollPane,
		        "All Transactions",
		        JOptionPane.INFORMATION_MESSAGE
		    );
		}
		
	}
    
    
}
