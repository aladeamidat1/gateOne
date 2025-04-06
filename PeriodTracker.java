import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class PeriodTracker {
    public static void main(String[] args) {
        Scanner cycle = new Scanner(System.in);

            System.out.println("Enter first date of your last period(YYYY-MM-DD):  ");
            String firstDate = cycle.nextLine();

            LocalDate lastPeriod = validateDate(firstDate);

            System.out.println("Enter your average cycle length in days in numbers between 1 and 31:  ");
            int cycleLength = validateCycleLength(cycle);


            System.out.println("Enter the length of your period in numbers between 1 and 7:  ");
            int periodLength = validatePeriodLength(cycle);

            LocalDate nextPeriod = calculateForNextPeriod(lastPeriod,cycleLength);

    }

    public static LocalDate validateDate(String date) {
        LocalDate parseDate ;

        while(true){
            try{
                parseDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                break;
            }catch(DateTimeParseException e){
                System.out.println("Invalid date format! Enter the date in the format YYYY-MM-DD");
            }
        }
        return parseDate;

    }

    public static int validateCycleLength(Scanner cycle) {
        int cycleLength ;
        while(true){
            try{
                cycleLength = Integer.parseInt(cycle.nextLine());

                if(cycleLength >= 1 && cycleLength <= 31){
                    return cycleLength;
                }else{
                    System.out.println("Invalid cycle length! Enter the number between 1 and 31:");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input! Enter a valid number");
            }
        }
    }

    public static int validatePeriodLength(Scanner cycle) {
        int periodLength ;
        while(true) {
            try {
                periodLength = Integer.parseInt(cycle.nextLine());
                if (periodLength >= 1 && periodLength <= 7) {
                    return periodLength;
                } else {
                    System.out.println("Invalid period length! Enter the number between 1 and 7:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a valid number");
            }
        }
    }
    public static LocalDate calculateForNextPeriod(LocalDate lastPeriod, int cycleLength) {
        return lastPeriod.plusDays(cycleLength);
    }
}
