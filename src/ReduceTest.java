import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by simonsaffer on 2016-02-12.
 */
public class ReduceTest {




  public static void main(String[] args) {

    Map<String, A> m = new HashMap<>();

    m.put("a", new A(1, 2, 3.0));
    m.put("b", new A(4, 5, 6.0));
    m.put("c", new A(7, 8, 9.0));

    //final Optional<A> reduce = m.values().stream().reduce((a, b) -> new A(a.sent + b.sent, a.received + b.received, Math.max(a
      //.val, b.val)));

    Optional<A> a = m.values()
      .stream()
      .reduce((a1, a2) -> new A(a1.sent + a2.sent, a1.received + a2.received, Math.max(a1.val, a2.val)));


    System.out.println(a.get().sent + " " + a.get().received + " " + a.get().val);
  }

}

class A {

  public A(long sent, long received, double val) {
    this.sent = sent;
    this.received = received;
    this.val = val;
  }

  long sent;
  long received;
  double val; // given as max {(double)sent/someDenominator,(double)received/someDenominator}
}
