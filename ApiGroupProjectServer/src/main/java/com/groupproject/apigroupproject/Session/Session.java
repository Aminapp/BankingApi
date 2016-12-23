package com.groupproject.apigroupproject.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session {
    public void doGet(HttpServletRequest request, HttpServletResponse response, String username) {
        HttpSession session = request.getSession();
        session.setAttribute("UserName", username);
    }
}