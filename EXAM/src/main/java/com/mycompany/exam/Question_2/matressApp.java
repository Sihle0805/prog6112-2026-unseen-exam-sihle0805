/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exam.Question_2;
import java.awt.event.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
/**
 *
 * @author pepea
 */
public class matressApp implements ActionListener{
    
    //=============Instance Variables================

    //Menu
    JMenu fileMenu;
    JMenu toolsMenu;
    JMenuItem exitMenuItem;
    JMenuItem processMenuItem;
    JMenuItem clearMenuItem;

    //text fields
    JLabel nameLabel;
    JTextField nameField;
    JLabel priceLabel;
    JTextField priceField;

    //combo box
    JLabel comboBoxLabel;
    JComboBox<String> moduleComboBox;

    //button
    JButton processButton;

    public static void main(String[] args) {

        // 1. Create and configure window
        JFrame frame = new JFrame();
        frame.setTitle("Product App");
        frame.setSize(335, 600);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        //Menu setup
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        JMenuItem processMenuItem = new JMenuItem("Process");
        JMenuItem clearMenuItem = new JMenuItem("Clear");

        fileMenu.add(exitMenuItem);
        toolsMenu.add(processMenuItem);
        toolsMenu.add(clearMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        frame.setJMenuBar(menuBar);

        //2. Create components
        JLabel nameLabel = new JLabel("Customer Name: ");
        JTextField nameField = new JTextField(20);

        JLabel priceLabel = new JLabel("Enter Price: ");
        JTextField priceField = new JTextField(20);

        JLabel comboBoxLabel = new JLabel("Select Product: ");
        JComboBox<String> moduleComboBox = new JComboBox<>();
        moduleComboBox.addItem("Cozy Nights Monarch");
        moduleComboBox.addItem("Restonic Barbados");
        moduleComboBox.addItem("Sealy Phuket");
        moduleComboBox.setSelectedIndex(0);

        JButton processButton = new JButton("PROCESS");

        //3. Create listener object and connect components to it
        matressApp listener = new matressApp();

        listener.fileMenu = fileMenu;
        listener.toolsMenu = toolsMenu;

        listener.moduleComboBox = moduleComboBox;
        listener.comboBoxLabel = comboBoxLabel;

        listener.nameLabel = nameLabel;
        listener.nameField = nameField;
        listener.priceField = priceField;
        listener.priceLabel = priceLabel;

        listener.exitMenuItem = exitMenuItem;
        listener.processMenuItem = processMenuItem;
        listener.clearMenuItem = clearMenuItem;
        listener.processButton = processButton;   // was missing

        processMenuItem.addActionListener(listener);
        clearMenuItem.addActionListener(listener);
        exitMenuItem.addActionListener(listener);
        processButton.addActionListener(listener); // was missing

        //4. Add components to the frame
        frame.add(nameLabel);
        frame.add(nameField);

        frame.add(comboBoxLabel);
        frame.add(moduleComboBox);

        frame.add(priceLabel);
        frame.add(priceField);

        frame.add(processButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == exitMenuItem) {
            System.exit(0);
        } else if (source == processButton || source == processMenuItem) {
            process();
        } else if (source == clearMenuItem) {
            clear();
        }
    }

    private void process() {
        String name = nameField.getText().trim();
        String product = (String) moduleComboBox.getSelectedItem();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the customer name.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        try {
            price = Double.parseDouble(priceField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid price.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        IProductCalculations calc = new ProductCalculations(price);
        double vat = calc.GetVat();
        double commission = calc.GetCommission();
        double total = calc.GetTotal();

        String result = "Customer Name: " + name + "\n"
                + "Product: " + product + "\n"
                + "VAT: R " + vat + "\n"
                + "COMMISSION: R " + commission + "\n"
                + "TOTAL: R " + total;

        JOptionPane.showMessageDialog(null, result, "Message",
                JOptionPane.INFORMATION_MESSAGE);

        saveToFile(result);
    }

    private void saveToFile(String details) {
    String border = "*".repeat(40);

    try (FileWriter writer = new FileWriter("data.txt")) {
        writer.write("DATA LOG \n");
        writer.write(border + "\n");
        writer.write(details + "\n");
        writer.write(border + "\n");
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Could not write to data.txt",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void clear() {
        nameField.setText("");
        priceField.setText("");
        moduleComboBox.setSelectedIndex(0);
    }
}
    
    
    
    

