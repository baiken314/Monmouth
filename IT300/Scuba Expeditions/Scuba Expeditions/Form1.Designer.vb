<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.Panel1 = New System.Windows.Forms.Panel()
        Me.lblLength = New System.Windows.Forms.Label()
        Me.lblCost = New System.Windows.Forms.Label()
        Me.lblScubaDive = New System.Windows.Forms.Label()
        Me.btnClear = New System.Windows.Forms.Button()
        Me.btnDiveCost = New System.Windows.Forms.Button()
        Me.lstDive = New System.Windows.Forms.ListBox()
        Me.lblSelect = New System.Windows.Forms.Label()
        Me.txtTeam = New System.Windows.Forms.TextBox()
        Me.lblTeam = New System.Windows.Forms.Label()
        Me.cboLocation = New System.Windows.Forms.ComboBox()
        Me.lblTitle = New System.Windows.Forms.Label()
        Me.Panel1.SuspendLayout()
        Me.SuspendLayout()
        '
        'Panel1
        '
        Me.Panel1.BackColor = System.Drawing.Color.Transparent
        Me.Panel1.Controls.Add(Me.lblLength)
        Me.Panel1.Controls.Add(Me.lblCost)
        Me.Panel1.Controls.Add(Me.lblScubaDive)
        Me.Panel1.Controls.Add(Me.btnClear)
        Me.Panel1.Controls.Add(Me.btnDiveCost)
        Me.Panel1.Controls.Add(Me.lstDive)
        Me.Panel1.Controls.Add(Me.lblSelect)
        Me.Panel1.Controls.Add(Me.txtTeam)
        Me.Panel1.Controls.Add(Me.lblTeam)
        Me.Panel1.Controls.Add(Me.cboLocation)
        Me.Panel1.Controls.Add(Me.lblTitle)
        Me.Panel1.Location = New System.Drawing.Point(418, 0)
        Me.Panel1.Name = "Panel1"
        Me.Panel1.Size = New System.Drawing.Size(441, 455)
        Me.Panel1.TabIndex = 0
        '
        'lblLength
        '
        Me.lblLength.AutoSize = True
        Me.lblLength.Font = New System.Drawing.Font("Microsoft Sans Serif", 16.0!)
        Me.lblLength.Location = New System.Drawing.Point(130, 402)
        Me.lblLength.Name = "lblLength"
        Me.lblLength.Size = New System.Drawing.Size(192, 26)
        Me.lblLength.TabIndex = 10
        Me.lblLength.Text = "XXXXXXXXXXXX"
        Me.lblLength.Visible = False
        '
        'lblCost
        '
        Me.lblCost.AutoSize = True
        Me.lblCost.Font = New System.Drawing.Font("Microsoft Sans Serif", 16.0!)
        Me.lblCost.Location = New System.Drawing.Point(130, 381)
        Me.lblCost.Name = "lblCost"
        Me.lblCost.Size = New System.Drawing.Size(192, 26)
        Me.lblCost.TabIndex = 9
        Me.lblCost.Text = "XXXXXXXXXXXX"
        Me.lblCost.Visible = False
        '
        'lblScubaDive
        '
        Me.lblScubaDive.AutoSize = True
        Me.lblScubaDive.Font = New System.Drawing.Font("Microsoft Sans Serif", 16.0!)
        Me.lblScubaDive.Location = New System.Drawing.Point(130, 360)
        Me.lblScubaDive.Name = "lblScubaDive"
        Me.lblScubaDive.Size = New System.Drawing.Size(192, 26)
        Me.lblScubaDive.TabIndex = 8
        Me.lblScubaDive.Text = "XXXXXXXXXXXX"
        Me.lblScubaDive.Visible = False
        '
        'btnClear
        '
        Me.btnClear.BackColor = System.Drawing.Color.MidnightBlue
        Me.btnClear.DialogResult = System.Windows.Forms.DialogResult.Cancel
        Me.btnClear.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.0!)
        Me.btnClear.ForeColor = System.Drawing.Color.White
        Me.btnClear.Location = New System.Drawing.Point(233, 293)
        Me.btnClear.Name = "btnClear"
        Me.btnClear.Size = New System.Drawing.Size(151, 36)
        Me.btnClear.TabIndex = 7
        Me.btnClear.Text = "Clear"
        Me.btnClear.UseVisualStyleBackColor = False
        Me.btnClear.Visible = False
        '
        'btnDiveCost
        '
        Me.btnDiveCost.BackColor = System.Drawing.Color.MidnightBlue
        Me.btnDiveCost.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.0!)
        Me.btnDiveCost.ForeColor = System.Drawing.Color.White
        Me.btnDiveCost.Location = New System.Drawing.Point(41, 293)
        Me.btnDiveCost.Name = "btnDiveCost"
        Me.btnDiveCost.Size = New System.Drawing.Size(151, 36)
        Me.btnDiveCost.TabIndex = 6
        Me.btnDiveCost.Text = "Dive Cost"
        Me.btnDiveCost.UseVisualStyleBackColor = False
        Me.btnDiveCost.Visible = False
        '
        'lstDive
        '
        Me.lstDive.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.0!)
        Me.lstDive.FormattingEnabled = True
        Me.lstDive.ItemHeight = 24
        Me.lstDive.Location = New System.Drawing.Point(123, 197)
        Me.lstDive.Name = "lstDive"
        Me.lstDive.Size = New System.Drawing.Size(179, 76)
        Me.lstDive.TabIndex = 5
        Me.lstDive.Visible = False
        '
        'lblSelect
        '
        Me.lblSelect.AutoSize = True
        Me.lblSelect.Font = New System.Drawing.Font("Microsoft Sans Serif", 16.0!)
        Me.lblSelect.Location = New System.Drawing.Point(116, 169)
        Me.lblSelect.Name = "lblSelect"
        Me.lblSelect.Size = New System.Drawing.Size(197, 26)
        Me.lblSelect.TabIndex = 4
        Me.lblSelect.Text = "Select Scuba Dive:"
        Me.lblSelect.Visible = False
        '
        'txtTeam
        '
        Me.txtTeam.Font = New System.Drawing.Font("Microsoft Sans Serif", 16.0!)
        Me.txtTeam.Location = New System.Drawing.Point(316, 115)
        Me.txtTeam.Name = "txtTeam"
        Me.txtTeam.Size = New System.Drawing.Size(42, 32)
        Me.txtTeam.TabIndex = 3
        Me.txtTeam.Visible = False
        '
        'lblTeam
        '
        Me.lblTeam.AutoSize = True
        Me.lblTeam.Font = New System.Drawing.Font("Microsoft Sans Serif", 16.0!)
        Me.lblTeam.Location = New System.Drawing.Point(74, 118)
        Me.lblTeam.Name = "lblTeam"
        Me.lblTeam.Size = New System.Drawing.Size(231, 26)
        Me.lblTeam.TabIndex = 2
        Me.lblTeam.Text = "Number In Dive Team:"
        Me.lblTeam.Visible = False
        '
        'cboLocation
        '
        Me.cboLocation.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.cboLocation.FormattingEnabled = True
        Me.cboLocation.Items.AddRange(New Object() {"Australia", "Belize", "Fiji", "Indonesia"})
        Me.cboLocation.Location = New System.Drawing.Point(130, 72)
        Me.cboLocation.Name = "cboLocation"
        Me.cboLocation.Size = New System.Drawing.Size(172, 32)
        Me.cboLocation.TabIndex = 1
        Me.cboLocation.Text = "Select Location:"
        '
        'lblTitle
        '
        Me.lblTitle.AutoSize = True
        Me.lblTitle.Font = New System.Drawing.Font("Stencil", 22.0!)
        Me.lblTitle.ForeColor = System.Drawing.Color.MidnightBlue
        Me.lblTitle.Location = New System.Drawing.Point(2, 17)
        Me.lblTitle.Name = "lblTitle"
        Me.lblTitle.Size = New System.Drawing.Size(439, 35)
        Me.lblTitle.TabIndex = 0
        Me.lblTitle.Text = "Oceanic Scuba Expeditions"
        '
        'Form1
        '
        Me.AcceptButton = Me.btnDiveCost
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackgroundImage = Global.Scuba_Expeditions.My.Resources.Resources.background
        Me.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.CancelButton = Me.btnClear
        Me.ClientSize = New System.Drawing.Size(854, 451)
        Me.Controls.Add(Me.Panel1)
        Me.Name = "Form1"
        Me.Text = "Oceanic Scuba Expeditions"
        Me.Panel1.ResumeLayout(False)
        Me.Panel1.PerformLayout()
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents Panel1 As Panel
    Friend WithEvents lblLength As Label
    Friend WithEvents lblCost As Label
    Friend WithEvents lblScubaDive As Label
    Friend WithEvents btnClear As Button
    Friend WithEvents btnDiveCost As Button
    Friend WithEvents lstDive As ListBox
    Friend WithEvents lblSelect As Label
    Friend WithEvents txtTeam As TextBox
    Friend WithEvents lblTeam As Label
    Friend WithEvents cboLocation As ComboBox
    Friend WithEvents lblTitle As Label
End Class
