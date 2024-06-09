package com.blog.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author YT
 * @since 2024-01-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class File implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文件编号
     */
    @TableId(value = "file_id", type = IdType.AUTO)
    private Integer fileId;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 学生信息
     */
    private String stuId;

    /**
     * 文件路径
     */
    private String fileUrl;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 所属考试编号
     */
    private Long belongExamId;

    /**
     * 是否删除
     */
    @JsonIgnore
    @TableLogic
    private Boolean isDelete;


    @TableField(fill = FieldFill.INSERT)
    private String creator;


}
