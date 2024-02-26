// these test cases ensure that the SouthDirection class behaves correctly according to its specifications, including its ability to spin right, spin left, move forward, and move back on the Mars Rover grid
package com.thoughtworks.marsrover.direction;

import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SouthDirectionTest extends BaseTest {


    public void start() throws Exception {
        direction = new SouthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
    }


    public void whenSouthDirectionTurnsRightNewDirectionIsWest() throws Exception {
        assertEquals(WestDirection.class, direction.spinRight().getClass());
    }


    public void whenSouthDirectionTurnsLeftNewDirectionIsEast() throws Exception {
        assertEquals(EastDirection.class, direction.spinLeft().getClass());
    }


    public void whenSouthDirectionMovesForwardCoordinateYDecrements() throws Exception {
        direction.moveForward(rover);
        assertEquals(--yCoordinate, rover.getCoordinateY());
    }


    public void whenSouthDirectionMovesBackCoordinateYIncrements() throws Exception {
        direction.moveBack(rover);
        assertEquals(++yCoordinate, rover.getCoordinateY());
    }
}
