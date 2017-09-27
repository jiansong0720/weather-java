package top.xuansong0720.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xuansong0720.domain.Message;
import top.xuansong0720.util.WeatherReportByCity;

/**
 * Created by song1993 on 2017/9/27.
 */
@RestController
@RequestMapping("/user")
@Api(value = "天气相关")
public class SmsController {

    @ApiOperation("获取天气信息")
    @GetMapping(value = "/getUser")
    public Message getUser() {
        return WeatherReportByCity.GetTodayTemperatureByCity("成都");
    }

}
