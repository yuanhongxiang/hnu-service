package com.hnu.common.respone.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author： yuan
 * @Description: description
 * @Date: Created in 15:05 2017/12/21
 * @Modified By:
 */
@Setter
@Getter
public class BaseVo {

    /**主键id*/
    private long id;

    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;

    /**更新时间*/
    private String creater;

    /**更新时间*/
    private String updater;

}
