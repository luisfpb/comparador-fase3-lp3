package com.mackenzie.ep.comparador.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AbstractController implements Controller {
    private HttpServletRequest request;
    protected String returnPage;
    public void init(HttpServletRequest request) {
        this.setRequest(request);
    }
    public void setReturnPage(String page) {
        returnPage = page;
    }
    public String getReturnPage() {
        return returnPage;
    }
    public HttpServletRequest getRequest() {
        return request;
    }
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
    
}
