package com.dev.eficiente.loja.endpoints;

import com.dev.eficiente.loja.dto.BookDTO;
import com.dev.eficiente.loja.dto.ResponseBook;
import com.dev.eficiente.loja.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/book")
@Validated
public class BookResource {
    private final BookRepository bookRepository;

    public BookResource(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public ResponseEntity<BookDTO> salve(@Valid @RequestBody BookDTO request) {

        bookRepository.save(request.toDomain());
        return ResponseEntity.ok().body(request);

    }

    @GetMapping()
    public ResponseEntity<List<ResponseBook>> findAll() {
        var listBook = bookRepository.findAll();
        var response = listBook.stream().map(b -> new ResponseBook(b.getId().toString(), b.getTitle())).collect(Collectors.toList());
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseBook> findById(@PathVariable("id") long id) {
        var book = bookRepository.findById(id);
        if (!book.isPresent()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(ResponseBook.fromDomain(book.get()));
        }


    }
}
