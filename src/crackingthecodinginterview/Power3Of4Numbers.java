package crackingthecodinginterview;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Bi on 7/28/18.
 */
public class Power3Of4Numbers {
    public static void main(String[] args) {
//        power3Of4Numbers();
//        power3Of4Numbers2();
//        power3Of4Numbers3();
        power3Of4Numbers4();
    }

    public static void power3Of4Numbers() {
        int count = 0;
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int c = 1; c <= 100; c++) {
                    for (int d = 1; d <= 100; d++) {
                        if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
                            System.out.println(a + " " + b + " " + c + " " + d);
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }

    public static void power3Of4Numbers2() {
        int count = 0;
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int c = 1; c <= 100; c++) {
                    for (int d = 1; d <= 100; d++) {
                        if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
                            System.out.println(a + " " + b + " " + c + " " + d);
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void power3Of4Numbers3() {
        int count = 0;
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int c = 1; c <= 100; c++) {
                    double d = Math.pow((Math.pow(a, 3) + Math.pow(b, 3) - Math.pow(c, 3)), 1.0 / 3.0);
                    if (a == 2 && b == 1 && c == 1) {
                        System.out.println("Spec: " + a + " " + b + " " + c + " " + d);
                    }
                    if (Math.pow(a, 3) + Math.pow(b, 3) == Math.pow(c, 3) + Math.pow(d, 3)) {
                        System.out.println(a + " " + b + " " + c + " " + d);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void power3Of4Numbers4() {
        Hashtable<Integer, List<Pair>> table = new Hashtable<>();

        for (int c = 1; c <= 100; c++) {
            for (int d = 1; d <= 100; d++) {
                int result = (int) (Math.pow(c, 3) + Math.pow(d, 3));
                List<Pair> pairs;

                if (table.containsKey(result)) {
                    pairs = table.get(result);
                } else {
                    pairs = new ArrayList<>();
                }

                pairs.add(new Pair(c, d));
                table.put(result, pairs);
            }
        }

        int count = 0;
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                int result = (int) (Math.pow(a, 3) + Math.pow(b, 3));

                for (Pair p: table.get(result)) {
                    System.out.println(a + " " + b + " " + p.a + " " + p.b);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}