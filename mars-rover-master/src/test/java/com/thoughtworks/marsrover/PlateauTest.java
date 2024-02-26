//this test case ensures that the Plateau class correctly initializes its lower-left coordinates to (0, 0) when a new plateau object is created

package com.thoughtworks.marsrover;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PlateauTest extends BaseTest {


    public void whenPlateauIsConstructedLowerLeftCoordinatesAreZeroZero() throws Exception {
        assertEquals(0, plateau.getLowerBoundCoordinateX());
        assertEquals(0, plateau.getLowerBoundCoordinateY());
    }
}
