using System.Data;
using System.Configuration;
using System.Data.SqlClient;
using System;
using System.Web.UI.WebControls;
using System.Globalization;

namespace PlayLibrary
{
    public partial class AdminData : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!this.IsPostBack)
            {
                this.BindGrid();
            }

        }

        private void BindGrid()
        {
            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;
            string query = "SELECT * FROM tblUser";
            string querytoy = "SELECT * FROM tblToy";

            try
            {

                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                    {
                        using (DataTable dt = new DataTable())
                        {
                            sda.Fill(dt);
                            GridUser.DataSource = dt;
                            GridUser.DataBind();
                        }
                    }


                    using (SqlDataAdapter sda = new SqlDataAdapter(querytoy, con))
                    {
                        using (DataTable dt = new DataTable())
                        {
                            sda.Fill(dt);
                            GridToy.DataSource = dt;
                            GridToy.DataBind();

                        }
                    }
                }
            }
            catch (Exception)
            {
                showMessage();
            }
        }

        protected void InsertUser(object sender, EventArgs e)
        {
            string strpwd = txtPassword.Text;
            string stremail = txtEmail.Text;
            string strfname = txtFirstName.Text;
            string strlname = txtLastName.Text;

            //clear controls
            txtPassword.Text = "";
            txtEmail.Text = "";
            txtFirstName.Text = "";
            txtLastName.Text = "";

            string query = "INSERT INTO tblUser VALUES(@password, @email, @fname, @lname)";
            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;

            try
            {
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlCommand cmd = new SqlCommand(query))
                    {
                        cmd.Parameters.AddWithValue("@password", strpwd);
                        cmd.Parameters.AddWithValue("@email", stremail);
                        cmd.Parameters.AddWithValue("@fname", strfname);
                        cmd.Parameters.AddWithValue("@lname", strlname);
                        cmd.Connection = con;
                        con.Open();
                        cmd.ExecuteNonQuery();
                        con.Close();
                    }
                }
                this.BindGrid();

            }
            catch (Exception)
            {
                showMessage();
            }
        }

        protected void OnRowEditing(object sender, GridViewEditEventArgs e)
        {
            GridUser.EditIndex = e.NewEditIndex;
            this.BindGrid();
        }

        protected void OnRowUpdating(object sender, GridViewUpdateEventArgs e)
        {
            try
            {
                GridViewRow row = GridUser.Rows[e.RowIndex];
                int uid = Convert.ToInt32(GridUser.DataKeys[e.RowIndex].Values[0]);

                string strpwd = (row.FindControl("txtPassword") as TextBox).Text;
                string stremail = (row.FindControl("txtEmail") as TextBox).Text;
                string strfname = (row.FindControl("txtFirstName") as TextBox).Text;
                string strlname = (row.FindControl("txtLastName") as TextBox).Text;
                string query = "UPDATE tblUser SET password=@password, email=@email, firstName=@fname, lastName=@lname WHERE userID=@uid";
                string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlCommand cmd = new SqlCommand(query))
                    {
                        cmd.Parameters.AddWithValue("@uid", uid);
                        cmd.Parameters.AddWithValue("@password", strpwd);
                        cmd.Parameters.AddWithValue("@email", stremail);
                        cmd.Parameters.AddWithValue("@fname", strfname);
                        cmd.Parameters.AddWithValue("@lname", strlname);
                        cmd.Connection = con;
                        con.Open();
                        cmd.ExecuteNonQuery();
                        con.Close();
                    }
                }
                GridUser.EditIndex = -1;
                this.BindGrid();
            }
            catch (Exception)
            {
                showMessage();
            }
        }

        protected void OnRowCancelingEdit(object sender, EventArgs e)
        {
            GridUser.EditIndex = -1;
            this.BindGrid();
        }

        protected void OnRowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            int uid = Convert.ToInt32(GridUser.DataKeys[e.RowIndex].Values[0]);
            string query = "DELETE FROM tblUser WHERE userID=@uid";
            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;

            try
            {
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlCommand cmd = new SqlCommand(query))
                    {
                        cmd.Parameters.AddWithValue("@uid", uid);
                        cmd.Connection = con;
                        con.Open();
                        cmd.ExecuteNonQuery();
                        con.Close();
                    }
                }

                this.BindGrid();

            }
            catch (Exception)
            {
                showMessage();
            }
        }

        protected void OnRowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow && e.Row.RowIndex != GridUser.EditIndex)
            {
                (e.Row.Cells[5].Controls[2] as Button).Attributes["onclick"] = "return confirm('Do you want to delete this row?');";
            }
        }

        protected void OnPaging(object sender, GridViewPageEventArgs e)
        {
            GridUser.PageIndex = e.NewPageIndex;
            this.BindGrid();
        }

        /// ///////////////////////////////////////////////
        /// 


        protected void InsertToy(object sender, EventArgs e)
        {
            string strtoyname = txtToyname.Text;
            string strtoydesc = txtToydesc.Text;
            string strimgsource = txtImg.Text;

            var culture = new CultureInfo("en-US");
            decimal strprice = decimal.Parse(txtPrice.Text, culture);
            string strtype = txtType.Text;
            string strmadein = txtMadein.Text;

            //clear controls
            txtPassword.Text = "";
            txtEmail.Text = "";
            txtFirstName.Text = "";
            txtLastName.Text = "";

            try
            {

                string query = "INSERT INTO tblToy VALUES(@name, @desc, @img, @price, @type, @madein)";
                string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlCommand cmd = new SqlCommand(query))
                    {
                        cmd.Parameters.AddWithValue("@name", strtoyname);
                        cmd.Parameters.AddWithValue("@desc", strtoydesc);
                        cmd.Parameters.AddWithValue("@img", strimgsource);
                        cmd.Parameters.AddWithValue("@price", strprice);
                        cmd.Parameters.AddWithValue("@type", strtype);
                        cmd.Parameters.AddWithValue("@madein", strmadein);
                        cmd.Connection = con;
                        con.Open();
                        cmd.ExecuteNonQuery();
                        con.Close();
                    }
                }
                this.BindGrid();
            }
            catch (Exception)
            {
                showMessage();
            }
        }

        //toy table operation
        protected void OnToyEditing(object sender, GridViewEditEventArgs e)
        {
            GridToy.EditIndex = e.NewEditIndex;
            //GridToy.Columns[0].ItemStyle.Width = 120;
            //GridToy.Columns[1].ItemStyle.Width = 120;
            //GridToy.Columns[2].ItemStyle.Width = 120;
            //GridToy.Columns[3].ItemStyle.Width = 120;

            //(GridToy.Rows[e.NewEditIndex].Cells[2].Controls[0] as TextBox).Attributes["width"] = "20";

            this.BindGrid();
        }

        protected void OnToyUpdating(object sender, GridViewUpdateEventArgs e)
        {
            GridViewRow row = GridToy.Rows[e.RowIndex];

            int struid = Convert.ToInt32(row.Cells[0].Text);
            string strtoyname = row.Cells[1].Text;
            string strtoydesc = row.Cells[2].Text;
            string strimgsource = row.Cells[3].Text;

            //decimal strprice = decimal.Parse(GridToy.Rows[e.RowIndex].Cells[4].Text, culture);
            decimal strprice = decimal.Parse(row.Cells[4].Text);
            string strtype = row.Cells[5].Text;
            string strmadein = row.Cells[6].Text;

            string query = "UPDATE tblToy SET toyname=@name, toydesc=@desc, imgSource=@img, price=@price, type=@type, madein=@madein WHERE userID=@uid";
            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;

            try
            {
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlCommand cmd = new SqlCommand(query))
                    {
                        cmd.Parameters.AddWithValue("@uid", struid);
                        cmd.Parameters.AddWithValue("@name", strtoyname);
                        cmd.Parameters.AddWithValue("@desc", strtoydesc);
                        cmd.Parameters.AddWithValue("@img", strimgsource);
                        cmd.Parameters.AddWithValue("@price", strprice);
                        cmd.Parameters.AddWithValue("@type", strtype);
                        cmd.Parameters.AddWithValue("@madein", strmadein);
                        cmd.Connection = con;
                        con.Open();
                        cmd.ExecuteNonQuery();
                        con.Close();
                    }
                }
                GridToy.EditIndex = -1;
                this.BindGrid();
            }
            catch (Exception)
            {
                showMessage();
            }

        }

        protected void OnToyCancelingEdit(object sender, EventArgs e)
        {
            GridToy.EditIndex = -1;
            this.BindGrid();
        }

        protected void OnToyDeleting(object sender, GridViewDeleteEventArgs e)
        {
            int uid = Convert.ToInt32(GridToy.DataKeys[e.RowIndex].Values[0]);
            int struid = Convert.ToInt32(GridToy.Rows[e.RowIndex].Cells[0].Text);

            string query = "DELETE FROM tblToy WHERE toyID=@tid";
            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;
            try
            {
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlCommand cmd = new SqlCommand(query))
                    {
                        cmd.Parameters.AddWithValue("@tid", struid);
                        cmd.Connection = con;
                        con.Open();
                        cmd.ExecuteNonQuery();
                        con.Close();
                    }
                }

                this.BindGrid();
            }
            catch (Exception)
            {
                showMessage();
            }
        }

        protected void OnToyPaging(object sender, GridViewPageEventArgs e)
        {
            GridToy.PageIndex = e.NewPageIndex;
            this.BindGrid();
        }

        private void showMessage ()
        {
            lblMessage.Visible = true;
            lblMessage.Text = "Database error. ";
        }

        protected void BtnTop10_Click(object sender, EventArgs e)
        {

            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;
            string query = "SELECT TOP(10) * FROM tblUser ORDER BY logintime DESC";

            try
            {

                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                    {
                        using (DataTable dt = new DataTable())
                        {
                            sda.Fill(dt);
                            GridUser.DataSource = dt;
                            GridUser.DataBind();
                        }
                    }
                }
            }
            catch (Exception)
            {
                showMessage();
            }
        }

        protected void SearchUser(object sender, EventArgs e)
        {

            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;
            string query = "SELECT  * FROM tblUser";
            if (searchTxt.Text != null)
                query = "SELECT  * FROM tblUser WHERE firstname LIKE '%" + searchTxt.Text + "%'";

            try
            {
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                    {
                        using (DataTable dt = new DataTable())
                        {
                            sda.Fill(dt);
                            GridUser.DataSource = dt;
                            GridUser.DataBind();
                        }
                    }
                }
            }
            catch (Exception)
            {
                showMessage();
            }
        }

        protected void SearchToyByDate(object sender, EventArgs e)
        {

            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;
            string query = "SELECT  * FROM tblToy";
            if (SearToyDate.Text != null)
                query = "SELECT  * FROM tblToy WHERE moddate LIKE '%" + SearToyDate.Text + "%'";

            try
            {
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                    {
                        using (DataTable dt = new DataTable())
                        {
                            sda.Fill(dt);
                            GridToy.DataSource = dt;
                            GridToy.DataBind();
                        }
                    }
                }
            }
            catch (Exception)
            {
                showMessage();
            }
        }

        protected void SearchToyByType(object sender, EventArgs e)
        {

            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;
            string query = "SELECT  * FROM tblToy";
            if (SearToyType.Text != null)
                query = "SELECT  * FROM tblToy WHERE type LIKE '%" + SearToyType.Text + "%'";

            try
            {
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                    {
                        using (DataTable dt = new DataTable())
                        {
                            sda.Fill(dt);
                            GridToy.DataSource = dt;
                            GridToy.DataBind();
                        }
                    }
                }
            }
            catch (Exception)
            {
                showMessage();
            }
        }


        protected void SearchToyByName(object sender, EventArgs e)
        {

            string constr = ConfigurationManager.ConnectionStrings["dbSOFT703ConnectionString"].ConnectionString;
            string query = "SELECT  * FROM tblToy";
            if (SearToyName.Text != null)
                query = "SELECT  * FROM tblToy WHERE type LIKE '%" + SearToyName.Text + "%'";

            try
            {
                using (SqlConnection con = new SqlConnection(constr))
                {
                    using (SqlDataAdapter sda = new SqlDataAdapter(query, con))
                    {
                        using (DataTable dt = new DataTable())
                        {
                            sda.Fill(dt);
                            GridToy.DataSource = dt;
                            GridToy.DataBind();
                        }
                    }
                }
            }
            catch (Exception)
            {
                showMessage();
            }
        }

    }
}