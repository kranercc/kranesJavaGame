package com.github.krane;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.rmi.CORBA.Tie;
import javax.swing.JLabel;

import com.github.krane.gfx.Assets;
import com.github.krane.gfx.ImageLoader;
import com.github.krane.input.KeyManager;
import com.github.krane.states.GameState;
import com.github.krane.states.State;

public class Game implements Runnable{
	
	private Display display;
	
	private Thread thread;
	private boolean running = false;
	
	
	public String title;
	public int width, height;
	
	
	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}

	private BufferStrategy bStrategy;
	private Graphics graphics;
	
	
	//Input
	private KeyManager keyManager;
	
	
	//States
	private State gameState;
	
	//handler
	private Handler handler;
	
	public Game(String title, int width, int height)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		
		keyManager = new KeyManager();
		handler = new Handler(this);
		
	}

	
	private void init()
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(handler);
		State.setState(gameState);
	}
	
	
	private void render()
	{
		//int canvasSize[] = {(int)display.getCanvas().getSize().getWidth(), (int)display.getCanvas().getSize().getHeight()};
		
		bStrategy = display.getCanvas().getBufferStrategy();
		if(bStrategy == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		graphics = bStrategy.getDrawGraphics();
		
		//clear screen
		graphics.clearRect(0, 0, width, height);

		//Draw HERE
		
		if(State.getState() != null)
		{
			State.getState().render(graphics);
		}
		
		graphics.setColor(Color.BLUE);
		Font font = new Font("Serif", Font.BOLD, 16);
		graphics.setFont(font);
		graphics.drawString("FPS: " + fpsToShow.toString(), 50, 50);
		//End of Draw
		bStrategy.show();
		graphics.dispose();
		
		
	}
	
	private void tick() {

		keyManager.tick();
		if(State.getState() != null)
		{
			State.getState().tick();
		}
	}

	int fps = 60;
	double timePerTick = 1000000000 / fps;
	double delta = 0;
	long now;
	long lastTime = System.nanoTime();
	long timer = 0;
	int ticks = 0;
	Integer fpsToShow = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		init();
		
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1)
			{
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000)
			{
				fpsToShow = ticks;
				ticks = 0;
				timer = 0;
			}
			
		}
		stop();
	}
	
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public synchronized void start()
	{
		if(running == true)
		{
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		if(!running)
		{
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
