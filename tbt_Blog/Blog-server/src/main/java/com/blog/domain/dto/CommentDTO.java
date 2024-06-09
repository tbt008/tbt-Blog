package com.blog.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CommentDTO {
//来源  1.文章，2.留言，3，说说
    private Integer     source;
    private Integer      sourceId;
    private String       img;
    private String       name;
    private String      targetName;
    private Integer   targetId;
    private String       content;
    private String      url;
    private String      qq;
    private String      email;
}
