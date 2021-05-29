import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

//Работа с целочисленным массивом с помощью стримов
public class IntegerArrayList {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i < 20; i++){
            nums.add(r.nextInt(10));
        }
        System.out.println(nums);

        System.out.println(nums.stream().distinct().collect(Collectors.toList()));
        System.out.println(nums.stream().distinct().filter((n) -> n>=7 && n<=14).filter((n)-> n%2==0).collect(Collectors.toList()));
        System.out.println(nums.stream().distinct().map((n)->n*2).collect(Collectors.toList()));
        System.out.println(nums.stream().sorted().limit(4).collect(Collectors.toList()));
        System.out.println(nums.stream().count());
        System.out.println(nums.stream().mapToInt(i -> i).average().getAsDouble());
    }
}
