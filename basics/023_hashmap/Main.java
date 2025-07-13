// A HashMap in Java is a part of the Java Collections Framework that stores data in key-value pairs.
// It is similar to a dictionary in Python or an object/map in JavaScript.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    Map<String, Double> prices = new HashMap<>();

    prices.put("Apple", 20.0);
    prices.put("Banana", 10.0);
    prices.put("Cherry", 25.0);
    prices.put("Durian", 200.00);

    // TODO: remove "Durian" using `remove(obj)` function from HashMap
    ???.???("Durian");

    List<String> keys = new ArrayList<String>(prices.keySet());
    Collections.sort(keys);

    for (String product : keys) {
      System.out.printf("%s P%.2f\n", product, prices.get(product));
    }
  }
  
}