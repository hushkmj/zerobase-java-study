import java.util.ArrayList;

/*
* 약수 구하, 두 수의 최대공약수와 최소공배수 구하기
* 활용) 1-10의 수 중 A의 약수 또는 8의 약수인 경우의 수
* 활용) 1-10의 수 중 A의 약수이면서 8의 약수인 경우의 수
* */
public class Practice3 {

//    약수
    public ArrayList<Integer> getDivisor(int num){
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 1 ; i <= (int)num/2; i++){
            if(num % i == 0) {
                result.add(i);
            }
        }
        result.add(num);

        return result;
    }

//  최대 공약수
//  GCD: the  Greatest Common Denominaotor
    public int getGCD(int numA, int numB){
        int gcd = -1;

        ArrayList<Integer> divisionA = this.getDivisor(numA);
        System.out.println(divisionA);
        ArrayList<Integer> divisionB = this.getDivisor(numB);
        System.out.println(divisionB);

        for (int itemA: (ArrayList<Integer>)divisionA
        ) {
            for (int itemB: (ArrayList<Integer>)divisionB
            ) {
                if(itemA == itemB) {
                    if (itemA > gcd) {
                        gcd = itemA;
                    }
                }
            }
        }

        return gcd;
    }
//  최소 공배수
//  LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;

        int gcd = this.getGCD(numA, numB);

        if(gcd != -1) {
            lcm = numA * numB / gcd;
        }

        return lcm;
    }

    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 6;

        Practice3 p = new Practice3();
        ArrayList<Integer> l1 = p.getDivisor(number1);
        ArrayList<Integer> l2 = p.getDivisor(number2);

        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대공약수: " + p.getGCD(number1, number2));
        System.out.println("최소공배수: " + p.getLCM(number1, number2));
    }
}
