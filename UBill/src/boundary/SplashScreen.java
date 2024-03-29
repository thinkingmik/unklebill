/**
 * Copyright 2011 Michele Andreoli
 * 
 * This file is part of UnkleBill.
 *
 * UnkleBill is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * UnkleBill is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with UnkleBill; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 **/

package boundary;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class SplashScreen extends JWindow {

	private static final long serialVersionUID = 1L;
	private JPanel mainPane = null;
	private int wWidth = 420;
	private int wHeight = 210;
    
    public SplashScreen() {
    	setContentPane(getMainPane());
    	setSize(new Dimension(this.wWidth, this.wHeight));		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(new Point((d.width-wWidth)/2, (d.height-wHeight)/2));
		start();
    }
    
    private JPanel getMainPane() {
    	if (mainPane == null) {
    		mainPane = new JPanel();
    		mainPane.setBorder(new LineBorder(new Color(51, 102, 204), 5));
    		mainPane.setSize(new Dimension(this.wWidth, this.wHeight));
			mainPane.setLayout(null);
			
			JLabel licenseLabel = new JLabel("GNU GPL copyright 2011");
			licenseLabel.setHorizontalAlignment(SwingConstants.CENTER);
			licenseLabel.setForeground(new Color(51, 102, 204));
			licenseLabel.setFont(new Font("Courier", Font.BOLD, 12));
			licenseLabel.setBounds(6, 188, 408, 16);
			mainPane.add(licenseLabel);
			
			JLabel devLabel = new JLabel("UnkleBill v1.1 developed by Michele Andreoli");
			devLabel.setForeground(new Color(51, 102, 204));
			devLabel.setFont(new Font("Courier", Font.BOLD, 12));
			devLabel.setHorizontalAlignment(SwingConstants.CENTER);
			devLabel.setBounds(6, 6, 408, 16);
			mainPane.add(devLabel);
			
			JLabel iconLabel = new JLabel("");
			iconLabel.setIcon(new ImageIcon(getClass().getResource("/icons/UBill_165x165.png")));
			iconLabel.setBounds(6, 22, 165, 165);
			mainPane.add(iconLabel);
			
			JLabel titleLabel = new JLabel("I Want Your...");
			titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
			titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 32));
			titleLabel.setBounds(158, 41, 256, 81);
			mainPane.add(titleLabel);
			
			JLabel title2Label = new JLabel("Bills!");
			title2Label.setForeground(Color.RED);
			title2Label.setHorizontalAlignment(SwingConstants.CENTER);
			title2Label.setFont(new Font("SansSerif", Font.BOLD, 44));
			title2Label.setBounds(158, 87, 256, 81);
			mainPane.add(title2Label);
    	}
    	return mainPane;
    }
    
    private void start() {
    	setVisible(true);
        try {
        	Main main = new Main(this);
    		main.START();    		
        } catch (Exception e) {
        	System.err.println("Error: splahscreen\n"+e);
        	this.dispose();
        }
        setVisible(false); 
    }
}
