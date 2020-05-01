' Title:   IMAX Tickets
' Date:    30 April 2020
' Author:  Bradley Aiken
' Purpose: Calculate cost of tickets

Public Class Form1

    Dim intTicketCost As Integer
    Dim intNumberOfTickets As Integer
    Dim intTotalCost As Integer

    Private Sub Form1_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Threading.Thread.Sleep(4000)
    End Sub

    Private Sub cboShowType_SelectedIndexChanged(sender As Object, e As EventArgs) Handles cboShowType.SelectedIndexChanged
        lblNumberOfTickets.Visible = True
        txtNumberOfTickets.Visible = True
    End Sub

    Private Sub txtNumberOfTickets_TextChanged(sender As Object, e As EventArgs) Handles txtNumberOfTickets.TextChanged
        btnCost.Visible = True
        btnClear.Visible = True
    End Sub

    Private Sub btnCost_Click(sender As Object, e As EventArgs) Handles btnCost.Click
        If isInputValid() Then
            intNumberOfTickets = Convert.ToInt32(txtNumberOfTickets.Text)
            If cboShowType.SelectedIndex = 0 Then
                ' matinee = $16
                intTicketCost = 16
            Else
                ' evening = $27
                intTicketCost = 27
            End If
            intTotalCost = intTicketCost * intNumberOfTickets
                lblCost.Visible = True
            lblCost.Text = intTotalCost.ToString("C") & " for " & intNumberOfTickets & " tickets."
        End If
    End Sub

    Private Sub btnClear_Click(sender As Object, e As EventArgs) Handles btnClear.Click
        cboShowType.SelectedIndex = -1
        lblNumberOfTickets.Visible = False
        txtNumberOfTickets.Visible = False
        txtNumberOfTickets.Text = ""
        btnCost.Visible = False
        btnClear.Visible = False
        lblCost.Visible = False
    End Sub

    Private Function isInputValid() As Boolean
        Try
            intNumberOfTickets = Convert.ToInt32(txtNumberOfTickets.Text)
            If intNumberOfTickets <= 0 Then
                MsgBox("Your input must be over 0.", , "Range Error")
                Return False
            End If
            If cboShowType.SelectedIndex < 0 Then
                MsgBox("You must select a ticket type.", , "Selection Error")
                Return False
            End If
            Return True
        Catch ex As Exception
            MsgBox("Your input must be a positive integer.", , "Type Error")
            Return False
        End Try
    End Function

End Class
