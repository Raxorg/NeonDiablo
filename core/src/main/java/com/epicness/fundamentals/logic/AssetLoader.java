package com.epicness.fundamentals.logic;

import com.epicness.fundamentals.assets.Assets;

import java.util.List;

public class AssetLoader {

    // Logic
    private List<Assets> assetsList;
    private CompletionListener listener;

    protected void beginLoading(List<Assets> assetsToLoad, CompletionListener completionListener) {
        assetsList = assetsToLoad;
        for (int i = 0; i < assetsList.size(); i++) {
            if (assetsList.get(i).areAssetsInitialized()) continue;
            assetsList.get(i).queueAssetLoading();
        }
        listener = completionListener;
    }

    protected void update() {
        if (assetsList == null) {
            return;
        }
        for (int i = 0; i < assetsList.size(); i++) {
            Assets assets = assetsList.get(i);
            if (assets.areAssetsInitialized()) {
                continue;
            }
            if (assets.loadAssets()) {
                assets.initAssets();
            }
            return;
        }
        assetsList = null;
        listener.onComplete();
    }
}