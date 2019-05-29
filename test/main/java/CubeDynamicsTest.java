package main.java;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CubeDynamicsTest {

    @Test
    void chOrientLeftTest() throws FileNotFoundException, CorruptedFile {

        CubeComparator cubeComparator = new CubeComparator();

        Cube c1 = new Cube("/home/dominik/IdeaProjects/CubeOperator/src/cubeFiles/cubeFrontChOrientLeft1.txt");
        CubeDynamics cubeDynamics = new CubeDynamics(c1);
        cubeDynamics.chOrientRight(c1.f);
        Cube c2 = new Cube("/home/dominik/IdeaProjects/CubeOperator/src/cubeFiles/cubeFrontChOrientLeft2.txt");

        assertTrue(cubeComparator.compareCubes(c1, c2));

    }

    @Test
    void frontLeftTest() throws FileNotFoundException, CorruptedFile {

        CubeComparator cubeComparator = new CubeComparator();

        Cube cube = new Cube("solved");
        CubeDynamics cubeDynamics = new CubeDynamics(cube);

        cubeDynamics.frontLeft();
        assertTrue(cubeComparator.compareCubes(new Cube("/home/dominik/IdeaProjects/CubeOperator/src/cubeFiles/cubeFrontLeft.txt"), cube));

    }

    @Test
    void frontRightTest() throws FileNotFoundException, CorruptedFile {

        CubeComparator cubeComparator = new CubeComparator();

        Cube cube = new Cube("solved");
        CubeDynamics cubeDynamics = new CubeDynamics(cube);

        cubeDynamics.frontRight();
        assertTrue(cubeComparator.compareCubes(new Cube("/home/dominik/IdeaProjects/CubeOperator/src/cubeFiles/cubeFrontRight.txt"), cube));

    }

    @Test
    void backLeftTest() throws FileNotFoundException, CorruptedFile {

        CubeComparator cubeComparator = new CubeComparator();

        Cube cube = new Cube("solved");
        CubeDynamics cubeDynamics = new CubeDynamics(cube);

        cubeDynamics.backLeft();

        Cube testC = new Cube("/home/dominik/IdeaProjects/CubeOperator/src/cubeFiles/cubeBackLeft.txt");

        assertTrue(cubeComparator.compareCubes(testC, cube));

    }

    @Test
    void upLeftTest() throws FileNotFoundException, CorruptedFile {

        CubeComparator cubeComparator = new CubeComparator();

        Cube cube = new Cube("solved");
        CubeDynamics cubeDynamics = new CubeDynamics(cube);

        cubeDynamics.upLeft();

        Cube testC = new Cube("/home/dominik/IdeaProjects/CubeOperator/src/cubeFiles/cubeUpLeft.txt");

        assertTrue(cubeComparator.compareCubes(testC, cube));

    }

    @Test
    void downLeftTest() throws FileNotFoundException, CorruptedFile {

        CubeComparator cubeComparator = new CubeComparator();

        Cube cube = new Cube("solved");
        CubeDynamics cubeDynamics = new CubeDynamics(cube);

        cubeDynamics.downLeft();

        Cube testC = new Cube("/home/dominik/IdeaProjects/CubeOperator/src/cubeFiles/cubeDownLeft.txt");

        assertTrue(cubeComparator.compareCubes(testC, cube));

    }

    @Test
    void leftLeftTest() throws FileNotFoundException, CorruptedFile {

        CubeComparator cubeComparator = new CubeComparator();

        Cube cube = new Cube("solved");
        CubeDynamics cubeDynamics = new CubeDynamics(cube);

        cubeDynamics.leftLeft();

        Cube testC = new Cube("/home/dominik/IdeaProjects/CubeOperator/src/cubeFiles/cubeLeftLeft.txt");

        assertTrue(cubeComparator.compareCubes(testC, cube));

    }

    @Test
    void rightLeftTest() throws FileNotFoundException, CorruptedFile {

        CubeComparator cubeComparator = new CubeComparator();

        Cube cube = new Cube("solved");
        CubeDynamics cubeDynamics = new CubeDynamics(cube);

        cubeDynamics.rightLeft();

        Cube testC = new Cube("/home/dominik/IdeaProjects/CubeOperator/src/cubeFiles/cubeRightLeft.txt");

        assertTrue(cubeComparator.compareCubes(testC, cube));

    }


}