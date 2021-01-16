package lesson2.exceptions;

public class TwoArgsSummer {

    public int processString(String src) {
        String[] args = src.split(" ");
        if (args.length != 2) {
            throw new IllegalArgumentException("Processed string contains not a two args");
        }
        try {
            return getInt(args[0]) + getInt(args[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException("Each arg should be int");
        }
    }

    private int getInt(String s) {
        return Integer.parseInt(s);
    }
}
