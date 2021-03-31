package com.hf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

/**
 * @program: springboot-07-cache
 * @description:
 * @author: xiehongfei
 * @create: 2021-03-23 20:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department implements Serializable {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(getDepartmentId(), that.getDepartmentId()) && Objects.equals(getDepartmentName(), that.getDepartmentName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDepartmentId(), getDepartmentName());
    }

    private String departmentId;

    private String departmentName;
}
