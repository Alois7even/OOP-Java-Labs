
public class ArrayAccess {
    static int safeGet(int[] arr, int index) {
        try {
            return arr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bad index: " + e.getMessage());
            return -1;                                // sentinel meaning "not found"
        }
    }

    public static void main(String[] args) {
        int[] data = {10, 20, 30};
        System.out.println(safeGet(data, 1));
        System.out.println(safeGet(data, 7));
    }
}