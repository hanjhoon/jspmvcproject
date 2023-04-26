package com.playdata.util;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface DBUtil{
    Connection getConnection(ServletContext servletContext);

}
