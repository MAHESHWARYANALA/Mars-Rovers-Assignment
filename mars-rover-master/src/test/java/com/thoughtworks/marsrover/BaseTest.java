
// this BaseTest class provides common setup and variables that can be used by test classes to test Mars Rover functionality. It initializes a plateau, initial coordinates, direction, rover, and command for testing purposes. Subclasses can extend this base class to write specific test cases.
package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.Plateau;
import com.thoughtworks.marsrover.command.Command;
import com.thoughtworks.marsrover.direction.Direction;
import com.thoughtworks.marsrover.rover.Rover;

public abstract class BaseTest {

    protected final Plateau plateau = new Plateau(5, 5);
    protected int xCoordinate = 2;
    protected int yCoordinate = 2;
    protected Direction direction;
    protected Rover rover;
    protected Command command;
}
