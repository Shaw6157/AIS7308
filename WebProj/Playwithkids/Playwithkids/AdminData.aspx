<%@ Page Title="" Language="C#" MasterPageFile="~/Main.Master" AutoEventWireup="true" CodeBehind="AdminData.aspx.cs" Inherits="Playwithkids.AdminData" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

    <h3 class="title" id="title" style="display: inline-block;">Admin Page</h3>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 


    <a href="#GridUser" class="label-info">Edit Users </a>&nbsp | &nbsp
    
		<a href="#product" class="label-info">Edit Product </a>

    <asp:SqlDataSource ID="DS_User" runat="server" ConnectionString="<%$ ConnectionStrings:dbSOFT703ConnectionString %>" SelectCommand="SELECT * FROM [tblUser]"></asp:SqlDataSource>
    <asp:SqlDataSource ID="DS_Toy" runat="server" ConnectionString="<%$ ConnectionStrings:dbSOFT703ConnectionString %>" SelectCommand="SELECT * FROM [tblToy]"></asp:SqlDataSource>
    <br />


    <asp:Label ID="lblMessage" runat="server" Text="Label"></asp:Label>


    <h4>Tables: tblUser</h4>
    <asp:ScriptManager ID="ScriptManager1" runat="server">
    </asp:ScriptManager>
    <div id="dvGrid" style="padding: 10px; width: 800px">
        <contenttemplate>
            <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="false" OnRowDataBound="OnRowDataBound"
                DataKeyNames="userID" OnRowEditing="OnRowEditing" OnRowCancelingEdit="OnRowCancelingEdit" PageSize="5" AllowPaging="true" OnPageIndexChanging="OnPaging"
                OnRowUpdating="OnRowUpdating" OnRowDeleting="OnRowDeleting" EmptyDataText="No user has been added."
                CellSpacing ="4">
                <PagerStyle BackColor="White" ForeColor="#000066" HorizontalAlign="Left" />
                <HeaderStyle BackColor="#006699" Font-Bold="True" ForeColor="White" />
                <FooterStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
                <Columns>
                    <asp:TemplateField HeaderText="User ID" ItemStyle-Width="150">
                        <ItemTemplate>
                            <asp:Label ID="lblUID" runat="server" Text='<%# Eval("userID") %>'></asp:Label>
                        </ItemTemplate>
                        <EditItemTemplate>
                            <asp:Label ID="lblUID" runat="server" Text='<%# Eval("userID") %>' Width="140"></asp:Label>
                        </EditItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Password" ItemStyle-Width="150">
                        <ItemTemplate>
                            <asp:Label ID="lblPassword" runat="server" Text='<%# Eval("password") %>'></asp:Label>
                        </ItemTemplate>
                        <EditItemTemplate>
                            <asp:TextBox ID="txtPassword" runat="server" Text='<%# Eval("password") %>' Width="140"></asp:TextBox>
                        </EditItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Email" ItemStyle-Width="200">
                        <ItemTemplate>
                            <asp:Label ID="lblEmail" runat="server" Text='<%# Eval("email") %>'></asp:Label>
                        </ItemTemplate>
                        <EditItemTemplate>
                            <asp:TextBox ID="txtEmail" runat="server" Text='<%# Eval("email") %>' Width="170"></asp:TextBox>
                        </EditItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="First Name" ItemStyle-Width="150">
                        <ItemTemplate>
                            <asp:Label ID="lblFirstName" runat="server" Text='<%# Eval("firstName") %>'></asp:Label>
                        </ItemTemplate>
                        <EditItemTemplate>
                            <asp:TextBox ID="txtFirstName" runat="server" Text='<%# Eval("firstName") %>' Width="120"></asp:TextBox>
                        </EditItemTemplate>
                    </asp:TemplateField>
                    <asp:TemplateField HeaderText="Last Name" ItemStyle-Width="150">
                        <ItemTemplate>
                            <asp:Label ID="lblLastName" runat="server" Text='<%# Eval("lastName") %>'></asp:Label>
                        </ItemTemplate>
                        <EditItemTemplate>
                            <asp:TextBox ID="txtLastName" runat="server" Text='<%# Eval("lastName") %>' Width="120"></asp:TextBox>
                        </EditItemTemplate>
                    </asp:TemplateField>
                    <asp:CommandField ButtonType="Button" ShowEditButton="true" ShowDeleteButton="true" ControlStyle-CssClass="btn ht-btn bg-4 m-t-10"
                        ItemStyle-Width="250" />
                </Columns>
            </asp:GridView>
            <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
                <tr>
                    <td style="width: 140px">User ID:<br />
                        <asp:Label ID="lblUserID" runat="server" Width="120" text="[Auto]"/>
                    </td>
                    <td style="width: 150px">Password:<br />
                        <asp:TextBox ID="txtPassword" runat="server" Width="130" />
                    </td>
                    <td style="width: 200px">Email:<br />
                        <asp:TextBox ID="txtEmail" runat="server" Width="170" />
                    </td>
                    <td style="width: 150px">Last Name:<br />
                        <asp:TextBox ID="txtLastName" runat="server" Width="130" />
                    </td>
                    <td style="width: 150px">First Name:<br />
                        <asp:TextBox ID="txtFirstName" runat="server" Width="130" />
                    </td>
                    <td style="width: 150px">
                        <asp:Button ID="btnAdd" class="btn ht-btn bg-4 m-t-10"  runat="server" Text="Add" OnClick="InsertUser" />
                    </td>
                </tr>
            </table>
        </contenttemplate>
    </div>


    <br />
    <hr color="#D9E7F8" id="product" />

    <h4>Tables: tblToy</h4>
    <asp:GridView ID="GridToy" runat="server" AutoGenerateColumns="False" DataKeyNames="toyID"
        OnRowEditing="OnToyEditing" OnRowCancelingEdit="OnToyCancelingEdit" PageSize="5" AllowPaging="true" OnPageIndexChanging="OnToyPaging"
        OnRowUpdating="OnToyUpdating" OnRowDeleting="OnToyDeleting" EmptyDataText="No user has been added."
        CellSpacing="4" Width="1000">
        <HeaderStyle BackColor="#006699" Font-Bold="True" ForeColor="White" />
        <FooterStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
        <Columns>
            <asp:BoundField DataField="toyID" HeaderText="toyID" InsertVisible="False" ReadOnly="True" SortExpression="toyID" />
            <asp:BoundField DataField="toyname" HeaderText="toyname" SortExpression="toyname" ItemStyle-Width="650px" />
            <asp:BoundField DataField="toydesc" HeaderText="toydesc" SortExpression="toydesc" ItemStyle-Width="650px" />
            <asp:BoundField DataField="imgSource" HeaderText="imgSource" SortExpression="imgSource" ItemStyle-Width="650px" />
            <asp:BoundField DataField="price" HeaderText="price" SortExpression="price" ItemStyle-Width="650" />
            <asp:BoundField DataField="type" HeaderText="type" SortExpression="type" ItemStyle-Width="650" />
            <asp:BoundField DataField="madein" HeaderText="madein" SortExpression="madein" ItemStyle-Width="650" />
            <asp:CommandField ShowEditButton="True" ButtonType="Button" ControlStyle-CssClass="btn ht-btn bg-4 m-t-10" />
            <asp:CommandField ShowDeleteButton="True" ButtonType="Button" ControlStyle-CssClass="btn ht-btn bg-4 m-t-10" />
        </Columns>

    </asp:GridView>
    <table border="1" cellpadding="0" cellspacing="0" style="border-collapse: collapse">
        <tr>
            <td>Toy ID:<br />
                <asp:Label ID="Label1" runat="server" Text="[Auto]" />
            </td>
            <td style="width: 150px">Name:<br />
                <asp:TextBox ID="txtToyname" runat="server" Width="130" />
            </td>
            <td style="width: 200px">Desc:<br />
                <asp:TextBox ID="txtToydesc" runat="server" Width="170" />
            </td>
            <td style="width: 150px">Image URL:<br />
                <asp:TextBox ID="txtImg" runat="server" Width="130" />
            </td>
            <td style="width: 150px">Price:<br />
                <asp:TextBox ID="txtPrice" runat="server" Width="130" />
            </td>
            <td style="width: 150px">Type:<br />

                <asp:DropDownList ID="txtType" runat="server">
                    <asp:ListItem Value="baby">Baby(0-2)</asp:ListItem>
                    <asp:ListItem Value="Kids">Kids (2-6)</asp:ListItem>
                    <asp:ListItem Value="Children">Children(7-12)</asp:ListItem>
                </asp:DropDownList>
            </td>
            <td style="width: 150px">Made in:<br />
                <asp:TextBox ID="txtMadein" runat="server" Width="130" />
            </td>
            <td style="width: 150px">
                <asp:Button ID="Button1" class="btn ht-btn bg-4 m-t-10" runat="server" Text="Add" OnClick="InsertToy" />
            </td>
        </tr>
    </table>

    <br />
    <a href="#title" class="label-info">Back to top </a>

    <br />

</asp:Content>
