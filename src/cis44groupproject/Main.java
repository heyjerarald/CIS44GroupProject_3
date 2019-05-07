package cis44groupproject;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author chuongtruong
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        LinkedBag<Student> studentBag = new LinkedBag<>();
        Queue<Student> waitingList = new Queue<>();
        Stack<Student> studentStack = new Stack<>();

        Student st1 = new Student("a", "b", 4.0);
        Student st2 = new Student("c", "d", 3.0);
        Student st3 = new Student("e", "f", 6.0);

        Student st4 = new Student("g", "h", 3.75);
        Student st5 = new Student("i", "j", 3.9);
        Student st6 = new Student("k", "l", 2.5);

        studentBag.add(st1);
        studentBag.add(st2);
        studentBag.add(st3);

        waitingList.enqueue(st4);
        waitingList.enqueue(st5);
        waitingList.enqueue(st6);

        Scanner input = new Scanner(System.in);
        int userChoice;
        boolean isContinue = true;
        boolean showMenu = true;
        
        while (isContinue) {
            while(showMenu)
            {
            System.out.println("WELCOME TO THE GRADEBOOK.");
            //program options
            
            System.out.println("1. See students.\n2. Add Students\n3. Ranking\n4. Accept student from waiting list.\n"
                    + "5. Find the best student\n6. Find the worst student\n10. Exit the program.");
            System.out.print("Choice: ");
            showMenu = false;
            }
            
            //enter options to continue the program
            userChoice = input.nextInt();
            switch (userChoice) {
                case 1: //See list of students
                    System.out.println("Total student is: " + studentBag.getCurrentSize());
                    System.out.println("------------------------------------------------");
                    studentBag.display();
                    System.out.println("------------------------------------------------");
                    System.out.println("");
                    break;
                case 2: //Add new student to class
                    System.out.println("Enter Student first name: ");
                    String fName = input.next();
                    System.out.println("Enter Student last name: ");
                    String lName = input.next();
                    System.out.println("Enter Student GPA: ");
                    Double GPA = input.nextDouble();
                    Student newStudent = new Student(fName, lName, GPA);
                    studentBag.add(newStudent);
                    System.out.println("");
                    break;
                case 3: //Sort the list of student in acesnding order.
                    System.out.println("List of student sorted ascendingly: ");
                    System.out.println("------------------------------------------------");
                    for (Student e : accendingSort(toArrayCasting(studentBag))) {
                        System.out.println(e);
                    }
                    System.out.println("------------------------------------------------");
                    break;
                case 4://Add student from waiting list to current list.
                    Student firstStudentFromWaitingList = waitingList.dequeue();
                    if(firstStudentFromWaitingList != null)
                    {
                        studentBag.add(firstStudentFromWaitingList);
                    }
                    else
                    {
                        System.out.println("Waiting is emtpty");
                    }
                    System.out.println("");
                    break;
                case 5:
                    for (Student s : accendingSort(toArrayCasting(studentBag))) {
                        studentStack.push(s);
                    }
                    System.out.println("The best student is: \n" + studentStack.pop().toString());
                    System.out.println("");
                    break;
                case 6:
                    for (Student s : descendingSort(toArrayCasting(studentBag))) {
                        studentStack.push(s);
                    }
                    System.out.println("The best student is: " + studentStack.pop().toString());
                    System.out.println("");
                    break;                    
                case 10:
                    isContinue = false;
                    break;
                default:
                    System.out.println("Invalid selection. %n");
            }
        }

    }

    public static <T extends Comparable<T>> T[] accendingSort(T[] arr) {
        T[] sortedList = arr;
        for (T item : sortedList) {
            for (int i = 0; i < sortedList.length - 1; i++) {
                if (sortedList[i].compareTo(sortedList[i + 1]) > 0) {
                    T temp = arr[i];
                    sortedList[i] = arr[i + 1];
                    sortedList[i + 1] = temp;
                }
            }
        }
        return sortedList;
    }
    
    public static <T extends Comparable<T>> T[] descendingSort(T[] arr) {
        T[] sortedList = arr;
        for (T item : sortedList) {
            for (int i = 0; i < sortedList.length - 1; i++) {
                if (sortedList[i].compareTo(sortedList[i + 1]) < 0) {
                    T temp = arr[i];
                    sortedList[i] = arr[i + 1];
                    sortedList[i + 1] = temp;
                }
            }
        }
        return sortedList;
    }
    
    //Casting method
    public static <T> Student[] toArrayCasting(LinkedBag<T> inputBag)
    {
        Object[] rawStudentData = inputBag.toArray();
        Student currentStudent;
        Student[] toArrayStudent = new Student[rawStudentData.length];
        for (int i = 0; i < rawStudentData.length; i++) {
            currentStudent = (Student) rawStudentData[i];
            toArrayStudent[i] = currentStudent;
        }
        return toArrayStudent;
    }
    
    //clear console

}
