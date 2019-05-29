package main.java;

import java.io.IOException;
import java.util.Scanner;

public class Table {


    public static void main(String[] args) throws IOException, CorruptedFile {

        /* Available main creation parameters:
            1) solved.
            2) random.
            3) path to file with main.
        */

        System.out.println("Welcome!");
        System.out.println("It's a simple terminal user interface.");

        boolean stillMenu = true;
        while(stillMenu) {
            System.out.println("MENU:");
            System.out.println("1 - Play with solved cube.");
            System.out.println("2 - Generate random cube.");
            System.out.println("\\ - End program.");
            System.out.print("Enter the number or '\\' ... ");

            Scanner scaner = new Scanner(System.in);
            String option = scaner.nextLine();
            String mode = "exit";
            switch (option) {
                case "1":
                    mode = "solved";
                    break;
                case "2":
                    mode = "random";
                    break;
                case "\\":
                    break;
                default:
                    continue;
            }

            if (!mode.equals("exit")) {
                Cube cube = new Cube(mode);
                System.out.println("\nIt's your cube. Now you can play with using keys on your keyboard.");
                boolean playing = true;
                while (playing) {
                    CubeDynamics cD = new CubeDynamics(cube);
                    cube.printCube();
                    System.out.println("q - front left; w - front right; e - back left; r - back right, t - up left; y - up right; u - down left; i - down right; o - left left; p - left right; [ - right left; ] - right right; \\ - exit");
                    String move = scaner.next();
                    switch (move) {
                        case "q":
                            cD.frontLeft();
                            break;
                        case "w":
                            cD.frontRight();
                            break;
                        case "e":
                            cD.backLeft();
                            break;
                        case "r":
                            cD.backRight();
                            break;
                        case "t":
                            cD.upLeft();
                            break;
                        case "y":
                            cD.upRight();
                            break;
                        case "u":
                            cD.downLeft();
                            break;
                        case "i":
                            cD.downRight();
                            break;
                        case "o":
                            cD.leftLeft();
                            break;
                        case "p":
                            cD.leftRight();
                            break;
                        case "[":
                            cD.rightLeft();
                            break;
                        case "]":
                            cD.rightRight();
                            break;
                        case "\\":
                            playing = false;
                            break;
                    }
                }
            } else {
                System.out.println("Have a good day.");
                stillMenu = false;
            }
        }
    }
}