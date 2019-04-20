<%@ Page Title="" Language="C#" MasterPageFile="~/Main.Master" AutoEventWireup="true" CodeBehind="UserPassword.aspx.cs" Inherits="PlayLibrary.UserPassword" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <div class="thumb p-60">
        <div id="content">
            <div class="row">
                <div class="col-sm-12 col-md-6 col-md-offset-3">
                    <h3 class="title">Forgot Password</h3>
                        <div class="form-group">
                            <asp:Label class="control-label f-normal" ID="lblUsername" runat="server" Text="UserID" />
                            <asp:TextBox class="form-control form-item" ID="txtUserID" runat="server"></asp:TextBox>

                        </div>
                        <div class="form-group m-t-15">
                            <asp:Label class="control-label f-normal" ID="lblPassword" runat="server" Text="UserName" />
                            <asp:TextBox class="form-control form-item" ID="txtUserName" runat="server"></asp:TextBox>
                        </div>
                        <p><asp:Label class="label-warning" ID="lblMessage" runat="server"><strong></strong></asp:Label></p>
                        <asp:Button ID="btnReset" runat="server" class="btn ht-btn bg-4 m-t-10" Text="Reset" OnClick="BtnResetPwd" />

                </div>
            </div>
        </div>
    </div>
</asp:Content>
