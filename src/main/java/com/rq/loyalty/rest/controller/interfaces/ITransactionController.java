package com.rq.loyalty.rest.controller.interfaces;

import com.rq.loyalty.entity.Transaction;
import com.rq.loyalty.rest.dto.request.CheckRequestDTO;
import com.rq.loyalty.rest.dto.request.PointRequestDTO;
import com.rq.loyalty.rest.dto.request.RedeemRequestDTO;
import com.rq.loyalty.rest.dto.response.CheckResponseDTO;
import com.rq.loyalty.rest.dto.response.PointResponseDTO;
import com.rq.loyalty.rest.dto.response.RedeemResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Validated
@RestController
@Tag(name = "Consult the transactions.")
@RequestMapping("/v1/transaction")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface ITransactionController {

    @Operation(summary = "Test the integrity of the transactions system.")
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
    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity healthCheck();

    @Operation(summary = "List of customer transactions.")
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
                                                "seqId": 1,
                                                "transactionId": "dbd984f7-08fa-4342-a639-73f9c2a01d70",
                                                "type": 1,
                                                "ruleId": "dbd984f7-08fa-4342-a639-73f9c2a01d70",
                                                "customerId": "dbd984f7-08fa-4342-a639-73f9c2a01d70",
                                                "storeId": "dbd984f7-08fa-4342-a639-73f9c2a01d70",
                                                "orderId": "dbd984f7-08fa-4342-a639-73f9c2a01d70",
                                                "createdAt": "2023-03-09 17:45:43",
                                                "points": 10,
                                                "amount": 10,
                                                "expiration": "2023-03-09T17:45:43.126Z",
                                                "productId": "dbd984f7-08fa-4342-a639-73f9c2a01d70",
                                                "productName": "test product"
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
    @GetMapping(value = "/customerId", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Transaction>> findAllByCustomer(@RequestParam String customerId) throws Exception;

    @Operation(summary = "Check customer scores.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If verification is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "customerId": "dbd984f7-08fa-4342-a639-73f9c2a01d70",
                                              "storeId": "dbd984f7-08fa-4342-a639-73f9c2a01d70",
                                              "ruleId": "dbd984f7-08fa-4342-a639-73f9c2a01d70",
                                              "points": 10,
                                              "amount": 10,
                                              "nextExpirationDate": "2023-02-17T11:21:28.3157412",
                                              "nextExpirationPoints": 10,
                                              "pointsToExpireIn30": 10
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
    @GetMapping(value = "/check", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CheckResponseDTO> checkPoints(CheckRequestDTO dto) throws Exception;

    @Operation(summary = "Throws a score.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If registration is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "transactionId": null,
                                              "customerId": "a30acaf5-427e-425e-8268-e0604e5aa255",
                                              "storeId": "6dcb88b4-9f3f-4014-a4b5-f8e87716a50a",
                                              "ruleId": "bebc7031-6d6b-4082-9098-865aad834fa4",
                                              "points": 50,
                                              "amount": 100,
                                              "balancePoints": 50,
                                              "balanceAmount": 100,
                                              "orderId": "9bc748d5-3ad1-4e9a-bb8a-80ecbb6454ff"
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
                    Dice to roll a new score.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                      "customerId": "a30acaf5-427e-425e-8268-e0604e5aa255",
                                      "storeId": "6dcb88b4-9f3f-4014-a4b5-f8e87716a50a",
                                      "ruleId": "bebc7031-6d6b-4082-9098-865aad834fa4",
                                      "points": 50,
                                      "amount": 100,
                                      "orderId": "9bc748d5-3ad1-4e9a-bb8a-80ecbb6454ff"
                                    }
                                    """
                    )
            )
    )
    @PostMapping(value = "/point", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<PointResponseDTO> savePoint(@Valid @RequestBody PointRequestDTO pointRequest) throws Exception;

    @Operation(summary = "Redeem a benefit.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "If registration is successful.",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                              "transactionId": "7d4b0afe-fbbd-402b-9640-49305a5debb0",
                                              "customerId": "4916efee-fcf5-422e-a075-0448aac9bb99",
                                              "storeId": "87780db0-5b62-4a8c-93ea-68e5dd4deb5f",
                                              "ruleId": "576e86a7-23cc-41c3-9fd9-ea0eb476ddb9",
                                              "orderId": "41f578de-3503-4867-9dd0-f711f91a4d36",
                                              "points": 50,
                                              "amount": 50,
                                              "productId": "49197440-4b2a-46da-a717-4a331dd67a60",
                                              "productName": "Product name test"
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
                    Data to redeem a benefit.
                    """,
            content = @Content(
                    mediaType = "application/json",
                    examples = @ExampleObject(
                            value = """
                                    {
                                      "customerId": "4916efee-fcf5-422e-a075-0448aac9bb99",
                                      "storeId": "87780db0-5b62-4a8c-93ea-68e5dd4deb5f",
                                      "ruleId": "576e86a7-23cc-41c3-9fd9-ea0eb476ddb9",
                                      "orderId": "41f578de-3503-4867-9dd0-f711f91a4d36",
                                      "points": 50,
                                      "amount": 50,
                                      "productId": "49197440-4b2a-46da-a717-4a331dd67a60",
                                      "productName": "Product name test"
                                    }
                                    """
                    )
            )
    )
    @PostMapping(value = "/redeem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<RedeemResponseDTO> saveRedeem(@Valid @RequestBody RedeemRequestDTO redeemRequest) throws Exception;

}
