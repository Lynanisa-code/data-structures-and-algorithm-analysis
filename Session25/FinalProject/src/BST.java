/**
 * Group-5 (PVCA - LAB) 
 * Members 
 *  1. Ahmad Andi Nugroho – 2902792355 
 *  2. Lynatu Khoirinnisa – 2902785980 
 *  3. Naura Zulwinda Putri – 2902783602 
 *  4. Indah Tri Praesti – 2902795395 
 */

public class BST {

    private BSTNode root;

    // Constructor
    public BST() {
        root = null;
    }

    // ================================
    // INSERT
    // ================================
    public void insert(Mahasiswa mahasiswa) {
        root = insertRecursive(root, mahasiswa);
    }

    private BSTNode insertRecursive(BSTNode node, Mahasiswa mahasiswa) {

        // Jika posisi kosong, buat node baru
        if (node == null) {
            return new BSTNode(mahasiswa);
        }

        // Bandingkan NIM
        int perbandingan = mahasiswa.getNim().compareTo(node.data.getNim());

        // NIM lebih kecil → kiri
        if (perbandingan < 0) {
            node.left = insertRecursive(node.left, mahasiswa);
        }

        // NIM lebih besar → kanan
        else if (perbandingan > 0) {
            node.right = insertRecursive(node.right, mahasiswa);
        }

        // Jika NIM sama
        else {
            System.out.println(
                "NIM " + mahasiswa.getNim() + " sudah ada di BST."
            );
        }

        return node;
    }

    // ================================
    // SEARCH
    // ================================
    public Mahasiswa search(String nim) {
        BSTNode hasil = searchRecursive(root, nim);

        if (hasil != null) {
            System.out.println("\n--- Data Mahasiswa Ditemukan ---");
            System.out.println(hasil.data);
            return hasil.data;
        }

        System.out.println(
            "\nMahasiswa dengan NIM " + nim + " tidak ditemukan."
        );

        return null;
    }

    private BSTNode searchRecursive(BSTNode node, String nim) {

        // Tidak ditemukan
        if (node == null) {
            return null;
        }

        // NIM ditemukan
        if (nim.equals(node.data.getNim())) {
            return node;
        }

        // Cari ke kiri
        if (nim.compareTo(node.data.getNim()) < 0) {
            return searchRecursive(node.left, nim);
        }

        // Cari ke kanan
        return searchRecursive(node.right, nim);
    }

    // ================================
    // INORDER
    // ================================
    public void inorder() {
        System.out.println("\n=== INORDER ===");
        inorderRecursive(root);
    }

    private void inorderRecursive(BSTNode node) {

        if (node != null) {

            inorderRecursive(node.left);

            System.out.println(node.data);

            inorderRecursive(node.right);
        }
    }

    // ================================
    // PREORDER
    // ================================
    public void preorder() {
        System.out.println("\n=== PREORDER ===");
        preorderRecursive(root);
    }

    private void preorderRecursive(BSTNode node) {

        if (node != null) {

            System.out.println(node.data);

            preorderRecursive(node.left);

            preorderRecursive(node.right);
        }
    }

    // ================================
    // POSTORDER
    // ================================
    public void postorder() {
        System.out.println("\n=== POSTORDER ===");
        postorderRecursive(root);
    }

    private void postorderRecursive(BSTNode node) {

        if (node != null) {

            postorderRecursive(node.left);

            postorderRecursive(node.right);

            System.out.println(node.data);
        }
    }
}