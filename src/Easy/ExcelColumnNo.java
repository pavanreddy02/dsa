package src.Easy;

public class ExcelColumnNo {
    public static void main(String[] args) {
//        System.out.println(answer("AA"));
        System.out.println('J' - '@');
    }

    static int answer(String s){
        int ans = 0;
        for (char c: s.toCharArray()) {
            ans = ans * 26 + c - '@';
        }
        return ans;
    }
}
