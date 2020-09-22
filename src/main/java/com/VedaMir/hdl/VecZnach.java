package com.VedaMir.hdl;
/**
 * @author DmitryHDL
 * Danny`i` class opisy`vaet nahozhdeniia sobstvennogo vektora i maksimal`noe sobstvennoe znachenie.Proverka soglasovnsti rezul`tata.
 */
public class VecZnach {

    /**
     * Nahozhdeniia sobstvennogo vektora
     *
     * @param MatPopSrav - matritca poparny`kh sravnenii`
     * @return - vektor prioritetov
     */


    public double[] Vect(double[][] MatPopSrav) {

        double[] aBs = new double[0];
        double w2 = 0;
        double[] W1;
        double[] W = new double[0];
        double[] SS = new double[0];

        for (int i = 1; i < 100; i++) {

            W1 = resultVector(powerMatrix(MatPopSrav, i), edVectorStolb(MatPopSrav));

            w2 = MultVector(edVector(MatPopSrav), W1);

            W = DelVector(w2, W1); // Vektor prioritetov

            int k = i - 1;


            SS = Vecrotminus(powerVecrot(W, i), powerVecrot(W, k));

            aBs = VectorAbs(SS);

            // usloviia zadannoi` tochnosti
            if (aBs[aBs.length - 1] <= 0.01) {
                break;

            }

        }

        return W;

    }

    /**
     * Vy`chislenie sobstvennogo znacheniia
     *
     * @param MatPopSrav - matritca poparny`kh sravnenii`
     * @return - sobstvennogo znacheniia
     */
    public double maxsobzn(double[][] MatPopSrav) {
        double[] sobVect = Vect(MatPopSrav);

        return MultVector(sobVect, resultVector(MatPopSrav, edVectorStolb(MatPopSrav)));
    }

    /**
     * Proverka soglasovanosti rezul`tata
     * @param MatPopSrav - matritca poparny`kh sravnenii`
     * @return - soglasovanosti rezul`tata
     */

    public double   sogrez (double [][] MatPopSrav) {
        double ir9;
        double Ig = 0;
        double l_max = maxsobzn(MatPopSrav);
        int n = MatPopSrav.length;

        double is = (l_max-(n+1))/(n-1);


        switch (n) {

            case 1:
            case 2:
                double ir = 0;

                Ig =  ig(is,ir);


                break;
            case 3:
                double ir3 = 0.58;

                Ig =  ig(is,ir3);
                break;
            case 4:
                double ir4 = 0.9;

                Ig =  ig(is,ir4);
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                double ir5 = 1.41-(8-n)*0.09;

                Ig =  ig(is,ir5);
                break;
            case 9:
            case 10:
            case 11:
                double ir6 = 1.51-(11-n)*0.03;

                Ig =  ig(is,ir6);
                break;
            case 12:
                double ir7 = 1.48;


                Ig =  ig(is,ir7);
                break;
            case 13:
            case 14:
            case 15:
                double ir8 = 1.59-(15-n)*0.01;

                Ig =  ig(is,ir8);
                break;

        }

        if(n<1000){

            ir9 = 1.59+(n-15)*0.01;

            Ig =  ig(is,ir9);

        }

        return Ig;

}

















// Matematicheskie operatcii

    /**
     * Umnozhenie matritcy` na matritcu
     * @param m1 -  pervaia matritca
     * @param m2 -  vtoraia matritca
     * @return - vozrashchaet matrichnoe umnozhenie
     */
    public double[][] multiplyByMatrix(double[][] m1, double[][] m2) {
        int m1ColLength = m1[0].length;
        int m2RowLength = m2.length;
        if(m1ColLength != m2RowLength) return null;
        int mRRowLength = m1.length;
        int mRColLength = m2[0].length;
        double[][] mResult = new double[mRRowLength][mRColLength];
        for(int i = 0; i < mRRowLength; i++) {
            for(int j = 0; j < mRColLength; j++) {
                for(int k = 0; k < m1ColLength; k++) {
                    mResult[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return mResult;
    }

    /**
     * Vozvedeniia matritcy` v stepen`
     *
     * @param mRe - ishodnaia matritca
     * @param p - stepen` matritcy`
     * @return - vozrashchaemaia matritca
     */
    double[][] powerMatrix (double[][] mRe, int p) {

        double[][] result = mRe;
        for (int n = 1; n < p; ++ n)
            result = multiplyByMatrix(mRe,mRe);
        return result;
    }


    /**
     * peremnozhenie matritcy` na vektor
     * @param matrix - matritca
     * @param vector - vektor-stolbetc
     * @return - vector
     */

    double [] resultVector (double[][] matrix,int [][] vector){
        int s = 0;
       double [] resultVector = new double[vector.length];
        for (int j = 0; j < vector.length; j++) {
            for (int i = 0; i < vector.length; i++) {
                resultVector[j] += matrix[j][i] * vector[i][s];
            }
        }
        return resultVector;

    }


    /**
     * Vy`chislenie edinichnogo vektora stolbtca
     * @param MatPopSrav - razmernost`
     * @return - vektor-stolbetc
     */

    int[][] edVectorStolb (double [][] MatPopSrav){

        int [][] pio = new int[MatPopSrav.length][1];


        for (int j = 0; j < MatPopSrav.length; j++) {
            for (int f = 0; f < 1; f++) {
                pio [j][f]= 1;
            }
        }

        return pio;
    }

    /**
     * Edinichny`i` vektor
     *
     */

    double [] edVector (double [][] MatPopSrav){

        double[] pio = new double[MatPopSrav.length];
        for (int j = 0; j < MatPopSrav.length; j++) {
                pio [j]= 1;
        }
        return pio;
    }


    /**
     * Umnozhenie vetora stolbetc na vetkor stroka
     * @param edVector - edenichny`i` vektor
     * @param edVectorStolb - edinichny`i` vektor stolbetc
     * @return - znachenia
     */

     double MultVector (double[] edVector ,double[] edVectorStolb){

        double mulVect = 0;

        for (int j = 0; j < edVector.length; j++) {
            mulVect += edVector[j]*edVectorStolb[j];
        }
        return mulVect;
    }

    /**
     * Delenie vetora  na vetkor
     * @param edVector - edenichny`i` vektor
     * @param edVectorStolb - edinichny`i` vektor stolbetc
     * @return - vector
     */

    double [] DelVector (double edVector ,double[] edVectorStolb){

        double [] mulVect = new double[edVectorStolb.length];

        for (int j = 0; j < edVectorStolb.length; j++) {
            mulVect[j] = edVectorStolb[j]/edVector;
        }
        return mulVect;
    }


    /**
     * Vozvedenie kazhdogo e`lementa v stepen`

     */
    double[] powerVecrot (double[] mRe, int p) {

        double[] dd = new double[mRe.length];
        for (int j = 0; j < mRe.length; j++)
            dd[j] = Math.pow(mRe[j],p);
        return dd;
    }

    /**
     * Vy`chitanie kazhdogo e`lementa vektora
     *
     */
    double[] Vecrotminus (double[] mm1,double[] mm2 ) {

        double[] Mmm = new double [mm1.length];
        for (int j = 0; j < mm1.length; j++)
            Mmm[j] = mm1[j]-mm2[j];
        return Mmm;
    }

/**
 * Raschyot kazhdogo e`lementa v vektora po moduliu
 */
     double[] VectorAbs (double[] mm1) {

    double[] absy = new double [mm1.length];
    for (int j = 0; j < mm1.length; j++)
        absy[j] = Math.abs(mm1[j]);
    return absy;
}

double ig (double is,double ir){

         double ig = is/ir;

         return  ig;
}


}
