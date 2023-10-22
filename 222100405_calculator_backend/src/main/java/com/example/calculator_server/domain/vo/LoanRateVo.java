package com.example.calculator_server.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanRateVo extends RateVo implements Serializable {
    private static final long serialVersionUID = 1034761965982343L;
    /**
     * 6月
     */
    private Double sixMon;
    /**
     * 1年
     */
    private Double oneYear;
    /**
     * 1-3年
     */
    private Double oneToThree;
    /**
     * 3-5年
     */
    private Double threeToFive;
    /**
     * 5年
     */
    private Double fiveYear;

}
