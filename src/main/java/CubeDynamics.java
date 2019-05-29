package main.java;

import java.util.Random;

public class CubeDynamics {

    private Cube.Colour[] u, d, l, r, b, f;

    CubeDynamics(Cube cube){

        u = cube.u;
        d = cube.d;
        l = cube.l;
        r = cube.r;
        b = cube.b;
        f = cube.f;
    }

    void shuffle() {

        Random generator = new Random();

        for(int i=0; i<100; i++){
            int actionNumber = generator.nextInt(11);
            switch (actionNumber) {
                case 0: frontLeft(); break;
                case 1: frontRight(); break;
                case 2: backLeft(); break;
                case 3: backRight(); break;
                case 4: leftLeft(); break;
                case 5: leftRight(); break;
                case 6: rightLeft(); break;
                case 7: rightRight(); break;
                case 8: upLeft(); break;
                case 9: upRight(); break;
                case 10: downLeft(); break;
                case 11: downRight(); break;
                default: System.out.println("Wrong random number!");
            }
        }
    }



    void frontLeft(){

        turnLeft(f, u, d, l, r);
    }

    void frontRight(){

        for(int i=0;i<3;i++) turnLeft(f, u, d, l, r);
    }

    void upLeft(){

        chOrientLeft(l);
        chOrientRight(r);
        turnLeft(u, b, f, l, r);
        chOrientLeft(r);
        chOrientRight(l);

    }

    public void upRight(){

        for(int i=0;i<3;i++) turnLeft(u, b, f, l, r);
    }

    void downLeft(){

        chOrientRight(l);
        chOrientLeft(r);
        turnLeft(d, f, b, l, r);
        chOrientLeft(l);
        chOrientRight(r);
    }

    public void downRight(){

        for(int i=0;i<3;i++) turnLeft(d, f, b, l, r);
    }

    void backLeft(){

        chOrientLeft(l);chOrientLeft(l);
        chOrientLeft(r);chOrientLeft(r);
        turnLeft(b, d, u, l, r);
        chOrientLeft(l);chOrientLeft(l);
        chOrientLeft(r);chOrientLeft(r);

    }

    public void backRight(){

        chOrientLeft(l);chOrientLeft(l);
        chOrientLeft(r);chOrientLeft(r);
        for(int i=0;i<3;i++) turnLeft(b, d, u, l, r);
        chOrientLeft(l);chOrientLeft(l);
        chOrientLeft(r);chOrientLeft(r);

    }

    void leftLeft(){

        chOrientRight(u);
        chOrientLeft(d);
        chOrientRight(b);chOrientRight(b);
        turnLeft(l, u, d, b, f);
        chOrientLeft(u);
        chOrientRight(d);
        chOrientRight(b);chOrientRight(b);
    }

    public void leftRight(){

        for(int i=0;i<3;i++) turnLeft(l, u, d, b, f);
    }

    void rightLeft(){

        chOrientRight(d);
        chOrientLeft(u);
        chOrientRight(b);chOrientRight(b);
        turnLeft(r, u, d, f, b);
        chOrientLeft(d);
        chOrientRight(u);
        chOrientRight(b);chOrientRight(b);
    }

    public void rightRight(){

        for(int i=0;i<3;i++) turnLeft(r, u, d, f, b);
    }

    private void turnLeft(Cube.Colour[] fV, Cube.Colour[] uV, Cube.Colour[] dV, Cube.Colour[] lV, Cube.Colour[] rV) {

        Cube.Colour tmp;

        tmp = fV[1];
        fV[1] = fV[5];
        fV[5] = fV[7];
        fV[7] = fV[3];
        fV[3] = tmp;

        tmp = fV[0];
        fV[0] = fV[2];
        fV[2] = fV[8];
        fV[8] = fV[6];
        fV[6] = tmp;

        Cube.Colour t1 = uV[6], t2 = uV[7], t3 = uV[8];
        uV[6] = rV[0];
        uV[7] = rV[3];
        uV[8] = rV[6];

        rV[0] = dV[2];
        rV[3] = dV[1];
        rV[6] = dV[0];

        dV[0] = lV[2];
        dV[1] = lV[5];
        dV[2] = lV[8];

        lV[8] = t1;
        lV[5] = t2;
        lV[2] = t3;
    }

    void chOrientRight(Cube.Colour[] wall){

        Cube.Colour tmp = wall[0];
        wall[0] = wall[2];
        wall[2] = wall[8];
        wall[8] = wall[6];
        wall[6] = tmp;
        tmp = wall[1];
        wall[1] = wall[5];
        wall[5] = wall[7];
        wall[7] = wall[3];
        wall[3] = tmp;
    }

    private void chOrientLeft(Cube.Colour[] wall){

        for(int i=0; i<3; i++) chOrientRight(wall);
    }

}
