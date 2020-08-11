package com.hf.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 将配置文件中的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties: 告诉springboot将本类中所有的属性和配置文件中相关的配置进行绑定
 * prefix = "person" 配置文件中哪个下面的所有属性进行一一映射
 *
 * @Component 将person加到spring容器中
 * 只有这个组件是容器中组件，才能使用容器提供的@ConfigurationProperties功能
 *
 *
 * @Value无法注入复杂类型   只能取出基本类型数据
 */
@Component
@ConfigurationProperties(prefix = "person")
public class Person {
    //@Value("${person.lastName}")
    private String lastName;
    //@Value("${person.age}")
    private int age;
    private boolean isBoss;
    private Date birth;

    private Map<String,Object> map;
    private List<Object> list;
    private Dog dog;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBoss() {
        return isBoss;
    }

    public void setBoss(boolean boss) {
        isBoss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isBoss=" + isBoss +
                ", birth=" + birth +
                ", map=" + map +
                ", list=" + list +
                ", dog=" + dog +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                isBoss == person.isBoss &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(birth, person.birth) &&
                Objects.equals(map, person.map) &&
                Objects.equals(list, person.list) &&
                Objects.equals(dog, person.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, age, isBoss, birth, map, list, dog);
    }
}
