import java.util.Scanner;
public class CallBitVector {
    public static void call() {
        Scanner console = new Scanner(System.in);
        int sizeVector;
        do {
            System.out.print("Please enter the SIZE of Vector - ");
            sizeVector = console.nextInt();
        } while (sizeVector <= 0);
        BitVector bitVector = new BitVector(sizeVector);
        int num;
        boolean isTrue = true;
        while (isTrue) {
            do {
                System.out.println();
                System.out.print("Do you want change to 1 or 0 (Enter 2 for ending the program) - ");
                num = console.nextInt();
                System.out.println();
            }while (num > 2 && num < 0);
            if (num == 2) {
                isTrue = false;
            } else if (num == 1) {
                do {
                    int inputPosition;
                    do {
                        System.out.print("\nPlease enter the bit POSITION (starting from 0 to SIZE) - ");
                        inputPosition = console.nextInt();
                    }while (inputPosition > (sizeVector));
                    bitVector.set(inputPosition);
                }while (num < 0);
            } else if (num == 0) {
                do {
                    int inputPosition;
                    do{
                        System.out.print("\nPlease enter the bit POSITION (starting from 0 to SIZE) - ");
                        inputPosition = console.nextInt();
                    }while (inputPosition > (sizeVector));
                    bitVector.reset(inputPosition);
                }while (num < 0);
            }
        }
        System.out.println("You've finished the program");
    }
}
