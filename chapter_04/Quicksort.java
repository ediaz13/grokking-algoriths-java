package chapter_04;

import java.util.ArrayList;
import java.util.List;

public class Quicksort {
    public static List<Integer> quicksort(List<Integer> array) {
        if (array.size() < 2) {
            return array;
        } else {
            int pivot = array.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> greater = new ArrayList<>();

            for (int i = 1; i < array.size(); i++) {
                if (array.get(i) <= pivot) {
                    less.add(array.get(i));
                } else {
                    greater.add(array.get(i));
                }
            }

            return concatenateLists(quicksort(less), pivot, quicksort(greater));
        }
    }

    private static List<Integer> concatenateLists(List<Integer> less, int pivot, List<Integer> greater) {
        List<Integer> numbers = new ArrayList<>(less);
        numbers.add(pivot);
        numbers.addAll(greater);
        return numbers;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(2);
        numbers.add(3);
        numbers.add(7);
        numbers.add(6);
        numbers.add(8);
        numbers.add(9);
        numbers.add(1);
        numbers.add(4);

        System.out.println(quicksort(numbers));
    }

}
