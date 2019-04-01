<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="WebRegister.aspx.cs" Inherits="CookieDemo.WebForm2" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table class="auto-style1">
        <tr>
            <td style="width: 280px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 280px">First Name</td>
            <td>
                <asp:TextBox ID="txtFirstname" runat="server"></asp:TextBox>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 280px">Last Name</td>
            <td>
                <asp:TextBox ID="txtLastname" runat="server"></asp:TextBox>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 280px">User ID</td>
            <td>
                <asp:TextBox ID="txtuid" runat="server"></asp:TextBox>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 280px; height: 33px">password</td>
            <td style="height: 33px">
                <asp:TextBox ID="txtpwd" runat="server"></asp:TextBox>
            </td>
            <td style="height: 33px"></td>
        </tr>
        <tr>
            <td style="width: 280px">confirm password</td>
            <td>
                <asp:TextBox ID="txtpwd2" runat="server"></asp:TextBox>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 280px">&nbsp;</td>
            <td>
                <asp:Button ID="btnsave" runat="server" OnClick="Button_Save" Text="Save" />
                <asp:Button ID="btncancel" runat="server" OnClick="Button_Cancel" Text="Cancel" />
            </td>
            <td>&nbsp;</td>
        </tr>
    </table>
</asp:Content>
