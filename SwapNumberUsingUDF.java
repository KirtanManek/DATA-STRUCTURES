import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Swap {
    public void swapNumbers(int x, int y) {
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("\nAfter Swapping : ");
        System.out.println("1st number : " + x);
        System.out.println("2nd number : " + y);
    }
}

public class SwapNumberUsingUDF {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Swap s = new Swap();
        System.out.print("Enter 1st number : ");
        int x = Integer.parseInt(br.readLine());
        System.out.print("Enter 2nd number : ");
        int y = Integer.parseInt(br.readLine());

        s.swapNumbers(x, y);
    }
}
