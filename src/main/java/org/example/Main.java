package org.example;

import Business.ParquetConverter;
import Models.InfoData;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        org.joda.time.LocalDate teste = new org.joda.time.LocalDate();
        InfoData info1 = new InfoData("Artur", Math.random(), true, LocalDate.now().toEpochDay());
        InfoData info2 = new InfoData("Larissa", Math.random(), false, LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        ParquetConverter parquet = new ParquetConverter();
        parquet.convert(Arrays.asList(info1, info2));
    }
}