package org.saviour.model;

import org.saviour.utils.SAVIOURCONSTANT;

public class Torpedo extends Enemy {

  public Torpedo() {
  }

  public Torpedo(Coordinate startCoordinates, Coordinate endCoordinates, double accuracy) {
    super(startCoordinates, endCoordinates, accuracy, SAVIOURCONSTANT.TORPEDO);
  }

  public Torpedo(Coordinate startCoordinates, Coordinate endCoordinates) {
    super(startCoordinates, endCoordinates, SAVIOURCONSTANT.TORPEDO);
  }

  public Torpedo(Coordinate startCoordinates, double accuracy) {
    super(startCoordinates, accuracy, SAVIOURCONSTANT.TORPEDO);
  }
}
