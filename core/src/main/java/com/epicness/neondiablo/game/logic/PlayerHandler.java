package com.epicness.neondiablo.game.logic;

import static com.badlogic.gdx.graphics.Color.WHITE;

import com.epicness.fundamentals.stuff.grid.Cell;

public class PlayerHandler extends GameLogicHandler {

    @Override
    protected void init() {
        Cell startingCell = stuff.getGrid().getCells()[0][0];
        stuff.getPlayer().setCell(startingCell);
        startingCell.setColor(WHITE);
    }
}