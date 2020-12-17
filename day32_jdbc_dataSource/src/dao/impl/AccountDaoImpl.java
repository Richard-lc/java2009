package dao.impl;

import dao.IAccountDao;
import entity.Account;
import utils.DaoUtils;

import java.util.List;

/**
 * @author Richard
 * 2020/12/16 10:15
 */
public class AccountDaoImpl implements IAccountDao {
    @Override
    public int inMoney(String inName, Double money) {
        String sql = "update t_account set balance = balance + ? where name = ?";
        return DaoUtils.commonUpdate(sql, money, inName);
    }

    @Override
    public int outMoney(String outName, Double money) {
        String sql = "update t_account set balance = balance - ? where name = ?";
        return DaoUtils.commonUpdate(sql, money, outName);
    }

    @Override
    public Account getAccountByName(String name) {
        String sql = "select * from t_account where name = ?";
        List<Account> accounts = DaoUtils.commonQuery(sql, Account.class, name);
        if (accounts == null || accounts.size() == 0) {
            return null;
        }
        return accounts.get(0);
    }
}
