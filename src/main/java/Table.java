package main.java;

public class Table {


    public static void main(String[] args) {

        /* Available main creation parameters:
            1) solved.
            2) random.
            3) path to file with main
        */

        System.out.println("Start.");

        Cube cube1 = new Cube("solved");
        CubeDynamics cube1Dynamics = new CubeDynamics(cube1);

        if (cube1.checkIfSolved()) System.out.println("O Solved.");
        else System.out.println("X notlved.");

//        cube1.printCube();
        cube1Dynamics.frontLeft();

        if (cube1.checkIfSolved()) System.out.println("O Solved.");
        else System.out.println("X notlved.");

        cube1Dynamics.frontLeft();
        cube1Dynamics.frontLeft();
        cube1Dynamics.frontLeft();

        if (cube1.checkIfSolved()) System.out.println("O Solved.");
        else System.out.println("X notlved.");

//        cube1.printCube();

    }
}