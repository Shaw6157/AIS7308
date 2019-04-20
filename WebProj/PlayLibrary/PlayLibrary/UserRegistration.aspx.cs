using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PlayLibrary
{
    public partial class UserReg : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            lblMessage.Visible = false;
        }

        //handle the event when clicking the button
        protected void BtnRegistration(object sender, EventArgs e)
        {
            User_DAL Userdal = new User_DAL();

            string UID = txtUserID.Text;
            string UserName = txtUserName.Text;
            string Password = txtPassword.Text;
            string ConfirmPassword = txtConfirmPassword.Text;

            //validations for input
            if (Password != ConfirmPassword)
            {
                ShowMessage("Please type the same password to confirm!");
            }
            else if (string.IsNullOrEmpty(UID) || string.IsNullOrEmpty(UserName)
                || string.IsNullOrEmpty(Password) || string.IsNullOrEmpty(ConfirmPassword))
            {
                ShowMessage("Please fill all fields to finish the registration!");
            }
            else
            {
                Userdal.RegisterUser(UID, UserName, Password);
                Response.Redirect("UserLogin.aspx");
            }
        }

        //show the message in the label field
        private void ShowMessage(string message)
        {
            lblMessage.Visible = true;
            lblMessage.Text = message;
        }
    }
}