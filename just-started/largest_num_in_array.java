public class largest_num_in_array {
    public static void main(String[] args) {

        int i = 0; //defines i
        int[] arr = {18, 5, 19, 123, 1}; //gives array
        int x = arr[i]; //sets x to the first value

        for (i = 0; i < 5; i++) {
            System.out.println(x); //prints the first value

            if (x < arr[i]) 
            {
                x = arr[i]; //if the value is greater than x, changes value to x
            }
            else
            {
                //nothing
            }
        }

    }
}