class Solution {
    public static String intToRoman(int num) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num / 1000; i++) {
            sb.append("M");
        }
        num %= 1000;

        if (num >= 900) {
            sb.append("CM");
            num -= 900;
        }

        for (int i = 0; i < num / 500; i++) {
            sb.append("D");
        }
        num %= 500;

        if (num >= 400) {
            sb.append("CD");
            num -= 400;
        }

        for (int i = 0; i < num / 100; i++) {
            sb.append("C");
        }
        num %= 100;

        if (num >= 90) {
            sb.append("XC");
            num -= 90;
        }

        for (int i = 0; i < num / 50; i++) {
            sb.append("L");
        }
        num %= 50;

        if (num >= 40) {
            sb.append("XL");
            num -= 40;
        }


        for (int i = 0; i < num / 10; i++) {
            sb.append("X");
        }
        num %= 10;

        if (num == 9) {
            sb.append("IX");
            num -= 9;
        }

        for (int i = 0; i < num / 5; i++) {
            sb.append("V");
        }
        num %= 5;

        if (num == 4) {
            sb.append("IV");
            num -= 4;
        }


        for (int i = 0; i < num; i++) {
            sb.append("I");
        }

        return sb.toString();
    }
}