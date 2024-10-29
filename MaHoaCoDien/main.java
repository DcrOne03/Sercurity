package MaHoaCoDien;

public class main {
    public static void main(String[] args) {
        //caesar
        String inputCaesar="sTILLWATERSRUNDE";
        int keyCaesar=25;
        String ouputCaesar=function.caesar(inputCaesar, keyCaesar);
        System.out.println("Input caesar: "+inputCaesar);
        System.out.println("Output caesar: "+ouputCaesar);

        String inputEnCryptCaesar="RSHKKVZSDQRQTMCD";
        String ouputEncryptCaesar=function.deCryptCaesar(inputEnCryptCaesar, keyCaesar);
        System.out.println("Input enCryptCaesar: "+inputEnCryptCaesar);
        System.out.println("Output enCryptCaesar: "+ouputEncryptCaesar);
        System.out.println();
        
        //vigenere loop key:
        String inputVingenereLoopKey="PRACTICEMAKESP";
        String keyVigenereLoopKey="TWOCANP";
        String outputVingenereLoopKey=function.VingenereLoopKey(inputVingenereLoopKey, keyVigenereLoopKey);
        System.out.println("Input Vingenere LoopKey: "+inputVingenereLoopKey);
        System.out.println("Output Vingenere LoopKey: "+outputVingenereLoopKey);
        //de crypt vigenere loop key:
        String inputDeVingenereLoopKey="INOETVRXIOMEFE";
        String outputDeVingenereLoopKey=function.deCryptVingenereLoopKey(inputDeVingenereLoopKey, keyVigenereLoopKey);
        System.out.println("Input DeCrypt Vingenere LoopKey: "+inputDeVingenereLoopKey);
        System.out.println("Output DeCrypt Vingenere LoopKey: "+outputDeVingenereLoopKey);
        
        // Vigenere Auto key
        String inputVingenereAutoKey="PRACTICEMAKESP";
        String keyVigenereAutoKey="TWOCANP";
        String outputVingenereAutoKey=function.VingenereAutoKey(inputVingenereAutoKey, keyVigenereAutoKey);
        System.out.println("Input Vingenere AutoKey: "+inputVingenereAutoKey);
        System.out.println("Output Vingenere AutoKey: "+outputVingenereAutoKey);
        //DeCrypt Vigenere Auto key
        String inputDeCryptVingenereAutoKey="INOETVRTDAMXAR";
        String outputDeCryptVingenereAutoKey=function.deCryptVingenereAutoKey(inputDeCryptVingenereAutoKey, keyVigenereAutoKey);
        System.out.println("Input DeCrypt Vingenere AutoKey: "+inputDeCryptVingenereAutoKey);
        System.out.println("Output DeCrypt Vingenere AutoKey: "+outputDeCryptVingenereAutoKey);


        // ma hoa chu don
        String inputMaHoaChuDon="TIMEISMONEYTIMEI";
        String keyMaHoaChuDon="KGOXPMUHCAYTJQWZRIVESFLDNB";
        String outputMaHoaChuDon=function.singleCharacter(inputMaHoaChuDon, keyMaHoaChuDon);
        System.out.println("Input Ma Hoa chu don: "+inputMaHoaChuDon);
        System.out.println("Output Ma Hoa chu don: "+outputMaHoaChuDon);
        // decrypt ma hoa chu don
        String inputDeCryptMaHoaChuDon="ECJPCVJWQPNECJPC";
        String outputDeCryptMaHoaChuDon=function.deCryptSingleCharacter(inputDeCryptMaHoaChuDon, keyMaHoaChuDon);
        System.out.println("Input DeCrypt Ma Hoa chu don: "+inputDeCryptMaHoaChuDon);
        System.out.println("Output DeCrypt Ma Hoa chu don: "+outputDeCryptMaHoaChuDon);
        // playfair:
        String inputPlayfair="ALLWORKANDNOP";
        String keyPlayfair="BEAUTYIS";
        String outputPlayfair=function.playFair(inputPlayfair, keyPlayfair);
        System.out.println("Input Playfair: "+inputPlayfair);
        System.out.println("Output Playfair: "+outputPlayfair);
        
        // Decrypt playfair:
        String inputDecryptPlayfair="THHZMWHUQIOPXU";
        String outputDecryptPlayfair=function.deCryptPlayFair(inputDecryptPlayfair, keyPlayfair);
        System.out.println("Input DeCrypt Playfair: "+inputDecryptPlayfair);
        System.out.println("Output DeCrypt Playfair: "+outputDecryptPlayfair);

        //Ma hoan vi:
        String inputMaHoanVi="ALLWORKANDNOP";
        int[] keyInput = {2, 6, 5, 7, 1, 3, 4};
        String outputMaHoanVi=function.matMaHoanVi(inputMaHoanVi, keyInput);
        System.out.println("Input MaHoanVi: "+inputMaHoanVi);
        System.out.println("Output MaHoanVi: "+outputMaHoanVi);

        //Ma hoan vi:
        String inputDecryptMaHoanVi="OOAARPKLDLNWN";
        String outputDecryptMaHoanVi=function.decryptMatMaHoanVi(inputDecryptMaHoanVi, keyInput);
        System.out.println("Input DeCrypt MaHoanVi: "+inputDecryptMaHoanVi);
        System.out.println("Output DeCrypt MaHoanVi: "+outputDecryptMaHoanVi);
    }
}
