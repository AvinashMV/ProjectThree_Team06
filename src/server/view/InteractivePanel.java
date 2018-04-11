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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import server.services.InteractiveListenerService;
import server.services.ServerSocketService;

/**
 * @author mspranav
 */
public class InteractivePanel extends JPanel implements ActionListener, ChangeListener {


    JCheckBox autoResetCheckBox;
    JSpinner emoStateSpinner;
    JButton sendButton;
    InteractiveListenerService interactiveListenerService;
    ServerSocketService serverSocketService;

    /**
     * Creates new form InteractivePanel.
     */
    public InteractivePanel() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(new TitledBorder(null, "Interactive", TitledBorder.LEADING,
                TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), null));
        this.setBounds(11, 11, 474, 104);
        this.setLayout(null);

        JLabel emoStateLabel = new JLabel("<html>EmoState Interval:</html>");
        emoStateLabel.setForeground(Color.WHITE);
        emoStateLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
        emoStateLabel.setBounds(175, 29, 124, 25);
        this.add(emoStateLabel);

        autoResetCheckBox = new JCheckBox("Auto Reset");
        autoResetCheckBox.setForeground(Color.WHITE);
        autoResetCheckBox.setBackground(Color.GRAY);
        autoResetCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
        autoResetCheckBox.setBounds(175, 61, 101, 25);
        this.add(autoResetCheckBox);
        autoResetCheckBox.addActionListener(this);

        sendButton = new JButton("Send");
        sendButton.setBackground(Color.LIGHT_GRAY);
        sendButton.setContentAreaFilled(false);
        sendButton.setOpaque(true);
        sendButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        sendButton.setBounds(302, 61, 107, 25);
        this.add(sendButton);
        sendButton.addActionListener(this);

        emoStateSpinner = new JSpinner();
        emoStateSpinner.setModel(new SpinnerNumberModel(0.25, 0.25, 100.00, 0.50));
        emoStateSpinner.setBounds(324, 29, 55, 25);
        emoStateSpinner.addChangeListener(this);
        this.add(emoStateSpinner);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == autoResetCheckBox) {

            if (!autoResetCheckBox.isSelected()) {
                interactiveListenerService.stateSpinnerChange(autoResetCheckBox.isSelected());
            }
        }
        if (e.getSource() == sendButton)
        {
           interactiveListenerService.stateSpinnerChange(autoResetCheckBox.isSelected());

        }


    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == emoStateSpinner) {
            String stateValue = emoStateSpinner.getValue().toString();
            interactiveListenerService.autoResetChange(stateValue);
        }




    }

    public void setInteractiveListener(InteractiveListenerService interactiveListenerService) {
        this.interactiveListenerService = interactiveListenerService;
    }
}
