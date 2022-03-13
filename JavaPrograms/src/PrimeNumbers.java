import java.util.Scanner;

public class PrimeNumbers {
    boolean isPrime(int num) {
        boolean flag = true;
        for(int i=2;i<num;i++){
            if(num%i == 0)
                flag = false;
        }
        return flag;
    }


    public static void main(String args[]){
        PrimeNumbers checkPrime = new PrimeNumbers();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(checkPrime.isPrime(a))
            System.out.println("Given Number "+a+" is Prime");
        else
            System.out.println("Given Number "+a+" is Not Prime");
    }
}
