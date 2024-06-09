package com.blog.utils;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

import java.io.InputStream;
public class AliOssUtil {

    private static final String ENDPOINT ="";//https://oss-cn-beijing.aliyuncs.com
    //从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量


    private static final String ACCESS_KEY_ID="";
        private static final String ACCESS_KEY_SECRET="";
    //填写Bucket名称，例如exampLebucket。
    private static final String BUCKET_NAME ="";
    public static String uploadFile(String objectName, InputStream in) throws Exception {

        //创建OSScLient实例。

        OSS ossCLient = new OSSClientBuilder().build(ENDPOINT,ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        String url = "";
            //创建PutobjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKET_NAME,objectName,in);

        PutObjectResult res = ossCLient.putObject(putObjectRequest);
        url="http://"+BUCKET_NAME+'.'+ENDPOINT.substring(ENDPOINT.lastIndexOf("/")+1)+"/"+objectName;
            return url;

    }
}
