
class Bank {

    long bank[];
    int n;

    public Bank(long[] balance) {
        n = balance.length;
        bank = balance;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!isValid(account1) || (!isValid(account2))) {
            return false;
        }
        if (bank[account1 - 1] >= money) {
            bank[account1 - 1] -= money;
            bank[account2 - 1] += money;
            return true;
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        if (!isValid(account)) {
            return false;
        }
        bank[account - 1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValid(account)) {
            return false;
        }
        if (bank[account - 1] >= money) {
            bank[account - 1] -= money;
            return true;
        }
        return false;
    }

    private boolean isValid(int account) {
        return account >= 1 && account <= n;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
