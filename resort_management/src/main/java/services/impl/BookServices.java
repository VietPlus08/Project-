package services.impl;

import models.Book;
import repositories.IBaseRepositories;
import repositories.impl.BookRepositories;
import services.IBaseServices;

import java.util.List;
import java.util.Map;

public class BookServices implements IBaseServices<Book> {
    IBaseRepositories<Book> repositories = new BookRepositories();
    @Override
    public List<Book> findByCondition(String id) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return repositories.findAll();
    }

    @Override
    public Book findById(String id) {
        return null;
    }

    @Override
    public Map<String, String> create(Book book) {
        return null;
    }

    @Override
    public Map<String, String> update(Book book) {
        return null;
    }

    @Override
    public void delete(String id) {
        repositories.delete(id);
    }
}
