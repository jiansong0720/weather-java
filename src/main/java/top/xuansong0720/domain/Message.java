package top.xuansong0720.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by song1993 on 2017/8/9.
 */
@ApiModel("天气实体")
public class Message {

    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty("温度")
    private String temperature;

    @ApiModelProperty("天气")
    private String weather;

    @ApiModelProperty("星期")
    private String week;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
