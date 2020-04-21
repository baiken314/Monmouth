' Program Name: Chef Shack Food Truck Depreciation
' Author:       Bradley Aiken
' Date:         17 April 2020
' Purpose:      Determines depreciation for 5 years using straight-line and double-declining balance methods.

Option Strict On

Public Class frmDepreciation

    Private _intLifeOfItems As Integer = 5
    Public Shared _intSizeOfArray As Integer = 7
    Public Shared _strInventoryItems(_intSizeOfArray) As String
    Private _strItemIds(_intSizeOfArray) As String
    Private _decInitialPrices(_intSizeOfArray) As Decimal
    Private _intQuantities(_intSizeOfArray) As Integer

    Private Sub frmDepreciation_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        ' read inventory.txt, populate lists
        Dim objReader As IO.StreamReader
        ' file path is absolute, should be changed on another system
        Dim strFilePath As String = "C:\Users\Bradley\Documents\GitHub\Monmouth\IT300\Deprecation\Deprecation\inventory.txt"
        Dim intCount As Integer = 0
        Dim intFill As Integer
        Dim strFileError As String = "File not available. Restart when available."
        ' verify file exists
        If IO.File.Exists(strFilePath) Then
            objReader = IO.File.OpenText(strFilePath)
            ' read file
            Do While objReader.Peek <> -1
                _strInventoryItems(intCount) = objReader.ReadLine()
                _strItemIds(intCount) = objReader.ReadLine()
                _decInitialPrices(intCount) = Convert.ToDecimal(objReader.ReadLine())
                _intQuantities(intCount) = Convert.ToInt32(objReader.ReadLine())
                intCount += 1
            Loop
            objReader.Close()
            ' ListBox filled with inventory ids
            For i = 0 To (_strInventoryItems.Length - 1)
                lstInventoryId.Items.Add(_strItemIds(i))
            Next
        Else
            MsgBox(strFileError, , "Error")
            Close()
        End If
    End Sub

    Private Sub btnCalculateDepreciation_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnCalculateDepreciation.Click
        ' call depreciation subprocedures
        Dim intSelectedItemId As Integer
        Dim strMissingSelection As String = "Missing selection"
        Dim strSelectDepreciationError As String = "Select a depreciation method"
        Dim strSelectInventoryItemIDError As String = "Select an inventory item ID"
        ' if listbox and method selected, call depreciation procedures
        If lstInventoryId.SelectedIndex >= 0 Then
            intSelectedItemId = lstInventoryId.SelectedIndex
            If radStraightLine.Checked Then
                StraightLineDepreciation(intSelectedItemId)
            ElseIf radDoubleDeclining.Checked Then
                DoubleDecliningDepreciation(intSelectedItemId)
            Else
                MsgBox(strSelectDepreciationError, , strMissingSelection)
            End If
        Else
            MsgBox(strSelectInventoryItemIDError, , strMissingSelection)
        End If
    End Sub

    Private Sub StraightLineDepreciation(ByVal intItemId As Integer)
        ' compute and display straight line depreciation
        Dim intStraightPresentYear As Integer
        Dim decStraightPresentYearValue As Decimal = 0D
        Dim decStraightDepreciation As Decimal
        Dim decStraightTotal As Decimal
        Dim strDepreciationItem As String = "The depreciation of the item: "
        Dim strQuantityMessage As String = "Quantity: "
        ' display form objects
        MakeObjectsVisible()
        ' display item and quantity of selected item
        lblItem.Text = strDepreciationItem & _strInventoryItems(intItemId)
        lblQuantity.Text = strQuantityMessage & _intQuantities(intItemId).ToString()
        ' formula for straight line depreciation
        decStraightDepreciation = _decInitialPrices(intItemId) / _intLifeOfItems
        decStraightPresentYearValue = _decInitialPrices(intItemId)

        For intStraightPresentYear = 1 To _intLifeOfItems
            ' accumulate total depreciation
            decStraightTotal += decStraightDepreciation
            ' display amounts
            lstYear.Items.Add(intStraightPresentYear.ToString())
            lstPresentValue.Items.Add(decStraightPresentYearValue.ToString("C"))
            lstYearDepreciation.Items.Add(decStraightDepreciation.ToString("C"))
            lstTotalDepreciation.Items.Add(decStraightTotal.ToString("C"))
            decStraightPresentYearValue -= decStraightDepreciation
        Next
    End Sub

    Private Sub DoubleDecliningDepreciation(ByVal intItemId As Integer)
        ' calculate and display double declining depreciation for selected item
        Dim intDoublePresentYear As Integer
        Dim decDoublePresentYearValue As Decimal = 0D
        Dim decDoubleDepreciation As Decimal
        Dim decDoubleTotal As Decimal
        ' display form objects
        MakeObjectsVisible()
        ' display item and quantity
        lblItem.Text = "The depreciation of the item: " & _strInventoryItems(intItemId)
        lblQuantity.Text = "Quantity: " & _intQuantities(intItemId).ToString()
        decDoublePresentYearValue = _decInitialPrices(intItemId)

        For intDoublePresentYear = 1 To _intLifeOfItems
            ' formula for double-declining depreciation
            decDoubleDepreciation = (decDoublePresentYearValue * 2D) / _intLifeOfItems
            ' accumulate total
            decDoubleTotal += decDoubleDepreciation
            ' display amounts
            lstYear.Items.Add(intDoublePresentYear.ToString())
            lstPresentValue.Items.Add(decDoublePresentYearValue.ToString("C"))
            lstYearDepreciation.Items.Add(decDoubleDepreciation.ToString("C"))
            lstTotalDepreciation.Items.Add(decDoubleTotal.ToString("C"))
            decDoublePresentYearValue -= decDoubleDepreciation
        Next
    End Sub

    Private Sub MakeObjectsVisible()
        lblItem.Visible = True
        lblQuantity.Visible = True
        lblYear.Visible = True
        lstYear.Visible = True
        lblPresentValue.Visible = True
        lstPresentValue.Visible = True
        lblYearDepreciation.Visible = True
        lstYearDepreciation.Visible = True
        lblTotalDepreciation.Visible = True
        lstTotalDepreciation.Visible = True
        ' clear lists
        lstYear.Items.Clear()
        lstPresentValue.Items.Clear()
        lstYearDepreciation.Items.Clear()
        lstTotalDepreciation.Items.Clear()
    End Sub

    Private Sub mnuDisplay_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles mnuDisplay.Click
        Dim frmSecond As New frmDisplayInventory
        ' hide this form
        Hide()
        frmSecond.ShowDialog()
    End Sub

    Private Sub mnuClear_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles mnuClear.Click
        lstInventoryId.SelectedIndex = -1
        radStraightLine.Checked = False
        radDoubleDeclining.Checked = False
        lblItem.Visible = False
        lblQuantity.Visible = False
        lblYear.Visible = False
        lstYear.Visible = False
        lstYear.Items.Clear()
        lblPresentValue.Visible = False
        lstPresentValue.Visible = False
        lstPresentValue.Items.Clear()
        lblYearDepreciation.Visible = False
        lstYearDepreciation.Visible = False
        lstYearDepreciation.Items.Clear()
        lblTotalDepreciation.Visible = False
        lstTotalDepreciation.Visible = False
        lstTotalDepreciation.Items.Clear()
    End Sub

    Private Sub mnuExit_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles mnuExit.Click
        Application.Exit()
    End Sub

End Class
