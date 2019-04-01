using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace MyRestaurantDemo
{
    public partial class WebForm3 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            int menuID = int.Parse(Request.QueryString["menuID"]);
            DAL_Menu dal = new DAL_Menu();
            SqlDataReader reader = dal.getMenus();

            reader.Read();
            Response.Write("<Table border=3 bordercolor=red align=center bgcolor=pink width=80%>");
            Response.Write("<tr> <td colspan='2'>");
            Response.Write("</Table>");

        }
    }
}