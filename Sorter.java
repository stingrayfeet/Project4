
public class Sorter {

    //sorting method that returns an Employee[] array
    public static Employee[] sort(Employee[] a) {
        Employee temp;

        //insertion sort used to alphabetically sort the Employee[] array
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].getName().compareToIgnoreCase(a[j - 1].getName()) < 0) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        //returns sorted Employee[] array
        return a;
    }
}
