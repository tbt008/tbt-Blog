package com.blog.controller.admin;

import com.blog.utils.AliOssUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YT
 * @since 2024-01-28
 */
@RestController
@Slf4j
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

    // 1   上传
    @PostMapping("/addFile")
    public String upload(@RequestParam("file") MultipartFile File) throws Exception {
        return AliOssUtil.uploadFile(File.getOriginalFilename(),File.getInputStream());
    }



}


