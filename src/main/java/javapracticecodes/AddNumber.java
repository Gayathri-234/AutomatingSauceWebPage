package javapracticecodes;

public class AddNumber {
    public static void main(String[] args) {
        System.out.println("Hello World");
        AddNumber logic = new AddNumber();
        logic.addNumber(5,6);
        //addNumber(5, 6);
        subNumber();
        // DivNumber(10,2);
    }

    public  void addNumber(int a, int b) {
        System.out.println("Sum is: " + (a + b));

    }

    public static void subNumber() {
        int c = 20;
        int d = 10;
        int diff = c - d;
        System.out.println("Difference is :" + diff);
    }
    // public static void DivNumber(int i,int j){
    //System.out.println("Division is: ",+i/j);
}

