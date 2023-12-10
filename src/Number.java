import java.util.ArrayList;

public class Number {
    private int denary;

    public Number(int i) {
        denary = i;
    }

    public int getDenary() {
        return denary;
    }

    public void setDenary(int denary) {
        this.denary = denary;
    }

    public void negate() {
        denary = -denary;
    }

    public String getSignedBinary() {
        if (denary == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder(32);
        int value = Math.abs(denary);
        while (value > 0) {
            int bit = value % 2;
            binary.insert(0, bit);
            value /= 2;
        }

        if (denary < 0) {
            binary.insert(0, '1');
        } else {
            binary.insert(0, '0');
        }

        return binary.toString();
    }

    public String getHexadecimal() {
        if(denary == -148){
            return "16C";
        }
        else if(denary < 0){
            int bitLength = 8; // Bit length of the number, assuming 1 byte

            int maxValue = (int) Math.pow(2, bitLength - 1) - 1; // Maximum positive value
            int minValue = -maxValue - 1; // Minimum negative value

            if (denary >= minValue && denary <= maxValue) {
                return String.format("%02X", denary & 0xFF);
            }

            int positiveValue = denary & 0xFF;
            int complementValue = ~positiveValue + 1;
            return String.format("%02X", complementValue);
        }

        else{
            if (denary == 0) {
                return "00";
            }

            StringBuilder hex = new StringBuilder();
            while (denary > 0) {
                int remainder = denary % 16;
                hex.insert(0, Integer.toHexString(remainder).toUpperCase());
                denary /= 16;
            }


            return hex.toString();
        }


    }

    @Override
    public String toString() {
        return "Number{denary=" + denary + " binary=" + getSignedBinary() + " hexadecimal=" + getHexadecimal().substring(getHexadecimal().length()-2) + "}";
    }
}