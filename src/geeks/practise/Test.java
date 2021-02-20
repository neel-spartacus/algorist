package geeks.practise;

public class Test {

    int fact(int n){
        int result;
        if(n==1){
            return 1;
        }

        result=fact(n-1)*n;
        return result;
    }
}

class Output {
    public static void main(String[] args) {
        Test obj= new Test();
        System.out.println(obj.fact(1));
    }
}
