import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by simonsaffer on 2015-04-10.
 */
public class BigFileSystemSearch {



  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    List<HashSet<Integer>> files = new ArrayList<>(N);

    for (int i = 0; i < N; i++) {

      int M = sc.nextInt();

      HashSet<Integer> file = new HashSet<Integer>(M);

      for (int j = 0; j < M; j++) {
        file.add(sc.nextInt());
      }

      files.add(file);

    }

    int Q = sc.nextInt();

    for (int i = 0; i < Q; i++) {

      int typeOfQuery = sc.nextInt();

      int K = sc.nextInt();

      int[] A = new int[K];

      for (int j = 0; j < K; j++) {
        A[j] = sc.nextInt();
      }
      Arrays.sort(A);

      int result = -1;

      switch (typeOfQuery) {
        case 1:
          result = queryAll(files, A);
          break;
        case 2:
          result = queryAny(files, A);
          break;
        case 3:
          result = querySome(files, A);
      }

      System.out.println(result);
    }
  }

  private static int querySome(List<HashSet<Integer>> files, int[] a) {
    int total = 0;
    for (HashSet<Integer> file : files) {
      if (someMatch(file, a)) {
        ++total;
      }
    }
    return total;
  }

  private static boolean someMatch(HashSet<Integer> file, int[] a) {
    return anyMatch(file, a) && !allMatch(file, a);
  }

  private static boolean anyMatch(HashSet<Integer> file, int[] a) {

    for (int i = 0; i < a.length; i++) {
      if (file.contains(a[i])) return true;
    }

    return false;
  }

  private static int queryAny(List<HashSet<Integer>> files, int[] a) {
    int total = 0;
    for (HashSet<Integer> file : files) {
      if (anyMatch(file, a)) {
        ++total;
      }
    }
    return total;
  }

  private static int queryAll(List<HashSet<Integer>> files, int[] a) {
    int total = 0;
    for (HashSet<Integer> file : files) {
      if (allMatch(file, a)) {
        ++total;
      }
    }
    return total;
  }

  private static boolean allMatch(HashSet<Integer> file, int[] a) {

    for (int i = 0; i < a.length; i++) {
      if (!file.contains(a[i])) return false;
    }

    return true;
  }
}
