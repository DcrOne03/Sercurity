package DSS;

public class Dss {
    public int y;
    public int r;
    public int s;
    public int q;
    public int p;
    public int h;
    public int Hm;
    public int g;
    public int k;
    public int x;
    public Dss(int q,int p,int h,int k,int x){
        this.x=x;
        this.q=q;
        this.p=p;
        this.h=h;
        this.k=k;
        this.g=(int) Math.pow(h, (p-1)/q);
        this.Hm=9;
        this.y=Modulo.Library.function.moduloBinhPhuong(g, x, p);
        System.out.println("Khóa riêng là: "+x);
        System.out.println("Khóa công khai là: "+y);
        
    }
    public void excuteDsa(){
        this.r=Modulo.Library.function.moduloBinhPhuong(g, k, p)%q;
        System.out.println(r);
        int revert_k=Modulo.Library.function.nghichDaoModulo(k, q);
        this.s= (revert_k*(Hm+x*r))%q;
        System.out.printf("Chữ kí số: {r,s}={%d,%d} %n",r,s);
    }
    public void verify(){
        int w=Modulo.Library.function.nghichDaoModulo(s, q);
        int u1= Hm*w%q;
        int u2=r*w%q;
        int gu1=Modulo.Library.function.moduloBinhPhuong(g, u1, p);
        int yu2=Modulo.Library.function.moduloBinhPhuong(y, u2, p);
        int v=((gu1*yu2)%p)%q;
        if(v==r){
            System.out.printf("Xác thực thành công. v=r : %d=%d %n",v,r);
        }
        else
            System.out.printf("Xác thực không thành công. v!=r : %d!=%d %n",v,r);
    }
}
