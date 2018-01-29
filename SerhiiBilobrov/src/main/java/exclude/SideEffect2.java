package exclude;

/**
 * Created by serhii on 28.01.18.
 */
public class SideEffect2 {

    public static final int ITER_NUM = 10_000_000;
    public static final int money = 0;

    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(() -> {
            int a = 12;
            for (int i = 0; i < ITER_NUM; i++) {
//                money++;
            }
        });
        thread1.start();
        Thread thread = new Thread(() -> {
            for (int i = 0; i < ITER_NUM; i++) {
//                money--;
            }
        });
        thread.start();

        thread.join();
        thread1.join();

        System.out.println(money);
    }
}
