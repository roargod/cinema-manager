package com.rabbiter.cm.service.impl;

import com.rabbiter.cm.domain.SysBill;
import com.rabbiter.cm.mapper.SysBillMapper;
import com.rabbiter.cm.service.SysBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysBillServiceImpl implements SysBillService {

    @Autowired
    private SysBillMapper sysBillMapper;

    @Override
    public List<SysBill> findAllBills(SysBill sysBill) {
        return sysBillMapper.findAllBills(sysBill);
    }

    @Override
    public SysBill findBillById(Long id) {
        return sysBillMapper.findBillById(id);
    }

    @Override
    public Object addBill(SysBill sysBill) {
        int rows = sysBillMapper.addBill(sysBill);
        return rows > 0 ? sysBill : rows;
    }

    @Override
    public int updateBill(SysBill sysBill) {
        return sysBillMapper.updateBill(sysBill);
    }

    @Override
    public int deleteBill(Long[] ids) {
        int rows = 0;
        for (Long id : ids) {
            rows += sysBillMapper.deleteBill(id);
        }
        return rows;
    }

    @Override
    public List<SysBill> findTimeoutBill() {
        return sysBillMapper.findTimeoutBill();
    }

}
