//import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics;

public class BounceFrame extends JFrame {
	private BallPanel ballPanel;
	public static final int WIDTH = 450;
	public static final int HEIGHT = 350;

	public BounceFrame() {
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("Ball simple programm");

		this.ballPanel = new BallPanel();
		this.add(ballPanel);
	}

	public void simulate() {
		int i = 0;
		while (true) {
			ballPanel.move();
			try {
				Thread.sleep(5);
			}
			catch (InterruptedException ex) {
				;
			}
			//System.out.println("i="+(i++));
		}
	}
}
