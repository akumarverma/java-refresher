# Date Time

**Instant**
```
java.time.Instant  -- point in time
java.time.Duration -- time difference

Duration timeDiff = Duration.between(t1,t2);
```

**Local Date**
```
LocalDate t1 = LocalDate.now()
LocalDate t2 = LocalDate.of()

> LocalDate diff is Period, the way instant diff is Duration

> until gives local date difference
System.out.println("Days between new year and Independence day: " + newYear.until(indDay, ChronoUnit.DAYS));

> day of week
DayOfWeek dow = indDay.getDayOfWeek();

> add days
System.out.println("Independence Day plus 10: "+ indDay.plusDays(10));

> Range of Date
Stream<LocalDate> tStream = t1.datesUntil(t2);
System.out.println(tStream.collect(Collectors.toList()));
```

**Time Adjustment**
```$xslt
> Next Tuesday
LocalDate today = LocalDate.now();
LocalDate nextTuesday = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
```

**LocalDateTime**


**ZonedDateTime**