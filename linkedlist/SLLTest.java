import java.util.Locale;

public class SLLTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String a = "asd";
        System.out.println(a);
        String upperCasedA =  a.toUpperCase(Locale.CHINA);
        System.out.println(upperCasedA);
    }
}
