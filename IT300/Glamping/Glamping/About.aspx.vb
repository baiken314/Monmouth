' Project: Moonbean Glamping Reservation
' Author:  Bradley Aiken
' Date:    30 April 2020
' Purpose: Request reservation information, compute cost of nights w/ tent selection

Public Class About
    Inherits Page

    Protected Sub btnSubmit_Click(sender As Object, e As EventArgs) Handles btnSubmit.Click

        Dim decGrizzyCost As Decimal = 99D
        Dim decPolarCost As Decimal = 89D
        Dim decKodiakCost As Decimal = 79D
        Dim strName As String
        Dim strEmail As String
        Dim decTentCost As Decimal = 0D
        Dim intNumberOfNights As Integer
        Dim strMessage As String

        ' trim extra spaces
        strName = txtName.Text.Trim
        strEmail = txtEmail.Text.Trim
        lblReservation.Text = ""

        If Not (chkGrizzly.Checked Or chkPolar.Checked Or chkKodiak.Checked) Then
            lblTentError.Visible = True
            If cldArrival.SelectedDate < cldArrival.TodaysDate Then
                lblCalendarError.Visible = True
            Else
                lblCalendarError.Visible = False
            End If
        Else
            lblTentError.Visible = False
            If cldArrival.SelectedDate >= cldArrival.TodaysDate Then
                lblCalendarError.Visible = False
                ' calculate cost
                If chkGrizzly.Checked Then
                    decTentCost += decGrizzyCost
                End If
                If chkPolar.Checked Then
                    decTentCost += decPolarCost
                End If
                If chkKodiak.Checked Then
                    decTentCost += decKodiakCost
                End If
                intNumberOfNights = Convert.ToInt32(ddlNights.SelectedItem.Text)
                decTentCost = intNumberOfNights * decTentCost
                strMessage = "A reservation has been made for: " & "<br>" & strName & "<br>" & "Email: " & strEmail & "<br>"
                strMessage &= "The tent(s) cost is: " & decTentCost.ToString("C") & "<br>"
                strMessage &= "Arrival date: " & cldArrival.SelectedDate.ToShortDateString() & "<br>" & " for " & intNumberOfNights & " night(s)"
                lblReservation.Text = strMessage
            Else
                lblCalendarError.Visible = True
            End If
        End If
    End Sub

End Class