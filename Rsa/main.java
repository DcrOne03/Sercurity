package Rsa;

public class main {
    public static void main(String[] args) {
        // Rsa excute:
        Rsa rsa=new Rsa(17, 11, 7, 88);
        rsa.excuteRsa();
        rsa.revertExcute();
    }
}
