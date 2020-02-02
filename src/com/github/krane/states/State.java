package com.github.krane.states;

import java.awt.Graphics;

import com.github.krane.Game;
import com.github.krane.Handler;

public abstract class State {

	private static State currentState = null;
	
	
	public static void setState(State state)
	{
		currentState = state;
	}
	
	public static State getState()
	{
		return currentState;
	}
	
	protected Handler handler;
	
	public State(Handler handler)
	{
		this.handler = handler;
	}
	
	//class
	public abstract void tick();
	public abstract void render(Graphics graphics);
	
	
	
	
	
}
