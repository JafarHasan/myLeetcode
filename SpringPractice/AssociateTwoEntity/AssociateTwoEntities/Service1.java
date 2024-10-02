package com.Acciojob_Practice_Project.July2024.AssociateTwoEntities;

import com.Acciojob_Practice_Project.July2024.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Service1 {
    @Autowired
    private  Book1Repo book1Repo;

    @Autowired
    private Author1Repo author1Repo;

    public String addBook(Book1 book1) throws Exception{
        book1=book1Repo.save(book1);
        return "Book added successfully";

    }

    public String addAuthor(Author1 author1) throws Exception{
        author1=author1Repo.save(author1);
        return "Author added successfully";
    }

    public  String associateAuthorAndBook(Integer bookId,Integer authorId) throws Exception{
        //get book from bookId
        Optional<Book1> optionalBook1=book1Repo.findById(bookId);
        if(optionalBook1.isEmpty()){
            throw new Exception("Failed ...Book not found!");
        }

        //get Author from authorId
        Optional<Author1> optionalAuthor1=author1Repo.findById(authorId);
        if(optionalAuthor1.isEmpty()){
            throw new Exception("Failed ...Author not found!");
        }

        //if both found Successfully get Obj of both
        Book1 book1=optionalBook1.get();
        Author1 author1=optionalAuthor1.get();

        //set FK in book
        book1.setAuthor1(author1);
        //save into DB
        book1Repo.save(book1);
        return "Associated Successfully";
    }
}
