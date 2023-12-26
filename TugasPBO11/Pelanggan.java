import java.util.*;
import java.text.*;

public class Pelanggan extends DataPelanggan {

    //method untuk mengisi data pelanggan
    public void inputDataPelanggan(){
        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        
        System.out.println("Masukkan nomor faktur = ");
        no_faktur = scanString.next();
        System.out.println("Masukkan nama pelanggan = ");
        nama = scanString.next();
        System.out.println("Masukkan No. HP = ");
        no_hp = scanString.next();
        System.out.println("Masukkan alamat = ");
        alamat = scanString.next();
        System.out.println("Masukkan kode barang = ");
        kode_barang = scanString.next();
        System.out.println("Masukkan nama barang = ");
        namaBarang = scanString.next();
        System.out.println("Masukkan harga barang = ");
        hargaBarang = scanInt.nextInt();
        System.out.println("Masukkan jumlah beli = ");
        jumlahBarang = scanInt.nextInt();
        System.out.println("Masukkan nama kasir = ");
        kasir = scanString.next();
        scanString.close();
        scanInt.close();
    }

    //method untuk mencetak struk
    @Override
    public void struk() {
        Integer totalBayar = hargaBarang*jumlahBarang;
        //this.hargaBarang = hargaBarang;
        this.totalBayar = totalBayar;

        Date HariSekarang = new Date();
        SimpleDateFormat tg = new SimpleDateFormat("E, yyyy/MM/dd ");
        SimpleDateFormat wt = new SimpleDateFormat("hh:mm:ss zzz");

        System.out.println("---------KHAIRA MART---------");
        System.out.println("Tanggal :"+tg.format(HariSekarang));
        System.out.println("Waktu   :"+wt.format(HariSekarang));
        System.out.println("=============================");
        System.out.println("DATA PELANGGAN");
        System.out.println("-------------------------------" );
        System.out.println("Nama Pelanggan  = " + nama);
        System.out.println("No. HP          = " + no_hp);
        System.out.println("Alamat          = " + alamat);
        System.out.println("+++++++++++++++++++++++++++++++" );
        System.out.println("DATA PEMBELIAN BARANG");
        System.out.println("-------------------------------" );
        System.out.println("Kode Barang     = " + kode_barang);
        System.out.println("Nama Barang     = " + namaBarang);
        System.out.println("Harga Barang    = " + hargaBarang);
        System.out.println("Jumlah Beli     = " + jumlahBarang);
        System.out.println("TOTAL BAYAR     = " + this.totalBayar);
        System.out.println("+++++++++++++++++++++++++++++++");
        System.out.println("Kasir           = " + kasir);

        //method string
        System.out.println("toUperrcase\t: " + nama.toUpperCase() );
        System.out.println("compareTo\t= "+nama.compareTo(kasir));
        System.out.println("Sebelum trim\t= "+nama+kasir);
        System.out.println("Setelah trim\t= "+nama.trim()+kasir);
        System.out.println("length\t\t: " + nama.length() );
        System.out.println("equals\t\t:" + tg.equals(wt) );
        System.out.println("concat\t\t="+nama.concat(kasir));
    }
    

}
