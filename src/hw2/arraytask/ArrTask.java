package hw2.arraytask;

/**
 * array task
 *
 * @author Aleksandr Kurov
 * @version dated Авг. 19, 2018
 */
public class ArrTask {

    private static String msgLength = "MyArraySizeException: data length must be 4x4";
    private static String msgData = "MyArrayDataException: wrong data at element %d x %d, value is [%s]";

    public static int sumArrayElements(String[][] data) throws MyArraySizeException, MyArrayDataException {

        if (data.length != 4) throw new MyArraySizeException(msgLength);

        for (String[] row : data) {
            if (row.length !=4) throw new MyArraySizeException(msgLength);
        }

        int sum = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                try {
                    sum += Integer.parseInt(data[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format(msgData, i+1, j+1, data[i][j]));
                }
            }
        }

        return sum;
    }

}
