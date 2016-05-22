import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by simonsaffer on 2016-03-10.
 */
public class MultiSet <T>{

  public MultiSet(List<T> elements) {
    this.elements = elements.stream().sorted().collect(Collectors.toList());
  }

  List<T> elements;

  public List<T> intersect(MultiSet<T> other) {

    Map<T, Integer> f = new HashMap<>(elements.size());
    calcFrequencies(elements, f);

    Map<T, Integer> otherF = new HashMap<>(other.elements.size());
    calcFrequencies(other.elements, otherF);

    List<T> result = new ArrayList<>();
    for (Map.Entry<T, Integer> entry : f.entrySet()) {
      if (otherF.containsKey(entry.getKey())) {
        for (int i = 0; i < Math.max(entry.getValue(), otherF.get(entry.getKey())); i++) {
          result.add(entry.getKey());
        }
      }
    }

    return result;
  }

  private static <T> void calcFrequencies(List<T> elements, Map<T, Integer> f) {
    for (T element : elements) {
      Integer frequency = f.getOrDefault(element, 0);
      ++frequency;
      f.put(element, frequency);
    }
  }

  public static void main(String[] args) {

    MultiSet<Integer> a = new MultiSet<>(Arrays.asList(0,1,1,2,2,5));
    MultiSet<Integer> b = new MultiSet<>(Arrays.asList(0,1,1,2,2,6));

    System.out.println(a.intersect(b));

  }
}
