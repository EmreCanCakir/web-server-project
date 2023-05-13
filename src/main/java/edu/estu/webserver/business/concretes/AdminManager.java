package edu.estu.webserver.business.concretes;

import edu.estu.webserver.business.abstracts.AdminService;
import edu.estu.webserver.core.utilities.results.*;
import edu.estu.webserver.dataaccess.AdminDao;
import edu.estu.webserver.entities.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminManager implements AdminService {
    private final AdminDao adminDao;

    @Autowired
    public AdminManager(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Result add(Admin entity) {
        if (this.adminDao.findByUserName(entity.getUserName()).orElse(null) != null)
            return new ErrorResult("Admin is already exist");

        this.adminDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        Admin admin = this.adminDao.findById(id).orElse(null);
        if (admin == null)
            return new ErrorResult("Admin is not exist");

        this.adminDao.delete(admin);
        return new SuccessResult("Admin is successfully deleted");
    }

    @Override
    public Result update(Admin entity) {
        if (this.adminDao.findById(entity.getId()).orElse(null) == null)
            return new ErrorResult("Admin is not exist");

        this.adminDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.adminDao.findAll());
    }

    @Override
    public DataResult getById(int id) {
        return new SuccessDataResult(this.adminDao.findById(id));
    }
}
