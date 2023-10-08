package E1360NumberofDaysBetweenTwoDates;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Solution {
    public int daysBetweenDates(String date1, String date2) {
        // initialise dates in type<LocalDate>
        LocalDate d1 = LocalDate.parse(date1);
        LocalDate d2 = LocalDate.parse(date2);

        // calculate the absolute difference between dates using chronoUnit and
        // store it in long as it will return long value
        long days = Math.abs(ChronoUnit.DAYS.between(d1, d2));

        // convert long into int and return the date
        return (int)days;
    }
}
