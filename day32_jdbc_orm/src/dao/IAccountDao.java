package dao;

import entity.Account;

/**
 * @author Richard
 * 2020/12/16 10:12
 */
public interface IAccountDao {

    /**
     * 转入金额
     *
     * @param inName 转入用户名
     * @param money  金额
     * @return 受影响的行数
     */
    int inMoney(String inName, Double money);

    /**
     * 转出金额
     *
     * @param outName 转出用户名
     * @param money   金额
     * @return 受影响的行数
     */
    int outMoney(String outName, Double money);

    /**
     * 根据用户名查找用户
     *
     * @param name 用户名
     * @return Account对象
     */
    Account getAccountByName(String name);
}
