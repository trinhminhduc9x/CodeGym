package vn.codegym.service;

import vn.codegym.model.MailBox;

import java.util.List;

public interface MailBoxService {
    List<MailBox> findAll();

    void save(MailBox mailBox);

    public List<MailBox> findByName(String keyword);
}
