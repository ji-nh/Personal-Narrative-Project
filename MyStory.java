import org.code.theater.*;
import org.code.media.*;

/**
 * This class extends Scene and is responsible for creating and managing
 * a scene that displays various musical instruments with effects.
 */
public class MyStory extends Scene {

  private String[][] mediaFiles;
  private String[][] descriptions;

  /**
   * Constructor for MyStory
   * mediaFiles - 2D array containing image and sound files
   * descriptions - 2D array containing instrument descriptions and names
   */
  public MyStory(String[][] mediaFiles, String[][] descriptions) {
    this.mediaFiles = mediaFiles;
    this.descriptions = descriptions;
  }

  /**
   * Displays an instrument with various visual effects and sound
   * index - The index of the instrument in the mediaFiles and descriptions arrays
   * Note - Images might be a bit too big.  
   */
  private void displayInstrument(int index) {
    // Create a FilterImage object for the instrument
    FilterImage instrument = new FilterImage(mediaFiles[index][0]);
    String txt = descriptions[index][0];
    String instrumentName = descriptions[index][1];
    playSound(mediaFiles[index][1]); 

    // Initial display of the instrument
    drawImage(instrument, 0, 0, 700);
    drawText(txt, 10, 355);
    drawText(instrumentName, 10, 50);
    pause(3);

    // Apply fade effect
    instrument.fade(-30);
    drawImage(instrument, 0, 0, 700);
    pause(2);

    // Apply blur effect
    instrument.blur();
    drawImage(instrument, 0, 0, 700);
    pause(2);

    // Apply border effect
    Color rowColor = new Color(55, 90, 150); 
    instrument.createBorder(rowColor, Color.GREEN);
    drawImage(instrument, 0, 0, getWidth(), getHeight(), 0);
    pause(2);
  }

  /**
   * Draws the entire scene by displaying each instrument
   */
  public void drawScene() {
    for (int i = 0; i < mediaFiles.length; i++) {
      displayInstrument(i);
    }
  }
}
