package com.epicness.neondiablo.game.logic;

import com.epicness.fundamentals.logic.Logic;

public class GameLogic extends Logic {

    private final MovementHandler movementHandler;

    public GameLogic() {
        super();
        registerHandler(new GameInputHandler());
        registerHandler(movementHandler = new MovementHandler());
        registerHandler(new PlayerHandler());
        registerHandler(new VisionHandler());
    }

    @Override
    public void update(float delta) {
        movementHandler.update(delta);
    }
}