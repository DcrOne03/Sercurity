package Elgama;

import javax.xml.crypto.Data;

import DataType.PublicKeyElgamaKeyElgama;

public class Elgama {
    public PublicKeyElgamaKeyElgama<Integer,Integer,Integer> keyElgama;
    public int PrivateKey;
    public int x;
    public int y;
    public int q;
    public int k;
    public int K;
    public int C1;
    public int C2;
    public int M;
    public Elgama(int q,int a, int x,int k,int M){
        this.M=M;
        this.k=k;
        this.q=q;
        this.x=x;
        this.y=Modulo.Library.function.moduloBinhPhuong(a, x, q);
        this.keyElgama=new PublicKeyElgamaKeyElgama<Integer,Integer,Integer>(q, a, y);
        System.out.printf("Khóa công khai là: {q, a, y}={%d ,%d,%d} %n", q, a, y);
        System.out.printf("Khóa Khóa riêng là: {Xa}={%d} %n", x);
        
    }
    public void excuteElgama(){

        this.K=Modulo.Library.function.moduloBinhPhuong(keyElgama.getThird(), k, q);
        this.C1=Modulo.Library.function.moduloBinhPhuong(keyElgama.getSecond(), k, q);
        this.C2=K*M%q;
        System.out.println("K là:" +K);
        System.out.println("Đầu vào cần mã hóa là:"+M);
        System.out.printf("Kết quả mã hóa {C1,C2}={%d, %d} %n",C1,C2);
    }
    public void revertExcuteElgama(){
        int K=Modulo.Library.function.moduloBinhPhuong(C1, x, q);
        int revertModuloK=Modulo.Library.function.nghichDaoModulo(K, q);
        int M_revert=(revertModuloK*C2)%q;
        System.out.printf("Đầu vào giải mã {C1,C2}={%d, %d} %n",C1,C2);
        System.out.println("revertModuloK: "+revertModuloK);
        System.out.println("Kết quả giải mã: "+M_revert);
    }
}
