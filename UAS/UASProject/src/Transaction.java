/* PROJECT UAS 
 * DATA STRUCTURE AND ALGORITHM ANALYSIS 
 * COSC6025036
 * 
 * Lynatu Khoirinnisa
 * NIM 2902785980 
 * Kelas LVCA
 */

// Class Transaction, entitas data transaksi
public class Transaction{
    private String transactionId;
    private String type; // tipe transaksi (transfer, top-up, payment)
    private double amount;
    private long timestamp;

    // Define constructor
    public Transaction(String transactionId, String type, double amount){
        this.transactionId = transactionId;
        this.type = type;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }

    // Define getter
    public String getTransactionId(){ 
    	return transactionId; 
    }
    
    public String getType(){
    	return type; 
    }
    
    public double getAmount(){
    	return amount; 
    }
    
    public long getTimestamp(){
    	return timestamp; 
    }

    @Override
    public String toString(){
        return "Transaction{id='" + transactionId + "', type='" + type + "', amount=" + amount + ", time=" + timestamp + "}";
    }
}
