package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.edu.iuh.fit.entity.Manager;

import java.util.List;

@Repository
public class ManagerDao {
    private EntityManager manager;
    @Autowired
    public ManagerDao(EntityManager manager) {
        this.manager = manager;
    }
    @Transactional
    public boolean addManager(Manager man){
        try{
            if(man.getStatus()<0||man.getStatus()>2){
                return false;
            }
            long totalManager= (long) manager.createQuery("select count(m) from Manager m").getSingleResult();
            man.setMan_id(totalManager+1);
            man.setStatus(1);
            manager.persist(man);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean updateManager(Manager man){
        try{
            if(man.getStatus()<0||man.getStatus()>2){
                return false;
            }
            manager.merge(man);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean deleteManager(long manID){
        try{
            Manager man=manager.find(Manager.class, manID);
            man.setStatus(0);
            manager.merge(man);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public boolean activeManager(long manID){
        try{
            Manager man=manager.find(Manager.class, manID);
            man.setStatus(1);
            manager.merge(man);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    @Transactional
    public Manager getManager(long manID){
        try{
            return manager.find(Manager.class, manID);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public List<Manager> getListManager(){
        try{
            return manager.createQuery("select m from Manager m", Manager.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @Transactional
    public Page<Manager> getAll(int page, int size){
        try{
            List<Manager> managers=manager.createQuery("select m from Manager m", Manager.class)
                    .setFirstResult(page * size)
                    .setMaxResults(size)
                    .getResultList();
            long totalManager= (long) manager.createQuery("select count(m) from Manager m").getSingleResult();
            return new PageImpl<>(managers, PageRequest.of(page, size), totalManager);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean loginManager(long manID, String pass){
        try{
            Manager man=manager.find(Manager.class, manID);
            if(man==null){
                return false;
            }
            if(man.getMan_id()==manID && man.getPhone().equalsIgnoreCase(pass)){
                return true;
            }else return false;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
