import java.util.Scanner;
public class CallBitVector {
    public static void call() {
        Scanner console = new Scanner(System.in);
        int sizeVector;
        do {
            System.out.print("Please enter the size of Vector - ");
            sizeVector = console.nextInt();
        } while (sizeVector <= 0);
        BitVector bitVector = new BitVector(sizeVector);
        int num;
        boolean isTrue = true;
        while (isTrue) {
            do {
                System.out.println();
                System.out.println("For ending the program enter - 0\n" +
                        "For setting 1 in a bit enter - 1\n" +
                        "For resetting the bit please enter - 2");
                num = console.nextInt();
            }while (num > 2 && num < 0);
            if (num == 0) {
                isTrue = false;
            } else if (num == 1) {
                System.out.print("\nPlease set the bit position - ");
                bitVector.set(console.nextInt());
            } else if (num == 2) {
                System.out.print("\nPlease reset the bit position - ");
                bitVector.reset(console.nextInt());
            }
        }
        System.out.println("You finished the program");

    }
}
