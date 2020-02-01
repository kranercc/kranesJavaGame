package com.github.krane.spells;

import com.github.krane.entities.Player;
import com.github.krane.helpers.TimeHelp;
import com.github.krane.input.KeyManager;

public class Spells{


		boolean trigger_Dash = true;
		
		int dashCooldown = 4;
		long endTimeDash = 0;
		
		public float remainingTime_DASH = 0;

		public void DashX(Player p)
		{
			
			long currentTime = new TimeHelp().getSeconds();
			
			
			//System.out.println("End time : " + endTime + " Curr: " + currentTime);
			
			remainingTime_DASH = endTimeDash - currentTime;
			
			if(currentTime - endTimeDash >= 0) { trigger_Dash = true; }
			
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
				
			}
						
		}
		
		public void DashY(Player p)
		{			
			long currentTime = new TimeHelp().getSeconds();

			
			if(currentTime - endTimeDash >= 0) { trigger_Dash = true; }
			
			if(trigger_Dash == false) {return;}
			
			if(p.getGame().getKeyManager().shift)
			{
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
		
		
	
}
