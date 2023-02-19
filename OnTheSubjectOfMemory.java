
public class OnTheSubjectOfMemory {


    public static void main(String[] args) {
        int[][] input = {{1,3,2,4,1},
                {3,1,2,4,3},
                {2,3,4,1,2},
                {2,1,4,3,1},
                {4,1,2,3,4}};

        System.out.println(decode(input));
    }

    static String decode(int[][] input){
        StringBuilder sb = new StringBuilder();
        int[] temp1 = stage1(input[0]);
        int lb1 = temp1[0];
        int pos1 = temp1[1];

        sb.append(lb1);

        int[] temp2 = stage2(input[1], pos1);
        int lb2 = temp2[0];
        int pos2 = temp2[1];

        sb.append(lb2);

        int[] temp3 = stage3(input[2], lb1, lb2);
        int lb3 = temp3[0];
        int pos3 = temp3[1];

        sb.append(lb3);

        int[] temp4 = stage4(input[3], pos1, pos2);
        int lb4 = temp4[0];
        int pos4 = temp4[1];

        sb.append(lb4);

        int[] temp5 = stage5(input[4], pos1, pos2, pos3, pos4);

        sb.append(temp5[0]);
        return sb.toString();
    }

    static int[] stage1(int[] input){
        int[] output = new int[2];
        switch (input[4]){
            case 1,2 -> {
                output[0] = input[1];
                output[1] = 1;
            }
            case 3 -> {
                output[0] = input[2];
                output[1] = 2;
            }
            case 4 -> {
                output[0] = input[3];
                output[1] = 3;
            }
        }
        return output;
    }

    static int[] stage2(int[] input, int pos1){
        int[] output = new int[2];
        switch (input[4]){
            case 1 -> {
                output[0] = 4;
                output[1] = findIndex(input, 4);
            }
            case 2, 4 -> {
                output[0] = input[pos1];
                output[1] = pos1;
            }
            case 3 -> {
                output[0] = input[0];
                output[1] = 0;
            }
        }
        return output;
    }

    static int[] stage3(int[] input, int lb1, int lb2){
        int[] output = new int[2];
        switch (input[4]){
            case 1 -> {
                output[0] = lb2;
                output[1] = findIndex(input, lb2);
            }
            case 2 -> {
                output[0] = lb1;
                output[1] = findIndex(input, lb1);;
            }
            case 3 -> {
                output[0] = input[2];
                output[1] = 2;
            }
            case 4 -> {
                output[0] = 4;
                output[1] = findIndex(input, 4);;
            }
        }
        return output;
    }

    static int[] stage4(int[] input, int pos1, int pos2){
        int[] output = new int[2];
        switch (input[4]){
            case 1 -> {
                output[0] = input[pos1];
                output[1] = pos1;
            }
            case 2 -> {
                output[0] = input[0];
                output[1] = 0;;
            }
            case 3, 4 -> {
                output[0] = input[pos2];
                output[1] = pos2;
            }
        }
        return output;
    }

    static int[] stage5(int[] input, int pos1, int pos2, int pos3, int pos4){
        int[] output = new int[2];
        switch (input[4]){
            case 1 -> {
                output[0] = input[pos1];
                output[1] = pos1;
            }
            case 2 -> {
                output[0] = input[pos2];
                output[1] = pos2;
            }
            case 3 -> {
                output[0] = input[pos3];
                output[1] = pos3;
            }
            case 4 -> {
                output[0] = input[pos4];
                output[1] = pos4;
            }
        }
        return output;
    }

    static int findIndex(int[] arr, int t){
        if (arr == null) {
            return -1;
        }

        int len = arr.length;
        int i = 0;

        while (i < len) {

            // if the i-th element is t
            // then return the index
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
}
