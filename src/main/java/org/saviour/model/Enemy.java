package org.saviour.model;

public class Enemy implements Comparable<Enemy> {

  private Coordinate startCoordinates;
  private Coordinate endCoordinates;
  private double accuracy;
  private String type;

  public Enemy() {
  }

  public Enemy(Coordinate startCoordinates, Coordinate endCoordinates, double accuracy,
      String type) {
    this.startCoordinates = startCoordinates;
    this.endCoordinates = endCoordinates;
    this.accuracy = accuracy;
    this.type = type;
  }

  public Enemy(Coordinate startCoordinates, Coordinate endCoordinates, String type) {
    this.startCoordinates = startCoordinates;
    this.endCoordinates = endCoordinates;
    this.accuracy = 50.0;
    this.type = type;
  }

  public Enemy(Coordinate startCoordinates, double accuracy, String type) {
    this.startCoordinates = startCoordinates;
    this.accuracy = accuracy;
    this.type = type;
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    String res = String
        .format("\n===== %s Starts:%s Ends:%s Accuracy:%s =====\n", this.type,
            this.startCoordinates,
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
