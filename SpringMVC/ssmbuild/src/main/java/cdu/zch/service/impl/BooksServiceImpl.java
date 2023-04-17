package cdu.zch.service.impl;

import cdu.zch.entity.Books;
import cdu.zch.mapper.BooksMapper;
import cdu.zch.service.BooksService;

import java.util.List;

/**
 * @author Zch
 **/
public class BooksServiceImpl implements BooksService {

    private BooksMapper booksMapper;
    public void setBooksMapper(BooksMapper booksMapper) {
        this.booksMapper = booksMapper;
    }

    @Override
    public int addBook(Books book) {
        return booksMapper.addBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return booksMapper.deleteBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return booksMapper.updateBook(books);
    }

    @Override
    public Books queryBookById(int id) {
        return booksMapper.queryBookById(id);
    }

    @Override
    public List<Books> queryAllBook() {
        return booksMapper.queryAllBook();
    }
}
