package com.akv.volume.two.ch06;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalDataTest {

    public static void main(String[] args){
        LocalDate now = LocalDate.now();
        LocalDate newYear = LocalDate.of(2020,01,1);
        LocalDate indDay = LocalDate.of(2020,8,15);
        System.out.println("Local Date:"+now+" "+ newYear);

        LocalDate afterTenDays = now.plusYears(10);
        System.out.println("After 10 Year:"+now+" "+ afterTenDays);
        System.out.println("Days between new year and Independence day: " + Period.between(newYear,indDay));
        System.out.println("Days between new year and Independence day: " + newYear.until(indDay, ChronoUnit.DAYS));

        DayOfWeek dow = indDay.getDayOfWeek();
        System.out.println("Independence Day week day: "+ dow);
        System.out.println("Independence Day plus 10: "+ indDay.plusDays(10));

        // Data Stream
        LocalDate t1 = LocalDate.now();
        LocalDate t2 = t1.plusDays(10);
        Stream<LocalDate> tStream = t1.datesUntil(t2);
        System.out.println(tStream.collect(Collectors.toList()));

        }


    }
