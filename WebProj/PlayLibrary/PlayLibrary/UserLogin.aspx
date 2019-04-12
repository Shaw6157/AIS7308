<%@ Page Title="" Language="C#" MasterPageFile="~/Main.Master" AutoEventWireup="true" CodeBehind="UserLogin.aspx.cs" Inherits="PlayLibrary.AdminLogin" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="thumb p-60">
        <div id="content">
            <div class="row">
                <div class="col-sm-12 col-md-6 col-md-offset-3">
                    <h3 class="title">PlayLibrary User Login</h3>
                        <div class="form-group">
                            <asp:Label class="control-label f-normal" ID="lblUsername" runat="server" Text="Username" />
                            <asp:TextBox class="form-control form-item" ID="txtUsername" runat="server"></asp:TextBox>

                        </div>
                        <div class="form-group m-t-15">
                            <asp:Label class="control-label f-normal" ID="lblPassword" runat="server" Text="Password" />
                            <asp:TextBox class="form-control form-item" ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
                        </div>
                        <p><asp:Label class="label-warning" ID="lblMsg" runat="server"><strong></strong></asp:Label></p>
                        <asp:Button ID="btnLogin" runat="server" class="btn ht-btn bg-4 m-t-10" Text="Login" OnClick="UserLogin" />

                    <a href="UserPassword.aspx">Fogot Password?</a>
                </div>
            </div>
        </div>
    </div>

</asp:Content>
