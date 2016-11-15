package com.ryl.learn.guava.pojo;

import com.google.common.base.Objects;

import static com.google.common.base.Objects.equal;

/**
 * Created on 16/10/31 12:07.
 */
public class Customer {
    
    private Integer id;
    private String name;
    
    public Customer(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Customer)) {
            return false;
        }
        
        Customer that = (Customer) obj;
        return equal(id, that.getId())
                && equal(name, that.getName());
        
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }
    
    @Override
    public String toString() {
        return name + " (id " + id + ")";
    }
    
    public Integer getId() {
        return id;
    }
    
    public boolean isSick() {
        return false;
    }
    
    public String getAddress() {
        return null;
    }
    
    public String getName() {
        return name;
    }
}
