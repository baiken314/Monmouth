Option Strict On

Public Class frmDisplayInventory

    Private Sub frmDisplayInventory_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Dim strItem As String
        Array.Sort(frmDepreciation._strInventoryItems)
        For Each strItem In frmDepreciation._strInventoryItems
            lstDisplay.Items.Add(strItem)
        Next
    End Sub

    Private Sub btnReturn_Click(sender As Object, e As EventArgs) Handles btnReturn.Click
        Dim frmFirst As New frmDepreciation
        Hide()
        frmFirst.ShowDialog()
    End Sub

End Class