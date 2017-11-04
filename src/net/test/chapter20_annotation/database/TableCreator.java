package net.test.chapter20_annotation.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args) throws Exception
    {
        if (args.length < 1)
        {
            System.out.println("arguments: annotated classes");
            System.exit(0);
        }

        for (String className: args)
        {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null)
            {
                System.out.println("No DBTable annotations in class " + className);
                continue;
            }

            String tableName = dbTable.name();
            if (tableName.length() < 1)
            {
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnDefs = new ArrayList<>();
            for (Field field : cl.getDeclaredFields())
            {
                String columnName = null;
                Annotation[] anns = field.getDeclaredAnnotations();
                if (anns.length < 1) continue;
                if (anns[0] instanceof SQLInteger)
                {
                    SQLInteger sqlInteger = (SQLInteger)anns[0];
                    if (sqlInteger.name().length() < 1)
                    {
                        columnName = field.getName().toUpperCase();
                    }
                    else columnName = sqlInteger.name();

                    columnDefs.add(columnName + " INT " + getConstraints(sqlInteger.constraints()));
                }

                if (anns[0] instanceof SQLString)
                {
                    SQLString sString = (SQLString)anns[0];
                    if (sString.name().length() < 1)
                        columnName = field.getName().toUpperCase();
                    else
                        columnName = sString.name();

                    columnDefs.add(columnName + " VARCHAR(" + sString.value() + ")" + getConstraints(sString.constraints()));
                }
            }

            StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + "(");
            for (String columnDef : columnDefs)
            {
                createCommand.append("\n    " + columnDef + ",");
            }
            String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ");";
            System.out.println("Table Creation SQL for " + className + " is : \n" + tableCreate);
        }
    }

    private static String getConstraints(Constraints con)
    {
        String constrains = "";
        if (!con.allowNull())
        {
            constrains += " NOT NULL";
        }

        if (con.primaryKey())
        {
            constrains += " PRIMARY KEY";
        }

        if (con.unique())
            constrains += " UNIQUE";

        return  constrains;
    }
}
