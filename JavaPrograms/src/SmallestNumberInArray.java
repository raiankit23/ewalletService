import java.util.Arrays;

public class SmallestNumberInArray {
    int SmallNum(int arr[]){
        Arrays.sort(arr);
        return arr[0];
    }

    public static void main(String[] args) {
        SmallestNumberInArray smallNum = new SmallestNumberInArray();
        int array[] = {2, 5, 1 ,3, 0};
        int num;
        num = smallNum.SmallNum(array);
        System.out.println("Smallest Number from Array = "+ num);
    }
}

