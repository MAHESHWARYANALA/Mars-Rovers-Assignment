//this test case ensures that the SpinRightCommand class correctly executes a right spin operation on a Rover object, resulting in the rover changing its direction to the right.

package com.thoughtworks.marsrover.command;

import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.direction.EastDirection;
import com.thoughtworks.marsrover.direction.NorthDirection;
import com.thoughtworks.marsrover.rover.Rover;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SpinRightCommandTest extends BaseTest {


    public void start() throws Exception {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
        command = new SpinRightCommand();
    }


    public void whenSpinRightCommandIsExecutedRoverSpinsRight() throws Exception {
        command.execute(rover);
        assertEquals(EastDirection.class, rover.getDirection().getClass());
    }
}
