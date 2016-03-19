package com.nvh.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by HoaNV on 3/19/16.
 */
public class Icicle {

    private Vector2 position;

    public Icicle(Vector2 position) {
        this.position = position;
    }

    public void render(ShapeRenderer renderer){
        // Set the shaperenderer's color
        renderer.setColor(Constant.ICICLES_COLOR);

        // Set the shape type
        renderer.set(ShapeRenderer.ShapeType.Filled);

        // Draw the icicle using size constants
        renderer.triangle(position.x, position.y,
                position.x - Constant.ICICLES_WIDTH / 2, position.y + Constant.ICICLES_HEIGHT,
                position.x + Constant.ICICLES_WIDTH / 2, position.y + Constant.ICICLES_HEIGHT
        );
    }

}
