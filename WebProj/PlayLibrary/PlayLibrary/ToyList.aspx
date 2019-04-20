<%@ Page Title="" Language="C#" MasterPageFile="~/Main.Master" AutoEventWireup="true" CodeBehind="ToyList.aspx.cs" Inherits="PlayLibrary.ToyList" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

    <!-- Product list -->
        <div class="thumb p-30">
            <h3 class="title">Toys for kids</h3> 
            &nbsp &nbsp Search: <asp:TextBox ID="searchTxt" runat="server" />
            <asp:Menu ID="Menu1" runat="server" Orientation="Horizontal">
                <Items>
                    <asp:MenuItem Text="All Toys &nbsp; &nbsp; &nbsp; &nbsp;  |" Value="All Toys" NavigateUrl="ToyList.aspx"></asp:MenuItem>
                    <asp:MenuItem Text="&nbsp; &nbsp; &nbsp; &nbsp; For babys &nbsp; &nbsp; &nbsp; &nbsp; |" Value="For babys " NavigateUrl="ToyList.aspx?type=baby"></asp:MenuItem>
                    <asp:MenuItem Text="&nbsp; &nbsp; &nbsp; &nbsp; For Kids    &nbsp; &nbsp; &nbsp; &nbsp; | " Value="For kids " NavigateUrl="ToyList.aspx?type=kid"></asp:MenuItem>
                    <asp:MenuItem Text="&nbsp; &nbsp; &nbsp; &nbsp; For children &nbsp; &nbsp; &nbsp; &nbsp; |" Value="For young children " NavigateUrl="ToyList.aspx?type=children"></asp:MenuItem>
                </Items>
            </asp:Menu>


        </div>
        <div class="product-bor">
            <asp:DataList ID="DataList1" runat="server" DataSourceID="DB_Toy_List" RepeatColumns="2">
                <ItemTemplate>
                    <div class="col-md-12">
                        <!-- Product item -->
                        <div class="product-item hover-img">
                            <a href="ToyDetail.aspx?toyID=<%# Eval("toyID") %>" class="product-img">
                                <img src="<%# Eval("imgSource") %>" alt="image"></a>
                            <div class="product-caption">
                                <h4 class="product-name"><a href="#"><%# Eval("toyname") %></a></h4>
                                <div class="product-price-group">
                                    <span class="product-price"><%# String.Format("{0:0.00}", Convert.ToDecimal(Eval("price")) * Convert.ToDecimal(Eval("pricedisc"))) %></span>
                                </div>
                            </div>
                        </div>
                    </div>

                </ItemTemplate>
            </asp:DataList>
            <asp:SqlDataSource ID="DB_Toy_Type" runat="server" ConnectionString="<%$ ConnectionStrings:dbSOFT703ConnectionString %>" SelectCommand="SELECT DISTINCT [type] FROM [tblToy]">
                <SelectParameters>
                    <asp:QueryStringParameter DefaultValue="%" Name="type2" QueryStringField="type" Type="String" />
                </SelectParameters>
            </asp:SqlDataSource>
            <asp:SqlDataSource ID="DB_Toy_List" runat="server" ConnectionString="<%$ ConnectionStrings:dbSOFT703ConnectionString %>" SelectCommand="SELECT * FROM [tblToy] WHERE (([toydesc] LIKE '%' + @toydesc + '%') AND ([type] LIKE '%' + @type + '%'))">
                <SelectParameters>
                    <asp:ControlParameter ControlID="searchTxt" DefaultValue="%" Name="toydesc" PropertyName="Text" Type="String" />
                    <asp:QueryStringParameter DefaultValue="%" Name="type" QueryStringField="type" Type="String" />
                </SelectParameters>
            </asp:SqlDataSource>

        </div>
</asp:Content>
