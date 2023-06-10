package com.rq.loyalty.rest.controller.interfaces;

import com.rq.loyalty.rest.dto.request.StoreRequestDTO;
import com.rq.loyalty.rest.dto.response.StoreResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RestController
@Tag(name = "Consult the stories.")
@RequestMapping("/v1/store")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface IStoreController {

    @Operation(summary = "Test the integrity of the stores system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "202",
                    description = "If system health is stable.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            """
                            )
                    )
            )
    })
    @GetMapping(value = "/health")
    ResponseEntity healthCheck();

    @Operation(summary = "Save a new store in the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "If registration is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "storeId": "edb88983-8bd4-4033-8334-a21a15e3cd0b",
                                              "createdAt": "2023-02-17T11:21:28.3157412",
                                              "document": "26799819000154",
                                              "name": "test store"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "If the request is invalid.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 400,
                                              "title": "Bad Request",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "If the user is not authenticated.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 401,
                                              "title": "Unauthorized",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )
    })
    @RequestBody(
            description = """
                    Data to save a new store.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                      "document": "26799819000154",
                                      "name": "test store"
                                    }
                                    """
                    )
            )
    )
    @PostMapping
    ResponseEntity<StoreResponseDTO> save(@Valid @RequestBody StoreRequestDTO storeRequest);

    @Operation(summary = "Lists all stories saved in the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            [
                                              {
                                                "storeId": "edb88983-8bd4-4033-8334-a21a15e3cd0b",
                                                "createdAt": "2023-02-17T11:21:28.3157412",
                                                "document": "26799819000154",
                                                "name": "test store 1"
                                              },
                                              {
                                                "storeId": "6bcf4940-0087-11ee-be56-0242ac120002",
                                                "createdAt": "2023-06-01T11:20:28.3157412",
                                                "document": "01642043000133",
                                                "name": "test store 2"
                                              }
                                            ]
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "If the user is not authenticated.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 401,
                                              "title": "Unauthorized",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping
    ResponseEntity<List<StoreResponseDTO>> findAll(@RequestParam(name = "name", required = false) String name);

    @Operation(summary = "Finds a store by id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "storeId": "edb88983-8bd4-4033-8334-a21a15e3cd0b",
                                              "createdAt": "2023-02-17T11:21:28.3157412",
                                              "document": "26799819000154",
                                              "name": "test store"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "If the user is not authenticated.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 401,
                                              "title": "Unauthorized",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "If the store is not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 404,
                                              "title": "Not Found",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<StoreResponseDTO> findById(@PathVariable("id") String storeId);

    @Operation(summary = "Update store data.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "storeId": "edb88983-8bd4-4033-8334-a21a15e3cd0b",
                                              "createdAt": "2023-02-17T11:21:28.3157412",
                                              "document": "26799819000154",
                                              "name": "test store"
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "If the request is invalid.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 400,
                                              "title": "Bad Request",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "If the user is not authenticated.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 401,
                                              "title": "Unauthorized",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "If the store is not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 404,
                                              "title": "Not Found",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )
    })
    @PutMapping("/update/{id}")
    ResponseEntity<StoreResponseDTO> update(@Valid @RequestBody StoreRequestDTO storeRequest, @PathVariable("id") String storeId);

    @Operation(summary = "Deletes a store by id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "If the action was taken and no further information should be provided.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "If the user is not authenticated.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 401,
                                              "title": "Unauthorized",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "If the store is not found.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "timestamp": "2023-02-16T19:50:07.516558",
                                              "status": 404,
                                              "title": "Not Found",
                                              "detail": "Short description of the problem."
                                            }
                                            """
                            )
                    )
            )
    })
    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable("id") String ruleId);

}
