package com.VedaMir.hdl;

public class IntegralAvtomat {


    Sort sort = new Sort();
    VecZnach vecZnach = new VecZnach();


    /**
     * @param massiv - massiv koe`fficentov
     * @return - integralkoefavtomat
     */


   public double IntegKoefAvto(int[] massiv, double[][] matrixB) {
        int[] korf = sort.puzSort(massiv);
        double p = 10;

        double [] lkef = delVecrot(korf,p);
        double [] rez = vecZnach.Vect(matrixB);

        double [] ll = DelVectornaVector(lkef,rez);

        double ia = SumVector(ll);

        return ia;
    }







// Matematicheskie rezul`taty`

    double[] delVecrot(int[] rtt, double p) {

        double[] dd = new double[rtt.length];
        for (int j = 0; j < rtt.length; j++) {
            double a = rtt[j]/ p;
            dd[j] = a;
        }
        return dd;
    }


    /**
     * delenie vektora na vektor koe`fficentov

     */
    double [] DelVectornaVector (double[] edVector ,double[] edVectorStolb){

        double [] mulVect = new double[edVectorStolb.length];

        for (int j = 0; j < edVectorStolb.length; j++) {
            mulVect[j] = edVectorStolb[j]*edVector[j];
        }
        return mulVect;
    }

    double  SumVector (double[] edVector){

        double sumVect = 0;

        for (int j = 0; j < edVector.length; j++) {
            sumVect += edVector[j];
        }
        return sumVect;
    }

}