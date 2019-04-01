using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Web;

namespace HashDemo
{
    public class Security
    {
        public static string GetHash512(string password)
        {
            byte[] passwordByte = ASCIIEncoding.ASCII.GetBytes(password);

            HashAlgorithm algorithm = new HMACSHA512();
            byte[] hashPassword = algorithm.ComputeHash(passwordByte);
            return Convert.ToBase64String(hashPassword);
        }
        public static string GetHash5(string password)
        {
            byte[] passwordByte = ASCIIEncoding.ASCII.GetBytes(password);

            HashAlgorithm algorithm = new HMACMD5();
            byte[] hashPassword = algorithm.ComputeHash(passwordByte);
            return Convert.ToBase64String(hashPassword);
        }
    }