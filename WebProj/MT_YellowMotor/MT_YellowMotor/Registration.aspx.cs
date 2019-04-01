using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace MT_YellowMotor
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!Page.IsPostBack) // init for the first time
            {
                //ddlCountry.Items.Insert(0, new ListItem("Select Your Country"));
                DAL_Database aLayer = new DAL_Database();
                List<string> list = aLayer.getCountries();
                if (list != null && list.Count > 0)
                {
                    for (int i = 0; i < list.Count; i++)
                    {

                        ListItem listItem = new ListItem();
                        
                        ddlCountry.Items.Insert(i, new ListItem(list[i], list[i]));
                    }
                }
            }
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            if (Page.IsValid)
            {
                //save user into DB table
                DAL_Database aLayer = new DAL_Database();
                aLayer.registerUser(
                    txtUserID.Text,
                    txtName.Text,
                    txtPassword.Text,
                    ddlCountry.SelectedItem.Text,
                    txtEmail.Text);

                //save first name to cookie
                HttpCookie regCookie = new HttpCookie("regCookie");
                regCookie.Values["firstName"] = lblName.Text;
                regCookie.Expires.AddDays(3);
                Response.Cookies.Add(regCookie);

                //navigat to Login
                Response.Redirect("Login.aspx");
            }
        }
    }
}