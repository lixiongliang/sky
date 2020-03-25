package com.hgshequ.springbootai.service;

import com.hgshequ.springbootai.annotation.factory.BusinessBeanFactory;
import com.hgshequ.springbootai.mapper.OrderTblMapper;
import com.hgshequ.springbootai.model.OrderTbl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderTblMapper orderTblMapper;

    @Autowired
    BusinessBeanFactory beanFactory;

    public List<OrderTbl> listOrder() {
        return orderTblMapper.selectAll();
    }

}
