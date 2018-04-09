/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author mspranav
 */
public class ConsolePanel extends javax.swing.JPanel {

	/**
	 * Creates new form ConsolePanel
	 */
	JButton btnClearLog;
	JTextArea consoleTextArea;

	public ConsolePanel() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setBorder(new TitledBorder(null, "EmoEngine Log", TitledBorder.LEADING, TitledBorder.TOP,
						new Font("Tahoma", Font.BOLD, 12), Color.BLACK));
		this.setBounds(11, 408, 474, 152);
		this.setLayout(null);

		btnClearLog = new JButton("Clear Log");
		btnClearLog.setBounds(140, 119, 171, 25);
		btnClearLog.setBackground(Color.LIGHT_GRAY);
		btnClearLog.setContentAreaFilled(false);
		btnClearLog.setOpaque(true);
		consoleTextArea = new JTextArea();
		consoleTextArea.setBackground(Color.DARK_GRAY);
		consoleTextArea.setBounds(10, 26, 454, 86);
		this.add(btnClearLog);
		this.add(consoleTextArea);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE));
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE));
	}// </editor-fold>//GEN-END:initComponents

	public void appendLogMessage(String message) {
		message = message + "\n";
		consoleTextArea.append(message);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables
}
