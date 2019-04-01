<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ContactUs.aspx.cs" Inherits="ASPdemo_empty2.ContactUs" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            Simple calculator<br />
            <br />
            Enter Number1<input id="txt1" type="text" /><br />
            <br />
            Enter Number2<input id="txt2" type="text" /><br />
            <input id="Button1" type="button" value="button" /><br />
        </div>
        <asp:Button ID="Button2" runat="server" OnClick="Button2_Click" Text="Button" />
    </form>
    <p>
        &nbsp;</p>
</body>
</html>
