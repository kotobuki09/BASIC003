import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // LEAVE UNTOUCHED
        Scanner sc = new Scanner(System.in);
        int numberOfTestCases = sc.nextInt();
        sc.nextLine();

        // BEGIN problem

        while (numberOfTestCases-- > 0) {
            String input = sc.nextLine();
            // Biến để lưu tổng số chữ số
            int digitCount = 0;
            // Duyệt qua từng ký tự trong chuỗi
            for (int i = 0; i < input.length(); i++) {
                // Kiểm tra xem ký tự có phải là chữ số không
                if (Character.isDigit(input.charAt(i))) {
                    digitCount++;
                }
            }
            System.out.println(digitCount);
        }

        // TEAR DOWN
        sc.close();
    }
}