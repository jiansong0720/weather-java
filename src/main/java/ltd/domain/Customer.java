package ltd.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

/*
 * 用户实体
 *
 * songshu 2017/11/23 15:19
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue
    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("用户姓名")
    private String name;

    @ApiModelProperty("用户电话")
    private String phone;

    @ApiModelProperty("查询地点")
    private String location;

    /**
     * 主控方：Message
     * 被控方：Customer
     * Customer相对于Message是被控方，只需在被控方写mappedBy,其值为主控方中引用的外键对象的名称。
     */
    @ApiModelProperty("短信集合")
    @OneToMany(mappedBy = "customer")
    private List<Message> list;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Message> getList() {
        return list;
    }

    public void setList(List<Message> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
