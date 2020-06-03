import java.util.*;

public class SumTabs {

    // Calculates the total tabs for each customer given a list of transactions
    // pre: transactions != null
    // post: A map which maps customer names to their total tab.
    public static Map<String, Double> sumTabs(List<String> transactions) {
        HashMap<String, Double> result = new HashMap<>();
        for(String s : transactions){
            Scanner scan = new Scanner(s);
            String name = scan.next();
            double cost = scan.nextDouble();
            if(!result.containsKey(name))
                result.put(name, cost);
            else
                result.put(name, result.get(name) + cost);
        }
        return result;
    }
}