package com.gomgom.gomgombank.data.mapper;

import com.gomgom.gomgombank.data.model.IssueToken;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface IssueTokenMapper {
    int insert(IssueToken record);

    int insertSelective(IssueToken record);

    int insertMultiRow(HashMap<String, List<HashMap<String ,String>>> dataParam);
}
