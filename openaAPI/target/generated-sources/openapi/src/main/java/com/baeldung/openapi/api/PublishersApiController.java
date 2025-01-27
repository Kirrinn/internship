package com.baeldung.openapi.api;

import com.baeldung.openapi.model.PublisherDto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T14:51:59.454589200+01:00[Europe/Budapest]", comments = "Generator version: 7.8.0")
@Controller
@RequestMapping("${openapi.library.base-path:/api}")
public class PublishersApiController implements PublishersApi {

    private final PublishersApiDelegate delegate;

    public PublishersApiController(@Autowired(required = false) PublishersApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PublishersApiDelegate() {});
    }

    @Override
    public PublishersApiDelegate getDelegate() {
        return delegate;
    }

}
