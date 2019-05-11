import java.util.function.*;

public class FunctionalJavaComposition {

    public static <A,B,C> Function<A,C> composition(Function<A,B> f, Function<B,C> g){
      return (A a) -> g.apply(f.apply(a));
    }

    public static void main(String args[]){
        Function <Void, String> fnProducingString = v -> "Complex";
        Function <String, String> fnConcatenatingThing = s -> {
            String thing = "Thing";
            return s + thing;
        };
        Function <Void, String> fnMakingComplexThing = FunctionalJavaComposition.composition(fnProducingString, fnConcatenatingThing); // fnConcatenatingThing.compose(fnProducingString);
        String complexThing = fnMakingComplexThing.apply(null);
        System.out.println(complexThing);
    }
}