package site.oopDesign.VendingMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine {

    private Inventory<Coin> cashInventory = new Inventory<>();
    private Inventory<Item> itemInventory = new Inventory<>();
    private long totalSales;
    private Item currentItem;
    private long currentBalance;

    public VendingMachineImpl() {
        initialize();
    }

    private void initialize() {
        for (Coin coin : Coin.values()) {
            cashInventory.put(coin, 5);
        }

        for (Item item : Item.values()) {
            itemInventory.put(item, 5);
        }
    }

    @Override
    public int selectIntemAndGetPrice(Item item) throws SoldOutException {
        if (itemInventory.hasItem((item))) {
            currentItem = item;
            return currentItem.getPrice();
        }
        throw new SoldOutException("Sold Out, Please buy another item");
    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);
    }

    @Override
    public Bucket<Item, List<Coin>> collectITEmAndChange() {
        Item item = collectItem();
        totalSales += currentItem.getPrice();
        List<Coin> changes = collectChange();
        return new Bucket<>(item,changes);
    }

    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException {
        if (isFullPaid()) {
            if(hasSufficientChangeForAmount(currentBalance - currentItem.getPrice())){
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not Sufficient Change Exception");
        }
        long remainingBalance = currentItem.getPrice()  - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining : ", remainingBalance);
    }

    private List<Coin> collectChange() {
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change =  getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    private boolean isFullPaid() {
        if (currentBalance >= currentItem.getPrice()) {
            return true;
        }
        return false;
    }

    private boolean hasSufficientChangeForAmount(long amount){
        try{
            getChange(amount);
        }catch(NotSufficientChangeException nsce){
            return false;
        }
        return true;
    }

    private List<Coin> getChange(long amount) throws NotSufficientChangeException {
        List<Coin> changes = Collections.emptyList();
        if (amount > 0) {
            changes = new ArrayList<>();
            long balance = amount;
            while (balance > 0) {
                if (balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance -= Coin.QUARTER.getDenomination();
                    continue;
                } else if (balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)) {
                    changes.add(Coin.DIME);
                    balance -= Coin.DIME.getDenomination();
                    continue;
                } else if (balance >= Coin.NICKLE.getDenomination() && cashInventory.hasItem(Coin.NICKLE)) {
                    changes.add(Coin.NICKLE);
                    balance -= Coin.NICKLE.getDenomination();
                    continue;
                } else if (balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)) {
                    changes.add(Coin.PENNY);
                    balance -= Coin.PENNY.getDenomination();
                    continue;
                } else {
                    throw new NotSufficientChangeException("Not Sufficient Change, Please try another product");
                }
            }
        }
        return changes;
    }

    @Override
    public void reset() {
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem = null;
        currentBalance = 0;
    }

    private void updateCashInventory(List<Coin> changes) {
        for (Coin c : changes) {
            cashInventory.deduct(c);
        }
    }

    public long getTotalSales() {
        return totalSales;
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    public void printStats(){
        System.out.println("Total Sales : " + totalSales);
        System.out.println("Current Item Inventory :  " + itemInventory);
        System.out.println("Current Cash Inventory" + cashInventory);
    }

}
