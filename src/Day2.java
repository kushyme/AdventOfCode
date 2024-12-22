import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Day2 {

    public static void main(String[] args) {
        ArrayList<Integer> array1 = new ArrayList<>();
        int safeCounter = 0;
        int unsafeCounter = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("input2.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] numbers = line.trim().split("\\s+");
                for (String number : numbers) {
                    array1.add(Integer.parseInt(number));
                }

                if ((decreasing(array1) && !increasing(array1)) || (!decreasing(array1) && increasing(array1))) {
                    safeCounter++;
                } else {
                    unsafeCounter++;
                }

                array1.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(safeCounter);
        System.out.println(unsafeCounter);
    }

    public static boolean increasing(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            int diff = array.get(i + 1) - array.get(i);
            if (diff < 1 || diff > 3) {
                return false;
            }
            if (array.get(i) >= array.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean decreasing(ArrayList<Integer> array) {
        for (int i = 0; i < array.size() - 1; i++) {
            int diff = array.get(i) - array.get(i + 1);
            if (diff < 1 || diff > 3) {
                return false;
            }
            if (array.get(i) <= array.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    
// part 1
//    public static boolean increasing(ArrayList<Integer> array) {
//        for (int i = 0; i < array.size() - 1; i++) {
//            int diff = array.get(i + 1) - array.get(i);
//            if (diff < 1 || diff > 3) {
//                return false;
//            }
//            if (array.get(i) >= array.get(i + 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean decreasing(ArrayList<Integer> array) {
//        for (int i = 0; i < array.size() - 1; i++) {
//            int diff = array.get(i) - array.get(i + 1);
//            if (diff < 1 || diff > 3) {
//                return false;
//            }
//            if (array.get(i) <= array.get(i + 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
