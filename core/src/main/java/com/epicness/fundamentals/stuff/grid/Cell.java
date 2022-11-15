package com.epicness.fundamentals.stuff.grid;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.epicness.fundamentals.stuff.Sprited;

import java.util.HashMap;

public class Cell extends Sprited {

    public final int column, row;
    public final HashMap<String, Object> properties;

    public Cell(Sprite cellSprite, int column, int row) {
        super(cellSprite);
        this.column = column;
        this.row = row;
        properties = new HashMap<>();
    }

    public void setProperty(String key, Object property) {
        properties.put(key, property);
    }

    @SuppressWarnings("unchecked")
    public <T> T getProperty(String key) {
        return (T) properties.get(key);
    }
}