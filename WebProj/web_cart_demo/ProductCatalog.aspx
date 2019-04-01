<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="ProductCatalog.aspx.cs" Inherits="web_cart_demo.ProductCatalog" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
        </div>
        <asp:GridView ID="DataGrid1" runat="server" OnSelectedIndexChanged="DataGrid1_SelectedIndexChanged1">
        </asp:GridView>
    </form>
</body>
</html>
