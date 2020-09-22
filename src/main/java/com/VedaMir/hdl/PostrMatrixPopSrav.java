package com.VedaMir.hdl;
/**
 * @author DmitryHDL
 * Danny`i` class opisy`vaet ocenku togo ili inogo koe`fficenta avtomatizatcii soglsano shkale vazhnosti po sravneniiu s drugimi koe`fficentami.Postroenie matritcy` poprny`kh sravnenii`.
 */

public class PostrMatrixPopSrav {
    /**
     * @param mas_sort - otsortirovanny`i` massiv
     *
     * @return - vozrashchaet obratno semetrichnuiu matritcu
     */


    public double[][] MatPopSrav(int[] mas_sort) {
        double inf = Double.POSITIVE_INFINITY;
        double[][] hh = new double[mas_sort.length - 1][mas_sort.length - 1];
        int lenght_hh = mas_sort.length;
        int n = lenght_hh -1;


        for (int i = 0; i < lenght_hh - 1; i++) {
            for (int j = i; j < lenght_hh - 1; j++) {


                int rez = mas_sort[i] - mas_sort[j + 1];
/**
 * @param rez - ocenka sravneneniia vcladov koe`fficentov;
 *
 */
                switch (rez) {

                    case 0:
                    case 1:
                        /**
                         * Ravnocenny`i` vclad
                         */
                        hh[i][j] = 1;
                        hh[n-1-i][n-1-j] = 1;

                        double aw = hh[n-1-i][n-1-j];
                        double as = 1/aw;

                        // Проверка бесконечности и запись нуля в матрицу
                        if (as == inf){
                            hh [n-1-i][n-1-j] = 0;
                        }
                        else {
                            hh [n-1-i][n-1-j] = as;
                        }


                        break;
                    case 2:
                    case 3:
                        /**
                         * nekotoroe preobrazovanie znachimosti vclada pered drugim(slabaia znachimost`) po sravneniiu s drugim vcladom
                         */
                        hh[i][j] = 3;
                        hh[n-1-i][n-1-j] = 3;

                        double ak = hh[n-1-i][n-1-j];
                        double aq = 1/ak;
                        if (aq == inf){
                            hh [n-1-i][n-1-j] = 0;
                        }
                        else {
                            hh [n-1-i][n-1-j] = aq;
                        }




                        break;
                    case 4:
                    case 5:

                        /**
                         * sushchestvennaia ili sil`naia znachimost`(sil`naia dei`stvie pered drugim) po sravneniiu s drugim vcladom
                         */

                        hh[i][j] = 5;
                        hh[n-1-i][n-1-j] = 5;

                        double ae = hh[n-1-i][n-1-j];
                        double ap = 1/ae;
                        if (ap == inf){
                            hh [n-1-i][n-1-j] = 0;
                        }
                        else {
                            hh [n-1-i][n-1-j] = ap;
                        }

                        break;
                    case 6:
                    case 7:

                        /**
                         * predpochtenie vclada po sravneniiu s drugim vcladom ochen` sil`noe, prevoshodstvo prakticheski iavnoe
                         */

                        hh[i][j] = 7;
                        hh[n-1-i][n-1-j] = 7;

                        double at = hh[n-1-i][n-1-j];
                        double ay = 1/at;
                        if (ay == inf){
                            hh [n-1-i][n-1-j] = 0;
                        }
                        else {
                            hh [n-1-i][n-1-j] = ay;
                        }

                        break;
                    case 8:
                    case 9:
                        /**
                         * absoliutnoe prevoshodstvo po sravneniiu s drugim vcladom
                         */

                        hh[i][j] = 9;
                        hh[n-1-i][n-1-j] = 9;

                        double al = hh[n-1-i][n-1-j];
                        double ab = 1/al;
                        if (ab == inf){
                            hh [n-1-i][n-1-j] = 0;
                        }
                        else {
                            hh [n-1-i][n-1-j] = ab;
                        }

                        break;

                }
            }

        }

        return hh;
        }

    }


