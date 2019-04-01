using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI.WebControls;

namespace APM_website
{
    public class DAL_User
    {
        SqlConnection sqlConn;
        string connStr = ConfigurationManager.ConnectionStrings["connDB"].ConnectionString;

        public void registerUser(string userID, string name, string password)
        {
            sqlConn = new SqlConnection(connStr);
            sqlConn.Open();

            string query_save = "insert into tblAPM_user values ('"
                + userID + "', '"
                + name + "', '"
                + password + "')";

            SqlCommand sqlCmd = new SqlCommand(query_save, sqlConn);
            sqlCmd.ExecuteNonQuery();
            sqlConn.Close();
        }

        public Boolean loginUser(string userID, string password)
        {
            sqlConn = new SqlConnection(connStr);
            sqlConn.Open();

            string query_select = "select * from tblAPM_user where UserID = '"
                + userID + "' and Password = '"
                + password + "'";

            SqlCommand sqlCmd = new SqlCommand(query_select, sqlConn);
            SqlDataReader reader = sqlCmd.ExecuteReader();
            if (reader.HasRows)
            {
                return true;
            }
            return false;
        }
    }
}