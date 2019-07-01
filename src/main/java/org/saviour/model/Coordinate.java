package org.saviour.model;

public class Coordinate {

  private int row;
  private int column;

  public Coordinate() {
  }

  public Coordinate(int row, int column) {
    this.row = row;
    this.column = column;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getColumn() {
    return column;
  }

  public void setColumn(int column) {
    this.column = column;
  }

  @Override
  public String toString() {
    return String.format("(%s,%s)", this.row, this.column);
  }
}
