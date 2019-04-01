<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="WebLogin.aspx.cs" Inherits="CookieDemo.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <p>
        Login</p>
    <table class="auto-style1">
        <tr>
            <td style="width: 243px">UserID</td>
            <td style="width: 380px">
                <asp:TextBox ID="txtuid" runat="server"></asp:TextBox>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 243px">password</td>
            <td style="width: 380px">
                <asp:TextBox ID="txtpwd" runat="server"></asp:TextBox>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 243px">&nbsp;</td>
            <td style="width: 380px">
                <asp:Button ID="Button1" runat="server" OnClick="Button1_Click" Text="Login" />
            </td>
            <td>&nbsp;</td>
        </tr>
    </table>
</asp:Content>
