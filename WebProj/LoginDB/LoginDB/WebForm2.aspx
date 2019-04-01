<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm2.aspx.cs" Inherits="LoginDB.WebForm2" %>

<%@ Register assembly="System.Web.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35" namespace="System.Web.UI.DataVisualization.Charting" tagprefix="asp" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            sdfsdfsdf
        </div>
        
        <div>   

            <asp:DropDownList ID="DropDownList1" runat="server" DataSourceID="SqlType" DataTextField="menuType" DataValueField="menuType">
            </asp:DropDownList>
            <asp:SqlDataSource ID="SqlType" runat="server" ConnectionString="<%$ ConnectionStrings:dbMyRestaurantConnectionString %>" SelectCommand="SELECT DISTINCT [menuType] FROM [tblMenu]"></asp:SqlDataSource>

        </div>
        
        <asp:GridView ID="GridView1" runat="server" AutoGenerateColumns="False" DataSourceID="SqlDataSource1" CellPadding="4" ForeColor="#333333" GridLines="None">
            <AlternatingRowStyle BackColor="White" />
            <Columns>
                <asp:BoundField DataField="menuID" HeaderText="menuID" SortExpression="menuID" />
                <asp:BoundField DataField="menuName" HeaderText="menuName" SortExpression="menuName" />
                <asp:BoundField DataField="menuDescription" HeaderText="menuDescription" SortExpression="menuDescription" />
                <asp:BoundField DataField="menuImage" HeaderText="menuImage" SortExpression="menuImage" />
                <asp:BoundField DataField="menuPrice" HeaderText="menuPrice" SortExpression="menuPrice" />
                <asp:BoundField DataField="menuType" HeaderText="menuType" SortExpression="menuType" />
            </Columns>
            <FooterStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
            <HeaderStyle BackColor="#990000" Font-Bold="True" ForeColor="White" />
            <PagerStyle BackColor="#FFCC66" ForeColor="#333333" HorizontalAlign="Center" />
            <RowStyle BackColor="#FFFBD6" ForeColor="#333333" />
            <SelectedRowStyle BackColor="#FFCC66" Font-Bold="True" ForeColor="Navy" />
            <SortedAscendingCellStyle BackColor="#FDF5AC" />
            <SortedAscendingHeaderStyle BackColor="#4D0000" />
            <SortedDescendingCellStyle BackColor="#FCF6C0" />
            <SortedDescendingHeaderStyle BackColor="#820000" />
        </asp:GridView>
        <asp:SqlDataSource ID="SqlDataSource1" runat="server" ConnectionString="<%$ ConnectionStrings:dbMyRestaurantConnectionString %>" SelectCommand="SELECT * FROM [tblMenu] WHERE ([menuType] = @menuType)">
            <SelectParameters>
                <asp:ControlParameter ControlID="DropDownList1" Name="menuType" PropertyName="SelectedValue" Type="String" />
            </SelectParameters>
        </asp:SqlDataSource>
        <asp:ListView ID="ListView1" runat="server" DataSourceID="SqlDataSource1" GroupItemCount="3">
            <AlternatingItemTemplate>
                <td runat="server" style="background-color: #FFFFFF;color: #284775;">menuID:
                    <asp:Label ID="menuIDLabel" runat="server" Text='<%# Eval("menuID") %>' />
                    <br />menuName:
                    <asp:Label ID="menuNameLabel" runat="server" Text='<%# Eval("menuName") %>' />
                    <br />menuDescription:
                    <asp:Label ID="menuDescriptionLabel" runat="server" Text='<%# Eval("menuDescription") %>' />
                    <br />menuImage:
                    <asp:Label ID="menuImageLabel" runat="server" Text='<%# Eval("menuImage") %>' />
                    <br />menuPrice:
                    <asp:Label ID="menuPriceLabel" runat="server" Text='<%# Eval("menuPrice") %>' />
                    <br />menuType:
                    <asp:Label ID="menuTypeLabel" runat="server" Text='<%# Eval("menuType") %>' />
                    <br /></td>
            </AlternatingItemTemplate>
            <EditItemTemplate>
                <td runat="server" style="background-color: #999999;">menuID:
                    <asp:TextBox ID="menuIDTextBox" runat="server" Text='<%# Bind("menuID") %>' />
                    <br />menuName:
                    <asp:TextBox ID="menuNameTextBox" runat="server" Text='<%# Bind("menuName") %>' />
                    <br />menuDescription:
                    <asp:TextBox ID="menuDescriptionTextBox" runat="server" Text='<%# Bind("menuDescription") %>' />
                    <br />menuImage:
                    <asp:TextBox ID="menuImageTextBox" runat="server" Text='<%# Bind("menuImage") %>' />
                    <br />menuPrice:
                    <asp:TextBox ID="menuPriceTextBox" runat="server" Text='<%# Bind("menuPrice") %>' />
                    <br />menuType:
                    <asp:TextBox ID="menuTypeTextBox" runat="server" Text='<%# Bind("menuType") %>' />
                    <br />
                    <asp:Button ID="UpdateButton" runat="server" CommandName="Update" Text="Update" />
                    <br />
                    <asp:Button ID="CancelButton" runat="server" CommandName="Cancel" Text="Cancel" />
                    <br /></td>
            </EditItemTemplate>
            <EmptyDataTemplate>
                <table runat="server" style="background-color: #FFFFFF;border-collapse: collapse;border-color: #999999;border-style:none;border-width:1px;">
                    <tr>
                        <td>No data was returned.</td>
                    </tr>
                </table>
            </EmptyDataTemplate>
            <EmptyItemTemplate>
<td runat="server" />
            </EmptyItemTemplate>
            <GroupTemplate>
                <tr id="itemPlaceholderContainer" runat="server">
                    <td id="itemPlaceholder" runat="server"></td>
                </tr>
            </GroupTemplate>
            <InsertItemTemplate>
                <td runat="server" style="">menuID:
                    <asp:TextBox ID="menuIDTextBox" runat="server" Text='<%# Bind("menuID") %>' />
                    <br />menuName:
                    <asp:TextBox ID="menuNameTextBox" runat="server" Text='<%# Bind("menuName") %>' />
                    <br />menuDescription:
                    <asp:TextBox ID="menuDescriptionTextBox" runat="server" Text='<%# Bind("menuDescription") %>' />
                    <br />menuImage:
                    <asp:TextBox ID="menuImageTextBox" runat="server" Text='<%# Bind("menuImage") %>' />
                    <br />menuPrice:
                    <asp:TextBox ID="menuPriceTextBox" runat="server" Text='<%# Bind("menuPrice") %>' />
                    <br />menuType:
                    <asp:TextBox ID="menuTypeTextBox" runat="server" Text='<%# Bind("menuType") %>' />
                    <br />
                    <asp:Button ID="InsertButton" runat="server" CommandName="Insert" Text="Insert" />
                    <br />
                    <asp:Button ID="CancelButton" runat="server" CommandName="Cancel" Text="Clear" />
                    <br /></td>
            </InsertItemTemplate>
            <ItemTemplate>
                <td runat="server" style="background-color: #E0FFFF;color: #333333;">menuID:
                
                    <asp:Label ID="menuNameLabel" runat="server" Text='<%# Eval("menuName") %>' />

                    <asp:Image ID="Image" runat="server" ImageUrl='<%# Eval("menuImage") %>' />
                    <asp:Label ID="menuImageLabel" runat="server" Text='<%# Eval("menuImage") %>' />
 <br /></td>
            </ItemTemplate>
            <LayoutTemplate>
                <table runat="server">
                    <tr runat="server">
                        <td runat="server">
                            <table id="groupPlaceholderContainer" runat="server" border="1" style="background-color: #FFFFFF;border-collapse: collapse;border-color: #999999;border-style:none;border-width:1px;font-family: Verdana, Arial, Helvetica, sans-serif;">
                                <tr id="groupPlaceholder" runat="server">
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <tr runat="server">
                        <td runat="server" style="text-align: center;background-color: #5D7B9D;font-family: Verdana, Arial, Helvetica, sans-serif;color: #FFFFFF"></td>
                    </tr>
                </table>
            </LayoutTemplate>
            <SelectedItemTemplate>
                <td runat="server" style="background-color: #E2DED6;font-weight: bold;color: #333333;">menuID:

                    <asp:Label ID="menuNameLabel" runat="server" Text='<%# Eval("menuName") %>' />

                    <asp:Image ID="Image" runat="server" source='<%# Eval("menuImage") %>' />
                    <asp:Label ID="menuImageLabel" runat="server" Text='<%# Eval("menuImage") %>' />

                    <br /></td>
            </SelectedItemTemplate>
        </asp:ListView>
        <br />
        <br />
        <asp:Image ID="Image1" runat="server" ImageUrl="~/btnNum.jpg" />
        <br />
        <br />
        <asp:DetailsView ID="DetailsView1" runat="server" AllowPaging="True" AutoGenerateRows="False" BackColor="LightGoldenrodYellow" BorderColor="Tan" BorderWidth="1px" CellPadding="2" DataSourceID="SqlDataSource2" ForeColor="Black" GridLines="None" Height="50px" OnPageIndexChanging="DetailsView1_PageIndexChanging" Width="125px">
            <AlternatingRowStyle BackColor="PaleGoldenrod" />
            <EditRowStyle BackColor="DarkSlateBlue" ForeColor="GhostWhite" />
            <Fields>
                <asp:BoundField DataField="menuID" HeaderText="menuID" SortExpression="menuID" />
                <asp:BoundField DataField="menuName" HeaderText="menuName" SortExpression="menuName" />
                <asp:BoundField DataField="menuDescription" HeaderText="menuDescription" SortExpression="menuDescription" />
                <asp:BoundField DataField="menuImage" HeaderText="menuImage" SortExpression="menuImage" />
                <asp:BoundField DataField="menuPrice" HeaderText="menuPrice" SortExpression="menuPrice" />
                <asp:BoundField DataField="menuType" HeaderText="menuType" SortExpression="menuType" />
                <asp:ButtonField ButtonType="Button" CommandName="Edit" HeaderText="Add header" ShowHeader="True" Text="Add to cart" />
            </Fields>
            <FooterStyle BackColor="Tan" />
            <HeaderStyle BackColor="Tan" Font-Bold="True" />
            <PagerStyle BackColor="PaleGoldenrod" ForeColor="DarkSlateBlue" HorizontalAlign="Center" />
        </asp:DetailsView>
        <asp:FormView ID="FormView1" runat="server" AllowPaging="True" BackColor="White" BorderColor="#336666" BorderStyle="Double" BorderWidth="3px" CellPadding="4" DataSourceID="SqlDataSource3" GridLines="Horizontal">
            <EditItemTemplate>
                menuID:
                <asp:TextBox ID="menuIDTextBox" runat="server" Text='<%# Bind("menuID") %>' />
                <br />
                menuName:
                <asp:TextBox ID="menuNameTextBox" runat="server" Text='<%# Bind("menuName") %>' />
                <br />
                menuDescription:
                <asp:TextBox ID="menuDescriptionTextBox" runat="server" Text='<%# Bind("menuDescription") %>' />
                <br />
                menuImage:
                <asp:TextBox ID="menuImageTextBox" runat="server" Text='<%# Bind("menuImage") %>' />
                <br />
                menuPrice:
                <asp:TextBox ID="menuPriceTextBox" runat="server" Text='<%# Bind("menuPrice") %>' />
                <br />
                menuType:
                <asp:TextBox ID="menuTypeTextBox" runat="server" Text='<%# Bind("menuType") %>' />
                <br />
                <asp:LinkButton ID="UpdateButton" runat="server" CausesValidation="True" CommandName="Update" Text="Update" />
                &nbsp;<asp:LinkButton ID="UpdateCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
            </EditItemTemplate>
            <EditRowStyle BackColor="#339966" Font-Bold="True" ForeColor="White" />
            <FooterStyle BackColor="White" ForeColor="#333333" />
            <HeaderStyle BackColor="#336666" Font-Bold="True" ForeColor="White" />
            <InsertItemTemplate>
                menuID:
                <asp:TextBox ID="menuIDTextBox" runat="server" Text='<%# Bind("menuID") %>' />
                <br />
                menuName:
                <asp:TextBox ID="menuNameTextBox" runat="server" Text='<%# Bind("menuName") %>' />
                <br />
                menuDescription:
                <asp:TextBox ID="menuDescriptionTextBox" runat="server" Text='<%# Bind("menuDescription") %>' />
                <br />
                menuImage:
                <asp:TextBox ID="menuImageTextBox" runat="server" Text='<%# Bind("menuImage") %>' />
                <br />
                menuPrice:
                <asp:TextBox ID="menuPriceTextBox" runat="server" Text='<%# Bind("menuPrice") %>' />
                <br />
                menuType:
                <asp:TextBox ID="menuTypeTextBox" runat="server" Text='<%# Bind("menuType") %>' />
                <br />
                <asp:LinkButton ID="InsertButton" runat="server" CausesValidation="True" CommandName="Insert" Text="Insert" />
                &nbsp;<asp:LinkButton ID="InsertCancelButton" runat="server" CausesValidation="False" CommandName="Cancel" Text="Cancel" />
            </InsertItemTemplate>
            <ItemTemplate>
                menuID:
                <asp:Label ID="menuIDLabel" runat="server" Text='<%# Bind("menuID") %>' />
                <br />
                menuName:
                <asp:Label ID="menuNameLabel" runat="server" Text='<%# Bind("menuName") %>' />
                <br />
                menuDescription:
                <asp:Label ID="menuDescriptionLabel" runat="server" Text='<%# Bind("menuDescription") %>' />
                <br />
                menuImage:
                <asp:Label ID="menuImageLabel" runat="server" Text='<%# Bind("menuImage") %>' />
                <br />
                menuPrice:
                <asp:Label ID="menuPriceLabel" runat="server" Text='<%# Bind("menuPrice") %>' />
                <br />
                menuType:
                <asp:Label ID="menuTypeLabel" runat="server" Text='<%# Bind("menuType") %>' />
                <br />

            </ItemTemplate>
            <PagerStyle BackColor="#336666" ForeColor="White" HorizontalAlign="Center" />
            <RowStyle BackColor="White" ForeColor="#333333" />
        </asp:FormView>
        <asp:SqlDataSource ID="SqlDataSource3" runat="server" ConnectionString="<%$ ConnectionStrings:dbMyRestaurantConnectionString %>" SelectCommand="SELECT * FROM [tblMenu]"></asp:SqlDataSource>
&nbsp;&nbsp;&nbsp;&nbsp;
        <asp:SqlDataSource ID="SqlDataSource2" runat="server" ConnectionString="<%$ ConnectionStrings:dbMyRestaurantConnectionString %>" SelectCommand="SELECT * FROM [tblMenu]"></asp:SqlDataSource>
        <p>
            &nbsp;</p>
        <asp:Chart ID="Chart1" runat="server">
            <series>
                <asp:Series Name="Series1">
                </asp:Series>
            </series>
            <chartareas>
                <asp:ChartArea Name="ChartArea1">
                </asp:ChartArea>
            </chartareas>
        </asp:Chart>
    </form>
    <p>
        &nbsp;</p>
</body>
</html>
