using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace MyRestaurantDemo
{
    public partial class WebForm2 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            string menuType = Request.QueryString["menuType"];
            DAL_Menu dal = new DAL_Menu();

            SqlDataReader reader = dal.getMenus(menuType);
            Response.Write("<Table border=1 bordercolor=blue align=center>");

            while(reader.Read())
            {
                Response.Write("<tr> <td>" + reader[0] + "</td><td> <a href=menuDetails.aspx?menuID=" + reader[0] + "</a> </td></tr>");
            }

            Response.Write("</Table>");
        }
    }
}