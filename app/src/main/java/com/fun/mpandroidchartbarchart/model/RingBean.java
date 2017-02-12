package com.fun.mpandroidchartbarchart.model;

import java.io.Serializable;

/**
 * Created by HZF on 2017/2/12.
 */

public class RingBean implements Serializable {

    private double amount;
    private String axis;

    public RingBean(double amount, String axis) {
        this.amount = amount;
        this.axis = axis;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

}
