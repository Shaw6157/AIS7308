using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace MT_YellowMotor
{
    public partial class WebForm3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            //hide the message label
            lblMessage.Visible = false;
        }

        protected void btnLogin_Click(object sender, EventArgs e)
        {
            if (Page.IsValid)
            {
                if (txtPassword.Text.Length != 8)
                {
                    lblMessage.Text = "Sorry, the length of password should be 8.";
                    lblMessage.Visible = true;
                    return;
                }

                if (new DAL_Database().loginUser(txtUID.Text, txtPassword.Text))
                {
                    //save data into cookie
                    HttpCookie myCookie = new HttpCookie("loginUser");
                    myCookie.Values["uid"] = txtUID.Text;
                    myCookie.Expires.AddDays(3);
                    Response.Cookies.Add(myCookie);

                    //navigation
                    Response.Redirect("Home.aspx");

                }
                else
                {
                    lblMessage.Text = "Sorry, wrong user ID or password, please try again!";
                    lblMessage.Visible = true;
                }

            }
        }
    }
}