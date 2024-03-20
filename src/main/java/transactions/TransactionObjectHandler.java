package transactions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TransactionObjectHandler {

    public void saveTransactions(ArrayList<Transaction> transactions, String path)
            throws TransactionObjectException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {

            oos.writeObject(transactions);
            oos.flush();

        } catch (IOException e) {
            throw new TransactionObjectException(path, e);
        }

    }
}
