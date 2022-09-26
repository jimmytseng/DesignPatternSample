package CreationalPattern.FactoryMethodPattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FactoryMethodPattern {

	public static void main(String args[]) {
		GenSQLToolFactory genSQLToolFactory = new GenSQLToolFactoryImpl();
		GenSqlDTO genSqlDTO = new GenSqlDTO();
		genSqlDTO.setTableName("PERSONS");
		ArrayList<String> columnList = new ArrayList();
		columnList.add("account");
		columnList.add("psw");
		genSqlDTO.setColumnName(columnList);
		GenSQLTool gen = genSQLToolFactory.getGenSQLTool(GenSQLTool.HIBERNATE_GEN, genSqlDTO);
		System.out.print(gen.genSelect());
	}
}

interface GenSQLToolFactory {
	public GenSQLTool getGenSQLTool(String genType, GenSqlDTO dto);
}

class GenSQLToolFactoryImpl implements GenSQLToolFactory {

	@Override
	public GenSQLTool getGenSQLTool(String genType, GenSqlDTO dto) {
		GenSQLTool genSQL = null;
		switch (genType) {
		case "NATIVE":
			genSQL = new NativeGenSQL(dto);
			break;
		case "HIBERNATE":
			genSQL = new HibernateGenSQL(dto);
			break;
		}
		return genSQL;
	}

}

abstract class GenSQLTool {

	protected GenSqlDTO genSqlDTO;
	public static String NATIVE_GEN = "NATIVE";
	public static String HIBERNATE_GEN = "HIBERNATE";

	public GenSQLTool(GenSqlDTO genSqlDTO) {
		this.genSqlDTO = genSqlDTO;
	}

	public String genSelect() {
		List<String> columnNames = this.genSqlDTO.getColumnName();
		StringBuilder builder = new StringBuilder();
		builder.append(" select ");
		if (columnNames.size() == 0) {

		} else {
			for (int i = 0; i < columnNames.size(); i++) {
				String column = columnNames.get(i);
				builder = concateColumn(column, builder);
				if (i != columnNames.size() - 1) {
					builder.append(" , ");
				}
			}
		}
		builder.append(" from ");

		builder = concateTable(builder);
		return builder.toString();
	}

	abstract public StringBuilder concateTable(StringBuilder builder);

	abstract public StringBuilder concateColumn(String column, StringBuilder builder);

}

class NativeGenSQL extends GenSQLTool {

	public NativeGenSQL(GenSqlDTO genSqlDTO) {
		super(genSqlDTO);
	}

	@Override
	public StringBuilder concateTable(StringBuilder builder) {
		builder.append(" " + genSqlDTO.getTableName() + " ");
		return builder;
	}

	@Override
	public StringBuilder concateColumn(String column, StringBuilder builder) {
		builder.append(" " + column + " ");
		return builder;
	}

}

class HibernateGenSQL extends GenSQLTool {

	public HibernateGenSQL(GenSqlDTO genSqlDTO) {
		super(genSqlDTO);
	}

	@Override
	public StringBuilder concateTable(StringBuilder builder) {
		String alias = this.genSqlDTO.getTableName().toLowerCase();
		builder.append(" " + genSqlDTO.getTableName() + " as " + alias);
		return builder;
	}

	@Override
	public StringBuilder concateColumn(String column, StringBuilder builder) {
		String alias = this.genSqlDTO.getTableName().toLowerCase();
		builder.append(" " + alias + "." + column + " ");
		return builder;
	}

}

class GenSqlDTO {
	public static final String DML_SELECT = "select";
	public static final String DML_INSERT = "insert";
	public static final String DML_UPDATE = "update";
	public static final String DML_DELETE = "delete";
	public static Map<Integer, String> letterMap;
	static {
		letterMap = new HashMap<>();
		letterMap.put(1, "none");
		letterMap.put(2, "lower-case");
		letterMap.put(3, "upper-case");
	}
	private String sqlType;
	private String tableName;
	private List<String> columnName;
	private String dmlType;
	private boolean withSchema;
	private String whereCondition;
	private Integer isUpperCase = 1;
	private String sqlResult;

	public String getSqlType() {
		return sqlType;
	}

	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getColumnName() {
		return columnName;
	}

	public void setColumnName(List<String> columnName) {
		this.columnName = columnName;
	}

	public String getDmlType() {
		return dmlType;
	}

	public void setDmlType(String dmlType) {
		this.dmlType = dmlType;
	}

	public boolean isWithSchema() {
		return withSchema;
	}

	public void setWithSchema(boolean withSchema) {
		this.withSchema = withSchema;
	}

	public String getWhereCondition() {
		return whereCondition;
	}

	public void setWhereCondition(String whereCondition) {
		this.whereCondition = whereCondition;
	}

	public Integer getIsUpperCase() {
		return isUpperCase;
	}

	public void setIsUpperCase(Integer isUpperCase) {
		this.isUpperCase = isUpperCase;
	}

	public String getSqlResult() {
		return sqlResult;
	}

	public void setSqlResult(String sqlResult) {
		this.sqlResult = sqlResult;
	}

}