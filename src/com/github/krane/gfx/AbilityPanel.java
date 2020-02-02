package com.github.krane.gfx;

import java.awt.Color;
import java.awt.Graphics;

import com.github.krane.entities.Player;

public class AbilityPanel {
	
	int panelCoords[] = {62, 565, 900, 100};
	
	public AbilityPanel()
	{
	
	}
	
	public void draw(Graphics graphics, Player player)
	{
		graphics.setColor(Color.red);
		graphics.drawRect(panelCoords[0], panelCoords[1], panelCoords[2], panelCoords[3]);
		graphics.setColor(Color.black);
		//abilities
		graphics.drawString("Dash Cooldown: " + player.getSpell().remainingTime_DASH , panelCoords[0] + 10, panelCoords[1] + 20);
		graphics.drawString("Regen Cooldown: " + player.getSpell().remainingTime_Regen , panelCoords[0] + 10, panelCoords[1] + 35);
		
	}
	
	
	
}
