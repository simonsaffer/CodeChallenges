/**
 * Created by simonsaffer on 2016-03-09.
 */
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student implements Comparable<Student> {
  private int token;
  private String fname;
  private double cgpa;
  public Student(int id, String fname, double cgpa) {
    super();
    this.token = id;
    this.fname = fname;
    this.cgpa = cgpa;
  }
  public int getToken() {
    return token;
  }
  public String getFname() {
    return fname;
  }
  public double getCgpa() {
    return cgpa;
  }

  @Override
  public int compareTo(Student that) {
    if(this.cgpa != that.cgpa) return Double.compare(that.cgpa, this.cgpa);
    else if(!this.fname.equals(that.fname)) return this.fname.compareTo(that.fname);
    else return Integer.compare(this.token, that.token);
  }
}

public class Students {

  public static void main(String[] args) {

    Locale.setDefault(Locale.CANADA);

    Scanner in = new Scanner(System.in);
    int totalEvents = Integer.parseInt(in.nextLine());

    PriorityQueue<Student> q = new PriorityQueue<>();

    while(totalEvents>0){
      String event = in.next();

      if(event.equals("ENTER")) {
        String name = in.next();
        double gpa = in.nextDouble();
        int id = in.nextInt();
        q.add(new Student(id, name, gpa));
      } else {
        q.poll();
      }

      totalEvents--;
    }
    boolean empty = q.isEmpty();
    if(empty) System.out.println("EMPTY");
    while(!q.isEmpty()) {
      Student s = q.poll();
      System.out.println(s.getFname());
    }
  }

}

