package com.nvh.gamedev.icicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by HoaNV on 3/19/16.
 */
public class Player  {

    private Vector2 position;
    private Viewport viewport;

    public Player(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        position = new Vector2(viewport.getWorldWidth() / 2, Constant.PLAYER_HEAD_HEIGHT);
    }

    public void update(float delta) {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            position.x -= delta * Constant.PLAYER_ACCELERATION;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            position.x += delta * Constant.PLAYER_ACCELERATION;
        }

        ensureInBounds();
    }

    public void ensureInBounds() {
        if (position.x - Constant.PLAYER_HEAD_RADIUS < 0) {
            position.x = Constant.PLAYER_HEAD_RADIUS;
        }

        if (position.x + Constant.PLAYER_HEAD_RADIUS > viewport.getWorldWidth()) {
            position.x = viewport.getWorldWidth() - Constant.PLAYER_HEAD_RADIUS;
        }
    }

    public void render(ShapeRenderer shapeRenderer) {
        shapeRenderer.setColor(Constant.PLAYER_COLOR);
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(position.x, position.y, Constant.PLAYER_HEAD_RADIUS, Constant.PLAYER_HEAD_SEGMENTS);

        Vector2 topLimb = new Vector2(position.x, position.y - Constant.PLAYER_HEAD_RADIUS);
        Vector2 botLimb = new Vector2(position.x, position.y - Constant.PLAYER_HEAD_RADIUS * 3);

        shapeRenderer.rectLine(topLimb, botLimb, Constant.PLAYER_LIMB_WIDTH);

        shapeRenderer.rectLine(
            topLimb.x, topLimb.y,
            topLimb.x + Constant.PLAYER_HEAD_RADIUS, topLimb.y - Constant.PLAYER_HEAD_RADIUS,
            Constant.PLAYER_LIMB_WIDTH
        );

        shapeRenderer.rectLine(
            topLimb.x, topLimb.y,
            topLimb.x - Constant.PLAYER_HEAD_RADIUS, topLimb.y - Constant.PLAYER_HEAD_RADIUS,
            Constant.PLAYER_LIMB_WIDTH
        );

        shapeRenderer.rectLine(
            botLimb.x, botLimb.y,
            botLimb.x + Constant.PLAYER_HEAD_RADIUS, botLimb.y - Constant.PLAYER_HEAD_RADIUS,
            Constant.PLAYER_LIMB_WIDTH
        );

        shapeRenderer.rectLine(
            botLimb.x, botLimb.y,
            botLimb.x - Constant.PLAYER_HEAD_RADIUS, botLimb.y - Constant.PLAYER_HEAD_RADIUS,
            Constant.PLAYER_LIMB_WIDTH
        );
    }
}
