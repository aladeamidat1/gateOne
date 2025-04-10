import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TestPeriodTracker {

    @Test
    public void testCalculateForNextPeriod() {
        LocalDate lastPeriod = LocalDate.of(2024, 7, 1);
        int cycleLength = 28;
        LocalDate expectedNextPeriod = LocalDate.of(2024, 7, 29);

        LocalDate actual = PeriodTracker.calculateForNextPeriod(lastPeriod, cycleLength);

        assertEquals(expectedNextPeriod, actual, "Next period calculation should add cycleLength to last period.");
    }

    @Test
    public void testValidateDateValidInput() {
        String inputDate = "2024-07-01";
        LocalDate expected = LocalDate.of(2024, 7, 1);

        LocalDate result = PeriodTracker.validateDate(inputDate);
        assertEquals(expected, result, "Should correctly parse valid date.");
    }


}

