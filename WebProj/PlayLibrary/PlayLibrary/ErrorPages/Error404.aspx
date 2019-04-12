<%@ Page Title="" Language="C#" MasterPageFile="~/Main.Master" AutoEventWireup="true" CodeBehind="Error404.aspx.cs" Inherits="PlayLibrary.Error404" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h3 class="title">
        <asp:image id="Image1" runat="server" imageurl="~/Images/error.png" width="50" /> &nbsp
        404 Error Has Occurred!</h3>
    <div class="tab-content thumb p-30">
        <div role="tabpanel" class="tab-pane active" id="tab-description">
            An unexpected error occurred on our website. 
            
        </div>
        <br/>
        Page Not Found!
        <br/>
        <br/>
        <a href="/Home.aspx" class="ui-state-focus">Return to the homepage</a>
    </div>
</asp:Content>
