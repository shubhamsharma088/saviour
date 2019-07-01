package org.saviour.model;

public class Torpedo extends Enemy {

  public Torpedo() {
  }

  public Torpedo(Coordinate startCoordinates, Coordinate endCoordinates, double accuracy) {
    super(startCoordinates, endCoordinates, accuracy);
  }

  public Torpedo(Coordinate startCoordinates, Coordinate endCoordinates) {
    super(startCoordinates, endCoordinates);
  }
}
