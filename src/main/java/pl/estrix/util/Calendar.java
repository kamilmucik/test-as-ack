package pl.estrix.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Iterator;

class Calendar implements Iterable<LocalDate>{

    private LocalDate date;

    Calendar(LocalDate localDate){
        this.date = localDate;
    }

    @Override
    public Iterator<LocalDate> iterator() {
        return new CalendarIterator(date);
    }

    private static class CalendarIterator implements Iterator<LocalDate> {

        private LocalDate date;

        CalendarIterator(LocalDate date){
            this.date = date;
        }

        /**
         * Method always return true, because calendar is infinity.
         * @return true
         */
        @Override
        public boolean hasNext() {
            return true;
        }

        /**
         * Method next() return every <i>Tuesday</i> and <i>Friday</i> in week days.
         * @return LocalDate
         */
        @Override
        public LocalDate next() {
            do {
                this.date = date.plusDays(1);
            } while ( (!date.getDayOfWeek().equals(DayOfWeek.TUESDAY))
                    && (!date.getDayOfWeek().equals(DayOfWeek.FRIDAY)));

            return date;
        }
    }
}