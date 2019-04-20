<%@ Page Title="" Language="C#" MasterPageFile="~/Main.Master" AutoEventWireup="true" CodeBehind="UserRegistration.aspx.cs" Inherits="PlayLibrary.UserReg" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    
    <div class="thumb p-60">
        <div id="content">
            <div class="row">
                <div class="col-sm-12 col-md-6 col-md-offset-3">
                    <h3 class="title">Registration</h3>
                        <div class="form-group">
                            <asp:Label class="control-label f-normal" ID="lblUsername" runat="server" Text="Email" />
                            <asp:TextBox class="form-control form-item" ID="txtUserID" runat="server"></asp:TextBox>

                        </div>
                        <div class="form-group m-t-15">
                            <asp:Label class="control-label f-normal" ID="lblPassword" runat="server" Text="Name" />
                            <asp:TextBox class="form-control form-item" ID="txtUserName" runat="server"></asp:TextBox>
                        </div>
                        <div class="form-group m-t-15">
                            <asp:Label class="control-label f-normal" ID="Label1" runat="server" Text="Password" />
                            <asp:TextBox class="form-control form-item" ID="txtPassword" runat="server" TextMode="Password"></asp:TextBox>
                        </div>
                        <div class="form-group m-t-15">
                            <asp:Label class="control-label f-normal" ID="Label6" runat="server" Text="Confirm Password" />
                            <asp:TextBox class="form-control form-item" ID="txtConfirmPassword" runat="server" TextMode="Password"></asp:TextBox>
                        </div>
                        <p><asp:Label class="label-warning" ID="lblMessage" runat="server"><strong></strong></asp:Label></p>
                        <asp:Button ID="btnReg" runat="server" class="btn ht-btn bg-4 m-t-10" Text="Sign Up" OnClick="BtnRegistration" />

                </div>
            </div>
        </div>
    </div>
</asp:Content>
