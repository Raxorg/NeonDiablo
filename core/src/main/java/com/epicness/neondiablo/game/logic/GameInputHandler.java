package com.epicness.neondiablo.game.logic;

import com.badlogic.gdx.Input;
import com.epicness.fundamentals.input.InputHandler;
import com.epicness.neondiablo.game.stuff.GameStuff;

import java.util.HashSet;
import java.util.Set;

public class GameInputHandler extends InputHandler<GameLogic, GameStuff> {

    private Set<Integer> movementKeys, shootingKeys;

    @Override
    public void init() {
        super.init();
        movementKeys = new HashSet<>();
        movementKeys.add(Input.Keys.W);
        movementKeys.add(Input.Keys.A);
        movementKeys.add(Input.Keys.S);
        movementKeys.add(Input.Keys.D);
        shootingKeys = new HashSet<>();
        shootingKeys.add(Input.Keys.UP);
        shootingKeys.add(Input.Keys.LEFT);
        shootingKeys.add(Input.Keys.DOWN);
        shootingKeys.add(Input.Keys.RIGHT);
    }

    @Override
    public void keyDown(int keycode) {
        if (movementKeys.contains(keycode)) logic.get(MovementHandler.class).movementKeyPressed(keycode);
        if (shootingKeys.contains(keycode)) logic.get(ShootingHandler.class).shootingKeyPressed(keycode);
    }

    @Override
    public void keyUp(int keycode) {
        if (movementKeys.contains(keycode)) logic.get(MovementHandler.class).movementKeyReleased(keycode);
    }
}