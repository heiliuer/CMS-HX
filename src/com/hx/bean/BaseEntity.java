package com.hx.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseEntity {

	public abstract String getCreateSql();

	public abstract BaseEntity setFromResultSet(ResultSet rs) throws SQLException;
}