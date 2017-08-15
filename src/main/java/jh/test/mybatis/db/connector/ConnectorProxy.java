/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: MysqlConnector.java
 * Author:   jianghan
 * Date:     2017年8月15日
 * Description: 主调接口抽象实现类，定义公共方法   
 * History: 
 * <author>      <time>      <version>    <desc>
 * jianghan      2017年8月15日                  创建
 */

/**
 * 
 */
package jh.test.mybatis.db.connector;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 功能描述: <br>
 * 〈proxy of Connection〉
 *
 * @author JiangHan 17020751
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ConnectorProxy {
	private Connection conn = null;
	private DatabaseMetaData metaData = null;

	/**
	 * 
	 */
	public ConnectorProxy() {
		super();
		// conn
		String url = "jdbc:mysql://localhost:3306/test?" + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";
		try {
			Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动

			System.out.println("成功加载MySQL驱动程序");
			// 一个Connection代表一个数据库连接
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			System.out.println("MySQL操作错误");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// metaData
		try {
			metaData = conn.getMetaData();
		} catch (SQLException e) {
			System.out.println("metaData 操作错误");
			e.printStackTrace();
		}
	}

	public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String types[]) {
		try {
			return metaData.getTables(catalog, schemaPattern, tableNamePattern, types);
		} catch (SQLException e) {
			System.out.println("getTables 操作错误");
			e.printStackTrace();
		}
		return null;
	}

	public ResultSet getResultSet(String tableName) {
		return getTables(null, "%", tableName, new String[] { "TABLE" });
	}

}
