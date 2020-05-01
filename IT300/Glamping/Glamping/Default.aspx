<%@ Page Title="Home Page" Language="VB" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="Default.aspx.vb" Inherits="Glamping._Default" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <div class="jumbotron">
        <asp:Image ID="Image1" runat="server" ImageUrl="http://delgraphics.delmarlearning.com/CourseTechnology/tents.jpg" AlternateText="picture of tents" Height="150px" Width="175px" />
        <h1 style="display: inline-block; vertical-align: top; padding: 10px">Enjoy a Luxury Camping Experience</h1>
        <p class="lead">Nestled in the mountain woods surrounded by the Moonbeam Mountians, our glamping retreat provides modern comfort with the genuine resort elegance, offering the sights and sounds of nature.</p>
        <p><a href="http://www.asp.net" class="btn btn-primary btn-lg">Learn more &raquo;</a></p>
    </div>
</asp:Content>
