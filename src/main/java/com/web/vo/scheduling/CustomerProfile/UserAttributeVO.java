package com.web.vo.scheduling.CustomerProfile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangmq1 on 2017/5/24.
 */
public class UserAttributeVO {
    private List<BasicCustomerVO> basicCustomer=new ArrayList<BasicCustomerVO>() {
    };
    private List<CustomerTypeVO> customerType=new ArrayList<CustomerTypeVO>();

    public List<BasicCustomerVO> getBasicCustomer() {
        return basicCustomer;
    }

    public void setBasicCustomer(List<BasicCustomerVO> basicCustomer) {
        this.basicCustomer = basicCustomer;
    }

    public List<CustomerTypeVO> getCustomerType() {
        return customerType;
    }

    public void setCustomerType(List<CustomerTypeVO> customerType) {
        this.customerType = customerType;
    }
}
