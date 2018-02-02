import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * author: 牛虻.
 * time:2018/1/31
 * email:pettygadfly@gmail.com
 * doc:
 * 封装一个字段的信息
 */
@lombok.Data
public class TableField {
    private String tableName;
    private String filed;
    private String type;
    private String isAllowNull;
    private String key;
    private String defValue;
    private String extra;
    private String comment;

    public TableField(ResultSet rs, String tableName) throws SQLException {
        String filed = rs.getString("FIELD");
        String type = rs.getString("TYPE");
        String isAllowNull = rs.getString("NULL");
        String key = rs.getString("KEY");
        String defValue = rs.getString("DEFAULT");
        String extra = rs.getString("EXTRA");
        String comment = rs.getString("COMMENT");
        this.filed = filed;
        this.type = type;
        this.isAllowNull = isAllowNull;
        this.key = key;
        this.defValue = defValue;
        this.extra = extra;
        this.comment = comment;
        this.tableName = tableName;
    }
}
