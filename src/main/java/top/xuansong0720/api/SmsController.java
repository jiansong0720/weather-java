package top.xuansong0720.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.xuansong0720.domain.Sms;
import top.xuansong0720.repository.SmsRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song1993 on 2017/9/27.
 */
@RestController
@RequestMapping("/sms")
@Api(value = "短信")
public class SmsController {

    @Resource
    private SmsRepository smsRepository;

    @ApiOperation("获取短信历史列表")
    @GetMapping(value = "/list")
    public List<Sms> list() {
        return smsRepository.findAll();
    }

}
