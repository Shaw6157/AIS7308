using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace web_cart_demo
{
    public partial class ProductCatalog : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack)
            {
                BindGrid();
            }
        }

        private void BindGrid()
        {
            SqlDataAdapter da =
            new SqlDataAdapter
            ("select * from products",
            @"data source=.\vsdotnet;initial catalog=northwind;user id=sa");
            DataSet ds = new DataSet();
            da.Fill(ds, "products");
            DataGrid1.DataSource = ds;
            DataGrid1.DataBind();
        }


        protected void DataGrid1_SelectedIndexChanged1(object sender, EventArgs e)
        {

            HttpCookie c = null;
            if (HttpContext.Current.Request.Cookies["shoppingcart"] == null)
                c = new HttpCookie("shoppingcart");
            else
                c = HttpContext.Current.Request.Cookies["shoppingcart"];
            string itemdetails;
            itemdetails = DataGrid1.SelectedItem.Cells[1].Text +
            "|" + DataGrid1.SelectedItem.Cells[2].Text +
            "|" + DataGrid1.SelectedItem.Cells[3].Text;
            c.Values[DataGrid1.SelectedItem.Cells[1].Text] = itemdetails;
            Response.Cookies.Add(c);
        }
    }
}