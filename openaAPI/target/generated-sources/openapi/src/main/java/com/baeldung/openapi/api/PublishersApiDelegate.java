package com.baeldung.openapi.api;

import com.baeldung.openapi.model.PublisherDto;
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
 * A delegate to be called by the {@link PublishersApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T14:51:59.454589200+01:00[Europe/Budapest]", comments = "Generator version: 7.8.0")
public interface PublishersApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /publishers : Add a publisher.
     *
     * @param publisherDto  (required)
     * @return OK (status code 200)
     * @see PublishersApi#publishersPost
     */
    default ResponseEntity<Long> publishersPost(PublisherDto publisherDto) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
