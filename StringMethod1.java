import java.util.Arrays;

class StringMethod1 {
    public static void main(String args[]) {

        String s1 = "  Java Programming  ";
        String s2 = "language";
        String s3 = "Java is fun,java is powerful language";

        // trim() → removes leading and trailing spaces
        System.out.println("Before trim: '" + s1 + "'");
        s1 = s1.trim();
        System.out.println("After trim: '" + s1 + "'");

        // substring(beginIndex) → returns substring from given index
        System.out.println("Substring from index 3: " + s1.substring(3));

        // substring(beginIndex, endIndex) → returns substring between given range (endIndex excluded)
        System.out.println("Substring from index 5 to 12: " + s1.substring(5, 13));

        // contains() → checks whether string contains the given sequence
        System.out.println("s3 contains Java: " + s3.contains("Java")); // case-sensitive

        // compareTo() → returns difference based on lexicographical comparison
        // if result = 0 → strings equal
        // if result < 0 → s1 < s2
        // if result > 0 → s1 > s2
        System.out.println("Comparing s1 and s2: " + s1.compareTo(s2));

        // toCharArray() → converts string into character array
        char ch[] = s2.toCharArray();
        System.out.println("Character array of s2: " + Arrays.toString(ch));

        // split() → splits string into multiple strings based on delimiter
        String str[] = s3.split(" ");
        System.out.println("Words after split: " + Arrays.toString(str));

        // concat() → joins two strings
        s1 = s1.concat(s2);
        System.out.println("After concat: " + s1);

        // isEmpty() → checks if string is empty (length == 0)
        System.out.println("Is s1 empty?: " + s1.isEmpty());
    }
}
