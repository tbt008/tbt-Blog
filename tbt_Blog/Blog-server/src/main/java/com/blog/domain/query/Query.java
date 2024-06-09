package com.blog.domain.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Query {
    private Integer pageNo ;
    private Integer pageSize ;

     public Page toPage(){
      return new Page<>(pageNo,pageSize);
     }
}
