//test cases ensure that the WestDirection class behaves correctly according to its specifications, including its ability to spin right, spin left, move forward, and move back on the Mars Rover grid

package com.thoughtworks.marsrover.direction;

import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WestDirectionTest extends BaseTest {


    public void start() throws Exception {
        direction = new WestDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
    }


    public void whenWestDirectionTurnsRightNewDirectionIsNorth() throws Exception {
        assertEquals(direction.spinRight().getClass(), NorthDirection.class);
    }


    public void whenWestDirectionTurnsLeftNewDirectionIsSouth() throws Exception {
        assertEquals(direction.spinLeft().getClass(), SouthDirection.class);
    }


    public void whenWestDirectionMovesForwardCoordinateXDecrements() throws Exception {
        direction.moveForward(rover);
        assertEquals(--xCoordinate, rover.getCoordinateX());
    }


    public void whenWestDirectionMovesBackCoordinateXIncrements() throws Exception {
        direction.moveBack(rover);
        assertEquals(++xCoordinate, rover.getCoordinateX());
    }
}
