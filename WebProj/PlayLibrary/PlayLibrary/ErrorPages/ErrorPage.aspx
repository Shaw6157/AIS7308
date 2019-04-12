<%@ Page Title="" Language="C#" MasterPageFile="~/Main.Master" AutoEventWireup="true" CodeBehind="ErrorPage.aspx.cs" Inherits="PlayLibrary.ErrorPage" %>

<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <h3 class="title">
        <asp:image id="Image1" runat="server" imageurl="~/Images/error.png" width="50" /> &nbsp
        An Error Has Occurred!</h3>
    <div class="tab-content thumb p-30">
        <div role="tabpanel" class="tab-pane active" id="tab-description">
            An unexpected error occurred on our website. 
            
        </div>
        <a href="/Home.aspx" class="ui-state-focus">Return to the homepage</a>
    </div>
</asp:Content>
