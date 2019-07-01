package org.saviour.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixUtilsTest {

  @Test
  public void getInputAsMatrix() {
    char[] inputString = {'+', '+', '\n', ' ', '+', '\n', '+', '+', '+'};
    char[][] expectedMatrix = {{'+', '+', ' '}, {' ', '+', ' '}, {'+', '+', '+'}};
    char[][] output = MatrixUtils.getInputAsMatrix(inputString, 3, 3);
    assertEquals(expectedMatrix, output);
  }

  @Test
  public void rows() {
    String input = "Some \n input\n string to be\n tested";
    int output = MatrixUtils.rows(input);
    assertEquals(output,3);
  }
}