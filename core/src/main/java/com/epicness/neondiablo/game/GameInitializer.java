package com.epicness.neondiablo.game;

import com.epicness.fundamentals.initializer.Initializer;
import com.epicness.neondiablo.game.assets.GameAssets;
import com.epicness.neondiablo.game.logic.GameLogic;
import com.epicness.neondiablo.game.stuff.GameStuff;

public class GameInitializer extends Initializer<GameAssets, GameRenderer, GameStuff> {

    public GameInitializer(GameAssets assets) {
        super(assets, new GameLogic(), new GameRenderer(), new GameStuff());
    }
}