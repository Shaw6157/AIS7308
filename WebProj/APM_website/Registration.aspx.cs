using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace APM_website
{
    public partial class Registration : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            DAL_User aLayer = new DAL_User();
            aLayer.registerUser(TextBox1.Text, TextBox2.Text, TextBox3.Text);
                        
        }
    }
}