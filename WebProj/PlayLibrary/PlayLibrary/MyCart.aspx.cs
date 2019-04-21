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
                if (Session["ToyModels"] != null)
                {
                    InitGridCart();
                }
            }
        }

        void InitGridCart()
        {
            GridViewCart.DataSource = Session["ToyModels"];
            GridViewCart.DataBind();

            List<ToyModel> itemList = (List<ToyModel>)Session["ToyModels"];

            decimal amount = 0;

            foreach (var item in itemList)
            {
                amount += item.Amount;
            }
            allquan.Text = itemList.Count().ToString();
            allamount.Text = amount.ToString();


            lblQuan.Visible = false;
            txtQuan.Visible = false;
            btnUpdate.Visible = false;

        }

        void ClearControls()
        {
            try
            {
                txtQuan.Text = "";
                CToyID.Text = "";
                lblQuan.Visible = false;
                txtQuan.Visible = false;
                btnUpdate.Visible = false;
            }
            catch
            {
                throw;
            }
        }

        protected void Clear_Click(object sender, EventArgs e)
        {
            try
            {
                ClearControls();
            }
            catch
            {

            }
        }

        protected void Edit_Click(object sender, EventArgs e)
        {
            try
            {
                ClearControls();
                Button btn = sender as Button;
                GridViewRow row = btn.NamingContainer as GridViewRow;
                CToyID.Text = (row.FindControl("lblToyID") as Label).Text;
                txtQuan.Text = (row.FindControl("lblToyQuan") as Label).Text;
                lblQuan.Visible = true;
                txtQuan.Visible = true;
                btnUpdate.Visible = true;
            }
            catch
            {

            }
        }

        protected void Update_Click(object sender, EventArgs e)
        {
            try
            {
                int newQuantity = Convert.ToInt32(txtQuan.Text);

                List<ToyModel> itemList = (List<ToyModel>)Session["ToyModels"];

                itemList.Single(s => s.Toyid == CToyID.Text).Quantity = newQuantity;
                itemList.Single(s => s.Toyid == CToyID.Text).Amount = itemList.Single(s => s.Toyid == CToyID.Text).Price * newQuantity;

                Session["ToyModels"] = itemList;
                InitGridCart();
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }

        protected void Del_Click(object sender, EventArgs e)
        {
            try
            {
                ClearControls();
                Button btn = sender as Button;
                GridViewRow row = btn.NamingContainer as GridViewRow;
                string removeID = (row.FindControl("lblToyID") as Label).Text;

                List<ToyModel> itemList = (List<ToyModel>)Session["ToyModels"];
                itemList.RemoveAll(s => s.Toyid == removeID);
                Session["ToyModels"] = itemList;
                InitGridCart();
            }
            catch (Exception ex)
            {
                throw ex;
            }
        }

    }
}