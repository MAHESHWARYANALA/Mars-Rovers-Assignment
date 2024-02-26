package com.thoughtworks.marsrover.rover;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;

import com.thoughtworks.marsrover.direction.EastDirection;
import com.thoughtworks.marsrover.direction.EastDirectionTest;
import com.thoughtworks.marsrover.direction.NorthDirection;
import com.thoughtworks.marsrover.direction.NorthDirectionTest;
import com.thoughtworks.marsrover.direction.SouthDirectionTest;
import com.thoughtworks.marsrover.rover.Rover;
import com.thoughtworks.marsrover.BaseTest;
import com.thoughtworks.marsrover.InputUtilTest;
import com.thoughtworks.marsrover.Plateau;
import com.thoughtworks.marsrover.PlateauTest;
import com.thoughtworks.marsrover.command.Command;
import com.thoughtworks.marsrover.command.MoveBackCommandTest;
import com.thoughtworks.marsrover.command.MoveForwardCommand;
import com.thoughtworks.marsrover.command.MoveForwardCommandTest;
import com.thoughtworks.marsrover.command.SpinLeftCommand;
import com.thoughtworks.marsrover.command.SpinLeftCommandTest;
import com.thoughtworks.marsrover.command.SpinRightCommand;
import com.thoughtworks.marsrover.command.SpinRightCommandTest;
import com.thoughtworks.marsrover.direction.WestDirection;
import com.thoughtworks.marsrover.direction.WestDirectionTest;

import org.junit.Test;

import java.util.ArrayList;


public class roverSteps extends BaseTest {

	InputUtilTest iu=new InputUtilTest();
	PlateauTest pt=new PlateauTest();
	MoveForwardCommandTest mfct=new MoveForwardCommandTest();	
	
	MoveBackCommandTest mbct=new MoveBackCommandTest();
	SpinLeftCommandTest slct=new SpinLeftCommandTest();
	SpinRightCommandTest srct=new SpinRightCommandTest();
	NorthDirectionTest ndt=new NorthDirectionTest();	
	EastDirectionTest edt=new EastDirectionTest();
	SouthDirectionTest sdt=new SouthDirectionTest();
	WestDirectionTest wdt=new WestDirectionTest();
	
	RoverExceptionTest ret=new RoverExceptionTest();
	RoverTest rt=new RoverTest();

	@Given("Rovers initial position is {int} {int} {string}")
	public void rovers_initial_position_is(Integer x, Integer y, String direction) throws Exception {
		iu.inputStringsCanBeParsedFromFile();
		iu.whenPlateauInputIsParsedPlateauIsConstructed();
		iu.whenPositionInputIsParsedRoverIsConstructed();
		iu.whenRCommandIsParsedSpinRightCommandIsConstructed();
		iu.whenLCommandIsParsedSpinLeftCommandIsConstructed();
		iu.whenMCommandIsParsedMoveForwardCommandIsConstructed();
		iu.whenBCommandIsParsedMoveBackCommandIsConstructed();
		iu.whenMultipleCommandsAreParsedCommandListIsConstructed();		
		pt.whenPlateauIsConstructedLowerLeftCoordinatesAreZeroZero();
	}

	@Then("the output should be {int} {int} {string}")
	public void the_output_should_be(Integer int1, Integer int2, String expectedPosition) throws Exception {
		
		mbct.start();
		mbct.whenMoveBackCommandIsExecutedRoverMovesBack();
		mfct.start();
		mfct.whenMoveForwardCommandIsExecutedRoverMovesForward();
		slct.start();
		slct.whenSpinLeftCommandIsExecutedRoverSpinsLeft();
		srct.start();
		srct.whenSpinRightCommandIsExecutedRoverSpinsRight();
	}

	@When("Rover prints its position")
	public void rover_prints_its_position() throws Exception {
		edt.start();
		edt.whenEastDirectionTurnsRightNewDirectionIsSouth();
		edt.whenEastDirectionTurnsLeftNewDirectionIsNorth();
		edt.whenEastDirectionMovesForwardCoordinateXIncrements();
		edt.whenEastDirectionMovesBackCoordinateXDecrements();
	}

	@Given("the plateau size is {int} {int}")
	public void the_plateau_size_is(Integer int1, Integer int2) throws Exception {
		ndt.start();
		ndt.whenNorthDirectionTurnsRightNewDirectionIsEast();
		ndt.whenNorthDirectionTurnsLeftNewDirectionIsWest();
		ndt.whenNorthDirectionMovesForwardCoordinateYIncrements();
		ndt.whenNorthDirectionMovesBackCoordinateYDecrements();
		
		sdt.start();
		sdt.whenSouthDirectionTurnsRightNewDirectionIsWest();
		sdt.whenSouthDirectionTurnsLeftNewDirectionIsEast();
		sdt.whenSouthDirectionMovesForwardCoordinateYDecrements();
		sdt.whenSouthDirectionTurnsRightNewDirectionIsWest();
		
		wdt.start();
		wdt.whenWestDirectionMovesBackCoordinateXIncrements();
		wdt.whenWestDirectionMovesForwardCoordinateXDecrements();
		wdt.whenWestDirectionTurnsLeftNewDirectionIsSouth();
		wdt.whenWestDirectionTurnsRightNewDirectionIsNorth();
		
	}

	@When("Rover moves with commands {string}")
	public void moveRover(String commands) throws Exception {
		
		rt.start();
		rt.whenRequestedRoverCanSpinRight();
		rt.whenRequestedRoverCanSpinLeft();
		rt.whenRequestedRoverCanMoveForward();
		rt.whenRequestedRoverCanMoveBack();
		rt.whenRequestedRoverCanPrintCurrentPosition();
		rt.whenRequestedRoverCanExecuteCommandAsAList();
		rt.whenHardCodedTestInputIsRunCorrectOutputIsReturned();
		
		
	}

}