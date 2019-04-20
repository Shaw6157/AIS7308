using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;

namespace PlayLibrary
{
    public class User_DAL
    {
        SqlConnection sqlConn;
        string connStr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;

        //for registration
        public void RegisterUser(string userID, string name, string password)
        {
            try
            {
                sqlConn = new SqlConnection(connStr);
                sqlConn.Open();

                string query_save = "insert into tblUser values ('"
                    //+ userID + "', '"
                    + getHashed(userID, password) + "', '"
                    + userID + "', '"
                    + name + "', '"
                    + "" + "', "
                    + "0"
                    + ")";

                SqlCommand sqlCmd = new SqlCommand(query_save, sqlConn);
                sqlCmd.ExecuteNonQuery();
                sqlConn.Close();
            }
            catch (Exception)
            {
                throw;
            }
        }

        //for login
        public Boolean LoginUser(string userID, string password)
        {
            try
            {
                sqlConn = new SqlConnection(connStr);
                sqlConn.Open();

                string query_select = "select * from tblUser where email = '"
                    + userID + "' and password = '"
                    + getHashed(userID, password) + "'";

                SqlCommand sqlCmd = new SqlCommand(query_select, sqlConn);
                SqlDataReader reader = sqlCmd.ExecuteReader();
                if (reader.HasRows)
                {
                    while (reader.Read()) {
                        LoginCounter(reader.GetInt32(0), reader.GetInt32(5) + 1);
                    }

                    return true;
                }
                return false;
            }
            catch (Exception)
            {
                throw;
            }
        }

        public void LoginCounter(int userID, int num)
        {
            try
            {
                sqlConn = new SqlConnection(connStr);
                sqlConn.Open();
                
                string query_save = "update tblUser " +
                    "SET logintime = "
                    + num + "" +
                    " WHERE userID = '" + userID + "'";

                SqlCommand sqlCmd = new SqlCommand(query_save, sqlConn);
                sqlCmd.ExecuteNonQuery();
                sqlConn.Close();
            }
            catch (Exception)
            {
                throw;
            }
        }

        public string ResetPassword(string userID, string userName)
        {
            try
            {
                sqlConn = new SqlConnection(connStr);
                sqlConn.Open();

                var password = "tLibrary" + new Random(999);

                string query_save = "update tblAPM_user " +
                    "SET password = '"
                    + getHashed(userID, password) + "'" +
                    " WHERE userID = '" + userID + "'";

                SqlCommand sqlCmd = new SqlCommand(query_save, sqlConn);
                sqlCmd.ExecuteNonQuery();
                sqlConn.Close();
                return password;
            }
            catch (Exception)
            {
                throw;
            }
        }


        private string getHashed(string str, string strSalt)
        {
            byte[] strByte  = ASCIIEncoding.ASCII.GetBytes(str + strSalt + "AIS");
            byte[] hashByte = SHA256.Create().ComputeHash(strByte);
            return Convert.ToBase64String(hashByte);
        }
    }
}