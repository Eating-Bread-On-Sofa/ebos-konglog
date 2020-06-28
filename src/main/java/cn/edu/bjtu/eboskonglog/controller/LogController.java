package cn.edu.bjtu.eboskonglog.controller;

import cn.edu.bjtu.eboskonglog.entity.CommonResult;
import cn.edu.bjtu.eboskonglog.entity.Log;
import cn.edu.bjtu.eboskonglog.service.LogService;
import cn.edu.bjtu.eboskonglog.utils.CommonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chancey
 * @create 2020-06-18 12:24
 */
@RestController
@RequestMapping("/api/konglog")
public class LogController {

    @Autowired
    private LogService logService;

    @PostMapping("/device")
    @CrossOrigin
    public void insertDeviceLog(@RequestBody String deviceLog){
        JSONObject jsonObject = CommonUtils.JSONparse(deviceLog);
        Log d_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        d_log.setCategory("设备管理");
        d_log.setCategoryEn("device");
        logService.save(d_log);
//        System.out.println(d_log);
    }

    @PostMapping("/profile")
    @CrossOrigin
    public void insertProfileLog(@RequestBody String profileLog){
        JSONObject jsonObject = CommonUtils.JSONparse(profileLog);
        Log p_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        p_log.setCategory("模板管理");
        p_log.setCategoryEn("profile");
        logService.save(p_log);
//        System.out.println(p_log);
    }

    @PostMapping("/command")
    @CrossOrigin
    public void insertCommandLog(@RequestBody String commandLog){
        JSONObject jsonObject = CommonUtils.JSONparse(commandLog);
        Log c_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        c_log.setCategory("设备指令");
        c_log.setCategoryEn("command");
        logService.save(c_log);
//        System.out.println(c_log);
    }

    @PostMapping("/scenario")
    @CrossOrigin
    public void insertScenarioLog(@RequestBody String scenarioLog){
        JSONObject jsonObject = CommonUtils.JSONparse(scenarioLog);
        Log s_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        s_log.setCategory("场景管理");
        s_log.setCategoryEn("scenario");
        logService.save(s_log);
//        System.out.println(s_log);
    }

    @PostMapping("/notice")
    @CrossOrigin
    public void insertNoticeLog(@RequestBody String noticeLog){
        JSONObject jsonObject = CommonUtils.JSONparse(noticeLog);
        Log n_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        n_log.setCategory("通知管理");
        n_log.setCategoryEn("notice");
        logService.save(n_log);
//        System.out.println(n_log);
    }

    @PostMapping("/rule")
    @CrossOrigin
    public void insertRuleLog(@RequestBody String ruleLog){
        JSONObject jsonObject = CommonUtils.JSONparse(ruleLog);
        Log r_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        r_log.setCategory("规则引擎");
        r_log.setCategoryEn("rule");
        logService.save(r_log);
//        System.out.println(r_log);
    }

    @PostMapping("/gatewayconfig")
    @CrossOrigin
    public void insertGCLog(@RequestBody String gcLog){
        JSONObject jsonObject = CommonUtils.JSONparse(gcLog);
        Log gc_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        gc_log.setCategory("网关管理");
        gc_log.setCategoryEn("gatewayconfig");
        logService.save(gc_log);
//        System.out.println(gc_log);
    }

    @PostMapping("/gwinst")
    @CrossOrigin
    public void insertGILog(@RequestBody String giLog){
//        System.out.println(giLog);
        JSONObject jsonObject = CommonUtils.JSONparse(giLog);
//        System.out.println(jsonObject);
        Log gi_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        gi_log.setCategory("网关实例");
        gi_log.setCategoryEn("gwinst");
        logService.save(gi_log);
//        System.out.println(gi_log);
    }

    @PostMapping("/mqrouter")
    @CrossOrigin
    public void insertMqrLog(@RequestBody String mqrLog){
        JSONObject jsonObject = CommonUtils.JSONparse(mqrLog);
        Log mqr_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        mqr_log.setCategory("消息路由");
        mqr_log.setCategoryEn("mqrouter");
        logService.save(mqr_log);
//        System.out.println(mqr_log);
    }

    @PostMapping("/servmgmt")
    @CrossOrigin
    public void insertSevLog(@RequestBody String sevLog){
        JSONObject jsonObject = CommonUtils.JSONparse(sevLog);
        Log sev_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        sev_log.setCategory("服务管理");
        sev_log.setCategoryEn("servmgmt");
        logService.save(sev_log);
//        System.out.println(sev_log);
    }

    @PostMapping("/oam")
    @CrossOrigin
    public void insertOamLog(@RequestBody String oamLog){
        JSONObject jsonObject = CommonUtils.JSONparse(oamLog);
        Log o_log = JSON.parseObject(jsonObject.toJSONString(), Log.class);
        o_log.setCategory("运维监控");
        o_log.setCategoryEn("oam");
        logService.save(o_log);
//        System.out.println(o_log);
    }

    @GetMapping("/category/{category}")
    @CrossOrigin
    public CommonResult<Log> getLogByCategory(@PathVariable String category){
        List<Log> categoryLog = logService.findByCategoryEn(category);
        if (categoryLog != null) {
            return new CommonResult(200, "日志查询成功", categoryLog);
        } else {
            return new CommonResult(404,"无法找到类别为" + category + "的日志记录",null);
        }
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public CommonResult<Log> getLogById(@PathVariable Integer id){
        Log log = logService.selectById(id);
        if (log != null) {
            return new CommonResult(200, "日志查询成功", log);
        } else {
            return new CommonResult(404,"无法找到id为" + id + "的日志记录",null);
        }
    }

    @GetMapping()
    @CrossOrigin
    public CommonResult getAllLog(){
        List<Log> logs = logService.selectAll();
        if (logs != null) {
            return new CommonResult(200, "日志查询成功", logs);
        } else {
            return new CommonResult(404,"无法找到日志记录",null);
        }
    }

    @GetMapping("/log")
    @CrossOrigin
    public CommonResult getLog(Date startDate, Date endDate, String method, String category) throws ParseException {
        List<Log> log = null;
        if (startDate == null && endDate == null) {
            log = logService.findLogWithoutDate(method, category);
        } else if ((startDate != null && endDate == null) || (startDate == null && endDate != null)) {
            throw new RuntimeException("开始日期和结束日期必须同时存在或同时为空");
        } else {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date sDate = dateFormat1.parse(dateFormat.format(startDate) + "00:00:00");
            Date eDate = dateFormat1.parse(dateFormat.format(endDate) + "23:59:59");
            log = logService.findLog(sDate, eDate, method, category);
        }
        if (log != null) {
            return new CommonResult(200, "日志查询成功", log);
        } else {
            return new CommonResult(404,"无法找到日志记录",null);
        }
    }


    @GetMapping("/ping")
    @CrossOrigin
    public String ping(){
        return "pong";
    }
}
