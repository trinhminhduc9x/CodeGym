package vn.codegym.service;

import org.springframework.stereotype.Service;


@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public double convert(double rate, double usd) {
        return rate * usd;
    }


}
