import java.sql.*;
import java.util.Scanner;

public class App {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/data_pelanggan";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    public static void main(String[] args) throws Exception {

    //polymorphisme
    DataPelanggan pelanggan1 = new Pelanggan();

    //menampilkan struk
    //pelanggan1.struk();
    
    Kasir Kasir1 = new Kasir();
    Kasir1.login();

    //exception
    Scanner scanner = new Scanner(System.in);

    try {
        Class.forName(JDBC_DRIVER);

        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();

        System.out.print("Masukkan Nomor Faktur: ");
        String no_faktur = scanner.nextLine();

        System.out.print("Masukkan Nama Pelanggan: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Nomor HP: ");
        String no_hp = scanner.nextLine();

        System.out.print("Masukkan Alamat: ");
        String alamat = scanner.nextLine();

        String sql = "INSERT INTO data_pelanggan (nomor_faktur, nama_pelanggan, nomor_hp, alamat_pelanggan) VALUE ('%s', '%s', '%s', '%s' )";
        sql = String.format(sql, no_faktur, nama, no_hp, alamat);
        stmt.execute(sql);

        System.out.print("Masukkan Kode Barang: ");
        String kode_barang = scanner.nextLine();

        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan Harga Barang: ");
        Integer hargaBarang = Integer.parseInt(scanner.nextLine());
        if (hargaBarang > 500000) {
            throw new IllegalArgumentException("Harga barang tidak boleh lebih dari 500000");
        }

        System.out.print("Masukkan Jumlah Barang: ");
        Integer jumlahBarang = Integer.parseInt(scanner.nextLine());
        if (jumlahBarang > 100) {
            throw new IllegalArgumentException("Jumlah barang tidak boleh lebih dari 100");
        }

       while (!conn.isClosed()) {
           showMenu();
        }

        stmt.close();
        conn.close(); 

    } catch (NumberFormatException e) {
        System.out.println("Input harus berupa angka");
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    } finally {
        System.out.println("Kasir : " + Kasir1);
    }
    scanner.close();
} 

static Scanner scanner = new Scanner(System.in); 

static void showMenu() {
    System.out.println("\n========= MENU UTAMA =========");
    System.out.println("1. Show Data");
    System.out.println("2. Edit Data");
    System.out.println("3. Delete Data");
    System.out.println("0. Keluar");
    System.out.println("");
    System.out.print("PILIHAN> ");

    try {
        Integer pilihan = Integer.parseInt(scanner.nextLine());

        switch (pilihan) {
            case 0:
                System.exit(0);
                break;
            case 1:
                showData();
                break;
            case 2:
                updateData();
                break;
            case 3:
                deleteData();
                break;
            default:
                System.out.println("Pilihan salah!");

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

static void showData() {
    String sql = "SELECT * FROM ";

    try {
        rs = stmt.executeQuery(sql);
        
        System.out.println("+--------------------------------+");
        System.out.println("|    DATA PELANGGAN DI KHAIRA MART   |");
        System.out.println("+--------------------------------+");

        while (rs.next()) {
            String nomor_faktur = rs.getString("nomor_faktur");
            String nama_pelanggan = rs.getString("nama_pelanggan");
            String nomor_hp = rs.getString("nomor_hp");
            String alamat_pelanggan = rs.getString("alamat_pelanggan");
    
            
            System.out.println(String.format("%s. %s -- %s -- (%s)", nomor_faktur, nama_pelanggan, alamat_pelanggan, nomor_hp));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

}

static void updateData() {
    try {
        
        System.out.print("Faktur yang mau diedit : ");
        String nomor_faktur = scanner.nextLine();
        System.out.print("Nama Pelanggan : ");
        String nama_pelanggan = scanner.nextLine().trim();
        System.out.print("Nomor HP : ");
        String nomor_hp = scanner.nextLine().trim();
        System.out.print("Alamat : ");
        String alamat_pelanggan = scanner.nextLine().trim();

        String sql = "UPDATE data_pelanggan SET nama_pelanggan='%s', nomor_hp='%s', alamat_pelanggan='%s' WHERE nomor_faktur='%s'";
        sql = String.format(sql, nama_pelanggan, nomor_hp, alamat_pelanggan, nomor_faktur);

        stmt.execute(sql);
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}

static void deleteData() {
    try {
        
        // ambil input dari user
        System.out.print("Faktur yang mau dihapus : ");
        String nomor_faktur = (scanner.nextLine());
        
        // buat query hapus
        String sql = String.format("DELETE FROM data_pelanggan WHERE nomor_faktur='%s'", nomor_faktur);

        // hapus data
        stmt.execute(sql);
        
        System.out.println("Data telah terhapus...");
    } catch (Exception e) {
        e.printStackTrace();
    }
} 
}


