import org.code.theater.*;
import org.code.media.*;

/**
 * Extends ImagePlus to provide image filtering 
 */
public class FilterImage extends ImagePlus {

  /**
   * Constructor for FilterImage
   * filename - The name of the image file to be loaded
   */
  public FilterImage(String filename) {
    super(filename);
  }

  /**
   * Creates a border around the image with specified colors
   * rowColor - Color for the top and bottom borders
   * colColor - Color for the left and right borders
   */
  public void createBorder(Color rowColor, Color colColor) {
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        // Set top and bottom borders
        if (row < 10 || row > pixels.length - 10) {
          pixels[row][col].setColor(rowColor);
        } 
        // Set left and right borders
        else if (col < 10 || col > pixels[row].length - 10) {
          pixels[row][col].setColor(colColor);
        }
      }
    }
  }

  /**
   * Applies a fade effect to the image
   * amount - The intensity of the fade effect
   */
  public void fade(int amount) {
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        // Adjust RGB values for each pixel
        int red = pixels[row][col].getRed() + amount;
        int green = pixels[row][col].getGreen() + amount;
        int blue = pixels[row][col].getBlue() + amount;

        // Set new RGB values
        pixels[row][col].setRed(red);
        pixels[row][col].setGreen(green);
        pixels[row][col].setBlue(blue);
      }
    }
  }

  /**
   * I tried creating a "blur" effect to the image
   */
  public void blur() {
    Pixel[][] pixels = getImagePixels();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        // Set a random blue value for each pixel
        int total = (int) (Math.random() * 255); 
        pixels[row][col].setBlue(total);
      }
    }
  }

}
