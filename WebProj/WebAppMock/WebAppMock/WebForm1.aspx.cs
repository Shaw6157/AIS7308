using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace WebAppMock
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            HttpCookie userinfo = new HttpCookie("User");
            userinfo.Values["firstname"] = TextBox1.Text;
            userinfo.Expires = DateTime.Now.AddDays(3d);
            Response.Cookies.Add(userinfo);
            Response.Redirect(WebForm2.aspx);
        }
    }
}