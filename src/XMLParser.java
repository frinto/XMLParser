import exceptions.NoSuchElementException;
import utilities.Iterator;
import utilities.MyQueue;
import utilities.MyStack;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.BreakIterator;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Mon Nov 20 13:10:21 MST 2017
 */


/**
 * @author Huy Khoa Le
 */
public class XMLParser extends JFrame
{

    private int fileIndex;

    public XMLParser()
    {
        initComponents();
        displayGUI();
    }

    private void displayGUI()
    {
        this.setVisible(true);
        this.setTitle("XMLParser GUI");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void comboBox1ActionPerformed(ActionEvent e)
    {
        // TODO add your code here
        JComboBox comboBox = (JComboBox) e.getSource();
        this.fileIndex = comboBox.getSelectedIndex();

    }

    private void button1ActionPerformed(ActionEvent e)
    {
        // TODO add your code here


        if (this.fileIndex == 0)
        {


        } else if (this.fileIndex == 1)
        {
            MyStack<String> stack = new MyStack<>();
            MyQueue<String> errorQueue = new MyQueue<>();
            MyQueue<String> extrasQueue = new MyQueue<>();

            boolean selfCloseTag = false;
            boolean startTag = false;
            boolean endTag = false;

        }

    }


    private void initComponents()
    {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        String fileList[] = {"sample1.xml", "sample2.xml", "xmlSample.xml"};

        comboBox1 = new JComboBox(fileList);
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();

        //---- comboBox1 ----
        comboBox1.addActionListener(e -> comboBox1ActionPerformed(e));

        //---- button1 ----
        button1.setText("parse");
        button1.addActionListener(e -> button1ActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 369, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(207, 207, 207)
                                                .addComponent(button1)))
                                .addContainerGap(69, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(button1)
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JComboBox comboBox1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public static void main(String[] args)
    {
        XMLParser xmlParser = new XMLParser();
    }
}
