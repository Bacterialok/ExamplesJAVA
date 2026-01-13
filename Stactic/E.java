public class E {
    static int x = 0;

    public E() { x++; }

    public static void main(String[] args) {
        E e1 = new E();
        E e2 = new E();

        System.out.println(e2.x);
        
        e1.x = 100;

        System.out.println(e2.x);
    }
}