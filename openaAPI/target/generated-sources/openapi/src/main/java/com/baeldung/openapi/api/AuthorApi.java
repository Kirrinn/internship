/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.8.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.baeldung.openapi.api;

import com.baeldung.openapi.model.AuthorDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-01-16T14:51:59.454589200+01:00[Europe/Budapest]", comments = "Generator version: 7.8.0")
@Validated
@Tag(name = "author-controller", description = "the author-controller API")
public interface AuthorApi {

    default AuthorApiDelegate getDelegate() {
        return new AuthorApiDelegate() {};
    }

    /**
     * GET /author/{id} : Get author with specific id.
     *
     * @param id Id of the author. (required)
     * @return Not Found (status code 404)
     *         or OK (status code 200)
     */
    @Operation(
        operationId = "authorIdGet",
        summary = "Get author with specific id.",
        tags = { "author-controller" },
        responses = {
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = AuthorDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/author/{id}",
        produces = { "application/json" }
    )
    
    default ResponseEntity<AuthorDto> authorIdGet(
        @Parameter(name = "id", description = "Id of the author.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id
    ) {
        return getDelegate().authorIdGet(id);
    }


    /**
     * PUT /author/{id} : Change author with specific id.
     *
     * @param id Id of the author. (required)
     * @param authorDto  (required)
     * @return Internal server error (status code 500)
     *         or Accepted (status code 202)
     */
    @Operation(
        operationId = "authorIdPut",
        summary = "Change author with specific id.",
        tags = { "author-controller" },
        responses = {
            @ApiResponse(responseCode = "500", description = "Internal server error"),
            @ApiResponse(responseCode = "202", description = "Accepted", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/author/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Long> authorIdPut(
        @Parameter(name = "id", description = "Id of the author.", required = true, in = ParameterIn.PATH) @PathVariable("id") Long id,
        @Parameter(name = "AuthorDto", description = "", required = true) @Valid @RequestBody AuthorDto authorDto
    ) {
        return getDelegate().authorIdPut(id, authorDto);
    }


    /**
     * POST /author : Add a author.
     *
     * @param authorDto  (required)
     * @return OK (status code 200)
     */
    @Operation(
        operationId = "authorPost",
        summary = "Add a author.",
        tags = { "author-controller" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Long.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/author",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    default ResponseEntity<Long> authorPost(
        @Parameter(name = "AuthorDto", description = "", required = true) @Valid @RequestBody AuthorDto authorDto
    ) {
        return getDelegate().authorPost(authorDto);
    }

}
