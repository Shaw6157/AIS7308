using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PlayLibrary
{
    public partial class AdminLogin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblMsg.Visible = false;
        }

        protected void UserLogin(object sender, EventArgs e)
        {
            User_DAL aLayer = new User_DAL();
            //check local
            if (aLayer.LoginUser(txtUsername.Text, txtPassword.Text))
            {
                if (txtUsername.Text.Equals("admin"))
                {
                    Response.Redirect("AdminData.aspx");
                }
                else
                {
                    Response.Redirect("Home.aspx");
                }

            }
            else
            {
                lblMsg.Visible = true;
                lblMsg.Text = "Wrong username or password, Please try again";
            }
        }
    }
}