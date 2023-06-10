package com.rq.loyalty.rest.controller.interfaces;

import com.rq.loyalty.rest.dto.request.RuleRequestDTO;
import com.rq.loyalty.rest.dto.response.RuleResponseDTO;
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
@Tag(name = "Consult the rules.")
@RequestMapping("/v1/rule")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface IRuleController {

    @Operation(summary = "Test the integrity of the rules system.")
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

    @Operation(summary = "Save a new rule in the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "If registration is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "ruleId": "bab99804-c657-4c9f-aef8-ed5e887c71d7",
                                              "createdAt": "2023-02-17T10:31:29.5693644",
                                              "name": "test name",
                                              "conversion": 0,
                                              "daysToExpire": 0,
                                              "redeemLimit": 0,
                                              "productId": "9bc748d5-3ad1-4e9a-bb8a-80ecbb6454ff",
                                              "productName": "product name test"
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
                    Data to save a new rule.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                      "name": "test name",
                                      "conversion": 0,
                                      "daysToExpire": 0,
                                      "redeemLimit": 0,
                                      "productId": "9bc748d5-3ad1-4e9a-bb8a-80ecbb6454ff",
                                      "productName": "product name test"
                                    }
                                    """
                    )
            )
    )
    @PostMapping
    ResponseEntity<RuleResponseDTO> save(@Valid @RequestBody RuleRequestDTO ruleRequest);

    @Operation(summary = "Lists all rules saved in the system.")
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
                                                "ruleId": "bab99804-c657-4c9f-aef8-ed5e887c71d7",
                                                "createdAt": "2023-02-17T10:31:29.5693644",
                                                "name": "test name 1",
                                                "conversion": 0,
                                                "daysToExpire": 0,
                                                "redeemLimit": 0,
                                                "productId": "9bc748d5-3ad1-4e9a-bb8a-80ecbb6454ff",
                                                "productName": "product name test 1"
                                              },
                                              {
                                                "ruleId": "28d1b108-0089-11ee-be56-0242ac120002",
                                                "createdAt": "2023-06-01T11:31:29.5693644",
                                                "name": "test name 2",
                                                "conversion": 0,
                                                "daysToExpire": 0,
                                                "redeemLimit": 0,
                                                "productId": "33f87080-0089-11ee-be56-0242ac120002",
                                                "productName": "product name test 2"
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
    ResponseEntity<List<RuleResponseDTO>> findAll();

    @Operation(summary = "Finds a rule by id.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "ruleId": "bab99804-c657-4c9f-aef8-ed5e887c71d7",
                                              "createdAt": "2023-02-17T10:31:29.5693644",
                                              "name": "test name",
                                              "conversion": 0,
                                              "daysToExpire": 0,
                                              "redeemLimit": 0,
                                              "productId": "9bc748d5-3ad1-4e9a-bb8a-80ecbb6454ff",
                                              "productName": "product name test"
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
                    description = "If the rule is not found.",
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
    ResponseEntity<RuleResponseDTO> findById(@PathVariable("id") String ruleId);

    @Operation(summary = "Update rule data.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If the query is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "ruleId": "bab99804-c657-4c9f-aef8-ed5e887c71d7",
                                              "createdAt": "2023-02-17T10:31:29.5693644",
                                              "name": "test name",
                                              "conversion": 0,
                                              "daysToExpire": 0,
                                              "redeemLimit": 0,
                                              "productId": "9bc748d5-3ad1-4e9a-bb8a-80ecbb6454ff",
                                              "productName": "product name test"
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
                    description = "If the rule is not found.",
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
    ResponseEntity<RuleResponseDTO> update(@Valid @RequestBody RuleRequestDTO ruleRequest, @PathVariable("id") String ruleId);

    @Operation(summary = "Deletes a rule by id.")
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
                    description = "If the rule is not found.",
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
