using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace WebApplication5
{
    public class DAL_user
    {
        SqlConnection conn;
        string connStr = ConfigurationManager.ConnectionStrings["connDB"].ConnectionString;

        public void saveUser(string uname, string password)
        {
            conn = new SqlConnection(connStr);
            conn.Open();

            string query = "insert into tblUsers values ('"
                + uname + "', '"
                + "ssss', '"
                + password + "')";

            SqlCommand cmd = new SqlCommand(query, conn);
            cmd.ExecuteNonQuery();
            conn.Close();

        }
    }
}