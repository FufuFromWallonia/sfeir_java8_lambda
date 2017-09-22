package lu.sfeir.java8.lambda.method_reference;

//tag::anInterface[]
public interface AnInterface {

    String A_STATIC_FIELD = "Hello";

    default void aDefaultMethod() {
        //...
    }

    static void aStaticMethod() {
        //...
    }

//    private void aPrivateMethod() {
//        //...
//    }
}
//end::anInterface[]