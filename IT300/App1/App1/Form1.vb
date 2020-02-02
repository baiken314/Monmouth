﻿Public Class Form1
    Private Sub BtnPumpkinSpice_Click(sender As Object, e As EventArgs) Handles btnPumpkinSpice.Click
        imgPumpkin.Visible = True
        imgMocha.Visible = False
        btnSelect.Enabled = True
        Me.BackColor = Color.FromArgb(255, 205, 170)
    End Sub

    Private Sub BtnMocha_Click(sender As Object, e As EventArgs) Handles btnMocha.Click
        imgMocha.Visible = True
        imgPumpkin.Visible = False
        btnSelect.Enabled = True
        Me.BackColor = Color.FromArgb(200, 170, 140)
    End Sub

    Private Sub BtnSelect_Click(sender As Object, e As EventArgs) Handles btnSelect.Click
        lblSelect.Visible = False
        lblEnjoy.Visible = True
        btnMocha.Enabled = False
        btnPumpkinSpice.Enabled = False
        btnSelect.Enabled = False
        btnExit.Enabled = True
    End Sub

    Private Sub BtnExit_Click(sender As Object, e As EventArgs) Handles btnExit.Click
        Close()
    End Sub
End Class
