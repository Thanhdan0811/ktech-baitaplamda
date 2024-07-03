package bai1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Bai1 {
    public static void main(String[] args) {

        Function<Integer, Integer> soPrimeUocMax = Bai1::timSoPrimeUocLonNhat;

        System.out.println("is prime : " + soPrimeUocMax.apply(38));

        timSoPrimeUocLonNhatCach2(28);

    }

    // Cách dùng steam
    public static int timSoPrimeUocLonNhatCach2(int x) {
        ArrayList<Integer> listUocChung = new ArrayList<>();
        int halfX = x / 2;
        for(int i = 1; i <= halfX; i++) {
            int res = x / i;
            if(x % i != 0) continue;
            listUocChung.add(i);
            listUocChung.add(res);
        }

        int max =  listUocChung.stream().distinct()
                .filter(num -> isPrime(num)).max(Integer::compare).get();

        System.out.println("list uoc chung: " + max);

        return max;

    }

    // Tìm số nguyên tố là ước lớn nhất của 1 số cách 1
    // tìm ra từng số và check xem có là số nguyên tố lớn nhất ko
    // cần thêm hàm check xem là số nguyên tố không.
    public static int timSoPrimeUocLonNhat(int x) {
        if(x == 0 || x == 1) return -1;
        if(x == 2 || x == 3) return x;
        if(isPrime(x)) return x;
        // chỉ tính từ 1 đến 1 nửa của x
        int m = x / 2;
        int i = 1;
        int max = 1;
        while (i <= m) {
            // không chia hết thì tính tiếp số i tiếp theo
            if((x % i) != 0) {
                i++;
                continue;
            }
            int res = x / i;
            boolean checkI = isPrime(i);
            boolean checkRes = isPrime(res);
            if(checkI && checkRes) {
                max = Math.max(max, i);
                max = Math.max(max, res);
            } else if (checkI) {
                max = Math.max(max, i);
            } else if(checkRes) {
                max = Math.max(max, res);
            }
            i++;
        }
        return max;
    }

    // Check xem là số nguyên tố hay không.
    public static boolean isPrime(int x) {
        if(x < 2) return false;
        if(x == 2 || x == 3 || x == 5 || x == 7) return true;
        int m = x / 2;
        int i = 2;
        while (true) {
            if(i > m) break;
            if(x % i == 0) return false;
            i++;
        }
        return true;
    }


}
