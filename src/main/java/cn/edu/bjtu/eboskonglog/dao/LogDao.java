package cn.edu.bjtu.eboskonglog.dao;

import cn.edu.bjtu.eboskonglog.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author chancey
 * @create 2020-06-17 21:58
 */
@Repository
public interface LogDao extends JpaRepository<Log, Integer> {
    List<Log> findByCategoryEn(String category);

    /**
     * 用于查询给定日期范围的日志查询
     * @param start
     * @param end
     * @return
     */
    List<Log> findByCreatedAtBetween(Date start, Date end);

    /**
     * 用于查询给定日期范围、给定请求方法的日志查询
     * @param start
     * @param end
     * @param method
     * @return
     */
    List<Log> findByCreatedAtBetweenAndMethod(Date start, Date end, String method);

    /**
     * 用于查询给定日期范围、给定查询类别的日志查询
     * @param start
     * @param end
     * @param category
     * @return
     */
    List<Log> findByCreatedAtBetweenAndCategoryEn(Date start, Date end, String category);

    /**
     * 用于查询给定日期范围、给定查询类别、给定请求方法的日志查询
     * @param start
     * @param end
     * @param category
     * @param method
     * @return
     */
    List<Log> findByCreatedAtBetweenAndCategoryEnAndMethod(Date start, Date end, String category, String method);

    /**
     * 查询给定请求方法的日志查询
     * @param method
     * @return
     */
    List<Log> findByMethod(String method);

    /**
     * 查询给定请求方法、给定查询类别的日志查询
     * @param category
     * @param method
     * @return
     */
    List<Log> findByCategoryEnAndMethod(String category, String method);
}
