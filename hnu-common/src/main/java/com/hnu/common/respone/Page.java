package com.hnu.common.respone;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author： yuan
 * @Description: description
 * @Date: Created in 13:32 2017/11/29
 * @Modified By:
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Page<T> {

    private long pageSize;
    private long pageIndex;
    private long pageCount;
    private long totalCount;
    private List<T> list ;

}
