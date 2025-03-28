import java.lang.Math;

public class lenght_of_side_triangle {
    public static void main(String[] args) {

        //a^2 + b^2 = c^2

        int a = 1; //defines the length of the base
        int b = 2; //defines the length of the height
        int c; //defines the hypotenous

        c = ((a*a)+(b*b)); //a^2 + b^2
        System.out.println(Math.sqrt(c)); // = c^2

    }
    
}
