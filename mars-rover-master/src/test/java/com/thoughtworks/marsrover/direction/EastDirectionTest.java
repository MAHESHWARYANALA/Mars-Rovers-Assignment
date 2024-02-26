// test cases ensure that the EastDirection class behaves correctly according to its specifications, including its ability to spin right, spin left, move forward, and move back on the Mars Rover grid
package com.thoughtworks.marsrover.direction;

import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EastDirectionTest extends BaseTest {


    public void start() throws Exception {
        direction = new EastDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
    }


    public void whenEastDirectionTurnsRightNewDirectionIsSouth() throws Exception {
        assertEquals(SouthDirection.class, direction.spinRight().getClass());
    }


    public void whenEastDirectionTurnsLeftNewDirectionIsNorth() throws Exception {
        assertEquals(NorthDirection.class, direction.spinLeft().getClass());
    }


    public void whenEastDirectionMovesForwardCoordinateXIncrements() throws Exception {
        direction.moveForward(rover);
        assertEquals(++xCoordinate, rover.getCoordinateX());
    }


    public void whenEastDirectionMovesBackCoordinateXDecrements() throws Exception {
        direction.moveBack(rover);
        assertEquals(--xCoordinate, rover.getCoordinateX());
    }
}
