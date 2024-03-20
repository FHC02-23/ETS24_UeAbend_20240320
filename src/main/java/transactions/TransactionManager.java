package transactions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TransactionManager {

    private ArrayList<Transaction> transactions;

    public TransactionManager(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public HashMap<String, Integer> getTransactionCountByCity() {
        HashMap<String, Integer> result = new HashMap<>();

        for (Transaction t : transactions) {
            if (result.containsKey(t.getCity())) {
                // es ist schon ein Eintrag in der HashMap
                int originalCount = result.get(t.getCity());
                originalCount++;
                result.put(t.getCity(), originalCount);
            }
            else {
                result.put(t.getCity(), 1);
            }
        }

        return result;
    }

    public int getCountOfTransaction(String country) {
        int result = 0;

        for (Transaction t : transactions) {
            if (t.getCountry().equals(country)) {
                result++;
            }
        }
        return result;
    }

    public ArrayList<Transaction> getTransactionsToProduct(String product) {
        ArrayList<Transaction> result = new ArrayList<>();

        for (Transaction t : transactions) {
            if (t.getProduct().equals(product)) {
                result.add(t);
            }
        }

        return result;
    }

    public  HashMap<String, Double> getAverageAmountByPaymentType() {

        HashMap<String, Double> result = new HashMap<>();
        HashMap<String, ArrayList<Transaction>> paymentTypes = getByPaymentType();

        for (Map.Entry<String, ArrayList<Transaction>> entry : paymentTypes.entrySet()){

            double sum = 0;
            for (Transaction t : entry.getValue()){
                sum += t.getPrice();
            }

            double avg = sum / entry.getValue().size();
            result.put(entry.getKey(), avg);
        }

        return result;
    }

    private  HashMap<String, ArrayList<Transaction>> getByPaymentType() {

        HashMap<String, ArrayList<Transaction>> result = new HashMap<>();

        for (Transaction t : transactions) {
            if (result.containsKey(t.getPaymentType())) {
                result.get(t.getPaymentType()).add(t);
            }
            else {
                ArrayList<Transaction> list = new ArrayList<>();
                list.add(t);
                result.put(t.getPaymentType(), list);
            }
        }

        return result;
    }
}
