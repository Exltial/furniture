package com.exltial.furniture.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

public class SessionUtils {
    private SessionUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }

    public static Object get(String key) {
        return SessionUtils.getSession().getAttribute(key);
    }

    public static void set(String key, String value) {
        SessionUtils.getSession().setAttribute(key, value);
    }
}
