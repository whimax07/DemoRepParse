public class Main {

    public static void main(String[] args) {
        System.out.println(Tokenizer.tokenizer("1110"));
        System.out.println(Tokenizer.tokenizer("10 * 20 + 30"));
        System.out.println(Tokenizer.tokenizer("10 * -20 + 30"));
        System.out.println(Tokenizer.tokenizer("0x10 * -20 + 0b1110"));
        System.out.println(Tokenizer.tokenizer("0x10 * -20 - 0b1110"));
    }

}
