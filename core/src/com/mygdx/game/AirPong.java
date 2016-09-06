package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import States.GameStateManager;
import States.MenuState;

public class AirPong extends ApplicationAdapter {
	private SpriteBatch batch;

	public static final int WIDTH = 1437;
	public static final int HEIGHT = 772;
	private GameStateManager gsm;

	
	@Override
	public void create () {
		gsm = new GameStateManager();
		batch = new SpriteBatch();
		gsm.push(new MenuState(gsm));
		
	}

	@Override
	public void render () {
		gsm.update(Gdx.graphics.getDeltaTime());
		gsm.render(batch);
	}
}
