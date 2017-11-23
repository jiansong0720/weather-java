package ltd.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@ApiModel("短信")
public class Message {

    @Id
    @GeneratedValue
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("属于哪个用户")
    @ManyToOne(optional = false)
    private Customer customer;

    @ApiModelProperty("发送时间")
    private Date sendDate;

    @ApiModelProperty("内容")
    private String content;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
