package com.akv.volume.two.ch06;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateTimeTest {

    public static void main(String[] args){
        LocalDateTime today = LocalDateTime.now();
        System.out.println("Today: "+today);
//        for (String zone: ZoneId.getAvailableZoneIds()){
//            System.out.println(zone);
//        }
        ZonedDateTime zt = today.atZone(ZoneId.of("UTC"));
        System.out.println("Zoned: "+zt);
        ZonedDateTime zt1 = ZonedDateTime.of(LocalDateTime.now(),ZoneId.of("UTC"));
        Instant ins= Instant.now();
        ZonedDateTime zt2 = ins.atZone(ZoneId.of("UTC")) ;
        System.out.println("Local and Zoned: "+ins+" "+ zt2);

    }
}
