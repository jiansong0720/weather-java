package top.xuansong0720.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.xuansong0720.domain.Sms;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * 根据城市名/id查询天气
 *
 * @author silk
 */
public class WeatherReportByCity {
    /**
     * 根据城市名获取
     *
     * @param cityName
     * @return
     */
    public static String excute(String cityName) {
        String url = "http://v.juhe.cn/weather/index?cityname=" + cityName + "&key=944e34fd992da62f5bec5287549bd695";
        return PureNetUtil.get(url);
    }

    /**
     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
     * "temperature": "8℃~20℃"     今日温度
     *
     * @return
     */
    public static Sms getTodayTemperatureByCity(String city) {
        String result = excute(city);
        if (result != null) {
            JSONObject obj = JSON.parseObject(result);
            /*获取返回状态码*/
            result = obj.getString("resultcode");
            /*如果状态码是200说明返回数据成功*/
            if (result != null && result.equals("200")) {
                result = obj.getString("result");
                //此时result中数据有多个key,可以对其key进行遍历,得到对个属性
                obj = JSON.parseObject(result);
                //今日温度对应的key是today
                result = obj.getString("future");
                obj = JSON.parseObject(result);

                //今日温度对应当key是temperature
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
                Calendar cal = new GregorianCalendar();
                cal.setTime(new Date());
                cal.add(Calendar.DAY_OF_MONTH, 1);

                result = obj.getString("day_" + formatter.format(cal.getTime()));
                obj = JSON.parseObject(result);

                String temperature = obj.getString("temperature");
                String[] split = temperature.split("℃");

                StringBuffer sb = new StringBuffer();
                for (String s : split) {
                    sb.append(s);
                }
                String week = obj.getString("week");
                String weather = obj.getString("weather");
                Sms sms = new Sms();
                sms.setTemperature(sb.toString());
                sms.setWeek(week);
                sms.setWeather(weather);
                return sms;
            }
        }
        return null;
    }

}