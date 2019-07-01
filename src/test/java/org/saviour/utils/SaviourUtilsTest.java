package org.saviour.utils;

import static org.junit.Assert.*;
import static org.saviour.utils.FileUtils.getFileAsString;
import static org.saviour.utils.MatrixUtils.getInputAsMatrix;
import static org.saviour.utils.MatrixUtils.rows;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.saviour.model.Enemy;

public class SaviourUtilsTest {

  private char rawDataMatrix[][];
  private char torpedoMatrix[][];

  @Before
  public void setUp() throws Exception {
    String rawDataString = getFileAsString("TestData.snw");
    String torpedoString = getFileAsString("HPTorpedo.snw");

    rawDataMatrix = getInputAsMatrix(rawDataString.toCharArray(), 100, 100);
    torpedoMatrix = getInputAsMatrix(torpedoString.toCharArray(), rows(torpedoString),
        10);
  }

  @After
  public void tearDown() throws Exception {
    rawDataMatrix = null;
    torpedoMatrix = null;
  }

  @Test
  public void scanDataForEnemies() {
    List<Enemy> topTorpedos = SaviourUtils
        .scanDataForEnemies(rawDataMatrix, torpedoMatrix, 50.0, "HPTorpedo");
    assertNotNull(topTorpedos);
  }
}