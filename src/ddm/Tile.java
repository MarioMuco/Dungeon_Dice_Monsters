package ddm;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class Tile extends JLabel{

	private static final long serialVersionUID = 1L;
	private final int r, c;
	private Border blackBorder = BorderFactory.createLineBorder(Color.black, 1);
	private Border player1Border = BorderFactory.createLineBorder(new Color(2, 124, 255, 255), 2);
	private Border player2Border = BorderFactory.createLineBorder(new Color(181, 32, 32, 255), 2);
	private Monster monster = null;
	private MouseListener mouseListener = null;
	
	private int cModifier = 2;	//Makes C (cModifier*2) shorter than R overall
	
	private String condition = "empty";	//path1, path2, empty, dne
	
	public Tile(int r_cord, int c_cord) {
		r = r_cord;
		c = c_cord;
		
		setOpaque(true);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
		
		if (r < 2 || r > Board.tilesInBoard + 1 || c < 2 + cModifier || c > Board.tilesInBoard + 1 - cModifier)	 {
			condition = "dne";	
		}
		
		updatePics();
	}
	
	public String getState() {
		return condition;
	}
	
	public void setState(String state) {
		if (condition.equals("dne"))
			return;
		if (state.equals("path1") || state.equals("path2") 
				|| state.equals("empty") || state.equals("dne")) {
			condition = state;
			setPathPic();
		}
		else
			JOptionPane.showConfirmDialog(null, "Invalid state of tile to change.\n"
					+ "Do something about it.", 
 					"ERROR", JOptionPane.ERROR_MESSAGE);
		updatePics();
	}
	
	public void setPathPic() {
		URL imageURL = null;
		if (condition.equals("path1")) {
			imageURL = getClass().getResource("resources/path1.jpg");	
		}
		else if (condition.equals("path2")) {
			imageURL = getClass().getResource("resources/path2.jpg");	
		}
		
		if (imageURL != null) {
			ImageIcon imageIcon = new ImageIcon(imageURL);
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(this.getWidth()-1, this.getHeight()-1, java.awt.Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(newimg));
		} else {
			JOptionPane.showConfirmDialog(null, "Bad imageURL received from Tile class.\n"
					+ "Do something about it.", 
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void addMonster(Monster monsterToPlace) {
		if (monster != null) {
			System.out.println("Trying to add monster to a tile with a monster.\n"
					+ "Do something about it.");
			return;
		}
		monster = monsterToPlace;
		monster.setTile(this);
		updatePics();
	}
	
	public void moveMonster(Tile newTile) {
		if (newTile != this) {
			newTile.addMonster(monster);
			monster.setTile(newTile);
			removeMonster();
		}
	}
	
	public void removeMonster() {
		removeMouseListener(mouseListener);
		monster = null;
		updatePics();
	}
	
	public void checkAndDestroyMonster() {
		if (monster.hp() <= 0) {
			System.out.println("DESTROY");
			monster.destroy();
			monster.owner().destroyMonster(monster);
			
			removeMonster();
		}
	}
	
	public Monster monster() {
		return monster;
	}
	
	public void rememberMouseListener(MouseListener aMouseListener) {
		mouseListener = aMouseListener;
	}
	
	public MouseListener mouseListener() {
		return mouseListener;
	}
	
	public void removeMouseListener() {
		mouseListener = null;
	}
	
	public void updatePics() {
		setBorder(blackBorder);
		if (condition.equals("empty")) {
			setBackground(null);
			setIcon(null);
		} else if (condition.equals("dne")) {
			setBackground(Color.black);
		} else if (condition.equals("path1")) {
			setBackground(Color.blue);
			setPathPic();
		} else if (condition.equals("path2")) {
			setBackground(Color.orange);
			setPathPic();
		}
		
		if (monster != null) {
			setIcon(monster.getResizedImageIcon(this.getWidth()-1, this.getHeight()-1));
			if (monster.owner().turnPlayer() == 1) {
				setBackground(Color.blue);
				setBorder(player1Border);
			} else if (monster.owner().turnPlayer() == 2) {
				setBackground(Color.orange);
				setBorder(player2Border);
			}
		}
	}
	
	public int r() {
		return r;
	}
	
	public int c() {
		return c;
	}
	
	public int cModifier() {
		return cModifier;
	}
}
