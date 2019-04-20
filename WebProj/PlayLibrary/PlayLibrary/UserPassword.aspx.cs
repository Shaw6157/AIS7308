using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PlayLibrary
{
    public partial class UserPassword : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblMessage.Text = "";
        }

        protected void BtnResetPwd(object sender, EventArgs e)
        {
            User_DAL aLayer = new User_DAL();
            var NewPassword = aLayer.ResetPassword(txtUserID.Text, txtUserName.Text);
            lblMessage.Text = "Your password has been reset to: " + NewPassword;
        }
    }
}