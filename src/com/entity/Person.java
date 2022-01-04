package com.entity;

import java.io.Serializable;

public final class Person extends BaseClass implements Serializable {
    //成员属性
    private String name;
    static final int age=30;
    protected String address;
    public String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Person(){}

    private Person(String name){
        this.name=name;
    }

    protected  Person(String name,String address,String message){
        this.name=name;
        this.address=address;
        this.message=message;
    }

    @Override
    public String toString() {
        return "{name:"+name+",age:"+age+",address:"+address+",message:"+message+"}";
    }
}
