package com.lpu.SpringSecurityBasic.service;

import com.lpu.SpringSecurityBasic.entity.Cricketer;

import java.util.List;

public interface CricketerService {
    Cricketer saveCricketer(Cricketer cricketer);

    Cricketer getCricketerById(int id);

    List<Cricketer> getAllCricketers();
}
