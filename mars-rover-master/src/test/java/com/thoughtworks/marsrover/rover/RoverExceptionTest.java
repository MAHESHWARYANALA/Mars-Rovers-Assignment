// test cases ensure that the Rover class handles various exceptional scenarios correctly, including null parameters, out-of-bounds coordinates, and movement beyond the plateau boundaries

package com.thoughtworks.marsrover.rover;

import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.direction.NorthDirection;
import org.junit.Before;
import org.junit.Test;

public class RoverExceptionTest extends BaseTest {


    public void start() throws Exception {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
    }


    public void whenRoverIsCreatedWithANullPlateauExceptionIsThrown() {
        new Rover(null, xCoordinate, yCoordinate, direction);
    }


    public void whenRoverIsCreatedWithANullDirectionExceptionIsThrown() {
        new Rover(plateau, xCoordinate, yCoordinate, null);
    }


    public void whenRoverIsCreatedOutOfPlateauBoundsExceptionIsThrown() {
        new Rover(plateau, xCoordinate, yCoordinate, direction);
    }


    public void whenRoverMovesOutOfNorthBoundsExceptionIsThrown() {
        rover.setCoordinateX(plateau.getUpperBoundCoordinateX());
        rover.setCoordinateY(plateau.getUpperBoundCoordinateY());
        rover.moveForward();
    }


    public void whenRoverMovesOutOfEastBoundsExceptionIsThrown() {
        rover.setCoordinateX(plateau.getUpperBoundCoordinateX());
        rover.setCoordinateY(plateau.getUpperBoundCoordinateY());
        rover.spinRight();
        rover.moveForward();
    }


    public void whenRoverMovesOutOfSouthBoundsExceptionIsThrown() {
        rover.setCoordinateX(plateau.getLowerBoundCoordinateX());
        rover.setCoordinateY(plateau.getLowerBoundCoordinateY());
        rover.moveBack();
    }


    public void whenRoverMovesOutOfWestBoundsExceptionIsThrown() {
        rover.setCoordinateX(plateau.getLowerBoundCoordinateX());
        rover.setCoordinateY(plateau.getLowerBoundCoordinateY());
        rover.spinLeft();
        rover.moveForward();
    }
}
