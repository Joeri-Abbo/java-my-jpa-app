package com.skillsoft.jpa;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "ContractEmployees")
@DiscriminatorValue("contract")
public class ContractEmployee extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer hourlyPay;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public ContractEmployee(){

    }


    public ContractEmployee(String name, Integer hourlyPay){
        super(name);
        this.hourlyPay = hourlyPay;
    }


    public Integer getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(Integer hourlyPay) {
        this.hourlyPay = hourlyPay;
    }
}
