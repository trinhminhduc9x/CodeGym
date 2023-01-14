package Ss12_Java_collection_Framework.exercise.service;

import Ss12_Java_collection_Framework.exercise.model.Product;

public interface IService {
    void dispaly();
    void add();
    void edit();
    void delete();
    void searchByName(String name);
    void sort();

}
