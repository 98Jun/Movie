package Movie;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class ImgPanel1 extends JPanel {
	private ImageIcon icon = new ImageIcon("../Movie/src/Image/ma.jpg");
	private Image img = icon.getImage(); // 이미지 객체

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}

class ImgPanel2 extends JPanel {
	private ImageIcon icon = new ImageIcon("../Movie/src/Image/city2.jpg");
	private Image img = icon.getImage(); // 이미지 객체

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}

class ImgPanel3 extends JPanel {
	private ImageIcon icon = new ImageIcon("../Movie/src/Image/word.jpg");
	private Image img = icon.getImage(); // 이미지 객체

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}

class ImgPanel4 extends JPanel {
	private ImageIcon icon = new ImageIcon("../Movie/src/Image/bro.jpg");
	private Image img = icon.getImage(); // 이미지 객체

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}

class ImgPanel5 extends JPanel {
	private ImageIcon icon = new ImageIcon("../Movie/src/Image/top.jpg");
	private Image img = icon.getImage(); // 이미지 객체

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
}

class ImgPanel6 extends JPanel {
	
	private ImageIcon icon = new ImageIcon("../Movie/src/Image/bs.jpg");
	private Image img = icon.getImage(); // 이미지 객체

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
	}
	
}
//class ImgPanel7 extends JPanel {
//	
//	private ImageIcon icon = new ImageIcon("C:/work/Movie/src/Image/moviecord.jpg");
//	private Image img = icon.getImage(); // 이미지 객체
//
//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
//	}

	

