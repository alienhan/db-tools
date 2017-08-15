/*
 * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 * FileName: Table.java
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
package jh.test.mybatis.db;

import java.util.List;

/**
 * 功能描述: <br>
 * 〈〉
 *
 * @author JiangHan 17020751
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Table {
	/** 表名称 */
	public String tableName;
	/** 表类型。典型的类型是 "TABLE"、"VIEW"、"SYSTEM TABLE"、"GLOBAL TEMPORARY"、"LOCAL TEMPORARY"、"ALIAS" 和 "SYNONYM" */
	public String tableType;
	/** 表的解释性注释 */
	public String remarks;
	
	public List<Column> columns;

}
