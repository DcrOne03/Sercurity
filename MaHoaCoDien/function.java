package MaHoaCoDien;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import DataType.PairKey;
import MaHoaCoDien.constant;
public class function {
    public static String caesar(String input, int k){
        input=input.toUpperCase();
        String output="";
        for(int i=0;i< input.length();i++){
            Character c=input.charAt(i);
            int key=constant.mapCaesarRevert.get(c);
            output+=constant.mapCaesar.get((key+k)%26);
        }
        return output;
    }
    public static String deCryptCaesar(String input,int k){
        String output="";
        for(int i=0;i< input.length();i++){
            Character c=input.charAt(i);
            int key=constant.mapCaesarRevert.get(c);
            output+=constant.mapCaesar.get((key-k+26)%26);
        }
        return output;
    }
    public static String VingenereLoopKey(String input,String key){
        String output="";
        String keyLoop="";
        for(int i=0;i<input.length();i++){
            char currentCharInkey=key.charAt(i%(key.length()));
            keyLoop+=currentCharInkey;
            int row=constant.mapCaesarRevert.get(keyLoop.charAt(i));
            int col=constant.mapCaesarRevert.get(input.charAt(i));
            output+=constant.VIGENERE_MATRIX[row][col];
        }
        return output;
    }
    public static String deCryptVingenereLoopKey(String input,String key){
        String output="";
        String keyLoop="";
        for(int i=0;i<input.length();i++){
            char currentCharInkey=key.charAt(i%(key.length()));
            keyLoop+=currentCharInkey;
            int row=constant.mapCaesarRevert.get(keyLoop.charAt(i));
            for(int j=0;j<26;j++){
                if(constant.VIGENERE_MATRIX[row][j]==input.charAt(i)){
                    output+=constant.VIGENERE_MATRIX[0][j];
                    break;
                }
            }
        }
        return output;
    }
    public static String VingenereAutoKey(String input,String key){
        String output="";
        String keyAuto=key;
        for(int i=0;i<input.length();i++){
            if(i>=key.length()){
                char currentCharInkey=input.charAt(i-key.length());
                keyAuto+=currentCharInkey;
            }
            int row=constant.mapCaesarRevert.get(keyAuto.charAt(i));
            int col=constant.mapCaesarRevert.get(input.charAt(i));
            output+=constant.VIGENERE_MATRIX[row][col];
        }
        return output;
    }
    public static String deCryptVingenereAutoKey(String input,String key){
        String output="";
        String keyAuto=key;
        for(int i=0;i<input.length();i++){
            if(i>=key.length()){
                char currentCharInkey=input.charAt(i-key.length());
                keyAuto+=currentCharInkey;
            }
            int row=constant.mapCaesarRevert.get(keyAuto.charAt(i));
            for(int j=0;j<26;j++){
                if(constant.VIGENERE_MATRIX[row][j]==input.charAt(i)){
                    keyAuto+=constant.VIGENERE_MATRIX[0][j];
                    output+=constant.VIGENERE_MATRIX[0][j];
                    break;
                }
            }
        }
        System.out.println(keyAuto);
        return output;
    }
    public static String singleCharacter(String input,String key){
        Map<Character,Character> map=new HashMap<>();
        char _key='A';
        String output="";
        for(int i=0;i<26;i++){
            map.put(_key++, key.charAt(i));
        }
        for(int i=0;i<input.length();i++){
            output+=map.get(input.charAt(i));
        }
        return output;
    }
    public static String deCryptSingleCharacter(String input,String key){
        Map<Character,Character> map=new HashMap<>();
        char _key='A';
        String output="";
        for(int i=0;i<26;i++){
            map.put(key.charAt(i),_key++);
        }
        for(int i=0;i<input.length();i++){
            output+=map.get(input.charAt(i));
        }
        return output;
    }
    public static String playFair(String input,String key){
        input=input.toUpperCase();
        Map<String,PairKey<Integer,Integer>> anhxaMaTranLayChiSoHangChiSoCot=new HashMap<>();
        String [][] matrixKey=new String[5][5];
        String output="";
        String solInput="";
        ArrayList<Character> fillKey=new ArrayList<>();
        char x='A';
        for(int i=0;i<26;i++){
                fillKey.add(x++);
        }
        fillKey.remove(Character.valueOf('J'));
        for(int i=0;i<key.length();i++){
            fillKey.remove(Character.valueOf(key.charAt(i)));
        }
        int it=0;
        int it1=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(it<key.length()){
                    matrixKey[i][j]=Character.toString(key.charAt(it++));
                    anhxaMaTranLayChiSoHangChiSoCot.put(matrixKey[i][j],new PairKey<Integer,Integer>(i, j));
                }
                else{
                    matrixKey[i][j]=Character.toString(fillKey.get(it1++));
                    anhxaMaTranLayChiSoHangChiSoCot.put(matrixKey[i][j],new PairKey<Integer,Integer>(i, j));
                }
            }
        }
        for(int i=0;i<input.length();i++){
            if(i+1<input.length()){
                if(input.charAt(i)==input.charAt(i+1)){
                    solInput += String.valueOf(input.charAt(i)) + "X";

                }
                else{
                    solInput+=String.valueOf(input.charAt(i))+String.valueOf(input.charAt(i+1));
                    i++;
                }
            }
            else
                solInput+=input.charAt(i)+""+"X";
        }
        for(int i=0;i<solInput.length();i+=2){
            if(i+1<solInput.length()){
                PairKey<Integer,Integer> index1=anhxaMaTranLayChiSoHangChiSoCot.get(Character.toString(solInput.charAt(i)));
                PairKey<Integer,Integer> index2=anhxaMaTranLayChiSoHangChiSoCot.get(Character.toString(solInput.charAt(i+1)));
                int row1=index1.getFirst();
                int row2=index2.getFirst();
                int col1=index1.getSecond();
                int col2=index2.getSecond();
                if(row1==row2 && col1!=col2){
                    output+=matrixKey[row1][(col1+1)%5]+matrixKey[row1][(col2+1)%5];
                }
                else if(row1!=row2 && col1==col2){
                    output+=matrixKey[(row1+1)%5][col1]+matrixKey[(row2+1)%5][col2];
                }
                else if(row1!=row2 && col1!=col2){
                    output+=matrixKey[row1][col2]+matrixKey[row2][col1];
                }
            }
        }
        
        return output;
    }
    public static String deCryptPlayFair(String input,String key){
        input=input.toUpperCase();
        Map<String,PairKey<Integer,Integer>> anhxaMaTranLayChiSoHangChiSoCot=new HashMap<>();
        String [][] matrixKey=new String[5][5];
        String output="";
        ArrayList<Character> fillKey=new ArrayList<>();
        char x='A';
        for(int i=0;i<26;i++){
                fillKey.add(x++);
        }
        fillKey.remove(Character.valueOf('J'));
        for(int i=0;i<key.length();i++){
            fillKey.remove(Character.valueOf(key.charAt(i)));
        }
        int it=0;
        int it1=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(it<key.length()){
                    matrixKey[i][j]=Character.toString(key.charAt(it++));
                    anhxaMaTranLayChiSoHangChiSoCot.put(matrixKey[i][j],new PairKey<Integer,Integer>(i, j));
                }
                else{
                    matrixKey[i][j]=Character.toString(fillKey.get(it1++));
                    anhxaMaTranLayChiSoHangChiSoCot.put(matrixKey[i][j],new PairKey<Integer,Integer>(i, j));
                }
            }
        }
        
        for(int i=0;i<input.length();i+=2){
            if(i+1<input.length()){
                PairKey<Integer,Integer> index1=anhxaMaTranLayChiSoHangChiSoCot.get(Character.toString(input.charAt(i)));
                PairKey<Integer,Integer> index2=anhxaMaTranLayChiSoHangChiSoCot.get(Character.toString(input.charAt(i+1)));
                int row1=index1.getFirst();
                int row2=index2.getFirst();
                int col1=index1.getSecond();
                int col2=index2.getSecond();
                if(row1==row2 && col1!=col2){
                    output+=matrixKey[row1][(col1-1+5)%5]+matrixKey[row1][(col2-1+5)%5];
                }
                else if(row1!=row2 && col1==col2){
                    output+=matrixKey[(row1-1+5)%5][col1]+matrixKey[(row2-1+5)%5][col2];
                }
                else if(row1!=row2 && col1!=col2){
                    output+=matrixKey[row1][col2]+matrixKey[row2][col1];
                }
            }
        }
        String solOutput="";
        for(int i=0;i<output.length();i++){
            if(i<output.length()-3){
                if(output.charAt(i+1)=='X'&& output.charAt(i+2)==output.charAt(i)){
                    solOutput+=output.charAt(i);
                    i++;
                }

            }
            solOutput+=output.charAt(i);
        }
        
        return solOutput;
    }
    public static String matMaHoanVi(String input, int[] key) {
        String output = "";

        int col = key.length;
        int row = (int) Math.ceil((double) input.length() / col);
        char[][] matrix = new char[row][col];
        Map<Integer, Integer> rowkey = new HashMap<>();
        for (int i = 0; i < key.length; i++)
            rowkey.put(key[i] - 1, i);
        int it = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (it < input.length())
                    matrix[i][j] = input.charAt(it++);
                else
                    matrix[i][j] = ' ';
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
               
                System.out.printf("%c  ", matrix[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[j][rowkey.get(i)] != ' ') {
                    output += matrix[j][rowkey.get(i)];
                }
            }
        }
        return output;
    }
    public static String decryptMatMaHoanVi(String input, int[] key) {
        String output = "";

        int col = key.length;
        int row = (int) Math.ceil((double) input.length() / col);
        char[][] matrix = new char[row][col];
        Map<Integer, Integer> rowkey1 = new HashMap<>();
        Map<Integer, Integer> rowkey2 = new HashMap<>();
        for (int i = 0; i < key.length; i++){
            rowkey1.put(i,key[i] - 1);
            rowkey2.put(key[i] - 1,i);
        }
            
        int it = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if(it<input.length()){
                    if ((j+1)*(rowkey1.get(i)+1)+1 > input.length())
                        matrix[j][i] = ' ';
                    else
                        matrix[j][i] = input.charAt(it++);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
               
                System.out.printf("%c  ", matrix[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][rowkey1.get(j)] != ' ') {
                    output += matrix[i][rowkey1.get(j)];
                }
            }
        }
        return output;
    }
    
}
