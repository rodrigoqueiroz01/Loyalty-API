package com.rq.loyalty.rest.controller.interfaces;

import com.rq.loyalty.rest.dto.request.CustomerRequestDTO;
import com.rq.loyalty.rest.dto.response.CustomerResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
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
@Tag(name = "Consult the customers.")
@RequestMapping("/v1/customer")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface ICustomerController {

    @Operation(summary = "Test the integrity of the client system.")
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

    @Operation(summary = "Save a new customer in the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "If registration is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "customerId": "347287c0-ca39-429a-bc50-0d857385063d",
                                              "createdAt": "2023-02-16T19:50:07.516558",
                                              "document": "51041985029",
                                              "name": "test name"
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
                    Data to save a new customer.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                      "document": "51041985029",
                                      "name": "test name"
                                    }
                                    """
                    )
            )
    )
    @PostMapping
    ResponseEntity<CustomerResponseDTO> save(@Valid @RequestBody CustomerRequestDTO customerRequest);

    @Operation(summary = "Lists all customers saved in the system.")
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
                                                "customerId": "347287c0-ca39-429a-bc50-0d857385063d",
                                                "createdAt": "2023-02-16T19:50:07.516558",
                                                "document": "51041985029",
                                                "name": "test name 1"
                                              },
                                              {
                                                "customerId": "82c3d358-0089-11ee-be56-0242ac120002",
                                                "createdAt": "2023-06-01T11:34:07.516558",
                                                "document": "11224160088",
                                                "name": "test name 2"
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
    ResponseEntity<List<CustomerResponseDTO>> findAll(@RequestParam(name = "name", required = false) String name);

    @Operation(summary = "Find a customer by ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "customerId": "347287c0-ca39-429a-bc50-0d857385063d",
                                              "createdAt": "2023-02-16T19:50:07.516558",
                                              "document": "51041985029",
                                              "name": "test name"
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
                    description = "If the client is not found.",
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
    ResponseEntity<CustomerResponseDTO> findById(@PathVariable("id") String customerId);

    @Operation(summary = "Update customer data.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "customerId": "347287c0-ca39-429a-bc50-0d857385063d",
                                              "createdAt": "2023-02-16T19:50:07.516558",
                                              "document": "51041985029",
                                              "name": "test name"
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
                    description = "If the client is not found.",
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
    ResponseEntity<CustomerResponseDTO> update(@Valid @RequestBody CustomerRequestDTO customerRequest, @PathVariable("id") String customerId);

    @Operation(summary = "Deletes a customer by id.")
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
                    description = "If the client is not found.",
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
    ResponseEntity<String> delete(@PathVariable("id") String customerId);

}
