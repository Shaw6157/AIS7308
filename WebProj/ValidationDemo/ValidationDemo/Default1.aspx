<%@ Page Language="C#" %>

<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta charset="utf-8" />
    <title></title>    
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }
        .auto-style2 {
            height: 31px;
        }
        .auto-style3 {
            width: 314px;
        }
        .auto-style4 {
            width: 24px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">   
        AIS Enrollment Form<br />
        <table class="auto-style1">
            <tr>
                <td colspan="6" class="auto-style2">B PERSONAL DETAILS</td>
            </tr>
            <tr>
                <td class="auto-style4">1</td>
                <td class="auto-style3">Family or Surname</td>
                <td class="auto-style3">
                    <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
                </td>
                <td>2</td>
                <td class="auto-style3">&nbsp;</td>
                <td>
                    <asp:TextBox ID="TextBox2" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style4">3</td>
                <td class="auto-style3">Date of birth (DD/MM/YYYY)</td>
                <td class="auto-style3">
                    <asp:TextBox ID="TextBox3" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style4">4</td>
                <td class="auto-style3">Gender</td>
                <td>
                    <asp:RadioButton ID="RadioButton1" runat="server" />
                </td>
            </tr>
            <tr>
                <td class="auto-style4">5</td>
                <td class="auto-style3">Home Address</td>
                <td class="auto-style3">
                    <asp:TextBox ID="TextBox4" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style4">6</td>
                <td class="auto-style3">Mail Address (if different)</td>
                <td>
                    <asp:TextBox ID="TextBox7" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td class="auto-style3">
                    <asp:TextBox ID="TextBox5" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td>
                    <asp:TextBox ID="TextBox8" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td class="auto-style3">
                    <asp:TextBox ID="TextBox6" runat="server"></asp:TextBox>
                </td>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td>
                    <asp:TextBox ID="TextBox9" runat="server"></asp:TextBox>
                </td>
            </tr>
            <tr>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
            <tr>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td class="auto-style4">&nbsp;</td>
                <td class="auto-style3">&nbsp;</td>
                <td>&nbsp;</td>
            </tr>
        </table>

    </form>
</body>
</html>
