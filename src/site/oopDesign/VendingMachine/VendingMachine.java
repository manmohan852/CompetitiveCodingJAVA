package site.oopDesign.VendingMachine;

import java.util.List;

public interface VendingMachine {
    public int selectIntemAndGetPrice(Item item);
    public void insertCoin(Coin coin);
    public List<Coin> refund();
    public Bucket<Item,List<Coin>> collectITEmAndChange();
    public void reset();
    public long getTotalSales();




}
