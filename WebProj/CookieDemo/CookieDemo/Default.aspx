<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="CookieDemo.WebForm3" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <p>
        Welcome
    </p>
    <table class="auto-style1">
        <tr>
            <td>
                <asp:Label ID="Label1" runat="server" Text="Label"></asp:Label>
            </td>
            <td>
                <asp:Button ID="btnLogout" runat="server" Text="Logout" OnClick="btnLogout_Click" />
            </td>
        </tr>
        <tr>
            <td colspan="2">This is my default page</td>
        </tr>
    </table>
</asp:Content>
