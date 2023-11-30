package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SavingAccDao {
    private EntityManager manager;
    @Autowired
    public SavingAccDao(EntityManager manager) {
        this.manager = manager;
    }
    //Tính lợi nhuận cuối tháng cho tk tiết kiệm
    public double getInterestAmountByAccount(String accNo){
        double rs=0;
        try{
            String sql="SELECT (Balance*InterestRate) AS InterestAmount FROM savingaccount\n" +
                    "INNER JOIN account ON account.AccountNo=savingaccount.AccountID\n" +
                    "WHERE AccountNo=?";
            Query query=manager.createNativeQuery(sql);
            query.setParameter(1, accNo);
            rs= Double.parseDouble(query.getSingleResult().toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return rs;
    }
}
