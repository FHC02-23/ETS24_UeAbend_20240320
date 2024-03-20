package transactions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DemoApp {

    public static void main(String[] args)  {

        try {
            ArrayList<Transaction> transactions = TransactionLoader.loadTransactions(".\\data\\transactions.csv");

            Collections.sort(transactions, new PriceProductComparator());
            //transactions.sort(new PriceProductComparator());

            System.out.println(transactions);

            
            TransactionObjectHandler toh = new TransactionObjectHandler();
            toh.saveTransactions(transactions, ".\\data\\transactions-as-object.dat");

            
            TransactionManager tm = new TransactionManager(transactions);

            System.out.println("tm.getTransactionCountByCity() = " + tm.getTransactionCountByCity());

            System.out.println("tm.getCountOfTransaction(\"United States\") = " + tm.getCountOfTransaction("United States"));

            System.out.println("-----");
            System.out.println("tm.getTransactionsToProduct(\"iphone\") = " + tm.getTransactionsToProduct("iphone"));
            System.out.println("tm.getAverageAmountByPaymentType() = " + tm.getAverageAmountByPaymentType());
            System.out.println("success");
       
        } catch (LoadException e) {
            e.printStackTrace();
        } catch (TransactionObjectException e) {
            e.printStackTrace();
        }
    }
}
