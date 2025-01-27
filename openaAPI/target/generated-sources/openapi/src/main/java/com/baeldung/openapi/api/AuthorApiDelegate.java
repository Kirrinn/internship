package com.baeldung.openapi.api;

import com.baeldung.openapi.model.AuthorDto;
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
 * A delegate to be called by the {@link AuthorApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T14:51:59.454589200+01:00[Europe/Budapest]", comments = "Generator version: 7.8.0")
public interface AuthorApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /author/{id} : Get author with specific id.
     *
     * @param id Id of the author. (required)
     * @return Not Found (status code 404)
     *         or OK (status code 200)
     * @see AuthorApi#authorIdGet
     */
    default ResponseEntity<AuthorDto> authorIdGet(Long id) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"nationality\" : \"nationality\", \"year\" : 0, \"name\" : \"name\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /author/{id} : Change author with specific id.
     *
     * @param id Id of the author. (required)
     * @param authorDto  (required)
     * @return Internal server error (status code 500)
     *         or Accepted (status code 202)
     * @see AuthorApi#authorIdPut
     */
    default ResponseEntity<Long> authorIdPut(Long id,
        AuthorDto authorDto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /author : Add a author.
     *
     * @param authorDto  (required)
     * @return OK (status code 200)
     * @see AuthorApi#authorPost
     */
    default ResponseEntity<Long> authorPost(AuthorDto authorDto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
