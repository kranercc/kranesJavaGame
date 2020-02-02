package com.github.krane.playerSpecific;

import com.github.krane.entities.Player;
import com.github.krane.helpers.TimeHelp;

public class LevelingUP {

	
	
	public void Experience()
	{
		
	}
	
	
	
	long currentTime;
	long endTime;
	
	public void passiveExperience(Player p)
	{
	
		
		currentTime = new TimeHelp().getSeconds();
		
		if (endTime == 0)
		{
			endTime = currentTime + p.passiveXP_Ammount;
		}

		
		System.out.println("End: " + endTime);
		if (currentTime - endTime >= 0)
		{
			p.exp += 10;
			endTime = currentTime + p.passiveXP_Ammount;
		}
		
		
	}
}
