<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmDepreciation
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
        Me.MenuStrip1 = New System.Windows.Forms.MenuStrip()
        Me.mnuFile = New System.Windows.Forms.ToolStripMenuItem()
        Me.mnuDisplay = New System.Windows.Forms.ToolStripMenuItem()
        Me.mnuClear = New System.Windows.Forms.ToolStripMenuItem()
        Me.mnuExit = New System.Windows.Forms.ToolStripMenuItem()
        Me.lblFoodTruck = New System.Windows.Forms.Label()
        Me.lblSelectItem = New System.Windows.Forms.Label()
        Me.lstInventoryId = New System.Windows.Forms.ListBox()
        Me.grpMethod = New System.Windows.Forms.GroupBox()
        Me.radDoubleDeclining = New System.Windows.Forms.RadioButton()
        Me.radStraightLine = New System.Windows.Forms.RadioButton()
        Me.btnCalculateDepreciation = New System.Windows.Forms.Button()
        Me.lblItem = New System.Windows.Forms.Label()
        Me.lblQuantity = New System.Windows.Forms.Label()
        Me.lblYear = New System.Windows.Forms.Label()
        Me.lstYear = New System.Windows.Forms.ListBox()
        Me.lstPresentValue = New System.Windows.Forms.ListBox()
        Me.lblPresentValue = New System.Windows.Forms.Label()
        Me.lstYearDepreciation = New System.Windows.Forms.ListBox()
        Me.lblYearDepreciation = New System.Windows.Forms.Label()
        Me.lstTotalDepreciation = New System.Windows.Forms.ListBox()
        Me.lblTotalDepreciation = New System.Windows.Forms.Label()
        Me.picTruck = New System.Windows.Forms.PictureBox()
        Me.MenuStrip1.SuspendLayout()
        Me.grpMethod.SuspendLayout()
        CType(Me.picTruck, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'MenuStrip1
        '
        Me.MenuStrip1.Items.AddRange(New System.Windows.Forms.ToolStripItem() {Me.mnuFile})
        Me.MenuStrip1.Location = New System.Drawing.Point(0, 0)
        Me.MenuStrip1.Name = "MenuStrip1"
        Me.MenuStrip1.Size = New System.Drawing.Size(684, 24)
        Me.MenuStrip1.TabIndex = 0
        Me.MenuStrip1.Text = "MenuStrip1"
        '
        'mnuFile
        '
        Me.mnuFile.DropDownItems.AddRange(New System.Windows.Forms.ToolStripItem() {Me.mnuDisplay, Me.mnuClear, Me.mnuExit})
        Me.mnuFile.Name = "mnuFile"
        Me.mnuFile.Size = New System.Drawing.Size(37, 20)
        Me.mnuFile.Text = "&File"
        '
        'mnuDisplay
        '
        Me.mnuDisplay.Name = "mnuDisplay"
        Me.mnuDisplay.Size = New System.Drawing.Size(165, 22)
        Me.mnuDisplay.Text = "&Display Inventory"
        '
        'mnuClear
        '
        Me.mnuClear.Name = "mnuClear"
        Me.mnuClear.Size = New System.Drawing.Size(165, 22)
        Me.mnuClear.Text = "&Clear"
        '
        'mnuExit
        '
        Me.mnuExit.Name = "mnuExit"
        Me.mnuExit.Size = New System.Drawing.Size(165, 22)
        Me.mnuExit.Text = "&Exit"
        '
        'lblFoodTruck
        '
        Me.lblFoodTruck.AutoSize = True
        Me.lblFoodTruck.Font = New System.Drawing.Font("Impact", 26.0!)
        Me.lblFoodTruck.ForeColor = System.Drawing.Color.Maroon
        Me.lblFoodTruck.Location = New System.Drawing.Point(217, 24)
        Me.lblFoodTruck.Name = "lblFoodTruck"
        Me.lblFoodTruck.Size = New System.Drawing.Size(444, 43)
        Me.lblFoodTruck.TabIndex = 2
        Me.lblFoodTruck.Text = "Chef Shack Burger Food Truck"
        '
        'lblSelectItem
        '
        Me.lblSelectItem.AutoSize = True
        Me.lblSelectItem.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lblSelectItem.ForeColor = System.Drawing.Color.Gray
        Me.lblSelectItem.Location = New System.Drawing.Point(222, 86)
        Me.lblSelectItem.Name = "lblSelectItem"
        Me.lblSelectItem.Size = New System.Drawing.Size(165, 17)
        Me.lblSelectItem.TabIndex = 3
        Me.lblSelectItem.Text = "Select Inventory Item:"
        '
        'lstInventoryId
        '
        Me.lstInventoryId.BackColor = System.Drawing.Color.WhiteSmoke
        Me.lstInventoryId.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lstInventoryId.ForeColor = System.Drawing.Color.Gray
        Me.lstInventoryId.FormattingEnabled = True
        Me.lstInventoryId.ItemHeight = 16
        Me.lstInventoryId.Location = New System.Drawing.Point(225, 106)
        Me.lstInventoryId.Name = "lstInventoryId"
        Me.lstInventoryId.Size = New System.Drawing.Size(162, 84)
        Me.lstInventoryId.TabIndex = 4
        '
        'grpMethod
        '
        Me.grpMethod.BackColor = System.Drawing.Color.WhiteSmoke
        Me.grpMethod.Controls.Add(Me.radDoubleDeclining)
        Me.grpMethod.Controls.Add(Me.radStraightLine)
        Me.grpMethod.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.grpMethod.ForeColor = System.Drawing.Color.Gray
        Me.grpMethod.Location = New System.Drawing.Point(428, 90)
        Me.grpMethod.Name = "grpMethod"
        Me.grpMethod.Size = New System.Drawing.Size(233, 100)
        Me.grpMethod.TabIndex = 5
        Me.grpMethod.TabStop = False
        Me.grpMethod.Text = "Select Depreciation Method"
        '
        'radDoubleDeclining
        '
        Me.radDoubleDeclining.AutoSize = True
        Me.radDoubleDeclining.Location = New System.Drawing.Point(6, 57)
        Me.radDoubleDeclining.Name = "radDoubleDeclining"
        Me.radDoubleDeclining.Size = New System.Drawing.Size(213, 21)
        Me.radDoubleDeclining.TabIndex = 1
        Me.radDoubleDeclining.TabStop = True
        Me.radDoubleDeclining.Text = "Double-Declining Balance"
        Me.radDoubleDeclining.UseVisualStyleBackColor = True
        '
        'radStraightLine
        '
        Me.radStraightLine.AutoSize = True
        Me.radStraightLine.Checked = True
        Me.radStraightLine.Location = New System.Drawing.Point(6, 23)
        Me.radStraightLine.Name = "radStraightLine"
        Me.radStraightLine.Size = New System.Drawing.Size(120, 21)
        Me.radStraightLine.TabIndex = 0
        Me.radStraightLine.TabStop = True
        Me.radStraightLine.Text = "Straight-Line"
        Me.radStraightLine.UseVisualStyleBackColor = True
        '
        'btnCalculateDepreciation
        '
        Me.btnCalculateDepreciation.BackColor = System.Drawing.Color.OrangeRed
        Me.btnCalculateDepreciation.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.btnCalculateDepreciation.ForeColor = System.Drawing.Color.White
        Me.btnCalculateDepreciation.Location = New System.Drawing.Point(341, 212)
        Me.btnCalculateDepreciation.Name = "btnCalculateDepreciation"
        Me.btnCalculateDepreciation.Size = New System.Drawing.Size(192, 36)
        Me.btnCalculateDepreciation.TabIndex = 6
        Me.btnCalculateDepreciation.Text = "Calculate Depreciation"
        Me.btnCalculateDepreciation.UseVisualStyleBackColor = False
        '
        'lblItem
        '
        Me.lblItem.AutoSize = True
        Me.lblItem.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lblItem.ForeColor = System.Drawing.Color.Gray
        Me.lblItem.Location = New System.Drawing.Point(283, 257)
        Me.lblItem.Name = "lblItem"
        Me.lblItem.Size = New System.Drawing.Size(308, 17)
        Me.lblItem.TabIndex = 7
        Me.lblItem.Text = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
        Me.lblItem.Visible = False
        '
        'lblQuantity
        '
        Me.lblQuantity.AutoSize = True
        Me.lblQuantity.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lblQuantity.ForeColor = System.Drawing.Color.Gray
        Me.lblQuantity.Location = New System.Drawing.Point(388, 274)
        Me.lblQuantity.Name = "lblQuantity"
        Me.lblQuantity.Size = New System.Drawing.Size(98, 17)
        Me.lblQuantity.TabIndex = 8
        Me.lblQuantity.Text = "XXXXXXXXX"
        Me.lblQuantity.Visible = False
        '
        'lblYear
        '
        Me.lblYear.AutoSize = True
        Me.lblYear.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lblYear.ForeColor = System.Drawing.Color.Gray
        Me.lblYear.Location = New System.Drawing.Point(50, 293)
        Me.lblYear.Name = "lblYear"
        Me.lblYear.Size = New System.Drawing.Size(69, 34)
        Me.lblYear.TabIndex = 9
        Me.lblYear.Text = "Present " & Global.Microsoft.VisualBasic.ChrW(13) & Global.Microsoft.VisualBasic.ChrW(10) & "Year"
        Me.lblYear.Visible = False
        '
        'lstYear
        '
        Me.lstYear.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lstYear.ForeColor = System.Drawing.Color.Gray
        Me.lstYear.FormattingEnabled = True
        Me.lstYear.ItemHeight = 16
        Me.lstYear.Location = New System.Drawing.Point(53, 335)
        Me.lstYear.Name = "lstYear"
        Me.lstYear.Size = New System.Drawing.Size(101, 84)
        Me.lstYear.TabIndex = 10
        Me.lstYear.Visible = False
        '
        'lstPresentValue
        '
        Me.lstPresentValue.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lstPresentValue.ForeColor = System.Drawing.Color.Gray
        Me.lstPresentValue.FormattingEnabled = True
        Me.lstPresentValue.ItemHeight = 16
        Me.lstPresentValue.Location = New System.Drawing.Point(212, 335)
        Me.lstPresentValue.Name = "lstPresentValue"
        Me.lstPresentValue.Size = New System.Drawing.Size(101, 84)
        Me.lstPresentValue.TabIndex = 12
        Me.lstPresentValue.Visible = False
        '
        'lblPresentValue
        '
        Me.lblPresentValue.AutoSize = True
        Me.lblPresentValue.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lblPresentValue.ForeColor = System.Drawing.Color.Gray
        Me.lblPresentValue.Location = New System.Drawing.Point(209, 293)
        Me.lblPresentValue.Name = "lblPresentValue"
        Me.lblPresentValue.Size = New System.Drawing.Size(69, 34)
        Me.lblPresentValue.TabIndex = 11
        Me.lblPresentValue.Text = "Present " & Global.Microsoft.VisualBasic.ChrW(13) & Global.Microsoft.VisualBasic.ChrW(10) & "Value" & Global.Microsoft.VisualBasic.ChrW(13) & Global.Microsoft.VisualBasic.ChrW(10)
        Me.lblPresentValue.Visible = False
        '
        'lstYearDepreciation
        '
        Me.lstYearDepreciation.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lstYearDepreciation.ForeColor = System.Drawing.Color.Gray
        Me.lstYearDepreciation.FormattingEnabled = True
        Me.lstYearDepreciation.ItemHeight = 16
        Me.lstYearDepreciation.Location = New System.Drawing.Point(371, 335)
        Me.lstYearDepreciation.Name = "lstYearDepreciation"
        Me.lstYearDepreciation.Size = New System.Drawing.Size(101, 84)
        Me.lstYearDepreciation.TabIndex = 14
        Me.lstYearDepreciation.Visible = False
        '
        'lblYearDepreciation
        '
        Me.lblYearDepreciation.AutoSize = True
        Me.lblYearDepreciation.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lblYearDepreciation.ForeColor = System.Drawing.Color.Gray
        Me.lblYearDepreciation.Location = New System.Drawing.Point(368, 293)
        Me.lblYearDepreciation.Name = "lblYearDepreciation"
        Me.lblYearDepreciation.Size = New System.Drawing.Size(100, 34)
        Me.lblYearDepreciation.TabIndex = 13
        Me.lblYearDepreciation.Text = "Year" & Global.Microsoft.VisualBasic.ChrW(13) & Global.Microsoft.VisualBasic.ChrW(10) & "Depreciation" & Global.Microsoft.VisualBasic.ChrW(13) & Global.Microsoft.VisualBasic.ChrW(10)
        Me.lblYearDepreciation.Visible = False
        '
        'lstTotalDepreciation
        '
        Me.lstTotalDepreciation.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lstTotalDepreciation.ForeColor = System.Drawing.Color.Gray
        Me.lstTotalDepreciation.FormattingEnabled = True
        Me.lstTotalDepreciation.ItemHeight = 16
        Me.lstTotalDepreciation.Location = New System.Drawing.Point(530, 335)
        Me.lstTotalDepreciation.Name = "lstTotalDepreciation"
        Me.lstTotalDepreciation.Size = New System.Drawing.Size(101, 84)
        Me.lstTotalDepreciation.TabIndex = 16
        Me.lstTotalDepreciation.Visible = False
        '
        'lblTotalDepreciation
        '
        Me.lblTotalDepreciation.AutoSize = True
        Me.lblTotalDepreciation.Font = New System.Drawing.Font("Microsoft Sans Serif", 10.0!, System.Drawing.FontStyle.Bold)
        Me.lblTotalDepreciation.ForeColor = System.Drawing.Color.Gray
        Me.lblTotalDepreciation.Location = New System.Drawing.Point(527, 293)
        Me.lblTotalDepreciation.Name = "lblTotalDepreciation"
        Me.lblTotalDepreciation.Size = New System.Drawing.Size(100, 34)
        Me.lblTotalDepreciation.TabIndex = 15
        Me.lblTotalDepreciation.Text = "Total" & Global.Microsoft.VisualBasic.ChrW(13) & Global.Microsoft.VisualBasic.ChrW(10) & "Depreciation"
        Me.lblTotalDepreciation.Visible = False
        '
        'picTruck
        '
        Me.picTruck.Image = Global.Deprecation.My.Resources.Resources.food_truck
        Me.picTruck.Location = New System.Drawing.Point(0, 25)
        Me.picTruck.Name = "picTruck"
        Me.picTruck.Size = New System.Drawing.Size(193, 223)
        Me.picTruck.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.picTruck.TabIndex = 1
        Me.picTruck.TabStop = False
        '
        'frmDepreciation
        '
        Me.AcceptButton = Me.btnCalculateDepreciation
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.White
        Me.ClientSize = New System.Drawing.Size(684, 431)
        Me.Controls.Add(Me.lstTotalDepreciation)
        Me.Controls.Add(Me.lblTotalDepreciation)
        Me.Controls.Add(Me.lstYearDepreciation)
        Me.Controls.Add(Me.lblYearDepreciation)
        Me.Controls.Add(Me.lstPresentValue)
        Me.Controls.Add(Me.lblPresentValue)
        Me.Controls.Add(Me.lstYear)
        Me.Controls.Add(Me.lblYear)
        Me.Controls.Add(Me.lblQuantity)
        Me.Controls.Add(Me.lblItem)
        Me.Controls.Add(Me.btnCalculateDepreciation)
        Me.Controls.Add(Me.grpMethod)
        Me.Controls.Add(Me.lstInventoryId)
        Me.Controls.Add(Me.lblSelectItem)
        Me.Controls.Add(Me.lblFoodTruck)
        Me.Controls.Add(Me.picTruck)
        Me.Controls.Add(Me.MenuStrip1)
        Me.MainMenuStrip = Me.MenuStrip1
        Me.Name = "frmDepreciation"
        Me.Text = "Compute Depreciation By Method"
        Me.MenuStrip1.ResumeLayout(False)
        Me.MenuStrip1.PerformLayout()
        Me.grpMethod.ResumeLayout(False)
        Me.grpMethod.PerformLayout()
        CType(Me.picTruck, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents MenuStrip1 As MenuStrip
    Friend WithEvents mnuFile As ToolStripMenuItem
    Friend WithEvents mnuDisplay As ToolStripMenuItem
    Friend WithEvents mnuClear As ToolStripMenuItem
    Friend WithEvents mnuExit As ToolStripMenuItem
    Friend WithEvents picTruck As PictureBox
    Friend WithEvents lblFoodTruck As Label
    Friend WithEvents lblSelectItem As Label
    Friend WithEvents lstInventoryId As ListBox
    Friend WithEvents grpMethod As GroupBox
    Friend WithEvents radDoubleDeclining As RadioButton
    Friend WithEvents radStraightLine As RadioButton
    Friend WithEvents btnCalculateDepreciation As Button
    Friend WithEvents lblItem As Label
    Friend WithEvents lblQuantity As Label
    Friend WithEvents lblYear As Label
    Friend WithEvents lstYear As ListBox
    Friend WithEvents lstPresentValue As ListBox
    Friend WithEvents lblPresentValue As Label
    Friend WithEvents lstYearDepreciation As ListBox
    Friend WithEvents lblYearDepreciation As Label
    Friend WithEvents lstTotalDepreciation As ListBox
    Friend WithEvents lblTotalDepreciation As Label
End Class
