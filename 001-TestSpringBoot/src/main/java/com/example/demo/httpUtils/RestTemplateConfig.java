package com.example.demo.httpUtils;

import okhttp3.OkHttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * @author: xiong.qiang
 * @date: 2023/2/21 11:22
 */
//https://www.jianshu.com/p/58949f8334f5
@Configuration
public class RestTemplateConfig {

    private final static Long TIMEOUT = 5L ;

//    @ConditionalOnMissingBean(RestTemplate.class)
    @Bean
    public RestTemplate restTemplate() {
        //方式一：使用了jdk自带的HttpURLConnection作为底层HTTP客户端实现。
        //RestTemplate restTemplate = new RestTemplate();
        //方式二：使用HttpClient作为客户端
        ClientHttpRequestFactory clientHttpRequestFactory = getClientHttpRequestFactory();
        RestTemplate rest = new RestTemplate(clientHttpRequestFactory);
        rest.getMessageConverters().set(1, new StringHttpMessageConverter(Charset.forName("utf-8")));
        return rest;

    }

    /**
     * 使用OkHttpClient作为底层客户端
     * @return
     */
    @Bean
    public ClientHttpRequestFactory getClientHttpRequestFactory(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT , TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS)
                .build();
        return new OkHttp3ClientHttpRequestFactory(okHttpClient);
    }


    /**
     * 使用HttpClient作为底层客户端
     * @return
     */
    private ClientHttpRequestFactory getClientHttpRequestFactory2() {
        int timeout = 5000;
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(timeout)
                .setConnectionRequestTimeout(timeout)
                .setSocketTimeout(timeout)
                .build();
        CloseableHttpClient client = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }



}
