package site.oopDesign.VendingMachine;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VendingMachineImplTest {
    private static VendingMachine vendingMachine;

    public VendingMachineImplTest() {
    }

    @BeforeClass
    public static void setUp() {
        vendingMachine = VendingMachineFactory.createVendingMachine();
    }

    @AfterClass
    public static void tearDown() {
        vendingMachine = null;
    }

    @Test
    public void testBuyWithExactPrice() {
        long price = vendingMachine.selectIntemAndGetPrice(Item.COKE);
        assertEquals(Item.COKE.getPrice(), price);
        vendingMachine.insertCoin(Coin.QUARTER);

        Bucket<Item, List<Coin>> bucket = vendingMachine.collectITEmAndChange();
        Item item = bucket.getFirst();
        List<Coin> changes = bucket.getSecond();

        assertEquals(Item.COKE, item);
        assertTrue(changes.isEmpty());
    }

    @Test
    public void testBuyWithMorePrice() {
        long price = vendingMachine.selectIntemAndGetPrice(Item.SODA);
        assertEquals(Item.SODA.getPrice(), price);

        vendingMachine.insertCoin(Coin.QUARTER);
        vendingMachine.insertCoin(Coin.QUARTER);

        Bucket<Item, List<Coin>> bucket = vendingMachine.collectITEmAndChange();
        Item item = bucket.getFirst();
        List<Coin> changes = bucket.getSecond();

        assertEquals(Item.SODA, item);
        assertTrue(!changes.isEmpty());

        assertEquals(50 - Item.SODA.getPrice(), getTotal(changes));
    }

    @Test
    public void testRefund() {
        long price = vendingMachine.selectIntemAndGetPrice(Item.PEPSI);
        assertEquals(Item.PEPSI.getPrice(), price);

        vendingMachine.insertCoin(Coin.DIME);
        vendingMachine.insertCoin(Coin.NICKLE);
        vendingMachine.insertCoin(Coin.PENNY);
        vendingMachine.insertCoin(Coin.QUARTER);

        assertEquals(41, getTotal(vendingMachine.refund()));

    }

    @Test(expected = SoldOutException.class)
    public void testSoldOut() {
        for (int i = 0; i < 7; i++) {
            vendingMachine.selectIntemAndGetPrice(Item.COKE);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.collectITEmAndChange();
        }
    }

    @Test(expected = SoldOutException.class)
    public void testRest() {
        VendingMachine vendingMachine1 = VendingMachineFactory.createVendingMachine();
        vendingMachine1.reset();
        vendingMachine1.selectIntemAndGetPrice(Item.COKE);
    }

    @Test(expected = NotSufficientChangeException.class)
    public void testNSCE() {
        for (int i = 0; i < 5; i++) {
            vendingMachine.selectIntemAndGetPrice(Item.SODA);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.collectITEmAndChange();

            vendingMachine.selectIntemAndGetPrice(Item.PEPSI);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.insertCoin(Coin.QUARTER);
            vendingMachine.collectITEmAndChange();
        }
    }

    @Ignore
    public void testVendingMachine() {
        VendingMachine vm = new VendingMachineImpl();
    }

    public long getTotal(List<Coin> changes) {
        long total = 0l;
        for (Coin coin : changes) {
            total += coin.getDenomination();
        }
        return total;
    }


}