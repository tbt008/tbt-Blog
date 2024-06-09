package com.blog.domain.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ArticleQuery {
    private Integer pageNo ;
    private Integer pageSize ;
    private Integer typeId;

    @ApiModelProperty(value = "是否升序", example = "true")
    private Boolean isAsc = true;
     public Page toPage(){
      return new Page<>(pageNo,pageSize);
     }
}
