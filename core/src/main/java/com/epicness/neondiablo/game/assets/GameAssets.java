package com.epicness.neondiablo.game.assets;

import static com.badlogic.gdx.graphics.Texture.TextureFilter.Linear;
import static com.epicness.neondiablo.game.assets.GameAssetPaths.EVIL_LAUGH;
import static com.epicness.neondiablo.game.assets.GameAssetPaths.SQUARE;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.assets.Assets;

public class GameAssets extends Assets {

    // Audio
    private Sound evilLaugh;
    // Sprites
    private Sprite square;

    @Override
    public void queueAssetLoading() {
        loadSound(EVIL_LAUGH);
        loadTexture(SQUARE);
    }

    @Override
    protected void initializeAssets() {
        evilLaugh = getSound(EVIL_LAUGH);
        square = getSprite(SQUARE, Linear);
    }

    public Sound getEvilLaugh() {
        return evilLaugh;
    }

    public Sprite getSquare() {
        return square;
    }
}