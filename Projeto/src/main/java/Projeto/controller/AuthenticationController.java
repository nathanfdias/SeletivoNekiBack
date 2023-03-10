package Projeto.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Projeto.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ResponseHeader;

@RestController
public class AuthenticationController {

    @ApiOperation("User login")
    @ApiResponses(value = {
    @ApiResponse(code = 200, 
            message = "Response Headers", 
            responseHeaders = {
                @ResponseHeader(name = "authorization", 
                        description = "Bearer <JWT value here>"),

            })  
    })
    
    @PostMapping("/login")
    public void theFakeLogin(@RequestBody UserDTO loginRequestModel)
    {
        throw new IllegalStateException("This method should not be called. This method is implemented by Spring Security");
    }
}