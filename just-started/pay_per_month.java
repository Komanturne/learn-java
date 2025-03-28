public class pay_per_month {
    public static void main(String[] args)
    {
        int months = 5;
        int days_per_month = 30;
        int pay_per_month = 100;

        int total = (months*days_per_month)*pay_per_month;
        System.out.println("months: " + months);
        System.out.println("money per month: $" + pay_per_month);
        System.out.println("$" + total);
    }
}