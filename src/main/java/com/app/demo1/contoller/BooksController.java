package com.app.demo1.contoller;


import com.app.demo1.Services.BookService;
import com.app.demo1.data.BooksEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class BooksController {

    @Autowired
    BookService bookService;

    @PostMapping("/books")
    public BooksEntity createBooks(@Valid @RequestBody BooksEntity booksEntity,
                                   @RequestParam (required = false) String requestType)
                                    {
        return  bookService.createBook(booksEntity, requestType);
    }
}
