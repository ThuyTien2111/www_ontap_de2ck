package vn.edu.iuh.fit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import vn.edu.iuh.fit.dao.CheckingAccDao;
import vn.edu.iuh.fit.dao.ManagerDao;
import vn.edu.iuh.fit.dao.SavingAccDao;
import vn.edu.iuh.fit.dao.TransactionDao;
import vn.edu.iuh.fit.entity.Manager;

@SpringBootApplication
public class De2CkApplication {
    public static void main(String[] args) {
       ConfigurableApplicationContext context=SpringApplication.run(De2CkApplication.class, args);
        ManagerDao managerDao=context.getBean(ManagerDao.class);
//        managerDao.getListManager().forEach(m->System.out.println(m.toString()));
        CheckingAccDao checkingAccDao=context.getBean(CheckingAccDao.class);
//        checkingAccDao.getMaxBalanceCheckingAcc().forEach(ca->System.out.println(ca.toString()));
//        checkingAccDao.getNotInTransactionCheckingAcc().forEach(ca->System.out.println(ca.toString()));
        TransactionDao transactionDao=context.getBean(TransactionDao.class);
//        transactionDao.getNumberTransOrderByMonth().entrySet().forEach(entry->{
//            System.out.println(entry.getKey()+": "+entry.getValue());
//        });
//        transactionDao.getStatementByAccount("987654321").forEach(tr->System.out.println(tr.toString()));
//        transactionDao.getEarnMoneyByAccount("987654321").forEach(tr->System.out.println(tr.toString()));
        SavingAccDao savingAccDao=context.getBean(SavingAccDao.class);
//        System.out.println(savingAccDao.getInterestAmountByAccount("3111222333"));
//        System.out.println(managerDao.loginManager(2,"987-654-3210" ));
//        System.out.println(managerDao.addManager(new Manager("tien","0388495421")));
//        System.out.println(managerDao.updateManager(new Manager(11,"tien","0388495421", 2)));
//        System.out.println(managerDao.deleteManager(11));
//        System.out.println(managerDao.activeManager(11));
        System.out.println(managerDao.getManager(11));


    }
}
