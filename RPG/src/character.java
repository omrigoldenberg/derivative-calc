import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.Timer;

public class character extends JComponent implements ActionListener {
		BufferedImage charImg;
		String name;
		int gravity= 80;
		boolean inAir = false;
		int frameCounter;
		int charX;
		int charY;
		int charXSpeed;
		int charYSpeed;
		int charXSize;
		int charYSize;
		int charSpeed;
		int charJumpSpeed;
		File[] img = new File[17];
		Timer walkRight;
		Timer walkLeft;
		character(String name, int charX, int charY, int charXSize, int charYSize, int charSpeed){
			img[0] = new File("idle.png");
			img[1] = new File("walkR1.png");
			img[2] = new File("walkR2.png");
			img[3] = new File("walkR3.png");
			img[4] = new File("walkR4.png");
			img[5] = new File("walkR5.png");
			img[6] = new File("walkR6.png");
			img[7] = new File("walkR7.png");
			img[8] = new File("walkR8.png");
			img[9] = new File("walkL1.png");
			img[10] = new File("walkL2.png");
			img[11] = new File("walkL3.png");
			img[12] = new File("walkL4.png");
			img[13] = new File("walkL5.png");
			img[14] = new File("walkL6.png");
			img[15] = new File("walkL7.png");
			img[16] = new File("walkL8.png");
			this.name = name;
			this.charSpeed = charSpeed;
			this.charX = charX;
			this.charY = charY;
			this.charXSize = charXSize;
			this.charYSize = charYSize;
			charXSpeed = 0;
			charYSpeed = 0;
			charJumpSpeed = 100;
			frameCounter=1;
			try{
				charImg = ImageIO.read(img[0]);
			}
			catch(Exception e) {
				
			}
			walkRight = new Timer(100, new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							charImg = ImageIO.read(img[frameCounter]);
						} catch (IOException e1) {
							System.out.println(frameCounter);
						}
						if(frameCounter < 8)
							frameCounter++;
						else
							frameCounter = 1;
					}
					});
			walkLeft = new Timer(100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						charImg = ImageIO.read(img[frameCounter+8]);
					} catch (IOException e1) {
						System.out.println(frameCounter);
					}
					if(frameCounter < 8)
						frameCounter++;
					else
						frameCounter = 1;
				}
				});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(charImg, charX, charY ,charXSize,charYSize, null);
		}
		public void update(){
			charX += (charXSpeed*(1.0/50));
			charY -= (charYSpeed*(1.0/50));
			charYSpeed -= gravity*(1.0/50);
			if(charY >= 855) {
				inAir = false;
				charYSpeed = 0;
				charY = 855;
			}
			repaint();
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		}
}
