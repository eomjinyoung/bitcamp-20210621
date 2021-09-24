import java.sql.Date;
import java.util.Calendar;

public class Test11 {
  public static void main(String[] args) {
    Date defaultDate = Date.valueOf("2020-01-01");
    Date d1 = Date.valueOf("2021-02-30");

    Calendar c0 = Calendar.getInstance();
    c0.setTime(defaultDate);

    Calendar c1 = Calendar.getInstance();
    c1.setTime(d1);

    System.out.println(c1.after(c0));


  }
}
