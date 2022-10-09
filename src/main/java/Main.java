import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        DayOfWeek actualWeekDay = LocalDate.now().getDayOfWeek();
        System.out.println(actualWeekDay);

        try {
            for (int i=0; i < 5; i++){
                Thread.sleep(1000);
                System.out.println("Timer: " + (i+1));
            }
        } catch (InterruptedException e) {
            System.out.println("Interupted exxeption invoced");
        }


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
