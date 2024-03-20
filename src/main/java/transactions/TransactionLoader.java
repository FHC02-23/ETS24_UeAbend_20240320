package transactions;

import java.io.*;
import java.util.ArrayList;

public class TransactionLoader {

    public static ArrayList<Transaction> loadTransactions(String path)
            throws LoadException {

        File f = new File(path);
        try (
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader)
            ){

            String line = bufferedReader.readLine(); // Erste Zeile wird bewusst igoniert, da es sich um die Kopfzeile handelt

            ArrayList<Transaction> transactions = new ArrayList<>();
            //Transaction_date;Product;Price;Payment_Type;Name;City;State;Country
            while ((line = bufferedReader.readLine()) != null){
                String[] columns = line.split(";");

                if (columns.length != 8) {
                    throw new LoadException("Fehler beim Einlesen von Zeile: " + line);
                }

                double price = Double.parseDouble(columns[2]);

                Transaction obj = new Transaction(columns[0], columns[1], price, columns[3],
                        columns[4], columns[5], columns[6], columns[7]);

                transactions.add(obj);
            }
            return transactions;

        }  catch (IOException e) {
            throw new LoadException("Fehler bei " + path, e);
        }
    }


    public static ArrayList<Transaction> loadTransactions2(String path)
            throws LoadException {

        try (
                BufferedReader bufferedReader = new BufferedReader(new FileReader(path))
        ){

            String line = bufferedReader.readLine(); // Erste Zeile wird bewusst igoniert, da es sich um die Kopfzeile handelt

            ArrayList<Transaction> transactions = new ArrayList<>();
            //Transaction_date;Product;Price;Payment_Type;Name;City;State;Country
            while ((line = bufferedReader.readLine()) != null){
                String[] columns = line.split(";");

                if (columns.length != 8) {
                    throw new LoadException("Fehler beim Einlesen von Zeile: " + line);
                }

                Transaction obj = new Transaction(columns[0], columns[1], Double.parseDouble(columns[2]), columns[3],
                        columns[4], columns[5], columns[6], columns[7]);

                transactions.add(obj);
            }
            return transactions;

        }  catch (IOException e) {
            throw new LoadException("Fehler bei " + path, e);
        }
    }

    public static ArrayList<Transaction> loadTransactionsStream(String path)
            throws LoadException {

        try (
                FileInputStream fis = new FileInputStream(path);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader bufferedReader = new BufferedReader(isr);
        ){
            String line = bufferedReader.readLine(); // Erste Zeile wird bewusst igoniert, da es sich um die Kopfzeile handelt

            ArrayList<Transaction> transactions = new ArrayList<>();
            //Transaction_date;Product;Price;Payment_Type;Name;City;State;Country
            while ((line = bufferedReader.readLine()) != null){
                String[] columns = line.split(";");

                if (columns.length != 8) {
                    throw new LoadException("Fehler beim Einlesen von Zeile: " + line);
                }

                Transaction obj = new Transaction(columns[0], columns[1], Double.parseDouble(columns[2]), columns[3],
                        columns[4], columns[5], columns[6], columns[7]);

                transactions.add(obj);
            }
            return transactions;

        }  catch (IOException e) {
            throw new LoadException("Fehler bei " + path, e);
        }
    }
}
