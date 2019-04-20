package javaFundaments.bitMapsAndTransforms;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class bitTransform {
    private int[][] px;
    private BufferedImage image;

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("To execute this file please have three arguements");
            System.out.println("Target image of bmp file type, javaFundaments.bitMapsAndTransforms.exampleTransforms directory, and transform type");
            System.out.println("ex. java bitTransfrom <targetFile> <outputDirectory> <transform>");
            System.out.println("Availble transforms: invert, degrade, negative, grayscale, yellowed, deconstruct, swapXXX. shuffleXXX, and suite");
            return;
        }

        bitTransform image = null;
        try {
            image = readBMPImage(args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (args[2].equals("invert")) {
            System.out.println("Transform selected: color inversion");
            image.invert();
        } else if (args[2].equals("degrade")) {
            System.out.println("Transform selected: image degrade");
            image.degrade();
        } else if (args[2].equals("negative")) {
            System.out.println("Transform selected: image negative");
            image.negative();
        } else if (args[2].equals("grayscale")) {
            System.out.println("Transform selected: image grayscale");
            image.grayscale();
        } else if (args[2].equals("deconstruct")) {
            System.out.println("Transform selected: image deconstruct");
            image.deconstruct();
        } else if (args[2].equals("highContrast")) {
            System.out.println("Transform selected: high Contrast");
            image.highContrast();
        } else if (args[2].equals("swapRBG")) {
            System.out.println("Transform selected: Swapping Blue Green");
            image.swapRBG();
        } else if (args[2].equals("swapBGR")) {
            System.out.println("Transform selected: Swapping Red Blue");
            image.swapBGR();
        } else if (args[2].equals("swapGRB")) {
            System.out.println("Transform selected: Swapping Red Green");
            image.swapGRB();
        } else if (args[2].equals("shuffleGBR")) {
            System.out.println("Transform selected: Shuffling to Green, Blue, Red");
            image.shuffleGBR();
        } else if (args[2].equals("shuffleBRG")) {
            System.out.println("Transform selected: Shuffling to Blue, Red, Green");
            image.shuffleBRG();
        } else if (args[2].equals("suite")) {
            System.out.println("Running the suite...");
            try {
                suite(image, args[1], args[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            image.writeImageFile(args[1]);
        } catch (
                IOException e) {
            e.printStackTrace();
        }

    }

    public static void suite(bitTransform image, String filepath, String file) throws IOException {
        image = readBMPImage(file);
        image.invert();
        image.writeImageFile(filepath + "Inverted");

        image = readBMPImage(file);
        image.degrade();
        image.writeImageFile(filepath + "Degraded");

        image = readBMPImage(file);
        image.negative();
        image.writeImageFile(filepath + "Negative");

        image = readBMPImage(file);
        image.grayscale();
        image.writeImageFile(filepath + "Grayscale");

        image = readBMPImage(file);
        image.deconstruct();
        image.writeImageFile(filepath + "Deconstruct");

        image = readBMPImage(file);
        image.swapRBG();
        image.writeImageFile(filepath + "RBG");

        image = readBMPImage(file);
        image.swapBGR();
        image.writeImageFile(filepath + "BGR");

        image = readBMPImage(file);
        image.swapGRB();
        image.writeImageFile(filepath + "GRB");

        image = readBMPImage(file);
        image.shuffleBRG();
        image.writeImageFile(filepath + "BRG");

        image = readBMPImage(file);
        image.shuffleGBR();
        image.writeImageFile(filepath + "GBR");


    }

    public static bitTransform readBMPImage(String filepath) throws IOException {
        bitTransform output = null;
        output = new bitTransform(filepath);
        return output;
    }

    public void writeImageFile(String filePath) throws IOException {
        File targetFile = new File(filePath);
        targetFile.createNewFile();
        ImageIO.write(image, "bmp", targetFile);
        System.out.println("Image written to " + filePath);
    }

    public bitTransform(String filePath) throws IOException {
        image = ImageIO.read(new File(filePath));
        px = new int[image.getWidth()][image.getHeight()];

        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                px[x][y] = image.getRGB(x, y);
            }
        }
        if (image != null) {
            System.out.println(filePath + "  Image written");
        }
    }

    //I wanted to see how RGB was stored in px
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (Integer column : row) {
                System.out.println(column);
            }
        }
    }

    //transforms
    public void highContrast() {
        int contrast = 128;
        int factor = (259 * (contrast + 255)) / (255 * (259 - contrast));
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column);
                Color c = new Color(color);
                int red = (factor * c.getRed() - 128) + 128;
                int green = (factor * c.getGreen() - 128) + 128;
                int blue = (factor * c.getBlue() - 128) + 128;
                red = red > 255 ? 255 : red;
                green = green > 255 ? 255 : green;
                blue = blue > 255 ? 255 : blue;

                Color highConstrast = new Color(red, green, blue);
                image.setRGB(row, column, highConstrast.getRGB());
            }
        }
        System.out.println("Image contrast increased");
    }

    public void invert() {
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column) ^ Color.WHITE.getBlue();
                image.setRGB(row, column, color);
            }
        }
        System.out.println("Image inverted");
    }

    public void degrade() {
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column) / 2;
                image.setRGB(row, column, color);
            }
        }
        System.out.println("Image degraded");
    }

    public void negative() {
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column) ^ -2;
                image.setRGB(row, column, color);
            }
        }
        System.out.println("Image negated");
    }

    public void grayscale() {
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column);
                Color c = new Color(color);
                int average = (c.getRed() + c.getBlue() + c.getGreen()) / 3;
                Color gray = new Color(average, average, average);
                image.setRGB(row, column, gray.getRGB());
            }
        }
        System.out.println("Image grayed");
    }

    public void swapRBG() {
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column);
                Color c = new Color(color);
                Color shuffle = new Color(c.getRed(), c.getBlue(), c.getGreen());

                image.setRGB(row, column, shuffle.getRGB());

            }
        }
        System.out.println("Image colors swapped: Blue and Green");
    }

    public void swapBGR() {
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column);
                Color c = new Color(color);
                Color shuffle = new Color(c.getBlue(), c.getGreen(), c.getRed());

                image.setRGB(row, column, shuffle.getRGB());

            }
        }
        System.out.println("Image colors swapped: Blue and Red");
    }

    public void swapGRB() {
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column);
                Color c = new Color(color);
                Color shuffle = new Color(c.getGreen(), c.getRed(), c.getBlue());

                image.setRGB(row, column, shuffle.getRGB());

            }
        }
        System.out.println("Image colors swapped: Red and Green");
    }


    public void shuffleGBR() {
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column);
                Color c = new Color(color);
                Color shuffle = new Color(c.getGreen(), c.getBlue(), c.getRed());

                image.setRGB(row, column, shuffle.getRGB());

            }
        }
        System.out.println("Image shuffled GBR;");
    }

    public void shuffleBRG() {
        for (int row = 0; row < image.getWidth(); row++) {
            for (int column = 0; column < image.getHeight(); column++) {
                int color = image.getRGB(row, column);
                Color c = new Color(color);
                Color shuffle = new Color(c.getBlue(), c.getRed(), c.getGreen());

                image.setRGB(row, column, shuffle.getRGB());

            }
        }
        System.out.println("Image shuffled BRG");
    }

    public void deconstruct() {
        for (int row = 0; row < image.getWidth(); row++) {
            int[] organizedRow = new int[image.getHeight()];
            for (int column = 0; column < image.getHeight(); column++) {
                organizedRow[column] = image.getRGB(row, column);
            }
            Arrays.sort(organizedRow);
            for (int column2 = 0; column2 < image.getHeight(); column2++) {
                image.setRGB(row, column2, organizedRow[column2]);
            }
        }
        System.out.println("Image deconstructed");
    }
}

