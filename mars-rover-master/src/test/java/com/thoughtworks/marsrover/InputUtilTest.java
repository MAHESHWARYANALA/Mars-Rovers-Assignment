//Each test method verifies that the actual output matches the expected output for a given input.
package com.thoughtworks.marsrover;

import com.thoughtworks.marsrover.InputUtil;
import com.thoughtworks.marsrover.Plateau;
import com.thoughtworks.marsrover.command.*;
import com.thoughtworks.marsrover.direction.NorthDirection;
import com.thoughtworks.marsrover.rover.Rover;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class InputUtilTest extends BaseTest {


    public void inputStringsCanBeParsedFromFile() throws Exception {
        InputStream testFileInputStream = getClass().getResourceAsStream("/testInput.txt");
        String expectedInputStringOne = "5 5";
        String expectedInputStringTwo = "1 2 N";
        String expectedInputStringThree = "LMLMLMLMM";
        String expectedInputStringFour = "3 3 E";
        String expectedInputStringFive = "MMRMMRMRRM";
        ArrayList<String> testFileLines = InputUtil.parseInputFromFile(testFileInputStream);

        assertEquals(5, testFileLines.size());
        assertEquals(expectedInputStringOne, testFileLines.get(0));
        assertEquals(expectedInputStringTwo, testFileLines.get(1));
        assertEquals(expectedInputStringThree, testFileLines.get(2));
        assertEquals(expectedInputStringFour, testFileLines.get(3));
        assertEquals(expectedInputStringFive, testFileLines.get(4));
    }


    public void whenPlateauInputIsParsedPlateauIsConstructed() throws Exception {
        String plateauInput = "5 5";
        Plateau plateauOutput = InputUtil.parsePlateauInput(plateauInput);

        assertEquals(0, plateauOutput.getLowerBoundCoordinateX());
        assertEquals(0, plateauOutput.getLowerBoundCoordinateY());
        assertEquals(5, plateauOutput.getUpperBoundCoordinateX());
        assertEquals(5, plateauOutput.getUpperBoundCoordinateY());
    }


    public void whenPositionInputIsParsedRoverIsConstructed() throws Exception {
        String positionInput = "1 2 N";
        Rover roverOutput = InputUtil.parsePositionInput(positionInput, plateau);

        assertEquals(1, roverOutput.getCoordinateX());
        assertEquals(2, roverOutput.getCoordinateY());
        assertEquals(NorthDirection.class, roverOutput.getDirection().getClass());
    }


    public void whenRCommandIsParsedSpinRightCommandIsConstructed() throws Exception {
        String rCommandInput = "R";
        ArrayList<Command> commandOutput = InputUtil.parseCommandInput(rCommandInput);

        assertEquals(rCommandInput.length(), commandOutput.size());
        assertEquals(SpinRightCommand.class, commandOutput.get(0).getClass());
    }


    public void whenLCommandIsParsedSpinLeftCommandIsConstructed() throws Exception {
        String lCommandInput = "L";
        ArrayList<Command> commandOutput = InputUtil.parseCommandInput(lCommandInput);

        assertEquals(lCommandInput.length(), commandOutput.size());
        assertEquals(SpinLeftCommand.class, commandOutput.get(0).getClass());
    }


    public void whenMCommandIsParsedMoveForwardCommandIsConstructed() throws Exception {
        String mCommandInput = "M";
        ArrayList<Command> commandOutput = InputUtil.parseCommandInput(mCommandInput);

        assertEquals(mCommandInput.length(), commandOutput.size());
        assertEquals(MoveForwardCommand.class, commandOutput.get(0).getClass());
    }


    public void whenBCommandIsParsedMoveBackCommandIsConstructed() throws Exception {
        String mCommandInput = "B";
        ArrayList<Command> commandOutput = InputUtil.parseCommandInput(mCommandInput);

        assertEquals(mCommandInput.length(), commandOutput.size());
        assertEquals(MoveBackCommand.class, commandOutput.get(0).getClass());
    }


    public void whenMultipleCommandsAreParsedCommandListIsConstructed() throws Exception {
        String multiCommandInput = "RLM";
        ArrayList<Command> commandOutput = InputUtil.parseCommandInput(multiCommandInput);

        assertEquals(multiCommandInput.length(), commandOutput.size());
        assertEquals(SpinRightCommand.class, commandOutput.get(0).getClass());
        assertEquals(SpinLeftCommand.class, commandOutput.get(1).getClass());
        assertEquals(MoveForwardCommand.class, commandOutput.get(2).getClass());
    }
}
