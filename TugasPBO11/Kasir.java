import java.util.Scanner;

public class Kasir implements Login {
    String captcha = "4KqtU1o9";
    String password = "KhAiiRaa13";
    String username = "Admin";
    String inputCaptcha;
    String inputPassword;
    String inputUsername;
     
     
     //method login
     public void login(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("SELAMAT DATANG DI KHAIRA MART");
        System.out.println("==============================");
        System.out.println("Log in");

        //username
        System.out.println("Username\t: "+username);

        //Input Password
        System.out.println("Password\t: ");
        inputPassword = scanner.next();
 
        while(!inputPassword.equals(password)){
             System.out.println("Password Salah!");
             System.out.println("Masukkan password: ");
             inputPassword = scanner.next();
         }
         
        //input kode captcha
        System.out.println("Kode captcha\t: " + captcha);
        System.out.println("Entry Captcha\t: ");
        inputCaptcha = scanner.next();

        while(!inputCaptcha.equalsIgnoreCase(captcha)){
            System.out.println("Anda Bukan Manusia\n");
            System.out.println("Masukkan captcha\t: ");
            inputCaptcha = scanner.next();
        }
        System.out.println("Kode Benar, Anda Manusia\n");

        System.out.println("LOGIN BERHASIL\n"); 
        scanner.close();
     }
}
