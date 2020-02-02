package com.github.krane.playerSpecific;

import com.github.krane.entities.Player;
import com.github.krane.helpers.TimeHelp;

public class LevelingUP {

	
	
	public void Experience()
	{
		
	}
	
	
	
	long currentTime;
	long endTime;
	
	public void levelUp(Player player)
	{
		if(player.exp >= player.requiredExp)
		{
			player.exp = 1;
			player.requiredExp = (int) (player.requiredExp * 1.3);
			player.level = player.level + 1;
			
			
			//stats
			player.str = player.str + 1;
			player.agi = player.agi + 1;
			player.intel = player.intel + 1;
			
			player.setSpeed(player.default_speed + player.agi*0.08f);
			player.setMaxHealth(player.getMaxHealth() + player.str*0.30f);
		}
	}
	public void passiveExperience(Player p)

	{
	
		
		currentTime = new TimeHelp().getSeconds();
		
		if (endTime == 0)
		{
			endTime = currentTime + p.passiveXP_Ammount;
		}

	
		if (currentTime - endTime >= 0)
		{
			p.exp += 10;
			endTime = currentTime + p.passiveXP_Ammount;
		}
		
		
	}
}
