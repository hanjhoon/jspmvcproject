package com.playdata.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public class jdbcSercletContextDBUtil  implements DBUtil{
    @Override
    public Connection getConnection(ServletContext servletContext) {
        return (Connection)  servletContext.getAttribute("conn");
    }
}
