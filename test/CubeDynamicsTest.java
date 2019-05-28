import main.java.Cube;
import main.java.CubeDynamics;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CubeDynamicsTest {

    @Test
    void turningTest() {

        Cube cube = new Cube("solved");
        CubeDynamics cubeDynamics = new CubeDynamics(cube);

        assertEquals(true, cube.checkIfSolved());
        for(int i=0;i<4;i++){
            cubeDynamics.frontLeft();
            cubeDynamics.frontRight();
            cubeDynamics.backLeft();

        }
        assertEquals(true, cube.checkIfSolved());





    }
}