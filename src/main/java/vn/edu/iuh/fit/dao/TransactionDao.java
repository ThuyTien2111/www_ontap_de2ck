package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.entity.Transaction;
import vn.edu.iuh.fit.entity.TransferTransaction;
import vn.edu.iuh.fit.entity.WithdrawlTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TransactionDao {
    private EntityManager manager;
    @Autowired
    public TransactionDao(EntityManager manager) {
        this.manager = manager;
    }
    public Map<String, Long> getNumberTransOrderByMonth(){
        Map<String, Long> map=new HashMap<>();
        try {
            String sql="SELECT DATE_FORMAT(AtDate, '%m-%Y') AS MonthYear, COUNT(*) AS totalTrans  \n" +
                    "FROM transaction\n" +
                    "GROUP BY MonthYear";
            List<Object[]> objects=manager.createNativeQuery(sql, Object[].class).getResultList();
            for (Object[] obj:objects) {
                map.put((String) obj[0], (Long) obj[1]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
    public List<Transaction> getStatementByAccount(String accNo){
        List<Transaction> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM transaction\n" +
                    "WHERE AccountNo IN (SELECT AccountID FROM checkingaccount)\n" +
                    "AND AccountNo=?";
            Query query=manager.createNativeQuery(sql, Transaction.class);
            query.setParameter(1, accNo);
            list=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<TransferTransaction> getStatementTransferByAccount(String accNo){
        List<TransferTransaction> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM transfertrans\n" +
                    "WHERE TransID IN(\n" +
                    "SELECT TransID FROM transaction\n" +
                    "WHERE AccountNo IN (SELECT AccountID FROM checkingaccount)\n" +
                    "AND AccountNo=? AND TransID IN (SELECT TransID FROM transfertrans)\n" +
                    ")";
            Query query=manager.createNativeQuery(sql, TransferTransaction.class);
            query.setParameter(1, accNo);
            list=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<WithdrawlTransaction> getStatementWidthdrawlByAccount(String accNo){
        List<WithdrawlTransaction> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM withdrawltrans\n" +
                    "WHERE TransID IN(\n" +
                    "SELECT TransID FROM transaction\n" +
                    "WHERE AccountNo IN (SELECT AccountID FROM checkingaccount)\n" +
                    "AND AccountNo=? AND TransID IN (SELECT TransID FROM withdrawltrans)\n" +
                    ")";
            Query query=manager.createNativeQuery(sql, WithdrawlTransaction.class);
            query.setParameter(1, accNo);
            list=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public List<TransferTransaction> getEarnMoneyByAccount(String accNo){
        List<TransferTransaction> list=new ArrayList<>();
        try{
            String sql="SELECT * FROM transfertrans\n" +
                    "WHERE ToAccountID IN (SELECT AccountID FROM checkingaccount)\n" +
                    "AND ToAccountID=?";
            Query query=manager.createNativeQuery(sql, TransferTransaction.class);
            query.setParameter(1, accNo);
            list=query.getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
