// test cases ensure that the NorthDirection class behaves correctly according to its specifications, including its ability to spin right, spin left, move forward, and move back on the Mars Rover grid
package com.thoughtworks.marsrover.direction;

import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NorthDirectionTest extends BaseTest {


    public void start() throws Exception {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
    }


    public void whenNorthDirectionTurnsRightNewDirectionIsEast() throws Exception {
        assertEquals(EastDirection.class, direction.spinRight().getClass());
    }


    public void whenNorthDirectionTurnsLeftNewDirectionIsWest() throws Exception {
        assertEquals(WestDirection.class, direction.spinLeft().getClass());
    }


    public void whenNorthDirectionMovesForwardCoordinateYIncrements() throws Exception {
        direction.moveForward(rover);
        assertEquals(++yCoordinate, rover.getCoordinateY());
    }


    public void whenNorthDirectionMovesBackCoordinateYDecrements() throws Exception {
        direction.moveBack(rover);
        assertEquals(--yCoordinate, rover.getCoordinateY());
    }
}
