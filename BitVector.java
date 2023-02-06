public class BitVector {
    private int size;
    private static int[] arr;
    private int position;
    private int index;
    public BitVector(int inputSize){                //Constructor for setting the size of array
        this.size = inputSize / 32 + 1;
        this.arr = new int[this.size];
    }
    public void set(int inputPosition){ // example. inputPosition == 100
        System.out.println("The binary expression of set is");
        toBinary(arr[index]);                      // Primary printing the binary representation of selected element
        index = (inputPosition / 32);              // example. (if inputPosition == 100) 100 / 32 == 3 (hence index = 3)
        position = (inputPosition - ((inputPosition / 32) * 32));  //100 - ((100 / 32) * 32) (hence position == (100 - 96) == 4)
        int tmp = (arr[index] << ((inputPosition / 32 + 1) * 32) - (inputPosition)); //arr[3] << 28
        tmp = (tmp >>> ((inputPosition / 32 + 1) * 32) - (inputPosition)); //tmp >>> 28
        arr[index] = arr[index] >>> position | 1;  // arr[3] >>> 4 | 1
        arr[index] = arr[index] << position | tmp; // arr[3] << 4 | tmp
        System.out.println("The array number of set is - " + arr[index]);
        System.out.println("Binary of set");
        toBinary(arr[index]);                       // Secondary printing the binary representation of selected element
    }
    public void reset(int inputPosition) {
        System.out.println("\nthe binary expression of reset\n");
        toBinary(arr[index]);
        index = (inputPosition / 32);
        position = (inputPosition - ((inputPosition / 32) * 32));
        int tmp = (arr[index] << (((inputPosition / 32 + 1) * 32) - (inputPosition)));
        tmp = (tmp >> ((inputPosition / 32 + 1) * 32) - (inputPosition));
        int tmp2 = (arr[index] >>> (position + 1));
        tmp2 = tmp | tmp2;
        if ((arr[index] >> position & 1) == 1){
            arr[index] = tmp2;
        }
        System.out.println("Binary of reset");
        toBinary(arr[index]);
    }
    private void toBinary(int num){
        for (int i = 31; i >= 0; i--) {
            System.out.print(num >> i & 1);
            if (i % 8 == 0 && i != 0){
                System.out.print("_");
            }
        }
        System.out.println();
    }
}
