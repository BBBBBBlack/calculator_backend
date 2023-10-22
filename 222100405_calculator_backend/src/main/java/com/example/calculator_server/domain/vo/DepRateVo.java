package com.example.calculator_server.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepRateVo extends RateVo implements Serializable {
    private static final long serialVersionUID = 426912846210087L;
    /**
     * 活期存款
     */
    private Double demandDep;
    /**
     * 三个月
     */
    private Double threeMon;
    /**
     * 半年
     */
    private Double sixMon;
    /**
     * 1年
     */
    private Double oneYear;
    /**
     * 2年
     */
    private Double twoYear;
    /**
     * 3年
     */
    private Double threeYear;
    /**
     * 5年
     */
    private Double fiveYear;

}
