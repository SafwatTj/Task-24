import java.util.Objects;

public class BankAccount {
    private final Person owner;
    private final String IBAN;
    private double balance;

    public BankAccount(Person owner, String IBAN, double balance) {
        this.owner = owner;
        this.IBAN = IBAN;
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    public String getIBAN() {
        return IBAN;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccount account = (BankAccount) o;

        if (Double.compare(account.balance, balance) != 0) return false;
        if (!Objects.equals(owner, account.owner)) return false;
        return Objects.equals(IBAN, account.IBAN);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = owner != null ? owner.hashCode() : 0;
        result = 31 * result + (IBAN != null ? IBAN.hashCode() : 0);
        temp = Double.doubleToLongBits(balance);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s  %5.2f %s", IBAN, balance, owner);
    }
}
