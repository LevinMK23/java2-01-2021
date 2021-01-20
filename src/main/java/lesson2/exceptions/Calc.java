package lesson2.exceptions;

public class Calc {

    public long sum(String[][] data) {
        if(data == null) {
            String message = "Array size not 4x4, " +
                    "actually array: is null";
            throw new ArraySizeException(message);
        }
        if (data.length == 0) {
            String message = String.format("Array size not 4x4, " +
                    "actually size: %d x %d", 0, 0);
            throw new ArraySizeException(message);
        }
        if (data.length != 4) {
            String message = String.format("Array size not 4x4, " +
                    "actually size: %d x %d", data.length, data[0].length);
            throw new ArraySizeException(message);
        }
        for (String[] datum : data) {
            if (datum.length != 4) {
                String message = String.format("Array size not 4x4, " +
                        "actually size: %d x %d", data.length, datum.length);
                throw new ArraySizeException(message);
            }
        }

        long sum = 0;
        for (String[] datum : data) {
            for (String s : datum) {
                try {
                    sum += Integer.parseInt(s);
                } catch (Exception e) {
                    throw new ArrayDataException("Data could not parsed to int");
                }
            }
        }
        return sum;
    }

}
