package com.hnu.druid;

import org.apache.calcite.avatica.AvaticaConnection;
import org.apache.calcite.avatica.AvaticaStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @description:
 * @author: YUANHX
 * @create: 7:11 下午
 **/
public class DruidJdbcUtil {

    private static ThreadLocal<AvaticaConnection> threadLocal = new ThreadLocal<>();

    public static AvaticaConnection connection(String url) throws SQLException {
        Properties properties = new Properties();
        AvaticaConnection connection = (AvaticaConnection) DriverManager.getConnection(url, properties);
        threadLocal.set(connection);
        return connection;
    }

    public static void closeConnection() throws SQLException{
        System.out.println("关闭线程："+threadLocal.get());
        AvaticaConnection conn = threadLocal.get();
        if(conn != null){
            conn.close();
            threadLocal.remove();
        }
    }

    public static void querySql (AvaticaConnection connection, String sql) throws SQLException{
        AvaticaStatement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            String equipmentCode = resultSet.getString("EquipmentCode");
            String vkaCode = resultSet.getString("VKACode");
//            System.out.println(equipmentCode + "   ;   "+ vkaCode);
        }
    }

    public static void main(String[] args) {
        try {
            String url = "jdbc:avatica:remote:url=http://172.16.0.160:8888/druid/v2/sql/avatica/";
            String sql = "SELECT * FROM \"vehicleCondition\" limit 20";
            for (int i = 0; i < 5; i++) {
                System.out.println("开始连接"+i);
                AvaticaConnection connection = connection(url);
                System.out.println("连接线程："+threadLocal.get());
                querySql(connection, sql);
                closeConnection();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
