import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by simonsaffer on 15-02-12.
 */
public class PeakTraffic {

  private static final Pattern pattern = Pattern.compile(".*\\t(.*)\\t(.*)");

  private HashMap<String, InteractionNode> nodes = new LinkedHashMap<>();

  private void run(BufferedReader br) throws Exception{

    String line;
    while ((line = br.readLine()) != null) {

      Matcher matcher = pattern.matcher(line);

      matcher.find();
      String emailA = matcher.group(1);
      String emailB = matcher.group(2);

      InteractionNode nodeA;
      if (nodes.containsKey(emailA)) {
        nodeA = nodes.get(emailA);
      } else {
        nodeA = new InteractionNode(emailA);
        nodes.put(emailA, nodeA);
      }

      InteractionNode nodeB;
      if (nodes.containsKey(emailB)) {
        nodeB = nodes.get(emailB);
      } else {
        nodeB = new InteractionNode(emailB);
        nodes.put(emailB, nodeB);
      }

      nodeA.addInteraction(nodeB);
      nodeB.addInteraction(nodeA);

    }
  }

  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new FileReader(args[0]));
  }

}

class InteractionNode {

  public final String email;
  private HashSet<InteractionNode> adjList = new LinkedHashSet<>();

  InteractionNode(String email) {
    this.email = email;
  }

  public void addInteraction(InteractionNode node) {
    if (node != this) {
      throw new IllegalArgumentException();
    } else {
      adjList.add(node);
    }
  }

  @Override
  public int hashCode() {
    return email.hashCode();
  }
}
