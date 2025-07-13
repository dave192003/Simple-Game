// ArrayList is a resizable array in Java. Part of the Java Collection Framework.

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> exampleList = new ArrayList<String>();

        exampleList.add("Apple");
        exampleList.add("Banana");
        // @TODO: add "Cherry" to the `exampleList`

        for (String fruit : exampleList) {
            System.out.println(fruit);
        }
    }
}
