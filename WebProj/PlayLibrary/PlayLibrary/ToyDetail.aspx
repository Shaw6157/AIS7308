<%@ Page Title="" Language="C#" MasterPageFile="~/Main.Master" AutoEventWireup="true" CodeBehind="ToyDetail.aspx.cs" Inherits="PlayLibrary.ToyDetail" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

    <asp:Label Text="Message" runat="server" ID="lblMessage"/>

    <asp:FormView ID="FormView" runat="server" AutoGenerateRows="False" DataSourceID="DB_Toy_detail">
        <ItemTemplate>
            <!--Product -->
            <section class="m-t-0 p-b-40">
                    <div class="thumb p-30">
                        <div class="row">
                            <!-- Product image gallery -->
                            <div class="col-sm-6 col-md-7" style="width: 40%">
                                <ul class="thumbnails p-0">
                                    <li>
                                        <a class="thumbnail img-large image-zoom" href='<%# Eval("imgSource") %>' title='<%# Eval("toyname") %>'>
                                            <img src='<%# Eval("imgSource") %>' alt='<%# Eval("toyname") %>'>
                                        </a>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                                </ul>
                            </div>
                            <!-- Product decr -->
                            <div class="col-sm-6 col-md-5">
                                <div class="product-pare m-t-xs-60">
                                    <h1><%# Eval("toyname") %></h1>
                                    <ul class="list-unstyled">
                                        <li><span>Product ID:</span> IT000<%# Eval("toyID") %></li>
                                        <li><span>Best for:</span> <%# Eval("type") %></li>
                                        <li><span>Made in:</span> <%# Eval("madein") %></li>
                                        <li><span>Availability:</span> In Stock</li>
                                        <li><span>RRP:</span> <%# Eval("price") %></li>
                                    </ul>
                                    <p class="product-price">$<%# String.Format("{0:0.00}", Convert.ToDecimal(Eval("price")) * Convert.ToDecimal(Eval("pricedisc")))  %></p>
                                    <div class="quantily-wrap">
                                        <label class="control-label" for="input-quantity">Qty</label>
                                        <asp:TextBox runat="server" value="1" ID="txtQuantity" CssClass="form-control form-item" TextMode="Number" />
                                    </div>
                                    <asp:Button Text="Add to Cart" runat="server" OnClick="btnAddToCart" class="btn ht-btn ht-btn-3x bg-4 m-t-0" />
                                    <a href="MyCart.aspx" style="text-decoration: underline;">Check my Cart</a>
                                    <div class="m-t-30">
                                    </div>
                                </div>
                            </div>
                        <!-- End row -->
                    </div>

                    <hr width="80%" />
                    <!-- Tabs -->
                    <div class="ht-tabs m-t-60">
                        <!-- Tab panes -->

                        <h3 class="title">Toy Description</h3>
                        <div class="tab-content thumb p-30">
                            <div role="tabpanel" class="tab-pane active" id="tab-description">
                                <%# Eval("toydesc") %>
                            </div>
                        </div>
                    </div>
                    <!-- End tabs -->
                </div>
            </section>

            <hr width="80%" />
            <!-- Product relaed -->
            <section class="m-b-50">
                    <div class="thumb p-30 p-b-0">
                        <h3 class="title">Product Related</h3>
                        <div class="row">
                            <div class="col-sm-6 col-md-4 col-lg-3">
                                <!-- Product item -->
                                <div class="product-item hover-img">
                                    <iframe width="230"
                                        src="https://www.youtube.com/embed/cfEQxoQyG_s"
                                        frameborder="0"
                                        allowfullscreen></iframe>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-4 col-lg-3">
                                <!-- Product item -->
                                <div class="product-item hover-img">

                                    <iframe width="230"
                                        src="https://www.youtube.com/embed/oMTUeKV3yPo"
                                        frameborder="0"
                                        allowfullscreen></iframe>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-4 col-lg-3">
                                <!-- Product item -->
                                <div class="product-item hover-img">
                                    <iframe width="230"
                                        src="https://www.youtube.com/embed/-KktLWiGZg4"
                                        frameborder="0"
                                        allowfullscreen></iframe>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-4 col-lg-3">
                                <!-- Product item -->
                                <div class="product-item hover-img">
                                    <iframe width="230"
                                        src="https://www.youtube.com/embed/irgWNfuIUdE"
                                        frameborder="0"
                                        allowfullscreen></iframe>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </ItemTemplate>
    </asp:FormView>
    <asp:SqlDataSource ID="DB_Toy_detail" runat="server" ConnectionString="<%$ ConnectionStrings:dbSOFT703ConnectionString %>" SelectCommand="SELECT * FROM [tblToy] WHERE ([toyID] = @toyID)">
        <SelectParameters>
            <asp:QueryStringParameter DefaultValue="1" Name="toyID" QueryStringField="toyID" Type="Int32" />
        </SelectParameters>
    </asp:SqlDataSource>
</asp:Content>
