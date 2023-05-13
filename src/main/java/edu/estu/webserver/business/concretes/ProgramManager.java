package edu.estu.webserver.business.concretes;

import edu.estu.webserver.business.abstracts.ProgramService;
import edu.estu.webserver.core.utilities.results.*;
import edu.estu.webserver.dataaccess.ProgramDao;
import edu.estu.webserver.entities.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramManager implements ProgramService {
    private final ProgramDao programDao;

    @Autowired
    public ProgramManager(ProgramDao programDao) {
        this.programDao = programDao;
    }

    @Override
    public Result add(Program entity) {
        this.programDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        Program program = this.programDao.findById(id).orElse(null);
        if (program == null)
            return new ErrorResult("Program is not exist");

        this.programDao.delete(program);
        return new SuccessResult("Program is successfully deleted");
    }

    @Override
    public Result update(Program entity) {
        if (this.programDao.findById(entity.getId()).orElse(null) == null)
            return new ErrorResult("Program is not exist");

        this.programDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.programDao.findAll());
    }

    @Override
    public DataResult getById(int id) {
        return new SuccessDataResult(this.programDao.findById(id));
    }
}
