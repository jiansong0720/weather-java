package ltd.service.webservice;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 阿里云短信发送服务
 *
 * songshu 2017/11/22 17:25
 */
@Service
public class MessageWebService {

    @Resource
    private IAcsClient iAcsClient;

    public SendSmsResponse sendMessage(String phone, String signName, String templateCode) throws ClientException {
        //组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        //必填:待发送手机号
        request.setPhoneNumbers(phone);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        if ("SMS_84290015".equals(templateCode)) {
            request.setTemplateCode(templateCode);
            //Message message = WeatherWebService.getTodayTemperatureByCity("成都");
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            //request.setTemplateParam("{\"num\":\"" + "，不对是明天" + message.getTemperature() + "\", \"weather\":\"" + message.getWeather() + "\", \"dressing\":\"" + getDress() + "\"}");
        } else if ("SMS_85575004".equals(templateCode)) {
            request.setTemplateCode(templateCode);
            //Message message = WeatherWebService.getTodayTemperatureByCity("成都");
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            // request.setTemplateParam("{\"num\":\"" + message.getTemperature() + "，" + message.getWeather() + "\"}");
        }
        return iAcsClient.getAcsResponse(request);
    }

    public QuerySendDetailsResponse querySendDetails(String phone, Date date) throws ClientException {
        //组装请求对象
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        //必填-号码
        request.setPhoneNumber(phone);
        //必填-发送日期 支持30天内记录查询，格式yyyyMMdd
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(date));
        //必填-页大小
        request.setPageSize(10L);
        //必填-当前页码从1开始计数
        request.setCurrentPage(1L);
        return iAcsClient.getAcsResponse(request);
    }

}
