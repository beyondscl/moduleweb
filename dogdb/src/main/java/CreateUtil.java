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
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r\n");
            sb.append("import lombok.Data;\r\n");
            sb.append("@Data\r\n");
            sb.append("public class " + tableName + " { \r\n");

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
                sb.append("\r\n");
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
                    System.out.println("不识别字段类型:" + type);
                    sb.append(" private byte[] ");//long?
                    sb.append(field);//需要做处理
                }
                sb.append(";");
                sb.append("\r\n");
            }
            sb.append("}\r\n");
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
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r\n");
            sb.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
            sb.append("import javax.annotation.Resource;\n");
            sb.append("import com.bird.service." + tableName + "Service;\n");
            sb.append("@Controller\n");
            sb.append("@RequestMapping(value = \"/" + StringUtil.firstCharToLower(tableName) + "Action\")\n");
            sb.append("public class " + tableName + "Action{\r\n");

            sb.append("@Resource\n");
            sb.append("private " + tableName + "Service " + StringUtil.firstCharToLower(tableName) + "Service;\n");

            sb.append("   @RequestMapping(value = \"/test\")\n" +
                    "    public String test() {\n" +
                    "        return \"\";\n" +
                    "    }\n" +
                    "\n" +
                    "    @RequestMapping(value = \"/save\")\n" +
                    "    public String save() {\n" +
                    "        return \"\";\n" +
                    "    }\n" +
                    "\n" +
                    "    @RequestMapping(value = \"/delete\")\n" +
                    "    public String delete() {\n" +
                    "        return \"\";\n" +
                    "    }\n" +
                    "\n" +
                    "    @RequestMapping(value = \"/update\")\n" +
                    "    public String update() {\n" +
                    "        return \"\";\n" +
                    "    }\n" +
                    "\n" +
                    "    @RequestMapping(value = \"/query\")\n" +
                    "    public String query() {\n" +
                    "        return \"\";\n" +
                    "    }\n" +
                    "\n" +
                    "    @RequestMapping(value = \"/pagequery\")\n" +
                    "    public String getList() {\n" +
                    "        return \"\";\n" +
                    "    }\n");


            sb.append("}\r\n");
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
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r\n");
            sb.append("import org.springframework.stereotype.Repository;\n");
            sb.append("@Repository\r\n");
            sb.append("public interface " + tableName + "Dao extends BaseDao {\r\n");
            sb.append("}\r\n");
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
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r\n");
            sb.append("import com.bird.service.base.BaseService;\r\n");
            sb.append("import org.springframework.stereotype.Service;\r\n");
            sb.append("@Service\r\n");
            sb.append("public interface " + tableName + "Service   extends BaseService {\r\n");
            sb.append("}\r\n");
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
            sb.append("package " + path.replaceAll("/", ".").replaceFirst(".", "") + "; \r\n");
            sb.append("import com.bird.dao.BaseDao;\r\n");
            sb.append("import com.bird.dao." + tableName + "Dao;\r\n");
            sb.append("import com.bird.service.base.BaseServiceImpl;\r\n");
            sb.append("import org.springframework.stereotype.Service;\r\n");
            sb.append("import javax.annotation.Resource;\r\n");
            sb.append("@Service\r\n");
            sb.append("public class " + tableName + "ServiceImpl extends BaseServiceImpl implements " + tableName + "Service {\r\n");
            sb.append("@Resource\r\n");
            sb.append("private " + tableName + "Dao " + StringUtil.firstCharToLower(tableName) + "Dao ;\r\n");
            sb.append("@Resource\r\n");
            sb.append("public void setBaseDao(BaseDao baseDao) {\n");
            sb.append("super.setBaseDao(this." + StringUtil.firstCharToLower(tableName) + "Dao);\n");
            sb.append("}\n");
            sb.append("}\r\n");
            outputStream.write(sb.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}
