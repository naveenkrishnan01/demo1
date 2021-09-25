package com.app.demo1.Services;

import com.app.demo1.data.BooksEntity;
import com.app.demo1.jpa.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    BooksRepository booksRepository;


    public BooksEntity createBook(BooksEntity booksEntity, String genreType) {
        Map<String, List<String>> addBooks = addBookType(genreType);
        if(genreType != null) {
            booksEntity.setBookDetails(addBooks);
        }
        booksRepository.save(booksEntity);
        return booksEntity;
    }

    private Map<String, List<String>> addBookType(String genreType){
        Map<String, List<String>> addItems = new HashMap<>();
        if(genreType != null ){
            if (genreType.equalsIgnoreCase("SCIENCE")){
                addItems.put("Space", Arrays.asList("star wars", "time machine"));
                addItems.put("Astronomer", Arrays.asList("galaxy", "UFO"));
            }
            if (genreType.equalsIgnoreCase("MOVIES")) {
                addItems.put("Roger More", Arrays.asList("gold finger"));
                addItems.put("Tom Cruise", Arrays.asList("Born on July 4", "Games"));
            }
        }  else {
            System.out.println("Please pass gentretype as science or movies");
        }
        return addItems;
    }
}
