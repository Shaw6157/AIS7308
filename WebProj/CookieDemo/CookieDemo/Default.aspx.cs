using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace CookieDemo
{
    public partial class WebForm3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            HttpCookie myCookie = Request.Cookies["UserInfo"];
            if (Request.Cookies["UserInfo"] != null)
            {
                Label1.Text = Label1.Text + "Welcome" + myCookie["uid"];
            } else
            {
                Response.Redirect("WebLogin.aspx");
            }
        }

        protected void btnLogout_Click(object sender, EventArgs e)
        {
            HttpCookie httpCookie = new HttpCookie("UserInfo");
            httpCookie.Expires.AddDays(-30);
            Response.Cookies.Add(httpCookie);
            Response.Redirect("WebLogin.aspx");
        }
    }
}