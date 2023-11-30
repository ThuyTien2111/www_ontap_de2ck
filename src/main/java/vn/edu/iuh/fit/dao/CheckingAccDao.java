package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.entity.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CheckingAccDao {
    private EntityManager manager;
    @Autowired
    public CheckingAccDao(EntityManager manager) {
        this.manager = manager;
    }
    //Ds checking account có balance cao nhat
    @Transactional
    public List<CheckingAccount> getMaxBalanceCheckingAcc(){
        List<CheckingAccount> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM checkingaccount\n" +
                    "WHERE AccountID IN (\n" +
                    "SELECT AccountNo FROM account\n" +
                    "WHERE Balance=(\n" +
                    "SELECT MAX(Balance) FROM account\n" +
                    "WHERE AccountNo IN ( \n" +
                    "SELECT AccountID FROM checkingaccount\n" +
                    ")) AND (AccountNo IN ( \n" +
                    "SELECT AccountID FROM checkingaccount\n" +
                    "))\n" +
                    ")";
            list=manager.createNativeQuery(sql, CheckingAccount.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    //ds checking account chua tung giao dich
    @Transactional
    public List<CheckingAccount> getNotInTransactionCheckingAcc(){
        List<CheckingAccount> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM checkingaccount \n" +
                    "WHERE AccountID NOT IN (\n" +
                    "SELECT DISTINCT AccountNo FROM transaction\n" +
                    "WHERE AccountNo IN (SELECT AccountID FROM checkingaccount)\n" +
                    ")";
            list=manager.createNativeQuery(sql, CheckingAccount.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public boolean loginAcc(String accNo, String pass){
        try{
            Account acc=manager.find(Account.class, accNo);
            if(acc==null){
                return false;
            }
            if(acc.getAcc_no().equalsIgnoreCase(accNo) && acc.getPin().equalsIgnoreCase(pass)){
                return true;
            }else return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public Account getAcc(String accNo){
        try{
            return manager.find(Account.class, accNo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Customer getCustomer(long cusID){
        try{
            return manager.find(Customer.class, cusID);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<CheckingAccount> getCheckingAccByCustomer(long cusID){
        List<CheckingAccount> list=new ArrayList<>();
        try{
            String sql="SELECT checkingaccount.* FROM checkingaccount\n" +
                    "INNER JOIN account on checkingaccount.AccountID=account.AccountNo\n" +
                    "WHERE CusID=?";
            Query query=manager.createNativeQuery(sql, CheckingAccount.class);
            query.setParameter(1, cusID);
            list=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<SavingAccount> getSavingAccByCustomer(long cusID){
        List<SavingAccount> list=new ArrayList<>();
        try{
            String sql="SELECT savingaccount.* FROM savingaccount\n" +
                    "INNER JOIN account on savingaccount.AccountID=account.AccountNo\n" +
                    "WHERE CusID=?";
            Query query=manager.createNativeQuery(sql, SavingAccount.class);
            query.setParameter(1, cusID);
            list=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
