package org.saviour.model;

import org.saviour.utils.SAVIOURCONSTANT;

public class HPShip extends Enemy {

  public HPShip() {
  }

  public HPShip(Coordinate startCoordinates, Coordinate endCoordinates, double accuracy) {
    super(startCoordinates, endCoordinates, accuracy, SAVIOURCONSTANT.HPSHIP);
  }

  public HPShip(Coordinate startCoordinates, Coordinate endCoordinates) {
    super(startCoordinates, endCoordinates, SAVIOURCONSTANT.HPSHIP);
  }

  public HPShip(Coordinate startCoordinates, double accuracy) {
    super(startCoordinates, accuracy, SAVIOURCONSTANT.HPSHIP);
  }
}
