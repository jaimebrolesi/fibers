package com.ifood.fibers.controller;

import co.paralleluniverse.fibers.Suspendable;
import co.paralleluniverse.fibers.httpclient.FiberHttpClient;
import co.paralleluniverse.fibers.httpclient.FiberHttpClientBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/httpclient")
public class HttpClientController {

    private FiberHttpClient fiberClient;
    private CloseableHttpClient apacheClient;
    private HttpGet getRequest;

    public HttpClientController() {
        fiberClient = FiberHttpClientBuilder.create(4).build();
        apacheClient = HttpClientBuilder.create().build();
        //Create another project with Thread.sleep(400ms) and send a request.
        getRequest = new HttpGet("http://localhost:8081/accounts?external_id=123");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/fiber")
    @Suspendable
    //Instrumented method using Annotation @Suspendable
    public void usingFiber() {
        try (final CloseableHttpResponse execute = fiberClient.execute(getRequest)){
            System.out.println("Fiber HTTP Client" + execute.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/nfiber")
    public void usingApache() {
        try (final CloseableHttpResponse execute = apacheClient.execute(getRequest)){
            System.out.println("Apache HTTP Client" + execute.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
