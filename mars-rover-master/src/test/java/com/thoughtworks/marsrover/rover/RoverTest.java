package com.thoughtworks.marsrover.rover;

import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.Plateau;
import com.thoughtworks.marsrover.command.Command;
import com.thoughtworks.marsrover.command.MoveForwardCommand;
import com.thoughtworks.marsrover.command.SpinLeftCommand;
import com.thoughtworks.marsrover.command.SpinRightCommand;
import com.thoughtworks.marsrover.direction.EastDirection;
import com.thoughtworks.marsrover.direction.NorthDirection;
import com.thoughtworks.marsrover.direction.WestDirection;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class RoverTest extends BaseTest {


    public void start() throws Exception {
        direction = new NorthDirection();
        rover = new Rover(plateau, xCoordinate, yCoordinate, direction);
    }

    
    public void whenRequestedRoverCanSpinRight() throws Exception {
        rover.spinRight();
        assertEquals(EastDirection.class, rover.getDirection().getClass());
    }


    public void whenRequestedRoverCanSpinLeft() throws Exception {
        rover.spinLeft();
        assertEquals(NorthDirection.class, rover.getDirection().getClass());
    }


    public void whenRequestedRoverCanMoveForward() throws Exception {
        rover.moveForward();
        assertEquals(++yCoordinate, rover.getCoordinateY());
    }


    public void whenRequestedRoverCanMoveBack() throws Exception {
        rover.moveBack();
        assertEquals(--yCoordinate, rover.getCoordinateY());
    }


    public void whenRequestedRoverCanPrintCurrentPosition() throws Exception {
        assertEquals(xCoordinate + " "
                + yCoordinate + " "
                + direction.getClass().getSimpleName().charAt(0), rover.broadcastLocation());
    }


    public void whenRequestedRoverCanExecuteCommandAsAList() throws Exception {
        ArrayList<Command> commandArrayList = new ArrayList<>();
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new SpinLeftCommand());
        commandArrayList.add(new MoveForwardCommand());
        commandArrayList.add(new SpinRightCommand());
        rover.executeCommandList(commandArrayList);

        assertEquals(1, rover.getCoordinateX());
        assertEquals(4, rover.getCoordinateY());
        assertEquals(NorthDirection.class, rover.getDirection().getClass());
    }


    public void whenHardCodedTestInputIsRunCorrectOutputIsReturned() {
        // Test Input:
        // 5 5
        Plateau plateau = new Plateau(5, 5);

        // 1 2 N
        Rover roverOne = new Rover(plateau, 1, 2, new NorthDirection());

        // LMLMLMLMM
        ArrayList<Command> roverOneCommands = new ArrayList<>();
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new SpinLeftCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOneCommands.add(new MoveForwardCommand());
        roverOne.executeCommandList(roverOneCommands);

        // 3 3 E
        Rover roverTwo = new Rover(plateau, 3, 3, new EastDirection());

        // MMRMMRMRRM
        ArrayList<Command> roverTwoCommands = new ArrayList<>();
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new SpinRightCommand());
        roverTwoCommands.add(new MoveForwardCommand());
        roverTwo.executeCommandList(roverTwoCommands);

        // Expected Output:
        // 1 3 N
        assertEquals(1, roverOne.getCoordinateX());
        System.out.print("1 ");
        assertEquals(3, roverOne.getCoordinateY());
        System.out.print("3 ");
        assertEquals(NorthDirection.class, roverOne.getDirection().getClass());
        System.out.print("N");

        // 5 1 E
        assertEquals(5, roverTwo.getCoordinateX());
        System.out.print("5 ");
        assertEquals(1, roverTwo.getCoordinateY());
        System.out.print("1 ");
        assertEquals(EastDirection.class, roverTwo.getDirection().getClass());
        System.out.print("E");
    }
}
