package com.polarbooksshop.catalogservice.domain;

import java.util.Optional;
//도메인 접근을 위한 도메인 계층 추상화
public interface BookRepository {

	Iterable<Book> findAll();
	Optional<Book> findByIsbn(String isbn);
	boolean existsByIsbn(String isbn);
	Book save(Book book);
	void deleteByIsbn(String isbn);

}
