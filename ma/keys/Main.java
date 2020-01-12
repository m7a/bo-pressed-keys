package ma.keys;

import javax.swing.JFrame;

public class Main extends JFrame {
	
	private static final long serialVersionUID = 5760229300847712694L;

	public Main() {
		super("Pressed Keys");
		AnalyzingComponent comp = new AnalyzingComponent();
		getContentPane().add("Center", comp);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocation(50, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
