package main.java;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CheckIfSolvedTest {

    static class CubeDynamicsTest {

        @Test
        void checkIfSolvedTest() throws FileNotFoundException, CorruptedFile {

            Cube cube = new Cube("solved");
            CubeDynamics cubeDynamics = new CubeDynamics(cube);

            assertTrue(cube.checkIfSolved());

            cubeDynamics.frontLeft();

            assertFalse(cube.checkIfSolved());

            cubeDynamics.frontRight();

            assertTrue(cube.checkIfSolved());


        }
    }
}