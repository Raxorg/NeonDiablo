package com.epicness.neondiablo.game;

import static com.badlogic.gdx.graphics.Color.BLACK;

import com.badlogic.gdx.utils.ScreenUtils;
import com.epicness.fundamentals.renderer.Renderer;
import com.epicness.neondiablo.game.stuff.GameStuff;

public class GameRenderer extends Renderer<GameStuff> {

    @Override
    public void render() {
        ScreenUtils.clear(BLACK);
        spriteBatch.begin();
        stuff.getGrid().draw(spriteBatch);
        spriteBatch.end();
    }
}