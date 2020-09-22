package com.VedaMir.hdl;
/**
 * @author DmitryHDL
 * Dannyj klass soderzhit vse glavnuye funkcii klassa
 */
public class CalculIntegAvtom {


    /**
     * Vychislenie Integral'nogo koefficenta avtomatizacii
     * @param massiv -  massiv ishodniy
     * @return - Integral'nogo koefficenta avtomatizacii
     */

   public double intAvt(int[] massiv) {
        /*
    Sortirovka vcladov

     */
        Sort sortirovka = new Sort();
        int[] sortirov = sortirovka.puzSort(massiv);

    /*
    Poluchenie matritcy` poparny`kh sravnenii`
    */
        PostrMatrixPopSrav matrixPopSrav = new PostrMatrixPopSrav();
        double[][] matPopSra = matrixPopSrav.MatPopSrav(sortirov);

    /*
    Nahozhdenie sobstvennogo vektora
     */
        VecZnach vecZnach = new VecZnach();
        double[] sobVector = vecZnach.Vect(matPopSra);

    /*
    Nahozhdenie maksimal`noe sobstvennoe znacheniia
     */
        double maxSobZnach = vecZnach.maxsobzn(matPopSra);

    /*
    Nahozhdenie soglasovanosti rezul`tata
     */
        double soglRez = vecZnach.sogrez(matPopSra);

    /*
   Nahozhdenie integral`nogo koe`ffitcienta avtomatizatcii
    */
        IntegralAvtomat integralAvtomat = new IntegralAvtomat();

        return integralAvtomat.IntegKoefAvto(massiv, matPopSra);
    }


    /**
     * Vy`chislenie soglasovanosti rezul`tata
     * @param massiv - massiv ishodniy
     * @return - soglasovanosti rezul`tata
     */
    public double sogRez(int[] massiv) {
        /*
    Sortirovka vcladov

     */
        Sort sortirovka = new Sort();
        int[] sortirov = sortirovka.puzSort(massiv);

    /*
    Poluchenie matritcy` poparny`kh sravnenii`
    */
        PostrMatrixPopSrav matrixPopSrav = new PostrMatrixPopSrav();
        double[][] matPopSra = matrixPopSrav.MatPopSrav(sortirov);

    /*
    Nahozhdenie sobstvennogo vektora
     */
        VecZnach vecZnach = new VecZnach();
        double[] sobVector = vecZnach.Vect(matPopSra);

    /*
    Nahozhdenie maksimal`noe sobstvennoe znacheniia
     */
        double maxSobZnach = vecZnach.maxsobzn(matPopSra);

    /*
    Nahozhdenie soglasovanosti rezul`tata
     */


        return vecZnach.sogrez(matPopSra);
    }

    /**
     * Vy`chislenie maksimal`nogo sobstvennogo znacheniia
     * @param massiv - massiv ishodniy
     * @return -  maksimal`nogo sobstvennogo znacheniia
     */
    public double maxSobZna(int[] massiv) {
        /*
    Sortirovka vcladov

     */
        Sort sortirovka = new Sort();
        int[] sortirov = sortirovka.puzSort(massiv);

    /*
    Poluchenie matritcy` poparny`kh sravnenii`
    */
        PostrMatrixPopSrav matrixPopSrav = new PostrMatrixPopSrav();
        double[][] matPopSra = matrixPopSrav.MatPopSrav(sortirov);

    /*
    Nahozhdenie sobstvennogo vektora
     */
        VecZnach vecZnach = new VecZnach();
        double[] sobVector = vecZnach.Vect(matPopSra);

    /*
    Nahozhdenie maksimal`noe sobstvennoe znacheniia
     */

        return vecZnach.maxsobzn(matPopSra);
    }

    /**
     * Vy`chislenie sobstvennogo vektora
     * @param massiv - massiv ishodniy
     * @return - sobstvennogo vektora
     */

   public double [] sobVect(int[] massiv) {
        /*
    Sortirovka vcladov

     */
        Sort sortirovka = new Sort();
        int[] sortirov = sortirovka.puzSort(massiv);

    /*
    Poluchenie matritcy` poparny`kh sravnenii`
    */
        PostrMatrixPopSrav matrixPopSrav = new PostrMatrixPopSrav();
        double[][] matPopSra = matrixPopSrav.MatPopSrav(sortirov);

    /*
    Nahozhdenie sobstvennogo vektora
     */
        VecZnach vecZnach = new VecZnach();

        return vecZnach.Vect(matPopSra);
    }


    /**
     * Vy`chislenie matritcy` poparny`kh sravnenii`
     * @param massiv - massiv ishodniy
     * @return - matritcy` poparny`kh sravnenii`
     */
   public double [][] matricaPopSrav(int[] massiv) {
        /*
    Sortirovka vcladov

     */
        Sort sortirovka = new Sort();
        int[] sortirov = sortirovka.puzSort(massiv);

    /*
    Poluchenie matritcy` poparny`kh sravnenii`
    */
        PostrMatrixPopSrav matrixPopSrav = new PostrMatrixPopSrav();

        return matrixPopSrav.MatPopSrav(sortirov);
    }

    /**
     * Vy`chislenie sortirovki vclada
     * @param massiv - massiv ishodniy
     * @return - sortirovki vclada
     */
    public int [] sort(int[] massiv) {
        /*
    Sortirovka vcladov

     */
        Sort sortirovka = new Sort();

        return sortirovka.puzSort(massiv);
    }


}



