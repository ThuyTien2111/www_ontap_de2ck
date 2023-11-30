package vn.edu.iuh.fit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.dao.CheckingAccDao;
import vn.edu.iuh.fit.dao.SavingAccDao;
import vn.edu.iuh.fit.dao.TransactionDao;
import vn.edu.iuh.fit.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerControll {
    private CheckingAccDao checkingAccDao;
    private TransactionDao transactionDao;
    private SavingAccDao savingAccDao;
    @Autowired
    public CustomerControll(CheckingAccDao checkingAccDao, TransactionDao transactionDao, SavingAccDao savingAccDao) {
        this.checkingAccDao = checkingAccDao;
        this.transactionDao = transactionDao;
        this.savingAccDao = savingAccDao;
    }

    @GetMapping("/customer-login")
    public String showCustomerLoginForm(){
        return "customer-login";
    }
    @PostMapping("/customer-login")
    public String customerLogin(@RequestParam String username,
                               @RequestParam String password, Model model){
        Customer customer=checkingAccDao.getAcc(username).getCustomer();
        if(checkingAccDao.loginAcc(username, password)){
            return "redirect:/customers/"+customer.getCus_id()+"/"+username;
        }else {
            model.addAttribute("error", "Sai thông tin đăng nhập");
            return "customer-login";
        }
    }
    @GetMapping("/customers/{cusID}/{mainAccNo}")
    public String showAccountsOfCus(@PathVariable long cusID,
                                    @PathVariable String mainAccNo, Model model){
        Customer customer=checkingAccDao.getCustomer(cusID);
        Account mainAcc=checkingAccDao.getAcc(mainAccNo);
        List<CheckingAccount> checkingAccounts=checkingAccDao.getCheckingAccByCustomer(cusID);
        List<SavingAccount> savingAccounts=checkingAccDao.getSavingAccByCustomer(cusID);
        Map<SavingAccount, Double> map=new HashMap<>();
        for (SavingAccount savingAccount:savingAccounts){
            map.put(savingAccount, savingAccDao.getInterestAmountByAccount(savingAccount.getAccount().getAcc_no()));
        }
        model.addAttribute("customer", customer);
        model.addAttribute("mainAcc", mainAcc);
        model.addAttribute("checkingAccounts", checkingAccounts);
        model.addAttribute("map", map);
        return "accounts";
    }
    @GetMapping("/history/{accNo}")
    public String getHistoryOfAccount(@PathVariable String accNo, Model model){
        List<TransferTransaction> earnMoneyTransactions=transactionDao.getEarnMoneyByAccount(accNo);
        List<TransferTransaction> transferTransactions=transactionDao.getStatementTransferByAccount(accNo);
        List<WithdrawlTransaction> withdrawlTransactions=transactionDao.getStatementWidthdrawlByAccount(accNo);
        model.addAttribute("earnMoneyTransactions", earnMoneyTransactions);
        model.addAttribute("transferTransactions", transferTransactions);
        model.addAttribute("withdrawlTransactions", withdrawlTransactions);
        return "history";
    }
}
