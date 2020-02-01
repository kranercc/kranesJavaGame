package com.github.krane.spells;

import com.github.krane.helpers.TimeHelp;
import com.github.krane.input.KeyManager;

public class Spells{


		boolean trigger_Dash = true;
		
		int dashCooldown = 4;
		long endTimeDash = 0;
		
		
		public float remainingTime_DASH = 0;

		public float DashX(float x, int agi, KeyManager km)
		{
			
			long currentTime = new TimeHelp().getSeconds();
			
			
			//System.out.println("End time : " + endTime + " Curr: " + currentTime);
			
			remainingTime_DASH = endTimeDash - currentTime;
			
			if(currentTime - endTimeDash >= 0) { trigger_Dash = true; }
			
			if(trigger_Dash == false) {return x;}
			
			
			if(km.shift)
			{
				if(km.left)
				{
					trigger_Dash = false;
					endTimeDash = new TimeHelp().getSeconds() + dashCooldown;
					return x = x - agi*1.0f;
				}
				if(km.right)
				{
				
					trigger_Dash = false;
					endTimeDash = new TimeHelp().getSeconds() + dashCooldown;
					return x = x + agi*1.0f;
				
				}
				
			}
			
			return x;
			
		}
		
		
		public float DashY(float y, int agi, KeyManager km)
		{			
			long currentTime = new TimeHelp().getSeconds();

			
			if(currentTime - endTimeDash >= 0) { trigger_Dash = true; }
			
			if(trigger_Dash == false) {return y;}
			
			if(km.shift)
			{
				if(km.up)
				{
					trigger_Dash = false;
					endTimeDash = new TimeHelp().getSeconds() + dashCooldown;
					return y = y - agi*1.0f;
					
				}
				if(km.down)
				{
					trigger_Dash = false;
					endTimeDash = new TimeHelp().getSeconds() + dashCooldown;
					return y = y + agi*1.0f;
					
				}
				
			}
			
			return y;
			
		}
		
		
	
}
