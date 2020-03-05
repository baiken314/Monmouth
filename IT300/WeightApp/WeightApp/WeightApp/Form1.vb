' Program: Fitness Challenge
' Author:  Bradley Aiken
' Date:    3 Mar 2020

Public Class Form1
    Private Sub btnWeightLoss_Click(sender As Object, e As EventArgs) Handles btnWeightLoss.Click
        ' accepts and displays up to 8 values, calculates and displays average
        Dim strWeightLoss As String
        Dim decWeightLoss As Decimal
        Dim decAverageLoss As Decimal
        Dim decTotalWeightLoss As Decimal = 0D
        Dim strInputMessage As String = "Enter the weight loss for team member #"
        Dim strInputHeading As String = "Weight Loss"
        Dim strNormalMessage As String = "Enter the weight loss for team member #"
        Dim strNonNumericError As String = "Error - Enter a number for the weight loss of team member #"
        Dim strNegativeError As String = "Error - Enter a positive number for the weight loss of team member #"

        ' loop variables
        Dim strCancelClicked As String = ""
        Dim intMaxNumberOfEntries As Integer = 8
        Dim intNumberOfEntries As Integer = 1

        ' create up to 8 entries
        strWeightLoss = InputBox(strInputMessage & intNumberOfEntries, strInputHeading, " ")

        Do Until intNumberOfEntries > intMaxNumberOfEntries Or strWeightLoss = strCancelClicked
            If IsNumeric(strWeightLoss) Then
                decWeightLoss = Convert.ToDecimal(strWeightLoss)
                If decWeightLoss > 0 Then
                    lstWeightLoss.Items.Add(decWeightLoss)
                    decTotalWeightLoss += decWeightLoss
                    intNumberOfEntries += 1
                    strInputMessage = strNormalMessage
                Else
                    strInputMessage = strNegativeError
                End If
            Else
                strInputMessage = strNonNumericError
            End If
            If intNumberOfEntries <= intMaxNumberOfEntries Then
                strWeightLoss = InputBox(strInputMessage & intNumberOfEntries, strInputHeading, " ")
            End If
        Loop

        ' calculates and displays average
        If intNumberOfEntries > 1 Then
            lblAverageLoss.Visible = True
            decAverageLoss = decTotalWeightLoss / (intNumberOfEntries - 1)
            lblAverageLoss.Text = "Average weight loss is " & decAverageLoss.ToString("F1") & " lbs"
        Else
            MsgBox("No weight loss value entered")
        End If

        ' gets employee with most weight lost
        Dim decMostWeightLost As Decimal = 0D
        Dim intMostWeightLostEmployeeNumber As Integer = 1
        For i = 0 To intNumberOfEntries - 2
            Dim currentWeightLoss As Decimal = CDec(lstWeightLoss.Items(i).ToString())
            If currentWeightLoss > decMostWeightLost Then
                decMostWeightLost = currentWeightLoss
                intMostWeightLostEmployeeNumber = i + 1
            End If
        Next

        lblMostLost.Text = "Employee " & intMostWeightLostEmployeeNumber & " lost " & decMostWeightLost & " lbs"

        btnWeightLoss.Enabled = False
    End Sub

    Private Sub mnuClear_Click(sender As Object, e As EventArgs) Handles mnuClear.Click
        lstWeightLoss.Items.Clear()
        lblAverageLoss.Visible = True
        btnWeightLoss.Enabled = True
    End Sub

    Private Sub mnuExit_Click(sender As Object, e As EventArgs) Handles mnuExit.Click
        Close()
    End Sub
End Class
