package org.saviour.model;

public class HPShip extends Enemy {

  public HPShip() {
  }

  public HPShip(Coordinate startCoordinates, Coordinate endCoordinates, double accuracy) {
    super(startCoordinates, endCoordinates, accuracy);
  }

  public HPShip(Coordinate startCoordinates, Coordinate endCoordinates) {
    super(startCoordinates, endCoordinates);
  }
}
