package org.drools.servlet;

import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("Init");
    }

}
