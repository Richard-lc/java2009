package controller;

import service.IAccountService;
import service.impl.AccountServiceImpl;

/**
 * @author Richard
 * 2020/12/16 12:51
 */
public class AccountController {
    public static void main(String[] args) {

        //模拟用户输入
        String username = "张三";
        String password = "123";
        String outName = "李四";
        Double money = 200.0;

        //实例化Service层
        IAccountService accountService = new AccountServiceImpl();
        //调用转账方法
        accountService.transfer(username, password, outName, money);
    }
}
