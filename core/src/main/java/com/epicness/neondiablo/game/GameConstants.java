package com.epicness.neondiablo.game;

import static com.epicness.fundamentals.SharedConstants.CAMERA_HEIGHT;
import static com.epicness.fundamentals.SharedConstants.CAMERA_WIDTH;

public class GameConstants {

    public static final float CELL_SIZE = CAMERA_HEIGHT / 40f;
    public static final int GRID_COLUMNS = (int) (CAMERA_WIDTH / CELL_SIZE);
    public static final int GRID_ROWS = (int) (CAMERA_HEIGHT / CELL_SIZE);
    public static final float GRID_WIDTH = CELL_SIZE * GRID_COLUMNS;
    public static final float SQUARES_PER_SECOND = 7f;
    public static final int VISION_RADIUS = 4;
}