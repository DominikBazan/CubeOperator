package main.java;

public class Cube {

    public Cube.Colour[] u, d, l, r, b, f;

    public enum Colour {
        G, B, Y, W, R, O
    }

    Cube.Colour[] up0 = {
            Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W, Cube.Colour.W
    };
    Cube.Colour[] down0 = {
            Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y, Cube.Colour.Y
    };
    Cube.Colour[] left0 = {
            Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R, Cube.Colour.R
    };
    Cube.Colour[] right0 = {
            Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O, Cube.Colour.O
    };
    Cube.Colour[] back0 = {
            Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G, Cube.Colour.G
    };
    Cube.Colour[] front0 = {
            Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B, Cube.Colour.B
    };


    public Cube(String mode) {

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
//            shuffle();
        } else if(mode.contains("/")){

            //TODO loading from file

        }

    }

    public void printCube(){
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
        System.out.println("---+---+---");
        System.out.println("   |"+b[0]+b[1]+b[2]+"|");
        System.out.println("   |"+b[3]+b[4]+b[5]+"|");
        System.out.println("   |"+b[6]+b[7]+b[8]+"|");
        System.out.println();

    }

    public boolean checkIfSolved(){

        int indexes[] = {0,1,2,3,5,6,7,8};
        Cube.Colour[] [] walls= {u, d, l, r, b, f};
        for (Cube.Colour[] wall : walls) {
            for (int i:indexes) {
                if(wall[i]!=wall[4]) return false;
            }
        }
        return true;
    }


}