package Advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ForEach {

    public static void main(String[] args) {
        ForEach.removeNumberFromListWithStream();
        ForEach.removeNumberFromListBasic();
    }

    private static void removeNumberFromListWithStream() {
        Integer[] numbers = {2, 4, -3, 5, -6};
        List<Integer> numberList = Arrays.asList(numbers);

        List<Integer> positiveNumbers = numberList.stream()
            .filter(number -> number >= 0)
            .collect(Collectors.toList());

        System.out.println("Filter number list with java Stream");
        System.out.println(numberList);
        System.out.println(positiveNumbers);
    }

    private static void removeNumberFromListBasic() {
        Integer[] numbers = {2, 4, -3, 5, -6};
        List<Integer> numberList = new ArrayList<>(Arrays.asList(numbers));
        List<Integer> negativeNumbers = new ArrayList<>();

        for (Integer number : numberList) {
            if (number < 0) negativeNumbers.add(number);
        }

        numberList.removeAll(negativeNumbers);

        System.out.println("Filter number list with basic foreach");
        System.out.println(Arrays.asList(numbers));
        System.out.println(numberList);
    }

}
