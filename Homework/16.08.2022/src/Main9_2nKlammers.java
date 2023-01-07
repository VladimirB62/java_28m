/* Дано целое число n (0<n<8). Требуется вывести все правильные скобочные последовательности длины 2n.
В задаче используются только круглые скобки
 */

public class Main9_2nKlammers {
    public static void main(String[] args) {

       // solution(5);

        int n = 3;
        solutionWihtRecursion(n*2,"",0);
    }

    public static void solution(int n) {
        n = n * 2;
        int num1 = (int) Math.pow(2, n - 1);
        int num2 = (int) Math.pow(2, n);
        for (int i = num1; i < num2; i += 2) {
            String binary = Integer.toBinaryString(i);
            if (stringsCheck(binary)) {
                System.out.println(toBracketsString(binary));
            }
        }
    }

    public static boolean stringsCheck(String str) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            counter = (str.charAt(i) == '1') ? counter + 1 : counter - 1;
            if (counter < 0) return false;
        }
        return counter == 0;
    }

    public static String toBracketsString(String str) {
        return str.replaceAll("1", "(")
                .replaceAll("0", ")");
    }


    public  static void solutionWihtRecursion(int n, String s, int openBrackets) {
        if (s.length()==n){
            System.out.println(s);
            return;
        }
        if (n>s.length()+openBrackets){
            solutionWihtRecursion(n,s + "(", openBrackets +1);
        }
        if (openBrackets > 0) {
            solutionWihtRecursion(n, s + ")",openBrackets-1);
        }
    }
}


