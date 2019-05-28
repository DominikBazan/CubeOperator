import main.java.Cube;
import main.java.CubeDynamics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CubeTest {

    @Test
    void checkIfSolvedTest() {

        Cube cube = new Cube("solved");
        CubeDynamics cubeDynamics = new CubeDynamics(cube);

        assertEquals(true, cube.checkIfSolved());

        cubeDynamics.frontLeft();

        assertEquals(false, cube.checkIfSolved());

    }
}