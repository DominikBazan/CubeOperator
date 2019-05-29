package main.java;

class CubeComparator {

    boolean compareCubes(Cube c1, Cube c2){

        if(c1.equals(c2)) return true;
        for(int i=0; i<9; i++){
            if( c1.f[i] != c2.f[i] ||
                c1.b[i] != c2.b[i] ||
                c1.r[i] != c2.r[i] ||
                c1.l[i] != c2.l[i] ||
                c1.u[i] != c2.u[i] ||
                c1.d[i] != c2.d[i] ) return false;
        }

        return true;
    }

}
