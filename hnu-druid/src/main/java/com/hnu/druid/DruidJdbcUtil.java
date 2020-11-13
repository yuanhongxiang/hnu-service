package com.hnu.druid;

import org.apache.calcite.avatica.AvaticaConnection;
import org.apache.calcite.avatica.AvaticaStatement;
import org.springframework.stereotype.Component;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * @description:
 * @author: YUANHX
 * @create: 7:11 下午
 **/
@Component
public class DruidJdbcUtil {

    private static ThreadLocal<AvaticaConnection> threadLocal = new ThreadLocal<>();

    private static final String DRUID_URL = "jdbc:avatica:remote:url=http://172.16.0.160:8888/druid/v2/sql/avatica/";

    /**
     * 打开连接
     * @param
     * @return
     * @throws SQLException
     */
    public static AvaticaConnection connection() throws SQLException {
        Properties properties = new Properties();
        AvaticaConnection connection = (AvaticaConnection) DriverManager.getConnection(DRUID_URL, properties);
        threadLocal.set(connection);
        return connection;
    }

    /**
     * 关闭连接
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException{
        System.out.println("关闭线程："+threadLocal.get());
        AvaticaConnection conn = threadLocal.get();
        if(conn != null){
            conn.close();
            threadLocal.remove();
        }
    }

    /**
     * 根据sql查询结果
     * @param
     * @param sql
     * @return
     * @throws SQLException
     */
    public static ResultSet executeQuery (String sql) throws SQLException{
        AvaticaStatement statement = connection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    /**
     * 通用执行方法
     * @param sql
     * @return
     * @throws SQLException
     */
    public static boolean execute(String sql) throws SQLException{
        AvaticaStatement statement = connection().createStatement();
        boolean flag = statement.execute(sql);
        return flag;
    }

    /*public static Object crud(String sql, Class clazz, List<Object> params) throws SQLException{
        AvaticaStatement statement = connection().createStatement();
        Object obj = null;
        for (int i = 0; i < params.size(); i++) {
            statement.set
        }
        return obj;
    }*/

    public static void main(String[] args) {
        try {
            String sql = "SELECT * FROM vehicleCondition limit 20";
            for (int i = 0; i < 5; i++) {
                ResultSet resultSet = executeQuery(sql);
                System.out.println("开始连接"+i + ";   连接线程："+threadLocal.get());
                while(resultSet.next()){
                    String equipmentCode = resultSet.getString("EquipmentCode");
                    String vkaCode = resultSet.getString("VKACode");
//                    System.out.println(equipmentCode + "   ;   "+ vkaCode);
                }
                closeConnection();
            }
            System.out.println("-----------       ---------------");
            boolean flag = execute(sql);

            System.out.println("-----------  execute(sql) flag:     ---------------" + flag);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
