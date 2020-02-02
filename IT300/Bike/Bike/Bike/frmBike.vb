Option Strict On

Public Class frmBike

    Const _cdecPricePerDay = 9.95D

    Private Sub frmBike_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        lblCostPerDayHeading.Text = "$" + Convert.ToString(_cdecPricePerDay) + " per day"
    End Sub

    Private Sub btnFindCost_Click(sender As Object, e As EventArgs) Handles btnFindCost.Click

        Dim strNumberOfDays As String
        Dim intNumberOfDays As Integer
        Dim decTotalCost As Decimal

        strNumberOfDays = txtNumberOfDays.Text
        intNumberOfDays = Convert.ToInt32(strNumberOfDays)
        decTotalCost = intNumberOfDays * _cdecPricePerDay

        lblTotalCost.Text = decTotalCost.ToString("C")

    End Sub

    Private Sub btnClear_Click(sender As Object, e As EventArgs) Handles btnClear.Click
        txtNumberOfDays.Text = ""
        lblTotalCost.Text = ""
    End Sub

    Private Sub btnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click
        Me.Close()
    End Sub

End Class
