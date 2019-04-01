<%@ Page Title="" Language="C#" MasterPageFile="~/StudentSite.Master" AutoEventWireup="true" CodeBehind="StudentSitemap.aspx.cs" Inherits="WebStaff.WebForm4" %>
<asp:Content ID="Content1" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <p>
        <asp:TreeView ID="TreeView1" runat="server" ImageSet="WindowsHelp">
            <HoverNodeStyle Font-Underline="True" ForeColor="#6666AA" />
            <Nodes>
                <asp:TreeNode Text="AIS home" Value="AIS home">
                    <asp:TreeNode Text="IT programme" Value="IT programme">
                        <asp:TreeNode Text="GD IT" Value="GD IT"></asp:TreeNode>
                        <asp:TreeNode Text="pgd it" Value="pgd it"></asp:TreeNode>
                    </asp:TreeNode>
                    <asp:TreeNode Text="Business" Value="Business"></asp:TreeNode>
                    <asp:TreeNode Text="Hospitality" Value="Hospitality"></asp:TreeNode>
                    <asp:TreeNode Text="Tourism" Value="Tourism"></asp:TreeNode>
                    <asp:TreeNode Text="Student" Value="Student">
                        <asp:TreeNode NavigateUrl="~/StudentLogin.aspx" Text="Login" Value="Login"></asp:TreeNode>
                        <asp:TreeNode NavigateUrl="~/StudentRegister.aspx" Text="Register" Value="Register"></asp:TreeNode>
                    </asp:TreeNode>
                </asp:TreeNode>
            </Nodes>
            <NodeStyle Font-Names="Tahoma" Font-Size="8pt" ForeColor="Black" HorizontalPadding="5px" NodeSpacing="0px" VerticalPadding="1px" />
            <ParentNodeStyle Font-Bold="False" />
            <SelectedNodeStyle BackColor="#B5B5B5" Font-Underline="False" HorizontalPadding="0px" VerticalPadding="0px" />
        </asp:TreeView>
        <br />
    </p>
    <p>
    </p>
</asp:Content>
