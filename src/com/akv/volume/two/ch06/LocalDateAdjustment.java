package com.akv.volume.two.ch06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateAdjustment {
    public static void main(String[] args){
        LocalDate today = LocalDate.now();
        LocalDate nextTuesday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        System.out.print(nextTuesday);
    }

}
