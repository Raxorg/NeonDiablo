package com.epicness.neondiablo.game.logic;

import static com.badlogic.gdx.Input.Keys.DOWN;
import static com.badlogic.gdx.Input.Keys.LEFT;
import static com.badlogic.gdx.Input.Keys.RIGHT;
import static com.badlogic.gdx.Input.Keys.UP;

public class ShootingHandler extends GameLogicHandler {

    private float cooldown;

    public Void shootingKeyPressed(int keycode) {
        if (cooldown != 0f) {
            return null;
        }

        switch (keycode) {
            case UP:

                break;
            case LEFT:

                break;
            case DOWN:

                break;
            case RIGHT:

                break;
        }
        return null;
    }

    public void update(float delta) {
        cooldown = Math.max(0f, cooldown - delta);
    }
}