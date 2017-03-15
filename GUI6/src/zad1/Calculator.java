package zad1;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator extends JFrame {
	
	private JPanel mainPanel = new JPanel();
	private JPanel buttonsPanel = new JPanel();
	private JPanel labelsPanel = new JPanel();
	private JLabel res = new JLabel("0.0");
	private JLabel op = new JLabel("");
	private Calc calc = new Calc();
	
	private String first = "";
	private String second = "";
	private Operation operation;
	private boolean flag = false;
	private boolean finished = false;
	
	public Calculator() {
		this.setTitle("Calculator");
		this.setSize(new Dimension(300,400));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		mainPanel.setLayout(new BorderLayout());
		
		//"Ekran"
		labelsPanel.setLayout(new GridLayout(2,1));
		
		op.setBackground(Color.lightGray);
		res.setBackground(Color.lightGray);
		
		op.setForeground(Color.GRAY);
		res.setForeground(Color.BLACK);
		
		op.setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
		res.setFont(new Font(Font.DIALOG, Font.PLAIN, 25));
		
		res.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		labelsPanel.add(op);
		labelsPanel.add(res);
		mainPanel.add(labelsPanel, BorderLayout.NORTH);
		
		
		// Przyciski
		buttonsPanel.setLayout(new GridLayout(5,3));
		
		JButton n1  = new JButton("1");
		n1.addActionListener(e -> digitButtonsOnClick("1"));
		buttonsPanel.add(n1);
		
		JButton n2  = new JButton("2");
		n2.addActionListener(e -> digitButtonsOnClick("2"));
		buttonsPanel.add(n2);
		
		JButton n3  = new JButton("3");
		n3.addActionListener(e -> digitButtonsOnClick("3"));
		buttonsPanel.add(n3);
		
		JButton n4  = new JButton("4");
		n4.addActionListener(e -> digitButtonsOnClick("4"));
		buttonsPanel.add(n4);
		
		JButton n5  = new JButton("5");
		n5.addActionListener(e -> digitButtonsOnClick("5"));
		buttonsPanel.add(n5);
		
		JButton n6  = new JButton("6");
		n6.addActionListener(e -> digitButtonsOnClick("6"));
		buttonsPanel.add(n6);
		
		JButton n7  = new JButton("7");
		n7.addActionListener(e -> digitButtonsOnClick("7"));
		buttonsPanel.add(n7);
		
		JButton n8  = new JButton("8");
		n8.addActionListener(e -> digitButtonsOnClick("8"));
		buttonsPanel.add(n8);
		
		JButton n9  = new JButton("9");
		n9.addActionListener(e -> digitButtonsOnClick("9"));
		buttonsPanel.add(n9);

		JButton add  = new JButton("+");
		add.addActionListener(e -> {
			operationButtonsOnClick(Operation.ADD);
		});
		buttonsPanel.add(add);
		
		JButton n0  = new JButton("0");
		n0.addActionListener(e -> {
			if(finished)
				clear();
			if(flag) {
				if(!second.equals("0")) {
					second += "0";
					op.setText(first + " " + operation.getDescription() + " " + second);
				}
			}
			else {
				if(!first.equals("0")) {
					first += "0";
					op.setText(first + "");
				}
			}
		});
		buttonsPanel.add(n0);
		
		JButton rem  = new JButton("-");
		rem.addActionListener(e -> {
			if(!flag) {
				if(first.equals("")) {
					first = "-";
					op.setText(first + "");
				}
				else {
					if(!first.equals("-")) {
						flag = true;
						operation = Operation.REM;
						op.setText(first + " " + operation.getDescription());
					}
				}
			}
			else if(flag) {
				if(second.equals("")) {
					second = "-";
					op.setText(first + " " + operation.getDescription() + " " + second);
				}
			}
		});
		buttonsPanel.add(rem);
		
		JButton mul  = new JButton("*");
		mul.addActionListener(e -> {
			operationButtonsOnClick(Operation.MUL);
		});
		buttonsPanel.add(mul);
		
		JButton eq  = new JButton("=");
		eq.addActionListener(e -> {
			if(!first.equals("") && !second.equals("") && !second.equals("-") && operation != null) {
				if(operation == Operation.ADD)
					res.setText("" + calc.add(Double.valueOf(first), Double.valueOf(second)));
				else if(operation == Operation.REM)
					res.setText("" + calc.substract(Double.valueOf(first), Double.valueOf(second)));
				else if(operation == Operation.MUL)
					res.setText("" + calc.multiply(Double.valueOf(first), Double.valueOf(second)));
				else if(operation == Operation.DIV) {
					if(!Double.isNaN(calc.divide(Double.valueOf(first), Double.valueOf(second))))
						res.setText("" + calc.divide(Double.valueOf(first), Double.valueOf(second)));
					else
						res.setText("ERR");
				}
				finished = true;
			}
		});
		buttonsPanel.add(eq);
		
		JButton div  = new JButton("/");
		div.addActionListener(e -> {
			operationButtonsOnClick(Operation.DIV);
		});
		buttonsPanel.add(div);
		
		JButton clr  = new JButton("Clear");
		clr.addActionListener(e -> {
			clear();
		});
		mainPanel.add(clr, BorderLayout.SOUTH);
		
		// Przycisk "Clear" na samym dole
		mainPanel.add(buttonsPanel, BorderLayout.CENTER);
		
		this.add(mainPanel);
		this.setTitle("Calculator");
		this.setSize(new Dimension(400,500));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		//this.pack();
	}
	
	public void clear() {
		res.setText("0.0");
		op.setText("");
		first = "";
		second = "";
		flag = false;
		operation = null;
		finished = false;
	}
	
	public void digitButtonsOnClick(String digit) {
		if(finished)
			clear();
		if(flag) {
			if(second.equals("0"))
				second = digit;
			else
				second += digit;
			
			op.setText(first + " " + operation.getDescription() + " " + second);
		}
		else {
			if(first.equals("0"))
				first = digit;
			else
				first += digit;
			
			op.setText(first + "");
		}
	}
	
	public void operationButtonsOnClick(Operation oper) {
		if(!first.equals("") && !first.equals("-") && second.equals("")) {
			flag = true;
			operation = oper;
			op.setText(first + " " + operation.getDescription());
		}
	}
	
}
