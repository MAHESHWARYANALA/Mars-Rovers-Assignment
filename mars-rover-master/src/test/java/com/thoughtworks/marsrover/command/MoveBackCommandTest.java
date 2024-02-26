//this test case ensures that the MoveBackCommand class correctly executes a move back operation on a Rover object, resulting in the rover moving backward by one unit along the y-axis.

package com.thoughtworks.marsrover.command;

import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.direction.NorthDirection;
import com.thoughtworks.marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MoveBackCommandTest extends BaseTest {


    public void start() throws Exception {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        command = new MoveBackCommand();
    }


    public void whenMoveBackCommandIsExecutedRoverMovesBack() throws Exception {
        command.execute(rover);
        assertEquals(--yCoordinate, rover.getCoordinateY());
    }
}
