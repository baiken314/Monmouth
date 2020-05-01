' Title:   Gaming Art
' Title:   Gaming Art
' Author:  Bradley Aiken
' Date:    30 April 2020
' Purpose: Display game design art as a database

Public Class frmArt

    Private Sub ArtistBindingNavigatorSaveItem_Click_1(sender As Object, e As EventArgs) Handles ArtistBindingNavigatorSaveItem.Click
        Me.Validate()
        Me.ArtistBindingSource.EndEdit()
        Me.TableAdapterManager.UpdateAll(Me.ArtDataSet)
    End Sub

    Private Sub frmArt_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        'TODO: This line of code loads data into the 'ArtDataSet.Artist' table. You can move, or remove it, as needed.
        Me.ArtistTableAdapter.Fill(Me.ArtDataSet.Artist)
    End Sub

    Private Sub btnValue_Click(sender As Object, e As EventArgs) Handles btnValue.Click

        Dim strSql As String = "SELECT * FROM Artist WHERE Collection='Public'"

        ' type and path of database
        ''''' this will need to be changed to a different path when used on another machine '''''
        Dim strPath As String = "Provider=Microsoft.ACE.OLEDB.12.0 ;" & "Data Source=C:\Users\Bradley\Documents\GitHub\Monmouth\IT300\GamingArt\Art.mdb"
        Dim odaArtist As New OleDb.OleDbDataAdapter(strSql, strPath)
        Dim datValue As New DataTable
        Dim intCount As Integer
        Dim decTotalValue As Decimal = 0D

        ' datValue is filled with data
        odaArtist.Fill(datValue)
        ' disconnect
        odaArtist.Dispose()
        For intCount = 0 To datValue.Rows.Count - 1
            decTotalValue += Convert.ToDecimal(datValue.Rows(intCount)("Retail Price"))
        Next
        lblTotalRetailValue.Visible = True
        lblTotalRetailValue.Text = "The total retail value is: " & decTotalValue.ToString("C")
        lblPublic.Visible = True
        lblPublic.Text = "Amount of public works: " & datValue.Rows.Count

    End Sub

End Class
