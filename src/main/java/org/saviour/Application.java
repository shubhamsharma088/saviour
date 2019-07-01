package org.saviour;

import java.io.IOException;

import static org.saviour.utils.MatrixUtils.*;

import java.util.List;
import org.saviour.model.Enemy;
import org.saviour.model.Torpedo;

import static org.saviour.utils.SaviourUtils.*;

public class Application {

  public static void main(String[] args) {
    String basePath = "C:\\Users\\Shubham\\IdeaProjects\\saviour\\src\\main\\resources";
    String rawDataFilePath = String.format("%s\\TestData.snw", basePath);
    String torpedoFilePath = String.format("%s\\HPTorpedo.snw", basePath);
    String hpShipStringPath = String.format("%s\\HPShip.snw", basePath);

    try {
      String rawDataString = getFileInputString(rawDataFilePath);
      String torpedoString = getFileInputString(torpedoFilePath);
      String hpShipString = getFileInputString(hpShipStringPath);

      char rawDataMatrix[][] = getInputAsMatrix(rawDataString.toCharArray(), 100, 100);
      char torpedoMatrix[][] = getInputAsMatrix(torpedoString.toCharArray(), rows(torpedoString),
          10);
      char hpShipMatrix[][] = getInputAsMatrix(hpShipString.toCharArray(), rows(hpShipString),
          14);
      /*printMatrix(rawDataMatrix);
      printMatrix(torpedoMatrix);
      printMatrix(hpShipMatrix);*/

      List<Enemy> topTorpedos = scanDataForEnemies(rawDataMatrix, torpedoMatrix, 0.0);
      printEnemies(getTopEnemies(removeOverlaps(topTorpedos),3),rawDataMatrix);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
