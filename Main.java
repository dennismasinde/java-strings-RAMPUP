public class Main {

    public static void main(String[] args) {
        System.out.println("The length of the string is " + lengthString("dennis"));
        System.out.println("Replica values " + copyString("dennis"));
        System.out.println(reverseString("dennis"));
        System.out.println(palindromeCheck("too hot To HooT"));
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
}
