/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: JDBCProxy.java
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

import java.sql.ResultSet;

import jh.test.mybatis.db.Table;

/**
 * 功能描述: <br>
 * 〈〉
 *
 * @author JiangHan 17020751
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TableBuilder {
	public Table table;

	ResultSet tableRet;

	/**
	 * 
	 */
	public TableBuilder(Table table) {
		this.table = table;
		this.tableRet = new ConnectorProxy().getResultSet(table.tableName);
		setTable();
		setColumns();
	}

	public TableBuilder(String tableName) {
		this.table = new Table();
		this.tableRet = new ConnectorProxy().getResultSet(tableName);
		setTable();
		setColumns();
	}

	public void setTable() {
		try {
			tableRet.next();
			table.tableName = tableRet.getString("TABLE_NAME");
			table.remarks = tableRet.getString("REMARKS");
			table.tableType = tableRet.getString("TABLE_TYPE");
		} catch (Exception e) {
			System.out.println("注入Table 失败");
			e.printStackTrace();
		}
	}

	public void setColumns() {

	}

	public static void main(String[] args) throws Exception {
		// new TableBuilder(new Table().tableName);
	}
}
