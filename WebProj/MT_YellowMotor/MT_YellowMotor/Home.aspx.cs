using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace MT_YellowMotor
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            HttpCookie httpCookie = Request.Cookies["loginUser"];
            if (httpCookie != null)
            {
                if (httpCookie.Values["firsttime"] != null)
                {
                    //not the first time here
                    lblWelcome.Text = "Welcome Back " + httpCookie.Values["uid"] + " !";
                }
                else
                {
                    //first time to the home page
                    lblWelcome.Text = "Welcome " + httpCookie.Values["uid"] + " !";
                    httpCookie.Values["firsttime"] = "1";
                    Response.Cookies.Add(httpCookie);
                }
            }
            else
            {
                Response.Redirect("Login.aspx");
            }
        }
    }
}