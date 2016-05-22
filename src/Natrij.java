import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Natrij {

  private static String formatDuration(Duration duration) {
    long seconds = duration.getSeconds();
    long absSeconds = Math.abs(seconds);
    String durationStr = String.format(
      "%d:%02d:%02d",
      absSeconds / 3600,
      (absSeconds % 3600) / 60,
      absSeconds % 60);
    return durationStr;
  }


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String currentString = sc.next();
    String boomString = sc.next();

    printTimeBetween(currentString, boomString);
  }

  private static void printTimeBetween(String currentString, String boomString) {
    String dateHack1 = "2016-01-01T";
    String dateHack2 = "2016-01-02T";

    LocalTime current = LocalTime.parse(currentString, DateTimeFormatter.ISO_LOCAL_TIME);
    LocalTime boom = LocalTime.parse(boomString, DateTimeFormatter.ISO_LOCAL_TIME);

    Duration duration;
    if (boom.isBefore(current)) {
      LocalDateTime currentDateTime = LocalDateTime.parse(dateHack1 + currentString);
      LocalDateTime boomDateTime = LocalDateTime.parse(dateHack2 + boomString);
      duration = Duration.between(currentDateTime, boomDateTime);
    }else if(boom.equals(current)) {
      duration = Duration.of(24, ChronoUnit.HOURS);
    } else {
      duration = Duration.between(current, boom);
    }

    System.out.println(formatDuration(duration));
  }

}
