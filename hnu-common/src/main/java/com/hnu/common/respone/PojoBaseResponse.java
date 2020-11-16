package com.hnu.common.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author： yuan
 * @Description: 集合数据返回response封装
 * @Date: Created in 13:36 2017/11/29
 * @Modified By:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PojoBaseResponse<T> extends BaseResponse {

    private T data;
}
