package com.github.krane.spells;

import com.github.krane.entities.Player;
import com.github.krane.helpers.TimeHelp;
import com.github.krane.input.KeyManager;

public class Spells{


		boolean trigger_Dash = true;
		int dashCooldown = 4;
		long endTimeDash = 0;
		public float remainingTime_DASH = 0;

			
		
		public void Dash(Player p)
		{
			
			long currentTime = new TimeHelp().getSeconds();
			
			
			//System.out.println("End time : " + endTime + " Curr: " + currentTime);
			
			remainingTime_DASH = endTimeDash - currentTime;
			
			if(currentTime - endTimeDash >= 0) { trigger_Dash = true; remainingTime_DASH = 0; }
			
			if(trigger_Dash == false) {return;}
			
			
			if(p.getGame().getKeyManager().shift)
			{
				if(p.getGame().getKeyManager().left)
				{
					trigger_Dash = false;
					endTimeDash = new TimeHelp().getSeconds() + dashCooldown;
					p.setX(p.getX() - p.agi*1.0f);
				}
				if(p.getGame().getKeyManager().right)
				{
				
					trigger_Dash = false;
					endTimeDash = new TimeHelp().getSeconds() + dashCooldown;
					p.setX(p.getX() + p.agi*1.0f);
				
				}
				if(p.getGame().getKeyManager().up)
				{
					trigger_Dash = false;
					endTimeDash = new TimeHelp().getSeconds() + dashCooldown;
					p.setY(p.getY() - p.agi*1.0f);
					
				}
				if(p.getGame().getKeyManager().down)
				{
					trigger_Dash = false;
					endTimeDash = new TimeHelp().getSeconds() + dashCooldown;
					p.setY(p.getY() + p.agi*1.0f);
					
				}
			}
						
		}
		
		
		
		boolean trigger_Regen = true;
		int regenCooldown = 7;
		long endTimeRegen = 0;
		public float remainingTime_Regen = 0;
		
		public void Regen(Player player)
		{
			long currentTime = new TimeHelp().getSeconds();
						
						
			//System.out.println("End time : " + endTime + " Curr: " + currentTime);
			
			remainingTime_Regen = endTimeRegen - currentTime;
			
			if(currentTime - endTimeRegen >= 0) { trigger_Regen = true; remainingTime_Regen = 0; }
			
			if(trigger_Regen == false) {return;}
			if(player.getGame().getKeyManager().q)
			{
				if(player.getHealth() <= player.getMaxHealth())
				{
					trigger_Regen = false;
					endTimeRegen = new TimeHelp().getSeconds() + regenCooldown;
					player.setHealth(player.getHealth() + player.intel*3.0f);		
				}
			
				//if go over
				if(player.getHealth() > player.getMaxHealth())
				{
					player.setHealth(player.getMaxHealth());
				}
			}
		}
		
		
	
}
