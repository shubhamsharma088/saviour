package org.saviour.utils;

import static java.util.Collections.reverse;
import static java.util.Collections.sort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.saviour.model.Coordinate;
import org.saviour.model.Enemy;

public class SaviourUtils {

  public static String getFileInputString(String path) throws IOException {
    return FileUtils.getFileAsString(path);
  }

  public static List<Enemy> scanDataForEnemies(char data[][], char[][] pattern,
      double desiredAccuracy) {

    List<Enemy> enemyEntities = new ArrayList<>();
    Enemy entity;
    int rowSize = data.length - pattern.length;
    int colSize = data[0].length - pattern[0].length;

    for (int row = 0; row < rowSize; row++) {
      for (int col = 0; col < colSize; col++) {
        entity = populateEnemies(data, pattern, row, col, desiredAccuracy);
        if (null != entity) {
          entity.setEndCoordinates(new Coordinate(row + pattern.length, col + pattern[0].length));
          enemyEntities.add(entity);
        }
      }
    }

    sort(enemyEntities);
    reverse(enemyEntities);

    return enemyEntities;
  }

  private static Enemy populateEnemies(char[][] data, char[][] pattern, int startRow,
      int startColumn,
      double desiredAccuracy) {
    Enemy entity = null;
    double accuracy = percentMatch(data, pattern, startRow, startColumn);

    if (accuracy >= desiredAccuracy) {
      entity = new Enemy();
      entity.setStartCoordinates(new Coordinate(startRow, startColumn));
      entity.setAccuracy(accuracy);
    }
    return entity;
  }

  private static double percentMatch(char[][] data, char[][] pattern, int startRow,
      int startColumn) {
    double count = 0.0, totalComparisons = pattern.length * pattern[0].length;
    for (int row = 0; row < pattern.length; row++) {
      for (int column = 0; column < pattern[0].length; column++) {
        if (pattern[row][column] == data[row + startRow][column + startColumn]) {
          count++;
        }
      }
    }
    return round(count * 100 / totalComparisons, 2);
  }

  private static double round(double value, int decimals) {
    if (decimals < 0) {
      throw new IllegalArgumentException();
    }

    long factor = (long) Math.pow(10, decimals);
    value = value * factor;
    long tmp = Math.round(value);
    return tmp / factor;
  }

  public static List<Enemy> removeOverlaps(List<Enemy> enemyList) {
    List<Enemy> refinedEnemyList = null;
    if (enemyList != null && enemyList.size() > 0) {
      refinedEnemyList = new ArrayList<>();
      refinedEnemyList.add(enemyList.get(0));

      int refinedRowEnd, inputRowStart, inputColStart, refinedColEnd;
      Enemy refinedEnemy, inputEnemy;

      int count = 0;

      for (int i = 0; i < enemyList.size(); i++) {
        refinedEnemy = refinedEnemyList.get(count);
        inputEnemy = enemyList.get(i);
        refinedRowEnd = refinedEnemy.getEndCoordinates().getRow();
        refinedColEnd = refinedEnemy.getEndCoordinates().getColumn();
        inputRowStart = inputEnemy.getStartCoordinates().getRow();
        inputColStart = inputEnemy.getStartCoordinates().getColumn();

        if (inputColStart > refinedColEnd && inputRowStart > refinedRowEnd) {
          refinedEnemyList.add(inputEnemy);
        }
      }
    }
    return refinedEnemyList;
  }

  public static void printEnemies(List<Enemy> enemies, char[][] rawDataMatrix) {
    if (enemies != null && enemies.size() > 0) {
      Iterator<Enemy> itr = enemies.iterator();
      Enemy enemy;
      while (itr.hasNext()) {
        enemy = itr.next();
        System.out.println(enemy);
        MatrixUtils.printEnemyEntity(rawDataMatrix, enemy);
      }
    } else {
      System.out.print("No Torpedo found, try reducing accuracy %age");
    }
  }

  public static List<Enemy> getTopEnemies(List<Enemy> enemies, int number) {
    List<Enemy> shortendList = new ArrayList<>();
    sort(enemies);
    reverse(enemies);
    Iterator<Enemy> itr = enemies.iterator();
    int count = 0;
    while (itr.hasNext() && count < number) {
      shortendList.add(itr.next());
      count++;
    }
    return shortendList;
  }
}
