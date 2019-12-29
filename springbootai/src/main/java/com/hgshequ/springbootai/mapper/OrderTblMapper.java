package com.hgshequ.springbootai.mapper;

import com.hgshequ.springbootai.model.OrderTbl;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface OrderTblMapper {
    int insert(OrderTbl record);

    List<OrderTbl> selectAll();
}