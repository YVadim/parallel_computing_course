import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Graphics;

public class BallPanel extends JPanel {
	private static final int XSIZE = 20;
	private static final int YSIZE = 20;
	private float x = 0;
	private float y = 0;
	private float dx = 2;
	private float dy = 2;
	private double slowing_coeff = 0.001;
	private boolean change_dir_flag_sim = false;
	private int change_direction = 0;

	public BallPanel() {
		x = 25;
		y = 25;
		this.repaint();
	}

	public void draw (Graphics2D g2) {
		g2.setColor(Color.darkGray);
		g2.fill(new Ellipse2D.Double(x, y, XSIZE, YSIZE));
	}

	public void slow () {

		if (dx < 0) {
			dx += slowing_coeff;
		}
		else {
			dx -= slowing_coeff;
		}

		if (dy < 0) {
			dy += slowing_coeff;
		}
		else {
			dy -= slowing_coeff;
		}
	}

	public void changed_direction_msg() {
		if (change_dir_flag_sim) {
			System.out.println("Direction: " + change_direction);
		}
	}

	public void increment_direction() {
		if (!change_dir_flag_sim) {
			change_direction ++;
			change_dir_flag_sim = true;
		}
	}

	public void move() {
		if (dx != 0) {
			change_dir_flag_sim = false;
			x += dx;
			y += dy;
			slow();
			// System.out.println("DX" + (dx));
			if (x < 0) {
				x = 0;
				dx = -dx;
				increment_direction();
			}
			if (x + XSIZE >= this.getWidth()) {
				x = this.getWidth() - XSIZE;
				dx = -dx;
				increment_direction();
			}
			if (y < 0) {
				y = 0;
				dy = -dy;
				increment_direction();
			}
			if (y + YSIZE >= this.getHeight()) {
				y = this.getHeight() - YSIZE;
				dy = -dy;
				increment_direction();
			}

			changed_direction_msg();

			this.repaint();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		this.draw(g2);
	}
}
