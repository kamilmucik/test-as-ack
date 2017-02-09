package pl.estrix.util;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Iterator;

public class CalendarTest {

    @Test
    public void shouldReturnWellKnowValues(){
        // arrange
        Calendar cal = new Calendar(LocalDate.of(2016, 9, 19));

        // act
        Iterator<LocalDate> it = cal.iterator();

        // assert
        Assertions.assertThat(it.hasNext()).isTrue();
        Assertions.assertThat(it.next()).isEqualTo(LocalDate.of(2016, 9, 20));
        Assertions.assertThat(it.next()).isEqualTo(LocalDate.of(2016, 9, 23));
        Assertions.assertThat(it.next()).isEqualTo(LocalDate.of(2016, 9, 27));
    }

    @Test
    public void shouldReturnIndependentIterators(){
        Calendar cal = new Calendar(LocalDate.of(2016, 9, 19));

        LocalDate date1 = cal.iterator().next();
        LocalDate date2 = cal.iterator().next();

        Assertions.assertThat(date1).isEqualTo(date2);
    }
}