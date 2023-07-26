package cn.itcast.service;

import cn.itcast.properties.IpProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: springBoot
 * @BelongsPackage: cn.itcast.service
 * @Author: ASUS
 * @CreateTime: 2023-07-25  09:25
 * @Description: TODO
 * @Version: 1.0
 */
public class IpCountService {
    private Map<String,Integer> ipCountMap=new HashMap<>();

    @Autowired
    //当前request,对象的注入工作由使用当前starter的工程提供自动装鹿
    private HttpServletRequest httpServletRequest;

    public void count(){
        //每次调用当前操作，就记录当前访问的IP，然后累加访问次数
        //1.获取当前操作的IP地址
        String ip = httpServletRequest.getRemoteAddr();
        System.out.println("-----------------------------"+ip);
        //根据IP地址从Map取值，并递增
        Integer count = ipCountMap.get(ip);
        if(count==null){
            ipCountMap.put(ip,1);
        }else {
            ipCountMap.put(ip,count+1);
        }
    }

    @Autowired
    private IpProperties ipProperties;
    //第一种方法：
    //@Scheduled(cron = "0/${tools.ip.cycle} * * * * ?")
    //第二种方法：
    @Scheduled(cron = "0/#{ipProperties.cycle} * * * * ?")
    public void print(){
        //模式切换
        if(ipProperties.getModel().equals(IpProperties.LogModel.DETAIL.getValue())){
                //明细模式
            System.out.println("         IP访问监控");
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : ipCountMap.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%18s  |%5d  |",key,value));
            }
            System.out.println("+--------------------+-------+");
        }else if(ipProperties.getModel().equals(IpProperties.LogModel.SIMPLE.getValue())){
                //极简模式
            System.out.println("     IP访问监控");
            System.out.println("+-----ip-address-----+");
            for (String key: ipCountMap.keySet()) {
                System.out.println(String.format("|%18s  |",key));
            }
            System.out.println("+--------------------+");
        }
                //周期内重置数据
        if(ipProperties.getCycleReset()){
            ipCountMap.clear();
        }
    }
}
