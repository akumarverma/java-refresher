package com.akv.volume.two.ch06;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;

public class TimeLine  {

    public static void main(String[] args) throws InterruptedException {
        Instant time1 = Instant.now();
        System.out.println(time1);
        Thread.sleep(100);
        Instant time2 = Instant.now();
        Duration timeDiff = Duration.between(time1,time2);
        System.out.println("time Interval: "+ timeDiff.toMillis());
        System.out.println("time Interval x 10: "+ timeDiff.multipliedBy(10));


    }
}
