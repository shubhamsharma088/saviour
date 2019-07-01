package org.saviour.model;

public class Enemy implements Comparable<Enemy> {

  private Coordinate startCoordinates;
  private Coordinate endCoordinates;
  private double accuracy;

  public Enemy() {
  }

  public Enemy(Coordinate startCoordinates, Coordinate endCoordinates, double accuracy) {
    this.startCoordinates = startCoordinates;
    this.endCoordinates = endCoordinates;
    this.accuracy = accuracy;
  }

  public Enemy(Coordinate startCoordinates, Coordinate endCoordinates) {
    this.startCoordinates = startCoordinates;
    this.endCoordinates = endCoordinates;
    this.accuracy = 50.0;
  }

  public Coordinate getStartCoordinates() {
    return startCoordinates;
  }

  public void setStartCoordinates(Coordinate startCoordinates) {
    this.startCoordinates = startCoordinates;
  }

  public Coordinate getEndCoordinates() {
    return endCoordinates;
  }

  public void setEndCoordinates(Coordinate endCoordinates) {
    this.endCoordinates = endCoordinates;
  }

  public double getAccuracy() {
    return accuracy;
  }

  public void setAccuracy(double accuracy) {
    this.accuracy = accuracy;
  }

  public int rowSize() {
    return this.endCoordinates.getRow() - this.startCoordinates.getRow();
  }

  public int columnSize() {
    return this.endCoordinates.getColumn() - this.startCoordinates.getColumn();
  }

  @Override
  public String toString() {
    String res = String
        .format("===== Starts:%s Ends:%s Accuracy:%s =====", this.startCoordinates,
            this.endCoordinates,
            this.accuracy);
    return res;
  }

  @Override
  public int compareTo(Enemy o) {
    if (this.accuracy == o.accuracy) {
      return 0;
    } else {
      return (this.accuracy > o.accuracy ? 1 : -1);
    }
  }
}
