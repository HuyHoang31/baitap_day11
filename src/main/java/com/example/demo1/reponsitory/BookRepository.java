package com.example.demo1.reponsitory;

import com.example.demo1.entity.BookEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<BookEntity> booklist= new ArrayList<>();
    @PostConstruct
    public void  innit(){
        booklist.add(new BookEntity(1,"java",17.6,"so"));
        booklist.add(new BookEntity(1,"java",17.6,"so"));
    }
public List<BookEntity>findAll(){
        return  booklist;
}
public BookEntity save(BookEntity book){
        booklist.add(book);

        return book;
    }
    public BookEntity update(BookEntity books){
        boolean isFound=false;
        BookEntity bookEntity= null;
        for(BookEntity book: booklist){
            if(book.getId()==books.getId()){
                isFound=true;
                bookEntity= book;
                break;
            }
        }
        if (!isFound)
        {
            return null;

        }
        booklist.remove(bookEntity);
        books.setId(bookEntity.getId());
        booklist.add(books);
        return books;
    }
    public  boolean delete(int bookID){
        boolean isFound = false;
        BookEntity foundBook = null;
        for (BookEntity book:booklist){
            if (book.getId()==bookID){
                isFound=true;
                foundBook=book;
                break;
            }
        }
        if (!isFound){
            return  false;
        }
        booklist.remove(foundBook);
        return  true;
    }
}
