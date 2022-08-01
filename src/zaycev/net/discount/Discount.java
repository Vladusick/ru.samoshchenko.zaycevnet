package zaycev.net.discount;

public class Discount {

    public static void main(String[] args) {

        int[] price = {5, 100, 20, 66, 16};
        int discount = 50;
        int offset = 1;
        int readLength = 3;

        decryptData(price, discount, offset, readLength);

        display(price);
    }

    public static boolean checkDiscount(int discount) {
        if (discount >= 1 && discount <= 99) {
            return true;
        } else {
            System.err.println("Wrong range of values. Variable discount must be in the range from 1 to 99");
            return false;
        }
    }

    public static boolean checkOffset(int[] price, int offset) {
        if (offset >= 0 && offset <= price.length - 1) {
            return true;
        } else {
            System.err.println("Wrong range of values. Variable offset must be in the range from 0 to " + (price.length - 1));
            return false;
        }
    }

    public static boolean checkReadLength(int[] price, int readLength, int offset) {
        if (readLength >= 1 && readLength <= price.length - offset) {
            return true;
        } else {
            System.err.println("Wrong range of values");
            System.err.println("At the current value of the variable offset = " + offset);
            System.err.println("Variable readLength must be in the range from 1 to " + (price.length - offset));
            return false;
        }
    }

    public static int[] decryptData(int[] price, int discount, int offset, int readLength) {
        if (checkDiscount(discount) && checkOffset(price, offset) && checkReadLength(price, readLength, offset)) {
            for (int i = offset; i < offset + readLength; i++) {
                float discountValue = (float) (price[i] * (discount * 0.01));
                price[i] = (int) (price[i] - discountValue);
            }
        }
        return price;
    }

    public static void display(int[] price) {
        for (int i = 0; i < price.length; i++) {
            System.out.println(price[i]);
        }
    }
}


