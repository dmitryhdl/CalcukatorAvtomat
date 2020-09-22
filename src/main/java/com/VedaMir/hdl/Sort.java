package com.VedaMir.hdl;

/**
 * @author DmitryHDL
 * Danny`i` class opisy`vaet sartirovku puzy`r`kom koe`fficentov urovnia avtomatizatcii po uby`vaniiu
 */

public class Sort {

 private boolean isSorted = false;
 private int buf;

    /**
     *
     * @param massiv - sortiruemiy massiv
     * @return - otsortirovaniy massiv
     */

public int [] puzSort (int [] massiv){

    while (! isSorted){
        isSorted = true;
        for (int i = 0; i < massiv.length-1;i++){
            if (massiv[i] < massiv[i+1]) {
                isSorted = false;

                buf = massiv[i];
                massiv[i] = massiv[i+1];
                massiv[i+1]= buf;
                }
            }

        }
        return massiv;
    }
}


