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

    <div class="thumb p-60">
        <div id="content_checkout"   runat="server" >
            <div class="row">
                <div class="col-sm-12 col-md-6 col-md-offset-3">
                    <h3 class="title">Checkout Details</h3>
                        <div class="form-group">
                            <asp:Label class="control-label f-normal" ID="lblName" runat="server" Text="Name" />
                            <asp:TextBox class="form-control form-item" ID="txtName" runat="server"></asp:TextBox>

                        </div>
                        <div class="form-group m-t-15">
                            <asp:Label class="control-label f-normal" ID="lblNo" runat="server" Text="Contact Number" />
                            <asp:TextBox class="form-control form-item" ID="txtNo" runat="server"></asp:TextBox>
                        </div>
                        <div class="form-group m-t-15">
                            <asp:Label class="control-label f-normal" ID="lblAddr" runat="server" Text="Delivery Address" />
                            <asp:TextBox class="form-control form-item" ID="txtAddr" runat="server"></asp:TextBox>
                        </div>
                        <p><asp:Label class="label-warning" ID="lblMsg" runat="server" Visible="false"><strong></strong></asp:Label></p>
                </div>
            </div>
        </div>
    </div>

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
                        <div class="pull-right p-r-60">
                            <asp:Button ID="Button1" runat="server" Text="Checkout" OnClick="Checkout" />
                        </div>
                    </div>
                </div>
            </div>
    </section>


</asp:Content>
