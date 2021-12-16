import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int alphabetCount = scanner.nextInt();
        String questionAlphabet = scanner.next();
        String answerAlphabet = scanner.next();

        if (questionAlphabet.equals(answerAlphabet))
            System.out.println(0);
        else {
            char[] questionCharArray = questionAlphabet.toCharArray();
            char[] answerCharArray = answerAlphabet.toCharArray();
            int wrongCounter = 0;
            for (int i = 0; i < alphabetCount; i++) {
                if (questionAlphabet.charAt(i) != answerAlphabet.charAt(i))
                    wrongCounter++;
            }
            System.out.println(wrongCounter);
        }
    }
}
