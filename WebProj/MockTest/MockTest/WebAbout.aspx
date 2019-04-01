<%@ Page Title="" Language="C#" MasterPageFile="~/MyTestSite.Master" AutoEventWireup="true" CodeBehind="WebAbout.aspx.cs" Inherits="MockTest.WebForm4" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <link href="StyleSheet1.css" rel="stylesheet" />
    <asp:Button ID="Button1" runat="server" Text="Button" CssClass="input" />



    <asp:TextBox ID="TextBox1" runat="server">mm/dd/yyyy</asp:TextBox>
    <asp:RequiredFieldValidator ID="RequiredFieldValidator1" ControlToValidate="TextBox1" runat="server" InitialValue="mm/dd/yyyy" ErrorMessage="RequiredFieldValidator" Font-Size="X-Large"></asp:RequiredFieldValidator>



</asp:Content>
