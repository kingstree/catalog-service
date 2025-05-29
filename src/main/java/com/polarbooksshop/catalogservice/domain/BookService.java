package com.polarbooksshop.catalogservice.domain;

import org.springframework.stereotype.Service;

@Service // 스프링이 관리하는 서비스를 표시
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository; // bookRepository를 생성자 오토 와이어링 통해 제공
    }

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn) {
        return bookRepository.findByIsbn(isbn) // 존재하지 않는 책을 보려고 할때 그에 해당하는 예외를 발생 시킴
                .orElseThrow(() -> new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book) {
        if (bookRepository.existsByIsbn(book.isbn())) { // 동일한 책을 여러 번 추가하려 시도 시 예외 발생
            throw new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByIsbn(isbn);
    }

    public Book editBookDetails(String isbn, Book book) {
		return bookRepository.findByIsbn(isbn)
				.map(existingBook -> {
					var bookToUpdate = new Book( // 책을 수정할 때 개체 식별자인 ISBN코드를 제외한 모든 피드를 수정할 수 있다.
							existingBook.isbn(),
							book.title(),
							book.author(),
							book.price());
					return bookRepository.save(bookToUpdate);
				})
				.orElseGet(() -> addBookToCatalog(book)); // 카탈로그에 존제하지 않은 책 수정하려할 시 신규 책 생성
    }

}
