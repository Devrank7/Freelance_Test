package com.example.client_2.controller;

import com.example.client_2.model.Book;
import com.example.client_2.model.Library;
import com.example.client_2.repo.Repo_Books;
import com.example.client_2.repo.Repo_Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/to")
public class ARestController1 {


    private Repo_Library repoLibrary;
    private Repo_Books repoBooks;

    @Autowired
    public ARestController1(Repo_Library repoLibrary,Repo_Books repoBooks) {
        this.repoLibrary = repoLibrary;
        this.repoBooks = repoBooks;
    }


    @GetMapping("/get")
    public ResponseEntity<List<Library>> listResponseEntity() {
        return new ResponseEntity<>(repoLibrary.findAll(), HttpStatus.OK);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<Library> libraryResponseEntity(@PathVariable("id")int id) {
        return new ResponseEntity<>(repoLibrary.findById(id).orElseThrow(),HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Library> createLib(@RequestBody Library library) {
        return new ResponseEntity<>(repoLibrary.save(library),HttpStatus.CREATED);
    }
    @PutMapping("/set/{id}")
    public ResponseEntity<Library> setLib(@PathVariable("id")int id,@RequestBody Library library) {
        library.setId(id);
        return new ResponseEntity<>(repoLibrary.save(library),HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public HttpStatus deleteLib(@PathVariable("id")int id) {
        if (repoLibrary.existsById(id)) {
            repoLibrary.deleteById(id);
            return HttpStatus.OK;
        }
            return HttpStatus.NOT_FOUND;
    }
    @GetMapping("/book/get")
    public ResponseEntity<List<Book>> listResponseEntityBook() {
        return new ResponseEntity<>(repoBooks.findAll(), HttpStatus.OK);
    }
    @GetMapping("/book/get/{id}")
    public ResponseEntity<Book> libraryResponseEntityBook(@PathVariable("id")int id) {
        return new ResponseEntity<>(repoBooks.findById(id).orElseThrow(),HttpStatus.OK);
    }
    @PostMapping("/book/add")
    public ResponseEntity<Book> createLib(@RequestBody Book book) {
        return new ResponseEntity<>(repoBooks.save(book),HttpStatus.CREATED);
    }
    @PostMapping("/book/{id}/to/{idd}")
    public ResponseEntity<Book> bookResponseEntity(@PathVariable("id")int id,@PathVariable("idd")int id1) {
        Book book = repoBooks.findById(id).orElseThrow();
        book.setLibrary(repoLibrary.findById(id1).orElseThrow());
        return new ResponseEntity<>(repoBooks.save(book),HttpStatus.OK);
    }
    @PatchMapping("/book/detach/{id}")
    public ResponseEntity<Book> detach(@PathVariable("id")int id) {
        Book book = repoBooks.findById(id).orElseThrow(() -> new RuntimeException("not found! Do is understand Client?"));
        book.setLibrary(null);
        return new ResponseEntity<>(repoBooks.save(book),HttpStatus.OK);
    }
}
