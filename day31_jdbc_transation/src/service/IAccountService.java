package service;

/**
 * @author Richard
 * 2020/12/16 11:50
 */
public interface IAccountService {
    /**
     * 转账方法
     *
     * @param username 用户名
     * @param password 密码
     * @param outName  对方用户名
     * @param money    转账金额
     */
    void transfer(String username, String password, String outName, Double money);
}
