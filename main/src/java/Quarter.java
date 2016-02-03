/**
 * Quarters enum
 * Created by Jadenz on 2016/2/2.
 */
public enum Quarter {
    FIRST_QUARTER(1, 1, 3),
    SECOND_QUARTER(2, 4, 6),
    THIRD_QUARTER(3, 7, 9),
    FORTH_QUARTER(4, 10, 12);


    private int number;
    private int fromMonth;
    private int toMonth;


    Quarter(int number, int fromMonth, int toMonth) {
        this.number = number;
        this.fromMonth = fromMonth;
        this.toMonth = toMonth;
    }

    public int getNumber() {
        return number;
    }

    public int getFromMonth() {
        return fromMonth;
    }

    public int getToMonth() {
        return toMonth;
    }
}
