package com.gomgom.gomgombank.api.controller;

import com.gomgom.gomgombank.api.model.IssueTokenRequest;
import com.gomgom.gomgombank.api.model.IssueTokenResult;
import com.gomgom.gomgombank.api.service.IssueTokenService;
import com.gomgom.gomgombank.common.constants.ErrorCode;
import com.gomgom.gomgombank.common.exception.BasicException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/token")
@Api(tags = {"토큰 발급"})
public class IssueTokenController {

    @Autowired
    IssueTokenService issuanceTokenService;


    @RequestMapping(value = "/create-string", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public IssueTokenResult issueToken(@RequestBody IssueTokenRequest request, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) throw new BasicException(ErrorCode.COMMON_BAD_REQUEST);
        return issuanceTokenService.createIssuanceToken(request);
    }

}
