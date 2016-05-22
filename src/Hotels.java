import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by simonsaffer on 2016-03-09.
 */
public class Hotels {

  public static LocalDate date(String d) {
    return LocalDate.parse(d, DateTimeFormatter.ISO_LOCAL_DATE);
  }

  public static void main(String[] args) {

    List<Hotel> hotelList = Arrays.asList(new Hotel(3, "Westin"), new Hotel(2, "Best Western"), new Hotel(3, "Hilton"));

    List<Booking> bookings = Arrays.asList(
      new Booking("Hilton", date("2015-04-01"), date("2015-04-02")),
      new Booking("Hilton", date("2015-04-02"), date("2015-04-03")),
      new Booking("Hilton", date("2015-04-04"), date("2015-04-05")),
      new Booking("Westin", date("2015-04-01"), date("2015-04-20")),
      new Booking("Westin", date("2015-04-01"), date("2015-04-02")),
      new Booking("Westin", date("2015-04-04"), date("2015-04-10")),
      new Booking("Best Western", date("2015-04-01"), date("2015-04-03")),
      new Booking("Westin", date("2015-04-01"), date("2015-04-01")),
      new Booking("Best Western", date("2015-04-03"), date("2015-04-20")),
      new Booking("Hilton", date("2015-04-01"), date("2015-04-20")),
      new Booking("Westin", date("2015-04-01"), date("2015-04-05")),
      new Booking("Best Western", date("2015-04-05"), date("2015-04-06")),
      new Booking("Hilton", date("2015-04-02"), date("2015-04-04"))
    );

    listHotelsWithRooms(date("2015-03-29"), date("2015-04-01"), hotelList, bookings);

  }

  private static void listHotelsWithRooms(LocalDate start, LocalDate end, List<Hotel> hotelList, List<Booking> bookings) {

    Map<Hotel, Integer[]> availableRooms = new HashMap<>(hotelList.size());

    long nbrOfDays = ChronoUnit.DAYS.between(start, end);

    hotelList.forEach(hotel -> {
      Integer[] integers = new Integer[(int)nbrOfDays];
      Arrays.fill(integers, hotel.nbrOfRooms);
      availableRooms.put(hotel, integers);
    });

    for (Booking booking : bookings) {
      long length = ChronoUnit.DAYS.between(booking.checkIn, booking.checkOut);
      int offsetStart = (int) ChronoUnit.DAYS.between(start, booking.checkIn);
      //for (int i = offsetStart; i < )
    }

  }

}

class Hotel {
  public final int nbrOfRooms;
  public final String name;

  public Hotel(int nbrOfRooms, String name) {
    this.nbrOfRooms = nbrOfRooms;
    this.name = name;
  }
}

class Booking {
  public final String hotelName;
  public final LocalDate checkIn;
  public final LocalDate checkOut;

  public Booking(String hotelName, LocalDate checkIn, LocalDate checkOut) {
    this.hotelName = hotelName;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
  }
}
