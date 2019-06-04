package com.example.postgresdemo.bean.PO;

import lombok.Data;

/**
 * @Auther: liweizhi
 * @Date: 2018/10/22 09:56
 * @Description:
 */
@Data
public class PetPO {

    private String name;
    private int age;
    private String color;

    public PetPO() {
        super();
    }

    public PetPO(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public PetPO(String name, int age, String color) {
        super();
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
