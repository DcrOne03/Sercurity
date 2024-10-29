package MaHoaCoDien;

import java.util.HashMap;
import java.util.Map;

public class constant {
        public static Map<Integer, Character> mapCaesar = new HashMap<>();
        static {
            int key = 0;
            char value = 'A';
            for (int i = 0; i < 26; i++) {
                mapCaesar.put(key++, value++); 
            }
        }
        public static Map<Character, Integer> mapCaesarRevert = new HashMap<>();
        static {
            char key = 'A';
            int value = 0;
            for (int i = 0; i < 26; i++) {
                mapCaesarRevert.put(key++, value++); 
            }
        }
    public static char[][] VIGENERE_MATRIX = new char[26][26];

    static{
        char startChar = 'A';
        for (int i = 0; i < 26; i++) {
            char currentChar = startChar;
            for (int j = 0; j < 26; j++) {
                VIGENERE_MATRIX[i][j] = currentChar;
                currentChar++;
                if (currentChar > 'Z') {
                    currentChar = 'A';
                }
            }
            startChar++;
            if (startChar > 'Z') {
                startChar = 'A';
            }
        }
    }
}
