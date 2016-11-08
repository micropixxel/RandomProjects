/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomprojects;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Gamer
 */
public class ReadFile extends JFrame {
    
    private JTextField addressBar;
    private JEditorPane display;
    
    // Constructor
    public ReadFile() {
        super("Bucky Browser");
        
        addressBar = new JTextField("Enter a full URL!");
        addressBar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                loadCrap(event.getActionCommand());
            }
        });
        add(addressBar, BorderLayout.NORTH);
        
        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(new HyperlinkListener() {
            public void hyperlinkUpdate(HyperlinkEvent event) {
                if (event.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
                    loadCrap(event.getURL().toString());
                }
            }
        });
        add(new JScrollPane(display), BorderLayout.CENTER);
        setSize(500, 300);
        setVisible(true);
    }
    
    private void loadCrap(String userText) {
        try {
            display.setPage(userText);
            addressBar.setText(userText);
        } catch(Exception e) {
            System.out.println("Crap!");
        }
    }
}
