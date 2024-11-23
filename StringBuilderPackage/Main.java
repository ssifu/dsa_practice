package StringBuilderPackage;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Sifat");
        int end = sb.length() - 1;
        int start = 0;

        while (start < end) {
            char front = sb.charAt(start);
            char back = sb.charAt(end);

            sb.setCharAt(start, back);
            sb.setCharAt(end, front);

            start++;
            end--;
        }

        System.out.println(sb);
    }
}
