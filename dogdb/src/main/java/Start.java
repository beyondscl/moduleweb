import org.junit.Test;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: 牛虻.
 * time:2018/1/31
 * email:pettygadfly@gmail.com
 * doc:
 * 修改GET_TABLES字段中的数据库名称
 * 修改DbUtil中的数据库连接信息
 * 生成所有相关信息
 * 请手动选择需要的代码
 */
public class Start {

    //查看库中所有表
    private static String GET_TABLES = "select table_name from information_schema.tables  where table_schema= 'world' ";
    //查看表信息
    private static String SHOW_TABLE_INFO = "desc ";
    //过滤表

    /**
     *
     */
    public static List<String> getTables() throws SQLException {
        Connection connection = DbUtil.getConnection();
        PreparedStatement statement = connection.prepareStatement(GET_TABLES);
        ResultSet rs = statement.executeQuery();
        List<String> tables = new ArrayList<String>();
        while (rs.next()) {
            tables.add(rs.getString(1));
        }
        DbUtil.closeConn(connection, statement, rs);
        return tables;
    }

    public static ArrayList getTableInfos() throws SQLException {
        ArrayList<String> exeTables = new ArrayList<String>();
        Connection connection = DbUtil.getConnection();
        List<String> tableNames = getTables();
        PreparedStatement statement = null;
        ResultSet rs = null;
        ArrayList listAll = new ArrayList();
        for (String tableName : tableNames) {
            if (exeTables.contains(tableName)) {
                continue;
            }
            statement = connection.prepareStatement(SHOW_TABLE_INFO + tableName);
            rs = statement.executeQuery();
            ArrayList<TableField> list = new ArrayList<TableField>();
            while (rs.next()) {
                rs.getMetaData();
                TableField tablePojo = new TableField(rs, tableName);
                list.add(tablePojo);
            }
            listAll.add(list);

        }
        DbUtil.closeConn(connection, statement, rs);
        return listAll;
    }

    @Test
    public void genaratorJava() throws SQLException {
        ArrayList arrayList = getTableInfos();
        String fileRoot = System.getProperty("user.dir");
        String packageRoot = "/com/bird/";
        String[] pNames = {"control", "dao", "domain", "service"};//mapping jsp 没写
        for (int i = 0; i < arrayList.size(); i++) {
            ArrayList<TableField> tablePojos = (ArrayList<TableField>) arrayList.get(i);
            for (String dirName : pNames) {
                String filePath = fileRoot + packageRoot + dirName;
                File file = new File(filePath);
                file.delete();
                file.mkdirs();
                if (dirName.equals("control"))
                    CreateUtil.createController(packageRoot + dirName, tablePojos);
                if (dirName.equals("dao"))
                    CreateUtil.createDao(packageRoot + dirName, tablePojos);
                if (dirName.equals("domain"))
                    CreateUtil.createDomain(packageRoot + dirName, tablePojos);
                if (dirName.equals("service"))
                    CreateUtil.createService(packageRoot + dirName, tablePojos);
            }
        }
    }
}
