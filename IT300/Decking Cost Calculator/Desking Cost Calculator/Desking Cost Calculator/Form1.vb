' Program Name: Decking Cost Calculator Application
' Auhor:        Bradley Aiken
' Date:         February 13, 2020

Option Strict On

Public Class frmDecking
    Private Sub frmDecking_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub

    Private Sub btnCalculate_Click(sender As Object, e As EventArgs) Handles btnCalculate.Click
        ' calculates the estimated cost
        Dim decFootage As Decimal
        Dim decCostPerSquareFoot As Decimal
        Dim decCostEstimate As Decimal
        Dim decLumberCost As Decimal = 2.35D
        Dim decRedwoodCost As Decimal = 7.75D
        Dim decCompositeCost As Decimal = 8.5D

        If IsNumeric(txtFootage.Text) Then
            decFootage = Convert.ToDecimal(txtFootage.Text)
            If decFootage > 0 Then
                If radLumber.Checked Then
                    decCostPerSquareFoot = decLumberCost
                ElseIf radRedwood.Checked Then
                    decCostPerSquareFoot = decRedwoodCost
                ElseIf radComposite.Checked Then
                    decCostPerSquareFoot = decCompositeCost
                End If
                decCostEstimate = decFootage * decCostPerSquareFoot
                lblCostEstimate.Text = decCostEstimate.ToString("C")
            Else
                ' Display error message if less than 0
                MsgBox("You entered " & decFootage.ToString() & ". Enter a positive number.", 0, "Input Error")
                txtFootage.Text = ""
                txtFootage.Focus()
            End If
        Else
            ' Display error message if not numeric
            MsgBox("Enter the square footage of decking.", 0, "Input Error")
            txtFootage.Text = ""
            txtFootage.Focus()
        End If
    End Sub

    Private Sub radLumber_CheckedChanged(sender As Object, e As EventArgs) Handles radLumber.CheckedChanged

    End Sub

    Private Sub radRedwood_CheckedChanged(sender As Object, e As EventArgs) Handles radRedwood.CheckedChanged

    End Sub

    Private Sub RadioButton1_CheckedChanged(sender As Object, e As EventArgs) Handles radComposite.CheckedChanged

    End Sub
End Class
