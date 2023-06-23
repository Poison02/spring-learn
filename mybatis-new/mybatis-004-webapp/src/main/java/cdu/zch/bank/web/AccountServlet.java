package cdu.zch.bank.web;

import cdu.zch.bank.exceptions.MoneyNotEnoughException;
import cdu.zch.bank.exceptions.TransferException;
import cdu.zch.bank.service.AccountService;
import cdu.zch.bank.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zch
 * @data 2023/6/23
 **/
@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    // 声明为一个实例变量
    private AccountService accountService = new AccountServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单数据
        String fromActno = req.getParameter("fromActno");
        String toActno = req.getParameter("toActno");
        double money = Double.parseDouble(req.getParameter("money"));
        // 调用service的转账方法完成转账
        try {
            accountService.transfer(fromActno, toActno, money);
            // 程序能走到这里，表示转账成功
            // 调用View完成展示结果
            resp.sendRedirect(req.getContextPath() + "/success.html");
        } catch (MoneyNotEnoughException e) {
            resp.sendRedirect(req.getContextPath() + "/error1.html");
        } catch (TransferException e) {
            resp.sendRedirect(req.getContextPath() + "/error2.html");
        }
    }
}
