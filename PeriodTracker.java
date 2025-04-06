import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PeriodTracker {
    public static void main(String[] args) {
        Scanner cycle = new Scanner(System.in);

            System.out.println("Enter first date of your last period(YYYY-MM-DD):  ");
            String firstDate = cycle.nextLine();

            LocalDate firstPeriod = validateDate(firstDate);

            System.out.println("Enter your average cycle length in days in numbers between 1 and 31:  ");
            int cycleLength = cycle.nextInt();

            System.out.println("Enter the length of your period in numbers between 1 and 7:  ");
            int periodLength = cycle.nextInt();

    }

    public static LocalDate validateDate(String date) {
        LocalDate parseDate = null;

        while(true){
            try{
                parseDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;
            }catch(DateTimeParseException e){
                System.out.println("Invalid date format! Enter the date in the format YYYY-MM-DD");
                Scanner cycle = new Scanner(System.in);
                date = cycle.nextLine();
            }
        }
        return parseDate;

    }
}
