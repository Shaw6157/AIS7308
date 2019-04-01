using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace LoginDB
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if (Page.IsValid)
            {

                //DAL_Users aLayer = new DAL_Users();
                //aLayer.saveUser(txtFirstName.Text, txtUserID.Text, txtPassword.Text);
                lbmsg.Text = "Done";
                lbmsg.Visible = true;

                HttpCookie myCookie = new HttpCookie("user");
                myCookie.Values["firstname"] = "aaa";
                myCookie.Expires = DateTime.Now.AddDays(3);
                Response.Cookies.Add(myCookie);

            }
        }

        protected void Button2_Click(object sender, EventArgs e)
        {
            HttpCookie httpCookie = Request.Cookies["user"];
            if (httpCookie != null)
            {

                lbmsg.Text = lbmsg.Text + "   Done   " + Request.Cookies["user"]["firstname"];
            } else
            {
                lbmsg.Text = "login  plz";
            }



            //DAL_Users aLayer = new DAL_Users();
            //if (aLayer.loginUser(txtFirstName.Text, txtPassword.Text))
            //{
            //    lbmsg.Text = "success";
            //} else
            //{
            //    lbmsg.Text = "no user";
            //}
            //lbmsg.Visible = true;
        }

        protected void Button3_Click(object sender, EventArgs e)
        {
            //HttpCookie aCookie = HttpCookie.Cookies"user");
            //Response.Cookies["user"]["firstname"] = "sdf";
            //Response.Cookies["firstname"].Expires();
            HttpCookie aCookie = new HttpCookie("user");
            aCookie.Expires = DateTime.Now.AddDays(-3);
            Response.Cookies.Add(aCookie);
        }
    }
}