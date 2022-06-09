public class Var {
    public static void main(String[] args) {
        Examples e = new Examples();
        char x = e.getA();
        int y = e.getB();
        System.out.println(x);
        System.out.println(y);
    }
}
class Examples  {
    char a;
    int b;
    public char getA() {
        return a;
    }

    public void setA(char a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

