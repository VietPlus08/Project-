package services.impl;

import models.Book;
import repositories.IBaseRepositories;
import repositories.impl.BookRepositories;
import services.IBaseServices;
import utils.Valid;

import java.util.List;
import java.util.Map;

public class BookServices implements IBaseServices<Book> {
    IBaseRepositories<Book> repositories = new BookRepositories();
    @Override
    public List<Book> findByCondition(String id) {
        return repositories.findByCondition(id);
    }

    @Override
    public List<Book> findAll() {
        return repositories.findAll();
    }

    @Override
    public Book findById(String id) {
        return repositories.findByCondition(id).get(0);
    }

    @Override
    public Map<String, String> create(Book book) {
        Map<String,String> error = Valid.getValidation(book);
        List<Book> list = repositories.findByCondition(book.getId());
        if (list.isEmpty()){
            if (error.isEmpty()){
                repositories.create(book);
            }
        } else {
            error.put("id","Id had been existed");
        }
        return error;
    }

    @Override
    public Map<String, String> update(Book book) {
        Map<String,String> error = Valid.getValidation(book);
        if (error.isEmpty()){
            repositories.update(book);
        }
        return error;
    }

    @Override
    public void delete(String id) {
        repositories.delete(id);
    }
}
