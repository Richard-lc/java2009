package service.impl;

import dao.IAccountDao;
import dao.impl.AccountDaoImpl;
import entity.Account;
import service.IAccountService;
import utils.DBUtils;

/**
 * @author Richard
 * 2020/12/16 11:53
 */
public class AccountServiceImpl implements IAccountService {

    //关联Dao层
    IAccountDao accountDao = new AccountDaoImpl();

    @Override
    public void transfer(String username, String password, String outName, Double money) {
        //数据校验
        if (username == null || username.length() == 0) {
            System.err.println("用户名不能为空！");
            return;
        }
        Account account = accountDao.getAccountByName(username);
        if (account == null) {
            System.err.println("用户不存在！");
            return;
        }
        if (!account.getPassword().equals(password)) {
            System.err.println("用户名与密码不匹配！");
            return;
        }
        Account outAccount = accountDao.getAccountByName(outName);
        if (outAccount == null) {
            System.err.println("对方账户不存在！");
            return;
        }
        if (money > account.getBalance()) {
            System.err.println("余额不足！");
            return;
        }

        //开启事务，进行转账
        DBUtils.beginTransaction();

        try {
            //转出余额
            accountDao.outMoney(username, money);
            //模拟出现异常
            //int i = 10 / 0;
            //转入余额
            accountDao.inMoney(outName, money);
            //未出现异常，提交事务
            DBUtils.commit();
            System.out.println("转账成功！");
        } catch (Exception e) {
            System.err.println("转账失败！");
            //出现异常，回滚事务
            DBUtils.rollback();
        }
    }
}
