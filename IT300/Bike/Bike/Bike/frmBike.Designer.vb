<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmBike
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(frmBike))
        Me.picBike = New System.Windows.Forms.PictureBox()
        Me.lblHeading = New System.Windows.Forms.Label()
        Me.lblCostPerDayHeading = New System.Windows.Forms.Label()
        Me.lblDays = New System.Windows.Forms.Label()
        Me.txtNumberOfDays = New System.Windows.Forms.TextBox()
        Me.lblTotalCostHeading = New System.Windows.Forms.Label()
        Me.lblTotalCost = New System.Windows.Forms.Label()
        Me.btnFindCost = New System.Windows.Forms.Button()
        Me.btnClear = New System.Windows.Forms.Button()
        Me.btnExit = New System.Windows.Forms.Button()
        CType(Me.picBike, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'picBike
        '
        Me.picBike.Image = CType(resources.GetObject("picBike.Image"), System.Drawing.Image)
        Me.picBike.Location = New System.Drawing.Point(103, 324)
        Me.picBike.Name = "picBike"
        Me.picBike.Size = New System.Drawing.Size(296, 214)
        Me.picBike.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.picBike.TabIndex = 0
        Me.picBike.TabStop = False
        '
        'lblHeading
        '
        Me.lblHeading.AutoSize = True
        Me.lblHeading.Font = New System.Drawing.Font("Sitka Subheading", 24.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblHeading.Location = New System.Drawing.Point(110, 38)
        Me.lblHeading.Name = "lblHeading"
        Me.lblHeading.Size = New System.Drawing.Size(283, 47)
        Me.lblHeading.TabIndex = 1
        Me.lblHeading.Text = "Beach Bike Rental"
        Me.lblHeading.TextAlign = System.Drawing.ContentAlignment.TopCenter
        '
        'lblCostPerDayHeading
        '
        Me.lblCostPerDayHeading.AutoSize = True
        Me.lblCostPerDayHeading.Font = New System.Drawing.Font("Microsoft YaHei", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblCostPerDayHeading.Location = New System.Drawing.Point(182, 97)
        Me.lblCostPerDayHeading.Name = "lblCostPerDayHeading"
        Me.lblCostPerDayHeading.Size = New System.Drawing.Size(139, 25)
        Me.lblCostPerDayHeading.TabIndex = 2
        Me.lblCostPerDayHeading.Text = "$X.XX per day"
        '
        'lblDays
        '
        Me.lblDays.AutoSize = True
        Me.lblDays.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblDays.Location = New System.Drawing.Point(73, 149)
        Me.lblDays.Name = "lblDays"
        Me.lblDays.Size = New System.Drawing.Size(199, 24)
        Me.lblDays.TabIndex = 3
        Me.lblDays.Text = "Number of rental days:"
        '
        'txtNumberOfDays
        '
        Me.txtNumberOfDays.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtNumberOfDays.Location = New System.Drawing.Point(388, 146)
        Me.txtNumberOfDays.Name = "txtNumberOfDays"
        Me.txtNumberOfDays.Size = New System.Drawing.Size(42, 29)
        Me.txtNumberOfDays.TabIndex = 4
        Me.txtNumberOfDays.TextAlign = System.Windows.Forms.HorizontalAlignment.Right
        '
        'lblTotalCostHeading
        '
        Me.lblTotalCostHeading.AutoSize = True
        Me.lblTotalCostHeading.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblTotalCostHeading.Location = New System.Drawing.Point(73, 204)
        Me.lblTotalCostHeading.Name = "lblTotalCostHeading"
        Me.lblTotalCostHeading.Size = New System.Drawing.Size(206, 24)
        Me.lblTotalCostHeading.TabIndex = 5
        Me.lblTotalCostHeading.Text = "Total cost of bike rental:"
        '
        'lblTotalCost
        '
        Me.lblTotalCost.AutoSize = True
        Me.lblTotalCost.Font = New System.Drawing.Font("Microsoft Sans Serif", 14.25!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblTotalCost.ImageAlign = System.Drawing.ContentAlignment.MiddleLeft
        Me.lblTotalCost.Location = New System.Drawing.Point(368, 204)
        Me.lblTotalCost.Name = "lblTotalCost"
        Me.lblTotalCost.Size = New System.Drawing.Size(0, 24)
        Me.lblTotalCost.TabIndex = 6
        Me.lblTotalCost.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        '
        'btnFindCost
        '
        Me.btnFindCost.Location = New System.Drawing.Point(85, 265)
        Me.btnFindCost.Name = "btnFindCost"
        Me.btnFindCost.Size = New System.Drawing.Size(75, 23)
        Me.btnFindCost.TabIndex = 7
        Me.btnFindCost.Text = "Find Cost"
        Me.btnFindCost.UseVisualStyleBackColor = True
        '
        'btnClear
        '
        Me.btnClear.DialogResult = System.Windows.Forms.DialogResult.Cancel
        Me.btnClear.Location = New System.Drawing.Point(217, 265)
        Me.btnClear.Name = "btnClear"
        Me.btnClear.Size = New System.Drawing.Size(75, 23)
        Me.btnClear.TabIndex = 8
        Me.btnClear.Text = "Clear"
        Me.btnClear.UseVisualStyleBackColor = True
        '
        'btnExit
        '
        Me.btnExit.Location = New System.Drawing.Point(342, 265)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(75, 23)
        Me.btnExit.TabIndex = 9
        Me.btnExit.Text = "Exit"
        Me.btnExit.UseVisualStyleBackColor = True
        '
        'frmBike
        '
        Me.AcceptButton = Me.btnFindCost
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(224, Byte), Integer), CType(CType(192, Byte), Integer))
        Me.CancelButton = Me.btnClear
        Me.ClientSize = New System.Drawing.Size(503, 576)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.btnClear)
        Me.Controls.Add(Me.btnFindCost)
        Me.Controls.Add(Me.lblTotalCost)
        Me.Controls.Add(Me.lblTotalCostHeading)
        Me.Controls.Add(Me.txtNumberOfDays)
        Me.Controls.Add(Me.lblDays)
        Me.Controls.Add(Me.lblCostPerDayHeading)
        Me.Controls.Add(Me.lblHeading)
        Me.Controls.Add(Me.picBike)
        Me.Name = "frmBike"
        Me.Text = "Bike Rental"
        CType(Me.picBike, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents picBike As PictureBox
    Friend WithEvents lblHeading As Label
    Friend WithEvents lblCostPerDayHeading As Label
    Friend WithEvents lblDays As Label
    Friend WithEvents txtNumberOfDays As TextBox
    Friend WithEvents lblTotalCostHeading As Label
    Friend WithEvents lblTotalCost As Label
    Friend WithEvents btnFindCost As Button
    Friend WithEvents btnClear As Button
    Friend WithEvents btnExit As Button
End Class
