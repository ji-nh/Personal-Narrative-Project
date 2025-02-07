import org.code.theater.*;
import org.code.media.*;

/**
 * This class is responsible for setting up and running the scenes
 * that showcases various musical instruments.
 */
public class TheaterRunner {
  public static void main(String[] args) {

    // 2D array to store for images and sounds
    String[][] mediaFiles = {
      {"piano.jpg", "piano.wav"},
      {"drums.jpg", "drums.wav"},
      {"violin.jpg", "violin.wav"},
      {"guitar.jpg", "guitar.wav"}
    };

    // 2D array to store descriptions and names of instruments
    String[][] descriptions = {
      {"I practiced piano for two years", "Piano"},
      {"I practiced drums for a year", "Drums"},
      {"I practiced violin for two months", "Violin"},
      {"I practiced guitar for a year", "Guitar"}
    };

    // new MyStory object with media files and descriptions
    MyStory scene = new MyStory(mediaFiles, descriptions);

    // Draw the scene
    scene.drawScene();

    // Play the scenes using the Theater class
    Theater.playScenes(scene);
  }
}
