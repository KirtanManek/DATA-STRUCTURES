import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Pattern2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        int maxNumber = n * (n + 1) / 2;
        System.out.println(maxNumber);
        List<List<Integer>> l = new ArrayList<>();
        int count = n;
        while (count != 0) {
            List<Integer> l1 = new ArrayList<>();
            for(int j = 0; j < count; j++){
                l1.add(maxNumber);
                maxNumber--;
            }
            count--;
            l.add(l1);

            if(count == 0) break;

            List<Integer> l2 = new ArrayList<>();
            int temp = maxNumber - count + 1;
            maxNumber -= count;
            for(int j = 0; j < count; j++){
                l2.add(temp);
                temp++;
            }
            count--;
            l.add(l2);
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                System.out.print(l.get(i - j).get(j) + " ");
            }
            System.out.println();
        }
    }
}