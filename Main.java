import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println(lengthString("dennis"));
        System.out.println(copyString("dennis"));
        System.out.println(reverseString("dennis"));
        System.out.println(palindromeCheck("too hot To HooT"));
        System.out.println(convertToUppercase("dennis masinde"));
        System.out.println(convertFirstLetterToUppercase("this is a sentence"));
        countVowelsConsonantsSymbols("asuyreas\\/");
        System.out.println();
        System.out.println(containsIntegers("0567891"));
        System.out.println(isAnagram("oMo","moO"));
        System.out.println(isPangram("the quick brown fox jumps over a lazy dog"));
        Map<Character, Integer> map = stringToMap("dennis");
        map.forEach((k,v) -> System.out.println(k + " " + v));
        System.out.println(mapHasUniqueCharacters(map));
        printNonRepeatedCharacters(map);
        System.out.println();
        System.out.println(firstNonRepeatingCharacter((LinkedHashMap<Character, Integer>) map));
        System.out.println(removeDuplicates("dennis"));
        System.out.println(isStringEmpty(null));
        swapStringsInPlace("den","nis");
        System.out.println(
                "There are " +
                        wordsInSentence("I wonder how many words are in this sentence")
                            + " words in the sentence");

        System.out.println(
                "There are " +
                        wordsInSentenceToo("I wonder how many words are in this sentence")
                        + " words in the sentence");

        System.out.println(isRotation("dada","adad"));
        System.out.println(deleteOccurence("dennis", 'n'));
        System.out.println(convertStringToInteger("34567") + 1);
        System.out.println(convertIntegerToString(3456));
        String paragraph = """
                Java is a general-purpose computer programming language that is concurrent, class-based, object-oriented,[14] and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers "write once, run anywhere" (WORA),[15] meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.[16] Java applications are typically compiled to bytecode that can run on any Java virtual machine (JVM) regardless of computer architecture. As of 2016, Java is one of the most popular programming languages in use,[17][18][19][20] particularly for client-server web applications, with a reported 9 million developers.[21] Java was originally developed by James Gosling at Sun Microsystems (which has since been acquired by Oracle Corporation) and released in 1995 as a core component of Sun Microsystems' Java platform. The language derives much of its syntax from C and C++, but it has fewer low-level facilities than either of them.
                The original and reference implementation Java compilers, virtual machines, and class libraries were originally released by Sun under proprietary licenses. As of May 2007, in compliance with the specifications of the Java Community Process, Sun relicensed most of its Java technologies under the GNU General Public License. Others have also developed alternative implementations of these Sun technologies, such as the GNU Compiler for Java (bytecode compiler), GNU Classpath (standard libraries), and IcedTea-Web (browser plugin for applets).
                The latest version is Java 8 which is the only version currently supported for free by Oracle, although earlier versions are supported both by Oracle and other companies on a commercial basis.""";
        wordFrequency(paragraph);
        System.out.println(reverseStringRecursively("dennis"));

    }

    public static int lengthString(String str) {
        str = str.concat("\0");
        char[] ch = str.toCharArray();
        int count = 0;
        int i = 0;
        while(ch[i] != '\0') {
            ++count;
            ++i;
        }
        return count;
    }

    public static String copyString(String str) {
        char [] a = str.toCharArray();
        char [] b = new char[a.length];

        System.arraycopy(a, 0, b, 0, a.length);
        StringBuilder newString = new StringBuilder();
        for (char data : b) {
            newString.append(data);
        }
        return newString.toString();
    }

    public static String reverseString(String str) {
        char[] a = str.toCharArray();
        char[] b = new char[a.length];

        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - 1 - i];
        }

        StringBuilder newString = new StringBuilder();
        for (char data: b) {
          newString.append(data);
        }
        return newString.toString();
    }

    public static String reverseStringRecursively(String word){
        String wordReversed = "";

        if (word.length() == 1){
            return word;
        } else {
            wordReversed = wordReversed.concat(String.valueOf(word.charAt(word.length() - 1)));
            wordReversed = wordReversed.concat(reverseString(word.substring(0,word.length() - 1)));
        }
        return wordReversed;
    }

    public static String palindromeCheck(String str1) {
        str1 = str1.toLowerCase().replaceAll("\\s","");
        String str2 = reverseString(str1);

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return "Not a palindrome";
            }
        }
        return "Palindrome";
    }

    public static void wordFrequency(String paragraph) {
        String[] words = paragraph.split(" ");
        Map<String, Integer> map = new LinkedHashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        map.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
    }

    public static String convertToUppercase(String str) {
        char[] a = str.toCharArray();

        StringBuilder upperCase = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (a[i] != ' ') {
                a[i] = (char) (a[i] - 32);
            }
            upperCase.append(a[i]);
        }
        return upperCase.toString();
    }

    public static String convertFirstLetterToUppercase(String str) {
        char[] a = str.toCharArray();
        StringBuilder upperCase = new StringBuilder();
        a[0] = (char) (a[0] - 32);
        for (int i = 0; i < a.length; i++) {
            if(a[i] == ' ') {
                a[i+1] = (char) (a[i+1] - 32);
            }
            upperCase.append(a[i]);
        }
        return upperCase.toString();
    }

    public static void countVowelsConsonantsSymbols(String str) {
        str = str.toLowerCase();
        char [] ch = str.toCharArray();

        int countVowels = 0;
        int countConsonants = 0;
        int countSymbols = 0;

        for (char c : ch) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    ++countVowels;
                } else {
                    ++countConsonants;
                }
            } else {
                ++countSymbols;
            }

        }
        System.out.printf("Vowels %d, Consonants %d, Symbols %d",
                countVowels,countConsonants,countSymbols);
    }

    public static boolean containsIntegers(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static boolean isStringEmpty(String str) {
        try {
            if (str.length() < 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Null string");
        }
        return false;
    }

    public static void swapStringsInPlace(String str1, String str2) {
        System.out.println("Strings before swapping: " + str1 + " " + str2);

        str1 = str1 + str2;
        str2 = str1.substring(0, (str1.length() - str2.length()));
        str1 = str1.substring(str2.length());

        System.out.println("Strings after swapping: " + str1 + " " + str2);
    }

    public static boolean isRotation(String str1, String str2) {
        str1 = str1.concat(str1);
        return str1.contains(str2);
    }

    public static boolean isAnagram(String str1, String str2) {
        str1 = str1.toLowerCase().replaceAll("\\s","");
        str2 = str2.toLowerCase().replaceAll("\\s","");

        if (str1.length() != str2.length()) {
            return false;
        }
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a,b);
    }

    public static boolean isPangram(String str) {
        str = str.toUpperCase().replaceAll("\\s","");
        if (str.length() < 26) {
            return false;
        }

        char [] ch = str.toCharArray();
        int [] arr = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        for (char c : ch) {
            arr[c - 65] = 1;
        }
        Arrays.stream(arr).forEach(System.out::print);

        for (int data: arr) {
            if (data == 0) {
                return false;
            }
        }
        return true;
    }

    public static String deleteOccurence(String str, char ch) {
        char [] arr = str.toCharArray();
        StringBuilder str2 = new StringBuilder();
        for (char data: arr) {
            if (data != ch) {
                str2.append(data);
            }
        }
        return str2.toString();
    }

    public static int wordsInSentence(String str) {
        return str.split(" ").length;
    }

    public static int wordsInSentenceToo(String str)  {
        char [] ch = str.toCharArray();

        int words = 1;
        for (int data: ch) {
            if (data == ' ') {
                ++words;
            }
        }
        return words;
    }

    public static Map<Character,Integer> stringToMap(String str) {
        str = str.toLowerCase();
        char [] ch = str.toCharArray();
        Map<Character,Integer> map = new LinkedHashMap<>();

        for (char data: ch) {
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data,1);
            }
        }
        return map;
    }

    public static boolean mapHasUniqueCharacters(Map <Character,Integer> map) {
        for (Map.Entry<Character,Integer> data: map.entrySet()) {
            if (data.getValue() > 1) {
                return false;
            }
        }
        return true;
    }

    public static void printNonRepeatedCharacters(Map<Character,Integer> map) {
        map.forEach((k,v) -> {
            if (v == 1) {
                System.out.print(k);
            }
        });
    }

    public static char firstNonRepeatingCharacter(LinkedHashMap<Character,Integer> lhmap) {
        for (Map.Entry<Character, Integer> data: lhmap.entrySet()) {
            if (data.getValue() == 1) {
                return data.getKey();
            }
        }
        return ' ';
    }

    public static String removeDuplicates(String str) {
        Map<Character,Integer> lhmap = stringToMap(str);
        StringBuilder uniqueValues = new StringBuilder();
        for (Map.Entry<Character,Integer> data: lhmap.entrySet()) {
            uniqueValues.append(data.getKey());
        }
        return uniqueValues.toString();
    }

    public static int convertStringToInteger(String str) {
        return Integer.parseInt(str);
    }

    public static String convertIntegerToString(int i) {
        return String.valueOf(i);
    }

}
