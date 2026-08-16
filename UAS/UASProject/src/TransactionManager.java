/* PROJECT UAS 
 * DATA STRUCTURE AND ALGORITHM ANALYSIS 
 * COSC6025036
 * 
 * Lynatu Khoirinnisa
 * NIM 2902785980 
 * Kelas LVCA
 */

import java.util.*;

// Class TransactionManager, untuk mengelola struktur data dan logika bisnis
public class TransactionManager {
	// Define Queue untuk antrean FIFO
    private Queue<Transaction> transactionQueue = new LinkedList<>(); 
    
    // Define HashMap untuk pencarian cepat O(1)
    private HashMap<String, Transaction> transactionMap = new HashMap<>(); 
    
    // Define Stack untuk fitur undo atau rollback
    private Stack<Transaction> undoStack = new Stack<>();

    // Menambah transaksi baru 
    public void addTransaction(Transaction tx) {
        transactionQueue.offer(tx);
        transactionMap.put(tx.getTransactionId(), tx);
        System.out.println("Added: " + tx);
    }

    // Memproses transaksi dari antrean (FIFO)
    public void processTransaction() {
        if (transactionQueue.isEmpty()) {
            System.out.println("No transactions to process.");
            return;
        }
        Transaction processedTx = transactionQueue.poll();
        
        // Push ke stack untuk keperluan undo atau rollback
        undoStack.push(processedTx); 
        System.out.println("Processed: " + processedTx);
    }

    // Melakukan undo terhadap transaksi terakhir yang diproses
    public void undoTransaction() {
        if (undoStack.isEmpty()) {
            System.out.println("No transaction to undo.");
            return;
        }
        Transaction undoneTx = undoStack.pop();
        transactionMap.remove(undoneTx.getTransactionId()); 
        System.out.println("Undone/Rolled back: " + undoneTx);
    }

    // Pencarian cepat berdasarkan ID menggunakan HashMap
    public Transaction searchTransaction(String id) {
        return transactionMap.get(id);
    }

    // Menampilkan seluruh transaksi
    public void displayAllTransactions() {
        System.out.println("\n--- All Active Transactions in System ---");
        if (transactionMap.isEmpty()) {
            System.out.println("System is empty.");
        } else {
            System.out.println("----------------------------------------------------------------------");
            System.out.printf("| %-10s | %-12s | %-15s | %-20s |%n", 
                              "ID", "Type", "Amount", "Timestamp");
            System.out.println("----------------------------------------------------------------------");
            
            for (Transaction tx : transactionMap.values()) {
                System.out.printf("| %-10s | %-12s | Rp %-12.2f | %-20d |%n", 
                                  tx.getTransactionId(), 
                                  tx.getType(), 
                                  tx.getAmount(), 
                                  tx.getTimestamp());
            }
            System.out.println("----------------------------------------------------------------------");
        }
    }
}






