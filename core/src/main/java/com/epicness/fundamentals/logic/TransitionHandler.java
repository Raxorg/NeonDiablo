package com.epicness.fundamentals.logic;

import com.epicness.fundamentals.SharedResources;
import com.epicness.fundamentals.assets.Assets;
import com.epicness.fundamentals.initializer.Initializer;

import java.util.ArrayList;
import java.util.List;

public class TransitionHandler {

    // Structure
    private SharedResources sharedResources;
    private Initializer<?, ?, ?> nextInitializer;
    private SharedLogic logic;
    // Logic
    private boolean transitionAllowed;

    public void startTransition(CompletionListener completionListener, Initializer<?, ?, ?>... initializers) {
        nextInitializer = sharedResources.findInitializer(initializers[0]);
        List<Assets> assetsList = new ArrayList<>();
        for (int i = 0; i < initializers.length; i++) {
            Initializer<?, ?, ?> initializer = sharedResources.findInitializer(initializers[i]);
            assetsList.add(initializer.getAssets());
        }
        logic.getAssetLoader().beginLoading(assetsList, completionListener);
    }

    public void update() {
        logic.getAssetLoader().update();
        if (transitionAllowed) {
            showNewScreen();
            transitionAllowed = false;
        }
    }

    public void allowTransition() {
        transitionAllowed = true;
    }

    private void showNewScreen() {
        if (nextInitializer.wasInitialized()) {
            nextInitializer.fastInitialize(sharedResources);
            return;
        }
        nextInitializer.initialize(sharedResources);
        nextInitializer.initialized();
    }

    public void setSharedResources(SharedResources sharedResources) {
        this.sharedResources = sharedResources;
        logic = sharedResources.getLogic();
    }

    public void setLogic(SharedLogic logic) {
        this.logic = logic;
    }
}