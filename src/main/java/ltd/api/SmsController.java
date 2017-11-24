package ltd.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ltd.domain.Message;
import ltd.repository.MessageRepository;
import ltd.service.webservice.MailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by song1993 on 2017/9/27.
 */
@RestController
@RequestMapping("/sms")
@Api(value = "短信", produces = "application/json")
public class SmsController {

    @Resource
    private MailService mailService;
    @Resource
    private MessageRepository messageRepository;

    @ApiOperation("获取短信历史列表")
    @GetMapping(value = "/list")
    public List<Message> list() {
        return messageRepository.findAll();
    }

}
