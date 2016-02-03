import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Utils {

    //Question1
    public static List<Extension> sortByName(List<Extension> extensions) {
        /*
            steps:
                1. map to ComparableData
                2. sort
                3. map to Data
         */
        return extensions.stream()
                .map((extension) -> new ComparableData<>(extension.getFirstName() + extension.getLastName(), extension))
                .sorted((data1, data2) -> data1.getComparable().compareTo(data2.getComparable()))
                .map((data) -> data.getData())
                .collect(Collectors.toList());

    }


    //Question2
    public static List<Extension> sortByExtType(List<Extension> extensions) {
        return extensions.stream()
                .sorted((e1, e2) -> e1.getExtType().compareTo(e2.getExtType()))
                .collect(Collectors.toList());
    }

    //Question3
    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {

        List<QuarterSalesItem> result = new ArrayList<>();
        for (Quarter quarter : Quarter.values()) {
            result.add(getDataSumByQuarter(saleItems, quarter));
        }
        return result;
    }

    /**
     * Get the sum of the quarter
     *
     * @param saleItems saleItems
     * @param quarter   season  quarter
     * @return QuarterSalesItem
     */
    private static QuarterSalesItem getDataSumByQuarter(List<SaleItem> saleItems, Quarter quarter) {
        return new QuarterSalesItem(quarter.getNumber(), getQuarterDoubleStream(saleItems, quarter).sum());
    }


    /**
     * Get temp state  from quarter handling
     *
     * @param saleItems saleItems
     * @param quarter   season  quarter
     * @return DoubleStream
     */
    private static DoubleStream getQuarterDoubleStream(List<SaleItem> saleItems, Quarter quarter) {
        return saleItems.stream()
                .filter(salesItem -> quarter.getFromMonth() <= salesItem.getMonth() && salesItem.getMonth() <= quarter.getToMonth())
                .mapToDouble(salesItem -> salesItem.getSaleNumbers());

    }

    //Question4
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
        List<QuarterSalesItem> result = new ArrayList<>();
        for (Quarter quarter : Quarter.values()) {
            result.add(getDataMaxByQuarter(saleItems, quarter));
        }
        return result;
    }

    /**
     * Get the max data of the quarter
     *
     * @param saleItems saleItems
     * @param quarter   season  quarter
     * @return QuarterSalesItem
     */
    private static QuarterSalesItem getDataMaxByQuarter(List<SaleItem> saleItems, Quarter quarter) {
        return new QuarterSalesItem(quarter.getNumber(),
                getQuarterDoubleStream(saleItems, quarter).max().getAsDouble());

    }

    //Question5

    /**
     * We have all Keys: 0-9;
     * usedKeys is an array to store all used keys like :[2,3,4];
     * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,]
     */

    public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
        return Arrays.stream(allKeys)
                .filter(key -> !contains(usedKeys, key))
                .toArray();
    }

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

}
