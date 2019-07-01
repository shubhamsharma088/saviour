package org.saviour.utils;

import org.saviour.model.Enemy;

public class MatrixUtils {

  public static char[][] getInputAsMatrix(char[] inputArr, int totalRows, int totalColumn) {
    char matrix[][] = new char[totalRows][totalColumn];
    int inputStringLength = inputArr.length;
    int readerIndex = 0;
    for (int row = 0; row < totalRows; row++) {
      for (int col = 0; col < totalColumn; col++) {
        if (readerIndex < inputStringLength && inputArr[readerIndex] != '\n') {
          matrix[row][col] = inputArr[readerIndex];
        } else if (readerIndex < inputStringLength && inputArr[readerIndex] == '\n') {
          while (col < totalColumn) {
            matrix[row][col] = ' ';
            col++;
          }
          if (row < (totalRows - 1)) {
            row++;
            col = -1;
          }
        }
        readerIndex++;
      }
      readerIndex++;
    }
    return matrix;
  }

  public static void printMatrix(char[][] matrix) {
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[0].length; col++) {
        System.out.print(matrix[row][col]);
      }
      System.out.println();
    }
  }

  public static void printSubMatrix(char[][] matrix, int rowStartIndex, int colStartIndex,
      int rowEndIndex, int colEndIndex) {

    System.out.println(
        String.format("(%s,%s)=>(%s,%s)", rowStartIndex, colStartIndex, rowEndIndex, colEndIndex));

    for (int row = rowStartIndex; row < rowEndIndex; row++) {
      for (int col = colStartIndex; col < colEndIndex; col++) {
        System.out.println(matrix[row][col]);
      }
      System.out.println();
    }
  }

  public static void printEnemyEntity(char data[][], Enemy entity) {
    int rowStart, colStart, rowEnd, colEnd;

    if (data != null && entity != null) {
      rowStart = entity.getStartCoordinates().getRow();
      colStart = entity.getStartCoordinates().getColumn();
      rowEnd = entity.getEndCoordinates().getRow();
      colEnd = entity.getEndCoordinates().getColumn();

      for (int row = rowStart; row < rowEnd; row++) {
        for (int col = colStart; col < colEnd; col++) {
          System.out.print(data[row][col]);
        }
        System.out.println();
      }
    }
  }

  public static int rows(String inputString) {
    return (int) inputString.chars().filter(ch -> ch == '\n').count();
  }
}
