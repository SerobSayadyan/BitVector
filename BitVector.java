public class BitVector {
    private int size;
    private static int[] arr;
    private double tmpMathPower;

    public BitVector(int inputSize){                //Constructor for setting the size of array
        this.size = inputSize / 32 + 1;
        this.arr = new int[this.size];
    }
    public void set(int inputPosition){ // example. inputPosition == 100
        System.out.println("\nThe Binary representation of the Vector before");
        printToBinary(arr);                        // Primary printing the binary representation of selected element
        int index = (inputPosition / 32);              // example. (if inputPosition == 100) 100 / 32 == 3 (hence index = 3)
        int position = (inputPosition - ((inputPosition / 32) * 32));  //100 - ((100 / 32) * 32) (hence position == (100 - 96) == 4)
        int tmp = (arr[index] << ((inputPosition / 32 + 1) * 32) - (inputPosition)); //arr[3] << 28
        tmp = (tmp >>> ((inputPosition / 32 + 1) * 32) - (inputPosition)); //tmp >>> 28
        arr[index] = arr[index] >>> position | 1;  // arr[3] >>> 4 | 1
        arr[index] = arr[index] << position | tmp; // arr[3] << 4 | tmp
        tmpMathPower += Math.pow(2.0, (double)inputPosition);
        System.out.println("The Binary representation of Vector");
        printToBinary(arr);                       // Secondary printing the binary representation of selected element
        System.out.println("The decimal representation of the number - " + tmpMathPower);
    }
    public void reset(int inputPosition) {
        System.out.println("\nThe Binary representation of the Vector before");
        printToBinary(arr);
        int index = (inputPosition / 32);
        int position = (inputPosition - ((inputPosition / 32) * 32));
        if (position < 31 && position > 0) {
            int tmp = (arr[index] << (((inputPosition / 32 + 1) * 32) - (inputPosition)));
            tmp = (tmp >>> (((inputPosition / 32 + 1) * 32) - (inputPosition)));
            int tmp2 = (arr[index] >>> (position + 1)); // 
            tmp2 = (tmp2 << (position + 1)); 
            int res = tmp2 | tmp;
            if ((arr[index] >>> position & 1) == 1) {
                arr[index] = res;
                tmpMathPower -= Math.pow(2.0, (double) inputPosition);
            }
        } else if (position == 31){
            int tmp = arr[index] << 1;
            tmp = tmp >>> 1;
            arr[index] = tmp;
            tmpMathPower -= Math.pow(2.0, (double) inputPosition);
        } else if (position == 0) {
            int tmp = arr[index] >>> 1;
            tmp = tmp << 1;
            arr[index] = tmp;
            tmpMathPower -= Math.pow(2.0, (double) inputPosition);
        }
        System.out.println("The Binary representation of Vector");
        printToBinary(arr);
        System.out.println("The decimal representation of the number - " + tmpMathPower);
    }
    private void printToBinary(int[] array){
        for (int i = (array.length - 1); i >= 0; i--) {
            for (int j = 31; j >= 0; j--) {
                System.out.print(array[i] >> j & 1);
                if (i != 0){
                    if (j % 8 == 0) {
                        System.out.print("_");
                    }
                }else{
                    if (j % 8 == 0 && j != 0) {
                        System.out.print("_");
                    }
                }
            }
        }
        System.out.println();
    }
}
