package ddm;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;


public class Board extends JPanel {
	
	private static final long serialVersionUID = 1L;
	public final int width = 660;
	public static final int tilesInBoard = 17;
	private final int tilesInLength = tilesInBoard + 4;
	private Tile[][] tiles = new Tile[tilesInLength][tilesInLength];
	
	public Board() {
		setLayout(new GridLayout(tilesInLength, tilesInLength));
		setSize(new Dimension(width, width));
		
		for (int r = 0; r < tilesInLength; r++)
		{
			for (int c = 0; c < tilesInLength; c++) 
			{
				tiles[r][c] = new Tile(r, c);
				add(tiles[r][c]);
			}
		}
	}
	
	public Tile[][] getTiles() {
		return tiles;
	}

}
