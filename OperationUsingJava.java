

import java.util.Scanner;

import java.sql.*;

public class OperationUsingJava

{

public static void main( String args[] )

{

String flag="Y";

do{

System.out.println("Select DML Operation For Movies Table...");

System.out.println("1. Insert");

System.out.println("2. Select");


System.out.println("3. Exit");

Scanner reader = new Scanner(System.in);

System.out.println("Enter a choice: ");

int n = reader.nextInt();

Connection c = null;

Statement stmt = null;

try {

Class.forName("org.sqlite.JDBC");

c = DriverManager.getConnection("jdbc:sqlite:Movies.db");

c.setAutoCommit(false);

stmt = c.createStatement();

String name="",sql="";
String actor="";
String actress="";
int YOR;
String director="";



Scanner scanName;

switch(n){

 

case 1:

scanName=new Scanner(System.in);

System.out.println("Enter Movie Name:");

name=scanName.nextLine();

System.out.println("Enter Actor Name:");

actor=scanName.nextLine();

System.out.println("Enter Actress Name:");

actress=scanName.nextLine();

System.out.println("Enter Year of release:");

YOR=scanName.nextInt();

System.out.println("Enter Director Name:");

director=scanName.nextLine();


sql = "INSERT INTO Movies (Movie,Actor,Actress,YOR,Director) " +

"VALUES ('" +name+ "','" +

actor + "','" + actress + "',"+YOR+",'"+director+"')";

stmt.executeUpdate(sql);

System.out.println("Inserted Successfully!!!");

break;

case 2:

ResultSet rs = stmt.executeQuery("SELECT * FROM Movies;");

System.out.println("Name\t Actor\t Actress\t Yr\t Dir ");

while ( rs.next() ) {

name = rs.getString("Movie");
actor = rs.getString("Actor");
actress = rs.getString("Actress");

YOR = rs.getInt("YOR");
director = rs.getString("Director");



System.out.println(name+" \t "+actor+"\t "+actress+"\t "+YOR+"\t "+director);

}

rs.close();

break;




case 3:

System.exit(0);

break;

 

default:

System.out.println("Oops!!! Wrong Choice...");

break;

}

stmt.close();

c.commit();

c.close();

}

catch ( Exception e )

{

System.err.println( e.getClass().getName() + ": " + e.getMessage() );

System.exit(0);

}

 

System.out.println("Continue Y OR N?");

reader=new Scanner(System.in);

flag=reader.nextLine();

 

}while(flag.equalsIgnoreCase("Y"));

System.exit(0);

}

}
