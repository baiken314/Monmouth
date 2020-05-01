<%@ Page Title="Moonbeam Glamping" Language="VB" MasterPageFile="~/Site.Master" AutoEventWireup="true" CodeBehind="About.aspx.vb" Inherits="Glamping.About" %>

<asp:Content ID="BodyContent" ContentPlaceHolderID="MainContent" runat="server">
    <h2><%: Title %>&nbsp;Guest Reservation Form<table style="width:100%;">
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Name:</td>
            <td class="modal-sm" style="width: 250px">
                <asp:TextBox ID="txtName" runat="server" Width="250px"></asp:TextBox>
            </td>
            <td>
                <asp:RequiredFieldValidator ID="rfvName" runat="server" ControlToValidate="txtName" ErrorMessage="* Enter name"></asp:RequiredFieldValidator>
            </td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Email address:</td>
            <td class="modal-sm" style="width: 250px">
                <asp:TextBox ID="txtEmail" runat="server" Width="250px"></asp:TextBox>
            </td>
            <td>
                <asp:RequiredFieldValidator ID="rfvEmail" runat="server" ControlToValidate="txtEmail" ErrorMessage="* Enter a valid email"></asp:RequiredFieldValidator>
                <br />
                <asp:RegularExpressionValidator ID="revEmail" runat="server" ControlToValidate="txtEmail" ErrorMessage="RegularExpressionValidator" ValidationExpression="\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*"></asp:RegularExpressionValidator>
            </td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Tent selection:</td>
            <td class="modal-sm" style="width: 250px">
                <asp:CheckBox ID="chkGrizzly" runat="server" Text="Grizzly (suite) $99" Width="250px" />
                <asp:CheckBox ID="chkPolar" runat="server" Text="Polar (deluxe plus cot) $89" Width="250px" />
                <asp:CheckBox ID="chkKodiak" runat="server" Text="Kodiak (deluxe) $79" />
            </td>
            <td>
                <asp:Label ID="lblTentError" runat="server" Text="* Select a tent" Visible="False"></asp:Label>
            </td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Night(s):</td>
            <td class="modal-sm" style="width: 250px">
                <asp:DropDownList ID="ddlNights" runat="server">
                    <asp:ListItem>1</asp:ListItem>
                    <asp:ListItem>2</asp:ListItem>
                    <asp:ListItem>3</asp:ListItem>
                    <asp:ListItem>4</asp:ListItem>
                    <asp:ListItem>5</asp:ListItem>
                    <asp:ListItem>6</asp:ListItem>
                    <asp:ListItem>7</asp:ListItem>
                </asp:DropDownList>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr style="font-size: medium">
            <td class="modal-sm" style="width: 150px">Check-in date</td>
            <td class="modal-sm" style="width: 250px">
                <asp:Calendar ID="cldArrival" runat="server" BackColor="#FFFFCC" BorderColor="#FFCC66" BorderWidth="1px" DayNameFormat="Shortest" Font-Names="Verdana" Font-Size="8pt" ForeColor="#663399" Height="200px" ShowGridLines="True" Width="220px">
                    <DayHeaderStyle BackColor="#FFCC66" Font-Bold="True" Height="1px" />
                    <NextPrevStyle Font-Size="9pt" ForeColor="#FFFFCC" />
                    <OtherMonthDayStyle ForeColor="#CC9966" />
                    <SelectedDayStyle BackColor="#CCCCFF" Font-Bold="True" />
                    <SelectorStyle BackColor="#FFCC66" />
                    <TitleStyle BackColor="#990000" Font-Bold="True" Font-Size="9pt" ForeColor="#FFFFCC" />
                    <TodayDayStyle BackColor="#FFCC66" ForeColor="White" />
                </asp:Calendar>
            </td>
            <td>
                <asp:Button ID="btnSubmit" runat="server" Text="Submit" />
                <br />
                <asp:Label ID="lblCalendarError" runat="server" Text="* Select a valid date" Visible="False"></asp:Label>
                <br />
                <br />
                <br />
                <asp:Label ID="lblReservation" runat="server" Text="[lblReservation]"></asp:Label>
                <br />
                <br />
                <br />
                <br />
                <br />
                <br />
            </td>
        </tr>
        </table>
    </h2>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</asp:Content>
