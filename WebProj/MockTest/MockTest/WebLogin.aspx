<%@ Page Title="" Language="C#" MasterPageFile="~/MyTestSite.Master" AutoEventWireup="true" CodeBehind="WebLogin.aspx.cs" Inherits="MockTest.WebForm2" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <table class="auto-style1">
        <tr>
            <td align="center" colspan="3">Login Form Form</td>
        </tr>
        <tr>
            <td style="width: 194px">
                <asp:Label ID="Label1" runat="server" Text="User ID"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
                
                <asp:RequiredFieldValidator ID="RequiredFieldValidator1" ControlToValidate="TextBox1" runat="server" ErrorMessage="RequiredFieldValidator"></asp:RequiredFieldValidator>
                
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 194px">
                <asp:Label ID="Label2" runat="server" Text="Password"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 194px">
                <asp:Button ID="Button1" runat="server" Text="Button" OnClick="Button1_Click" />
            </td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </table>
</asp:Content>
