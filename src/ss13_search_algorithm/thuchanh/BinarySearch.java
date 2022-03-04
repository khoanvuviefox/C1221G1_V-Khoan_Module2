package ss13_search_algorithm.thuchanh;

public class BinarySearch {
    static int[] list = {2, 4, 7, 10, 55, 66, 77, 88, 89, 92};
    static int binarySearch (int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return  -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(list, 2));
        System.out.println(binarySearch(list, 5));
        System.out.println(binarySearch(list, 89));
    }
}
