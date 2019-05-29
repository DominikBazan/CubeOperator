package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Cube {

    public Colour[] u, d, l, r, b, f;

    public enum Colour {
        G, B, Y, W, R, O
    }

    private Cube.Colour[] up0 = {
            Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W
    };
    private Cube.Colour[] down0 = {
            Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y
    };
    private Cube.Colour[] left0 = {
            Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R
    };
    private Cube.Colour[] right0 = {
            Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O
    };
    private Cube.Colour[] back0 = {
            Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G
    };
    private Cube.Colour[] front0 = {
            Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B
    };

    Cube(String mode) throws FileNotFoundException, CorruptedFile {

        if(mode.equals("solved")) {
            u = up0;
            d = down0;
            l = left0;
            r = right0;
            b = back0;
            f = front0;
        } else if (mode.equals("random")){
            u = up0;
            d = down0;
            l = left0;
            r = right0;
            b = back0;
            f = front0;
            new CubeDynamics(this).shuffle();
        } else if(mode.contains(".")){

            Colour[][] tab = getTableOfWallsFromFile(mode);

            System.out.println();
            u = tab[0];
            d = tab[1];
            l = tab[2];
            r = tab[3];
            b = tab[4];
            f = tab[5];

        }

    }

    private Cube.Colour [][] getTableOfWallsFromFile(String path) throws FileNotFoundException, CorruptedFile {

        File file = new File(path);
        Scanner in = new Scanner(file);

        Cube.Colour[][] result = new Cube.Colour[6][9];

        for(int i=0; i<6; i++) {

            String row1 = in.nextLine();
            String row2 = in.nextLine();
            String row3 = in.nextLine();

            for(int j=0; j<3; j++) result[i][j] = whatColour(row1.substring(j,j+1));
            for(int j=3; j<6; j++) result[i][j] = whatColour(row2.substring(j-3,j-2));
            for(int j=6; j<9; j++) result[i][j] = whatColour(row3.substring(j-6,j-5));

        }

        return result;
    }

    private Cube.Colour whatColour(String sign) throws CorruptedFile {

        switch (sign){
            case "W": return Cube.Colour.W;
            case "Y": return Cube.Colour.Y;
            case "R": return Cube.Colour.R;
            case "O": return Cube.Colour.O;
            case "G": return Cube.Colour.G;
            case "B": return Cube.Colour.B;
            default: throw new CorruptedFile("Wrong colour!");
        }

    }

    void printCube(){
        System.out.println("   |"+u[0]+u[1]+u[2]+"|");
        System.out.println("   |"+u[3]+u[4]+u[5]+"|");
        System.out.println("   |"+u[6]+u[7]+u[8]+"|");
        System.out.println("---+---+---");
        System.out.println(""+l[0]+l[1]+l[2]+"|"+f[0]+f[1]+f[2]+"|"+r[0]+r[1]+r[2]);
        System.out.println(""+l[3]+l[4]+l[5]+"|"+f[3]+f[4]+f[5]+"|"+r[3]+r[4]+r[5]);
        System.out.println(""+l[6]+l[7]+l[8]+"|"+f[6]+f[7]+f[8]+"|"+r[6]+r[7]+r[8]);
        System.out.println("---+---+---");
        System.out.println("   |"+d[0]+d[1]+d[2]+"|");
        System.out.println("   |"+d[3]+d[4]+d[5]+"|");
        System.out.println("   |"+d[6]+d[7]+d[8]+"|");
        System.out.println("   +---+");
        System.out.println("   |"+b[0]+b[1]+b[2]+"|");
        System.out.println("   |"+b[3]+b[4]+b[5]+"|");
        System.out.println("   |"+b[6]+b[7]+b[8]+"|");
        System.out.println();

    }

    boolean checkIfSolved(){

        int[] indexes = new int[]{0,1,2,3,5,6,7,8};
        Cube.Colour[] [] walls= {u, d, l, r, b, f};
        for (Cube.Colour[] wall : walls) {
            for (int i:indexes) {
                if(wall[i]!=wall[4]) return false;
            }
        }
        return true;
    }


}