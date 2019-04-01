<%@ Page Title="" Language="C#" MasterPageFile="~/UserSite.Master" AutoEventWireup="true" CodeBehind="FormLogin.aspx.cs" Inherits="LoginDB.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table style="width: 100%">
        <tr>
            <td colspan="3">Registration</td>
        </tr>
        <tr>
            <td style="width: 244px">FirstName</td>
            <td style="width: 238px">
                <asp:TextBox ID="txtFirstName" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:Label ID="lbmsg" runat="server" Font-Bold="True" Font-Size="X-Large" ForeColor="#FF6600" Text="Label" Visible="False"></asp:Label>
            </td>
        </tr>
        <tr>
            <td style="width: 244px">User ID</td>
            <td style="width: 238px">
                <asp:TextBox ID="txtUserID" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
            </td>
        </tr>
        <tr>
            <td style="width: 244px">Password</td>
            <td style="width: 238px">
                <asp:TextBox ID="txtPassword" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ErrorMessage="RegularExpressionValidator"></asp:RegularExpressionValidator>
            </td>
        </tr>
        <tr>
            <td style="width: 244px">Confirm Pwd</td>
            <td style="width: 238px">
                <asp:TextBox ID="txtConfirmPwd" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:HyperLink ID="HyperLink1" runat="server" NavigateUrl="~/WebForm2.aspx" Target="_blank">Form2</asp:HyperLink>
            </td>
        </tr>
        <tr>
            <td style="width: 244px">&nbsp;</td>
            <td style="width: 238px">
                <asp:Button ID="Button1" runat="server" Text="Save" OnClick="Button1_Click" />
                <asp:Button ID="Button2" runat="server" Text="Check" OnClick="Button2_Click" />
                <asp:Button ID="Button3" runat="server" OnClick="Button3_Click" Text="Button" />
            </td>
            <td>&nbsp;</td>
        </tr>
    </table>
</asp:Content>
