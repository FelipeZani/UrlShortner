import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;
 
public class CustomSQLiteDialect extends Dialect {
    public CustomSQLiteDialect() {
        registerColumnType(java.sql.Types.BOOLEAN, "numeric");
        registerColumnType(java.sql.Types.BIGINT, "integer");
        registerColumnType(java.sql.Types.INTEGER, "integer");
        registerColumnType(java.sql.Types.DOUBLE, "double");
        registerColumnType(java.sql.Types.FLOAT, "float");
        registerColumnType(java.sql.Types.VARCHAR, "text");
        registerColumnType(java.sql.Types.DATE, "date");
        registerColumnType(java.sql.Types.TIME, "time");
        registerColumnType(java.sql.Types.TIMESTAMP, "datetime");
 
        registerFunction("concat", new StandardSQLFunction("concat", StandardBasicTypes.STRING));
    }
 
    @Override
    public String getIdentityColumnString() {
        return "integer";
    }
 
    @Override
    public String getIdentitySelectString() {
        return "select last_insert_rowid()";
    }
}