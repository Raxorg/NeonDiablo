package com.epicness.neondiablo.game.stuff;

import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.epicness.fundamentals.SharedConstants.CAMERA_HALF_WIDTH;
import static com.epicness.neondiablo.game.GameConstants.CELL_SIZE;
import static com.epicness.neondiablo.game.GameConstants.GRID_COLUMNS;
import static com.epicness.neondiablo.game.GameConstants.GRID_ROWS;
import static com.epicness.neondiablo.game.GameConstants.GRID_WIDTH;

import com.epicness.fundamentals.stuff.Stuff;
import com.epicness.fundamentals.stuff.grid.Grid;
import com.epicness.neondiablo.game.assets.GameAssets;

public class GameStuff extends Stuff<GameAssets> {

    private Grid grid;
    private Player player;

    @Override
    public void initializeStuff() {
        grid = new Grid(GRID_COLUMNS, GRID_ROWS, assets.getSquare());
        grid.setCellSize(CELL_SIZE);
        grid.translate(CAMERA_HALF_WIDTH - GRID_WIDTH / 2f, 0f);
        grid.setColor(BLACK);

        player = new Player();
    }

    public Grid getGrid() {
        return grid;
    }

    public Player getPlayer() {
        return player;
    }
}