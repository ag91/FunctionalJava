import java.util.function.*;

public class FunctionalJavaDefaultComposition {

    public static void main(String args[]){
        Function <Void, String> h = (Void v) -> "Hello";
        Function <String, String> w = (String s) -> s + "World"; 
        String x = w.compose(h).apply(null);
        System.out.println(x);
    }
}