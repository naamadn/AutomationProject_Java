package Utilities;

import java.sql.DriverManager;

public class manageDB extends commonOps
{
   public static void iniConnection(String dbUrl, String user, String password)
   {
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con = DriverManager.getConnection(dbUrl, user, password);
           stmt = con.createStatement();
       }
       catch (Exception e)
       {
           System.out.println("Error Occurred while connecting to DB. see details: "+ e);
       }
   }

   public static void closeConnection()
   {
      try
      {
          con.close();
      }
      catch (Exception e)
      {
          System.out.println("Error Occurred while closing the DB. see details: "+ e);
      }
   }
}
