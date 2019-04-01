using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Playwithkids
{
    public partial class AdminLogin : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblMsg.Visible = false;
        }

        protected void UserLogin(object sender, EventArgs e)
        {
            //check server
            //todo

            //check local
            if (txtUsername.Text.Equals("admin") && txtPassword.Text.Equals("admin"))
            {
                Response.Redirect("AdminData.aspx");
            } else
            {
                lblMsg.Visible = true;
                lblMsg.Text = "Wrong username or password, Please try again";
            }
        }
    }
}