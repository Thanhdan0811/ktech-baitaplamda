package bai2;

import java.util.function.Function;

public class Bai2 {
    public static void main(String[] args) {
        // Cách dùng built-in có sẵn
        Function<Integer, String> binaryStr = Integer::toBinaryString;
        System.out.println(binaryStr.apply(123));

        // từ hàm custom
        Function<Integer, String> binaryStr2 = Bai2::binaryFromInt;
        System.out.println(binaryStr2.apply(123));
    }

    public static String binaryFromInt(int x) {
        StringBuilder binaryStr = new StringBuilder();
        int y = x / 2;
        int z = x % 2;
        x = y;
        binaryStr.append(z);
        while(y != 0) {
            y = x / 2;
            z = x % 2;
            x = y;
            binaryStr.insert(0, z);
        }

        return binaryStr.toString();

    }

}
