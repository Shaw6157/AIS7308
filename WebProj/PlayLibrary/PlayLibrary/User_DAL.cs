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

                string query_save = "insert into tblAPM_user values ('"
                    + userID + "', '"
                    + name + "', '"
                    + getHashed(userID, password) + "')";

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

                string query_select = "select * from tblAPM_user where UserID = '"
                    + userID + "' and Password = '"
                    + getHashed(userID, password) + "'";

                SqlCommand sqlCmd = new SqlCommand(query_select, sqlConn);
                SqlDataReader reader = sqlCmd.ExecuteReader();
                if (reader.HasRows)
                {
                    return true;
                }
                return false;
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