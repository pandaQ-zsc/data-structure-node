package com.example.demo.httpUtils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

/**
 * @author: xiong.qiang
 * @date: 2023/3/11 15:10
 */
public class FileUploader {

    /**
     * 使用时只需调用uploadFile方法，传入API接口地址和要上传的文件路径即可。
     * 注意，这里使用了FileSystemResource来创建文件资源，
     * 并将其作为MultiValueMap的一个属性来上传。RestTemplate会自动将其转换为multipart/form-data格式。
     *
     * @param apiUrl
     * @param filePath
     */
    public static void uploadFile(String apiUrl, String filePath) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        body.add("file", new FileSystemResource(new File(filePath)));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(apiUrl, requestEntity, String.class);

        if (responseEntity.getStatusCodeValue() == 200) {
            // 文件上传成功
        } else {
            // 文件上传失败
        }
    }
}
