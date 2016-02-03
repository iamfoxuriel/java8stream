import java.util.Date;

public class SaleItem {
    private int month;
    private Date date;
    private String transactionId;
    private double saleNumbers;

    public SaleItem(double saleNumbers, int month) {
        this.saleNumbers = saleNumbers;
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getSaleNumbers() {
        return saleNumbers;
    }

    public void setSaleNumbers(double saleNumbers) {
        this.saleNumbers = saleNumbers;
    }
}
