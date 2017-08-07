package minicraft.screen;

import minicraft.gfx.Color;
import minicraft.gfx.Font;
import minicraft.gfx.FontStyle;
import minicraft.gfx.Screen;

public class AboutDisplay extends Display {
	
	private Menu parent; // Creates a parent object to go back to. *Should* always be a menu...
	private static final String[] info = Font.getLines("Moded by David.b and +Dillyg10+ until 1.8, then taken over by Chris J. Our goal is to expand Minicraft to be more fun and continuous.\nMinicraft was originally made by Markus Perrson for ludum dare 22 competition.", Screen.w - 8, Font.textHeight()*3/2);
	
	/** The about menu is a read menu about what the game was made for. Only contains text and a black background */
	public AboutDisplay(Menu parent) {
		super();
		setTextStyle(
			new FontStyle(Color.get(-1, 333))
			.setYPos(5*Font.textHeight())
		);
		
		text = info;
		
		this.parent = parent;
	}

	public void tick() {
		if (input.getKey("exit").clicked || input.getKey("select").clicked) {
			game.setMenu(parent); //goes back to parent if either above button is pressed
		}
	}
	
	/** Renders the text on the screen */
	public void render(Screen screen) {
		screen.clear(0); // clears the screen to make it black.
		
		Font.drawCentered("About MinicraftPlus", screen, 1 * 8, Color.get(-1, 555));
		super.render(screen);
		//FontStyle style = new FontStyle(Color.get(-1, 333));
		//Font.drawParagraph(, screen, 4, true, 5 * 8, false, style, 12);
	}
}