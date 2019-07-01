package org.saviour;

import java.io.IOException;

import static org.saviour.utils.MatrixUtils.*;

import java.net.URISyntaxException;
import java.util.List;
import org.saviour.model.Enemy;
import org.saviour.utils.SAVIOURCONSTANT;

import static org.saviour.utils.SaviourUtils.*;
import static org.saviour.utils.FileUtils.*;

public class Application {

  public static void main(String[] args) {

    try {
      String rawDataString = getFileAsString("TestData.snw");
      String torpedoString = getFileAsString("HPTorpedo.snw");
      String hpShipString = getFileAsString("HPShip.snw");

      char rawDataMatrix[][] = getInputAsMatrix(rawDataString.toCharArray(), 100, 100);
      char torpedoMatrix[][] = getInputAsMatrix(torpedoString.toCharArray(), rows(torpedoString),
          10);
      char hpShipMatrix[][] = getInputAsMatrix(hpShipString.toCharArray(), rows(hpShipString),
          14);

      printMatrix(hpShipMatrix);
      List<Enemy> topHpShips = scanDataForEnemies(rawDataMatrix, torpedoMatrix, 0.0,
          SAVIOURCONSTANT.HPSHIP);
      printEnemies(getTopEnemies(removeOverlaps(topHpShips), 5), rawDataMatrix);

      printMatrix(torpedoMatrix);
      List<Enemy> topTorpedos = scanDataForEnemies(rawDataMatrix, torpedoMatrix, 0.0,
          SAVIOURCONSTANT.TORPEDO);
      printEnemies(getTopEnemies(removeOverlaps(topTorpedos), 5), rawDataMatrix);
    } catch (IOException | URISyntaxException e) {
      e.printStackTrace();
    }

  }
}
