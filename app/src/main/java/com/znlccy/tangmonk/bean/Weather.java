package com.znlccy.tangmonk.bean;

import java.io.Serializable;
import java.util.List;

public class Weather implements Serializable {

    /* 声明日期 */
    public String date;

    /* 声明错误码 */
    public int error;

    /* 声明结果集 */
    public List<ResultEntity> results;

    /* 声明状态 */
    public String status;

    public class ResultEntity implements Serializable {

    }
}
