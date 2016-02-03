import junit.framework.Assert;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

/**
 * Sorting Utils testCases
 * Created by Jadenz on 2016/2/2.
 */
public class UtilsTest extends TestCase {

    List<Extension> initialExtensions;
    Extension albertExtension = new Extension("Albert", "Jones", "ext1", "TypeB");
    Extension billyWExtension = new Extension("Billy", "Wong", "ext1", "TypeA");
    Extension billyCExtension = new Extension("Billy", "Chen", "ext1", "TypeC");

    int[] allKeys = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    List<SaleItem> saleItems;

    @Before
    public void setUp() throws Exception {
        initialExtensions = new ArrayList<>();
        initialExtensions.add(albertExtension);
        initialExtensions.add(billyWExtension);
        initialExtensions.add(billyCExtension);

        saleItems = new ArrayList<>();
        //Q1 max 110.1, total 300.2
        saleItems.add(new SaleItem(100.1d, 1));
        saleItems.add(new SaleItem(90d, 2));
        saleItems.add(new SaleItem(110.1d, 3));
        //Q2 max 110, total 320
        saleItems.add(new SaleItem(100d, 4));
        saleItems.add(new SaleItem(110d, 5));
        saleItems.add(new SaleItem(110d, 6));
        //Q3 max 140, total 370
        saleItems.add(new SaleItem(140d, 7));
        saleItems.add(new SaleItem(120d, 8));
        saleItems.add(new SaleItem(110d, 9));
        //Q4 max 100, total 280
        saleItems.add(new SaleItem(100d, 10));
        saleItems.add(new SaleItem(90d, 11));
        saleItems.add(new SaleItem(90d, 12));

    }

    @Test
    public void testSortByName() {
        List<Extension> result = Utils.sortByName(initialExtensions);
        //Albert J >Billy C > Billy W
        Assert.assertEquals(albertExtension, result.get(0));
        Assert.assertEquals(billyCExtension, result.get(1));
        Assert.assertEquals(billyWExtension, result.get(2));
    }

    @Test
    public void testSortByExtType() {
        //Billy W > Albert J >Billy C
        List<Extension> result = Utils.sortByExtType(initialExtensions);
        Assert.assertEquals(billyWExtension, result.get(0));
        Assert.assertEquals(albertExtension, result.get(1));
        Assert.assertEquals(billyCExtension, result.get(2));
    }

    @Test
    public void testSumByQuarter() {
        List<QuarterSalesItem> result = Utils.sumByQuarter(saleItems);
        Assert.assertEquals(300.2d, result.get(0).getTotal());
        Assert.assertEquals(320d, result.get(1).getTotal());
        Assert.assertEquals(370d, result.get(2).getTotal());
        Assert.assertEquals(280d, result.get(3).getTotal());
    }


    @Test
    public void testMaxByQuarter() {
        List<QuarterSalesItem> result = Utils.maxByQuarter(saleItems);
        Assert.assertEquals(110.1d, result.get(0).getTotal());
        Assert.assertEquals(110d, result.get(1).getTotal());
        Assert.assertEquals(140d, result.get(2).getTotal());
        Assert.assertEquals(100d, result.get(3).getTotal());
    }

    @Test
    public void testGetUnUsedKeys() {
        int[] result = Utils.getUnUsedKeys(allKeys, new int[]{2, 3, 4});
        assertArrayEquals(new int[]{0, 1, 5, 6, 7, 8, 9}, result);
    }


}
