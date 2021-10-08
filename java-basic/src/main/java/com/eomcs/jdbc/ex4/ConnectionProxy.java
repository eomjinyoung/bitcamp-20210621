// 실제 커넥션 객체를 대행하는 역할을 수행한다.
package com.eomcs.jdbc.ex4;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

// proxy를 만든 이유?
// => close()를 호출할 때 DB 연결을 끊는 대신,
//    DataSource에 커넥션을 반납하기 위해!
public class ConnectionProxy implements Connection {
  DataSource dataSource;
  Connection con;

  public ConnectionProxy(DataSource dataSource, Connection con) {
    this.dataSource = dataSource;
    this.con = con;
  }

  public <T> T unwrap(Class<T> iface) throws SQLException {
    return con.unwrap(iface);
  }

  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return con.isWrapperFor(iface);
  }

  public Statement createStatement() throws SQLException {
    return con.createStatement();
  }

  public PreparedStatement prepareStatement(String sql) throws SQLException {
    return con.prepareStatement(sql);
  }

  public CallableStatement prepareCall(String sql) throws SQLException {
    return con.prepareCall(sql);
  }

  public String nativeSQL(String sql) throws SQLException {
    return con.nativeSQL(sql);
  }

  public void setAutoCommit(boolean autoCommit) throws SQLException {
    con.setAutoCommit(autoCommit);
  }

  public boolean getAutoCommit() throws SQLException {
    return con.getAutoCommit();
  }

  public void commit() throws SQLException {
    con.commit();
  }

  public void rollback() throws SQLException {
    con.rollback();
  }

  public void close() throws SQLException {
    dataSource.returnConnection(this);
  }

  public boolean isClosed() throws SQLException {
    return con.isClosed();
  }

  public DatabaseMetaData getMetaData() throws SQLException {
    return con.getMetaData();
  }

  public void setReadOnly(boolean readOnly) throws SQLException {
    con.setReadOnly(readOnly);
  }

  public boolean isReadOnly() throws SQLException {
    return con.isReadOnly();
  }

  public void setCatalog(String catalog) throws SQLException {
    con.setCatalog(catalog);
  }

  public String getCatalog() throws SQLException {
    return con.getCatalog();
  }

  public void setTransactionIsolation(int level) throws SQLException {
    con.setTransactionIsolation(level);
  }

  public int getTransactionIsolation() throws SQLException {
    return con.getTransactionIsolation();
  }

  public SQLWarning getWarnings() throws SQLException {
    return con.getWarnings();
  }

  public void clearWarnings() throws SQLException {
    con.clearWarnings();
  }

  public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
    return con.createStatement(resultSetType, resultSetConcurrency);
  }

  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    return con.prepareStatement(sql, resultSetType, resultSetConcurrency);
  }

  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
    return con.prepareCall(sql, resultSetType, resultSetConcurrency);
  }

  public Map<String, Class<?>> getTypeMap() throws SQLException {
    return con.getTypeMap();
  }

  public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
    con.setTypeMap(map);
  }

  public void setHoldability(int holdability) throws SQLException {
    con.setHoldability(holdability);
  }

  public int getHoldability() throws SQLException {
    return con.getHoldability();
  }

  public Savepoint setSavepoint() throws SQLException {
    return con.setSavepoint();
  }

  public Savepoint setSavepoint(String name) throws SQLException {
    return con.setSavepoint(name);
  }

  public void rollback(Savepoint savepoint) throws SQLException {
    con.rollback(savepoint);
  }

  public void releaseSavepoint(Savepoint savepoint) throws SQLException {
    con.releaseSavepoint(savepoint);
  }

  public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    return con.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    return con.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency,
      int resultSetHoldability) throws SQLException {
    return con.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
  }

  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
    return con.prepareStatement(sql, autoGeneratedKeys);
  }

  public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
    return con.prepareStatement(sql, columnIndexes);
  }

  public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
    return con.prepareStatement(sql, columnNames);
  }

  public Clob createClob() throws SQLException {
    return con.createClob();
  }

  public Blob createBlob() throws SQLException {
    return con.createBlob();
  }

  public NClob createNClob() throws SQLException {
    return con.createNClob();
  }

  public SQLXML createSQLXML() throws SQLException {
    return con.createSQLXML();
  }

  public boolean isValid(int timeout) throws SQLException {
    return con.isValid(timeout);
  }

  public void setClientInfo(String name, String value) throws SQLClientInfoException {
    con.setClientInfo(name, value);
  }

  public void setClientInfo(Properties properties) throws SQLClientInfoException {
    con.setClientInfo(properties);
  }

  public String getClientInfo(String name) throws SQLException {
    return con.getClientInfo(name);
  }

  public Properties getClientInfo() throws SQLException {
    return con.getClientInfo();
  }

  public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
    return con.createArrayOf(typeName, elements);
  }

  public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
    return con.createStruct(typeName, attributes);
  }

  public void setSchema(String schema) throws SQLException {
    con.setSchema(schema);
  }

  public String getSchema() throws SQLException {
    return con.getSchema();
  }

  public void abort(Executor executor) throws SQLException {
    con.abort(executor);
  }

  public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
    con.setNetworkTimeout(executor, milliseconds);
  }

  public int getNetworkTimeout() throws SQLException {
    return con.getNetworkTimeout();
  }


}










