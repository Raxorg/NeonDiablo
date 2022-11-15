package com.epicness.neondiablo.game.logic;

import static com.badlogic.gdx.Input.Keys.A;
import static com.badlogic.gdx.Input.Keys.D;
import static com.badlogic.gdx.Input.Keys.S;
import static com.badlogic.gdx.Input.Keys.W;
import static com.badlogic.gdx.graphics.Color.BLACK;
import static com.badlogic.gdx.graphics.Color.CLEAR;
import static com.badlogic.gdx.graphics.Color.DARK_GRAY;
import static com.badlogic.gdx.graphics.Color.WHITE;
import static com.epicness.neondiablo.game.GameConstants.GRID_COLUMNS;
import static com.epicness.neondiablo.game.GameConstants.GRID_ROWS;
import static com.epicness.neondiablo.game.GameConstants.SQUARES_PER_SECOND;
import static com.epicness.neondiablo.game.GameConstants.VISION_RADIUS;

import com.badlogic.gdx.math.MathUtils;
import com.epicness.fundamentals.stuff.grid.Cell;
import com.epicness.neondiablo.game.stuff.Player;

public class MovementHandler extends GameLogicHandler {

    private float vSpeed, hSpeed;
    private float accumulator;

    public void movementKeyPressed(int keycode) {
        Player player = stuff.getPlayer();
        int column = player.getCell().column;
        int row = player.getCell().row;
        switch (keycode) {
            case W:
                move(column, row, 0, 1);
                vSpeed += SQUARES_PER_SECOND;
                break;
            case A:
                move(column, row, -1, 0);
                hSpeed -= SQUARES_PER_SECOND;
                break;
            case S:
                move(column, row, 0, -1);
                vSpeed -= SQUARES_PER_SECOND;
                break;
            case D:
                move(column, row, 1, 0);
                hSpeed += SQUARES_PER_SECOND;
                break;
        }
    }

    public void movementKeyReleased(int keycode) {
        switch (keycode) {
            case W:
                vSpeed -= SQUARES_PER_SECOND;
                break;
            case A:
                hSpeed += SQUARES_PER_SECOND;
                break;
            case S:
                vSpeed += SQUARES_PER_SECOND;
                break;
            case D:
                hSpeed -= SQUARES_PER_SECOND;
                break;
        }
    }

    public void update(float delta) {
        accumulator += Math.max(Math.abs(vSpeed), Math.abs(hSpeed)) * delta;
        if (accumulator < 1f) {
            return;
        }
        // Move
        Player player = stuff.getPlayer();
        int column = player.getCell().column;
        int row = player.getCell().row;
        // Vertical
        if (vSpeed > 0f) {
            move(column, row, 0, 1);
        } else if (vSpeed < 0f) {
            move(column, row, 0, -1);
        }
        column = player.getCell().column;
        row = player.getCell().row;
        // Horizontal
        if (hSpeed > 0f) {
            move(column, row, 1, 0);
        } else if (hSpeed < 0f) {
            move(column, row, -1, 0);
        }
    }

    private boolean outOfBounds(int column, int row) {
        return column < 0 || row < 0 || column >= GRID_COLUMNS || row >= GRID_ROWS;
    }

    private void move(int column, int row, int columnOffset, int rowOffset) {
        if (outOfBounds(column + columnOffset, row + rowOffset)) {
            return;
        }
        colorArea(column, row);
        colorVision(column + columnOffset, row + rowOffset);
        Cell cell = stuff.getGrid().getCells()[column + columnOffset][row + rowOffset];
        stuff.getPlayer().setCell(cell);
        cell.setColor(WHITE);
        accumulator = 0f;
        logic.get(VisionHandler.class).updateVision(column, row, column + columnOffset, row + rowOffset);
    }

    private void colorArea(int column, int row) {
        Cell[][] cells = stuff.getGrid().getCells();
        for (int c = column - VISION_RADIUS; c <= column + VISION_RADIUS; c++) {
            for (int r = row - VISION_RADIUS; r <= row + VISION_RADIUS; r++) {
                if (outOfBounds(c, r)) {
                    continue;
                }
                cells[c][r].setColor(BLACK);
            }
        }
    }

    private void colorVision(int column, int row) {
        Cell[][] cells = stuff.getGrid().getCells();
        for (int c = column - VISION_RADIUS; c <= column + VISION_RADIUS; c++) {
            for (int r = row - VISION_RADIUS; r <= row + VISION_RADIUS; r++) {
                if (outOfBounds(c, r)) {
                    continue;
                }
                int distance = Math.abs(c - column) + Math.abs(r - row);
                float progress = MathUtils.map(0, 8, 0, 1f, distance);
                cells[c][r].setColor(DARK_GRAY.cpy().lerp(CLEAR, progress));
            }
        }
    }
}