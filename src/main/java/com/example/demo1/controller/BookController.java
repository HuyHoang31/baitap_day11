package com.example.demo1.controller;

import com.example.demo1.entity.BookEntity;
import com.example.demo1.reponsitory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value ="/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @RequestMapping (method = RequestMethod.GET)
    public Object getAllBook(){
        List<BookEntity>liss=bookRepository.findAll();
        return liss;
    }
    @RequestMapping(method = RequestMethod.POST)
    public Object addNewBook(@RequestBody BookEntity newBookEntity){
        BookEntity result=bookRepository.save(newBookEntity);
        return result;
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Object updateBook(@RequestBody BookEntity updataBookEntity){
        BookEntity result=bookRepository.update(updataBookEntity);
        if(result == null){
            Map<String,String >error= new HashMap<String,String >(){{
                put("error",updataBookEntity.getId()+"does not exist");
            }

            };
            return error;
        }
        return result;
    }
    @RequestMapping(value = "/{bookID}", method = RequestMethod.DELETE)
    public  Object deleteBook(@PathVariable(value = "bookID") String bookID){
        Boolean result = bookRepository.delete(Integer.valueOf(bookID));
        if (!result){
            Map<String, String> error = new HashMap<String,String>(){{
                put("error","A book which book ID =" + bookID+"does not exit");

            }};
            return error;
        } else {
            Map<String,String> success = new HashMap<String,String>(){{
                put("success","A book which book ID =" + "has been deleted successfully");
            }};
            return  success;
        }
    }
}
