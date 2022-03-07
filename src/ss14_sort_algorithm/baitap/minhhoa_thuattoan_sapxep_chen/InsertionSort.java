package ss14_sort_algorithm.baitap.minhhoa_thuattoan_sapxep_chen;

public class InsertionSort {
    void sort(int array[]) {
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;


            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }


    static void printArray(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");

        System.out.println();
    }

    public static void main(String args[]) {
        int array[] = { 0, 9, 3, 8, -1, 2, 10, -9 };
        System.out.println("Mảng ban đầu:");
        printArray(array);
        InsertionSort ob = new InsertionSort();
        ob.sort(array);
        System.out.println("Mảng sau khi sắp xếp:");
        printArray(array);
    }
}
