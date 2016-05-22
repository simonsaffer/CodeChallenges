import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by simonsaffer on 15-01-17.
 *
 *  Since you crave state-of-the-art technology, you've just purchased a phone with a great new feature: autocomplete! Your phone's version of autocomplete has some pros and cons. On the one hand, it's very cautious. It only autocompletes a word when it knows exactly what you're trying to write. On the other hand, you have to teach it every word you want to use.

 You have N distinct words that you'd like to send in a text message in order. Before sending each word, you add it to your phone's dictionary. Then, you write the smallest non-empty prefix of the word necessary for your phone to autocomplete the word. This prefix must either be the whole word, or a prefix which is not a prefix of any other word yet in the dictionary.

 What's the minimum number of letters you must type to send all N words?
 Input

 Input begins with an integer T, the number of test cases. For each test case, there is first a line containing the integer N. Then, N lines follow, each containing a word to send in the order you wish to send them.
 Output

 For the ith test case, print a line containing "Case #i: " followed by the minimum number of characters you need to type in your text message.
 Constraints

 1 ≤ T ≤ 100
 1 ≤ N ≤ 100,000

 The N words will have a total length of no more than 1,000,000 characters.
 The words are made up of only lower-case alphabetic characters.
 The words are pairwise distinct.

 NOTE: The input file is about 10-20MB.
 Explanation of Sample

 In the first test case, you will write "h", "he", "l", "hil", "hill", for a total of 1 + 2 + 1 + 3 + 4 = 11 characters.

 INPUT

 5
 5
 hi
 hello
 lol
 hills
 hill
 5
 a
 aa
 aaa
 aaaa
 aaaaa
 5
 aaaaa
 aaaa
 aaa
 aa
 a
 6
 to
 be
 or
 not
 two
 bee
 3
 having
 fun
 yet


 OUTPUT

 Case #1: 11
 Case #2: 15
 Case #3: 11
 Case #4: 9
 Case #5: 3

 */
public class AutoComplete {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(new File(args[0]));

    int T = sc.nextInt();

    for (int i = 1; i <= T; i++) {

      int nbrOfDigitsTyped = 0;

      TrieNode root = new TrieNode();

      int N = sc.nextInt();

      for (int j = 0; j < N; j++) {

        String word = sc.next();

        root.insert(word);

        nbrOfDigitsTyped += root.digitsToType(word);



      }

      System.out.println("Case #" + i + ": " + nbrOfDigitsTyped);

    }

  }

}

class TrieNode {

  private final Character letter;
  private TrieNode[] children = new TrieNode[26];
  boolean isUnique;

  TrieNode() {
    letter = null;
  }

  TrieNode(char letter) {
    this.letter = letter;
  }

  public void insert(String word) {

    if(word.length() > 0) {

      TrieNode node;
      if (children[word.charAt(0)-'a'] == null) {
        node = new TrieNode(word.charAt(0));
        children[word.charAt(0) - 'a'] = node;
        node.isUnique = true;
      } else {
        node = children[word.charAt(0)-'a'];
        node.isUnique = false;
      }

      node.insert(word.substring(1));

    }

  }

  public boolean exists(String s) {

    if (s.isEmpty()) {
      return true;
    }

    TrieNode node = children[s.charAt(0) - 'a'];
    if (node == null) {
      return false;
    }

    return node.exists(s.substring(1));

  }

  public TrieNode getChild(char c) {
    return children[c-'a'];
  }

  public boolean isUnique(String s) {
    return isUnique;
  }

  public int digitsToType(String word) {

    if (word.isEmpty() || isUnique) {
      return 0;
    }

    return getChild(word.charAt(0)).digitsToType(word.substring(1)) + 1;
  }
}
