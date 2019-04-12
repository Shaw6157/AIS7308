using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PlayLibrary
{
    public partial class MyCart : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack)
            {
                if (Session["toyitems"] != null)
                {
                    GridView1.DataSource = Session["toyitems"];
                    GridView1.DataBind();

                    List<ToyItem> itemList = new List<ToyItem>();
                    itemList = (List<ToyItem>)Session["toyitems"];

                    int i = 0;
                    decimal amount = 0;

                    foreach (var item in itemList)
                    {
                        i += item.Quantity;
                        amount += item.Quantity * item.Price;
                    }
                    allquan.Text = i.ToString();
                    allamount.Text = amount.ToString();
                }
            }


            //string menuType = Request.QueryString["menuType"];
            //DAL_Menu dal = new DAL_Menu();

            //SqlDataReader reader = dal.getMenus(menuType);
            //Response.Write("<Table border=1 bordercolor=blue align=center>");

            //while (reader.Read())
            //{
            //    Response.Write("<tr> <td>" + reader[0] + "</td><td> <a href=menuDetails.aspx?menuID=" + reader[0] + "</a> </td></tr>");
            //}

            //Response.Write("</Table>");


            //List<ToyItem> itemList = (List<ToyItem>) Session["toyitems"];

            //foreach (var item in itemList)
            //{
            //    Response.Write("<Label>" + item.Price + "</Label><br/>");
            //}
        }
    }
}