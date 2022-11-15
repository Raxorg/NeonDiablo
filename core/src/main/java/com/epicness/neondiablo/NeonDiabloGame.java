package com.epicness.neondiablo;

import com.badlogic.gdx.Game;
import com.epicness.fundamentals.SharedResources;
import com.epicness.neondiablo.game.GameInitializer;
import com.epicness.neondiablo.game.assets.GameAssets;

public class NeonDiabloGame extends Game {

    @Override
    public void create() {
        GameAssets assets = new GameAssets();
        assets.queueAssetLoading();
        assets.finishLoading();
        assets.initAssets();
        new GameInitializer(assets).initialize(new SharedResources());
    }
}