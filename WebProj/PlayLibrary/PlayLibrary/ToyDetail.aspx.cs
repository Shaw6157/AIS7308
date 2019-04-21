using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PlayLibrary
{
    public partial class ToyDetail : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblMessage.Visible = false;
        }
        
        protected void btnAddToCart(object sender, EventArgs e)
        {
            try
            {
                List<ToyModel> itemList = new List<ToyModel>();
                if ((List<ToyModel>)Session["ToyModels"] != null)
                    itemList = (List<ToyModel>)Session["ToyModels"];

                //get values from datasource
                DataView dvSql = (DataView)DB_Toy_detail.Select(DataSourceSelectArguments.Empty);
                ToyModel item = new ToyModel();
                item.Toyid = dvSql[0]["toyID"].ToString();
                item.Toyname = dvSql[0]["toyname"].ToString();
                item.ImgSource = dvSql[0]["ImgSource"].ToString();
                item.Price = Convert.ToDecimal(dvSql[0]["Price"]) * Convert.ToDecimal(dvSql[0]["Pricedisc"]);
                item.RRP = Convert.ToDecimal(dvSql[0]["Price"]);

                TextBox box = (TextBox)FormView.FindControl("txtQuantity");    
                item.Quantity = Convert.ToInt16(box.Text);

                item.Amount = item.Price * item.Quantity;

                itemList.Add(item);

                //add to session
                Session["ToyModels"] = itemList;

                lblMessage.Visible = true;
                lblMessage.Text = "Toys added successfully!!";
            }
            catch (Exception)
            {
                throw;
            }
        }
    }
}