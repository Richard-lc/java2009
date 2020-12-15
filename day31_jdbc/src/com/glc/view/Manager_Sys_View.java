package com.glc.view;

import com.glc.controller.IUserController;
import com.glc.controller.impl.UserControllerImpl;

/**
 * @author Richard
 * 2020/12/15 11:29
 */
public class Manager_Sys_View {
    public static void main(String[] args) {
        IUserController userController = new UserControllerImpl();
        userController.menu();
    }
}
