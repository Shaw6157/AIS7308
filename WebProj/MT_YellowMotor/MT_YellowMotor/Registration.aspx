<%@ Page Title="" Language="C#" MasterPageFile="~/YellowMotorSite.Master" AutoEventWireup="true" CodeBehind="Registration.aspx.cs" Inherits="MT_YellowMotor.WebForm1" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <link href="StyleSheet.css" rel="stylesheet" />
    <table class="auto-style1">
        <tr>
            <td colspan="3">
                <h1>User Registeration</h1></td>
        </tr>
        <tr>
            <td>
                <asp:Label CssClass="labelReg" ID="lblUserID" runat="server" Text="User ID" Width="100%"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtUserID" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:RequiredFieldValidator ID="RequiredFieldValidator1" ControlToValidate="txtUserID" runat="server" CssClass="validation" ErrorMessage="Please Enter User ID"></asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td>
                <asp:Label CssClass="labelReg" ID="lblName" runat="server" Text="Name" Width="100%"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtName" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:RequiredFieldValidator ID="RequiredFieldValidator2" ControlToValidate="txtName" runat="server" CssClass="validation" ErrorMessage="Please Enter Your Name"></asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="lblPassword" runat="server" CssClass="labelReg" Width="100%" Text="Password"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtPassword" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:RequiredFieldValidator ID="RequiredFieldValidator3" ControlToValidate="txtPassword" runat="server" CssClass="validation" ErrorMessage="Please Enter Your Password"></asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="lblConfirmPasssword" runat="server" CssClass="labelReg" Width="100%" Text="Confirm Password"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtConfirmPasssword" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:RequiredFieldValidator ID="RequiredFieldValidator4" ControlToValidate="txtConfirmPasssword" runat="server" CssClass="validation" ErrorMessage="Please Enter Confirm Password"></asp:RequiredFieldValidator>
                <asp:CompareValidator ID="CompareValidator1" runat="server" ControlToValidate="txtConfirmPasssword" CssClass="validation" ErrorMessage="The confirm Password is different" ControlToCompare="txtPassword"></asp:CompareValidator>
            </td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="lblCountry" runat="server" CssClass="labelReg" Width="100%" Text="country"></asp:Label>
            </td>
            <td>
                
                <asp:DropDownList ID="ddlCountry" runat="server" Width="200px">
                </asp:DropDownList>
                
            </td>
            <td>
                <asp:RequiredFieldValidator ID="RequiredFieldValidator5" ControlToValidate="ddlCountry" runat="server" CssClass="validation" ErrorMessage="Select Your Country"></asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr>
            <td>
                <asp:Label ID="lblEmail" runat="server" CssClass="labelReg" Width="100%" Text="Email Address"></asp:Label>
            </td>
            <td>
                <asp:TextBox ID="txtEmail" runat="server"></asp:TextBox>
            </td>
            <td>
                <asp:RequiredFieldValidator ID="RequiredFieldValidator6" ControlToValidate="txtEmail" runat="server" CssClass="validation" ErrorMessage="Enter Your Email"></asp:RequiredFieldValidator>
                <asp:RegularExpressionValidator ID="RegularExpressionValidator1" runat="server" ControlToValidate="txtEmail" CssClass="validation" ErrorMessage="Please type right email address!!" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
            </td>
        </tr>
        <tr>
            <td>
                &nbsp;</td>
            <td>
                <asp:Button ID="btnSave" runat="server" Text="Save" OnClick="btnSave_Click" />
                
            </td>
            <td>&nbsp;</td>
        </tr>
    </table>
    <br />
    <asp:ValidationSummary ID="ValidationSummary1" runat="server" CssClass="validation" />
    <br />
</asp:Content>
