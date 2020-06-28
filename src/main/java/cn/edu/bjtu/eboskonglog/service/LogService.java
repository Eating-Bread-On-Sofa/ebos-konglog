package cn.edu.bjtu.eboskonglog.service;

import cn.edu.bjtu.eboskonglog.entity.Log;

import java.util.Date;
import java.util.List;

/**
 * @author chancey
 * @create 2020-06-17 22:20
 */
public interface LogService {
    Log selectById(Integer id);

    Log save(Log deviceLog);

    List<Log> selectAll();

    List<Log> findByCategoryEn(String category);

    List<Log> findByCreatedAtBetween(Date start, Date end);

    List<Log> findByCreatedAtBetweenAndMethod(Date start, Date end, String method);

    List<Log> findByCreatedAtBetweenAndCategoryEn(Date start, Date end, String category);

    List<Log> findByCreatedAtBetweenAndCategoryEnAndMethod(Date start, Date end, String category, String method);

    List<Log> findByMethod(String method);

    List<Log> findByCategoryEnAndMethod(String category, String method);

    List<Log> findLog(Date startDate, Date endDate, String method, String category);

    List<Log> findLogWithoutDate(String method, String category);
}
