package com.nvh.gamedev.icicles;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class IciclesGame extends ApplicationAdapter {
    private ShapeRenderer shapeRenderer;
    private ExtendViewport extendViewport;
	
	@Override
	public void create () {
        shapeRenderer = new ShapeRenderer();
        extendViewport = new ExtendViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
