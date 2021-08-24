

import java.sql.*;

public class TableUsingJava

{

public static void main( String args[] )

{

Connection c = null;

Statement stmt = null;

try {

Class.forName("org.sqlite.JDBC");

c = DriverManager.getConnection("jdbc:sqlite:Movies.db");

System.out.println("Database Opened...\n");

stmt = c.createStatement();

String sql = "CREATE TABLE Movies " +

"( Movie TEXT NOT NULL, " +

" Actor TEXT NOT NULL, " +

" Actress TEXT NOT NULL,"+
" YOR INTEGER,"+
" Director TEXT NOT NULL) " ;

stmt.executeUpdate(sql);

stmt.close();

c.close();

}

catch ( Exception e ) {

System.err.println( e.getClass().getName() + ": " + e.getMessage() );

System.exit(0);

}

System.out.println("Table Movies Created Successfully!!!");

}

}
