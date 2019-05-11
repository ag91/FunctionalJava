import java.util.function.*;
import java.util.*;
import java.util.stream.*;

public class FunctionalJavaFPExample {

    public static void main(String args[]){
        Function <String, Stream<Integer>> readFromDB = (String key) -> Arrays.asList(1, 2, 3, 0, -1, 100).stream(); 
        Function <Stream<Integer>, Integer> countValuableItems = (Stream<Integer> l) -> {
            long count = l.filter(e -> e <= 1).count();
            return Math.toIntExact(count);
        };
        Function <String, Integer> howManyValuableItemsInDbForKey = countValuableItems.compose(readFromDB);
        String valuableInformation = "Valuable items: " + howManyValuableItemsInDbForKey.apply("someKey");
        System.out.println(valuableInformation);
    }
}