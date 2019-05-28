package main.java;

public class CubeDynamics {

    Cube.Colour[] u, d, l, r, b, f;

    public CubeDynamics(Cube cube){

        u = cube.u;
        d = cube.d;
        l = cube.l;
        r = cube.r;
        b = cube.b;
        f = cube.f;
    }

    private void shuffle() {

        //TODO shuffling, the rest (11) of 12 cases
        /*Random generator = new Random();

        for(int i=0; i<100; i++){
            int actionNumber = generator.nextInt()%12;
            switch (actionNumber) {
                case 0:
                    frontLeft();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;

            }
        }
        */
    }



    public void frontLeft(){

        turnLeft(f, u, d, l, r);
    }

    public void frontRight(){

        for(int i=0;i<3;i++) turnLeft(f, u, d, l, r);
    }

    public void upLeft(){

        turnLeft(u, b, f, l, r);
    }

    public void upRight(){

        for(int i=0;i<3;i++) turnLeft(u, b, f, l, r);
    }

    public void downLeft(){

        turnLeft(d, f, b, l, r);
    }

    public void downRight(){

        for(int i=0;i<3;i++) turnLeft(d, f, b, l, r);
    }

    public void backLeft(){

        turnLeft(b, d, u, l, r);
    }

    public void backRight(){

        for(int i=0;i<3;i++) turnLeft(b, d, u, l, r);
    }

    public void leftLeft(){

        turnLeft(l, u, d, b, f);
    }

    public void leftRight(){

        for(int i=0;i<3;i++) turnLeft(l, u, d, b, f);
    }

    public void rightLeft(){

        turnLeft(r, u, d, f, b);
    }

    public void rightRight(){

        for(int i=0;i<3;i++) turnLeft(r, u, d, f, b);
    }

    public void turnLeft(Cube.Colour[] fV, Cube.Colour[] uV, Cube.Colour[] dV, Cube.Colour[] lV, Cube.Colour[] rV) {

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

}
