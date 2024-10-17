
/*
 * Created on 2025-02-20
 *
 * Copyright (c) 2025 Nadine von Frankenberg
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class SnowflakeStudio {
    public static void main(String[] args) {
        String inputPath = "penguin.png";
        String outputPath = "penguin_in_snow.png";

        try {
            // First, we need to load the image
            BufferedImage originalImage = ImageIO.read(new File(inputPath));
            System.out.println("Image loaded successfully.");

            // TODO Task 1a: Convert image to 3D array: implement ImageProcessor.imageToArray
            // pixelArray = ... ;

            // TODO Task 1b: Change bow color from green to a new color
            // Define a newBowColor

            // ImageProcessor.changeBowColor(pixelArray, newBowColor);
            // System.out.println("Bow color changed: " + Arrays.toString(newBowColor));

            // Add snowflakes
            // TODO Task 2: uncomment to run!
            // int numberOfSnowflakes = 100;
            // SnowEffect.addSnowflakes(pixelArray, numberOfSnowflakes);
            // System.out.println(numberOfSnowflakes + " snowflakes added.");

            // Convert back to image
            BufferedImage modifiedImage = ImageProcessor.arrayToImage(pixelArray);

            // Save the modified image
            ImageIO.write(modifiedImage, "png", new File(outputPath));
            System.out.println("Modified image saved as: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error processing the image: " + e.getMessage());
        }
    }
}
