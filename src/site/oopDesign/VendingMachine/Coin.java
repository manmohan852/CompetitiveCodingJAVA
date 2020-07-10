package site.oopDesign.VendingMachine;

public enum Coin {
    PENNY(1),NICKLE(5),DIME(10),QUARTER(25);
    public int denomination;

    private Coin(int denomination){
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }
}
