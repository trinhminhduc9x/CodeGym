package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.repository.TranslateRepository;

@Service
public class TranslateServiceImpl implements TranslateService {
    @Autowired
    private TranslateRepository translateRepository;

    @Override
    public String translate(String eng) {
        return this.translateRepository.translate(eng);
    }
}


