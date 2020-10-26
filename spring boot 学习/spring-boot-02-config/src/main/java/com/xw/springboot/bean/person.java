package com.xw.springboot.bean;

import org.hibernate.validator.constraints.Email;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置文件中每一个属性的值映射到这个组件中
 * @ConfigurationProperties:告诉SpringBoot将类中的所有属性和配置文件中的相关配置进行绑定；
 *      prefix=“person” ： 配置文件下那个下面的属性进行一一映射
 *
 *  只有这个组件是容器里面的组件，才能使用容器提供的@ConfigurationProperties功能
 *  @ConfigurationProperties(prefix = "person")默认从全局配置中获取值
 */
//@PropertySource(value = {"classpath:Person.properties"})
@Component
@ConfigurationProperties(prefix = "person")
//@Validated
public class person {
    /**
     * <bean class="Person">
     *     <property name="lastName="字面量/${key}从环境变量、配置文件中获取值/#{SpEL}"></property/>
     *  <bean/>
     */
    //@Value("${person.last-name}")
    //@Email
    private String lastName;
    //@Value("#{11*2}")
    private Integer age;
    //@Value("true")
    private Boolean boss;
    private Date birth;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    @Override
    public String toString() {
        return "person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
