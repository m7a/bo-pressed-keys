package ma.keys;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class AnalyzingComponent extends JComponent implements KeyListener {
	
	private static final long serialVersionUID = 8081562843396352959L;
	private char[] pressed_keys;
	private int maximum;
	
	private static final char EMPTY_CHAR = 255;
	
	public AnalyzingComponent() {
		pressed_keys = new char[12];
		for(int i = 0; i < pressed_keys.length; i++) {
			pressed_keys[i] = EMPTY_CHAR;
		}
		maximum = 0;
		setFocusable(true);
		addKeyListener(this);
	}
	
	private void dev_info() {
		JOptionPane.showMessageDialog(this, 
				"Maximum Key Press analizing tool.\nVersion 1.0.0.0, Copyright (c) 2009 Ma_Sys.ma\n" +
				"For help or bug-reports please send an e-mail to : Ma_Sys.ma@web.de\n\n" +
				"I hope that tool can help you with testing your keyboard.\n\n" +
				"Why to use this tool?\nIt can help you with testing the maximum of keys,\n" +
				"your keyboard sends to the computer. This is required for some games,\nlike " +
				"Descent3 for example.\n WARNING! The value displayed on 'Maximum' isn't correct each time.\n" +
				"There is an other problem with the key 'alt gr'. Please don't use it within this tool.", 
				"About", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		g.setColor(Color.YELLOW);
		g.drawString("Press as many keys the same time as possible. F5 resets, F1 showes some info.", 5, 20);
		
		g.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 70));
		g.setColor(Color.GREEN);
		int pressed = 0;
		for(int i = 0; i < pressed_keys.length; i++) {
			if(pressed_keys[i] != EMPTY_CHAR) {
				pressed++;
				g.drawString(String.valueOf(pressed_keys[i]), i*64+32, 85);
			}
		}
		if(pressed > maximum) {
			maximum = pressed;
		}
		
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 16));
		g.setColor(Color.RED);
		g.drawString("Keys pressed : " + pressed + ", Maximum : " + maximum, 10, 117);
	}
	
	public int getHeight() {
		return 128;
	}
	
	public int getWidth() {
		return 800;
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(getWidth(), getHeight());
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		} else if(e.getKeyCode() == KeyEvent.VK_F5) {
			maximum = 0;
			for(int i = 0; i < pressed_keys.length; i++) {
				pressed_keys[i] = EMPTY_CHAR;
			}
		} else if(e.getKeyCode() == KeyEvent.VK_F1) {
			dev_info();
		} else if(Character.isDefined(e.getKeyChar())) {
		
			char key = e.getKeyChar();
			for(int i = 0; i < pressed_keys.length; i++) {
				if(pressed_keys[i] == EMPTY_CHAR || pressed_keys[i] == key) {
					pressed_keys[i] = key;
					break;
				}
			}
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		char key = e.getKeyChar();
		for(int i = 0; i < pressed_keys.length; i++) {
			if(Character.toLowerCase(pressed_keys[i]) == Character.toLowerCase(key) || pressed_keys[i] == key) {
				pressed_keys[i] = EMPTY_CHAR;
			}
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {
	}
}
