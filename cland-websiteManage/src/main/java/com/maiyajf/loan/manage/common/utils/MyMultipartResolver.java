/**
 * 
 */
package com.maiyajf.loan.manage.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;
 
public class MyMultipartResolver extends CommonsMultipartResolver {
 
    @Override
    public boolean isMultipart(HttpServletRequest request) {
        return super.isMultipart(request);
    }
 
}