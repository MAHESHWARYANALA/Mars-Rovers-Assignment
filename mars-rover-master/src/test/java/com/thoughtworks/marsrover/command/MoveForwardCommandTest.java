//this test case ensures that the MoveForwardCommand class correctly executes a move forward operation on a Rover object, resulting in the rover moving forward by one unit along the y-axis.

package com.thoughtworks.marsrover.command;

import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.direction.NorthDirection;
import com.thoughtworks.marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoveForwardCommandTest extends BaseTest {


    public void start() throws Exception {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        command = new MoveForwardCommand();
    }

    @Test
    public void whenMoveForwardCommandIsExecutedRoverMovesForward() throws Exception {
        command.execute(rover);
        assertEquals(++yCoordinate, rover.getCoordinateY());
    }
}
