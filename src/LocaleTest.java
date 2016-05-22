import java.text.DecimalFormat;
import java.util.Locale;

/**
 * Created by simonsaffer on 2016-02-04.
 */
public class LocaleTest {

    public static void main(String[] args) {
      String out="";
      String Format="0000.0000";
      Locale.setDefault(Locale.ENGLISH);
      DecimalFormat dfm=new DecimalFormat(Format);
      out=dfm.format(123.45);
      System.out.println("out="+out);
    }

}
