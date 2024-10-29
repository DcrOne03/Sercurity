/**
 * main
 */
public class main {

    public static void main(String[] args) {
        // String inputKey="0f1571c947d9e8590cb7add6af7f6798";                
        // String inputM="0123456789abcdeffedcba9876543210";  
        
        //Nhom6
        // String inputKey="344E74129CD8D1D127FC62A01EF147B7";
        // String inputM="58A89BB7073DAA060FF436751C46674C";
        // nhóm 4:
        String inputM="AB5BFF34115C963B835CAF027EBE0B53";
        String inputKey="CDAB0FC51CACBCF9A8A348C3D2D0247A";
       // in giá trị kết quả ma trận mixcolum vòng 7
        //nhom1
        // String inputKey="CFD61D489E7C48BC46C9F875C1F04E1B";
        // String inputM="18DC9095F9149EDB7323F20E4E462D92";
        // nhom2:
        // String inputM ="B104AADD3AC293DF787EFD2CF8065925";
        // String inputKey ="C281B1763B140EF7AB12EB2745F1F59F" ;

        // String inputKey="A2E7F3E9F4EC8BB93217B94C5FD982CD";
        // String inputM="39400A33DB86771F578E208998CDB8A4";

        // String inputKey="CDAB0FC51CACBCF9A8A348C3D2D0247A";
        // String inputM="AB5BFF34115C963B835CAF027EBE0B53";
        //String testShiftRow="87F24D97EC6E4C904AC346E78CD895A6";
        inputKey=inputKey.toUpperCase();
        inputM=inputM.toUpperCase();
        Aes aes=new Aes(inputKey, inputM);
        aes.expandKey(inputKey);
        aes.printfKey();
        //aes.shiftRowOnRound(testShiftRow);
        aes.excuteRound();
        String [][] mixcolum7=new String[4][4];

        String roundstate7=aes.roundState[6];
        System.out.println(roundstate7);
        String outputSubByteOnRound=function.subByte(roundstate7);
        String outputShiftRowOnRound=aes.shiftRowOnRound(outputSubByteOnRound);
        String outMixColumn=aes.mixColumn(outputShiftRowOnRound);
        mixcolum7=function.convertStringToMatric(outMixColumn);
        System.out.println("Key on round 7");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.printf("%s  ",mixcolum7[i][j]);
            }
            System.out.println();
        }
    }
}