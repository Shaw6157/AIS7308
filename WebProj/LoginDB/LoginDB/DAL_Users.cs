using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Data.SqlClient;
using System.Configuration;
using System.Data;

namespace LoginDB
{
    public class DAL_Users
    {
        string connString = ConfigurationManager.ConnectionStrings["connSOFT703"].ConnectionString;
        //Database 
        //  "Data Source=SHUAB-PC\xxx; Initial Catalog=dbSOFT703; Integrated Security = true;"
        SqlConnection connection;

        SqlConnection conn;
        //string connString = ConfigurationManager.ConnectionStrings["connDB"].ConnectionString;

        public void testUser (string str_uname)
        {
            connection = new SqlConnection(connString);
            connection.Open();
            String query = "insert into tblUsers values ('"
                + str_uname + "')";
            SqlCommand sqlcmd = new SqlCommand(query, connection);

            sqlcmd.ExecuteNonQuery();
            connection.Close();
        }

        public void saveUser(string firstName, string userID, string userpassword)
        {
            connection = new SqlConnection(connString);
            connection.Open();
            string query = "Insert into tblUsers values('" +
                firstName + "', '" +
                userID + "', '" +
                userpassword + "')";
            //step 4
            SqlCommand command = new SqlCommand(query, connection);

            command.ExecuteNonQuery();
            connection.Close();
        }

        public Boolean loginUser(string name, string password)
        {
            connection = new SqlConnection(connString);
            connection.Open();
            string query = "select * from tblUsers where firstName = '"
                + name + "' and password = '"
                + password + "'";

            SqlCommand comm = new SqlCommand(query, connection);

            SqlDataReader reader = comm.ExecuteReader();

            if (reader.HasRows)
                
            //SqlDataAdapter da = new SqlDataAdapter(comm);
            //DataTable dt = new DataTable();
            //da.Fill(dt);

            //connection.Close();
            //if (dt.Rows.Count > 0)
            {
                return true;
            }
            return false;

        }
    }
}