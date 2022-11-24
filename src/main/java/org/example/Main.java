package org.example;

import Business.ParquetConverter;
import Models.InfoData;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        InfoData info1 = new InfoData("Artur", Math.random(), true);
        InfoData info2 = new InfoData("Larissa", Math.random(), false);
        InfoData info3 = new InfoData("Pepe", Math.random(), false);
        InfoData info4 = new InfoData("Bebes", Math.random(), true);
        ParquetConverter parquet = new ParquetConverter();
        parquet.convert(Arrays.asList(info1, info2, info3, info4));
    }
}