package com.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("label_article")
public class LabelArticle {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    public Integer labelId;
    public Integer articleId;
}

