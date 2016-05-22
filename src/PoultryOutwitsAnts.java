import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class PoultryOutwitsAnts {

  private static final String ORIGINAL_CHECKSUM = "4624d200580677270a54ccff86b9610e";
  public static final char[] ANAGRAM = "poultryoutwitsants".toCharArray();
  private static Set<String> dict = new LinkedHashSet<>();
  private static int nbrOfTripplesTried = 0;

  public static void main(String[] args) {

    Instant start = Instant.now();

    readDictionary();

    Instant endReadDictionary = Instant.now();

    for (String w1 : dict) {

      ArrayList<Character> availableChars = getAvailableCharacters(w1);

      for (String w2 : dict) {

        ArrayList<Character> availableChars2 = new ArrayList<>();
        boolean isValidWord = getAvailableCharacters(availableChars, w2, availableChars2);
        if (!isValidWord) {
          continue;
        } else {

          for (String w3 : dict) {

            ++nbrOfTripplesTried;
            ArrayList<Character> availableChars3 = new ArrayList<>();
            boolean isValidWord3 = getAvailableCharacters(availableChars2, w3, availableChars3);
            if (!isValidWord3 || !availableChars3.isEmpty()) {
              continue;
            } else {

              String s = String.join(" ", w1, w2, w3);

              if (matchesOriginalChecksum(s)) {
                System.out.println("Found answer: '" + s + "' after checking " + nbrOfTripplesTried + " tripples of words");
                Instant endProgram = Instant.now();
                System.out.println("Time to read wordlist: " + ChronoUnit.MILLIS.between(start, endReadDictionary) + " milliseconds");
                System.out.println("Time to find answer: " + ChronoUnit.SECONDS.between(endReadDictionary, endProgram) + " seconds");
                System.out.println("Total time " + ChronoUnit.SECONDS.between(start, endProgram) + " seconds");
                return;
              }
            }

          }


        }

      }

    }
  }

  private static boolean getAvailableCharacters(ArrayList<Character> inputChars, String word, ArrayList<Character> outputChars) {
    outputChars.addAll(inputChars);

    boolean isValidWord = true;
    for (Character c : word.toCharArray()) {
      if (!outputChars.contains(c)) {
        isValidWord = false;
        break;
      } else {
        outputChars.remove(c);
      }
    }
    return isValidWord;
  }

  private static ArrayList<Character> getAvailableCharacters(String w1) {
    ArrayList<Character> availableChars = new ArrayList<>();
    for (char c : ANAGRAM) {
      availableChars.add(c);
    }

    for (Character c : w1.toCharArray()) {
      availableChars.remove(c);
    }
    return availableChars;
  }

  private static void readDictionary() {
    try {

      Scanner sc = new Scanner(new File("wordlist"));

      ArrayList<Character> availableChars = new ArrayList<>();
      for (char c : ANAGRAM) {
        availableChars.add(c);
      }

      while (sc.hasNext()) {
        String next = sc.next();
        boolean isCulled = false;
        for (Character c : next.toCharArray()) {
          if (!availableChars.contains(c)) {
            isCulled = true;
            break;
          }
        }

        if (!isCulled) {
          dict.add(next);
        }
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static boolean matchesOriginalChecksum(String possibleAnagram) {
    String checksum = getMD5CheckSum(possibleAnagram);
    return checksum.equals(ORIGINAL_CHECKSUM);
  }

  private static String getMD5CheckSum(String s) {

    MessageDigest messageDigest = null;
    try {
      messageDigest = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
    messageDigest.update(s.getBytes());

    byte byteData[] = messageDigest.digest();

    //convert the byte to hex format method 1
    StringBuilder checksumBuilder = new StringBuilder();
    for (int i = 0; i < byteData.length; i++) {
      checksumBuilder.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }

    return checksumBuilder.toString();
  }

}
