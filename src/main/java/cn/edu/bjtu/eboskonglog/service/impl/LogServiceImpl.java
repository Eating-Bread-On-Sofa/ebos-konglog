package cn.edu.bjtu.eboskonglog.service.impl;

import cn.edu.bjtu.eboskonglog.dao.LogDao;
import cn.edu.bjtu.eboskonglog.entity.Log;
import cn.edu.bjtu.eboskonglog.service.LogService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chancey
 * @create 2020-06-17 22:45
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public Log selectById(Integer id) {
        Log log = logDao.findById(id).get();
        return log;
    }

    @Override
    public Log save(Log log) {
        Log save = logDao.save(log);
        return save;
    }

    @Override
    public List<Log> selectAll() {
        List<Log> logs = logDao.findAll();
        return logs;
    }

    @Override
    public List<Log> findByCategoryEn(String category) {
        return logDao.findByCategoryEn(category);
    }

    @Override
    public List<Log> findByCreatedAtBetween(Date start, Date end) {
        return logDao.findByCreatedAtBetween(start, end);
    }

    @Override
    public List<Log> findByCreatedAtBetweenAndMethod(Date start, Date end, String method) {
        return logDao.findByCreatedAtBetweenAndMethod(start, end, method);
    }

    @Override
    public List<Log> findByCreatedAtBetweenAndCategoryEn(Date start, Date end, String category) {
        return logDao.findByCreatedAtBetweenAndCategoryEn(start, end, category);
    }

    @Override
    public List<Log> findByCreatedAtBetweenAndCategoryEnAndMethod(Date start, Date end, String category, String method) {
        return logDao.findByCreatedAtBetweenAndCategoryEnAndMethod(start, end, category, method);
    }

    @Override
    public List<Log> findByMethod(String method) {
        return logDao.findByMethod(method);
    }

    @Override
    public List<Log> findByCategoryEnAndMethod(String category, String method) {
        return logDao.findByCategoryEnAndMethod(category, method);
    }

    @Override
    public List<Log> findLog(Date startDate, Date endDate, String method, String category) {
        if (startDate.getTime() > endDate.getTime()){
            throw new RuntimeException("您的日期选择有误");
        }
        if (method == null && category == null) {
            return findByCreatedAtBetween(startDate, endDate);
        } else if (method != null && category == null) {
            return findByCreatedAtBetweenAndMethod(startDate, endDate, method);
        } else if (method == null && category != null) {
            return findByCreatedAtBetweenAndCategoryEn(startDate, endDate, category);
        } else {
            return findByCreatedAtBetweenAndCategoryEnAndMethod(startDate, endDate, category, method);
        }
    }

    public List<Log> findLogWithoutDate(String method, String category) {
        if (method == null && category == null) {
            // 返回所有日志
            return selectAll();
        } else if (method != null && category == null) {
            return findByMethod(method);
        } else if (method == null && category != null) {
            return findByCategoryEn(category);
        } else {
            return findByCategoryEnAndMethod(category, method);
        }
    }
}
