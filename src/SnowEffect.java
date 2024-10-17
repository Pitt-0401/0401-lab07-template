/*
 * Created on 2025-02-20
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

import java.util.Random;

public class SnowEffect {

    /**
     * Adds random snowflakes (white dots) to the image background.
     * 
     * @param pixelArray         The 3D pixel array representing the image.
     * @param numberOfSnowflakes The number of snowflakes to add.
     */
    public static void addSnowflakes(int[][][] pixelArray, int numberOfSnowflakes) {
        Random random = new Random();
        int height = pixelArray.length;
        int width = pixelArray[0].length;

        for (int i = 0; i < numberOfSnowflakes; i++) {
            int x = random.nextInt(width - 40) + 20; // Random X position
            int y = random.nextInt(height - 40) + 20; // Random Y position
            int size = random.nextInt(10) + 10; // Random snowflake size between 10-20
            int thickness = Math.max(2, size / 10); // Adjust thickness based on size

            // TODO: Only place snowflakes on bright background pixels (avoid dark penguin pixels)
            
        }
    }

    /**
     * Draws a snowflake by modifying the 3D pixel array.
     * 
     * @param pixelArray The 3D pixel array.
     * @param x          x-coordinate of the snowflake.
     * @param y          y-coordinate of the snowflake.
     * @param size       Size of the snowflake.
     */
    private static void drawSnowflake(int[][][] pixelArray, int x, int y, int size, int thickness) {
        int[] colorRGB = { 255, 255, 255 }; // White color for snowflakes
        int diagonalSize = size / 2; // Make diagonals shorter than horizontal & vertical

        // Draw horizontal and vertical lines
        for (int i = -size; i <= size; i++) {
            drawPixel(pixelArray, y, x + i, thickness, colorRGB); // Horizontal
            drawPixel(pixelArray, y + i, x, thickness, colorRGB); // Vertical
        }

        // Draw shorter diagonal lines
        for (int i = -diagonalSize; i <= diagonalSize; i++) {
            drawPixel(pixelArray, y + i, x + i, thickness, colorRGB); // Diagonal 1
            drawPixel(pixelArray, y + i, x - i, thickness, colorRGB); // Diagonal 2
        }
    }

    /**
     * Draws a thicker pixel by filling a small square around it.
     * 
     * @param pixelArray The 3D pixel array.
     * @param y          The row index.
     * @param x          The column index.
     * @param thickness  The size of the stroke.
     * @param color      The RGB color array.
     */
    private static void drawPixel(int[][][] pixelArray, int y, int x, int thickness, int[] color) {
        for (int dy = -thickness / 2; dy <= thickness / 2; dy++) {
            for (int dx = -thickness / 2; dx <= thickness / 2; dx++) {
                if (isWithinBounds(pixelArray, y + dy, x + dx)) {
                    pixelArray[y + dy][x + dx] = color;
                }
            }
        }
    }

    /**
     * Checks if the given coordinates are within image bounds.
     * 
     * @param pixelArray The 3D pixel array.
     * @param y          The row index.
     * @param x          The column index.
     * @return True if within bounds, otherwise false.
     */
    private static boolean isWithinBounds(int[][][] pixelArray, int y, int x) {
        return y >= 0 && y < pixelArray.length && x >= 0 && x < pixelArray[0].length;
    }

    /**
     * Checks if the given pixel belongs to the penguin (non-bright colors).
     * 
     * @param pixel The RGB color array.
     * @return True if the pixel is dark (part of the penguin), false otherwise.
     */
    private static boolean isPenguinPixel(int[] pixel) {
        int brightness = (pixel[0] + pixel[1] + pixel[2]) / 3; // Calculate brightness
        return brightness < 200; // Background is between RGB 200-255 (avg.)

    }

    /**
     * Checks if the given pixel is in snow (bright colors).
     * 
     * @param pixel The RGB color array.
     * @return True if the pixel is bright (part of snow), false otherwise.
     */
    private static boolean isSnowPixel(int[] pixel) {
        int brightness = (pixel[0] + pixel[1] + pixel[2]) / 3; // Calculate brightness
        return brightness > 250; // White color indicates snow
    }
}
