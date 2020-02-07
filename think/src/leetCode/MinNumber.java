package LeetCode;

public class MinNumber {
    public String PrintMinNumber(int [] numbers) {
        int length = numbers.length;
        String str = "";
        if(length == 0){
            return str;
        }
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length - i - 1; j++){
                String str1 = String.valueOf(numbers[j]) + String.valueOf(numbers[j+1]);
                String str2 = String.valueOf(numbers[j+1]) + String.valueOf(numbers[j]);
                System.out.println(str1 + " " + str2);
//                Integer a = Integer.parseInt(str1.trim());
//                Integer b = Integer.parseInt(str2.trim());
                if(Long.valueOf(str1) > Long.valueOf(str2)){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        for(int i = 0; i < length; i++){
            str += String.valueOf(numbers[i]);
        }
        System.out.println(str);
        return str;
    }
    public static void main(String[] args){
        MinNumber minNumber = new MinNumber();
        int[] numbers = {3334,3,3333332};
        minNumber.PrintMinNumber(numbers);
    }
}
