package ltd.service;

import ltd.domain.Customer;
import ltd.domain.Message;
import ltd.repository.CustomerRepository;
import ltd.repository.MessageRepository;
import ltd.service.webservice.MessageWebService;
import ltd.service.webservice.WeatherWebService;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/*
 * 短信服务
 *
 * songshu 2017/11/23 15:09
 */
@Service
public class MessageService {

    Logger logger = Logger.getLogger(MessageService.class);

    @Resource
    private MessageRepository messageRepository;
    @Resource
    private WeatherWebService weatherWebService;
    @Resource
    private CustomerRepository customerRepository;
@Resource
    private MessageWebService messageWebService;

    @Scheduled(cron = "0 56 17 * * ?")
    public void sendMessage() {
        try {
            List<Customer> customerList = customerRepository.findAll();
            for (Customer customer : customerList) {
                String resoult = weatherWebService.getByLocation(customer.getLocation());

                System.out.println(resoult);
                Message message = new Message();
                message.setCustomer(customer);
                message.setSendDate(new Date());
                message.setContent(resoult);
                messageRepository.save(message);
            }

//            messageWebService.sendMessage();
            List<Message> all = messageRepository.findAll();
            for (Message message : all) {
                System.out.println(1);
            }

        } catch (IOException e) {
            logger.error(e);
        }
    }

}
