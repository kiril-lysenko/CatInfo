package com.self.education.catinfo.resource;

import com.self.education.catinfo.api.CatsColorInfoResponse;
import com.self.education.catinfo.service.CatsStatisticService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/cats-statistic")
public class CatsStatisticResource {

    private final CatsStatisticService catsStatisticService;

    @Operation(summary = "Add cat colors info",
            description = "Endpoint for adding information about the number of cats of each color",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Created"),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "409", description = "Conflict"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    @PostMapping
    public ResponseEntity<List<CatsColorInfoResponse>> createCatsColorInfo() {
        return new ResponseEntity<>(catsStatisticService.createCatColorsInfo(), CREATED);
    }
}
