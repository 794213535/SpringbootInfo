package com.cskaoyan.project.service.Impl;


import com.aliyun.oss.OSSClient;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class AliUploadService {
    // endpoint以杭州为例，其它region请按实际情况填写
    String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
    String accessKeyId = "LTAIvOfFBk2mW0rT";
    String accessKeySecret = "Es1WmpiGJQOhurfPsKnHPbQwR3MfST";


    String buketname = "wangdaoimages";

    public String upload(MultipartFile file) {

        // 创建OSSClient实例
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 使用访问OSS

        String originalFilename = file.getOriginalFilename();

        // 上传
        byte[] content = new byte[0];
        try {
            content = file.getBytes();
            client.putObject(buketname, originalFilename, new ByteArrayInputStream(content));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 关闭client
        client.shutdown();

        return  "https://"+buketname+".oss-cn-shenzhen.aliyuncs.com" +"\\"+originalFilename;
    }
}