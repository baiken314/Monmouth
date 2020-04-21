<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmDisplayInventory
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
        Me.picTruck = New System.Windows.Forms.PictureBox()
        Me.lblTitle2 = New System.Windows.Forms.Label()
        Me.lstDisplay = New System.Windows.Forms.ListBox()
        Me.btnReturn = New System.Windows.Forms.Button()
        CType(Me.picTruck, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'picTruck
        '
        Me.picTruck.Image = Global.Deprecation.My.Resources.Resources.food_truck
        Me.picTruck.InitialImage = Nothing
        Me.picTruck.Location = New System.Drawing.Point(0, 0)
        Me.picTruck.Name = "picTruck"
        Me.picTruck.Size = New System.Drawing.Size(79, 59)
        Me.picTruck.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.picTruck.TabIndex = 0
        Me.picTruck.TabStop = False
        '
        'lblTitle2
        '
        Me.lblTitle2.AutoSize = True
        Me.lblTitle2.Font = New System.Drawing.Font("Microsoft Sans Serif", 17.0!)
        Me.lblTitle2.ForeColor = System.Drawing.Color.OrangeRed
        Me.lblTitle2.Location = New System.Drawing.Point(81, 16)
        Me.lblTitle2.Name = "lblTitle2"
        Me.lblTitle2.Size = New System.Drawing.Size(237, 29)
        Me.lblTitle2.TabIndex = 1
        Me.lblTitle2.Text = "Chef Shack Inventory"
        '
        'lstDisplay
        '
        Me.lstDisplay.BackColor = System.Drawing.Color.WhiteSmoke
        Me.lstDisplay.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold)
        Me.lstDisplay.ForeColor = System.Drawing.Color.Gray
        Me.lstDisplay.FormattingEnabled = True
        Me.lstDisplay.ItemHeight = 20
        Me.lstDisplay.Location = New System.Drawing.Point(83, 90)
        Me.lstDisplay.Name = "lstDisplay"
        Me.lstDisplay.Size = New System.Drawing.Size(205, 164)
        Me.lstDisplay.TabIndex = 2
        '
        'btnReturn
        '
        Me.btnReturn.BackColor = System.Drawing.Color.OrangeRed
        Me.btnReturn.Font = New System.Drawing.Font("Microsoft Sans Serif", 12.0!, System.Drawing.FontStyle.Bold)
        Me.btnReturn.ForeColor = System.Drawing.Color.White
        Me.btnReturn.Location = New System.Drawing.Point(83, 290)
        Me.btnReturn.Name = "btnReturn"
        Me.btnReturn.Size = New System.Drawing.Size(205, 36)
        Me.btnReturn.TabIndex = 7
        Me.btnReturn.Text = "Return to Application"
        Me.btnReturn.UseVisualStyleBackColor = False
        '
        'frmDisplayInventory
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.White
        Me.ClientSize = New System.Drawing.Size(371, 380)
        Me.Controls.Add(Me.btnReturn)
        Me.Controls.Add(Me.lstDisplay)
        Me.Controls.Add(Me.lblTitle2)
        Me.Controls.Add(Me.picTruck)
        Me.Name = "frmDisplayInventory"
        Me.Text = "Sorted Inventory Listing"
        CType(Me.picTruck, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents picTruck As PictureBox
    Friend WithEvents lblTitle2 As Label
    Friend WithEvents lstDisplay As ListBox
    Friend WithEvents btnReturn As Button
End Class
