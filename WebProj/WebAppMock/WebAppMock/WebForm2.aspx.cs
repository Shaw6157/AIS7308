using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebAppMock
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            HttpCookie cookie = Response.Cookies["user"];
            if (cookie != null)
            {
                Label1.Text = Label1.Text + "Welcome " + cookie.Values["firstname"];
            }
            else
            {
                Response.Redirect("WebForm1.aspx");
            }
        }
    }
}