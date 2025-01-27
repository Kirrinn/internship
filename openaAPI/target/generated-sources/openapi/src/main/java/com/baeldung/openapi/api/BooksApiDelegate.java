package com.baeldung.openapi.api;

import com.baeldung.openapi.model.BookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link BooksApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T14:51:59.454589200+01:00[Europe/Budapest]", comments = "Generator version: 7.8.0")
public interface BooksApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /books : Return list of books.
     *
     * @return OK (status code 200)
     * @see BooksApi#booksGet
     */
    default ResponseEntity<List<BookDto>> booksGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"author\" : \"author\", \"publicationYear\" : 0, \"publisher\" : \"publisher\", \"title\" : \"title\" }, { \"author\" : \"author\", \"publicationYear\" : 0, \"publisher\" : \"publisher\", \"title\" : \"title\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /books/{id} : Returna a book with specific id.
     *
     * @param id The id of the book. (required)
     * @return OK (status code 200)
     *         or Not Found (status code 404)
     * @see BooksApi#booksIdGet
     */
    default ResponseEntity<BookDto> booksIdGet(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"author\" : \"author\", \"publicationYear\" : 0, \"publisher\" : \"publisher\", \"title\" : \"title\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /books : Add a book.
     *
     * @param bookDto  (required)
     * @return OK (status code 200)
     *         or Not found (status code 404)
     * @see BooksApi#booksPost
     */
    default ResponseEntity<Long> booksPost(BookDto bookDto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
