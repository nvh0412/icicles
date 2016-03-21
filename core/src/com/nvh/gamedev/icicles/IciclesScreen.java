package com.nvh.gamedev.icicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

/**
 * Created by HoaNV on 3/19/16.
 */
public class IciclesScreen implements Screen {

    private ShapeRenderer shapeRenderer;
    private ExtendViewport extendViewport;
    private Icicle icicle;
    private Player player;

    @Override
    public void pause() {

    }

    @Override
    public void show() {
        extendViewport = new ExtendViewport(Constant.WORLD_SIZE, Constant.WORLD_SIZE);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);

        icicle = new Icicle(new Vector2(Constant.WORLD_SIZE /2, Constant.WORLD_SIZE /2));
        player = new Player(extendViewport);
    }

    @Override
    public void render(float delta) {
        extendViewport.apply(true);

        Gdx.gl.glClearColor(Constant.BACKGROUND_COLOR.r, Constant.BACKGROUND_COLOR.g, Constant.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(extendViewport.getCamera().combined);

        shapeRenderer.begin();
        icicle.render(shapeRenderer);
        player.render(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        shapeRenderer.dispose();
    }

    @Override
    public void dispose(){

    }

    @Override
    public void resize(int width, int height) {
        extendViewport.update(width, height);
        player.init();
    }
}
