package edu.estu.webserver.business.concretes;

import edu.estu.webserver.business.abstracts.SubjectService;
import edu.estu.webserver.core.utilities.results.*;
import edu.estu.webserver.dataaccess.SubjectDao;
import edu.estu.webserver.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectManager implements SubjectService {
    private final SubjectDao subjectDao;

    @Autowired
    public SubjectManager(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    public Result add(Subject entity) {
        this.subjectDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        Subject subject = this.subjectDao.findById(id).orElse(null);
        if (subject == null)
            return new ErrorResult("Subject is not exist");

        this.subjectDao.delete(subject);
        return new SuccessResult("Subject is successfully deleted");
    }

    @Override
    public Result update(Subject entity) {
        if (this.subjectDao.findById(entity.getSubjectId()).orElse(null) == null)
            return new ErrorResult("Subject is not exist");

        this.subjectDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.subjectDao.findAll());
    }

    @Override
    public DataResult getById(int id) {
        return new SuccessDataResult(this.subjectDao.findById(id));
    }
}
