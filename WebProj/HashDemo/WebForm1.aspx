<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="HashDemo.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style2 {
            width: 259px;
        }
        .auto-style3 {
            width: 259px;
            height: 31px;
        }
        .auto-style4 {
            height: 31px;
        }
        .auto-style5 {
            width: 282px;
        }
        .auto-style6 {
            height: 31px;
            width: 282px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <table align="center" class="auto-style1">
                <tr>
                    <td class="auto-style2">Enter User ID</td>
                    <td class="auto-style5">
                        <asp:TextBox ID="txtUID" runat="server"></asp:TextBox>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2">Password</td>
                    <td class="auto-style5">
                        <asp:TextBox ID="txtPassword" runat="server"></asp:TextBox>
                    </td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style2">
                        <asp:Button ID="btnSave" runat="server" Text="Save" OnClick="btnSave_Click" />
                    </td>
                    <td class="auto-style5">&nbsp;</td>
                    <td>&nbsp;</td>
                </tr>
                <tr>
                    <td class="auto-style3">MD5</td>
                    <td class="auto-style6">
                        <asp:Label ID="lblMD5" runat="server" Text="Label"></asp:Label>
                    </td>
                    <td class="auto-style4">
                        <asp:Label ID="lblMD6" runat="server" Text="Label"></asp:Label>
                    </td>
                </tr>
                <tr>
                    <td class="auto-style2">SHA1</td>
                    <td class="auto-style5">
                        <asp:Label ID="lblSHA1" runat="server" Text="Label"></asp:Label>
                    </td>
                    <td>
                        <asp:Label ID="lblSHA2" runat="server" Text="Label"></asp:Label>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
