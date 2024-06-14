package ddm;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Player {
	
	private final int turnPlayer;
	private int atk = 0, def = 0, move = 0, spell = 0,trap = 0;
	private String name = "";
	private ArrayList <Monster> summonedMonsters = new ArrayList<Monster>();
	private int destroyedMonsters = 0;
	private String color;
	private Color panelForeground;
	private JPanel panel;
	private Panel mainPanel;
	private JLabel nameLabel, attackLabel, defenceLabel, moveLabel, spellLabel, trapLabel;
	private ArrayList <Monster> juunishishiArray = new ArrayList<Monster>();
	
	private int dieBonus = 0;
	
	private String[] nameTemp = {"Yugi", "Tristan", "Mai", "Joey", "Bakura", "Marik", "Kaiba", 
			"Pegasus", "Duke", "Jack", "Mokuba", "Tea", "Jaden", "Yusei", "Weevil", "Dartz"};
	
	private ArrayList <Monster> allMonsters = new ArrayList<Monster>();
	
	public Player(int turn, Panel main_panel) {
		turnPlayer = turn;
		mainPanel = main_panel;
		
		setUpPanel();
		
		randomizeName();
		
		if (turnPlayer == 1)
			color = "blue";
		if (turnPlayer == 2)
			color = "orange";
		if (turnPlayer != 1 && turnPlayer != 2) {
			color = null;
		}
		setUpAllMonsters();
	}
	
	public void setUpAllMonsters() {
		//To add abilities
		//allMonsters.add(new Monster("Naturia Beast", 20, 20, 10, this, mainPanel, 2));//new
		//allMonsters.add(new Monster("Naturia Barkion", 20, 25, 10, this, mainPanel, 2));//new
		//allMonsters.add(new Monster("Babycerasaurus", 10, 10, 10, this, mainPanel, 1));//overdrive
		//allMonsters.add(new Monster("Thunder Dragon Colossus", 40, 30, 30, this, mainPanel, 3));//new
		//allMonsters.add(new Monster("Sky Striker Raye", 20, 15, 15, this, mainPanel, 2));//volcano
		//allMonsters.add(new Monster("Sky Striker Roze", 20, 15, 15, this, mainPanel, 2));//wall shadow
		//allMonsters.add(new Monster("Ash Blossom", 10, 10, 20, this, mainPanel, 1));
		//allMonsters.add(new Monster("Ursarctic Polari", 10, 10, 0, this, mainPanel, 1));
		//allMonsters.add(new Monster("Albaz", 15, 25, 15, this, mainPanel, 2));
		//allMonsters.add(new Monster("Ecclesia", 10, 15, 10, this, mainPanel, 2));
		//allMonsters.add(new Monster("Linkuriboh", 20, 10, 0, this, mainPanel, 1));
		//allMonsters.add(new Monster("Stardust Dragon", 30, 20, 10, this, mainPanel, 3));
		//allMonsters.add(new Monster("Ghoti of the Deep Beyond", 40, 0, 0, this, mainPanel, 3));
		//allMonsters.add(new Monster("Stone Sweeper", 10, 20, 0, this, mainPanel, 1));
		//allMonsters.add(new Monster("Numerounius Numerounia", 10, 1000, 1000, this, mainPanel, 5));
	

		//Abilities done
		allMonsters.add(new Monster("Yata-Garasu", 20, 0, 0, this, mainPanel, 1));
		allMonsters.add(new Monster("Dangerous Machine Type-6", 20, 0, 0, this, mainPanel, 1));
		allMonsters.add(new Monster("Tsuchinoko", 10, 10, 0, this, mainPanel, 1));
		allMonsters.add(new Monster("Labrynth Labyrinth", 60, 0, 10, this, mainPanel, 1));
		allMonsters.add(new Monster("Cyber Dragon Core", 10, 10, 20, this, mainPanel, 1));
		allMonsters.add(new Monster("Snake-Eyes Poplar", 10, 10, 10, this, mainPanel, 1)); 		
		allMonsters.add(new Monster("Vampire Fraulein", 40, 10, 10, this, mainPanel, 2));
		allMonsters.add(new Monster("IP Masquerena", 10, 10, 20, this, mainPanel, 2));
		allMonsters.add(new Monster("Ki Sikil", 20, 20, 10, this, mainPanel, 2));
		allMonsters.add(new Monster("Lil La", 20, 20, 10, this, mainPanel, 2));
		allMonsters.add(new Monster("Magicians of Bond and Unity", 40, 30, 10, this, mainPanel, 3)); 
		allMonsters.add(new Monster("Cartesia", 40, 30, 0, this, mainPanel, 3));
		allMonsters.add(new Monster("Gandora", 10, 20, 0, this, mainPanel, 3));
		allMonsters.add(new Monster("Gameciel, The Sea Turtle Kaiju", 20, 30, 10, this, mainPanel, 3));
		allMonsters.add(new Monster("Ultimate Conductor Tyranno", 30, 40, 20, this, mainPanel, 3)); 
		allMonsters.add(new Monster("Deus Machinex", 50, 40, 20, this, mainPanel, 4)); 
		allMonsters.add(new Monster("AriseHeart", 50, 40, 30, this, mainPanel, 4)); 
		allMonsters.add(new Monster("Dragon Magia Master", 60, 50, 20, this, mainPanel, 4)); 
		allMonsters.add(new Monster("Slifer the Sky Dragon", 60, 60, 60, this, mainPanel, 5));
		allMonsters.add(new Monster("Obelisk the Tormentor", 60, 60, 60, this, mainPanel, 5));
		allMonsters.add(new Monster("Winged Dragon of Ra", 60, 60, 60, this, mainPanel, 5));
	}
	
	public void addAtk(int i) {
		atk = atk + i;
		attackLabel.setText(" " + atk);
	}
	public void addDef(int i) {
		def = def + i;
		defenceLabel.setText(" " + def);
	}
	public void addMove(int i) {
		move = move + i;
		moveLabel.setText(" " + move);
	}
	public void addSpell(int i) {
		spell = spell + i;
		spellLabel.setText(" " + spell);
	}
	public void addTrap(int i) {
		trap = trap + i;
		trapLabel.setText(" " + trap);
	}
	
	public void subtractAtk(int i) {
		atk = atk - i;
		attackLabel.setText(" " + atk);
	}
	public void subtractDef(int i) {
		def = def - i;
		defenceLabel.setText(" " + def);
	}
	public void subtractMove(int i) {
		move = move - i;
		moveLabel.setText(" " + move);
	}
	public void subtractSpell(int i) {
		spell = spell - i;
		spellLabel.setText(" " + spell);
	}
	public void subtractTrap(int i) {
		trap = trap - i;
		trapLabel.setText(" " + trap);
	}
	
	public void setDieBonus(int newDieBonus) {
		dieBonus = newDieBonus;
	}
	public int dieBonus() {
		return dieBonus;
	}
	
	public ArrayList <Monster> summonedMonsters() {
		return summonedMonsters;
	}

	public void summonAMonster(Monster monster) {
		summonedMonsters.add(monster);	//Monster lord not included
		
		int index = allMonsters.indexOf(monster);	//For one time use of every monster
		if (index >= 0) {
			allMonsters.remove(monster);
		}
	}

	public void destroyMonster (Monster monster) {
		summonedMonsters.remove(monster);
		destroyedMonsters++;
		
		onDestroyMonsterAbilities();
	}
	public int destroyedMonsters() {
		return destroyedMonsters;
	}
	public void onDestroyMonsterAbilities() {
		for (Monster mon : summonedMonsters) {
			if (mon.name().equalsIgnoreCase("Obelisk the Tormentor")) {
				mon.ability();
			}
			else if (mon.name().equalsIgnoreCase("Mr. Volcano")) {
				mon.ability();
			}
		}
	}
	
	public int turnPlayer() {
		return turnPlayer;
	}
	
	public int atk() {
		return atk;
	}
	public int def() {
		return def;
	}
	public int move() {
		return move;
	}
	public int spell() {
		return spell;
	}
	public int trap() {
		return trap;
	}
	public String name() {
		return name;
	}
	public void randomizeName() {
		name = nameTemp[(int)(Math.random()*nameTemp.length)];
		nameLabel.setText(name);
	}
	public String color() {
		return color;
	}
	public ArrayList<Monster> allMonsters() {
		return allMonsters;
	}
	public ArrayList<Monster> juunishishiArray() {
		return juunishishiArray;
	}
	
	private void setUpPanel() {
		panel = new JPanel();
		panel.setSize(126, 250);
		panel.setLayout(new GridLayout(6,0));
		if (turnPlayer == 1) {
			panel.setBackground(new Color(2, 124, 255, 255));
			panelForeground = Color.white;
		}
		else if (turnPlayer == 2) {
			panel.setBackground(new Color(181, 32, 32, 255));
			panelForeground = Color.white;
		}
		
		nameLabel = new JLabel();
		nameLabel.setSize(126,25);
		nameLabel.setFocusable(false);
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(panelForeground);
		nameLabel.setFont(new Font("Ariel", Font.BOLD, 16));
		nameLabel.setText(name);
		panel.add(nameLabel);
		
		attackLabel = new JLabel();
		attackLabel.setSize(100,25);
		attackLabel.setFocusable(false);
		attackLabel.setHorizontalAlignment(SwingConstants.CENTER);
		attackLabel.setForeground(panelForeground);
		attackLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		attackLabel.setText(" " + atk);
		attackLabel.setIcon(getIcon("atk1", 25, 25));
		panel.add(attackLabel);
		
		defenceLabel = new JLabel();
		defenceLabel.setSize(100,25);
		defenceLabel.setFocusable(false);
		defenceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		defenceLabel.setForeground(panelForeground);
		defenceLabel.setFont(attackLabel.getFont());
		defenceLabel.setText(" " + def);
		defenceLabel.setIcon(getIcon("def1", 25, 25));
		panel.add(defenceLabel);
		
		moveLabel = new JLabel();
		moveLabel.setSize(100,25);
		moveLabel.setFocusable(false);
		moveLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moveLabel.setForeground(panelForeground);
		moveLabel.setFont(attackLabel.getFont());
		moveLabel.setText(" " + move);
		moveLabel.setIcon(getIcon("move1", 25, 25));
		panel.add(moveLabel);
		
		spellLabel = new JLabel();
		spellLabel.setSize(100,25);
		spellLabel.setFocusable(false);
		spellLabel.setHorizontalAlignment(SwingConstants.CENTER);
		spellLabel.setForeground(panelForeground);
		spellLabel.setFont(attackLabel.getFont());
		spellLabel.setText(" " + spell);
		spellLabel.setIcon(getIcon("spell1", 25, 25));
		panel.add(spellLabel);
		
		trapLabel = new JLabel();
		trapLabel.setSize(100,25);
		trapLabel.setFocusable(false);
		trapLabel.setHorizontalAlignment(SwingConstants.CENTER);
		trapLabel.setForeground(panelForeground);
		trapLabel.setFont(attackLabel.getFont());
		trapLabel.setText(" " + trap);
		trapLabel.setIcon(getIcon("trap1", 25, 25));
		panel.add(trapLabel);
	}
	
	public JPanel panel() {
		return panel;
	}
	
	private ImageIcon getIcon(String picName, int width, int height) {
		URL imageURL = getClass().getResource("resources/" + picName + ".jpg");	
		if (imageURL != null) {
			ImageIcon imageIcon = new ImageIcon(imageURL);
			Image image = imageIcon.getImage();
			Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
			imageIcon = new ImageIcon(newimg);
			if (imageIcon != null)
				return imageIcon;
		}
		JOptionPane.showConfirmDialog(null, "Invalid pic inside Player class.\n"
				+ "Do something about it.", 
					"ERROR", JOptionPane.ERROR_MESSAGE);
		return null;
	}
	
	public String toString() {
		return "atk: " + atk + "\tdef: " + def + "\tmove: " + move + "\tspell: " + spell + "\ttrap: " + trap;
	}
	
}
