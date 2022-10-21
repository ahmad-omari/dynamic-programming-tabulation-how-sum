import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : Ahmad Al-Omari
 * @mailto : alomari.ah98@gmail.com
 * @created : 10/22/2022, Saturday
 * @project : dynamic-programming-tabulation-how-sum
 **/
public class HowSum {

    public static ArrayList<Integer> howSum(int target, List<Integer> numbers) {
        ArrayList<ArrayList<Integer>> table = new ArrayList<>(Collections.nCopies(target+1, null));
        table.add(0, new ArrayList<>());

        for (int i = 0; i <= target; i++) {
            if (table.get(i) != null){
                for (Integer num : numbers) {
                    ArrayList<Integer> clonedList = (ArrayList<Integer>) table.get(i).clone();
                    clonedList.add(num);
                    if ((i+num) <= target) {
                        table.set((i + num), clonedList);
                    }
                }
            }
        }
        return table.get(target);
    }
    public static void main(String[] args) {
        System.out.println(howSum(7, Arrays.asList(2, 3)));
        System.out.println(howSum(7, Arrays.asList(5, 3, 4, 7)));
        System.out.println(howSum(7, Arrays.asList(2, 4)));
        System.out.println(howSum(8, Arrays.asList(2, 3, 5)));
        System.out.println(howSum(300, Arrays.asList(7, 14)));
    }
}
