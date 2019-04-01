<%@ Page Title="" Language="C#" MasterPageFile="~/YellowMotorSite.Master" AutoEventWireup="true" CodeBehind="Login.aspx.cs" Inherits="MT_YellowMotor.WebForm3" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <link href="StyleSheet.css" rel="stylesheet" />
    <table class="auto-style1">
        <tr>
            <td colspan="3">
                <h1>User&nbsp;Login</h1></td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="lblUID" CssClass="labelReg" runat="server" Text="User ID"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtUID" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:RequiredFieldValidator CssClass="validation" ID="RequiredFieldValidator1" runat="server" ControlToValidate="txtUID" ErrorMessage="Please Enter Your user ID"></asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="lblPassword" CssClass="labelReg" runat="server" Text="Password"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtPassword" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:RequiredFieldValidator CssClass="validation" ID="RequiredFieldValidator2" runat="server" ControlToValidate="txtPassword" ErrorMessage="Please Enter Your password"></asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td>
                <asp:Button ID="btnLogin" runat="server" OnClick="btnLogin_Click" Text="Login" />
            </td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </table>
    <br/>
    <asp:Label ID="lblMessage" runat="server" CssClass="msgLogin" Text="message" Visible="False"></asp:Label>
    <br/>
</asp:Content>
