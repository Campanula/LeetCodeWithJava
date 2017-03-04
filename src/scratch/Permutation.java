package scratch;

/**
 * 对输入的字符串进行全排列
 */
public class Permutation {
    private char[] cs;

    public Permutation(String s) {
        this.cs = s.toCharArray();
    }

    public void sort(String sb) {
        for (int i = 0; i < cs.length; i++) {
            if (sb.indexOf(cs[i]) == -1) {
                String stmp = sb + cs[i];
                if (stmp.length() == cs.length) {
                    System.out.println(stmp);
                    break;
                }
                sort(stmp);
            }
        }
    }

    public static void main(String[] args) {
        Permutation test = new Permutation("abcde");
        String s = "";
        test.sort(s);
    }
}
