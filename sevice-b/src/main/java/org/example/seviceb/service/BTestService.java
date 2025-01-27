package org.example.seviceb.service;

import com.example.model.AuthorDto;
import com.example.model.BookDto;
import com.example.model.PublisherDto;
import lombok.extern.slf4j.Slf4j;
import org.example.seviceb.model.BookServiceBDto;
import org.example.seviceb.model.PublisherServiceBDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;

import org.example.seviceb.model.AuthorServiceBDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;


import java.util.List;

@Slf4j
@Service
public class BTestService {

    private final RestClient restClient;

    public BTestService() {
        restClient = RestClient.builder().baseUrl("http://localhost:9091/api").build();
    }

    public AuthorServiceBDto findAuthorById(long id) {
        ResponseEntity<AuthorDto> response = restClient.get().uri("/author/{id}",id).retrieve().
                toEntity(AuthorDto.class);

        if(response.getStatusCode()== HttpStatus.OK){
            return new AuthorServiceBDto(response.getBody().getName(),response.getBody().getYear(),
                    response.getBody().getNationality(),"Uspela komunikacija izmedju mikroservisa");
        }
        return null;
    }

    public List<BookServiceBDto> getAllBooksWithIbn() {
        List<BookServiceBDto> allBooks = null;
        List<BookDto> response = restClient.get().uri("/books").retrieve().body(new ParameterizedTypeReference<List<BookDto>>() {
        });
        if(response!=null){
            allBooks = response.stream().map(bookRetrieveDto -> new BookServiceBDto(bookRetrieveDto.getTitle(),
                            bookRetrieveDto.getPublicationYear(),bookRetrieveDto.getAuthor(),bookRetrieveDto.getPublisher(),1))
                    .toList();
        }

        return allBooks;
    }

    public Long addPublisher(PublisherServiceBDto publisherDto) {

        ResponseEntity<Long> response = restClient.post().uri("/publishers").body(new PublisherDto(
                publisherDto.getName(),
                publisherDto.getCountry()
        )).contentType(MediaType.APPLICATION_JSON).retrieve().toEntity(Long.class);

        return response.getBody();
    }
}
