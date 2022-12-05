package com.gomgom.gomgombank.api.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class IssueTokenRequest {
    @ApiModelProperty(value = "file", dataType = "file", example = "100")
    private MultipartFile file;
}
