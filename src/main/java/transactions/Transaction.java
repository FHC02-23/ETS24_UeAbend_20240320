
package transactions;

import java.io.Serializable;
import java.util.Objects;

public class Transaction implements Comparable<Transaction> , Serializable {
    private String transactionDate;
    private String product;
    private double price;
    private String paymentType;
    private String name;
    private String city;
    private String state;
    private String country;

    public Transaction(String transactionDate, String product, double price, String paymentType, String name, String city, String state, String country) {
        this.transactionDate = transactionDate;
        this.product = product;
        this.price = price;
        this.paymentType = paymentType;
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionDate='" + transactionDate + '\'' +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", paymentType='" + paymentType + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(transactionDate, that.transactionDate) && Objects.equals(product, that.product) && Objects.equals(paymentType, that.paymentType) && Objects.equals(name, that.name) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionDate, product, price, paymentType, name, city, state, country);
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int compareTo(Transaction o) {
        /*
            <0 : Element (a) ist kleiner als das zu vergleichende Element (b)
            0 : Beide Element ident
            >0 : Element (a) ist größer als das zu vergleichende Element (b)
         */
        /* a = 5; b = 8
        *  Fall 1: a < b? 5 < 8: -1
        *  Fall 2: b < a? 8 < 5: 1
        *  */

        /*
            -128 ... 0 ... 127 (256)
            -128 * -1 = +128 (-1)
         */

        return this.transactionDate.compareTo(o.transactionDate); // aufsteigend
        //return o.transactionDate.compareTo(this.transactionDate); // absteigend
    }
}
