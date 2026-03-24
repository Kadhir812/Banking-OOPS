package Interface;

@FunctionalInterface
public interface Phone {
    void calling(int rate);

    default void msg() {
        System.out.println("SMS Charge: 2 Rs");
    }
     
}