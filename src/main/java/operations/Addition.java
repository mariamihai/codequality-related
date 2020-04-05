package operations;

public class Addition {

    public static Integer add(Integer a, Integer b) {
        if(validInteger(a) && validInteger(b)) {
            return a + b;
        }

        throw new IllegalArgumentException("Invalid Integer");
    }

    public static boolean validInteger(Integer number) {
        return number != null;
    }
}