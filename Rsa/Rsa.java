package Rsa;
import DataType.PairKey;

public class Rsa {
    public PairKey<Integer,Integer> khoaCongKhai;
    public PairKey<Integer,Integer> khoaRieng;
    public int M;
    public int C;
    public Rsa(int p,int q,int e,int M){
        int n=p*q;
        int phi_n=Modulo.Library.function.euler(n);
        int d=Modulo.Library.function.nghichDaoModulo(e, phi_n);
        this.M=M;
        this.khoaCongKhai=new PairKey<Integer,Integer>(e, n);
        this.khoaRieng=new PairKey<Integer,Integer>(d, n); 
        System.out.printf("Khóa công khai là:{e,n}= {%d, %d} %n",khoaCongKhai.getFirst(),khoaCongKhai.getSecond());
        System.out.printf("Khóa riêng là: {d,n} = {%d, %d} %n", khoaRieng.getFirst(),khoaRieng.getSecond());
    }
    public void excuteRsa(){
        
        System.out.println("Ma hoa input: "+M);
        this.C=Modulo.Library.function.moduloBinhPhuong(M, khoaCongKhai.getFirst(), khoaCongKhai.getSecond());
        System.out.println("Ket qua ma hoa la: "+C);
    }
    public void revertExcute(){
        System.out.println("Giai ma Input: "+C);
        int M_result_revert=Modulo.Library.function.moduloBinhPhuong(C, khoaRieng.getFirst(), khoaRieng.getSecond());
        System.out.println("Ket qua giai ma la: "+M_result_revert);
    }
}
