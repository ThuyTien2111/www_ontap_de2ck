package vn.edu.iuh.fit.controller;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.convert.ManagerForm;
import vn.edu.iuh.fit.dao.ManagerDao;
import vn.edu.iuh.fit.entity.Manager;

@Controller
public class ManagerControll {
    private ManagerDao managerDao;
    @Autowired
    public ManagerControll(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }
    @GetMapping("/manager-login")
    public String showManagerLoginForm(){
        return "manager-login";
    }
    @PostMapping("/manager-login")
    public String managerLogin(@RequestParam String username,
                               @RequestParam String password, Model model){
        if(managerDao.loginManager(Long.parseLong(username), password)){
            return "redirect:/managers/"+username;
        }else {
            model.addAttribute("error", "Sai thông tin đăng nhập");
            return "manager-login";
        }
    }
    @GetMapping("/managers/{manID}")
    public String getManagerList(@PathVariable long manID,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "5") int size,
                                 Model model){
        Page<Manager> managers=managerDao.getAll(page, size);
        model.addAttribute("managers", managers.getContent());
        model.addAttribute("totalManager", managers.getTotalPages());
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("manID", manID);
        return "managers";
    }
    @GetMapping("/delete-manager/{manID}/{delManID}")
    public String delManager(@PathVariable long manID, @PathVariable long delManID){
        managerDao.deleteManager(delManID);
        return "redirect:/managers/"+manID;
    }
    @GetMapping("/active-manager/{manID}/{actManID}")
    public String activeManager(@PathVariable long manID, @PathVariable long actManID){
        managerDao.activeManager(actManID);
        return "redirect:/managers/"+manID;
    }
    @GetMapping("/update-manager/{manID}/{uptManID}")
    public String updateManagerForm(@PathVariable long manID, @PathVariable long uptManID,
                                Model model){
        Manager manager=managerDao.getManager(uptManID);
        model.addAttribute("manID",manID);
        model.addAttribute("manager",manager);
        return "update-manager";
    }
    @PostMapping ("/update-manager/{manID}")
    public String updateManager(@PathVariable long manID, @ModelAttribute ManagerForm managerForm){
        long updManID=Long.parseLong(managerForm.getManID());
        int status=Integer.parseInt(managerForm.getStatus());
        managerDao.updateManager(new Manager(updManID, managerForm.getName(), managerForm.getPhone(), status));
        return "redirect:/managers/"+manID;
    }
    @GetMapping("/add-manager/{manID}")
    public String addManagerForm(@PathVariable long manID,
                                Model model){
        model.addAttribute("manID",manID);
        return "add-manager";
    }
    @PostMapping ("/add-manager/{manID}")
    public String addManager(@PathVariable long manID, @ModelAttribute ManagerForm managerForm){
        managerDao.addManager(new Manager(managerForm.getName(), managerForm.getPhone()));
        return "redirect:/managers/"+manID;
    }
}
