import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bubblesort {

    static void bubble_sort(List<Integer> data) {
        int n = data.size();

        for (int i = 0; i < n - 1; ++i) {
            int ptr = 0;

            while (ptr < n - 1 - i) {
                if (data.get(ptr) > data.get(ptr + 1)) {
                    Collections.swap(data, ptr, ptr + 1);
                }

                ptr++;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>(List.of(120, 32, 254, 25));

        bubble_sort(temp);

        System.out.println(temp);
    }
}
