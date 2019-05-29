package main.java;

import java.io.FileNotFoundException;

public class Table {


    public static void main(String[] args) throws FileNotFoundException, CorruptedFile {

        /* Available main creation parameters:
            1) solved.
            2) random.
            3) path to file with main.
        */

        Cube cube = new Cube("random");
        cube.printCube();

    }
}