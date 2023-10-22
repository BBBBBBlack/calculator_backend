package com.example.calculator_server.service.impl;

import com.example.calculator_server.domain.DepRate;
import com.example.calculator_server.domain.LoanRate;
import com.example.calculator_server.domain.ResponseResult;
import com.example.calculator_server.domain.vo.RateVo;
import com.example.calculator_server.mapper.ApiMapper;
import com.example.calculator_server.service.ApiService;
import com.example.calculator_server.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {
    @Autowired
    private ApiMapper apiMapper;

    @Override
    public ResponseResult getRateTable(Integer rateType) {
        if (rateType == 0) {
            Object o = apiMapper.getDepRateTable().get(0);
            return new ResponseResult(200, "存款利率表", o);
        } else if (rateType == 1) {
            LoanRate loanRateTable = apiMapper.getLoanRateTable().get(0);
            return new ResponseResult(201, "贷款利率表", loanRateTable);
        }
        return new ResponseResult(400, "参数错误", null);
    }

    @Override
    public ResponseResult updateRateTable(Integer rateType, LinkedHashMap<String, Object> rateTable) {
        if (rateType == 0) {
            DepRate depRate = DepRate.mapToDepRate(rateTable);
            apiMapper.updateDepRateTable(depRate);
            depRate = apiMapper.getDepRateTable().get(0);
            return new ResponseResult(200, "存款利率表", depRate);
        } else if (rateType == 1) {
            LoanRate loanRate = LoanRate.mapToLoanRate(rateTable);
            apiMapper.updateLoanRateTable(loanRate);
            loanRate = apiMapper.getLoanRateTable().get(0);
            return new ResponseResult(201, "贷款利率表", loanRate);
        }
        return new ResponseResult(400, "参数错误", null);
    }

    @Override
    public ResponseResult addHistory(String expression) {
        Double result = Double.parseDouble(expression
                .substring(expression.lastIndexOf('=') + 1));
        expression = expression.substring(0, expression.lastIndexOf('='));
        apiMapper.addHistory(expression, result);
        return new ResponseResult(200, "添加历史记录", null);
    }

    @Override
    public ResponseResult getHistory() {
        return new ResponseResult(200, "历史记录", apiMapper.getHistory());
    }
}