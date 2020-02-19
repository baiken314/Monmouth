' Program Name: Decking Cost Calculator Application
' Auhor:        Bradley Aiken
' Date:         February 13, 2020

Option Strict On

Public Class frmDecking
    Private Sub frmDecking_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        ' Sets focus and defaults
        txtFootage.Focus()
        radLumber.Checked = True
        lblCostEstimate.Text = ""
    End Sub

    Private Sub btnCalculate_Click(sender As Object, e As EventArgs) Handles btnCalculate.Click
        ' calculates the estimated cost
        Dim decFootage As Decimal
        Dim decCostPerSquareFoot As Decimal
        Dim decCostEstimate As Decimal
        Dim decLumberCost As Decimal = 2.35D
        Dim decRedwoodCost As Decimal = 7.75D
        Dim decCompositeCost As Decimal = 8.5D
        Dim decAcaciaCost As Decimal = 3.5D

        If IsNumeric(txtFootage.Text) Then
            decFootage = Convert.ToDecimal(txtFootage.Text)
            If decFootage >= 0 Then
                If radLumber.Checked Then
                    decCostPerSquareFoot = decLumberCost
                ElseIf radRedwood.Checked Then
                    decCostPerSquareFoot = decRedwoodCost
                ElseIf radComposite.Checked Then
                    decCostPerSquareFoot = decCompositeCost
                ElseIf radAcacia.Checked Then
                    decCostPerSquareFoot = decAcaciaCost
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

        picDeck.Load("final_deck.jpg")
    End Sub

    Private Sub btnClear_Click(sender As Object, e As EventArgs) Handles btnClear.Click
        ' Resets focus and defaults
        txtFootage.Text = ""
        lblCostEstimate.Text = ""
        radLumber.Checked = True
        radRedwood.Checked = False
        radComposite.Checked = False
        radAcacia.Checked = False
        txtFootage.Focus()
    End Sub
End Class
