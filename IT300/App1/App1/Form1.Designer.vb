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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1))
        Me.lblLatte = New System.Windows.Forms.Label()
        Me.btnPumpkinSpice = New System.Windows.Forms.Button()
        Me.btnSelect = New System.Windows.Forms.Button()
        Me.btnMocha = New System.Windows.Forms.Button()
        Me.btnExit = New System.Windows.Forms.Button()
        Me.lblSelect = New System.Windows.Forms.Label()
        Me.lblEnjoy = New System.Windows.Forms.Label()
        Me.imgPumpkin = New System.Windows.Forms.PictureBox()
        Me.imgMocha = New System.Windows.Forms.PictureBox()
        CType(Me.imgPumpkin, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.imgMocha, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'lblLatte
        '
        Me.lblLatte.AutoSize = True
        Me.lblLatte.Font = New System.Drawing.Font("Microsoft Sans Serif", 15.0!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblLatte.Location = New System.Drawing.Point(235, 54)
        Me.lblLatte.Name = "lblLatte"
        Me.lblLatte.Size = New System.Drawing.Size(156, 25)
        Me.lblLatte.TabIndex = 0
        Me.lblLatte.Text = "Latte Selection"
        '
        'btnPumpkinSpice
        '
        Me.btnPumpkinSpice.Location = New System.Drawing.Point(103, 333)
        Me.btnPumpkinSpice.Name = "btnPumpkinSpice"
        Me.btnPumpkinSpice.Size = New System.Drawing.Size(75, 23)
        Me.btnPumpkinSpice.TabIndex = 1
        Me.btnPumpkinSpice.Text = "Pumpkin Spice"
        Me.btnPumpkinSpice.UseVisualStyleBackColor = True
        '
        'btnSelect
        '
        Me.btnSelect.Enabled = False
        Me.btnSelect.Location = New System.Drawing.Point(274, 333)
        Me.btnSelect.Name = "btnSelect"
        Me.btnSelect.Size = New System.Drawing.Size(75, 23)
        Me.btnSelect.TabIndex = 2
        Me.btnSelect.Text = "Select Latte"
        Me.btnSelect.UseVisualStyleBackColor = True
        '
        'btnMocha
        '
        Me.btnMocha.Location = New System.Drawing.Point(447, 333)
        Me.btnMocha.Name = "btnMocha"
        Me.btnMocha.Size = New System.Drawing.Size(75, 23)
        Me.btnMocha.TabIndex = 3
        Me.btnMocha.Text = "Mocha"
        Me.btnMocha.UseVisualStyleBackColor = True
        '
        'btnExit
        '
        Me.btnExit.Enabled = False
        Me.btnExit.Location = New System.Drawing.Point(274, 470)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(75, 23)
        Me.btnExit.TabIndex = 4
        Me.btnExit.Text = "Exit Program"
        Me.btnExit.UseVisualStyleBackColor = True
        '
        'lblSelect
        '
        Me.lblSelect.AutoSize = True
        Me.lblSelect.Location = New System.Drawing.Point(240, 391)
        Me.lblSelect.Name = "lblSelect"
        Me.lblSelect.Size = New System.Drawing.Size(147, 13)
        Me.lblSelect.TabIndex = 5
        Me.lblSelect.Text = "Select a latte with the buttons"
        '
        'lblEnjoy
        '
        Me.lblEnjoy.AutoSize = True
        Me.lblEnjoy.Location = New System.Drawing.Point(263, 427)
        Me.lblEnjoy.Name = "lblEnjoy"
        Me.lblEnjoy.Size = New System.Drawing.Size(101, 13)
        Me.lblEnjoy.TabIndex = 6
        Me.lblEnjoy.Text = "Enjoy your selection"
        Me.lblEnjoy.Visible = False
        '
        'imgPumpkin
        '
        Me.imgPumpkin.Image = CType(resources.GetObject("imgPumpkin.Image"), System.Drawing.Image)
        Me.imgPumpkin.InitialImage = CType(resources.GetObject("imgPumpkin.InitialImage"), System.Drawing.Image)
        Me.imgPumpkin.Location = New System.Drawing.Point(52, 131)
        Me.imgPumpkin.Name = "imgPumpkin"
        Me.imgPumpkin.Size = New System.Drawing.Size(172, 181)
        Me.imgPumpkin.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.imgPumpkin.TabIndex = 7
        Me.imgPumpkin.TabStop = False
        Me.imgPumpkin.Visible = False
        '
        'imgMocha
        '
        Me.imgMocha.Image = CType(resources.GetObject("imgMocha.Image"), System.Drawing.Image)
        Me.imgMocha.Location = New System.Drawing.Point(402, 131)
        Me.imgMocha.Name = "imgMocha"
        Me.imgMocha.Size = New System.Drawing.Size(172, 181)
        Me.imgMocha.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage
        Me.imgMocha.TabIndex = 8
        Me.imgMocha.TabStop = False
        Me.imgMocha.Visible = False
        '
        'Form1
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.FromArgb(CType(CType(255, Byte), Integer), CType(CType(214, Byte), Integer), CType(CType(245, Byte), Integer))
        Me.ClientSize = New System.Drawing.Size(627, 547)
        Me.Controls.Add(Me.imgMocha)
        Me.Controls.Add(Me.imgPumpkin)
        Me.Controls.Add(Me.lblEnjoy)
        Me.Controls.Add(Me.lblSelect)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.btnMocha)
        Me.Controls.Add(Me.btnSelect)
        Me.Controls.Add(Me.btnPumpkinSpice)
        Me.Controls.Add(Me.lblLatte)
        Me.ForeColor = System.Drawing.SystemColors.ControlText
        Me.Name = "Form1"
        Me.SizeGripStyle = System.Windows.Forms.SizeGripStyle.Show
        Me.StartPosition = System.Windows.Forms.FormStartPosition.Manual
        Me.Text = "Latte Selection"
        CType(Me.imgPumpkin, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.imgMocha, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents lblLatte As Label
    Friend WithEvents btnPumpkinSpice As Button
    Friend WithEvents btnSelect As Button
    Friend WithEvents btnMocha As Button
    Friend WithEvents btnExit As Button
    Friend WithEvents lblSelect As Label
    Friend WithEvents lblEnjoy As Label
    Friend WithEvents imgPumpkin As PictureBox
    Friend WithEvents imgMocha As PictureBox
End Class
