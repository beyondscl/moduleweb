import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * author: 牛虻.
 * time:2018/1/31
 * email:pettygadfly@gmail.com
 * doc:
 */
public class CreateUtil {


    /**
     * table name 字段 需要使用XXX_XXXX格式不然无法反射
     *
     * @param path       包名 /com/bird/xxxx...
     * @param tablePojos 所有字段
     * @throws SQLException
     */
    public static void createDomain(String path, ArrayList<TableField> tablePojos) {
        try {
            if (null == tablePojos || tablePojos.size() == 0) {
                throw new RuntimeException("空字段");
            }
            String tableName = tablePojos.get(0).getTableName();
            tableName = getTuoFengString(tableName);
            tableName = StringUtil.firstCharToUpper(tableName);
            String fileName = System.getProperty("user.dir") + path + "/" + tableName + ".java";
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            OutputStream outputStream = new FileOutputStream(file);//或者追加
            StringBuffer sb = new StringBuffer();
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r \n");
            sb.append("import lombok.Data;\r \n");
            sb.append("@Data\r \n");
            sb.append("public class " + tableName + " { \r \n");

            //请使用@lombok.Data注解，我这里就不设置set/get
            for (TableField tablePojo : tablePojos) {
                String field = tablePojo.getFiled();
                field = getTuoFengString(field);
                String type = tablePojo.getType();
                String isAllowNull = tablePojo.getIsAllowNull();
                String key = tablePojo.getKey();
                String defValue = tablePojo.getDefValue();
                String extra = tablePojo.getExtra();
                String comment = tablePojo.getComment();

                sb.append(" //注释: ");
                sb.append(comment);
                sb.append(" 默认值: ");
                sb.append(defValue);
                sb.append(" 是否可为空 ");
                sb.append(isAllowNull);
                sb.append("\r \n");
                //目前先支持 int char varchar
                if (type.contains("char")) {
                    sb.append(" private String ");
                    sb.append(field);//需要做处理
                } else if (type.contains("int")) {
                    sb.append(" private int ");//long?
                    sb.append(field);//需要做处理
                } else if (type.contains("float")) {
                    sb.append(" private double ");//long?
                    sb.append(field);//需要做处理
                } else if (type.contains("blob")) {
                    sb.append(" private byte[] ");//long?
                    sb.append(field);//需要做处理
                } else if (type.contains("text")) {
                    sb.append(" private String ");//long?
                    sb.append(field);//需要做处理
                }
                sb.append(";");
                sb.append("\r \n");
            }
            sb.append("}\r \n");
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * ***——**——** 转为驼峰
     *
     * @param field
     * @return
     */
    private static String getTuoFengString(String field) {
        field = field.toLowerCase();
        String[] fieldsub = field.split("_");
        String str = "";
        for (String s : fieldsub) {
            str += StringUtil.firstCharToUpper(s);
        }
        return StringUtil.firstCharToLower(str);
    }


    public static void createController(String path, ArrayList<TableField> tablePojos) throws SQLException {
        try {
            if (null == tablePojos || tablePojos.size() == 0) {
                throw new RuntimeException("空字段");
            }
            String tableName = tablePojos.get(0).getTableName();
            tableName = getTuoFengString(tableName);
            tableName = StringUtil.firstCharToUpper(tableName);
            String fileName = System.getProperty("user.dir") + path + "/" + tableName + "Action.java";
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            OutputStream outputStream = new FileOutputStream(file);//或者追加
            StringBuffer sb = new StringBuffer();
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r \n");
            sb.append("import org.springframework.web.bind.annotation.RequestMapping; \n");
            sb.append("import javax.annotation.Resource; \n");
            sb.append("import com.bird.service." + tableName + "Service; \n");
            sb.append("@Controller \n");
            sb.append("@RequestMapping(value = \"/" + StringUtil.firstCharToLower(tableName) + "Action\") \n");
            sb.append("public class " + tableName + "Action{\r \n");

            sb.append("@Resource \n");
            sb.append("private " + tableName + "Service " + StringUtil.firstCharToLower(tableName) + "Service; \n");

            sb.append("   @RequestMapping(value = \"/test\") \n" +
                    "    public String test() { \n" +
                    "        return \"\"; \n" +
                    "    } \n" +
                    " \n" +
                    "    @RequestMapping(value = \"/save\") \n" +
                    "    public String save() { \n" +
                    "        return \"\"; \n" +
                    "    } \n" +
                    " \n" +
                    "    @RequestMapping(value = \"/delete\") \n" +
                    "    public String delete() { \n" +
                    "        return \"\"; \n" +
                    "    } \n" +
                    " \n" +
                    "    @RequestMapping(value = \"/update\") \n" +
                    "    public String update() { \n" +
                    "        return \"\"; \n" +
                    "    } \n" +
                    " \n" +
                    "    @RequestMapping(value = \"/query\") \n" +
                    "    public String query() { \n" +
                    "        return \"\"; \n" +
                    "    } \n" +
                    " \n" +
                    "    @RequestMapping(value = \"/pagequery\") \n" +
                    "    public String getList() { \n" +
                    "        return \"\"; \n" +
                    "    } \n");


            sb.append("}\r \n");
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }


    public static void createDao(String path, ArrayList<TableField> tablePojos) throws SQLException {
        try {
            if (null == tablePojos || tablePojos.size() == 0) {
                throw new RuntimeException("空字段");
            }
            String tableName = tablePojos.get(0).getTableName();
            tableName = getTuoFengString(tableName);
            tableName = StringUtil.firstCharToUpper(tableName);
            String fileName = System.getProperty("user.dir") + path + "/" + tableName + "Dao.java";
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            OutputStream outputStream = new FileOutputStream(file);//或者追加
            StringBuffer sb = new StringBuffer();
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r \n");
            sb.append("import org.springframework.stereotype.Repository; \n");
            sb.append("@Repository\r \n");
            sb.append("public interface " + tableName + "Dao extends BaseDao {\r \n");
            sb.append("}\r \n");
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void createService(String path, ArrayList<TableField> tablePojos) throws SQLException {
        try {
            if (null == tablePojos || tablePojos.size() == 0) {
                throw new RuntimeException("空字段");
            }
            String tableName = tablePojos.get(0).getTableName();
            tableName = getTuoFengString(tableName);
            tableName = StringUtil.firstCharToUpper(tableName);
            String fileName = System.getProperty("user.dir") + path + "/" + tableName + "Service.java";
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            OutputStream outputStream = new FileOutputStream(file);//或者追加
            StringBuffer sb = new StringBuffer();
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r \n");
            sb.append("import com.bird.service.base.BaseService;\r \n");
            sb.append("import org.springframework.stereotype.Service;\r \n");
            sb.append("@Service\r \n");
            sb.append("public interface " + tableName + "Service   extends BaseService {\r \n");
            sb.append("}\r \n");
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            outputStream.close();
            createServiceImpl(path, tablePojos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void createServiceImpl(String path, ArrayList<TableField> tablePojos) throws SQLException {
        try {
            if (null == tablePojos || tablePojos.size() == 0) {
                throw new RuntimeException("空字段");
            }
            String tableName = tablePojos.get(0).getTableName();
            tableName = getTuoFengString(tableName);
            tableName = StringUtil.firstCharToUpper(tableName);
            String fileName = System.getProperty("user.dir") + path + "/" + tableName + "ServiceImpl.java";
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            OutputStream outputStream = new FileOutputStream(file);//或者追加
            StringBuffer sb = new StringBuffer();
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r \n");
            sb.append("import com.bird.dao.BaseDao;\r \n");
            sb.append("import com.bird.dao." + tableName + "Dao;\r \n");
            sb.append("import com.bird.service.base.BaseServiceImpl;\r \n");
            sb.append("import org.springframework.stereotype.Service;\r \n");
            sb.append("import javax.annotation.Resource;\r \n");
            sb.append("@Service\r \n");
            sb.append("public class " + tableName + "ServiceImpl extends BaseServiceImpl implements " + tableName + "Service {\r \n");
            sb.append("@Resource\r \n");
            sb.append("private " + tableName + "Dao " + StringUtil.firstCharToLower(tableName) + "Dao ;\r \n");
            sb.append("@Resource\r \n");
            sb.append("public void setBaseDao(BaseDao baseDao) { \n");
            sb.append("super.setBaseDao(this." + StringUtil.firstCharToLower(tableName) + "Dao); \n");
            sb.append("} \n");
            sb.append("}\r \n");
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 创建*Dao.xml
     *
     * @param tablePojos
     */
    public static void createXml(String path, ArrayList<TableField> tablePojos) {
        try {
            if (null == tablePojos || tablePojos.size() == 0) {
                throw new RuntimeException("空字段");
            }
            String tableName = tablePojos.get(0).getTableName();
            String realTableName = tablePojos.get(0).getTableName();
            tableName = getTuoFengString(tableName);
            tableName = StringUtil.firstCharToUpper(tableName);
            String fileName = System.getProperty("user.dir") + path + "/" + tableName + "Dao.xml";
            File file = new File(fileName);
            if (file.exists()) {
                file.delete();
            }
            OutputStream outputStream = new FileOutputStream(file);//或者追加
            StringBuffer sb = new StringBuffer();
            sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n" +
                    "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.4//EN\" \n" +
                    "        \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
            sb.append("<mapper namespace=\"com.bird.dao." + tableName + "Dao\"> \n");

            //map转对象因为 字段名称是带下划线的
            sb.append("<resultMap id=\"mapToObject\" type=\"com.bird.domain." + tableName + "\">");
            sb.append(getClounProper(tablePojos));
            sb.append("\n");
            sb.append("</resultMap>");

            sb.append("<insert id=\"saveObject\" parameterType=\"com.bird.domain." + tableName + "\"> \n");
            sb.append("INSERT into " + realTableName.toLowerCase() + " \n");
            sb.append("( \n");
            sb.append(getCloumnNames(tablePojos));
            sb.append(") \n");
            sb.append("values \n");
            sb.append("( \n");
            sb.append(getObjCloumnNames(tablePojos));
            sb.append(") \n");
            sb.append("</insert> \n");

            sb.append("<update id=\"updateObject\" parameterType=\"com.bird.domain." + tableName + "\"> \n");
            sb.append("update " + realTableName.toLowerCase() + "  set \n");
            sb.append(updateloumnNames(tablePojos));
            sb.append(" \n");
            sb.append("where id = #{id} \n");
            sb.append("</update> \n");

            sb.append("<delete id=\"deleteById\" parameterType=\"java.lang.String\"> \n");
            sb.append("delete from " + realTableName.toLowerCase() + " \n");
            sb.append(" where id =#{id}\n");
            sb.append("</delete> \n");

            sb.append("<delete id=\"deleteByIds\"> \n");
            sb.append("delete from " + realTableName.toLowerCase() + " \n");
            sb.append(" where id IN\n" +
                    " <foreach collection=\"array\" item=\"id\" index=\"index\"\n" +
                    "          open=\"(\" close=\")\" separator=\",\">\n" +
                    "     #{id}\n" +
                    " </foreach>\n");
            sb.append("</delete> \n");

            sb.append("<select id=\"findById\"  parameterType=\"java.lang.String\" resultMap=\"mapToObject\" >\n");
            sb.append("select \n");
            sb.append(getCloumnNames(tablePojos));
            sb.append(" \n");
            sb.append("from " + realTableName.toLowerCase() + " \n");
            sb.append(" where id =#{id}\n");
            sb.append("</select> \n");

            sb.append("<select id=\"findByIds\" resultMap=\"mapToObject\" >\n");
            sb.append("select \n");
            sb.append(getCloumnNames(tablePojos));
            sb.append(" \n");
            sb.append("from " + realTableName.toLowerCase() + " \n");
            sb.append(" where id IN\n" +
                    " <foreach collection=\"array\" item=\"id\" index=\"index\"\n" +
                    "          open=\"(\" close=\")\" separator=\",\">\n" +
                    "     #{id}\n" +
                    " </foreach>\n");
            sb.append("</select> \n");

            sb.append("<select id=\"findByObject\" parameterType=\"com.bird.domain." + tableName + "\" resultMap=\"mapToObject\" >\n");
            sb.append("select \n");
            sb.append(getCloumnNames(tablePojos));
            sb.append(" \n");
            sb.append("from " + realTableName.toLowerCase() + " \n");
            sb.append("where 1=1 \n");
            sb.append(queryloumnNames(tablePojos));
            sb.append(" \n");
            sb.append("</select> \n");

            sb.append("<select id=\"findByPage\" parameterType=\"com.bird.domain." + tableName + "\" resultMap=\"mapToObject\" >\n");
            sb.append("select \n");
            sb.append(getCloumnNames(tablePojos));
            sb.append(" \n");
            sb.append("from " + realTableName.toLowerCase() + " \n");
            sb.append("where 1=1 \n");
            sb.append(queryloumnNames(tablePojos));
            sb.append(" \n");
            sb.append(" limit ${startRow}, ${endRow} \n");
            sb.append("</select> \n");


            sb.append("</mapper> \n");
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    /**
     * 插入的时候， id,name ,age ....
     *
     * @return
     */
    private static StringBuffer getCloumnNames(ArrayList<TableField> tablePojos) {
        StringBuffer sb = new StringBuffer(" ");
        for (int i = 0; i < tablePojos.size(); i++) {
            sb.append(tablePojos.get(i).getFiled());

            if (i != tablePojos.size() - 1)
                sb.append(", ");
            if (i % 4 == 0 && i != 0)
                sb.append(" \n");
        }
        return sb;
    }

    /**
     * 插入的时候， id,name ,age ....值
     *
     * @return
     */
    private static StringBuffer getObjCloumnNames(ArrayList<TableField> tablePojos) {
        StringBuffer sb = new StringBuffer(" ");
        for (int i = 0; i < tablePojos.size(); i++) {
            sb.append("#{");
            sb.append(getTuoFengString(tablePojos.get(i).getFiled()));
            sb.append("}");
            if (i != tablePojos.size() - 1)
                sb.append(", ");
            if (i % 4 == 0 && i != 0)
                sb.append(" \n");
        }
        return sb;
    }

    /**
     * 更新的时候
     *
     * @param tablePojos
     * @return
     */
    private static StringBuffer updateloumnNames(ArrayList<TableField> tablePojos) {
        StringBuffer sb = new StringBuffer(" ");
        for (int i = 0; i < tablePojos.size(); i++) {
            sb.append("<if test='null != " + getTuoFengString(tablePojos.get(i).getFiled()) + "'>\n");
            sb.append(tablePojos.get(i).getFiled());
            sb.append(" = ");
            sb.append("#{ ");
            sb.append(getTuoFengString(tablePojos.get(i).getFiled()));
            sb.append("} ");
            if (i != tablePojos.size() - 1)
                sb.append(", ");
            if (i % 3 == 0 && i != 0)
                sb.append(" \n");
            sb.append("\n</if>\n");
        }
        return sb;
    }

    /**
     * 查询：
     * 判断空条件
     *
     * @param tablePojos
     * @return
     */
    private static StringBuffer queryloumnNames(ArrayList<TableField> tablePojos) {
        StringBuffer sb = new StringBuffer(" ");
        for (int i = 0; i < tablePojos.size(); i++) {
            sb.append("<if test='null != " + getTuoFengString(tablePojos.get(i).getFiled()) + "'>\n");
            sb.append("and ");
            sb.append(tablePojos.get(i).getFiled());
            sb.append(" = ");
            sb.append("#{");
            sb.append(getTuoFengString(tablePojos.get(i).getFiled()));
            sb.append("}");
            sb.append("\n</if>\n");
        }
        return sb;
    }

    /**
     * map转对象
     *
     * @param tablePojos
     * @return
     */
    private static StringBuffer getClounProper(ArrayList<TableField> tablePojos) {
        StringBuffer sb = new StringBuffer(" ");
        for (int i = 0; i < tablePojos.size(); i++) {
            String field = tablePojos.get(i).getFiled();
            sb.append("<result column=\"" + field + "\" property=\"" + getTuoFengString(field) + "\"/>");
            sb.append("\n");
        }
        return sb;
    }

}
