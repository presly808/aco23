package exclude;

/**
 * Created by serhii on 28.01.18.
 */
public class SideEffect1 {

    public static int money = 0;

    public static void main(String[] args) {
        Container container = new Container("myKey");
        container = workWithContainer(container);
        System.out.println(container.key);
    }

    public static Container workWithContainer(Container container){
        return new Container("newKey");
    }

}
class Container {
    public final String key;

    public Container(String key) {
        this.key = key;
    }
}
