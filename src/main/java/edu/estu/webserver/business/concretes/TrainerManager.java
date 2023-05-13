package edu.estu.webserver.business.concretes;

import edu.estu.webserver.business.abstracts.TrainerService;
import edu.estu.webserver.core.utilities.results.*;
import edu.estu.webserver.dataaccess.TrainerDao;
import edu.estu.webserver.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerManager implements TrainerService {
    private final TrainerDao trainerDao;

    @Autowired
    public TrainerManager(TrainerDao trainerDao) {
        this.trainerDao = trainerDao;
    }

    @Override
    public Result add(Trainer entity) {
        if (this.trainerDao.findByUserName(entity.getUserName()).orElse(null) != null)
            return new ErrorResult("Trainer is already exist");

        this.trainerDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        Trainer trainer = this.trainerDao.findById(id).orElse(null);
        if (trainer == null)
            return new ErrorResult("Trainer is not exist");

        this.trainerDao.delete(trainer);
        return new SuccessResult("Trainer is successfully deleted");
    }

    @Override
    public Result update(Trainer entity) {
        if (this.trainerDao.findById(entity.getId()).orElse(null) == null)
            return new ErrorResult("Trainer is not exist");

        this.trainerDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.trainerDao.findAll());
    }

    @Override
    public DataResult getById(int id) {
        return new SuccessDataResult(this.trainerDao.findById(id));
    }
}
