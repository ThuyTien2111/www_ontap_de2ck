package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.dao.CheckingAccDao;
import vn.edu.iuh.fit.entity.CheckingAccount;

import java.util.List;

@Controller
public class CheckingAccControll {
    private CheckingAccDao checkingAccDao;

    @Autowired
    public CheckingAccControll(CheckingAccDao checkingAccDao) {
        this.checkingAccDao = checkingAccDao;
    }
    @GetMapping("/max-balance")
    public String getMaxBalanceCheckingAcc(Model model){
        List<CheckingAccount> accounts=checkingAccDao.getMaxBalanceCheckingAcc();
        model.addAttribute("accounts", accounts);
        return "max-balance";
    }
    @GetMapping("/not-transaction")
    public String getNotTransactionCheckingAcc(Model model){
        List<CheckingAccount> accounts=checkingAccDao.getNotInTransactionCheckingAcc();
        model.addAttribute("accounts", accounts);
        return "not-transaction";
    }
}
