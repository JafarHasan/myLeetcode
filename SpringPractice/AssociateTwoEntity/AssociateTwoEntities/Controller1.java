package com.Acciojob_Practice_Project.July2024.AssociateTwoEntities;

import com.Acciojob_Practice_Project.July2024.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/add")
public class Controller1 {
    @Autowired Service1 service1;

    @PostMapping("/book")
    public ResponseEntity<String> addBook(@RequestBody Book1 book1){
        try{
            String response=service1.addBook(book1);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/author")
    public ResponseEntity<String> addAuthor(@RequestBody Author1 author1){
        try{
            String response=service1.addAuthor(author1);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("associate-author-book")
    public ResponseEntity<String> associateAuthorAndBook(@RequestParam Integer bookId,@RequestParam Integer authorId){
        try{
            String response=service1.associateAuthorAndBook(bookId,authorId);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
