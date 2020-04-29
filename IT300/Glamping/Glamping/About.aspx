<%@ Page Title="About" Language="VB" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="About.aspx.vb" Inherits="Glamping.About" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <h2><%: Title %>Guest Reservation Form<table style="width:100%;">
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Name:</td>
            <td class="modal-sm" style="width: 250px">
                <asp:TextBox ID="txtName" runat="server" Width="250px"></asp:TextBox>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Email:</td>
            <td class="modal-sm" style="width: 250px">
                <asp:TextBox ID="txtEmail" runat="server" Width="250px"></asp:TextBox>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Address:</td>
            <td class="modal-sm" style="width: 250px">&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Tent selection:</td>
            <td class="modal-sm" style="width: 250px">
                <asp:CheckBox ID="chkGrizzly" runat="server" Text="Grizzly (suite) $99" Width="250px" />
                <asp:CheckBox ID="chkPolar" runat="server" Text="Polar (deluxe plus cot) $89" Width="250px" />
                <asp:CheckBox ID="chkKodiak" runat="server" Text="Kodiak (deluxe) $79" />
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Night(s):</td>
            <td class="modal-sm" style="width: 250px">&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Check-in date</td>
            <td class="modal-sm" style="width: 250px">&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">&nbsp;</td>
            <td class="modal-sm" style="width: 250px">&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        </table>
    </h2>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</asp:Content>
