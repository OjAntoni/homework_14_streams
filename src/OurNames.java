import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

//Работа с массивом строк с помощью стримов
public class OurNames {
    public static void main(String[] args) {
        List<String> group = new ArrayList<>(Arrays.asList(
                "Anton", "Maria", "Anatolii", "Vitaly", "Olga", "Egor",
                "Andrew", "Julia", "Tasja", "Aina", "Svetlana", "Aleksandr",
                "Evgenii", "Vitaly", "Mary", "Lera", "Katharina"
                ));

        System.out.println(countSameNames(group,"vitaly"));
        System.out.println(countSameNames(group,"andrew"));

        System.out.println(getSpecialNames(group, "a"));
        System.out.println(getSpecialNames(group, "E"));

        System.out.println(firstAlphabetic(group));
    }

    private static int countSameNames(List<String> names, String name){
       return (int)names.stream().map(String::toUpperCase).filter(name.toUpperCase()::equals).count();
    }

    private static List<String> getSpecialNames(List<String> names, String letter){
        return names.stream().filter(name -> name.toUpperCase(Locale.ROOT).startsWith(letter.toUpperCase(Locale.ROOT))).collect(Collectors.toList());
    }

    private static String firstAlphabetic(List<String> names){
        Optional<List<String>> listOptional = Optional.ofNullable(names);
        if(listOptional.isEmpty()) return "Empty";
        return listOptional.get().stream().sorted().collect(Collectors.toList()).get(1);
    }
}
