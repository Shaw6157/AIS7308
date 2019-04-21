<%@ Page Title="" Language="C#" MasterPageFile="~/Main.Master" AutoEventWireup="true" CodeBehind="MyCart.aspx.cs" Inherits="PlayLibrary.MyCart" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">


    <!-- Product cart -->
    <section class="m-t-0">
        <div class="container">
            <div class="thumb p-30">
                <div class="table-responsive">
                    <h3 class="title">Shopping cart</h3>

                    <asp:GridView ID="GridViewCart" runat="server" AutoGenerateColumns="False" ShowHeaderWhenEmpty="True"
                        EmptyDataText="No Toys added..." GridLines="both" CssClass="gv table table-bordered" EmptyDataRowStyle-ForeColor="Red">
                        <Columns>
                            <asp:TemplateField HeaderText="Toy" HeaderStyle-CssClass="text-white bg-danger table-heading">
                                <ItemTemplate>
                                    <asp:Image ID="imgToy" ImageUrl='<%#Eval("ImgSource") %>' runat="server" Width="70" />
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:TemplateField HeaderText="Toy Name" HeaderStyle-CssClass="text-white bg-danger table-heading">
                                <ItemTemplate>
                                    <asp:Label ID="lblToyName" runat="server" Text='<%#Eval("Toyname") %>' CssClass="table-content"></asp:Label>
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:TemplateField HeaderText="Quantity" HeaderStyle-CssClass="text-white bg-danger table-heading">
                                <ItemTemplate>
                                    <asp:Label ID="lblToyQuan" runat="server" Text='<%#Eval("Quantity") %>' CssClass="table-content"></asp:Label>
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:TemplateField HeaderText="Value" HeaderStyle-CssClass="text-white bg-danger">
                                <ItemTemplate>
                                    <asp:Label ID="lblToyPrice" runat="server" Text='<%# Eval("Amount") %>'></asp:Label>
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:TemplateField HeaderText="Action" HeaderStyle-CssClass="text-white bg-danger">
                                <ItemTemplate>
                                    <asp:Button ID="btnEdit" runat="server" Text="Edit" OnClick="Edit_Click" CssClass="btn btn-warning btn-sm" CausesValidation="False" />
                                    <asp:Button ID="btnDel" runat="server" Text="Remove" OnClick="Del_Click" CssClass="btn btn-warning btn-sm" CausesValidation="False" />
                                    <asp:Label ID="lblToyID" runat="server" Text='<%#Eval("Toyid") %>' Visible="false"></asp:Label>
                                </ItemTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                    <%--<input type="hidden" runat="server" id="CToyID" />--%>

                    <asp:Label ID="CToyID" Text="0" runat="server" Visible="false" />

                    
                    <div>
                        <asp:Label ID="lblQuan" Text="Toy Quantity:" runat="server" Visible="false" />
                        <asp:TextBox ID="txtQuan" runat="server" class="form-control" Width="100" Visible="false"></asp:TextBox>
                        <asp:Button ID="btnUpdate" runat="server" Text="Update" OnClick="Update_Click" Visible="false" class="btn btn-danger" />
                    </div>


                    <%--                <div class="table-div">
                    <div class="row m-0 table-heading">
                        <div class="col col-xs-1"><strong>Image</strong></div>
                        <div class="col col-xs-3"><strong>Product Name</strong></div>
                        <div class="col col-xs-2"><strong>Quantity</strong></div>
                        <div class="col col-xs-2"><strong>Unit Price</strong></div>
                        <div class="col col-xs-2"><strong>Total</strong></div>
                    </div>
                    <div class="row m-0 table-content">
                        <div class="col col-xs-1">
                            <a href="#">
                                <img src="Images/sp3.jpg" width="70" alt="Train" title="train"></a>
                        </div>
                        <div class="col col-xs-3">
                            <a href="#">Train</a>
                        </div>
                        <div class="col col-xs-2">
                            <div class="input-group btn-block">
                                <input type="number" value="1" size="1" class="form-control form-item">
                            </div>
                        </div>
                        <div class="col col-xs-2">$35.00</div>
                        <div class="col col-xs-2">$35.00</div>
                    </div>
                    <!--end row-->
                    <div class="row m-0 table-content">
                        <div class="col col-xs-1">
                            <a href="#">
                                <img src="Images/sp7.jpg" width="70" alt="Bricks" title="Bricks"></a>
                        </div>
                        <div class="col col-xs-3">
                            <a href="#">Bricks</a>
                        </div>
                        <div class="col col-xs-2">
                            <div class="input-group btn-block">
                                <input type="number" value="1" size="1" class="form-control form-item">
                            </div>
                        </div>
                        <div class="col col-xs-2">$19.99</div>
                        <div class="col col-xs-2">$19.99</div>
                    </div>
                    <!--end row-->
                    <div class="row m-0 table-content">
                        <div class="col col-xs-1">
                            <a href="#">
                                <img src="Images/sp5.jpg" width="70" alt="Lego" title="Lego"></a>
                        </div>
                        <div class="col col-xs-3">
                            <a href="#">Lego</a>
                        </div>
                        <div class="col col-xs-2">
                            <div class="input-group btn-block">
                                <input type="number" value="1" size="1" class="form-control form-item">
                            </div>
                        </div>
                        <div class="col col-xs-2">$45.50</div>
                        <div class="col col-xs-2">$45.50</div>
                    </div>
                    <!--end row-->
                </div>
            </div>--%>

                    <div class="row m-t-30">
                        <div class="col-sm-5 pull-right p-r-60">
                            <div class="total table-div">
                                <ul class="table-content">
                                    <li class="row m-0">
                                        <div class="col col-sm-6">
                                            <strong>Items:</strong>
                                        </div>
                                        <div class="col col-sm-6">
                                            <asp:Label ID="allquan" Text="0" runat="server" />
                                        </div>
                                    </li>
                                    <li class="row m-0">
                                        <div class="col col-sm-6">
                                            <strong>Total:</strong>
                                        </div>
                                        <div class="col col-sm-6">
                                            <asp:Label ID="allamount" Text="$ 0.0" runat="server" />
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div class="buttons clearfix m-t-30">
                        <div class="pull-left">
                            <a href="ToyList.aspx" class="btn ht-btn bg-1">Continue Shopping</a>


                        </div>
                        <div class="pull-right p-r-60"><a href="#" class="btn ht-btn bg-3">Checkout</a></div>
                    </div>
                </div>
            </div>
    </section>


</asp:Content>
