import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class datatime {
  public static void main(String args[]) {
	  datediff("1998-11-06T08:56:59","1995-10-07T09:30:27","1998-11-06T08:56:59+05:30","1995-10-07T09:30:27-15:30");
  }
  static void datediff(String d1,String d2,String zoned1,String zoned2) {
	  LocalDateTime myTime = LocalDateTime.parse(d1);
      System.out.println("My DateTime: " + myTime);
      
      LocalDateTime sisTime=LocalDateTime.parse(d2);
      System.out.println("Sis DateTime: " + sisTime);

      Instant start=Instant.parse(d1+".000Z");
      Instant end=Instant.parse(d2+".000Z");
      Duration d=Duration.between(end, start);
      System.out.println(d.toNanos());

      ZonedDateTime z1=ZonedDateTime.parse(zoned1);
      System.out.println(z1);
      ZonedDateTime z2=ZonedDateTime.parse(zoned2);
      System.out.println(z2);
      ChronoUnit c=ChronoUnit.DAYS;
      System.out.println(c.between(z2, z1));
  }
}
