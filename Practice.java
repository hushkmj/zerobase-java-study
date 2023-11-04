import java.util.ArrayList;

class MySet {
    //Arraylist
    ArrayList<Integer> list;

    //생성자1
    MySet() {
        this.list = new ArrayList<Integer>();
    }

    //생성자2
    MySet(int[] arr) {
        this.list = new ArrayList<Integer>();

        for (int item : arr) {
            this.list.add(item);
        }
    }

    /*
     * 원소추가(중복제외)
     * 리스트에 입력매게변수와 동일한 값이 존재할경우 함수종료
     */
    public void add(int x) {
        for (int item : this.list) {
            if (item == x) {
                return;
            }
        }
        this.list.add(x);
    }

    /*
     * 교집합
     * 두 집합이 공통으로 포함하는 원소로 이루어진 집합
     * A리스트와 B리스트의 공통된 원소만 새로운 리스트에 추출하여 리턴한다.
     */
    public MySet retainAll(MySet b) {
        MySet result = new MySet();
        for (int itemA : this.list
        ) {
            for (int itemB : b.list
            ) {
                if (itemA == itemB) {
                    result.add(itemA);
                }
            }
        }
        return result;
    }

    /*
    * 합집합
    * 어느 하나에라도 속하는 원소들을 모두 모은 집합
    */
    public MySet addAll(MySet b){
        MySet result = new MySet();

        for (int itemA: this.list
             ) {
            result.add(itemA);
        }
        for (int itemB: b.list
             ) {
            result.add(itemB);
        }

        return result;
    }
    /*
    * 차집합
    * A집합과 B집합중 교집합 제외한 A에만 속하는 원소를 모은 집합
    */
    public MySet removeAll(MySet b){
        MySet result = new MySet();

        for (int itemA: this.list
             ) {
            boolean containFlag = false;
            for (int itemB: b.list
                 ) {
                if(itemA == itemB){
                    containFlag = true;
                    break;
                }
            }
            if(!containFlag){
                result.add(itemA);
            }
        }
        return result;
    }

}

public class Practice {
    public static void main(String[] args) {
        System.out.println("start test code");

        MySet a = new MySet();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(2);
        System.out.println("add result: " + a.list);

        a = new MySet(new int[]{1, 3, 5, 7, 9});
        MySet b = new MySet(new int[]{2, 4, 6, 8, 10, 1, 3, 5});
        System.out.println(a.list);
        System.out.println(b.list);

        System.out.println("add retainAll: " +a.retainAll(b).list);
        System.out.println("add addAll: " +a.addAll(b).list);

        System.out.println("add removeAll: " +a.removeAll(b).list);
    }
}
