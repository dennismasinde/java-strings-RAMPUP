import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("The length of the string is " + lengthString("dennis"));
        System.out.println("Replica values " + copyString("dennis"));
        System.out.println(reverseString("dennis"));
        System.out.println(palindromeCheck("too hot To HooT"));
        System.out.println(convertToUppercase("dennis masinde"));
        System.out.println(convertFirstLetterToUppercase("this is a sentence"));
        countVowelsConsonantsSymbols("asuyreas\\/");
        System.out.println();
        System.out.println(containsIntegers("0567891"));
        System.out.println(isAnagram("oMo","moO"));
        System.out.println(isPangram("the quick brown fox jumps over a lazy dog"));

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

}
