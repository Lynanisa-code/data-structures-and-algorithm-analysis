/* PROJECT UAS 
 * DATA STRUCTURE AND ALGORITHM ANALYSIS 
 * COSC6025036
 * 
 * Lynatu Khoirinnisa
 * NIM 2902785980 
 * Kelas LVCA
 */

// Main Class, sebagai simulasi sistem
public class Main {
    public static void main(String[] args) {
        TransactionManager manager = new TransactionManager();

        System.out.println("=====================================");
        System.out.println("    SIMULASI PENAMBAHAN TRANSAKSI");
        System.out.println("=====================================");
        manager.addTransaction(new Transaction("Tx001", "Transfer", 150000));
        manager.addTransaction(new Transaction("Tx002", "Top-Up", 50000));
        manager.addTransaction(new Transaction("Tx003", "Payment", 250000));
        manager.addTransaction(new Transaction("Tx004", "Transfer", 1000000));
        manager.addTransaction(new Transaction("Tx005", "Top-Up", 75000));
        manager.addTransaction(new Transaction("Tx006", "Top-Up", 1500000));
        manager.addTransaction(new Transaction("Tx007", "Top-Up", 70000));
        manager.addTransaction(new Transaction("Tx008", "Payment", 100000));
        manager.addTransaction(new Transaction("Tx009", "Transfer", 1550000));
        manager.addTransaction(new Transaction("Tx010", "Payment", 85000));

        System.out.println("\n===================================================");
        System.out.println("    SIMULASI PENCARIAN TRANSAKSI BERDASARKAN ID");
        System.out.println("===================================================");
        Transaction found = manager.searchTransaction("Tx003");
        System.out.println("Search Result: " + (found != null ? found : "Not Found"));

        System.out.println("\n==========================================");
        System.out.println("    SIMULASI PEMROSESAN ANTREAN (FIFO)");
        System.out.println("==========================================");
        manager.processTransaction();
        manager.processTransaction();

        System.out.println("\n======================================");
        System.out.println("    SIMULASI FITUR UNDO / ROLLBACK");
        System.out.println("======================================");
        manager.undoTransaction();

        System.out.println("\n\nTAMPILAN AKHIR SISTEM");
        manager.displayAllTransactions();
    }
}