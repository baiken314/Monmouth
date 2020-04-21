' Program name: Scuba Expeditions Application
' Author:       Bradley Aiken
' Date:         17 April 2020
' Purpose:      Determines location and scuba dives available and calculates total dive team cost.

Option Strict On

Public Class Form1

    ' class variables
    Private _intFourHour As Integer = 4
    Private _intSixHour As Integer = 6
    Private _intEightHour As Integer = 8
    Private _strDive1 As String = "Great Barrier Reef"
    Private _strDive2 As String = "Tiger Shark"
    Private _strDive3 As String = "Fathom Chasm"
    Private _strDive4 As String = "Great Blue Chasm"
    Private _strDive5 As String = "Rainbow Reef"
    Private _strDive6 As String = "Namena Sunken Ship"
    Private _strDive7 As String = "Lambeh Strait"

    Private Sub cboLocation_SelectedIndexChanged(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles cboLocation.SelectedIndexChanged
        ' allow user to enter location choice, call subs to place dive types in list
        Dim intLocationChoice As Integer = cboLocation.SelectedIndex
        lstDive.Items.Clear()
        Select Case intLocationChoice
            Case 0
                AustraliaTeam()
            Case 1
                BelizeTeam()
            Case 2
                FijiTeam()
            Case 3 ' Indonesia
                IndonesiaTeam()
        End Select
        ' make items visible in window
        lblTeam.Visible = True
        txtTeam.Visible = True
        lblSelect.Visible = True
        lstDive.Visible = True
        btnDiveCost.Visible = True
        btnClear.Visible = True
        lblScubaDive.Visible = True
        lblCost.Visible = True
        lblLength.Visible = True
        ' clear labels
        lblScubaDive.Text = ""
        lblCost.Text = ""
        lblLength.Text = ""
        ' focus on dive team text box
        txtTeam.Focus()
    End Sub

    Private Sub AustraliaTeam()
        ' fill in Australia dive types
        lstDive.Items.Add(_strDive1)
        lstDive.Items.Add(_strDive2)
        lstDive.Items.Add(_strDive3)
    End Sub

    Private Sub BelizeTeam()
        ' fill in Belize dive types
        lstDive.Items.Add(_strDive4)
        lstDive.Items.Add(_strDive5)
    End Sub

    Private Sub FijiTeam()
        ' fill in Fiji dive types
        lstDive.Items.Add(_strDive2)
        lstDive.Items.Add(_strDive3)
        lstDive.Items.Add(_strDive6)
    End Sub

    Private Sub IndonesiaTeam()
        ' fill in Indonesia dive types
        lstDive.Items.Add(_strDive2)
        lstDive.Items.Add(_strDive7)
    End Sub

    Private Sub btnDiveCost_Click(sender As Object, e As EventArgs) Handles btnDiveCost.Click
        ' get cost of expedition and displays size of dive team, cost, and dive length
        Dim intTeamSize As Integer
        Dim blnNumberInTeamIsValid As Boolean = False
        Dim blnDiveIsSelected As Boolean = False
        Dim intDiveChoice As Integer
        Dim strSelectedTeam As String = ""
        Dim intLocationChoice As Integer
        Dim intLength As Integer
        Dim decTotalCost As Decimal
        ' validate number of people in team
        blnNumberInTeamIsValid = ValidateNumberInTeam()
        ' validate dive is selected
        intDiveChoice = ValidateDiveSelection(blnDiveIsSelected, strSelectedTeam)
        ' get cost
        If (blnNumberInTeamIsValid And blnDiveIsSelected) Then
            intTeamSize = Convert.ToInt32(txtTeam.Text)
            intLocationChoice = cboLocation.SelectedIndex
            Select Case intLocationChoice
                Case 0
                    decTotalCost = AustraliaDiveCost(intDiveChoice, intTeamSize, intLength)
                Case 1
                    decTotalCost = BelizeDiveCost(intDiveChoice, intTeamSize, intLength)
                Case 2
                    decTotalCost = FijiDiveCost(intDiveChoice, intTeamSize, intLength)
                Case 3 ' Indonesia
                    decTotalCost = IndonesiaDiveCost(intDiveChoice, intTeamSize, intLength)
            End Select
            ' display scuba dive cost
            lblScubaDive.Text = "Dive: " & strSelectedTeam
            lblCost.Text = "Cost: " & decTotalCost.ToString("C")
            lblLength.Text = "Length: " & intLength.ToString() & " hours"
        End If
    End Sub

    Private Function ValidateNumberInTeam() As Boolean
        ' validate value entered in dive team size
        Dim intTeamSize As Integer
        Dim blnValidityCheck As Boolean = False
        Dim strNummberInTeamMessage As String = "Please enter the number of people in your dive team (2-6)"
        Dim strMessageBoxTitle As String = "Error"

        Try
            intTeamSize = Convert.ToInt32(txtTeam.Text)
            If intTeamSize >= 2 And intTeamSize <= 6 Then
                blnValidityCheck = True
            Else
                MsgBox(strNummberInTeamMessage, , strMessageBoxTitle)
                txtTeam.Focus()
                txtTeam.Clear()
            End If
        Catch Exception As FormatException
            MsgBox(strNummberInTeamMessage, , strMessageBoxTitle)
            txtTeam.Focus()
            txtTeam.Clear()
        Catch Exception As OverflowException
            MsgBox(strNummberInTeamMessage, , strMessageBoxTitle)
            txtTeam.Focus()
            txtTeam.Clear()
        Catch Exception As SystemException
            MsgBox(strNummberInTeamMessage, , strMessageBoxTitle)
            txtTeam.Focus()
            txtTeam.Clear()
        End Try
        Return blnValidityCheck
    End Function

    Private Function ValidateDiveSelection(ByRef blnDive As Boolean, ByRef strDive As String) As Integer
        ' check if user selected dive type
        Dim intDiveType As Integer
        Try
            intDiveType = Convert.ToInt32(lstDive.SelectedIndex)
            strDive = lstDive.SelectedItem.ToString()
            blnDive = True
        Catch Exception As SystemException
            ' detect if dive not selected
            MsgBox("Select a dive type", , "Error")
            blnDive = False
        End Try
        Return intDiveType
    End Function

    Private Function AustraliaDiveCost(ByVal intDive As Integer, ByVal intTeam As Integer, ByRef intTime As Integer) As Decimal
        Dim decTeamCost As Decimal
        Dim decFinalCost As Decimal
        Dim decAustraliaDive1 As Decimal = 359D
        Dim decAustraliaDive2 As Decimal = 200D
        Dim decAustraliaDive3 As Decimal = 125D
        Select Case intDive
            Case 0
                decTeamCost = decAustraliaDive1
                intTime = _intEightHour
            Case 1
                decTeamCost = decAustraliaDive2
                intTime = _intSixHour
            Case 2
                decTeamCost = decAustraliaDive3
                intTime = _intFourHour
        End Select
        decFinalCost = decTeamCost * intTeam
        Return decFinalCost
    End Function

    Private Function BelizeDiveCost(ByVal intDive As Integer, ByVal intTeam As Integer, ByRef intTime As Integer) As Decimal
        Dim decTeamCost As Decimal
        Dim decFinalCost As Decimal
        Dim decBelizeDive4 As Decimal = 200D
        Dim decBelizeDive5 As Decimal = 150D
        Select Case intDive
            Case 0
                decTeamCost = decBelizeDive4
                intTime = _intEightHour
            Case 1
                decTeamCost = decBelizeDive5
                intTime = _intSixHour
        End Select
        decFinalCost = decTeamCost * intTeam
        Return decFinalCost
    End Function

    Private Function FijiDiveCost(ByVal intDive As Integer, ByVal intTeam As Integer, ByRef intTime As Integer) As Decimal
        Dim decTeamCost As Decimal
        Dim decFinalCost As Decimal
        Dim decFijiDive2 As Decimal = 280D
        Dim decFijiDive3 As Decimal = 225D
        Dim decFijiDive6 As Decimal = 200D
        Select Case intDive
            Case 0
                decTeamCost = decFijiDive2
                intTime = _intEightHour
            Case 1
                decTeamCost = decFijiDive3
                intTime = _intSixHour
            Case 2
                decTeamCost = decFijiDive6
                intTime = _intFourHour
        End Select
        decFinalCost = decTeamCost * intTime
        Return decFinalCost
    End Function

    Private Function IndonesiaDiveCost(ByVal intDiveChoice As Integer, ByVal intTeamSize As Integer, ByRef intLength As Integer) As Decimal
        Dim decTotalCost As Decimal
        Dim decIndonesiaDive2 As Decimal = 300D
        Dim decIndonesiaDive7 As Decimal = 400D
        Select Case intDiveChoice
            Case 0
                decTotalCost = decIndonesiaDive2 * intTeamSize
                intLength = _intEightHour
            Case 1
                decTotalCost = decIndonesiaDive7 * intTeamSize
                intLength = _intSixHour
        End Select
        Return decTotalCost
    End Function

    Private Sub btnClear_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnClear.Click
        ' reset form
        cboLocation.Text = "Select Location:"
        txtTeam.Clear()
        lstDive.Items.Clear()
        lblScubaDive.Text = ""
        lblCost.Text = ""
        lblLength.Text = ""
        lblTeam.Visible = False
        txtTeam.Visible = False
        lblSelect.Visible = False
        lstDive.Visible = False
        btnDiveCost.Visible = False
        btnClear.Visible = False
        lblScubaDive.Visible = False
        lblCost.Visible = False
        lblLength.Visible = False
    End Sub

    Private Sub fumScuba_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        ' pause to show splash screen
        Threading.Thread.Sleep(3000)
    End Sub

End Class
