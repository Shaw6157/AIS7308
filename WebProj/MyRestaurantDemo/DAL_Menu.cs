using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace MyRestaurantDemo
{
    public class DAL_Menu
    {
        SqlConnection sqlConn;
        string connStr = ConfigurationManager.ConnectionStrings["connDB"].ConnectionString;

        public void registerUser(string userID, string name, string password, string country, string emailAddress)
        {
            sqlConn = new SqlConnection(connStr);
            sqlConn.Open();

            string query_save = "insert into tblUsers values ('"
                + userID + "', '"
                + name + "', '"
                + password + "', '"
                + country + "', '"
                + emailAddress + "')";

            SqlCommand sqlCmd = new SqlCommand(query_save, sqlConn);
            sqlCmd.ExecuteNonQuery();
            sqlConn.Close();
        }

        public Boolean loginUser(string userID, string password)
        {
            sqlConn = new SqlConnection(connStr);
            sqlConn.Open();

            string query_select = "select * from tblUsers where userID = '"
                + userID + "' and password = '"
                + password + "'";

            SqlCommand sqlCmd = new SqlCommand(query_select, sqlConn);
            SqlDataReader reader = sqlCmd.ExecuteReader();
            if (reader.HasRows)
            {
                return true;
            }
            return false;
        }

        public SqlDataReader getMenus(string type)
        {

            sqlConn = new SqlConnection(connStr);
            sqlConn.Open();

            string query_select = "select * from tblMenu where menuType = '"
                + type + "'";

            SqlCommand sqlCmd = new SqlCommand(query_select, sqlConn);
            SqlDataReader reader = sqlCmd.ExecuteReader();

            //List<string> listResult = new List<string>();

            //while (reader.Read())
            //{
            //    listResult.Add(reader.GetString(0));
            //}
            return reader;
        }
        
    }
}