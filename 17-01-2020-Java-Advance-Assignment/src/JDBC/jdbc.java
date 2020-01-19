import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public interface jdbc {
  public static void main(String args[]) {
	  try{  
		  Class.forName("com.mysql.jdbc.Driver");  
		  Connection con=DriverManager.getConnection(  
		  "jdbc:mysql://localhost:3306/demo","root","root");
		  Statement stmt=con.createStatement();  
		  System.out.println("Order table");
		  ResultSet rs=stmt.executeQuery("select * from orders"); 
		  while(rs.next())  
			  System.out.println("order ID :"+rs.getInt(1)+"\n"+"customer ID :"+rs.getString(2)+" \n"+"order date :"+rs.getString(3)+"\n"); 
		  System.out.println("<-------------------------------->");
		  System.out.println("Customer table");
		  rs=stmt.executeQuery("select * from customers"); 
		  while(rs.next())  
			  System.out.println("customer ID :"+rs.getInt(1)+" \n"+"Custoner name :"+rs.getString(2)+"\n"+"Contant name :"+rs.getString(3)+"\n"+"Country :"+rs.getString(4)+"\n");  
			  
//		  String createProcedure ="DELIMITER // \n"+"CREATE PROCEDURE ep() \n"+"BEGIN \n"+"SELECT * FROM orders INNER JOIN customers on orders.CustomerID=customers.CustomerID;\n"+"END//";
//		  	stmt = con.createStatement();
//            stmt.executeUpdate(createProcedure);
		  CallableStatement cs = con.prepareCall("{call ep()}");
		  rs = cs.executeQuery();
		 
		  System.out.println("After the inner join the tables");
		  System.out.println();
		  while(rs.next()) {
			  System.out.println("order ID :"+rs.getInt(1)+" \n"+"customer ID :"+rs.getString(2)+"\n"+"order date :"+rs.getString(3)+"\n"+"Custoner name :"+rs.getString(5)+"\n"+"Contant name :"+rs.getString(6)+"\n"+"Country :"+rs.getString(7)+"\n");  
			  
		  }
		  con.close();  
		  }
	  catch(Exception e){ System.out.println(e);}
	  
  }
}
