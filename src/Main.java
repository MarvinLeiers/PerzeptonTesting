import java.util.Random;
import java.util.Scanner;

public class Main
{
    private static Random random = new Random();

    static int x0 = 1;
    static double w0 = 0;
    static double w1 = 0;
    static double alpha = 0.1;

    public static void main(String[] args)
    {
        learn();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte gebe eine Zahl ein!");

        while (true)
        {
            int check = scanner.nextInt();

            System.out.println(h(check * w1 + w0) == 1 ? "JA!" : "NEIN!");

            String wait = scanner.nextLine();
        }
    }

    private static void learn()
    {
        for (int i = 0; i < 100000; i++)
        {
            int x1 = random.nextInt(100);

            double h = h(w0 * x0 + w1 * x1);

            //System.out.println("w0: " + w0 + ", w1: " + w1 + "\n\tx1: " + x1 + " e: " + erwartet(x1) + " l: " + h);

            w0 += alpha * x0 * (erwartet(x1) - h);
            w1 += alpha * x1 * (erwartet(x1) - h);
        }

        System.out.println(w1 + " * x + " + w0);
    }

    private static double erwartet(int x1)
    {
        return x1 <= 50 ? 1 : 0;
    }

    private static double h(double h)
    {
        return h >= 0 ? 1 : 0;
    }
}
