package com.lpu.SpringSecurityBasic.service;

import com.lpu.SpringSecurityBasic.entity.Cricketer;
import com.lpu.SpringSecurityBasic.repository.CricketerRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CricketerServiceImpl implements CricketerService {

    private final CricketerRepository cricketerRepository;
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(10);

    @Override
    public Cricketer saveCricketer(Cricketer cricketer) {

        //to encode the plain password before saving it to the database
        cricketer.setPassword(encoder.encode(cricketer.getPassword()));
        return cricketerRepository.save(cricketer);
    }

    @Override
    public Cricketer getCricketerById(int id) {
        return cricketerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Cricketer> getAllCricketers() {
        return cricketerRepository.findAll();
    }
}
