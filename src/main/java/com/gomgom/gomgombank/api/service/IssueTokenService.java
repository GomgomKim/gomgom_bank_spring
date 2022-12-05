package com.gomgom.gomgombank.api.service;

import com.gomgom.gomgombank.api.model.IssueTokenRequest;
import com.gomgom.gomgombank.api.model.IssueTokenResult;
import com.gomgom.gomgombank.data.mapper.IssueTokenMapper;
import com.gomgom.gomgombank.data.model.IssueToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class IssueTokenService {
    @Autowired
    IssueTokenMapper issuanceTokenMapper;

    private static final Map<String, SseEmitter> CLIENTS = new ConcurrentHashMap<>();
    SseEmitter emitter;
    String userId;

    @Transactional
    public IssueTokenResult createIssuanceToken(IssueTokenRequest request) throws Exception {
        IssueToken issueToken = new IssueToken();
//        issuanceToken.setId(request.getId());
//        issuanceToken.setFirstname(request.getFirstname());
//        issuanceToken.setLastname(request.getLastname());
//        issuanceToken.setEmail(request.getEmail());
        IssueTokenResult result = issuanceTokenMapper.insertSelective(issueToken) > 0 ? IssueTokenResult.SUCCESS : IssueTokenResult.FAIL;
        return result;
    }

}
