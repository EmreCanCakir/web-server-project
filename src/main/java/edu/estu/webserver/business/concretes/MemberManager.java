package edu.estu.webserver.business.concretes;

import edu.estu.webserver.business.abstracts.MemberService;
import edu.estu.webserver.core.utilities.results.*;
import edu.estu.webserver.dataaccess.MemberDao;
import edu.estu.webserver.entities.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberManager implements MemberService {
    private final MemberDao memberDao;

    @Autowired
    public MemberManager(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public Result add(Member entity) {
        if (this.memberDao.findByUserName(entity.getUserName()).orElse(null) != null)
            return new ErrorResult("Member is already exist");

        this.memberDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        Member member = this.memberDao.findById(id).orElse(null);
        if (member == null)
            return new ErrorResult("Member is not exist");

        this.memberDao.delete(member);
        return new SuccessResult("Member is successfully deleted");
    }

    @Override
    public Result update(Member entity) {
        if (this.memberDao.findById(entity.getId()).orElse(null) == null)
            return new ErrorResult("Member is not exist");

        this.memberDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public DataResult getAll() {
        return new SuccessDataResult(this.memberDao.findAll());
    }

    @Override
    public DataResult getById(int id) {
        return new SuccessDataResult(this.memberDao.findById(id));
    }
}
