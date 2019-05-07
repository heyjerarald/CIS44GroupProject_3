package cis44groupproject;

/**
 *
 * @author chuongtruong
 */
public class DummyMethod {
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
}
