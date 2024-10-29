package Modulo;

import java.util.HashMap;
import java.util.Map;

import Modulo.Library.function;
public class main {
    public static void main(String[] args) {
        System.out.println("Bai 1: Tinh Luy thua modulo: "+function.moduloBinhPhuong(347, 6829, 6829));
        System.out.println("Bai 2 Nghich dao modulo: "+function.nghichDaoModulo(2084, 6113));
        System.out.println("Bai 4 Gia tri ham euler: "+function.euler(4432));
        System.out.println("Bai 5 Modulo euler: "+function.moduloDinhLyEuler(347, 6829, 6829));
        System.out.println("Bai 6 Phan du trung hoa: "+function.moduloPhanDuTrungHoa(163,79,70151));
        Map<Integer,Integer> map=new HashMap<>();
        map.put(13, 9);
        map.put(17, 5);
        map.put(19, 4);
        int nghiem=function.giaiphuongtrinhmodulo(map);
        System.out.println("Bai 7 giai phuong trinh modulo: "+nghiem);
        System.out.println("Bai 8 kiem tra checkCanNguyenThuy: "+function.checkCanNguyenThuy(5, 257));
        System.out.println("Bai 9 logaritRoiRac: "+function.logaritRoiRac(5, 6, 17));
    }
        
}
