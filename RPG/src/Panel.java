import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;
public class Panel extends JFrame implements ActionListener, KeyListener{
	Timer mainTimer;
	ArrayList<character> objects = new ArrayList<character>();
	character mainChar;
	File img = new File("idle.png");
	Panel(){
		mainChar = new character("MC", 960, 855, 60, 100, 50);
		addKeyListener(this);
		setSize(1920,1080);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setTitle("RPG");
	    mainTimer = new Timer(20, new ActionListener(
	    		) {
	    	public void actionPerformed(ActionEvent e) {
	    		update();
	    	}
	    });
	    mainTimer.start();
	    createLevel();
	    add(mainChar);
	}
	public void createLevel() {
		//TODO
	}
	public void update() {
		mainChar.update();
	}
	public static void main(String[] args) {
		Panel myPanel = new Panel();
		myPanel.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A) {
			mainChar.charXSpeed = -mainChar.charSpeed;
			mainChar.walkLeft.start();
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			mainChar.charXSpeed = mainChar.charSpeed;
			mainChar.walkRight.start();
		}
		if(e.getKeyCode() == KeyEvent.VK_W) {
			if(!mainChar.inAir) {
				mainChar.charYSpeed = mainChar.charJumpSpeed;
				mainChar.inAir = true;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_A) {
			mainChar.charXSpeed = 0;
			mainChar.walkLeft.stop();
			try{
				mainChar.charImg = ImageIO.read(img);
			}
			catch(Exception e1) {
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			mainChar.charXSpeed = 0;
			mainChar.walkRight.stop();
			try{
				mainChar.charImg = ImageIO.read(img);
			}
			catch(Exception e1) {
			}
			}
		}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
